/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.UI;
import deepspace.HangarToUI;
import deepspace.ShieldToUI;
import deepspace.SpaceStationToUI;
import deepspace.WeaponToUI;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class SpaceStationView extends javax.swing.JPanel {
    
    /**
     * Creates new form SpaceStationView
     */
    public SpaceStationView() {
        initComponents();
    }

    void setStation(SpaceStationToUI station) {
        ammoPower.setText(String.valueOf(station.getAmmoPower()));
        shieldPower.setText(String.valueOf(station.getShieldPower()));
        nMedals.setText(String.valueOf(station.getnMedals()));
        fuelUnits.setText(String.valueOf(station.getFuelUnits()));
        
        // añado weapons al panel
        addWeapons(station.getWeapons(),jpWeapon);
        
        //añado shields al panel
        addShields(station.getShieldBoosters(),jpShield);
        
        // añado hangar
        HangarToUI h = station.getHangar();
        addWeapons(h.getWeapons(),jpWeapon);
        addShields(h.getShieldBoosters(),jpShield);
    }
    
    private void addWeapons (ArrayList<WeaponToUI> weapons, javax.swing.JPanel p) {
        WeaponView weaponView;
        for (WeaponToUI w : weapons) {
            weaponView = new WeaponView();
            weaponView.setWeapon(w);
            p.add(weaponView);
        }
    }
    
     private void addShields (ArrayList<ShieldToUI> shields, javax.swing.JPanel p) {
        ShieldView shieldView;
        for (ShieldToUI s : shields) {
            shieldView = new ShieldView();
            shieldView.setShield(s);
            p.add(shieldView);
        }
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ammoPower = new javax.swing.JLabel();
        shieldPower = new javax.swing.JLabel();
        fuelUnits = new javax.swing.JLabel();
        nMedals = new javax.swing.JLabel();
        jpShield = new javax.swing.JPanel();
        jpWeapon = new javax.swing.JPanel();
        jpHangar = new javax.swing.JPanel();

        jLabel1.setText("Potencia de Ataque:");

        jLabel2.setText("Potencia de Defensa:");

        jLabel3.setText("Nivel de Combustible:");

        jLabel4.setText("Medallas:");

        ammoPower.setText("ap\n");

        shieldPower.setText("sp\n");

        fuelUnits.setText(String.valueOf(station.getFuelUnits()));

        nMedals.setText(String.valueOf(station.getnMedals()));

        jpShield.setBackground(new java.awt.Color(0, 242, 242));

        javax.swing.GroupLayout jpShieldLayout = new javax.swing.GroupLayout(jpShield);
        jpShield.setLayout(jpShieldLayout);
        jpShieldLayout.setHorizontalGroup(
            jpShieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jpShieldLayout.setVerticalGroup(
            jpShieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jpWeapon.setBackground(new java.awt.Color(242, 242, 0));

        javax.swing.GroupLayout jpWeaponLayout = new javax.swing.GroupLayout(jpWeapon);
        jpWeapon.setLayout(jpWeaponLayout);
        jpWeaponLayout.setHorizontalGroup(
            jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpWeaponLayout.setVerticalGroup(
            jpWeaponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jpHangar.setBackground(new java.awt.Color(53, 0, 53));

        javax.swing.GroupLayout jpHangarLayout = new javax.swing.GroupLayout(jpHangar);
        jpHangar.setLayout(jpHangarLayout);
        jpHangarLayout.setHorizontalGroup(
            jpHangarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jpHangarLayout.setVerticalGroup(
            jpHangarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(fuelUnits))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nMedals))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ammoPower, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(shieldPower, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpHangar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jpShield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpWeapon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ammoPower))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(shieldPower))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fuelUnits))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nMedals))
                .addGap(26, 26, 26)
                .addComponent(jpShield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jpWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jpHangar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammoPower;
    private javax.swing.JLabel fuelUnits;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpHangar;
    private javax.swing.JPanel jpShield;
    private javax.swing.JPanel jpWeapon;
    private javax.swing.JLabel nMedals;
    private javax.swing.JLabel shieldPower;
    // End of variables declaration//GEN-END:variables
}
