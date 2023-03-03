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
    LASER(2), MISSILE(3), PLASMA(4);   
    
    private final float power;
    
    WeaponType (float the_power) {
        this.power = the_power;
        
    }
    
    float getPower(){
        return (this.power);
    }
}
