#encoding: UTF-8

require_relative 'WeaponType'
require_relative 'WeaponToUI'

module Deepspace

	class Weapon

		def initialize(n,t,u)
			@name = n
			@type = t
			@uses = u
		end
		
		def self.newCopy(other)
			new(other.name, other.type, other.uses)
		end
		
		def getUIversion
			WeaponToUI.new(self)
		end

		attr_reader :name
		attr_reader :uses
		
		def type
			@type
		end

		def power
			@type.power()
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
		  return "Name: " + @name + ", Type: #{@type}, Power: #{@type.power}, Uses: #{@uses}"
		end
		
	end	
end
