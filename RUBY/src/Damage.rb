require_relative 'DamageToUI'
require_relative 'WeaponType'
require_relative 'Weapon'

module Deepspace
	class Damage
		
		@@NOUSO=-1
		
		def initialize(s,w,wp)
			@nShields=s
			@nWeapons=w
			@weapons=wp
		end
		
		def self.newNumericWeapons(w, s)
			return new(s, w, nil)
		end
		
		def self.newSpecificWeapons(wl, s)
			return new(s, @@NOUSO, wl)
		end
		
		def self.newCopy(d)
			if d.nWeapons == @@NOUSO
				return newSpecificWeapons(d.weapons, d.nShields)
			else
				return newNumericWeapons(d.nWeapons, d.nShields)
			end
		end
		
		def getUIversion()
			return damegeToUI.new(self)
		end
		
		attr_reader :nShields, :nWeapons, :weapons
		
		def adjust(w,s)   ## no estoy muy seguro
		
			l_nshields = [s.length, nShields].min

			if weapons==nil
			
				l_nweapons = [w.length, nWeapons].min
				
				return Damage.newNumericWeapons(l_nweapons,l_nshields)

			else
				result = []
				w_aux = w.clone
				
				weapons.each do |element|
					indice = arrayContainsType(w_aux, element)
              
					if indice != -1
						result.push(element)
						w_aux.delete_at(indice)
					end
				end

				Damage.newSpecificWeapons(result, l_nshields)
			end
		end
		
		
		def discardWeapon(w)
		
			if @nWeapons == @@NOUSO
			
				if @weapons.length != 0
					
					indice = @weapons.index(w.type)
					
					if indice != nil
						
						@weapons.delete_at(indice)
					end
				end
				
			elsif
				
				if @nWeapons > 0
					@nWeapons -= 1
				end
			end
			
		end
			
			
		def discardShieldBooster()
					
			if @nShields > 0
				
				@nShields -= 1
				
			end
			
		end
		
		def hasNoEffect()
		
			if @nWeapons == @@NOUSO
			
				retorno = @weapons.length + @nShields == 0
				
			else
			
				retorno = @nShields + @nWeapons == 0
				
			end
			
			return retorno
		end
		
		def to_s
			out="Damage - nShields: #{@nShields}"
						
			if (nWeapons != @@NOUSO)
				out+=", nWeapons: #{@nWeapons}\n"
			else
				out+="\tWeapons: [#{@weapons.join(', ')}]\n"
			end
			out+="------- end of Damage -------"
			return out
		end
		
		private 
		def arrayContainsType(w,t)
			
			contador=0
			retorno = -1
			
			w.each do |weapon_aux|
			
				if weapon_aux.type == t
					retorno = contador
				else
					contador+=1
				end
			end
			
			return retorno					
		end
		
	end
end			
