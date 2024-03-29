/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author mario
 */
public class Weapon implements CombatElement{
    private String name;
    private WeaponType type;
    private int uses;
    
    Weapon (String the_name, WeaponType the_type, int the_uses){
        this.name = the_name;
        this.type = the_type;
        this.uses = the_uses;
    }
    
    Weapon (Weapon w){
        this.name = w.name;
        this.type = w.type;
        this.uses = w.uses;
    }
    
    WeaponToUI getUIversion() {
        return new WeaponToUI(this);
    }
    
    public WeaponType getType (){
        return (this.type);
    }
    
    // ns si esto está bien pq no tiene ninguna utilidad poner exactamente lo mismo
    // pero q haya una interfaz
    @Override
    public int getUses(){
        return (this.uses);
    }
    
    
    public float power (){
        return (type.getPower());
    }
    
    // lo mismo q el getUses, no creo q esté bien
    @Override
    public float useIt(){
        float retorno = 1;
        
        if (this.uses > 0){
            --uses;
            retorno = this.power();
        }
        
        return (retorno);
    }
    
    public String toString(){
        
        String salida;
        
        salida = "Name=" + name + ", Type=" + type + ", Uses=" + uses;
        
        return salida;
    }
}
