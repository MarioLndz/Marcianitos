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
    
    public static void main (){     // ns si el tipo de funcion esta bien
                                    // asi es como esta en los ejemplos de las diapositivas
    
        Loot l = new Loot(2,5,1,6,3);
        System.out.println(l.getNHangars());
        System.out.println(l.getNMedals());
        System.out.println(l.getNShields());
        System.out.println(l.getNSupplies());
        System.out.println(l.getNWeapons());
        
        SuppliesPackage sp = new SuppliesPackage(4.5f, 2, 3.1f);
        System.out.println(sp.getAmmoPower());
        System.out.println(sp.getfuelUnits());
        System.out.println(sp.getshieldPower());

        ShieldBooster sb = new ShieldBooster("shield", 3.4f, 6);
        System.out.println(sb.getBoost());
        System.out.println(sb.getUses());
        System.out.println(sb.useIt());

        Weapon w = new Weapon("weapon", WeaponType.MISSILE, 4);
        System.out.println(w.getType());
        System.out.println(w.getUses());
        System.out.println(w.power());
        System.out.println(w.useIt());
        
        Dice d = new Dice();
        
        
    }
}
