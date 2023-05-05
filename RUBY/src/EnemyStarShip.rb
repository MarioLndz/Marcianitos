#encoding: UTF-8

require_relative 'ShotResult'

module Deepspace
	class EnemyStarShip
		# Constructor
		def initialize (n, ap, sp, l, d)  # n string, ap float, sp float, l loot, d Damage
			@name = n
			@ammoPower = ap
			@shieldPower = sp
			@loot = l
			@damage = d
			
		end
		
		# Constructor de copia
		def self.newCopy(other)
			new(other.name, other.ammoPower, other.shieldPower, other.loot, other.damage)
		end
		
		# Consultores publicos
		attr_reader :ammoPower
		attr_reader :loot
		attr_reader :name
		attr_reader :shieldPower
		attr_reader :damage
		
		def protection ()
			return @shieldPower   # devuelve float
		end
		
		def fire ()
			return @ammoPower   # devuelve float
		end
		
		def receiveShot (shot)   # shot es un float
			resultado = ShotResult::RESIST
			
			if (protection() < shot)
				resultado = ShotResult::DONOTRESIST
			end
			
			return (resultado)   # devuelve un ShotResult
		end
		
	end
end
