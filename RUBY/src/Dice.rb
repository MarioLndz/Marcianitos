#encoding: UTF-8

module DeepSpace
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
	end
	
	dice=Dice.new
	
	print dice.initWithNHangars
end
