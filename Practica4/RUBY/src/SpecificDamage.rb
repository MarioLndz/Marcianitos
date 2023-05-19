
require_relative 'Damage'
require_relative 'SpecificDamageToUI'

module Deepspace

class SpecificDamage < Damage	#terminada

	public_class_method :new

	attr_reader :weapons
  
	def initialize (wl,s)   #wl es array de weapontype, s int es numero de escudos
		super(s)
		@weapons=wl
	end
      
    def copy
		return SpecificDamage.new(@weapons,@nShields)
    end
    
    def getUIversion
		return SpecificDamageToUI.new(self)
    end
  
	def adjust(w,s)   # w es un array list de Weapon, s es un Array list de shield
		d = nil
		
		l_nshields = [s.length, nShields].min
		result = []
		w_aux = w.clone
			
		@weapons.each do |element|
			indice = arrayContainsType(w_aux, element)
	  
			if indice != -1
				result.push(element)
				w_aux.delete_at(indice)
			end
		end

		return SpecificDamage.new(result, l_nshields)    # Damage ajustado a lo que hemos pasado
	end
	
	def discardWeapon(w)    # w es Weapon
		
		if @weapons.length != 0
				
			indice = @weapons.index(w.type)
			
			if indice != nil
				@weapons.delete_at(indice)
			end
		end
	end		# void
	
	def hasNoEffect
		return (@weapons.length + @nShields == 0)       # true si no se pierden accesorios
	end
		
	def to_s
		out = super
		out += "\tWeapons: "
		@weapons.each do |w|
			out += w.to_s + " // "
		end			
		out += "\n"	
		out+="------- end of Damage -------"
		return out
	end

	private 
	def arrayContainsType(w,t)   # w es arraylist de Weapon y t es WeaponType	
		i = 0
		retorno = -1
		sigo = true
		
		while (sigo && i < w.length)
			if w[i].type == t
				retorno = i
				sigo = false
			end
			i += 1
		end
		
		return retorno	# devuelve indice de la primer posición de w que coincida con el tipo t	
	end
  
end # class

end # module

