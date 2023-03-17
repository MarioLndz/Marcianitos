#encoding: UTF-8

module Deepspace
	class Loot
		def initialize (supplies,weapons,shields,hangars,medals)
			@nSupplies = supplies
			@nWeapons = weapons
			@nShields = shields
			@nHangars = hangars
			@nMedals = medals
		end

		attr_reader :nSupplies
		
		attr_reader :nWeapons

		attr_reader :nShields
	
		attr_reader :nHangars

		attr_reader :nMedals
		
		def to_s
			return "Supplies: #{@nSupplies}, Weapons: #{@nWeapons}, Shields: #{@nShields}, Hangars: #{@nHangars}, Medals: #{@nMedals}"
		end
	end

end
