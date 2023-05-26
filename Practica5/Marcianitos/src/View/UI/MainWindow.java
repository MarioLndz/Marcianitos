/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.UI;

import View.DeepSpaceView;
import deepspace.GameState;
import deepspace.GameUniverseToUI;
import java.util.ArrayList;
import controller.Controller;

/**
 *
 * @author laura
 */
public class MainWindow extends javax.swing.JFrame implements DeepSpaceView {

    private String appName;
    private SpaceStationView stationView;
	private EnemyView enemyView;
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
		appName = "Deepspace 1.0";
		
        enemyView = new EnemyView();
        jpEnemy.add(enemyView);
		
		stationView = new SpaceStationView();
		jpStation.add(stationView);
		
        setTitle (appName);
        repaint();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Controller.getInstance().finish(0);
            }
        });
    }
    
    ////////////////////////////////
    private static MainWindow instance = null;

    public static MainWindow getInstance () {   // copiado del ejemplo y textmainview
        if (instance == null) {
          instance = new MainWindow();
        }
        return instance;
    }

    private GameUniverseToUI gameUI;
    private GameState state;
  
    @Override
    public void updateView(){  
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy());
		stationView.setSpaceStation(Controller.getInstance().getUIversion().getCurrentStation());
    }
     
    @Override
    public void showView() {    // lo pone en el pdf
        this.setVisible(true);
    }
    
    // Inputs
    @Override
    public ArrayList<String> readNamePlayers(){     //lo pone en el pdf
        NamesCapture namesCapt = new NamesCapture(this);    // hay q terminar el constructor de NamesCapture
        return namesCapt.getNames();    // añadir getNames a NamesCapture
    }
    
    // Outputs
    @Override
    public boolean confirmExitMessage() {
        return (true);
    }
    
    @Override
    public void nextTurnNotAllowedMessage() {
        
    }
    
    @Override
    public void lostCombatMessage(){
        
    }
    
    @Override
    public void escapeMessage(){
        
    }
    
    @Override
    public void wonCombatMessage(){
        
    }
    
    @Override
    public void wonGameMessage(){
        
    }
    
    @Override
    public void conversionMessage() {
        
    }
    
    @Override
    public void noCombatMessage() {
        
    }
    /////////////////////////////////////

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpStation = new javax.swing.JPanel();
        jpEnemy = new javax.swing.JPanel();
        jButtonSigTurno = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCombatir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpStation.setBackground(new java.awt.Color(3, 53, 53));

        javax.swing.GroupLayout jpStationLayout = new javax.swing.GroupLayout(jpStation);
        jpStation.setLayout(jpStationLayout);
        jpStationLayout.setHorizontalGroup(
            jpStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jpStationLayout.setVerticalGroup(
            jpStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        jpEnemy.setBackground(new java.awt.Color(53, 3, 53));

        javax.swing.GroupLayout jpEnemyLayout = new javax.swing.GroupLayout(jpEnemy);
        jpEnemy.setLayout(jpEnemyLayout);
        jpEnemyLayout.setHorizontalGroup(
            jpEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpEnemyLayout.setVerticalGroup(
            jpEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        jButtonSigTurno.setText("Siguiente Turno");

        jButtonSalir.setText("Salir");

        jButtonCombatir.setText("COMBATIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSigTurno)
                            .addComponent(jButtonCombatir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jButtonSalir))
                    .addComponent(jpEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonCombatir, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSigTurno)
                            .addComponent(jButtonSalir))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCombatir;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSigTurno;
    private javax.swing.JPanel jpEnemy;
    private javax.swing.JPanel jpStation;
    // End of variables declaration//GEN-END:variables
}
