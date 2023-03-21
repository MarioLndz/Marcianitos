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
    
    //private Loot ...
    //private ShotResult ...
    //private SuppliesPackage ....??
    //private CardDealer ...
    
    private void assignFuelValue(float f){
        throw new UnsupportedOperationException();
    }
    
    private void cleanPendingDamage(){
        throw new UnsupportedOperationException();
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        throw new UnsupportedOperationException();
    }
    
    public void cleanUpMountedItems() {
        
    }
    
    public void discardHangar() {
        
    }
    
    public void discardShieldBooster(int i){
        
    }
    
    public void discardShieldBoosterInHangar(int i){
        
    }
    
    public void discardWeapon(int i){
        
    }
    
    public void discardWeaponInHangar(int i){
        
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
    
    public SpaceStationToUI getUIVersion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return this.weapons;
    }
    
    public void mountShieldBooster(int i){
        
    }
    
    public void mountWeapon(int i){
        
    }
    
    public void move(){
        
    }
    
    public float protection(){
        
    }
    
    public void receiveHangar(Hangar h){
        
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        
    }
    
    public ShotResult receiveShot(float shot){
        
    }
    
    public void receiveSupplies(SuppliesPackage s){
        
    }
    
    public boolean receiveWeapon(Weapon w){
        
    }
    
    public void setLoot(Loot loot) {
        
    }
    
    public void setPendingDamage(Damage d){
        this.pendingDamage = d;
    }
    
    public boolean validState(){
        
    }
}