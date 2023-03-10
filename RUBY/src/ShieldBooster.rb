#encoding: UTF−8

module Deepspace

	class ShieldBooster		# ponerle visibilidad de paquete -> visibilidad publica
	
		#constructor
		def initialize(n,b,u)
			# atributos de instancia privados
			@name=n
			@boost=b
			@uses=u
		end
		
		# constructor de copia
		def self.newCopy(other)
			new(other.name, other.boost, other.uses)		
		end		
		
		# consultor publico 
		attr_reader: name
		attr_reader: boost
		
		# metodo de instancia publico
		def useIt
			retorno=1
			if (@uses > 0)
				@uses -= 1
				retorno = boost
			end
			
			return retorno
		end      
	end
end
