/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shali
 */
public class AssignVehicle extends javax.swing.JPanel {

    /**
     * Creates new form AssignVehicle
     */
    public AssignVehicle() {
        initComponents();
        
        btngrp100.add(rbtn1);
        btngrp100.add(rbtn2);
               
        
        
       
        SQL del= new SQL();
        del.incID(txtf125,"delivery", "deliveryId",'D');
        
        
       
        jButton101.setEnabled(false);
        
        
        //Load Route
        
        SQL rout = new SQL();
        rout.fillComboBox(cmb110, "schedule", "routeNo");
        
        //Load Emp
        SQL em=new SQL();
        em.DistDiv(ccmb178);
       
        //
       
    
        //d.incID(txtf125,"delivery","deliveryId",'D');
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrp100 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable100 = new javax.swing.JTable();
        jLabel111 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb179 = new javax.swing.JComboBox<>();
        jDateChooser104 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb110 = new javax.swing.JComboBox<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField145 = new javax.swing.JTextField();
        err190 = new javax.swing.JLabel();
        rbtn1 = new javax.swing.JRadioButton();
        rbtn2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel145 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtf125 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton101 = new javax.swing.JButton();
        hiddenInvoice = new javax.swing.JLabel();
        hiddenWeight = new javax.swing.JLabel();
        ccmb178 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 590));

        jTable100.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Number", "Weight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable100);
        if (jTable100.getColumnModel().getColumnCount() > 0) {
            jTable100.getColumnModel().getColumn(0).setResizable(false);
            jTable100.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel111.setText("0");

        jLabel5.setText("Vehicle ");

        cmb179.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb179ActionPerformed(evt);
            }
        });

        jLabel6.setText("Date  ");

        jLabel7.setText("Route Number ");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Details"));

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Invoice Number ");

        jTextField145.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField145FocusLost(evt);
            }
        });
        jTextField145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField145ActionPerformed(evt);
            }
        });
        jTextField145.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField145KeyReleased(evt);
            }
        });

        err190.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        err190.setForeground(new java.awt.Color(255, 0, 0));

        rbtn1.setBackground(new java.awt.Color(255, 255, 255));
        rbtn1.setText("Small Scale");

        rbtn2.setBackground(new java.awt.Color(255, 255, 255));
        rbtn2.setText("Large Scale");

        jLayeredPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField145, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(err190, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(rbtn1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(rbtn2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(rbtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn2))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(err190, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn1)
                    .addComponent(rbtn2))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(err190, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jButton2.setText("Assign Delivery");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel145.setForeground(new java.awt.Color(51, 255, 0));
        jLabel145.setText("0 Invoice(s)");

        jLabel4.setText("Delivery ID");

        txtf125.setEnabled(false);

        jLabel8.setText("Employee ID");

        jButton101.setText("Assign Vehicle");
        jButton101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton101ActionPerformed(evt);
            }
        });

        hiddenInvoice.setForeground(new java.awt.Color(255, 255, 255));
        hiddenInvoice.setText("..");

        hiddenWeight.setForeground(new java.awt.Color(255, 255, 255));
        hiddenWeight.setText("..");

        ccmb178.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccmb178ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Weight");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(txtf125, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(hiddenInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(hiddenWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel145)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(57, 57, 57)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ccmb178, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb179, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(528, 528, 528))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb110, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hiddenInvoice)
                            .addComponent(hiddenWeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel145)
                            .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(cmb179, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton101)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtf125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmb110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ccmb178, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        SetPanel p1 = new SetPanel();
        AssignVehicle as= new AssignVehicle();
        p1.SetPanel(as);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
          
        
         
        
        if((jTextField145.getText().isEmpty())||(cmb179.getSelectedIndex()==-1)||(jDateChooser104.getDate()==null)||(txtf125.getText()==null)||(cmb110.getSelectedIndex()==-1)||(ccmb178.getSelectedIndex()==-1))
            {
                
                
                
                JOptionPane.showMessageDialog(null,"One or more fields are empty","Warning",JOptionPane.ERROR_MESSAGE);
                   
            }
        
            else 
               {
                   
                   
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
         Date dateq = new Date();
         
     
        String date1 = dateFormat.format(jDateChooser104.getDate());
        
        
        String today = dateFormat.format(dateq);
        
        try{   
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(today);
            
            
                if(d1.after(d2))
                {
                 JOptionPane.showMessageDialog(null,"Invalid Date","Warning",JOptionPane.ERROR_MESSAGE);
                 
                }
                else 
                {
                SQL ass= new SQL();
                     ass.AssignVeh(txtf125, cmb179, jDateChooser104, cmb110, ccmb178, jLabel111);
                   JOptionPane.showMessageDialog(null, "Please assign a vehicle for the above delivery", "Delivery Notice!", JOptionPane.INFORMATION_MESSAGE);

                   
               jButton101.setEnabled(true);
                jButton2.setEnabled(false);
                
                }
              }
        catch (Exception i)
        {
        
        }
                     
                }
                      
                
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmb179ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb179ActionPerformed
        // TODO add your handling code here:
          double w ;//= Double.valueOf(jLabel111.getText());
        w=Double.valueOf(jLabel111.getText());
        
       // SQL l2 = new SQL();
       // l2.availableVehi(cmb179,"vehicle","vehicleNo",w);
        
        
        
        
    }//GEN-LAST:event_cmb179ActionPerformed

    private void jButton101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton101ActionPerformed
        // TODO add your handling code here:
        
      
        
             SQL inv= new SQL();
             
             
              for (int i = 0; i < jTable100.getRowCount(); i++)
    {
        String invo = (String) jTable100.getValueAt(i,0);
       
        System.out.println("Invoices "+invo);
        inv.AddInvoiceDeli(invo,txtf125);
        
        
           
       
    }
             
              JOptionPane.showMessageDialog(null, "Vehicle Successfuly added", "Delivery Notice!", JOptionPane.INFORMATION_MESSAGE);

             
             
             
             
            
        
            AssignVehicle as= new AssignVehicle();
            SetPanel p1= new SetPanel();
            p1.SetPanel(as);
                        
        
        
    }//GEN-LAST:event_jButton101ActionPerformed

    private void jTextField145KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField145KeyReleased
        // TODO add your handling code here:

  /*      if(rbtn1.isSelected())
        {
            SQL EiD= new SQL();
            EiD.GetEmployeeID(txt123,jTextField145);//Small Scale oreder

        }
        else if(rbtn2.isSelected())
        {

            SQL LEiD= new SQL();
            LEiD.GetEmployeeIDLarge(txt123,jTextField145);

        }
*/
    }//GEN-LAST:event_jTextField145KeyReleased

    private void jTextField145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField145ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField145ActionPerformed

    private void jTextField145FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField145FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField145FocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String selectedObject = (String) (Object) jTable100.getModel().getValueAt(jTable100.getSelectedRow(),jTable100.getSelectedColumn());

        System.out.println(selectedObject);

        RemoveFromTable(jTable100.getSelectedRow(),jTable100);
        
        jLabel145.setText(String.valueOf(jTable100.getRowCount())+" Invoices Added ");
        
         AddWeight(jLabel111, jTable100);
 
         double w ;//= Double.valueOf(jLabel111.getText());
        w=Double.valueOf(jLabel111.getText());
        
        cmb179.removeAllItems();

        SQL l2 = new SQL();
        l2.availableVehi(cmb179,"vehicle","vehicleNo",w);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        /*  TextValidator tv1 = new TextValidator(txtF106.getText());
        tv1.checkEmpty(err107);
        */
 
        cmb179.removeAllItems();

        if(jTextField145.getText().isEmpty())
        {

            err190.setText(" !");

        }

        else
        {
               err190.setText(null);
            
            
               if(rbtn1.isSelected())
             {

            SQL ch = new SQL();
            if(ch.CheckifExists(jTextField145,"smallordergoodinvoice","invoiceNo"))
            {
            
             JOptionPane.showMessageDialog(null, "Invalid Invoice Number", "Error!", JOptionPane.ERROR_MESSAGE);

            }
            
            else{
            
                 SQL small=new SQL();
                small.getFinalWeight(jTextField145,jTable100,hiddenInvoice,hiddenWeight,"getItemWeightSmallScale");
                //JOptionPane.showMessageDialog(null, "valid Invoice Number", "Error!", JOptionPane.ERROR_MESSAGE);
          AddToTable(hiddenInvoice,hiddenWeight, jTable100, jLabel145);
          AddWeight(jLabel111, jTable100);

            
            }
            
           
            }

        else if (rbtn2.isSelected())
        {
            SQL ch1= new SQL();
            SQL large=new SQL();
            if(ch1.CheckifExists(jTextField145,"largeordergoodinvoice","invoiceNo"))
            {
            
             JOptionPane.showMessageDialog(null, "Invalid Invoice Number", "Error!", JOptionPane.ERROR_MESSAGE);

            }
            else{
           
                large.getFinalWeight(jTextField145,jTable100,hiddenInvoice,hiddenWeight,"getItemWeightLargeScale");
                //JOptionPane.showMessageDialog(null, "valid Invoice Number", "Error!", JOptionPane.ERROR_MESSAGE);
          AddToTable(hiddenInvoice,hiddenWeight, jTable100, jLabel145);
          AddWeight(jLabel111, jTable100);

                            }   
            
     
         
        
                 }
         
        
        }
        
        //int weight= Integer.parseInt(jLabel111.getText());
        
        
         double w ;//= Double.valueOf(jLabel111.getText());
        w=Double.valueOf(jLabel111.getText());
        
        cmb179.removeAllItems();

        SQL l2 = new SQL();
        l2.availableVehi(cmb179,"vehicle","vehicleNo",w);
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ccmb178ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccmb178ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccmb178ActionPerformed

    //Add Item Details to the Table 
    
     public void AddToTable(JLabel inv,JLabel weigh,JTable tab,JLabel count)
    {   
        
        
        String invoiceNumber=inv.getText();
        int weight=Integer.parseInt(weigh.getText());
        
        
     
      
        //System.out.println(item + " "+ weight);
        Object in[]={invoiceNumber,weight};
        
        DefaultTableModel model = (DefaultTableModel) tab.getModel();

        model.addRow(in);
        count.setText(model.getRowCount()+" Invoices Added");
        
               
        
    
      
  }

     //Calculate Total Weight
   public void AddWeight(JLabel j,JTable tab)
    {
    int total = 0;
    
        /*System.out.println(jTable1.getRowCount());
        System.out.println(jTable1.getValueAt(1,2));*/
   
    for (int i = 0; i < tab.getRowCount(); i++)
    {
        //int amount = Integer.parseInt((String) jTable100.getValueAt(i, 2));
        int amount = (int) tab.getValueAt(i, 1);
        
        total += amount;
    }
   // System.out.println(total);
    j.setText(Integer.toString(total));
    
    
    }
 
    
     public void RemoveFromTable(int i, JTable t)
    {
    
    DefaultTableModel model = (DefaultTableModel) t.getModel();

    model.removeRow(i);
    
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngrp100;
    private javax.swing.JComboBox<String> ccmb178;
    private javax.swing.JComboBox<String> cmb110;
    private javax.swing.JComboBox<String> cmb179;
    private javax.swing.JLabel err190;
    private javax.swing.JLabel hiddenInvoice;
    private javax.swing.JLabel hiddenWeight;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser104;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable100;
    private javax.swing.JTextField jTextField145;
    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JTextField txtf125;
    // End of variables declaration//GEN-END:variables
}
