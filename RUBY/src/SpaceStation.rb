#encoding: UTF-8

require_relative 'SpaceStationToUI'
require_relative 'Weapon'
require_relative 'ShieldBooster'
require_relative 'Hangar'
require_relative 'Damage'
require_relative 'SuppliesPackage'

module Deepspace
  
	class SpaceStation

		#atributos de clase
		@@MAXFUEL=100
		@@SHIELDLOSSPERUNITSHOT=0.1
	  
		attr_reader :name, :nMedals, :ammoPower, :fuelUnits, \
		  :shieldPower, :shieldBoosters, :hangar, :weapons, \
		  :pendingDamage, :MAXFUEL, :SHIELDLOSSPERUNITSHOT
	  
		def initialize (n, supplies)		
			@name=n
			receiveSupplies(supplies)	#puede q falle
			
			@nMedals=0
			@weapons=nil
			@shieldBoosters=nil
			@hangar=nil
			@pendingDamage=nil
		end
		
		def cleanUpMountedItems()
			#Compruebo las armas sin usos y elimino las que no le queden usos
			@weapons.each do |w|
				if (w.uses == 0)
					@weapons.delete(w) #creo q es asi
				end
			end

			#Compruebo los escudos sin usos y elimino los que no tengan usos
			@shieldBoosters.each do |s|
				if (s.uses == 0)
					@shieldBoosters.delete(s) #creo q es asi
				end
			end
		end
		
		def discardHangar()
			@hangar=nil
		end
		
		def discardShieldBooster(i)
			
		end
		
		def discardShieldBoosterInHangar(i)
			if (hangar != nil)
				hangar.removeShieldBooster(i) 
			end
		end
		
		def discardWeapon(i)
		
		end
		
		def discardWeaponInHangar(i)
			if (hangar != nil)
				hangar.removeWeapon(i)
			end
		end
		
		def fire()
		
		end
		
		def getNMedals()
			return @nMedals
		end
		
		def getSpeed() 
			return (fuelUnits/MAXFUEL)
		end
		
		def getUIversion()
			SpaceStationToUI.new(self)
		end
		
		def mountShieldBooster(i)
			if (hangar != nil) 
				s = hangar.removeShieldBooster(i)
				if (s != nil)
					shieldBoosters.push(s)
				end
			end
		end
		
		def mountWeapon(i)
			if (hangar != nil) 
				w = hangar.removeWeapon(i)
				if (w != nil)
					weapons.push(s)
				end
			end
		end
		
		def move()
			fuelUnits -= fuelUnits*getSpeed();
		end
		
		def protection() 
		
		end
		
		def receiveHangar(h)
			if (hangar == nil)
				@hangar = h
			end
		end
		
		def receiveShieldBooster(s) 
			if (hangar != nil)
				hangar.addShieldBooster(s)	#creo q asi devuelve true o false ya
			end
		end
		
		def receiveShot(shot) 
		
		end
		
		def receiveSupplies(s) 
			@ammoPower += s.ammoPower
			@shieldPower += s.shieldPower
			assignFuelValue(fuelUnits + s.fuelUnits)
		end
		
		def receiveWeapon(w)
			if (hangar != nil)
				hangar.addWeapon(2)	#creo q asi devuelve true o false ya
			end
		end
		
		def setLoot(loot)
		
		end
		
		def setPendingDamage(d)
			d.adjust(weapons, shieldBoosters)
			# se almacena el resultado en el atributo correspondiente ???
			# creo q es esto:
			@pendingDamage = d
		end
		
		def validState()
			return (@pendingDamage == nil || @pendingDamage.hasNoEffect())
		end
		
		def to_s
			out="Space Station - Name: #{@name}\n"
			out+="\tnMedals: #{@nMedals}, Fuel units: #{@fuelUnits.round(2)}, Power: #{@ammoPower}, Shields: #{@shieldPower}\n"
			out+="\tWeapons: [#{@weapons.join(', ')}]\n"
			out+="\tShieldBooster: [#{@shieldBoosters.join(', ')}]\n"
			out+="\tHangars: #{@hangar}\n"
			out+="\tPendingDamage: #{@pendingDamage}\n" 
			out+="------- end of Space Station >> #{@name} << -------"
			return out
		end
		
		private 	#todos los metodos q haya debajo de esto son privados (solo los de instancia)
		def assignFuelValue(f)
			if (f < @@MAXFUEL)
				@fuelUnits = f
			else
				@fuelUnits = @@MAXFUEL
			end
		end
		
		def cleanPendingDamage()
			if (@pendingDamage.hasNoEffect())
				pendingDamage = nil 
			end 
		end

	end # class

end # module
