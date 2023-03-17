#encoding: UTF-8

module Deepspace

	class SuppliesPackage		# ponerle visibilidad de paquete
	
		#constructor
		def initialize(a,f,s)
			# atributos de instancia privados
			@ammoPower=a
			@fuelUnits=f
			@shieldPower=s
		end
		
		# constructor de copia
		def self.newCopy(other)
			new(other.ammoPower, other.fuelUnits, other.shieldPower)		
		end		
		
		# consultor publico para cada atributo
		attr_reader:ammoPower
		attr_reader:fuelUnits
		attr_reader:shieldPower
		
	end
end
