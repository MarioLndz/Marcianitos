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
			@currentStation = SpaceStation.new
			
			@gameState = GameStateController.new
			
			@turns = 0
			
			@dice = Dice.new
		end
		
		
		# Para la proxima practica
		def init (names)
		end
		
		def nextTurn
		end
		
		def combat
		end
		
		def combatGo (station, enemy)
		end
	end

end
