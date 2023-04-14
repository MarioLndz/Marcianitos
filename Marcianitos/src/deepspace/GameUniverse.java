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
        // crear contador de estados de juego
        this.gameState = new GameStateController();
        
        // contador de turno a 0
        this.turns = 0;
        
        // crear dado
        this.dice = new Dice();
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        throw new UnsupportedOperationException();
    }

    public CombatResult combat() {
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar() {
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.discardHangar();
    }
    
    public void discardShieldBooster(int i){
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.discardShieldBooster(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.discardShieldBoosterInHangar(i);
    }
    
    public void discardWeapon(int i){
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.discardWeapon(i);
    }
    
    public void discardWeaponInHangar(int i){
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.discardWeaponInHangar(i);
    }
    
    public GameState getState() {
        return this.gameState.getState();
    }
    
    public GameUniverseToUI getUIversion() {
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }
    
    public boolean haveAWinner(){
        return (this.currentStation.getNMedals() >= WIN);
    }
    
    public void init(ArrayList<String> names) {
        
        GameState state = gameState.getState();
        
        if(state == GameState.CANNOTPLAY){
            
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i=0;i<names.size();i++){
                
                SuppliesPackage supplies = dealer.suppliesPackages.next();
                
                SpaceStation station = new SpaceStation(names.get(i),supplies);
                
                spaceStations.add(station);
                
                int nh = dice.initWithNHangars();
                
                int nw = dice.initWithNWeapons();
                
                int ns = dice.initWithNShields();
                
                Loot lo = new Loot(0,nw,ns,nh,0);
                
                station.setLoot(lo);
                                   
            }
            
            currentStationIndex = dice.whoStarts(names.size());
            
            SpaceStation currentStation = spaceStations.get(currentStationIndex);
            
            EnemyStarShip currentEnemy = dealer.nextEnemy();
            
            gameState.next(turns, spaceStations.size());
            
            
        }
        
    }
    
    public void mountShieldBooster(int i){
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.mountShieldBooster(i);
    }
    
    public void mountWeapon(int i) {
        if (this.getState() == GameState.INIT || this.getState() == GameState.AFTERCOMBAT)
            this.currentStation.mountWeapon(i);
    }
    
    public boolean nextTurn() {
        throw new UnsupportedOperationException();
    }
}
