
package paquete1;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VentanaPrincipal extends javax.swing.JFrame {

    Color headsColor, bodyColor1, bodyColor2;
    int speed;
    boolean gridlines;
    
    public VentanaPrincipal() {
        initComponents();
        Icono();
        this.setLocationRelativeTo(null);
        botonPlay.requestFocus(true);
    }

    private void getData(){
        headsColor= fieldHeadColor.getBackground();
        bodyColor1= fieldBodyColor1.getBackground();
        bodyColor2= fieldBodyColor2.getBackground();
        gridlines= checkGridLines.isSelected();        
        speed= speed05.isSelected()?110:speed1.isSelected()?80:speed15.isSelected()?60:30;
        System.out.println(String.valueOf(speed)+headsColor.toString()+"\n"+bodyColor1.toString()+"\n"+bodyColor2.toString()+"\n"+gridlines);
    }
    
    public void Icono() {
        Image icon = new ImageIcon(getClass().getResource("/images/snake.png")).getImage();
        setIconImage(icon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        botonPlay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        colorOfHead = new javax.swing.JButton();
        fieldHeadColor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        fieldBodyColor1 = new javax.swing.JTextField();
        colorBody1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldBodyColor2 = new javax.swing.JTextField();
        colorBody2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        speed1 = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        checkGridLines = new javax.swing.JCheckBox();
        speed05 = new javax.swing.JCheckBox();
        speed15 = new javax.swing.JCheckBox();
        speed2 = new javax.swing.JCheckBox();

        buttonGroup.add(speed05);
        buttonGroup.add(speed1);
        buttonGroup.add(speed15);
        buttonGroup.add(speed2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(850, 650));
        setMinimumSize(new java.awt.Dimension(850, 650));
        setPreferredSize(new java.awt.Dimension(850, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        panelPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(600, 600));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(600, 600));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        botonPlay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonPlay.setText("Play");
        botonPlay.setFocusPainted(false);
        botonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPlayActionPerformed(evt);
            }
        });
        botonPlay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                botonPlayKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/snakegame.png"))); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Head's color:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, -1));

        colorOfHead.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        colorOfHead.setText("Choose");
        colorOfHead.setFocusPainted(false);
        colorOfHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorOfHeadActionPerformed(evt);
            }
        });
        jPanel2.add(colorOfHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, 25));

        fieldHeadColor.setEditable(false);
        fieldHeadColor.setBackground(new Color(0x004b23));
        jPanel2.add(fieldHeadColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 75, 25));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 160, 10));

        fieldBodyColor1.setEditable(false);
        fieldBodyColor1.setBackground(new Color(0x007200));
        jPanel2.add(fieldBodyColor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 75, 25));

        colorBody1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        colorBody1.setText("Choose");
        colorBody1.setFocusPainted(false);
        colorBody1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBody1ActionPerformed(evt);
            }
        });
        jPanel2.add(colorBody1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 80, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Body's color (1):");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, -1));

        fieldBodyColor2.setEditable(false);
        fieldBodyColor2.setBackground(new Color(0x38b000));
        jPanel2.add(fieldBodyColor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 75, 25));

        colorBody2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        colorBody2.setText("Choose");
        colorBody2.setFocusPainted(false);
        colorBody2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBody2ActionPerformed(evt);
            }
        });
        jPanel2.add(colorBody2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 80, 25));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, 160, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Snake's speed:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, -1));

        speed1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        speed1.setText("x1");
        speed1.setFocusPainted(false);
        speed1.setSelected(true);
        jPanel2.add(speed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 300, -1, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, 160, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Body's color (2):");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, -1));

        checkGridLines.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        checkGridLines.setText("Grid lines");
        checkGridLines.setFocusPainted(false);
        checkGridLines.setSelected(true);
        jPanel2.add(checkGridLines, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        speed05.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        speed05.setText("x0.5");
        speed05.setFocusPainted(false);
        jPanel2.add(speed05, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 275, -1, -1));

        speed15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        speed15.setText("x1.5");
        speed15.setFocusPainted(false);
        jPanel2.add(speed15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 275, -1, -1));

        speed2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        speed2.setText("x2");
        speed2.setFocusPainted(false);
        jPanel2.add(speed2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(botonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPlayActionPerformed
        panelPrincipal.removeAll();
        getData();
        panelDeJuego panel= new panelDeJuego(headsColor, bodyColor1, bodyColor2, speed, gridlines);
        panel.setBounds(0, 0, 600, 600);
        panelPrincipal.add(panel);
        repaint();
        revalidate();
        panel.requestFocus(true);
    }//GEN-LAST:event_botonPlayActionPerformed

    private void colorOfHeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorOfHeadActionPerformed
        Color color = JColorChooser.showDialog(null, "Choose the color of the snake's head", new Color(0x004b23));
        fieldHeadColor.setBackground(color);
    }//GEN-LAST:event_colorOfHeadActionPerformed

    private void colorBody1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBody1ActionPerformed
        Color color = JColorChooser.showDialog(null, "Choose the color of the snake's body 1", new Color(0x007200));
        fieldBodyColor1.setBackground(color);
    }//GEN-LAST:event_colorBody1ActionPerformed

    private void colorBody2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBody2ActionPerformed
        Color color = JColorChooser.showDialog(null, "Choose the color of the snake's body 2", new Color(0x38b000));
        fieldBodyColor2.setBackground(color);
    }//GEN-LAST:event_colorBody2ActionPerformed

    private void botonPlayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonPlayKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            panelPrincipal.removeAll();
            getData();
            panelDeJuego panel = new panelDeJuego(headsColor, bodyColor1, bodyColor2, speed, gridlines);
            panel.setBounds(0, 0, 600, 600);
            panelPrincipal.add(panel);
            repaint();
            revalidate();
            panel.requestFocus(true);
        }
    }//GEN-LAST:event_botonPlayKeyReleased

    private static void lookAndFeel() {
        Properties props = new Properties();
        GraphiteLookAndFeel.setCurrentTheme(props);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            lookAndFeel();
            new VentanaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPlay;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox checkGridLines;
    private javax.swing.JButton colorBody1;
    private javax.swing.JButton colorBody2;
    private javax.swing.JButton colorOfHead;
    private javax.swing.JTextField fieldBodyColor1;
    private javax.swing.JTextField fieldBodyColor2;
    private javax.swing.JTextField fieldHeadColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JCheckBox speed05;
    private javax.swing.JCheckBox speed1;
    private javax.swing.JCheckBox speed15;
    private javax.swing.JCheckBox speed2;
    // End of variables declaration//GEN-END:variables
}
