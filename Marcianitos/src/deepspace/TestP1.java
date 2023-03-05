/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author laura
 */
public class TestP1 {
    
    public static void main(String[] args) {												
        // LOOT
		Loot l = new Loot(2,5,1,6,3);
        System.out.println("LOOT:");
		System.out.println("Num Hangares:\t" + l.getNHangars());
        System.out.println("Num Medals:\t" + l.getNMedals());
        System.out.println("Num Shields:\t" + l.getNShields());
        System.out.println("Num Supplies:\t" + l.getNSupplies());
        System.out.println("Num Weapons:\t" + l.getNWeapons());
        
		// SUPPLIES
        SuppliesPackage sp = new SuppliesPackage(4.5f, 2, 3.1f);
		System.out.println("\nSUPPLIES:");
        System.out.println("AmmoPower:\t" + sp.getAmmoPower());
        System.out.println("Fuel Units:\t" + sp.getfuelUnits());
        System.out.println("Shield Power:\t" + sp.getshieldPower());
		
		// SHIELD BOOSTER
        ShieldBooster sb = new ShieldBooster("shield", 3.4f, 6);
		System.out.println("\nSHIELD BOOSTER");
        System.out.println("Boost:\t" + sb.getBoost());
        System.out.println("Uses:\t" + sb.getUses());
        System.out.println("UseIt:\t" + sb.useIt());
		
		// WEAPON
        Weapon w = new Weapon("weapon", WeaponType.MISSILE, 4);
		System.out.println("\nWEAPON");
        System.out.println("Type:\t" + w.getType());
        System.out.println("Uses:\t" + w.getUses());
        System.out.println("Power:\t" + w.power());
        System.out.println("UseIt:\t" + w.useIt());
        
		
		
		// PARTE 2
        Dice d = new Dice();
		
		// initWithNHangars
		final int TOPE = 100;
		
		int prob_hangars = 0;
		for (int i = 0; i < TOPE; ++i){
			prob_hangars += d.initWithNHangars();
		}
		
		System.out.println(prob_hangars + "/" + TOPE);
		
		// initWithNWeapons
		
		int prob_weapons = 0;
		for (int i = 0; i < TOPE; ++i){
			prob_weapons += d.initWithNWeapons();
		}
		
		System.out.println(prob_weapons + "/" + TOPE);
        
    }
}
