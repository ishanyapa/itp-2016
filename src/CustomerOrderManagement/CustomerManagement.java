/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrderManagement;

import CustomerOrderSupportedClasses.idIncrementCOM;
import CustomerOrderSupportedClasses.SetPanel;
import CustomerOrderSupportedClasses.TextValidator;
import CustomerOrderSupportedClasses.CustomerOrderDbAccess;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Saajith Zain
 */
public class CustomerManagement extends javax.swing.JPanel {

    ComboKeyHandler ckh;
    /**
     * Creates new form CustomerManagement
     */
    public CustomerManagement() {
        initComponents();
           
  
       
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
        
        //add customer
        CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer","companyId");
        idIncrementCOM idi=new idIncrementCOM(dba.getLastId());//Increment CustomerID on form load i
        txt501_AddCompId.setText(idi.incrementId());
        
         //view Customer       
        CustomerOrderDbAccess d1=new CustomerOrderDbAccess("largescalecustomer");
        d1.fillTableCustomer(jTable1);//fill Table Customer in view customer 
        lbl500_CustomerCount.setText(String.valueOf(jTable1.getRowCount())+ " Record/s found");
       
        //update customer
        CustomerOrderDbAccess dba1=new CustomerOrderDbAccess("largescalecustomer","companyName");
        dba1.fillCombo(cmb500_updateComp);
        CustomerOrderDbAccess db1=new CustomerOrderDbAccess("largescalecustomer");
        db1.fillTableCustomer(tbl500updte_Customer);
      
        
          ckh = new ComboKeyHandler(cmb500_updateComp);
          cmb500_updateComp.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                ckh.keyTyped(e);
            }
        });
    
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnl501_AddCustomer = new javax.swing.JPanel();
        txt501_AddCompId = new javax.swing.JTextField();
        txt502_AddCompName = new javax.swing.JTextField();
        txt500_AddCompPostal = new javax.swing.JTextField();
        txt503_AddCompEmail = new javax.swing.JTextField();
        txt500_AddCompTelephone2 = new javax.swing.JTextField();
        cmb501_compCountry = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl500_AddCompNameErr = new javax.swing.JLabel();
        lbl500_AddCompTelephoneErr = new javax.swing.JLabel();
        lbl500_AddCompEmailErr = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAr501_addcompAddress = new javax.swing.JTextArea();
        btb501_AddCustomer = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbl500_AddCompPostalErr = new javax.swing.JLabel();
        lbl500_AddCompCountryErr = new javax.swing.JLabel();
        lbl500_AddCompAddressErr = new javax.swing.JLabel();
        txt508_AddCompCity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbl500_AddCompCityErr = new javax.swing.JLabel();
        txt505_AddCompTelephone3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt500_AddCompTelephone1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DemoCustomer = new javax.swing.JButton();
        jpnl502_ViewCustomer = new javax.swing.JPanel();
        lbl500_CustomerCount = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jpnl503_UpdateCustomer = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl500_UpdtCompNameErr = new javax.swing.JLabel();
        lbl501_UpdtCompTelephoneErr = new javax.swing.JLabel();
        lbl502_updtCompTypeErr = new javax.swing.JLabel();
        txt500_UpdtCompId = new javax.swing.JTextField();
        txt500_UpdtCompTelephone3 = new javax.swing.JTextField();
        txt500_UpdtCompEmail = new javax.swing.JTextField();
        txt500_UpdtCompPostal = new javax.swing.JTextField();
        txt500_UpdtCompName = new javax.swing.JTextField();
        cmb500_updtCountry = new javax.swing.JComboBox<>();
        cmb500_updateComp = new javax.swing.JComboBox<>();
        btn502_updateCust = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAr500_updtCompAddress = new javax.swing.JTextArea();
        lbl500_UpdtCompNAddressErr = new javax.swing.JLabel();
        lbl500_UpdtPostalErr = new javax.swing.JLabel();
        lbl500_UpdtSelectNameErr = new javax.swing.JLabel();
        txt50_UpdtCompTelephone2 = new javax.swing.JTextField();
        txt500_UpdtCompTelephone1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl502_updtCompEmailErr1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt500Update_compCity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl500updte_compCountryErr = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl500updte_Customer = new javax.swing.JTable();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(790, 590));
        setMinimumSize(new java.awt.Dimension(790, 590));
        setPreferredSize(new java.awt.Dimension(790, 590));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(780, 570));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(780, 570));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(780, 570));

        jpnl501_AddCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jpnl501_AddCustomer.setMaximumSize(new java.awt.Dimension(780, 570));
        jpnl501_AddCustomer.setMinimumSize(new java.awt.Dimension(780, 570));
        jpnl501_AddCustomer.setPreferredSize(new java.awt.Dimension(780, 570));

        txt501_AddCompId.setEditable(false);
        txt501_AddCompId.setBackground(new java.awt.Color(255, 255, 255));
        txt501_AddCompId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt501_AddCompIdActionPerformed(evt);
            }
        });

        txt502_AddCompName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt502_AddCompNameFocusLost(evt);
            }
        });
        txt502_AddCompName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt502_AddCompNameActionPerformed(evt);
            }
        });

        txt500_AddCompPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_AddCompPostalFocusLost(evt);
            }
        });
        txt500_AddCompPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_AddCompPostalActionPerformed(evt);
            }
        });

        txt503_AddCompEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt503_AddCompEmailFocusLost(evt);
            }
        });
        txt503_AddCompEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt503_AddCompEmailActionPerformed(evt);
            }
        });

        txt500_AddCompTelephone2 .setColumns(2);
        txt500_AddCompTelephone2.setColumns(3);
        txt500_AddCompTelephone2.setToolTipText("");
        txt500_AddCompTelephone2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_AddCompTelephone2FocusLost(evt);
            }
        });
        txt500_AddCompTelephone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_AddCompTelephone2ActionPerformed(evt);
            }
        });
        txt500_AddCompTelephone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt500_AddCompTelephone2KeyTyped(evt);
            }
        });

        cmb501_compCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sri Lanka(LK)", "America(USA)", "Austrailia (AU)", "Canada(CN)", "India(IN)", "NewZeland(NZ)", "Pakistan(PAK)", "UAE" }));
        cmb501_compCountry.setSelectedIndex(-1);
        cmb501_compCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb501_compCountryFocusLost(evt);
            }
        });
        cmb501_compCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb501_compCountryActionPerformed(evt);
            }
        });

        jLabel1.setText("CompanyId");

        jLabel2.setText("CompanyName");

        jLabel3.setText("Point Of Contact");

        jLabel5.setText("Email");

        jLabel8.setText("Address");

        jLabel4.setText("Country");

        jLabel6.setText("postal Code");

        lbl500_AddCompNameErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompNameErr.setForeground(new java.awt.Color(204, 0, 0));
        lbl500_AddCompNameErr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl500_AddCompNameErrFocusLost(evt);
            }
        });

        lbl500_AddCompTelephoneErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompTelephoneErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl500_AddCompEmailErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompEmailErr.setForeground(new java.awt.Color(204, 0, 0));

        txtAr501_addcompAddress.setColumns(20);
        txtAr501_addcompAddress.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtAr501_addcompAddress.setRows(5);
        txtAr501_addcompAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAr501_addcompAddressFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtAr501_addcompAddress);

        btb501_AddCustomer.setText("Add ");
        btb501_AddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btb501_AddCustomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btb501_AddCustomerMousePressed(evt);
            }
        });
        btb501_AddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btb501_AddCustomerActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbl500_AddCompPostalErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompPostalErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl500_AddCompCountryErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompCountryErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl500_AddCompAddressErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompAddressErr.setForeground(new java.awt.Color(204, 0, 0));

        txt508_AddCompCity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt508_AddCompCityFocusLost(evt);
            }
        });

        jLabel11.setText("City");

        lbl500_AddCompCityErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_AddCompCityErr.setForeground(new java.awt.Color(204, 0, 0));

        txt505_AddCompTelephone3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt505_AddCompTelephone3FocusLost(evt);
            }
        });
        txt505_AddCompTelephone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt505_AddCompTelephone3ActionPerformed(evt);
            }
        });
        txt505_AddCompTelephone3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt505_AddCompTelephone3KeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setText("-");

        txt500_AddCompTelephone2 .setColumns(2);
        txt500_AddCompTelephone1.setColumns(3);
        txt500_AddCompTelephone1.setToolTipText("");
        txt500_AddCompTelephone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_AddCompTelephone1FocusLost(evt);
            }
        });
        txt500_AddCompTelephone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_AddCompTelephone1ActionPerformed(evt);
            }
        });
        txt500_AddCompTelephone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt500_AddCompTelephone1KeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("+");

        DemoCustomer.setText("Demo");
        DemoCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemoCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnl501_AddCustomerLayout = new javax.swing.GroupLayout(jpnl501_AddCustomer);
        jpnl501_AddCustomer.setLayout(jpnl501_AddCustomerLayout);
        jpnl501_AddCustomerLayout.setHorizontalGroup(
            jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl501_AddCustomerLayout.createSequentialGroup()
                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btb501_AddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt500_AddCompTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt500_AddCompTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt505_AddCompTelephone3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl500_AddCompTelephoneErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(50, 50, 50)
                                        .addComponent(txt501_AddCompId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109))
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(33, 33, 33)
                                        .addComponent(txt502_AddCompName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl500_AddCompNameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))
                                .addGap(49, 49, 49)
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt508_AddCompCity)
                                    .addComponent(txt500_AddCompPostal, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl500_AddCompPostalErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl500_AddCompCityErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(82, 82, 82)
                                        .addComponent(txt503_AddCompEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl500_AddCompEmailErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(67, 67, 67)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl500_AddCompAddressErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(67, 67, 67)
                                        .addComponent(cmb501_compCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl500_AddCompCountryErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addComponent(DemoCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jpnl501_AddCustomerLayout.setVerticalGroup(
            jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(txt501_AddCompId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(DemoCustomer)))
                .addGap(18, 18, 18)
                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txt502_AddCompName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl500_AddCompNameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt500_AddCompTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt505_AddCompTelephone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt500_AddCompTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(lbl500_AddCompTelephoneErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl500_AddCompEmailErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(txt503_AddCompEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                        .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4))
                                    .addComponent(cmb501_compCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl500_AddCompCityErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt508_AddCompCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl501_AddCustomerLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel6))
                                    .addComponent(txt500_AddCompPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl500_AddCompPostalErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl500_AddCompCountryErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jpnl501_AddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btb501_AddCustomer)
                            .addComponent(jButton2)))
                    .addComponent(lbl500_AddCompAddressErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add Customer", jpnl501_AddCustomer);
        jpnl501_AddCustomer.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        jpnl502_ViewCustomer.setBackground(new java.awt.Color(255, 255, 255));

        lbl500_CustomerCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl500_CustomerCount.setForeground(new java.awt.Color(51, 153, 0));
        lbl500_CustomerCount.setText("0 record/s found");

        jLabel9.setText("Company Id ");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("LSC");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setText("View All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "companyId", "CompanyName", "customerType", "telephone", "email", "country", "city", "postalCode", "address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("-");

        javax.swing.GroupLayout jpnl502_ViewCustomerLayout = new javax.swing.GroupLayout(jpnl502_ViewCustomer);
        jpnl502_ViewCustomer.setLayout(jpnl502_ViewCustomerLayout);
        jpnl502_ViewCustomerLayout.setHorizontalGroup(
            jpnl502_ViewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl502_ViewCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnl502_ViewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addGap(35, 35, 35))
            .addGroup(jpnl502_ViewCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl502_ViewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl502_ViewCustomerLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(jpnl502_ViewCustomerLayout.createSequentialGroup()
                        .addComponent(lbl500_CustomerCount)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpnl502_ViewCustomerLayout.setVerticalGroup(
            jpnl502_ViewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl502_ViewCustomerLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jpnl502_ViewCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl500_CustomerCount)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Customer", jpnl502_ViewCustomer);

        jpnl503_UpdateCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jpnl503_UpdateCustomer.setMaximumSize(new java.awt.Dimension(780, 570));
        jpnl503_UpdateCustomer.setMinimumSize(new java.awt.Dimension(780, 570));
        jpnl503_UpdateCustomer.setPreferredSize(new java.awt.Dimension(780, 570));

        jLabel10.setText("Company");

        jLabel12.setText("CompanyName");

        jLabel13.setText("Point Of Contact");

        jLabel14.setText("Email");

        jLabel15.setText("Address");

        jLabel16.setText("Country");

        jLabel17.setText("postal Code");

        jLabel21.setText("Company Id");

        lbl500_UpdtCompNameErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_UpdtCompNameErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl501_UpdtCompTelephoneErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl501_UpdtCompTelephoneErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl502_updtCompTypeErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl502_updtCompTypeErr.setForeground(new java.awt.Color(204, 0, 0));

        txt500_UpdtCompId.setEditable(false);
        txt500_UpdtCompId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_UpdtCompIdActionPerformed(evt);
            }
        });

        txt500_UpdtCompTelephone3.setEditable(false);
        txt500_UpdtCompTelephone3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_UpdtCompTelephone3FocusLost(evt);
            }
        });
        txt500_UpdtCompTelephone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_UpdtCompTelephone3ActionPerformed(evt);
            }
        });
        txt500_UpdtCompTelephone3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt500_UpdtCompTelephone3KeyTyped(evt);
            }
        });

        txt500_UpdtCompEmail.setEditable(false);
        txt500_UpdtCompEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_UpdtCompEmailFocusLost(evt);
            }
        });
        txt500_UpdtCompEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_UpdtCompEmailActionPerformed(evt);
            }
        });

        txt500_UpdtCompPostal.setEditable(false);
        txt500_UpdtCompPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_UpdtCompPostalFocusLost(evt);
            }
        });
        txt500_UpdtCompPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_UpdtCompPostalActionPerformed(evt);
            }
        });

        txt500_UpdtCompName.setEditable(false);
        txt500_UpdtCompName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_UpdtCompNameFocusLost(evt);
            }
        });
        txt500_UpdtCompName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_UpdtCompNameActionPerformed(evt);
            }
        });

        cmb500_updtCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sri Lanka(LK)", "America(USA)", "Austrailia (AU)", "Canada(CN)", "India(IN)", "NewZeland(NZ)", "Pakistan(PAK)", "UAE" }));
        cmb500_updtCountry.setSelectedIndex(-1);
        cmb500_updtCountry.setEnabled(false);
        cmb500_updtCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb500_updtCountryFocusLost(evt);
            }
        });
        cmb500_updtCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500_updtCountryActionPerformed(evt);
            }
        });
        cmb500_updtCountry.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb500_updtCountryPropertyChange(evt);
            }
        });

        cmb500_updateComp.setEditable(true);
        cmb500_updateComp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb500_updateCompItemStateChanged(evt);
            }
        });
        cmb500_updateComp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb500_updateCompFocusLost(evt);
            }
        });
        cmb500_updateComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500_updateCompActionPerformed(evt);
            }
        });
        cmb500_updateComp.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb500_updateCompPropertyChange(evt);
            }
        });
        cmb500_updateComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmb500_updateCompKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmb500_updateCompKeyTyped(evt);
            }
        });

        btn502_updateCust.setText("Update");
        btn502_updateCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn502_updateCustActionPerformed(evt);
            }
        });

        txtAr500_updtCompAddress.setEditable(false);
        txtAr500_updtCompAddress.setColumns(20);
        txtAr500_updtCompAddress.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtAr500_updtCompAddress.setRows(5);
        txtAr500_updtCompAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAr500_updtCompAddressFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtAr500_updtCompAddress);

        lbl500_UpdtCompNAddressErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_UpdtCompNAddressErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl500_UpdtPostalErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_UpdtPostalErr.setForeground(new java.awt.Color(204, 0, 0));

        lbl500_UpdtSelectNameErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500_UpdtSelectNameErr.setForeground(new java.awt.Color(204, 0, 0));

        txt50_UpdtCompTelephone2.setEditable(false);
        txt50_UpdtCompTelephone2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt50_UpdtCompTelephone2FocusLost(evt);
            }
        });
        txt50_UpdtCompTelephone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt50_UpdtCompTelephone2ActionPerformed(evt);
            }
        });
        txt50_UpdtCompTelephone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt50_UpdtCompTelephone2KeyTyped(evt);
            }
        });

        txt500_UpdtCompTelephone1.setEditable(false);
        txt500_UpdtCompTelephone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt500_UpdtCompTelephone1FocusLost(evt);
            }
        });
        txt500_UpdtCompTelephone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500_UpdtCompTelephone1ActionPerformed(evt);
            }
        });
        txt500_UpdtCompTelephone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt500_UpdtCompTelephone1KeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel23.setText("-");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("+");

        lbl502_updtCompEmailErr1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl502_updtCompEmailErr1.setForeground(new java.awt.Color(204, 0, 0));

        jLabel20.setText("City");

        txt500Update_compCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500Update_compCityActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl500updte_compCountryErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500updte_compCountryErr.setForeground(new java.awt.Color(204, 0, 0));

        tbl500updte_Customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Company Name", "Company Type", "Point Of Contact", "Email", "Country", "City", "Posta lCode", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl500updte_Customer);

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Active");

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Inactive");

        jLabel26.setText("Company  Status");

        javax.swing.GroupLayout jpnl503_UpdateCustomerLayout = new javax.swing.GroupLayout(jpnl503_UpdateCustomer);
        jpnl503_UpdateCustomer.setLayout(jpnl503_UpdateCustomerLayout);
        jpnl503_UpdateCustomerLayout.setHorizontalGroup(
            jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel21)))
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt500_UpdtCompName)
                                .addComponent(txt500_UpdtCompEmail)
                                .addComponent(cmb500_updateComp, 0, 215, Short.MAX_VALUE)
                                .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt500_UpdtCompTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt50_UpdtCompTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt500_UpdtCompTelephone3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt500_UpdtCompId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt500_UpdtCompPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl500_UpdtPostalErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl502_updtCompTypeErr, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(lbl500_UpdtCompNameErr, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(lbl500_UpdtSelectNameErr, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(lbl501_UpdtCompTelephoneErr, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel15)))
                                    .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)))))
                            .addComponent(lbl502_updtCompEmailErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt500Update_compCity, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                .addComponent(cmb500_updtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl500updte_compCountryErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jRadioButton3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton4)))
                                    .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                        .addComponent(btn502_updateCust, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl500_UpdtCompNAddressErr, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2, Short.MAX_VALUE))
        );
        jpnl503_UpdateCustomerLayout.setVerticalGroup(
            jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb500_updtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10)
                        .addComponent(lbl500_UpdtSelectNameErr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmb500_updateComp, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lbl500updte_compCountryErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt500_UpdtCompId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt500Update_compCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl501_UpdtCompTelephoneErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                            .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txt500_UpdtCompName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl500_UpdtCompNameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txt500_UpdtCompTelephone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt50_UpdtCompTelephone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt500_UpdtCompTelephone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24)))
                        .addComponent(jLabel15)
                        .addComponent(lbl500_UpdtCompNAddressErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl503_UpdateCustomerLayout.createSequentialGroup()
                                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txt500_UpdtCompEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl502_updtCompTypeErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl502_updtCompEmailErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt500_UpdtCompPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))
                            .addComponent(lbl500_UpdtPostalErr, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnl503_UpdateCustomerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3)
                            .addComponent(jLabel26))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnl503_UpdateCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn502_updateCust)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update Cutomer Details", jpnl503_UpdateCustomer);
        jpnl503_UpdateCustomer.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt500_UpdtCompEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_UpdtCompEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_UpdtCompEmailActionPerformed

    private void cmb500_updtCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500_updtCountryActionPerformed
        
    }//GEN-LAST:event_cmb500_updtCountryActionPerformed

    private void txt500_UpdtCompPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_UpdtCompPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_UpdtCompPostalActionPerformed

    private void btn502_updateCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn502_updateCustActionPerformed

        
        txt500_UpdtCompName.requestFocus();
        txt508_AddCompCity.requestFocus();
        txt500_UpdtCompEmail.requestFocus();
        txt500_UpdtCompPostal.requestFocus();
        txtAr500_updtCompAddress.requestFocus();
        cmb500_updtCountry.requestFocus();
        cmb500_updateComp.requestFocus();
        txt500_UpdtCompTelephone1.requestFocus();
        txt50_UpdtCompTelephone2.requestFocus();
        txt500_UpdtCompTelephone3.requestFocus();
        btn502_updateCust.requestFocus();
        
        
        if(    lbl500_UpdtCompNameErr.getText().equals("!")     || lbl502_updtCompTypeErr.getText().equals("!") 
            || lbl500_UpdtSelectNameErr.getText().endsWith("!") || lbl502_updtCompEmailErr1.getText().equals("!")
            || lbl502_updtCompTypeErr.getText().equals("!")     ||  lbl500_UpdtCompNAddressErr.getText().equals("!")
            || lbl501_UpdtCompTelephoneErr.getText().equals("!")|| lbl502_updtCompTypeErr.getText().equals("!")
            || cmb500_updtCountry.getSelectedIndex()==-1 ){
                              
            JOptionPane.showMessageDialog(this,"One or more fields contain Invalid data","Error!",JOptionPane.ERROR_MESSAGE);
        }
        
        else{
       String type="";     
       int result=JOptionPane.showConfirmDialog(this,"Do you want to Update details of "+String.valueOf(txt500_UpdtCompName.getText()),"Confirmation",JOptionPane.YES_NO_OPTION);
           if(result==JOptionPane.YES_OPTION){ 
             CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer");
             
             if(jRadioButton3.isSelected())
             {
                 type="Active";
             }
             else
                 type="Inactive";
                 
             dba.updateCustomer(txt500_UpdtCompId, txt500_UpdtCompName,txt500_UpdtCompTelephone1, txt50_UpdtCompTelephone2,
                            txt500_UpdtCompTelephone3,txt500_UpdtCompEmail, txtAr500_updtCompAddress, 
                            cmb500_updtCountry,txt500Update_compCity, txt500_UpdtCompPostal,type);
            
            JOptionPane.showMessageDialog(this,"Successfully Updated ","Successful",JOptionPane.INFORMATION_MESSAGE);
          
            CustomerOrderDbAccess d1=new CustomerOrderDbAccess("largescalecustomer");
            d1.fillTableCustomer(tbl500updte_Customer);
   
           }
            
        
        }
        
    }//GEN-LAST:event_btn502_updateCustActionPerformed

    private void cmb500_updateCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500_updateCompActionPerformed
               
    }//GEN-LAST:event_cmb500_updateCompActionPerformed

    private void txt503_AddCompEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt503_AddCompEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt503_AddCompEmailActionPerformed

    private void txt500_AddCompTelephone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_AddCompTelephone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_AddCompTelephone2ActionPerformed

    private void txt500_AddCompPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_AddCompPostalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_AddCompPostalActionPerformed

    private void cmb501_compCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb501_compCountryActionPerformed
        lbl500_AddCompCountryErr.setText("");
    }//GEN-LAST:event_cmb501_compCountryActionPerformed

    private void txt501_AddCompIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt501_AddCompIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt501_AddCompIdActionPerformed

    private void txt502_AddCompNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt502_AddCompNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt502_AddCompNameActionPerformed

    private void txt500_UpdtCompNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_UpdtCompNameFocusLost
      
      TextValidator t1 = new TextValidator(String.valueOf(txt500_UpdtCompName.getText()));
      t1.isName(lbl500_UpdtCompNameErr);
          
      
    }//GEN-LAST:event_txt500_UpdtCompNameFocusLost

    private void txt500_UpdtCompNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_UpdtCompNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_UpdtCompNameActionPerformed

    private void txt500_UpdtCompEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_UpdtCompEmailFocusLost
       
        TextValidator t1 = new TextValidator(String.valueOf(txt500_UpdtCompEmail.getText()));
           if(t1.isEmail())
            lbl502_updtCompEmailErr1.setText("");
           else
            lbl502_updtCompEmailErr1.setText("!");
         
    }//GEN-LAST:event_txt500_UpdtCompEmailFocusLost

    private void lbl500_AddCompNameErrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl500_AddCompNameErrFocusLost
 
    }//GEN-LAST:event_lbl500_AddCompNameErrFocusLost

    private void txt502_AddCompNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt502_AddCompNameFocusLost
       
        TextValidator t1 = new TextValidator(String.valueOf(txt502_AddCompName.getText())); 
        t1.isName(lbl500_AddCompNameErr);
      
              
    }//GEN-LAST:event_txt502_AddCompNameFocusLost

    private void txt503_AddCompEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt503_AddCompEmailFocusLost
        TextValidator t1 = new TextValidator(String.valueOf(txt503_AddCompEmail.getText()));
        
        if(t1.isEmail())
            lbl500_AddCompEmailErr.setText("");
        else
            lbl500_AddCompEmailErr.setText("!");
          
    }//GEN-LAST:event_txt503_AddCompEmailFocusLost

    private void txtAr501_addcompAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAr501_addcompAddressFocusLost

       TextValidator t1=new TextValidator(String.valueOf(txtAr501_addcompAddress.getText()));
       t1.empty(lbl500_AddCompAddressErr);
    }//GEN-LAST:event_txtAr501_addcompAddressFocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txt500_UpdtCompTelephone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_UpdtCompTelephone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_UpdtCompTelephone3ActionPerformed

    private void btb501_AddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btb501_AddCustomerActionPerformed
         
        txt502_AddCompName.requestFocus();
        txt503_AddCompEmail.requestFocus();
        txt500_AddCompPostal.requestFocus();
        txtAr501_addcompAddress.requestFocus();
        txt500_AddCompTelephone2.requestFocus();
        txt500_AddCompTelephone1.requestFocus();
        txt505_AddCompTelephone3.requestFocus();
        txt508_AddCompCity.requestFocus();
        cmb501_compCountry.requestFocus();
        btb501_AddCustomer.requestFocus();
        
        String gen="";
        try{
        if(cmb501_compCountry.getSelectedItem().equals("Sri Lanka(LK)"))
            gen="Local";
        else
            gen="Foreign";
        
        }catch(Exception e)
        {}
        
        if(lbl500_AddCompNameErr.getText().equals("!")        || lbl500_AddCompEmailErr.getText().equals("!") 
            || lbl500_AddCompAddressErr.getText().equals("!") || lbl500_AddCompCityErr.getText().equals("!")
            || lbl500_AddCompPostalErr.getText().equals("!")  || lbl500_AddCompCountryErr.getText().equals("!")
            || lbl500_AddCompTelephoneErr.getText().equals("!") 
            || cmb501_compCountry.getSelectedIndex()==-1
             ){
            JOptionPane.showMessageDialog(this,"One or more fields contain Invalid Data","Error!",JOptionPane.ERROR_MESSAGE);
        }
            
        
        else if(lbl500_AddCompNameErr.getText().equals("")   &&lbl500_AddCompEmailErr.getText().equals("") 
            && lbl500_AddCompAddressErr.getText().equals("") && lbl500_AddCompCityErr.getText().equals("")
            && lbl500_AddCompPostalErr.getText().equals("")  && lbl500_AddCompCountryErr.getText().equals("")
            && lbl500_AddCompTelephoneErr.getText().equals("") 
            && cmb501_compCountry.getSelectedIndex()!=-1) 
            {
            
                int c=JOptionPane.showConfirmDialog(this,"Add cutomer "+txt502_AddCompName.getText(),"Confirmation",JOptionPane.WARNING_MESSAGE);
                if(c==JOptionPane.YES_OPTION){
                CustomerOrderDbAccess dba=new CustomerOrderDbAccess();
                dba.insertCustomer(txt501_AddCompId, txt502_AddCompName,txt500_AddCompTelephone1, txt500_AddCompTelephone2, txt505_AddCompTelephone3, txt503_AddCompEmail, gen, txtAr501_addcompAddress, cmb501_compCountry,txt508_AddCompCity,txt500_AddCompPostal);
                JOptionPane.showMessageDialog(null,"Customer added Sucessfully");
                
           CustomerManagement cm =new CustomerManagement();
            SetPanel sp = new SetPanel();
            sp.SetPanel(cm);
          
            }
           }
        
        
        CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer","companyId");
        idIncrementCOM idi=new idIncrementCOM(dba.getLastId());
        txt501_AddCompId.setText(idi.incrementId());
    }//GEN-LAST:event_btb501_AddCustomerActionPerformed

    private void txt500_AddCompPostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_AddCompPostalFocusLost
        TextValidator t1=new TextValidator(String.valueOf(txt500_AddCompPostal.getText()));
        t1.empty(lbl500_AddCompPostalErr);        
    }//GEN-LAST:event_txt500_AddCompPostalFocusLost

    private void cmb501_compCountryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb501_compCountryFocusLost
        TextValidator t1=new TextValidator();
        t1.comboSelection(cmb501_compCountry, lbl500_AddCompCountryErr);
    }//GEN-LAST:event_cmb501_compCountryFocusLost

    private void txt508_AddCompCityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt508_AddCompCityFocusLost
        TextValidator t1=new TextValidator(String.valueOf(txt508_AddCompCity.getText()));
        t1.empty(lbl500_AddCompCityErr);
    }//GEN-LAST:event_txt508_AddCompCityFocusLost

    private void txt500_UpdtCompIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_UpdtCompIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_UpdtCompIdActionPerformed

    private void txtAr500_updtCompAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAr500_updtCompAddressFocusLost
        TextValidator t1=new TextValidator(String.valueOf(txtAr500_updtCompAddress.getText()));
        t1.empty(lbl500_UpdtCompNAddressErr);
    }//GEN-LAST:event_txtAr500_updtCompAddressFocusLost

    private void cmb500_updtCountryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb500_updtCountryFocusLost
        TextValidator t1=new TextValidator();
        t1.comboSelection(cmb500_updtCountry,lbl500updte_compCountryErr);
    }//GEN-LAST:event_cmb500_updtCountryFocusLost

    private void txt500_UpdtCompPostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_UpdtCompPostalFocusLost
        TextValidator t1=new TextValidator(String.valueOf(txt500_UpdtCompPostal.getText()));
        t1.empty(lbl500_UpdtPostalErr);
    }//GEN-LAST:event_txt500_UpdtCompPostalFocusLost

    private void cmb500_updateCompFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb500_updateCompFocusLost
        TextValidator t1=new TextValidator();
        t1.comboSelection(cmb500_updateComp, lbl500_UpdtSelectNameErr);
    }//GEN-LAST:event_cmb500_updateCompFocusLost

    private void txt505_AddCompTelephone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt505_AddCompTelephone3ActionPerformed
        
    }//GEN-LAST:event_txt505_AddCompTelephone3ActionPerformed

    private void txt500_AddCompTelephone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt500_AddCompTelephone2KeyTyped
        
        if(txt500_AddCompTelephone2.getText().length() <=2){
                    if(!(Character.isDigit(evt.getKeyChar())))
                          evt.consume();
                    
                }
            else
                evt.consume();
                
    }//GEN-LAST:event_txt500_AddCompTelephone2KeyTyped

    private void txt505_AddCompTelephone3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt505_AddCompTelephone3KeyTyped
        
        if(txt505_AddCompTelephone3.getText().length() <=6){
                    if(!(Character.isDigit(evt.getKeyChar())))
                          evt.consume();
        }
            else
                evt.consume();
    }//GEN-LAST:event_txt505_AddCompTelephone3KeyTyped

    private void txt500_AddCompTelephone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_AddCompTelephone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_AddCompTelephone1ActionPerformed

    private void txt500_AddCompTelephone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt500_AddCompTelephone1KeyTyped
        
        if(txt500_AddCompTelephone1.getText().length() <=1){
                    if(!(Character.isDigit(evt.getKeyChar())))
                          evt.consume();      
        }
            else
                evt.consume();
    }//GEN-LAST:event_txt500_AddCompTelephone1KeyTyped

    private void txt50_UpdtCompTelephone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt50_UpdtCompTelephone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt50_UpdtCompTelephone2ActionPerformed

    private void txt500_UpdtCompTelephone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500_UpdtCompTelephone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500_UpdtCompTelephone1ActionPerformed

    private void txt500_UpdtCompTelephone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt500_UpdtCompTelephone1KeyTyped
      if(txt500_UpdtCompTelephone1.getText().length() <=1){
                    if(!(Character.isDigit(evt.getKeyChar())))
                          evt.consume();      
        }
            else
                evt.consume();   
    }//GEN-LAST:event_txt500_UpdtCompTelephone1KeyTyped

    private void txt50_UpdtCompTelephone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt50_UpdtCompTelephone2KeyTyped
        if(txt50_UpdtCompTelephone2.getText().length() <=2){
                    if(!(Character.isDigit(evt.getKeyChar())))
                          evt.consume();      
        }
            else
                evt.consume(); 
    }//GEN-LAST:event_txt50_UpdtCompTelephone2KeyTyped

    private void txt500_UpdtCompTelephone3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt500_UpdtCompTelephone3KeyTyped
        if(txt500_UpdtCompTelephone3.getText().length() <=6){
                    if(!(Character.isDigit(evt.getKeyChar())))
                          evt.consume();      
        }
            else
                evt.consume(); 
    }//GEN-LAST:event_txt500_UpdtCompTelephone3KeyTyped

    private void txt505_AddCompTelephone3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt505_AddCompTelephone3FocusLost
        TextValidator t1=new TextValidator();
        t1.isTelephone(txt500_AddCompTelephone1.getText(), txt500_AddCompTelephone2.getText(), txt505_AddCompTelephone3.getText(), lbl500_AddCompTelephoneErr);
        
    }//GEN-LAST:event_txt505_AddCompTelephone3FocusLost

    private void txt500_UpdtCompTelephone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_UpdtCompTelephone1FocusLost
        TextValidator t1=new TextValidator();
        t1.isTelephone(txt500_UpdtCompTelephone1.getText(), txt50_UpdtCompTelephone2.getText(), txt500_UpdtCompTelephone3.getText(), lbl501_UpdtCompTelephoneErr);
       
    }//GEN-LAST:event_txt500_UpdtCompTelephone1FocusLost

    private void txt50_UpdtCompTelephone2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt50_UpdtCompTelephone2FocusLost
        TextValidator t1=new TextValidator();
        t1.isTelephone(txt500_UpdtCompTelephone1.getText(), txt50_UpdtCompTelephone2.getText(), txt500_UpdtCompTelephone3.getText(), lbl501_UpdtCompTelephoneErr);
       
    }//GEN-LAST:event_txt50_UpdtCompTelephone2FocusLost

    private void txt500_UpdtCompTelephone3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_UpdtCompTelephone3FocusLost
         TextValidator t1=new TextValidator();
         t1.isTelephone(txt500_UpdtCompTelephone1.getText(), txt50_UpdtCompTelephone2.getText(), txt500_UpdtCompTelephone3.getText(), lbl501_UpdtCompTelephoneErr);
           }//GEN-LAST:event_txt500_UpdtCompTelephone3FocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  
        CustomerOrderDbAccess d1=new CustomerOrderDbAccess("largescalecustomer");
       
       d1.fillTableCustomer(jTable1);
       lbl500_CustomerCount.setText(String.valueOf(jTable1.getRowCount())+ " Record/s found");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt500_AddCompTelephone2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_AddCompTelephone2FocusLost
        TextValidator t1=new TextValidator();
        t1.isTelephone(txt500_AddCompTelephone1.getText(), txt500_AddCompTelephone2.getText(), txt505_AddCompTelephone3.getText(), lbl500_AddCompTelephoneErr);
       
    }//GEN-LAST:event_txt500_AddCompTelephone2FocusLost

    private void txt500_AddCompTelephone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt500_AddCompTelephone1FocusLost
        TextValidator t1=new TextValidator();
        t1.isTelephone(txt500_AddCompTelephone1.getText(), txt500_AddCompTelephone2.getText(), txt505_AddCompTelephone3.getText(), lbl500_AddCompTelephoneErr);
       
    }//GEN-LAST:event_txt500_AddCompTelephone1FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            CustomerManagement cm =new CustomerManagement();
            SetPanel sp = new SetPanel();
            sp.SetPanel(cm);
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmb500_updateCompPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb500_updateCompPropertyChange
        if(cmb500_updateComp.getSelectedIndex()==-1){
            
        }
        else{
            txt500_UpdtCompName.setEditable(true);
            txt500_UpdtCompTelephone3.setEditable(true);
            txt500_UpdtCompEmail.setEditable(true);
            txt500_UpdtCompPostal.setEditable(true);
            cmb500_updtCountry.setEnabled(true);
            txtAr500_updtCompAddress.setEditable(true); 
            txt50_UpdtCompTelephone2.setEditable(true);
            txt500_UpdtCompTelephone1.setEditable(true);
            lbl500_UpdtSelectNameErr.setText("");
          //  jRadioButton1.setEnabled(true);
            //jRadioButton2.setEnabled(true);
            
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer", "companyId");
            txt500_UpdtCompId.setText(dba.getUpdateCompanyId(cmb500_updateComp));//set id for the selcted company
          
            
            CustomerOrderDbAccess dba1=new CustomerOrderDbAccess("largescalecustomer");
            dba1.UpdateCustomerLoadData(txt500_UpdtCompId, txt500_UpdtCompName, txt500_UpdtCompTelephone1, 
                                        txt50_UpdtCompTelephone2,txt500_UpdtCompTelephone3, txt500_UpdtCompEmail, 
                                         txtAr500_updtCompAddress, cmb500_updtCountry, txt500Update_compCity, txt500_UpdtCompPostal,jRadioButton3,jRadioButton4);
        }
        

    }//GEN-LAST:event_cmb500_updateCompPropertyChange

    private void cmb500_updateCompItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb500_updateCompItemStateChanged

    }//GEN-LAST:event_cmb500_updateCompItemStateChanged

    private void txt500Update_compCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500Update_compCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500Update_compCityActionPerformed

    private void cmb500_updtCountryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb500_updtCountryPropertyChange
        
    }//GEN-LAST:event_cmb500_updtCountryPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    CustomerManagement cm =new CustomerManagement();
            SetPanel sp = new SetPanel();
            sp.SetPanel(cm);
                   

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btb501_AddCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btb501_AddCustomerMouseClicked
      
    }//GEN-LAST:event_btb501_AddCustomerMouseClicked

    private void btb501_AddCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btb501_AddCustomerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btb501_AddCustomerMousePressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
       
            
    }//GEN-LAST:event_jTextField2KeyPressed

    private void DemoCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemoCustomerActionPerformed
       txt502_AddCompName.setText("Finco (pvt) Ltd");
       txt500_AddCompPostal.setText("20000");
       txt500_AddCompTelephone1.setText("94");
       txt500_AddCompTelephone2.setText("011");
       txt505_AddCompTelephone3.setText("6532145");
       txt503_AddCompEmail.setText("shalindweerasinghe@gmail.com");
       txt508_AddCompCity.setText("colombo");
       txtAr501_addcompAddress.setText("Address: 49/16, Galle Road, Colombo 3");
       cmb501_compCountry.setSelectedIndex(2);
       
        txt502_AddCompName.requestFocus();
        txt503_AddCompEmail.requestFocus();
        txt500_AddCompPostal.requestFocus();
        txtAr501_addcompAddress.requestFocus();
        txt500_AddCompTelephone2.requestFocus();
        txt500_AddCompTelephone1.requestFocus();
        txt505_AddCompTelephone3.requestFocus();
        txt508_AddCompCity.requestFocus();
        cmb501_compCountry.requestFocus();
        btb501_AddCustomer.requestFocus();
    }//GEN-LAST:event_DemoCustomerActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer","companyId");
        dba.fillCustomerTableOnCondition(jTable1,String.valueOf(jTextField1.getText())+String.valueOf(jLabel25.getText()+String.valueOf(jTextField2.getText())));//fill table record for entered companyId
        lbl500_CustomerCount.setText(String.valueOf(jTable1.getRowCount())+ " Record/s found");//get row count
    
    }//GEN-LAST:event_jTextField2KeyReleased

    private void cmb500_updateCompKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb500_updateCompKeyReleased

    }//GEN-LAST:event_cmb500_updateCompKeyReleased

    private void cmb500_updateCompKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb500_updateCompKeyTyped
      
    }//GEN-LAST:event_cmb500_updateCompKeyTyped

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DemoCustomer;
    private javax.swing.JButton btb501_AddCustomer;
    private javax.swing.JButton btn502_updateCust;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmb500_updateComp;
    private javax.swing.JComboBox<String> cmb500_updtCountry;
    private javax.swing.JComboBox<String> cmb501_compCountry;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    protected javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel jpnl501_AddCustomer;
    private javax.swing.JPanel jpnl502_ViewCustomer;
    private javax.swing.JPanel jpnl503_UpdateCustomer;
    private javax.swing.JLabel lbl500_AddCompAddressErr;
    private javax.swing.JLabel lbl500_AddCompCityErr;
    private javax.swing.JLabel lbl500_AddCompCountryErr;
    private javax.swing.JLabel lbl500_AddCompEmailErr;
    private javax.swing.JLabel lbl500_AddCompNameErr;
    private javax.swing.JLabel lbl500_AddCompPostalErr;
    private javax.swing.JLabel lbl500_AddCompTelephoneErr;
    private javax.swing.JLabel lbl500_CustomerCount;
    private javax.swing.JLabel lbl500_UpdtCompNAddressErr;
    private javax.swing.JLabel lbl500_UpdtCompNameErr;
    private javax.swing.JLabel lbl500_UpdtPostalErr;
    private javax.swing.JLabel lbl500_UpdtSelectNameErr;
    private javax.swing.JLabel lbl500updte_compCountryErr;
    private javax.swing.JLabel lbl501_UpdtCompTelephoneErr;
    private javax.swing.JLabel lbl502_updtCompEmailErr1;
    private javax.swing.JLabel lbl502_updtCompTypeErr;
    private javax.swing.JTable tbl500updte_Customer;
    private javax.swing.JTextField txt500Update_compCity;
    private javax.swing.JTextField txt500_AddCompPostal;
    private javax.swing.JTextField txt500_AddCompTelephone1;
    private javax.swing.JTextField txt500_AddCompTelephone2;
    private javax.swing.JTextField txt500_UpdtCompEmail;
    private javax.swing.JTextField txt500_UpdtCompId;
    private javax.swing.JTextField txt500_UpdtCompName;
    private javax.swing.JTextField txt500_UpdtCompPostal;
    private javax.swing.JTextField txt500_UpdtCompTelephone1;
    private javax.swing.JTextField txt500_UpdtCompTelephone3;
    private javax.swing.JTextField txt501_AddCompId;
    private javax.swing.JTextField txt502_AddCompName;
    private javax.swing.JTextField txt503_AddCompEmail;
    private javax.swing.JTextField txt505_AddCompTelephone3;
    private javax.swing.JTextField txt508_AddCompCity;
    private javax.swing.JTextField txt50_UpdtCompTelephone2;
    private javax.swing.JTextArea txtAr500_updtCompAddress;
    private javax.swing.JTextArea txtAr501_addcompAddress;
    // End of variables declaration//GEN-END:variables
}
