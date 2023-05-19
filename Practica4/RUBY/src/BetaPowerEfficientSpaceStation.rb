
require_relative 'PowerEfficientSpaceStation'

module Deepspace

class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
	
	@@EXTRAEFFICIENCY = 1.2

    def initialize (s)
        super(s)
    end
    
    #override
    def fire
		d = Dice.new()
		if(d.extraEfficiency)
			retorno = super*@@EXTRAEFFICIENCY
		else
			retorno = super
		end
		return retorno
    end
    
    #Override
    def to_s
      return super + " (beta)"
    end

end # class

end # module

