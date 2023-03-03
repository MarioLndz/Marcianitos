/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author mario
 */
class Loot {
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    Loot (int supplies, int weapons, int shields, int hangars, int medals){
        this.nSupplies = supplies;
        this.nWeapons = weapons;
        this.nShields = shields;
        this.nHangars = hangars;
        this.nMedals = medals;
        
    }
    
    public int getNSupplies(){
        return (this.nSupplies);
    }
    
    public int getNWeapons(){
        return (this.nWeapons);
    }
    
    public int getNShields(){
        return (this.nShields);
    }
    
    public int getNHangars(){
        return (this.nHangars);
    }
    
    public int getNMedals(){
        return (this.nMedals);
    }
}
