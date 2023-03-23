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
public class GameUniverse {
    static private int WIN = 10;     //atributo de clase creo q es asi
    
    private int currentStationIndex;
    private int turns;
    
    private GameStateController gameState;
    private EnemyStarShip currentEnemy;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    
    public GameUniverse(){
        
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        
    }

    public CombatResult combat() {
        
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
    
    public GameState getState() {
        
    }
    
    public GameUniverseToUI getUIversion() {
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }
    
    public boolean haveAWinner(){
        
    }
    
    public void init(ArrayList<String> names) {
        
    }
    
    public void mountShieldBooster(int i){
        
    }
    
    public void mountWeapon(int i) {
        
    }
    
    public boolean nextTurn() {
        
    }
}
