#encoding: UTF-8

require_relative 'CombatResult'
require_relative 'EnemyStarShip'
require_relative 'SpaceStation'
require_relative 'GameStateController'
require_relative 'Dice'

module DeepSpace
	class GameUniverse
		# Atributos de clase
		@@WIN = 10
		
		def initialize
			@currentStation = nil
			
			@gameState = GameStateController.new
			
			@turns = 0
			
			@dice = Dice.new
			
			@spaceStations = Array.new
			
			@currentStationIndex = -1
			
			@currentEnemy = nil 	#EnemyStarShip.new creo q falla pq el constructor recibe cosas
		end
		
		def haveAWinner()
			
			return @currentStation.getNMedals >= @@WIN
		end
		
		def discardHangar()
			
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  ##no estoy muy seguro de que esa sea la sintaxis  
																					  ##en todos los discard
				@currentStation.discardHangar()
			end
		end
		
		def discardShieldBooster(i)
		
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardShieldBooster(i)
			end
		end
		
		def discardShieldBoosterInHangar(i)
		
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardShieldBoosterInHangar(i)
			end
		end
		
		def discardShieldBoosterInHangar(i)
		
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardShieldBoosterInHangar(i)
			end
		end
		
		def discardWeapon(i)
		
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardWeapon(i)
			end
		end
		
		def discardWeaponInHangar(i)
		
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.discardWeaponInHangar(i)
			end
		end
		
		def state()
		
			return @gameState.state       ## se hace así cuando está el attreader en lugar del get() ??
		end
		
		def getUIversion()
		
			return GameUniverseToUI.new(self)
			
		end
		
		def mountShieldBooster(i)
			
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.mountShieldBooster(i)
			end
			
		end
		
		def mountWeapon(i)
			
			if @gameState == GameState::Init || @gameState == GameState::AFTERCOMBAT  
			
				@currentStation.mountWeapon(i)
			end
			
		end 	
		
		def init (names)    ## revisar este método
			
			state=@gameState 
			
			if(state==GameState::CANNOTPLAY)
				dealer=CardDealer.instance()
				names.each do |n|
					supplies=dealer.nextSuppliesPackage
					station=SpaceStation.new(n,supplies)
					@spaceStations << station
					nh=@dice.initWithNHangars
					nw=@dice.initWithNWeapons
					ns=@dice.initWithNShields
					lo=Loot.new(0,nw,ns,nh,0)
					station.setLoot(lo)
				end
				
				@currentStationIndex = @dice.whoStarts(names.length)
				@currentStation=@spaceStations[@currentStationIndex]
				@currentEnemy=dealer.nextEnemy
				@gameState.next(@turns,@spaceStations.length)
			end
				
		end
		
		def nextTurn
			ret = false
			state = @gameState
			
			if(state == GameState::AFTERCOMBAT)
				stationState = @currentStation.validState
				
				if (stationState)
					@currentStationIndex = (@currentStationIndex+1) % @spaceStations.length()
					@turns+=1
					@currentStation = @spaceStations[@currentStationIndex]
					@currentStation.cleanUpMountedItems()
					dealer = CardDealer.getInstance()
					@currentEnemy = dealer.nextEnemy()
					@gameState.next(@turns, @spaceStations.length())
					ret = true
				end
			end
			return ret
		end
		
		def combat
			resultado = CombatResult::NOCOMBAT
			state = @gameState.state

			if ((state == GameState::BEFORECOMBAT) || (state == GameState::INIT))
				resultado = combatGo(@currentStation, @currentEnemy)
			end
		end
		
		def combatGo (station, enemy)
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

				moves = dice.spaceStationMoves(s)

				if (!moves)
					damage = enemy.getDamage()
					station.setPendingDamage (damage)

					resultado = CombatResult::ENEMYWINS
				else
					station.move()
					resultado = CombatResult::STATIONESCAPES
				end
			else
				aLoot = enemy.getLoot()
				station.setLoot(aLoot)

				resultado = CombatResult::STATIONWINS
			end

			gameState.next(@turns, @spaceStations.size())

			return (resultado)
		end		
	end

end
