#encoding:utf-8

require_relative 'SpaceStation'
require_relative 'PowerEfficientSpaceStationToUI'

module Deepspace
  
class PowerEfficientSpaceStation < SpaceStation		#terminada
	
	@@EFFIENCYFACTOR = 1.10
	
	def initialize (station) 
		super(station.name, SuppliesPackage.new(station.ammoPower, station.fuelUnits, station.shieldPower))
		copy(station)

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
		transformacion = super(loot)

		if (transformacion == Transformation::SPACECITY)
			transformacion = Transformation::NOTRANSFORM
		end

		return (transformacion)	#no se pueden transformar
	end	#devuelve elemento de tipo Transformation
  
	#Override
	def to_s
		out = super
		out += " (ESTACIÓN EFICIENTE)"
		return out
	end

	#Override
	def getUIversion
		PowerEfficientSpaceStationToUI.new(self)
	end

end # class
end # module

