#encoding: UTF-8
require_relative 'LootToUI'

module Deepspace
	class Loot	#terminada
		def initialize (supplies,weapons,shields,hangars,medals,ef,city)  # son todos int menos ef y city q son bool
			@nSupplies = supplies
			@nWeapons = weapons
			@nShields = shields
			@nHangars = hangars
			@nMedals = medals
			
			@efficient = ef
			@spaceCity = city
		end

		attr_reader :nSupplies, :nWeapons, :nShields, :nHangars, :nMedals, :efficient, :spaceCity
		
		def getUIversion()
			return LootToUI.new(self)
		end
		
		def to_s
			return "Supplies: #{@nSupplies}, Weapons: #{@nWeapons}, Shields: #{@nShields}, Hangars: #{@nHangars}, Medals: #{@nMedals}, getEfficient: #{@getEfficient}, spaceCity: #{@spaceCity}"
		end
	end

end
