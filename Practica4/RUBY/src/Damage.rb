require_relative 'DamageToUI'
require_relative 'WeaponType'
require_relative 'Weapon'
require_relative 'ShieldBooster'


module Deepspace
	class Damage	#terminada
			
		private_class_method :new
		
		def initialize(s)  # s int es numero de escudos
			@nShields = s
		end
		
		attr_reader :nShields
		
		def discardShieldBooster()
					
			if @nShields > 0
				@nShields -= 1				
			end              # es void()	
		end
		
		def to_s
			out="Damage - nShields: #{@nShields}"
			return out
		end

=begin		
		private 
		
		#creo q este metodo iria en el SpecificDamage pq el otro damage no lo usa
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
=end

	end
	
	#tipos = Array.new
	#tipos << WeaponType::LASER
	#tipos << WeaponType::MISSILE

	#shields = Array.new
	#shields << "AAA"

	#d = Damage.newSpecificWeapons(tipos, 3)
	#puts d.getUIversion

	#pendingDamage = Damage.newSpecificWeapons(Array.new, 2)

	#armas = Array.new
	#armas << Weapon.new("MISIL", WeaponType::MISSILE, 2)

	#pendingDamage = d.adjust(armas, shields)
	#puts pendingDamage.getUIversion

end			

