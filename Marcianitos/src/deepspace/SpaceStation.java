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
public class SpaceStation {
    static private int MAXFUEL = 100;     //atributo de clase creo q es asi
    static private float SHIELDLOSSPERUNITSHOT = 0.1f;
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;   
    private Damage pendingDamage;
    
    private void assignFuelValue(float f){
        if (f < MAXFUEL)
            fuelUnits = f;
        else
            fuelUnits = MAXFUEL;
    }
    
    private void cleanPendingDamage(){
        if (getPendingDamage().hasNoEffect())
            pendingDamage = null;        
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        this.name = n;
        this.receiveSupplies(supplies);
        
        // estos de abajo creo q se inicializarian así
        this.nMedals = 0; 
        this.weapons = null;
        this.shieldBoosters = null;
        this.hangar = null;
        this.pendingDamage = null;       
    }
    
    public void cleanUpMountedItems() {
        
    }
    
    public void discardHangar() {
        this.hangar=null;        
    }
    
    public void discardShieldBooster(int i){
        
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (getHangar() != null)
            getHangar().removeShieldBooster(i);
    }
    
    public void discardWeapon(int i){
        
    }
    
    public void discardWeaponInHangar(int i){
        if (getHangar() != null)
            getHangar().removeWeapon(i);
    }
    
    public float fire(){
        throw new UnsupportedOperationException();
    }
    
    public float getAmmoPower(){
        return this.ammoPower;
    }
    
    public float getFuelUnits(){
        return this.fuelUnits;
    }
    
    public Hangar getHangar(){
        return this.hangar;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getNMedals(){
        return this.nMedals;
    }
    
    public Damage getPendingDamage(){
        return this.pendingDamage;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return this.shieldBoosters;
    }
    
    public float getShieldPower(){
        return this.shieldPower;
    }
    
    public float getSpeed(){
        throw new UnsupportedOperationException();
    }
    
    public SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return this.weapons;
    }
    
    public void mountShieldBooster(int i){
        ShieldBooster s;
        if (getHangar() != null) {
            s = getHangar().removeShieldBooster(i);
            if (s != null)
                getShieldBoosters().add(s);
        }        
    }
    
    public void mountWeapon(int i){
        Weapon w;
        if (getHangar() != null) {
            w = getHangar().removeWeapon(i);
            if (w != null)
                getWeapons().add(w);
        }
    }
    
    public void move(){
        
    }
    
    public float protection(){
        
    }
    
    public void receiveHangar(Hangar h){
        if (getHangar() == null)    
            this.hangar = h;
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        boolean resultado = false;
        
        if (getHangar() != null)  
            resultado = getHangar().addShieldBooster(s);
        
        return resultado; 
    }
    
    public ShotResult receiveShot(float shot){
        
    }
    
    public void receiveSupplies(SuppliesPackage s){
        this.ammoPower += s.getAmmoPower();
        this.shieldPower += s.getshieldPower();
        this.fuelUnits += s.getfuelUnits();
    }
    
    public boolean receiveWeapon(Weapon w){
        boolean resultado = false;
        
        if (getHangar() != null)  
            resultado = getHangar().addWeapon(w);
        
        return resultado;
    }
    
    public void setLoot(Loot loot) {
        
    }
    
    public void setPendingDamage(Damage d){
        d.adjust(weapons, shieldBoosters);
        // se almacena el resultado en el atributo correspondiente ???
        // creo q es esto:
        this.pendingDamage = d;
    }
    
    public boolean validState(){
        
    }
}
