/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class assets extends javax.swing.JPanel {

    /**
     
     */
    public assets() {
        initComponents();
       
       // lbl486.setVisible(false);
        
     //set enable
      btn471.setEnabled(false);
       jButton6.setEnabled(false);
       txtF460.setEnabled(false);
        
        String sqlVehicle = "select vehicleNo,model,type,department,location from vehicle";
        String sqlPlant = "select plantId,plantName,address from plant";
        String sqlMachine = "select machineId,location,purchaseDate,type from machinery";
        String sqlTechnicion = "select employeeId,name,telephoneMob from employee where jobId = 'JB011'";
        TechnicalServiceDbAcess obtViewAssets =new  TechnicalServiceDbAcess();
        obtViewAssets.fillTable(tbl460, sqlVehicle);
        obtViewAssets.fillTable(tbl461, sqlPlant);
        obtViewAssets.fillTable(tbl463, sqlMachine);
        obtViewAssets.fillTable(tbl462, sqlTechnicion);
        
        //add buttn to button group
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        buttonGroup1.add(jRadioButton5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtF463 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl463 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtF471 = new javax.swing.JTextField();
        txtF472 = new javax.swing.JTextField();
        btn471 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtF474 = new javax.swing.JTextField();
        jdate474 = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtF462 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl462 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl461 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtF460 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl460 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));
        setName("lbl460"); // NOI18N
        setPreferredSize(new java.awt.Dimension(790, 590));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setVerifyInputWhenFocusTarget(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Machine ID / Location / type / purchaseDate");
        jLabel5.setName("lbl463"); // NOI18N

        txtF463.setName("txtF463"); // NOI18N
        txtF463.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF463ActionPerformed(evt);
            }
        });
        txtF463.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF463KeyReleased(evt);
            }
        });

        tbl463.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Machine ID", "location", "purchaseDate", "type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl463.setName("tbl463"); // NOI18N
        tbl463.setRowHeight(25);
        tbl463.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl463MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl463);
        if (tbl463.getColumnModel().getColumnCount() > 0) {
            tbl463.getColumnModel().getColumn(0).setResizable(false);
            tbl463.getColumnModel().getColumn(1).setResizable(false);
            tbl463.getColumnModel().getColumn(2).setResizable(false);
            tbl463.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton5.setText("Add Machine");
        jButton5.setName("btn467"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setName("jpnl460"); // NOI18N

        jLabel7.setText("Machine ID");

        jLabel8.setText("location");

        txtF471.setEditable(false);

        btn471.setText("Update");
        btn471.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn471ActionPerformed(evt);
            }
        });

        jLabel10.setText("type");

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(57, 57, 57)
                .addComponent(txtF471, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jdate474, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(76, 76, 76)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtF472, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtF474, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(330, 330, 330)
                .addComponent(btn471))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(650, 650, 650)
                .addComponent(jButton6))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtF471, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdate474, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtF472, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtF474, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn471, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(txtF463, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtF463, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Machines", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Technicion ID/Name");
        jLabel2.setName("lbl462"); // NOI18N

        txtF462.setName("txtF462"); // NOI18N
        txtF462.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF462ActionPerformed(evt);
            }
        });
        txtF462.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF462KeyReleased(evt);
            }
        });

        tbl462.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Technicion ID", "Name", "Telephone number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl462.setName("tbl462"); // NOI18N
        tbl462.setRowHeight(25);
        jScrollPane1.setViewportView(tbl462);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(txtF462, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txtF462, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Technicions", jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl461.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Plant ID", "Plant Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl461.setName("tbl461"); // NOI18N
        tbl461.setRowHeight(25);
        jScrollPane3.setViewportView(tbl461);
        if (tbl461.getColumnModel().getColumnCount() > 0) {
            tbl461.getColumnModel().getColumn(0).setResizable(false);
            tbl461.getColumnModel().getColumn(1).setResizable(false);
            tbl461.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Plants", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtF460.setName("txtF460"); // NOI18N
        txtF460.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF460KeyReleased(evt);
            }
        });
        jPanel1.add(txtF460, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 220, 30));

        tbl460.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vehical Number", "model", "type", "department", "locatoin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl460.setName("tbl460"); // NOI18N
        tbl460.setRowHeight(25);
        jScrollPane2.setViewportView(tbl460);
        if (tbl460.getColumnModel().getColumnCount() > 0) {
            tbl460.getColumnModel().getColumn(0).setResizable(false);
            tbl460.getColumnModel().getColumn(1).setResizable(false);
            tbl460.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, 760, 400));

        jRadioButton1.setText("Model");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jRadioButton2.setText("Type");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 90, -1, -1));

        jRadioButton3.setText("Department");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jRadioButton4.setText("location");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jRadioButton5.setText("Vehicle");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jTabbedPane1.addTab("Vechicals", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn471ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn471ActionPerformed

        TechnicalServiceDbAcess obtUpdate = new TechnicalServiceDbAcess();
        SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
        String strDate = ft.format(jdate474.getDate());
        obtUpdate.updateMachineDetails(txtF471.getText(),txtF472.getText(),strDate,txtF474.getText());
        
        
        JFrame parent = new JFrame();
        JOptionPane.showMessageDialog(parent, "Updated");
        
        
         SetPanel p1 = new SetPanel();
         assets s= new assets();
         p1.SetPanel(s);  
    }//GEN-LAST:event_btn471ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        addMachine newMachine = new addMachine();
        newMachine.setVisible(true);
        newMachine.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl463MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl463MouseClicked
       
       
       //set values
       txtF471.setText((String) tbl463.getModel().getValueAt(tbl463.getSelectedRow(),0));
       txtF472.setText((String) tbl463.getModel().getValueAt(tbl463.getSelectedRow(),1));
       jdate474.setDate((Date) tbl463.getModel().getValueAt(tbl463.getSelectedRow(),2));
       txtF474.setText((String) tbl463.getModel().getValueAt(tbl463.getSelectedRow(),3));
       
       //set enable
       btn471.setEnabled(true);
       jButton6.setEnabled(true);
       
    }//GEN-LAST:event_tbl463MouseClicked

    private void txtF463ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF463ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF463ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
             String  selected = (String) tbl463.getModel().getValueAt(tbl463.getSelectedRow(),0);
             TechnicalServiceDbAcess dAsset = new TechnicalServiceDbAcess();
             
          
             
            
           JDialog.setDefaultLookAndFeelDecorated(true);
          int response = JOptionPane.showConfirmDialog(null, "Do you want to Delete?", "Confirm",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          
          if (response == JOptionPane.YES_OPTION) 
              dAsset.deleteMachine(selected);
          
          
            SetPanel p1 = new SetPanel();
             assets s= new assets();
            
             p1.SetPanel(s);
            
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtF460KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF460KeyReleased
      
        
        String sqlSearch="";
        
        if(jRadioButton1.isSelected())
        sqlSearch = "select vehicleNo,model,type,department,location from vehicle where model LIKE '"+ txtF460.getText()+"%'" ;
        else if(jRadioButton2.isSelected())
        sqlSearch = "select vehicleNo,model,type,department,location from vehicle where type LIKE '"+ txtF460.getText()+"%'" ;
        else if(jRadioButton3.isSelected())
        sqlSearch = "select vehicleNo,model,type,department,location from vehicle where department LIKE '"+ txtF460.getText()+"%'";
        else if(jRadioButton4.isSelected())
        sqlSearch = "select vehicleNo,model,type,department,location from vehicle where location LIKE '"+ txtF460.getText()+"%'";
        else if(jRadioButton5.isSelected())
          sqlSearch = "select vehicleNo,model,type,department,location from vehicle where vehicleNo LIKE '"+ txtF460.getText()+"%'" ;
        
        TechnicalServiceDbAcess obtResult =new  TechnicalServiceDbAcess();
        obtResult.fillTable(tbl460, sqlSearch);
        

    }//GEN-LAST:event_txtF460KeyReleased

    private void txtF463KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF463KeyReleased
              
        String machineId = txtF463.getText();

      
        textValidator validationMachine = new textValidator(machineId);
        
            String sqlMachine = "select machineId,location,purchaseDate,type from machinery where machineId LIKE '"+machineId+"%' OR location LIKE '"+machineId+"%' OR type LIKE '"+machineId+"%' OR purchaseDate LIKE '"+machineId+"%'";
            TechnicalServiceDbAcess obtResult =new  TechnicalServiceDbAcess();
            obtResult.fillTable(tbl463, sqlMachine);
        
    }//GEN-LAST:event_txtF463KeyReleased

    private void txtF462KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF462KeyReleased

      

        String sqlTechnicion= "select employeeId,name,telephoneMob from employee where jobId = 'JB011' AND employeeId  in (select employeeId from employee where employeeId LIKE '"+txtF462.getText()+"%' OR (name LIKE '"+txtF462.getText()+"%'))";
        TechnicalServiceDbAcess obtResult =new  TechnicalServiceDbAcess();
        obtResult.fillTable(tbl462, sqlTechnicion);

    }//GEN-LAST:event_txtF462KeyReleased

    private void txtF462ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF462ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF462ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
         txtF460.setEnabled(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        txtF460.setEnabled(true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        txtF460.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        txtF460.setEnabled(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        txtF460.setEnabled(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn471;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private com.toedter.calendar.JDateChooser jdate474;
    private javax.swing.JTable tbl460;
    private javax.swing.JTable tbl461;
    private javax.swing.JTable tbl462;
    private javax.swing.JTable tbl463;
    private javax.swing.JTextField txtF460;
    private javax.swing.JTextField txtF462;
    private javax.swing.JTextField txtF463;
    private javax.swing.JTextField txtF471;
    private javax.swing.JTextField txtF472;
    private javax.swing.JTextField txtF474;
    // End of variables declaration//GEN-END:variables
}
