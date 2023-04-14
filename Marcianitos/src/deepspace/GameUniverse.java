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
        boolean ret = false;
        GameState state = gameState.getState();
        
        if(state == GameState.AFTERCOMBAT) {
            boolean stationState = currentStation.validState();
            
            if(stationState) {
                currentStationIndex = (currentStationIndex+1) % spaceStations.size();
                turns++;
                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns, spaceStations.size());
                ret = true;
            }
        }
        return ret;
    }
}
