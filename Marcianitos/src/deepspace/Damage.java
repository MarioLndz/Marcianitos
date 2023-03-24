/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons; 
    
    Damage(int w, int s){
        this.nWeapons = w;
        this.nShields = s;
        weapons = null;
    }
    
    Damage(ArrayList<WeaponType> wl, int s) {
        this.weapons = wl;
        this.nShields = s;
        this.nWeapons = wl.size(); 
    }
    
    Damage (Damage d) {
        this.nShields = d.getNShields();
        this.nWeapons = d.getNWeapons();
        this.weapons = d.getWeapons();
    }
    
    DamageToUI getUIVersion() {
        return new DamageToUI(this);
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {        
        int pos = -1;
        boolean encontrado = false;
        int i = 0;
        
        while(i<w.size() && !encontrado) {
            if (w.get(i).getType() == t) {
                encontrado = true;
                pos = i;
            }
            else
                i++;
        }
        
        return pos;
    }
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        Damage ajustado = new Damage(w.size(), s.size());
        
        // NO SE HACERLO BIEN
		// YO TAMPOCO: ATENTAMENTE, EL LINDEZ
        
        return ajustado;
    }
    
    public void discardWeapon(Weapon w) {
        if (getNWeapons() > 0) {
            if (getWeapons() != null) {
                getWeapons().remove(w.getType());
            }
            this.nWeapons--;
        }
    }
    
    public void discarShieldBooster() {
        if (getNShields() > 0)
            this.nShields --;
    }
    
    public boolean hasNoEffect(){
        // NO SE SI ESTO ESTA BIEN
		boolean no_weapon_damage = nWeapons == -1 ? (this.weapons.isEmpty()) : (this.nWeapons == 0);
		
		return (no_weapon_damage && (this.nShields == 0));

    }
    
    public int getNShields() {
        return this.nShields;
    }
    
    public int getNWeapons() {
        return this.nWeapons;
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return this.weapons;
    }
}

