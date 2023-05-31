/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.UI;
import deepspace.HangarToUI;
import deepspace.ShieldToUI;
import deepspace.SpaceStationToUI;
import deepspace.WeaponToUI;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;

/**
 *
 * @author mario
 */
public class SpaceStationView extends javax.swing.JPanel {
    
	HangarView hangarView;
	
    /**
     * Creates new form SpaceStationView
     */
    public SpaceStationView() {
		this.setSize(775,700);
        initComponents();
		
		hangarView = new HangarView();
		jpHangar.add(hangarView);
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
        addShields(station.getShieldBoosters(),jPShields);
        
        // añado hangar
        HangarToUI h = station.getHangar();
		hangarView.setHangar(h);
		
		if (h == null){
			jpHangar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "SIN HANGAR"));
		} else {
			jpHangar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Hangar con " + h.getMaxElements() + " elementos"));
		}
        
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
	 
	ArrayList<Integer> getHangarSelectedWeapons (){
        return (hangarView.getSelectedWeapons());
	}
	
	ArrayList<Integer> getHangarSelectedShields (){
        return (hangarView.getSelectedShields());
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPendingDamage = new javax.swing.JPanel();
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
        jPShields = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpHangar = new javax.swing.JPanel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(790, 700));

        jPPendingDamage.setBorder(javax.swing.BorderFactory.createTitledBorder("Castigo Pendiente"));

        javax.swing.GroupLayout jPPendingDamageLayout = new javax.swing.GroupLayout(jPPendingDamage);
        jPPendingDamage.setLayout(jPPendingDamageLayout);
        jPPendingDamageLayout.setHorizontalGroup(
            jPPendingDamageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPPendingDamageLayout.setVerticalGroup(
            jPPendingDamageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        jPShields.setBorder(javax.swing.BorderFactory.createTitledBorder("Potenciadores de Defensa"));
        jPShields.setOpaque(false);
        jScrollShields.setViewportView(jPShields);

        jpHangar.setBorder(javax.swing.BorderFactory.createTitledBorder("Hangar con X lugares"));
        jpHangar.setOpaque(false);
        jScrollPane1.setViewportView(jpHangar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollShields, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                            .addComponent(jScrollWeapons))
                        .addContainerGap())
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
                                            .addComponent(shieldPower, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(44, 44, 44)
                                .addComponent(jPPendingDamage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLStationName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLStationName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                    .addComponent(jPPendingDamage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollWeapons, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollShields, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ammoPower;
    private javax.swing.JLabel fuelUnits;
    private javax.swing.JLabel jLStationName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPPendingDamage;
    private javax.swing.JPanel jPShields;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollShields;
    private javax.swing.JScrollPane jScrollWeapons;
    private javax.swing.JPanel jpHangar;
    private javax.swing.JPanel jpWeapons;
    private javax.swing.JLabel nMedals;
    private javax.swing.JLabel shieldPower;
    // End of variables declaration//GEN-END:variables
}
