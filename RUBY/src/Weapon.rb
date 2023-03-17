#encoding: UTF-8

module Deepspace

	class Weapon

		def initialize(n,t,u)
			@name = n
			@type = t
			@uses = u
		end

	
		attr_reader :name
		
		attr_reader :type

		attr_reader :uses


		def self.newCopy(other)

			new(other.name, other.type, other.uses)

		end


		def power

			type.power

		end

		def useIt
			
			if uses > 0

				@uses -= 1
				power()
			
			else

				1.0

			end
		
		end
	end
end
