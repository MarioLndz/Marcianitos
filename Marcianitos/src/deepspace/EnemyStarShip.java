/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

/**
 *
 * @author laura
 */
public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Loot loot;
    private Damage damage;
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d) {
        this.name = n;
        this.ammoPower = a;
        this.shieldPower = s;
        this.loot = l;
        this.damage = d;
    }
    
    EnemyStarShip(EnemyStarShip e) {
        this.name = e.name;
        this.ammoPower = e.ammoPower;
        this.shieldPower = e.shieldPower;
        this.loot = e.loot;
        this.damage = e.damage;
    }
    
    EnemyToUI getUIVersion() {
        return new EnemyToUI(this);
    }
    
    public float fire(){
        throw new UnsupportedOperationException();
    }
    
    public float getAmmoPower(){
        return this.ammoPower;
    }
    
    public Damage getDamage(){
        return this.damage;
    }
    
    public Loot getLoot(){
        return this.loot;
    }
    
    public String getName(){
        return this.name;
    }
    
    public float getShieldPower(){
        return this.shieldPower;
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public ShotResult receiveShot(float shot){
        throw new UnsupportedOperationException();
    }
}