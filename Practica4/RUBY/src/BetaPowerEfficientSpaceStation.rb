
require_relative 'PowerEfficientSpaceStation'
require_relative 'BetaPowerEfficientSpaceStationToUI'

module Deepspace

class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
	
	@@EXTRAEFFICIENCY = 1.2

    def initialize (s)
      super(s)
      d = Dice.new()
    end
    
    #override
    def fire
		
      if(d.extraEfficiency)
        retorno = super*@@EXTRAEFFICIENCY
      else
        retorno = super
      end
      return retorno
    end
    
    #Override
    def to_s
      return "(Beta) " + super
    end
	
	def getUIversion
      return BetaPowerEfficientSpaceStationToUI.new(self)
    end
    
end # class

end # module

