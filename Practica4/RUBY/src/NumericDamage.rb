
require_relative 'Damage'
require_relative 'NumericDamageToUI'

module Deepspace

class NumericDamage < Damage	#terminada
  	  
  	public_class_method :new

	attr_reader :nWeapons
	  
	def initialize (w,s)  #w = num weapons, s=num shields
		super(s)
		@nWeapons=w
	end
		
	#devuelve copia del objeto actual
	def copy
		return NumericDamage.new(@nWeapons,@nshields)	#ns si está bien
	end
	  
	def getUIversion
		return NumericDamageToUI.new(self)
	end
	  
	def adjust(w,s)   # w es un array list de Weapon, s es un Array list de shield
		l_nshields = [s.length, nShields].min
		l_nweapons = [w.length, nWeapons].min
					
		return NumericDamage.new(l_nweapons,l_nshields)
	end
  
	def discardWeapon(w)    # w es Weapon
		
		if @nWeapons > 0
			@nWeapons -= 1
		end                   
	end		 # es void

	def hasNoEffect
		return (@nShields + @nWeapons == 0)        # true si no se pierden accesorios
	end
		
	def to_s
		out = super
		out += ", nWeapons: #{@nWeapons}\n"
		out += "------- end of Damage -------"
		return out
	end
	
end # class

end # module

