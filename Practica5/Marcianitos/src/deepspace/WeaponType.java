/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

package deepspace;

/**
 *
 * @author mario
 */
public enum WeaponType {
	LASER(2.0f), MISSILE(3.0f), PLASMA(4.0f);
    
    private final float power;
    
    WeaponType (float the_power) {
        this.power = the_power;
        
    }
    
    float getPower(){
        return (this.power);
    }
	
	public static String toString (WeaponType tipo){
		String s = new String();
		
		switch (tipo) {
			case LASER:
				s += "Láser";
				break;
			case MISSILE:
				s += "Misil";
				break;
			case PLASMA:
				s += "Plasma";
				break;
		}
		
		return s;
	}
	
}
