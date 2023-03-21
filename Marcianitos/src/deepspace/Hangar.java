/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author laura
 */
public class Hangar {
    private int maxElements;
    private ShieldBooster shieldBoosters[]; // ns si esta bien
    private Weapon weapons[];               // ns si esta bien
    
    Hangar(int capacity){
        this.maxElements = capacity;
    }
    
    Hangar(Hangar h) {
        this.maxElements = h.maxElements;
        this.shieldBoosters = h.getShieldBoosters();
        this.weapons = h.getWeapons();
    }
    
    HangarToUI getUIVersion() {
        return new HangarToUI(this);
    }
    
    private boolean spaceAvailable(){
        throw new UnsupportedOperationException();
    }
    
    public boolean addWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addShieldBooster(ShieldBooster s) {
        throw new UnsupportedOperationException();
    }
    
    public int getMaxElements() {
        return this.maxElements;
    }
    
    public ShieldBooster[] getShieldBoosters(){
        return this.shieldBoosters;
    }
    
    public Weapon[] getWeapons() {
        return this.weapons;
    }
    
    public ShieldBooster removeShieldBooster(int s){
        throw new UnsupportedOperationException();
    }
    
    public Weapon removeWeapon(int w){
        throw new UnsupportedOperationException();
    }
    
}
