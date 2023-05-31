/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.UI;

import View.DeepSpaceView;
import controller.Controller;
import deepspace.GameState;
import deepspace.GameUniverseToUI;
import java.util.ArrayList;
import controller.Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author laura
 */
public class MainWindow extends javax.swing.JFrame implements DeepSpaceView {

    private String appName;
    private SpaceStationView stationView;
    private EnemyView enemyView;

    private static MainWindow instance = null;

    public static MainWindow getInstance () {   
        if (instance == null) {
          instance = new MainWindow();
        }
        return instance;
    }
    
    /**
     * Creates new form MainWindow
     */
    private MainWindow() {
        initComponents();
		
        //jButtonCombatir.setEnabled(false);

        appName = "Deepspace 1.0";
		
        enemyView = new EnemyView();
        jpEnemy.add(enemyView);
		
        stationView = new SpaceStationView();
        jpStation.add(stationView);
		
        setTitle (appName);
	this.setSize(1280, 760);
        repaint();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new java.awt.event.WindowAdapter() {  // para q al cerrar la ventana deje de ejecutarse
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Controller.getInstance().finish(0);
            }
        });
    }

    @Override
    public void updateView(){  
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy());
	stationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());	
        jpStation.add(stationView);
        jpEnemy.add(enemyView);
        
        GameState gameState = Controller.getInstance().getState();
        if(gameState == GameState.INIT){            
            jButtonCombatir.setEnabled(true);
            jButtonSigTurno.setEnabled(false);
        }
        if(gameState == GameState.BEFORECOMBAT){            
            jButtonCombatir.setEnabled(true);
            jButtonSigTurno.setEnabled(false);
        }
        if(gameState == GameState.AFTERCOMBAT){            
            jButtonCombatir.setEnabled(false);
            jButtonSigTurno.setEnabled(true);
        }
        
        repaint();
    }
     
    @Override
    public void showView() {   
        this.setVisible(true);
    }
    
    // Inputs
    @Override
    public ArrayList<String> readNamePlayers(){    
        NamesCapture namesCapt = new NamesCapture(this);    
        return namesCapt.getNames();    
    }
    
    // Outputs
    @Override
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "¿Desea salir realmente?", getAppName(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    @Override
    public void nextTurnNotAllowedMessage() {
        JOptionPane.showMessageDialog(this, "No puedes avanzar de turno, \nno has cumplido tu castigo.", getAppName(), JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void lostCombatMessage(){
        JOptionPane.showMessageDialog(this, "Has PERDIDO el combate. \nCumple tu castigo.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void escapeMessage(){
        JOptionPane.showMessageDialog(this, "Has logrado ESCAPAR. \nEres un gallina espacial.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void wonCombatMessage(){
        JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void wonGameMessage(){
        JOptionPane.showMessageDialog(this, "ENHORABUENA!!. \nHas ganado el juego!!.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void conversionMessage() {
        if(Controller.getInstance().getUIversion().getCurrentEnemy().getLoot().isGetEfficient()){
            JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO en una estación EFICIENTE. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO en una CIUDAD ESPACIAL. \nDisfruta de tu botín.", getAppName(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @Override
    public void noCombatMessage() {
        JOptionPane.showMessageDialog(this, "No puedes combatir en este momento.", getAppName(), JOptionPane.ERROR_MESSAGE);
    }
	
    public String getAppName() {
        return appName;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEnemy = new javax.swing.JPanel();
        jpStation = new javax.swing.JPanel();
        jButtonSigTurno = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCombatir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        jpEnemy.setBackground(new java.awt.Color(204, 204, 204));
        jpEnemy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpEnemy.setOpaque(false);

        javax.swing.GroupLayout jpEnemyLayout = new javax.swing.GroupLayout(jpEnemy);
        jpEnemy.setLayout(jpEnemyLayout);
        jpEnemyLayout.setHorizontalGroup(
            jpEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpEnemyLayout.setVerticalGroup(
            jpEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jpStation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonSigTurno.setText("Siguiente Turno");
        jButtonSigTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSigTurnoActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonCombatir.setText("COMBATIR");
        jButtonCombatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCombatirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpStation, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalir))
                    .addComponent(jpEnemy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCombatir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonSigTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jButtonCombatir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSigTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpStation, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jButtonSalir)
                .addGap(6, 6, 6))
        );

        jpStation.setSize(790,700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        Controller.getInstance().finish(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCombatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCombatirActionPerformed
        Controller.getInstance().combat();
        updateView();
        revalidate();
    }//GEN-LAST:event_jButtonCombatirActionPerformed

    private void jButtonSigTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSigTurnoActionPerformed
        Controller.getInstance().nextTurn();
        updateView();
        revalidate();
    }//GEN-LAST:event_jButtonSigTurnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCombatir;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSigTurno;
    private javax.swing.JPanel jpEnemy;
    private javax.swing.JPanel jpStation;
    // End of variables declaration//GEN-END:variables
}
