#encoding: UTF-8

require_relative 'CombatResult'
require_relative 'EnemyStarShip'
require_relative 'SpaceStation'
require_relative 'GameStateController'
require_relative 'Dice'
require_relative 'GameUniverseToUI'
require_relative 'CardDealer'

module Deepspace
	class GameUniverse
		# Atributos de clase
		@@WIN = 10
		
		def initialize()
			@currentStation = nil
			
			@gameState = GameStateController.new
			
			@turns = 0
			
			@dice = Dice.new
			
			@spaceStations = Array.new
			
			@currentStationIndex = -1
			
			@currentEnemy = nil 	#EnemyStarShip.new creo q falla pq el constructor recibe cosas
			
			@haveSpaceCity = false
		end
		
		def haveAWinner()
			
			return @currentStation.getNMedals >= @@WIN   # devuelve un bool
		end
		
		
		# llaman a los mount y discard de la estacion espacial
		
		def discardHangar()
			
			if @gameState == GameState::INIT || @gameState == GameState::AFTERCOMBAT  ##no estoy muy seguro de que esa sea la sintaxis  
																					  ##en todos los discard
				@currentStation.discardHangar()
			end
		end
		
		def discardShieldBooster(i)
		
			if @gameState == GameState::INIT || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardShieldBooster(i)
			end
		end
		
		def discardShieldBoosterInHangar(i)
		
			if @gameState == GameState::INIT || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardShieldBoosterInHangar(i)
			end
		end
		
		def discardWeapon(i)
		
			if state() == GameState::INIT || state() == GameState::AFTERCOMBAT  
			
				@currentStation.discardWeapon(i)
			end
		end
		
		def discardWeaponInHangar(i)
			if state() == GameState::INIT || state() == GameState::AFTERCOMBAT  
			
				@currentStation.discardWeaponInHangar(i)
			end
		end
		
		def state()
		
			return @gameState.state       ## se hace así cuando está el attreader en lugar del get() ??
		end
		
		def getUIversion()
		
			return GameUniverseToUI.new(@currentStation, @currentStation)
			
		end
		
		def mountShieldBooster(i)
			
			if state() == GameState::INIT || state() == GameState::AFTERCOMBAT  
			
				@currentStation.mountShieldBooster(i)
			end
			
		end
		
		def mountWeapon(i)

			if state() == GameState::INIT || state() == GameState::AFTERCOMBAT 
				@currentStation.mountWeapon(i)
			end
			
		end 	
		
		def init (names)    # names es arraylist de string
			
			_state = state() 
			
			if(_state==GameState::CANNOTPLAY)
				dealer=CardDealer.instance()
				names.each do |n|
					supplies=dealer.nextSuppliesPackage
					station=SpaceStation.new(n,supplies)
					@spaceStations << station
					nh=@dice.initWithNHangars
					nw=@dice.initWithNWeapons
					ns=@dice.initWithNShields
					lo=Loot.new(0,nw,ns,nh,0, False, False)
					station.setLoot(lo)
				end
				
				@currentStationIndex = @dice.whoStarts(names.length)
				@currentStation=@spaceStations[@currentStationIndex]
				@currentEnemy=dealer.nextEnemy
				@gameState.next(@turns,@spaceStations.length)
			end
				
		end 			# void()
		
		def nextTurn
			ret = false
			_state = state()
			
			if(_state == GameState::AFTERCOMBAT)
				stationState = @currentStation.validState
				
				if (stationState)
					@currentStationIndex = (@currentStationIndex+1) % @spaceStations.length()
					@turns+=1
					@currentStation = @spaceStations[@currentStationIndex]
					@currentStation.cleanUpMountedItems()
					dealer = CardDealer.instance
					@currentEnemy = dealer.nextEnemy()
					@gameState.next(@turns, @spaceStations.length())
					ret = true
				end
			end
			return ret  # bool comprueba que el jugador no tiene un daño pendiente en cuyo caso pasa al siguiente jugador
		end
		
		def combat
			resultado = CombatResult::NOCOMBAT
			_state = state()

			if ((_state == GameState::BEFORECOMBAT) || (_state == GameState::INIT))
				resultado = combatGo(@currentStation, @currentEnemy)
			end
		end		# devuelve combatResult
		
		def combatGo (station, enemy)  # station es un SpaceStation y enemy un EnemyStartship
			ch = @dice.firstShot() 

			if (ch == GameCharacter::ENEMYSTARSHIP) # Ataca enemigo primero
				fire = enemy.fire()

				result = station.receiveShot(fire)

				if (result == ShotResult::RESIST)
					fire = station.fire()
					result = enemy.receiveShot(fire)

					enemyWins = (result == ShotResult::RESIST)
				else
					enemyWins = true
				end
			else	# Ataca jugador primero
				fire = station.fire()

				result = enemy.receiveShot(fire)

				enemyWins = (result == ShotResult::RESIST)
			end

			if (enemyWins)
				s = station.getSpeed()

				moves = @dice.spaceStationMoves(s)

				if (!moves)
					damage = enemy.damage
					station.setPendingDamage (damage)

					resultado = CombatResult::ENEMYWINS
				else
					station.move()
					resultado = CombatResult::STATIONESCAPES
				end
			else	#estación espacial vence al enemigo
				aLoot = enemy.loot
				t = station.setLoot(aLoot)	#t es de tipo Transformation
				
				case t
					when Transformation::GETEFFICIENT
						resultado = CombatResult::STATIONWINSANDCONVERTS
						makeStationEfficient
					when Transformation::SPACECITY
						resultado = CombatResult::STATIONWINSANDCONVERTS
						createSpaceCity
					else
						resultado = CombatResult::STATIONWINS
				end
			end

			@gameState.next(@turns, @spaceStations.size())

			return (resultado)		# devuelve un combatResult
		end		
	
	
		private
		
		def makeStationEfficient
			if (@dice.extraEfficiency)
				@currentStation = BetaPowerEfficientSpaceStation.new(@currentStation)
			else
				@currentStation = PowerEfficientSpaceStation.new(@currentStation)
			end
		end		#void
		
		def createSpaceCity		#no estoy segura
			if (@haveSpaceCity == false)
				@currentStation = SpaceCity.new(@currentStation, @spaceStations)
				@haveSpaceCity = true
			end
		end		#void
		
	end   #class		

end		#module
