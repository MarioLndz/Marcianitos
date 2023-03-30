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
        this.nWeapons = -1; 
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
        
        Damage ajustado;
        int l_nshields = Math.min(s.size(), this.getNShields());

        if (this.getWeapons() == null) { // estamos usando solo numero de weapon
            int l_nweapons = Math.min(w.size(), this.getNWeapons());
            ajustado = new Damage(l_nweapons, l_nshields);
        }
        else {  // estamos usando array de weapontype
            ArrayList<WeaponType> result = new ArrayList();
            ArrayList<Weapon> aux = w;
                    
            for (int i = 0; i<this.getWeapons().size(); i++) {
                WeaponType element = this.getWeapons().get(i);
                int indice = this.arrayContainsType(aux, element);
                if (indice != -1) {
                    result.add(element);
                    aux.remove(indice);
                }
            }            
            ajustado = new Damage(result, l_nshields);
        }

        return ajustado;
    }
    
    public void discardWeapon(Weapon w) {
        if (getWeapons() != null) 
            getWeapons().remove(w.getType());
        else
            if (getNWeapons() > 0)
                this.nWeapons--;
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

