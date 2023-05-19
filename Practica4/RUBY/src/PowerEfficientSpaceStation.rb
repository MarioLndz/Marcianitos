#encoding:utf-8

require_relative 'SpaceStation'

module Deepspace
  
class PowerEfficientSpaceStation < SpaceStation		#terminada
	
	@@EFFIENCYFACTOR = 1.10
	
	def initialize (station) 
		super(station)
	end
  
	#override
	def fire
		return super*@@EFFIENCYFACTOR
	end
	
	#override
	def protection
		return super*@@EFFIENCYFACTOR
	end
	
	#Override
	def setLoot(loot)
		super
		return Transformation::NOTRANSFORM	#no se pueden transformar
	end	#devuelve elemento de tipo Transformation
  
	#Override
	def to_s
		out = super
		out += " (ESTACIÓN EFICIENTE)"
		return out
	end

end # class

end # module

