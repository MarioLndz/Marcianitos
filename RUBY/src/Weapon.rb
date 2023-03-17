#encoding: UTF-8

require_relative 'WeaponType'

module Deepspace

	class Weapon

		def initialize(n,t,u)
			@name = n
			@type = t
			@uses = u
		end

		attr_reader :name
		attr_reader :uses
		
		def type
			if @type == WeaponType::MISSILE
				return "missile"
			else
				if @type == WeaponType::LASSER
					return "lasser"
				else
					if @type == WeaponType::PLASMA
						return "plasma"
					end
				end
			end
		end


		def self.newCopy(other)
			new(other.name, other.type, other.uses)
		end


		def power
			@type.power
		end

		def useIt
			if uses > 0
				@uses -= 1
				power()
			else
				1.0
			end
		end
		
		def to_s
		  return "Name: " + @name + ", Type: #{@type}, Power: #{@power}, Uses: #{@uses}"
		end
	end
	
end
