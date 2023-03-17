#encoding: UTF-8

module Deepspace
	class Dice
		def initialize
			# Atributos de instancia
			@NHANGARSPROB = 0.25
			@NSHIELDSPROB = 0.25
			@NWEAPONSPROB = 0.33
			@FIRSTSHOTPROB = 0.5
			@generator = Random.new
			
		end
		
		attr_reader :generator
		
		def initWithNHangars
			retorno = 1
			
			if (@generator.rand() < @NHANGARSPROB)
				retorno = 0
			end
			
			return (retorno)
			
		end
		
		def initWithNWeapons
			retorno = 3
			
			num = @generator.rand()
			
			if (num < @NWEAPONSPROB)
				retorno = 1
			elsif (num < 2*@NWEAPONSPROB)
				retorno = 2
			end
			
			return (retorno)
		end
		
		def initWithNShields
			retorno = 1
			
			if (@generator.rand() < @NSHIELDSPROB)
				retorno = 0
			end
			
			return (retorno)
		end
		
		def whoStarts (nPlayers)
			return (@generator.rand(nPlayers))
		end
		
		def firstShot
			if (@generator.rand() < @FIRSTSHOTPROB)
				retorno = GameCharacter::SPACESTATION
			else
				retorno = GameCharacter::ENEMYSTARSHIP
			end
			
			return (retorno)
		end
		
		def spaceStationMoves (speed)
			if (@generator.rand() < speed)
				retorno = true
			else
				retorno = false
			end
			
			return (retorno)
		end
	end
end
