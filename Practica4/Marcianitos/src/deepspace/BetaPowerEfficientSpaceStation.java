/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author mario
 */
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation{
    
    private static final float EFFIENCYFACTOR=1.2f;
    private Dice dice;
    
    BetaPowerEfficientSpaceStation(SpaceStation station){
        super(station);
        dice=new Dice();
    }
    
    @Override
    public float fire(){
        
        float retorno;
        
        if(dice.extraEfficiency()){
            
            retorno=EFFIENCYFACTOR*super.fire();
        }
        else{
            retorno=super.fire();
        }
        
        return retorno;
    }
	
	
	@Override
	public BetaPowerEfficientSpaceStationToUI getUIversion (){
		return (new BetaPowerEfficientSpaceStationToUI(this));
	}
    
}
