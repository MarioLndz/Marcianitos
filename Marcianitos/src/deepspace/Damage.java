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
    private ArrayList<WeaponType> weapons; // ns
    
    Damage(int w, int s){
        this.nWeapons = w;
        this.nShields = s;
    }
    
    Damage(ArrayList<WeaponType> wl, int s) {
        this.weapons = wl;
        this.nShields = s;
        this.nWeapons = wl.size(); // ns
    }
    
    Damage (Damage d) {
        this.nShields = d.nShields;
        this.nWeapons = d.nWeapons;
        this.weapons = d.weapons;
    }
    
    DamageToUI getUIVersion() {
        return new DamageToUI(this);
    }
    
    private int arrayContainsType(Weapon w[], WeaponType t) {
        throw new UnsupportedOperationException();
    }
    
    public Damage adjust(Weapon w[], ShieldBooster s[]) {
        throw new UnsupportedOperationException();
    }
    
    public void discardWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }
    
    public void discarShieldBooster() {
        throw new UnsupportedOperationException();
    }
    
    public boolean hasNoEffect(){
        throw new UnsupportedOperationException();
    }
    
    public int getNShields() {
        return this.nShields;
    }
    
    public int getNWeapons() {
        return this.nWeapons;
    }
    
    public WeaponType[] getWeapons(){
        return this.weapons;
    }
}

