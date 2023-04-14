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
			
			@spaceStations = []
			
			@currentStationIndex = -1
			
			@currentEnemy = EnemyStarShip.new
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
		
		def init (names)
		end
		
		def nextTurn
			ret = false
			state = @gameState
			
			if(state == GameState::AFTERCOMBAT)
				stationState = @currentStation.validState9
				
				if (stationState)
					@currentStationIndex = (@currentStationIndex+1) % @spaceStations.length()
					@turns+=1
					@currentStation = @spaceStations[currentStationIndex]
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
		end
		
		def combatGo (station, enemy)
		end
	end

end
