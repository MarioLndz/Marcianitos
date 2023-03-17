package deepspace;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
    
    Loot(int supplies, int weapons, int shields, int hangars, int medals){
        
        nSupplies=supplies;
        nWeapons=weapons;
        nShields=shields;
        nHangars= hangars;
        nMedals=medals;       
       
    }
    
    public int getNSupplies(){
        
        return nSupplies;
    }
    
    public int getNWeapons(){
        
        return nWeapons;
    }
    
    public int getNShields(){
        
        return nShields;
    }
    
    public int getNHangars(){
        
        return nHangars;
    }
     
    public int getNMedals(){
        
        return nMedals;
    }
    
    public String ToString(){
        
        String salida;
        
        salida = "Supplies=" + nSupplies + ", Weapons=" + nWeapons + ", Shields=" + nShields + ", Hangars=" + nHangars;

        return salida;
    }
    
}
