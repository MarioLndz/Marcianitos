require_relative 'HangarToUI'
require_relative 'Weapon'
require_relative 'ShieldBooster'
require_relative 'WeaponType'

module Deepspace
	class Hangars
		def initialize(@capacity)
			@maxElements = capacity
			@shieldBoosters = []
			@weapons = []
		end
		
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
			
			if @maxElementos < @shieldBoosters.length + @weapons.length
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
				@shieldBopsters << s 
			end
			
			return retorno
		end
		
		def removeWeapon(w)	
			
			if w < @weapons.length && w >= 0
				
				return @weapons.delete_at(w)
			elsif
				return nil
				
			end
		
		end
		
		def  removeShieldBooster(s)
			
			if s < @shieldBooster.length && s >= 0
				return @shieldBoosters.delete_at(s)
			elsif
				return nil
			end
		end
		
		def getMaxElements()
			return @maxElements
		end
		
		def getWeapons()
			return @weapons
		end
		
		def getShieldBoosters()
			return @shieldBoosters
		end
		
		def getUIversion()
			return HangarToUI.new(self)
		end
		
		#to_s?
	end
end
		
		
			
			
