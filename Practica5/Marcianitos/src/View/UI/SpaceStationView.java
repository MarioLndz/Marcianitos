/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.UI;
import controller.Controller;
import deepspace.GameState;
import deepspace.HangarToUI;
import deepspace.ShieldToUI;
import deepspace.SpaceStationToUI;
import deepspace.WeaponToUI;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author mario
 */
public class SpaceStationView extends javax.swing.JPanel {
        DamageView damageView;
	HangarView hangarView;
	
    /**
     * Creates new form SpaceStationView
     */
    public SpaceStationView() {
	this.setSize(775,650);
        initComponents();
		
        repaint();
        revalidate();
    }

    void setSpaceStation(SpaceStationToUI station) {
        jLStationName.setText(station.getName());
	ammoPower.setText(String.valueOf(station.getAmmoPower()));
        shieldPower.setText(String.valueOf(station.getShieldPower()));
        nMedals.setText(String.valueOf(station.getnMedals()));
        fuelUnits.setText(String.valueOf(station.getFuelUnits()));
        
        // añado weapons al panel
        addWeapons(station.getWeapons(),jpWeapons);
        
        //añado shields al panel
        addShields(station.getShieldBoosters(),jpShields);
        
        // añado hangar
        hangarView = new HangarView();
        HangarToUI h = station.getHangar();
        hangarView.setHangar(h);
        jpHangar.add(hangarView);

        if (h == null){
            jpHangar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "SIN HANGAR"));
        } else {
            jpHangar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Hangar con " + h.getMaxElements() + " elementos"));
        }
        
        // añado pendingDamage
        damageView = new DamageView();
        damageView.setDamage(station.getPendingDamage());
        jpPendingDamage.add(damageView);
        
        enabledButtons(station);
        
        repaint();
        revalidate();
    }
    
    private void addWeapons (ArrayList<WeaponToUI> weapons, javax.swing.JPanel p) {
        p.removeAll();
        WeaponView weaponView;
        for (WeaponToUI w : weapons) {
            weaponView = new WeaponView();
            weaponView.setWeapon(w);
            p.add(weaponView);
        }
    }
    
     private void addShields (ArrayList<ShieldToUI> shields, javax.swing.JPanel p) {
        p.removeAll();
        ShieldView shieldView;
        for (ShieldToUI s : shields) {
            shieldView = new ShieldView();
            shieldView.setShield(s);
            p.add(shieldView);
        }
     }
	 
    ArrayList<Integer> getHangarSelectedWeapons (){
        return (hangarView.getSelectedWeapons());
    }

    ArrayList<Integer> getHangarSelectedShields (){
        return (hangarView.getSelectedShields());
    }
    
    ArrayList<Integer> getSelectedWeaponsMounted(){
        ArrayList<Integer> selectedWeaponsMounted = new ArrayList<>();
        
        int i = 0;
        for (Component c : jpWeapons.getComponents()) {
            if (((WeaponView) c).isSelected()) {
                selectedWeaponsMounted.add(i);
            }
            i++;
        }
        
        return selectedWeaponsMounted;
    }
    
    ArrayList<Integer> getSelectedShieldsMounted(){
        ArrayList<Integer> selectedShieldsMounted = new ArrayList<>();
        
        int i = 0;
        for (Component c : jpShields.getComponents()) {
            if (((ShieldView) c).isSelected()) {
                selectedShieldsMounted.add(i);
            }
            i++;
        }
        
        return selectedShieldsMounted;
    }
    
    void enabledButtons(SpaceStationToUI station){
        boolean hangarAvaiable = station.getHangar() != null;
        boolean shieldsInHangar = false;
        boolean weaponsInHangar = false;
        boolean elementsInHangar = false;
        if(hangarAvaiable){
            weaponsInHangar = (station.getHangar().getWeapons().size() != 0);
            shieldsInHangar = (station.getHangar().getShieldBoosters().size() != 0);
            
            elementsInHangar = weaponsInHangar || shieldsInHangar;
        }
        boolean weaponsMounted = station.getWeapons().size() != 0;
        boolean shieldsMounted = station.getShieldBoosters().size() != 0;
        
        GameState gameState = Controller.getInstance().getState();
        boolean init = gameState == GameState.INIT;
        boolean aftercombat = gameState == GameState.AFTERCOMBAT;
        
        discardHangarButton.setEnabled(hangarAvaiable && (init  || aftercombat));
        mountButton.setEnabled(hangarAvaiable && elementsInHangar && (init  || aftercombat));
        discardButton.setEnabled((elementsInHangar || weaponsMounted || shieldsMounted) && (init  || aftercombat));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPendingDamage = new javax.swing.JPanel();
        jLStationName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ammoPower = new javax.swing.JLabel();
        shieldPower = new javax.swing.JLabel();
        fuelUnits = new javax.swing.JLabel();
        nMedals = new javax.swing.JLabel();
        jScrollWeapons = new javax.swing.JScrollPane();
        jpWeapons = new javax.swing.JPanel();
        jScrollShields = new javax.swing.JScrollPane();
        jpShields = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpHangar = new javax.swing.JPanel();
        mountButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        discardHangarButton = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(790, 650));

        jpPendingDamage.setBorder(javax.swing.BorderFactory.createTitledBorder("Castigo Pendiente"));

        javax.swing.GroupLayout jpPendingDamageLayout = new javax.swing.GroupLayout(jpPendingDamage);
        jpPendingDamage.setLayout(jpPendingDamageLayout);
        jpPendingDamageLayout.setHorizontalGroup(
            jpPendingDamageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        jpPendingDamageLayout.setVerticalGroup(
            jpPendingDamageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        jLStationName.setBackground(new java.awt.Color(186, 186, 186));
        jLStationName.setFont(jLStationName.getFont().deriveFont(jLStationName.getFont().getStyle() | java.awt.Font.BOLD, jLStationName.getFont().getSize()+7));
        jLStationName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLStationName.setText("NombreEstacion");
        jLStationName.setOpaque(true);

        jLabel1.setText("Potencia de Ataque:");

        jLabel2.setText("Potencia de Defensa:");

        jLabel3.setText("Nivel de Combustible:");

        jLabel4.setText("Medallas:");

        ammoPower.setText("ap\n");

        shieldPower.setText("sp\n");

        fuelUnits.setText("f");

        nMedals.setText("medals\n");

        jpWeapons.setBorder(javax.swing.BorderFactory.createTitledBorder("Potenciadores de Fuego"));
        jpWeapons.setOpaque(false);
        jScrollWeapons.setViewportView(jpWeapons);

        jpShields.setBorder(javax.swing.BorderFactory.createTitledBorder("Potenciadores de Defensa"));
        jpShields.setOpaque(false);
        jScrollShields.setViewportView(jpShields);

        jpHangar.setBorder(javax.swing.BorderFactory.createTitledBorder("Hangar con X lugares"));
        jpHangar.setOpaque(false);
        jScrollPane1.setViewportView(jpHangar);

        mountButton.setText("Equipar");
        mountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mountButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Descartar");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        discardHangarButton.setText("Descartar Hangar Completo");
        discardHangarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardHangarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollShields, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                    .addComponent(jScrollWeapons, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(87, 87, 87)
                                        .addComponent(nMedals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(fuelUnits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ammoPower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(shieldPower, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLStationName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jpPendingDamage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(mountButton)
                .addGap(54, 54, 54)
                .addComponent(discardButton)
                .addGap(58, 58, 58)
                .addComponent(discardHangarButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLStationName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ammoPower))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(shieldPower))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fuelUnits))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nMedals)))
                    .addComponent(jpPendingDamage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollWeapons, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollShields, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mountButton)
                    .addComponent(discardButton)
                    .addComponent(discardHangarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mountButtonActionPerformed
        ArrayList<Integer> weaponsSelected = new ArrayList<>();
        ArrayList<Integer> shieldsSelected = new ArrayList<>();
        
        weaponsSelected = hangarView.getSelectedWeapons();
        shieldsSelected = hangarView.getSelectedShields();
        Controller.getInstance().mount(weaponsSelected, shieldsSelected);
        
        MainWindow.getInstance().updateView();
    }//GEN-LAST:event_mountButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList<Integer> weaponsMountedSelected = getSelectedWeaponsMounted();
        ArrayList<Integer> shieldsMountedSelected = getSelectedShieldsMounted();
        
        ArrayList<Integer> weaponsSelectedInHangar = new ArrayList<>();
        ArrayList<Integer> shieldsSelectedInHangar = new ArrayList<>();
        
        Controller.getInstance().discard(Controller.WEAPON, weaponsMountedSelected, shieldsMountedSelected);
        Controller.getInstance().discard(Controller.SHIELD, weaponsMountedSelected, shieldsMountedSelected);
        
        if(hangarView.isVisible()){ // no hangar nulo
            weaponsSelectedInHangar = hangarView.getSelectedWeapons();
            shieldsSelectedInHangar = hangarView.getSelectedShields();
            Controller.getInstance().discard(Controller.HANGAR, weaponsSelectedInHangar, shieldsSelectedInHangar);
        }
        
        MainWindow.getInstance().updateView();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void discardHangarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardHangarButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Hangar Completo Descartado!!!", MainWindow.getInstance().getAppName(), JOptionPane.INFORMATION_MESSAGE);
        Controller.getInstance().discardHangar();
        
        MainWindow.getInstance().updateView();
    }//GEN-LAST:event_discardHangarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammoPower;
    private javax.swing.JButton discardButton;
    private javax.swing.JButton discardHangarButton;
    private javax.swing.JLabel fuelUnits;
    private javax.swing.JLabel jLStationName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollShields;
    private javax.swing.JScrollPane jScrollWeapons;
    private javax.swing.JPanel jpHangar;
    private javax.swing.JPanel jpPendingDamage;
    private javax.swing.JPanel jpShields;
    private javax.swing.JPanel jpWeapons;
    private javax.swing.JButton mountButton;
    private javax.swing.JLabel nMedals;
    private javax.swing.JLabel shieldPower;
    // End of variables declaration//GEN-END:variables
}
