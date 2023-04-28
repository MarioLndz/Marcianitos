#encoding: UTF-8

require_relative 'SpaceStationToUI'
require_relative 'Weapon'
require_relative 'WeaponType'
require_relative 'ShieldBooster'
require_relative 'Hangar'
require_relative 'Damage'
require_relative 'SuppliesPackage'
require_relative 'ShotResult'

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
			@ammoPower = 0
			@shieldPower = 0
			@fuelUnits = 0
			receiveSupplies(supplies)
			
			@nMedals=0
			@weapons=Array.new()
			@shieldBoosters=Array.new()
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
			size = @shieldBoosters.length
			if (i>=0 && i<size)
				s=@shieldBoosters.delete_at(i)
				
				if (@pendingDamage != nil)
					@pendingDamage.discardShieldBooster(w)
					cleanPendingDamage
				end
			end	
		end
		
		def discardShieldBoosterInHangar(i)
			if (hangar != nil)
				hangar.removeShieldBooster(i) 
			end
		end
		
		def discardWeapon(i)
		
			size=@weapons.length
			if (i>=0 && i<size)
				w=@weapons.delete_at(i)
				
				if (@pendingDamage != nil)
					@pendingDamage.discardWeapon(w)
					cleanPendingDamage
				end
			end		
		end
		
		def discardWeaponInHangar(i)
			if (hangar != nil)
				hangar.removeWeapon(i)
			end
		end
		
		def fire()
			factor = 1
			
			@weapons.each do |w|
				factor *= w.useIt()
			end
			
			return (ammoPower*factor)
		
		end
		
		def getNMedals()
			return @nMedals
		end
		
		def getSpeed() 
			return (@fuelUnits.to_f/@@MAXFUEL)
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
					weapons.push(w)
				end
			end
		end
		
		def move()
			@fuelUnits -= @fuelUnits*getSpeed()
		end
		
		def protection() 
			factor = 1
			shieldBoosters.each do |s|
				factor *= s.useIt
			end	
			return (@shieldPower * factor)		
		end
		
		def receiveHangar(h)
			if (hangar == nil)
				@hangar = h
			end
		end
		
		def receiveShieldBooster(s) 
			retorno = false
			
			if (hangar != nil)
				retorno = hangar.addShieldBooster(s)	#creo q asi devuelve true o false ya
			end
			
			return (retorno)
		end
		
		def receiveShot(shot)
			myProtection=protection
			if(myProtection>=shot)
				@shieldPower=@shieldPower-(@@SHIELDLOSSPERUNITSHOT*shot)
				@shieldPower=[0.0,shieldPower].max
				ShotResult::RESIST
			else
				@shieldPower=0.0
				ShotResult::DONOTRESIST
			end
		
		end
		
		def receiveSupplies(s) 
			@ammoPower += s.ammoPower
			@shieldPower += s.shieldPower
			
			assignFuelValue(fuelUnits + s.fuelUnits)
			
		end
		
		def receiveWeapon(w)
			retorno = false
			if (hangar != nil)
				retorno = hangar.addWeapon(w)	#creo q asi devuelve true o false ya
			end
		end
		
		def setLoot(loot)
			dealer = CardDealer.new()
			
			#Aniadimos Hangars
			h = @loot.getNHangars()
			if (h > 0)
				hangar = dealer.nextHangar()
				
				receiveHangar(hangar)
			end
			
			#Aniadimos supplies
			elements = @loot.getNSupplies()
			for i in (1..elements) do
				sup = dealer.nextSuppliesPackage()
				receiveSupplies(sup)
			end
			
			# Aniadimos Weapons
			elements = @loot.getNWeapons()
			for i in (1..elements) do
				weap = dealer.nextWeapon()
				receiveWeapon(weap)
			end
			
			#Aniadimos Shields
			elements = @loot.getNShields()
			for i in (1..elements) do
				sh = dealer.nextShieldBooster()
				receiveShieldBooster(sh)
			end
			
			medals = @loot.getNMedals

			@nMedals += medals

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
			out+="\tWeapons: [#{@weapons.join(' // ')}]\n"
			out+="\tShieldBooster: [#{@shieldBoosters.join(' // ')}]\n"
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

	supplies = SuppliesPackage.new(1,10,3)
	estacion = SpaceStation.new(3, supplies)
	hangar = Hangar.new(3)
	shield = ShieldBooster.new("Escudo", 5, 2)

	weapon = Weapon.new("Arma de destruccion", WeaponType::LASER, 2)
	
	estacion.receiveHangar(hangar)

	estacion.receiveShieldBooster(shield)
	estacion.receiveWeapon(weapon)

	estacion.mountWeapon(0)

	puts estacion.protection

	puts estacion.to_s
	
end # module
