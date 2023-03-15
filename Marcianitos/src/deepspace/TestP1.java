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
        final int TOPE = 100;

        // initWithNHangars
        int prob_hangars = 0;
        for (int i = 0; i < TOPE; ++i){
            prob_hangars += d.initWithNHangars();
        }

        System.out.println("\ninitWithNHangars: " + prob_hangars + "/" + TOPE);

        // initWithNWeapons
        int prob_uno = 0;
        int prob_dos = 0;

        int valor;

        for (int i = 0; i < TOPE; ++i){
            valor = d.initWithNWeapons();
            if (valor==1)
                prob_uno++;
            else if (valor==2)
                prob_dos++;
        }
		
        System.out.println("\ninitWithNWeapons 1: " + prob_uno + "/" + TOPE);
        System.out.println("\ninitWithNWeapons 2: " + prob_dos + "/" + TOPE);

        // initWithNShields
        int prob_shields = 0;
        for (int i = 0; i < TOPE; ++i){
            prob_shields += d.initWithNShields();
        }

        System.out.println("\ninitWithNShields: " + prob_shields + "/" + TOPE);

        // firstShot
        int prob_firstShot = 0;
        GameCharacter character;
        for (int i = 0; i < TOPE; ++i){
            character = d.firstShot();
            if (character == GameCharacter.SPACESTATION)
                prob_firstShot++;
        }
        
        System.out.println("\nfirstShot SPACESTATION: " + prob_firstShot + "/" + TOPE);
        
        
        // spaceStationMoves
        int prob_spaceStationMoves = 0;
        float speed=0.6f;
        for (int i = 0; i < TOPE; ++i){
            if (d.spaceStationMoves(speed))
                prob_spaceStationMoves++;
        }
        
        System.out.println("\nspaceStationMoves (speed = " + speed + "): " + prob_spaceStationMoves + "/" + TOPE);
        
        
    }
}
