#encoding: UTF-8

module DeepSpace
	class Dice
		def initialize
			@NHANGARSPROB = 0.25
			@NSHIELDSPROB = 0.25
			@NWEAPONSPROB = 0.33
			@FIRSTSHOTPROB = 0.5
			
			@generator = rand(0)
		end
		
		attr_reader :generator
	end
	
	print "Prueba\n"
	obj = Dice.new
	num = obj.generator
	
	print generator

end
