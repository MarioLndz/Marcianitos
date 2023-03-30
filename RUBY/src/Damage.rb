require_relative 'DamageToUI'
require_relative 'WeaponType'
require_relative 'Weapon'

module Deepspace
	class Damage
		def initialize(s,w,wp)
			@nShields=s
			@nWeapons=w
			@weapons=wp
		end
		
		def self.newNumericWeapons(w, s)
			return new(w, s, nil)
		end
		
		def self.newSpecificWeapons(w, wp)
			return new(w, -1, wp)
		end
		
		def self.newCopy(d)
			if d.nWeapons == -1
				return newSpecificWeapons(d.nShields, d.weapons)
			else
				return newNumericWeapons(d.nShields, d.nWeapons)
			end
		end
		
		def getUIversion()
			return damegeToUI.new(self)
		end
		
		def arrayContainsType(w,t)
			
			contador=0
			
			w.each do |weapon_aux|
			
				if weapon_aux.type == t
					return contador
				else
					contador+=1
				end
			end
			
			return -1
				
					
		end
		
		def discardWeapon(w)
		
			if @nWeapons == -1
			
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
			
			
		def discardShieldBooster()
					
			if @nShields > 0
				
				@nShields -= 1
				
			end
			
		end
		
		def hasNoEffect()
		
			if @nWeapons == -1
			
				return @weapons.length + @nShields == 0
				
			else
			
				return @nShields + @nWeapons == 0
				
			end
		end
		
		def adjust(w,s)   ## no estoy muy seguro
		
			l_nshields = [s.length, nShields].min

			if weapons==nil
			
				l_nweapons = [w.length, nWeapons].min
				
				return Damage.newNumericWeapons(l_nshields,l_nweapons)

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

				Damage.newSpecificWeapons(limit_nshields, result)
			end
		
		def to_s
			out="Damage - nShields: #{@nShields}"
						
			if (nWeapons != -1)
				out+=", nWeapons: #{@nWeapons}\n"
			else
				out+="\tWeapons: [#{@weapons.join(', ')}]\n"
			end
			out+="------- end of Damage -------"
			return out
		end
		
      end
 end			
