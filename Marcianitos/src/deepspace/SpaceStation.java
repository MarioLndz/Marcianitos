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
        throw new UnsupportedOperationException();
    }
    
    private void cleanPendingDamage(){
        throw new UnsupportedOperationException();
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        throw new UnsupportedOperationException();
    }
    
    public void cleanUpMountedItems() {
        // Compruebo las armas sin usos y elimino la que no le queden
		int num_weapons = this.weapons.size();
		for (int i = 0; i < num_weapons; ++i){
			if (weapons.get(i).getUses() == 0){
				weapons.remove(i);
			}
		}
		
		//Compruebo los escudos sin usos y elimino los que no tengan usos
		int num_shields = this.shieldBoosters.size();
		for (int i = 0; i < num_shields; ++i){
			if (this.shieldBoosters.get(i).getUses() == 0){
				this.shieldBoosters.remove(i);
			}
			
		}
    }
    
    public void discardHangar() {
        
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBoosterInHangar(int i){
        
    }
    
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
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
        return (this.fuelUnits/SpaceStation.MAXFUEL);
    }
    
    public SpaceStationToUI getUIversion(){
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
        this.fuelUnits -= this.fuelUnits*this.getSpeed();
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public void receiveHangar(Hangar h){
        
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        
    }
    
    public ShotResult receiveShot(float shot){
        throw new UnsupportedOperationException();
    }
    
    public void receiveSupplies(SuppliesPackage s){
        
    }
    
    public boolean receiveWeapon(Weapon w){
        
    }
    
    public void setLoot(Loot loot) {
        throw new UnsupportedOperationException();
    }
    
    public void setPendingDamage(Damage d){
        this.pendingDamage = d;
    }
    
    public boolean validState(){
		return (this.pendingDamage == null || this.pendingDamage.hasNoEffect());
    }
}
