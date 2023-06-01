#encoding:utf-8

require_relative 'SpaceStation'

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

sp = SuppliesPackage.new(1,2,3)
station = SpaceStation.new("PRUEBA", sp)
station.receiveHangar(Hangar.new(5))
station.receiveWeapon(Weapon.new("LASER", WeaponType::LASER, 3))

puts station.getUIversion

ef_station = PowerEfficientSpaceStation.new(station)

puts ef_station.to_s

end # module

