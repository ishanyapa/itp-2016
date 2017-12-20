/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement;

import RootElement.SessionHandler;
import WarehouseManagement.SupportedClasses.SetPanel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author ashanginige
 */
public class WarehouseMain extends javax.swing.JFrame {

    /**
     * Creates new form main_menu
     */
    public WarehouseMain() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        if(SessionHandler.getInsta()==null){
            btnHome.setVisible(false);
        }
        lbl_logged_user.setText(SessionHandler.getOccupation());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jpnl200 = new javax.swing.JPanel();
        lbl_sub_function_name = new javax.swing.JLabel();
        lbl_logged_user = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btn200 = new javax.swing.JButton();
        btn201 = new javax.swing.JButton();
        btn202 = new javax.swing.JButton();
        btn203 = new javax.swing.JButton();
        btn204 = new javax.swing.JButton();
        btn205 = new javax.swing.JButton();
        btn206 = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1024, 720));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnl200.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(jpnl200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 590));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 790, 590));

        lbl_sub_function_name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_sub_function_name.setForeground(new java.awt.Color(162, 167, 174));
        getContentPane().add(lbl_sub_function_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        lbl_logged_user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_logged_user.setForeground(new java.awt.Color(162, 167, 174));
        lbl_logged_user.setText("Warehouse Manager");
        getContentPane().add(lbl_logged_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_default.png"))); // NOI18N
        btn_logout.setBorderPainted(false);
        btn_logout.setContentAreaFilled(false);
        btn_logout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_hover.png"))); // NOI18N
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, -1, -1));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_default.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_hover.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 640, 100, 30));

        btn200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/finalProducts_default.png"))); // NOI18N
        btn200.setBorderPainted(false);
        btn200.setContentAreaFilled(false);
        btn200.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/finalProducts_rollOver.png"))); // NOI18N
        btn200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn200ActionPerformed(evt);
            }
        });
        getContentPane().add(btn200, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btn201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/rawMaterials_default.png"))); // NOI18N
        btn201.setBorderPainted(false);
        btn201.setContentAreaFilled(false);
        btn201.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/rawMaterials_rollOver.png"))); // NOI18N
        btn201.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn201ActionPerformed(evt);
            }
        });
        getContentPane().add(btn201, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        btn202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/reorderLevel_default.png"))); // NOI18N
        btn202.setBorderPainted(false);
        btn202.setContentAreaFilled(false);
        btn202.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/reorderLevel_rollOver.png"))); // NOI18N
        btn202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn202ActionPerformed(evt);
            }
        });
        getContentPane().add(btn202, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        btn203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/issueRawMaterials_default.png"))); // NOI18N
        btn203.setBorderPainted(false);
        btn203.setContentAreaFilled(false);
        btn203.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/issueRawMaterials_rollOver.png"))); // NOI18N
        btn203.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn203ActionPerformed(evt);
            }
        });
        getContentPane().add(btn203, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        btn204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/assignProducts_default.png"))); // NOI18N
        btn204.setBorderPainted(false);
        btn204.setContentAreaFilled(false);
        btn204.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/assignProducts_rollOver.png"))); // NOI18N
        btn204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn204ActionPerformed(evt);
            }
        });
        getContentPane().add(btn204, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        btn205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/issueGRN_default.png"))); // NOI18N
        btn205.setBorderPainted(false);
        btn205.setContentAreaFilled(false);
        btn205.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/issueGRN_rollOver.png"))); // NOI18N
        btn205.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn205ActionPerformed(evt);
            }
        });
        getContentPane().add(btn205, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        btn206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/generateReports_default.png"))); // NOI18N
        btn206.setBorderPainted(false);
        btn206.setContentAreaFilled(false);
        btn206.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/WarehouseManagement/generateReports_rollOver.png"))); // NOI18N
        btn206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn206ActionPerformed(evt);
            }
        });
        getContentPane().add(btn206, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warehouse_management.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn200ActionPerformed
        ManageFinalProducts obj1 = new ManageFinalProducts();
        SetPanel sp = new SetPanel();
        sp.SetPanel((Object)obj1, jpnl200);
        lbl_sub_function_name.setText("Final Products");
        
    }//GEN-LAST:event_btn200ActionPerformed

    private void btn202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn202ActionPerformed
        CheckReorderLevel obj1 = new CheckReorderLevel();
        SetPanel sp = new SetPanel();
        sp.SetPanel((Object)obj1, jpnl200);
        lbl_sub_function_name.setText("Check Reorder Levels");        
    }//GEN-LAST:event_btn202ActionPerformed

    private void btn201ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn201ActionPerformed
       ManageRawMaterials obj1 = new ManageRawMaterials();
       SetPanel sp = new SetPanel();
       sp.SetPanel((Object)obj1, jpnl200);
       lbl_sub_function_name.setText("Raw Materials");
    }//GEN-LAST:event_btn201ActionPerformed

    private void btn203ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn203ActionPerformed
        IssueRawMaterials obj1 = new IssueRawMaterials();
        SetPanel sp = new SetPanel();
        sp.SetPanel((Object)obj1, jpnl200);
        lbl_sub_function_name.setText("Issue Raw Materials");
    }//GEN-LAST:event_btn203ActionPerformed

    private void btn204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn204ActionPerformed
        IssueFinishedProducts obj1 = new IssueFinishedProducts();
        SetPanel sp = new SetPanel();
        sp.SetPanel((Object)obj1, jpnl200);
        lbl_sub_function_name.setText("Assign Products");
    }//GEN-LAST:event_btn204ActionPerformed

    private void btn205ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn205ActionPerformed
        IssueGRN obj1 = new IssueGRN();
        SetPanel sp = new SetPanel();
        sp.SetPanel((Object)obj1, jpnl200);
        lbl_sub_function_name.setText("Issue GRN");
    }//GEN-LAST:event_btn205ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        SessionHandler.getInsta().getRootPane().getGlassPane().setVisible(false);
        SessionHandler.getInsta().setEnabled(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
      int option=JOptionPane.showConfirmDialog(this,"Do you want to logout ?");
      if(option==JOptionPane.YES_OPTION){
          this.dispose();
          SessionHandler.Dispose();
      }
      else{
            
        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn206ActionPerformed
        GenerateReports obj1 = new GenerateReports();
        SetPanel sp = new SetPanel();
        sp.SetPanel((Object)obj1, jpnl200);
        lbl_sub_function_name.setText("Generate Reports");
    }//GEN-LAST:event_btn206ActionPerformed

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
            java.util.logging.Logger.getLogger(WarehouseMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WarehouseMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WarehouseMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WarehouseMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                new WarehouseMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn200;
    private javax.swing.JButton btn201;
    private javax.swing.JButton btn202;
    private javax.swing.JButton btn203;
    private javax.swing.JButton btn204;
    private javax.swing.JButton btn205;
    private javax.swing.JButton btn206;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btn_logout;
    private javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JPanel jpnl200;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lbl_logged_user;
    private javax.swing.JLabel lbl_sub_function_name;
    // End of variables declaration//GEN-END:variables
}
