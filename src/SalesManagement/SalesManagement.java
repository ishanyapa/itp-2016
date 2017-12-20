/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

import RootElement.SalesDBConnect;
import RootElement.SessionHandler;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author ashanginige
 */
public class SalesManagement extends javax.swing.JFrame {

    /**
     * Creates new form main_menu
     */
    public SalesManagement() {
        initComponents();
        
        //this.setLocationRelativeTo(null);
        if(SessionHandler.getInsta()==null){
            jButton2.setVisible(false);
        }
        lbl_logged_user.setText(SessionHandler.getOccupation());
    }
    
    
    
    SalesManagement(String filename, Map param) {
      
    
       try {
            //db connection using the db class
											
            
           
            JasperPrint print=JasperFillManager.fillReport(filename,param,SalesDBConnect.connect());//dbc.con is the connection variable in the coonnection class
            JRViewer viewer=new JRViewer(print);
            
            Container c=getContentPane();
            c.add(viewer);
            
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       
       setBounds(10,10,1000,500);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
	

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_sub_function_name = new javax.swing.JLabel();
        lbl_logged_user = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(790, 590));
        jPanel1.setMinimumSize(new java.awt.Dimension(790, 590));
        jPanel1.setPreferredSize(new java.awt.Dimension(790, 590));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 780, 590));

        lbl_sub_function_name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_sub_function_name.setForeground(new java.awt.Color(162, 167, 174));
        getContentPane().add(lbl_sub_function_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 230, 40));

        lbl_logged_user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_logged_user.setForeground(new java.awt.Color(162, 167, 174));
        lbl_logged_user.setText("Sales Manager");
        getContentPane().add(lbl_logged_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_default.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_hover.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 640, 100, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/invoiceGeneration_default.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/invoiceGeneration_rollOver.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/customerManagement_default.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/customerManagement_rollOver.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/orderManagement_default.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/orderManagement_rollOver.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/priceModification_default.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salesManagement/priceModification_rollOver.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sales_Main_Layout.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(790, 590));
        jLabel1.setMinimumSize(new java.awt.Dimension(790, 590));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1020, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         lbl_sub_function_name.setText("Customer Management");
       
         CustomerManagement  m1= new CustomerManagement();
         SetPanel p1 = new SetPanel();
         p1.SetPanel(m1, jPanel1);
        
         
         
      
         
          
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        lbl_sub_function_name.setText("Invoice Generation");
        InvoiceGeneration pane2 = new InvoiceGeneration();
         
        jPanel1.removeAll();
        jPanel1.repaint();
        jPanel1.revalidate();
         
         
         
        jPanel1.add(pane2);
        jPanel1.repaint();
        jPanel1.revalidate();
         
         
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        lbl_sub_function_name.setText("Order Management");
        OrderManagement  o1= new OrderManagement();
        SetPanel p1 = new SetPanel();
        p1.SetPanel(o1, jPanel1);
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        lbl_sub_function_name.setText("Price Modification");
        PriceModification  p1= new PriceModification();
        SetPanel p2 = new SetPanel();
        p2.SetPanel(p1, jPanel1);
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
      else{
            
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_logged_user;
    private javax.swing.JLabel lbl_sub_function_name;
    // End of variables declaration//GEN-END:variables
}
