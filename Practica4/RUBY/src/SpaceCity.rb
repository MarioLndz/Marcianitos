#encoding: UTF-8

require_relative 'SpaceStation'
require_relative 'Transformation'

require_relative 'SpaceCityToUI'

module Deepspace
    class SpaceCity < SpaceStation
        #   la_base: SpaceStation
        #   los_collaborators: Arraylist<SpaceStation>
        def initialize (la_base, los_collaborators)
            super(la_base.name, SuppliesPackage.new(la_base.ammoPower, la_base.fuelUnits, la_base.shieldPower))
            copy(la_base)

            @base = la_base
            @collaborators = los_collaborators
        end

        attr_reader :collaborators

        def fire ()
            fire = super

            @collaborators.each do |s|
                fire += s.fire()
            end

            return (fire)
        end

        def protection
            protection = super

            @collaborators.each do |s|
                protection += s.protection()
            end

            return (protection)
        end

        def setLoot (loot)
            super(loot)

            return (Transformation::NOTRANSFORM)
        end

        def getUIversion 
            SpaceCityToUI.new(self)
        end
    end
end
