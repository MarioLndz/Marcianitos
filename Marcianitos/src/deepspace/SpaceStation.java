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
        
        // creo q estos se inicializarian a 0 pq si no estamos sumando cosas a algo q no tiene valor
        this.ammoPower = 0;
        this.shieldPower = 0;
        this.fuelUnits = 0;
        
        this.receiveSupplies(supplies);
        
        // estos de abajo creo q se inicializarian así
        this.nMedals = 0; 
        this.weapons = null;
        this.shieldBoosters = null;
        this.hangar = null;
        this.pendingDamage = null;       
    }
    
    public void cleanUpMountedItems() {
        // Compruebo las armas sin usos y elimino las que no le queden usos
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
        this.hangar=null;        
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (getHangar() != null)
            getHangar().removeShieldBooster(i);
    }
    
    public void discardWeapon(int i){
        //throw new UnsupportedOperationException();
        
        int size = weapons.size();
        
        if(i>=0 && i<size){
            
            Weapon w = weapons.remove(i);
            
            if(pendingDamage != null){
                
                pendingDamage.discardWeapon(w);
                
                cleanPendingDamage();
            }
        }
    }
    
    public void discardWeaponInHangar(int i){
        if (getHangar() != null)
            getHangar().removeWeapon(i);
    }
    
    public float fire(){
<<<<<<< HEAD
        
        // throw new UnsupportedOperationException();
        
        int size = weapons.size();
        
        float factor=1f;
        
        Weapon w;
        
        for(int i=0;i<size;i++){
            
            w = weapons.get(i);
            
            factor *= w.useIt();
                      
        }
        
        return (ammoPower*factor);           
          
=======
        int size = this.weapons.size();
		
		float factor = 1f;

		for (int i = 0; i < size; ++i){
			Weapon w = weapons.get(i);
			factor *= w.useIt();
		}
		
		return (ammoPower*factor);
>>>>>>> 67ab684375894aa35324610b685f40107b439ebe
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
        this.fuelUnits -= this.fuelUnits*this.getSpeed();
    }
    
    public float protection(){
        int size = this.shieldBoosters.size();
        int factor = 1;
        for (int i = 0; i < size; ++i) {
            ShieldBooster s = this.shieldBoosters.get(i);
            factor *= s.useIt();
        }
        return (shieldPower * factor);
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
        throw new UnsupportedOperationException();
    }
    
    public void receiveSupplies(SuppliesPackage s){
        this.ammoPower += s.getAmmoPower();
        this.shieldPower += s.getshieldPower();
        this.assignFuelValue(this.fuelUnits + s.getfuelUnits());
    }
    
    public boolean receiveWeapon(Weapon w){
        boolean resultado = false;
        
        if (getHangar() != null)  
            resultado = getHangar().addWeapon(w);
        
        return resultado;
    }
    
	public void setLoot(Loot loot) {
        CardDealer dealer = CardDealer.getInstance();
		
		// Aniadimos Hangars
		int h = loot.getNHangars();
		if (h > 0){
			hangar = dealer.nextHangar();
			
			this.receiveHangar(hangar);
		}
		
		// Aniadimos supplies
		int elements = loot.getNSupplies();
		for (int i = 1; i < elements; ++i){
			SuppliesPackage sup = dealer.nextSuppliesPackage();
			receiveSupplies(sup);
		}
		
		// Aniadimos Weapons
		elements = loot.getNWeapons();
		for (int i = 1; i < elements; ++i){
			Weapon weap = dealer.nextWeapon();
			receiveWeapon(weap);
		}
		
		// Aniadimos Shields
		elements = loot.getNShields();
		for (int i = 1; i < elements; ++i){
			ShieldBooster sh = dealer.nextShieldBooster();
			
			receiveShieldBooster(sh);
		}
		
		int medals = loot.getNMedals();
		
		this.nMedals += medals;
    }
    
    public void setPendingDamage(Damage d){
        d.adjust(weapons, shieldBoosters);
        // se almacena el resultado en el atributo correspondiente ???
        // creo q es esto:
        this.pendingDamage = d;
    }
    
    public boolean validState(){
        return (this.pendingDamage == null || this.pendingDamage.hasNoEffect());
    }
}
