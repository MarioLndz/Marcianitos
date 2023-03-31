require_relative 'HangarToUI'
require_relative 'Weapon'
require_relative 'ShieldBooster'
require_relative 'WeaponType'

module Deepspace
	class Hangar
		def initialize(capacity)
			@maxElements = capacity
			@shieldBoosters = Array.new()
			@weapons = Array.new()
		end
		
		attr_reader :maxElements, :weapons, :shieldBoosters
		
		def self.newCopy(h)
			
			copy=new(h.maxElements)
			
			h.shieldBoosters.each do |shieldBooster|
				copy.addShieldBooster(shieldBooster)
			end
			
			h.weapon.each do |weapon|
				copy.addWeapon(weapon)
			end
			
			return copy
		end
		
		def spaceAvailable()
			retorno=1
						
			if (@maxElements < (@weapons.length + @shieldBoosters.length))
				retorno=0
			end
			
			return (retorno)
		end
		
		def addWeapon(w)
			retorno=0
						
			if spaceAvailable()
				retorno=1
				@weapons << w
			end
			
			return retorno
		end
		
		def addShieldBooster(s)
		
			retorno=0
						
			if spaceAvailable()
				retorno=1
				@shieldBoosters << s 
			end
			
			return retorno
		end
		
		def removeWeapon(w)	
					
			if (w < @weapons.length && w >= 0)
				retorno = @weapons.delete_at(w)
			else
				retorno = nil
			end
			
			return retorno
		end
		
		def  removeShieldBooster(s)
			
			if (s < @shieldBooster.length && s >= 0)
				retorno = @shieldBoosters.delete_at(s)
			else
				retorno = nil
			end
			
			return retorno
		end
				
		def getUIversion()
			return HangarToUI.new(self)
		end
		
		def to_s
			out="Hangar - capacity: #{@maxElements}\n"
			out+="\tWeapons: [#{@weapons.join(', ')}]\n"
			out+="\tShieldBoosters: [#{@shieldBoosters.join(', ')}]\n"
			out+="------- end of Hangar -------"
			return out
		end
	end	
end
		
		
			
			
