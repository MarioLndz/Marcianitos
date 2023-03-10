#encoding: UTF-8

module DeepSpace
	module WeaponType
		class Type
			def initialize (p)
				@power = p
			end
			
			attr_reader	:power
			
		end
		
		LASER = Type.new(2.0)
		MISSILE = Type.new(3.0)
		PLASMA = Type.new(4.0)
		
	end

end