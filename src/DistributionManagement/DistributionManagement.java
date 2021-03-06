/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;

import RootElement.SessionHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author ashanginige
 */
public class DistributionManagement extends javax.swing.JFrame {

    /**
     * Creates new form main_menu
     */
    public DistributionManagement() {
        initComponents();
        if(SessionHandler.getInsta()==null){
            jButton2.setVisible(false);
        }
        lbl_logged_user.setText(SessionHandler.getOccupation());
        this.setLocationRelativeTo(null);
        
        Notifications n1 = new Notifications();
        SetPanel pq = new SetPanel();
        pq.SetPanel(n1, jpnl101);
        lbl100.setText("Notifications");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnl101 = new javax.swing.JPanel();
        lbl100 = new javax.swing.JLabel();
        lbl_logged_user = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1024, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnl101.setBackground(new java.awt.Color(255, 255, 255));
        jpnl101.setMaximumSize(new java.awt.Dimension(790, 590));
        jpnl101.setMinimumSize(new java.awt.Dimension(790, 590));
        jpnl101.setPreferredSize(new java.awt.Dimension(790, 590));
        getContentPane().add(jpnl101, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        lbl100.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl100.setForeground(new java.awt.Color(162, 167, 174));
        getContentPane().add(lbl100, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 320, 40));

        lbl_logged_user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_logged_user.setForeground(new java.awt.Color(162, 167, 174));
        lbl_logged_user.setText("Distribution Manager");
        getContentPane().add(lbl_logged_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 200, 30));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/logout_default.png"))); // NOI18N
        btn_logout.setBorderPainted(false);
        btn_logout.setContentAreaFilled(false);
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/logout_hover.png"))); // NOI18N
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/home_default.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/home_hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 640, 100, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/schedules_default.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/schedules_rollOver.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/assignVehicle_default.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/assignVehicle_rollOver.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/manageVehicleDetails_default_1.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/manageVehicleDetails_rollOver.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 190, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/issueGatePass_default.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/issueGatePass_rollOver.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/generateReports_default.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/generateReports_rollOver.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 30));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/driverDetails_default.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/driverDetails_rollOver.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Distribution/images/Distribution_Main_Layout.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1100, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       lbl100.setText("Manage Vehicle Details");
         ManageVehicles pane1 = new ManageVehicles();
         
         SetPanel p1= new SetPanel();
         p1.SetPanel(pane1, jpnl101);
         
        /* jpnl101.removeAll();
         jpnl101.repaint();
         jpnl101.revalidate();
         
         
         
         jpnl101.add(pane1);
         jpnl101.repaint();
         jpnl101.revalidate();
         
         */
      
         
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         // TODO add your handling code here:
           lbl100.setText("Delivery Schedules");
           
         DaySchedule del1 = new DaySchedule();
        
         SetPanel p1=new SetPanel();
        
         p1.SetPanel(del1, jpnl101);
         
         
           // lbl_sub_function_name.setText("Delivery Schedules");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
      lbl100.setText("Assign Vehicle");
      AssignVehicle v = new AssignVehicle();
      
      SetPanel p2 = new SetPanel();
      p2.SetPanel(v, jpnl101);
      
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        lbl100.setText("Issue Gate-Pass");
        GatePass pass=new GatePass();
        
        SetPanel p1=new SetPanel();
        p1.SetPanel(pass, jpnl101);
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    
        // TODO add your handling code here:
        lbl100.setText("Reports");
        
         ReportGeneration pass=new ReportGeneration();
        
        SetPanel r1=new SetPanel();
        r1.SetPanel(pass, jpnl101);
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        lbl100.setText("Driver Details");
        DriverDetails d = new DriverDetails();
        
        SetPanel p3 = new SetPanel();
        p3.SetPanel(d, jpnl101);
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        SessionHandler.getInsta().getRootPane().getGlassPane().setVisible(false);
        SessionHandler.getInsta().setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int option=JOptionPane.showConfirmDialog(this,"Do you want to logout ?");
      if(option==JOptionPane.YES_OPTION){
          this.dispose();
          SessionHandler.Dispose();
      }
    }//GEN-LAST:event_btn_logoutActionPerformed

    
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
            java.util.logging.Logger.getLogger(DistributionManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DistributionManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DistributionManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DistributionManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
              try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DistributionManagement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DistributionManagement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DistributionManagement.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(DistributionManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
               
                new DistributionManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpnl101;
    private javax.swing.JLabel lbl100;
    private javax.swing.JLabel lbl_logged_user;
    // End of variables declaration//GEN-END:variables
}
