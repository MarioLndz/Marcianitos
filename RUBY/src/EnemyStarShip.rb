#encoding: UTF-8

require_relative 'ShotResult'

module DeepSpace
	class EnemyStarShip
		# Constructor
		def initialize (n, ap, sp, l, d)
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
		attr_reader :loot
		attr_reader :damage
		
		def protection ()
			return @shieldPower
		end
		
		def fire ()
			return @ammoPower
		end
		
		def receiveShot (shot)
			resultado = ShotResult::RESIST
			
			if (this.protection() < shot)
				resultado = ShotResult::DONOTRESIST
			end
			
			return (resultado)
		end
		
	end
end
