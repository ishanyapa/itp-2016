/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Calendar.DATE;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author user
 */

public class maintainance extends javax.swing.JPanel {

    

    /**
     * Creates new form Maintenance
     */
     String sqlMaintainance =  "SELECt maintenanceId AS 'Maintenance ID',itemId AS 'Item ID',repairDate AS 'Repair Date',repairPeriod AS 'Repair Period' FROM maintenance where repairDate <= '"+dateAndTime.getDateAndTime("yyyy-MM-dd")+"'" ;
      boolean mode = false;
       String selected;
       
     public maintainance() {
        initComponents();
        //set visibility
        lbl485.setVisible(false);
        lbl413.setVisible(false);
        lbl495.setVisible(false);
        lbl414.setVisible(false);
        lbl415.setVisible(false);
        lbl486.setVisible(false);
        lbl487.setVisible(false);
        lbl488.setVisible(false);
        lbl416.setVisible(false);
        
        
        
        //set Editable
        txtF484.setEditable(false);
       jdatecho481.setEnabled(false);
       jsp401.setEnabled(false);
       txtAr484.setEditable(false);
       btn486.setEnabled(false);
        btn487.setEnabled(false);
       
      
       btn497.setEnabled(false);
        
        
         DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
         try{
        jdatecho480.setDate(df.parse(dateAndTime.getDateAndTime("dd-MM-yyyy")));
         }catch(Exception e){}
        
        
        
        //set date
        String date = dateAndTime.getDateAndTime("yyyy-MM-dd");
        lbl484.setText(date);
        lbl481.setText(date);
        
        //show table
       
       
        TechnicalServiceDbAcess obtMain =new  TechnicalServiceDbAcess();
        obtMain.fillTable(tbl480, sqlMaintainance);
        
        
        
         TechnicalServiceDbAcess obtAddMachine = new TechnicalServiceDbAcess();
            String maintenanceId=obtAddMachine.GetIncrementedId("maintenance","maintenanceID");
            txtF482.setText(maintenanceId);
        
       
        
        spi480.setValue(1);
        
     
        
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
        jLabel13 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl480 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtF480 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        lbl481 = new javax.swing.JLabel();
        btn486 = new javax.swing.JButton();
        btn487 = new javax.swing.JButton();
        btn485 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAr480 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtF481 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        lbl484 = new javax.swing.JLabel();
        lbl485 = new javax.swing.JLabel();
        spi480 = new javax.swing.JSpinner();
        jdatecho480 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtF482 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAr482 = new javax.swing.JTextArea();
        lbl486 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbl487 = new javax.swing.JLabel();
        lbl488 = new javax.swing.JLabel();
        pnl4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtF483 = new javax.swing.JTextField();
        txtF484 = new javax.swing.JTextField();
        jdatecho481 = new com.toedter.calendar.JDateChooser();
        jsp401 = new javax.swing.JSpinner();
        btn496 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtAr484 = new javax.swing.JTextArea();
        lbl413 = new javax.swing.JLabel();
        lbl415 = new javax.swing.JLabel();
        lbl414 = new javax.swing.JLabel();
        lbl416 = new javax.swing.JLabel();
        btn497 = new javax.swing.JButton();
        lbl495 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel13.setText("jLabel13");

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(790, 590));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl480.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Maintenance ID", "Item ID", "Date", "repair period"
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
        tbl480.setName("tbl480"); // NOI18N
        tbl480.setRowHeight(25);
        tbl480.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl480MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl480);
        if (tbl480.getColumnModel().getColumnCount() > 0) {
            tbl480.getColumnModel().getColumn(0).setResizable(false);
            tbl480.getColumnModel().getColumn(1).setResizable(false);
            tbl480.getColumnModel().getColumn(2).setResizable(false);
            tbl480.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText(" Maintenance ID/Iteam Id/Date");
        jLabel2.setName("lbl480"); // NOI18N

        txtF480.setName("txtF480"); // NOI18N
        txtF480.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF480KeyReleased(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Date "));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl481, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(lbl481, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        btn486.setText("Create complain");
        btn486.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn486ActionPerformed(evt);
            }
        });

        btn487.setText("Delete");
        btn487.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn487ActionPerformed(evt);
            }
        });

        btn485.setText("View All");
        btn485.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn485ActionPerformed(evt);
            }
        });

        txtAr480.setColumns(20);
        txtAr480.setRows(5);
        txtAr480.setBorder(javax.swing.BorderFactory.createTitledBorder("Discription"));
        jScrollPane3.setViewportView(txtAr480);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(txtF480, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btn485, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn486, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn487, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF480, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn485))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn486, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn487, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jTabbedPane1.addTab("View", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Item ID");
        jLabel3.setName("lbl481"); // NOI18N

        jLabel4.setText("Initial Date");
        jLabel4.setName("lbl482"); // NOI18N

        jLabel5.setText("Time period");
        jLabel5.setName("lbl483"); // NOI18N

        jButton2.setText("Add");
        jButton2.setName("btn482"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtF481.setName("txtF481"); // NOI18N
        txtF481.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF481ActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Date"));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl484, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lbl484, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbl485.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl485.setForeground(new java.awt.Color(255, 0, 0));
        lbl485.setText("!");
        lbl485.setName("lbl485"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Months");

        jLabel7.setText("Maintainance Id");

        txtF482.setEditable(false);

        txtAr482.setColumns(20);
        txtAr482.setRows(5);
        txtAr482.setBorder(javax.swing.BorderFactory.createTitledBorder("Discription"));
        jScrollPane2.setViewportView(txtAr482);

        lbl486.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl486.setForeground(new java.awt.Color(255, 0, 0));
        lbl486.setText("!");
        lbl486.setName("lbl485"); // NOI18N

        jButton1.setText("demo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl487.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl487.setForeground(new java.awt.Color(255, 0, 0));
        lbl487.setText("!");
        lbl487.setName("lbl485"); // NOI18N

        lbl488.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl488.setForeground(new java.awt.Color(255, 0, 0));
        lbl488.setText("!");
        lbl488.setName("lbl485"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addComponent(txtF482, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3)
                .addGap(88, 88, 88)
                .addComponent(txtF481, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl485))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4)
                .addGap(69, 69, 69)
                .addComponent(jdatecho480, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbl487, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel5)
                .addGap(61, 61, 61)
                .addComponent(spi480, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbl488, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbl486, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtF482, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(txtF481, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl485)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdatecho480, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl487))))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(spi480, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl488)
                    .addComponent(jLabel6))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lbl486))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton1)
                        .addGap(15, 15, 15)
                        .addComponent(jButton2))))
        );

        jTabbedPane1.addTab("Add", jPanel2);

        pnl4.setBackground(new java.awt.Color(255, 255, 255));
        pnl4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Maintainance Id");
        pnl4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel9.setText("Item Id");
        pnl4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, -1));

        jLabel10.setText("Date");
        pnl4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel11.setText("Repair period");
        pnl4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
        pnl4.add(txtF483, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 30, 222, -1));
        pnl4.add(txtF484, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 100, -1));
        pnl4.add(jdatecho481, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 140, -1));
        pnl4.add(jsp401, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 60, -1));

        btn496.setText("Search");
        btn496.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn496ActionPerformed(evt);
            }
        });
        pnl4.add(btn496, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Months");
        pnl4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        txtAr484.setColumns(20);
        txtAr484.setRows(5);
        txtAr484.setBorder(javax.swing.BorderFactory.createTitledBorder("Discription"));
        pnl4.add(txtAr484, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 288, 650, 150));

        lbl413.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl413.setForeground(new java.awt.Color(255, 51, 51));
        lbl413.setText("!");
        pnl4.add(lbl413, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 135, 30, -1));

        lbl415.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl415.setForeground(new java.awt.Color(255, 51, 51));
        lbl415.setText("!");
        pnl4.add(lbl415, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 375, 30, -1));

        lbl414.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl414.setForeground(new java.awt.Color(255, 51, 51));
        lbl414.setText("!");
        pnl4.add(lbl414, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 10, -1));

        lbl416.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl416.setForeground(new java.awt.Color(255, 51, 51));
        lbl416.setText("!");
        pnl4.add(lbl416, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 30, -1));

        btn497.setText("Update");
        btn497.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn497ActionPerformed(evt);
            }
        });
        pnl4.add(btn497, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 477, -1, -1));

        lbl495.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl495.setForeground(new java.awt.Color(255, 51, 51));
        lbl495.setText("!");
        pnl4.add(lbl495, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 20, -1));

        jTabbedPane1.addTab("Update Deatils", pnl4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        lbl485.setVisible(false);
        lbl486.setVisible(false);
         lbl487.setVisible(false);
          lbl488.setVisible(false);
        boolean check= true,ckeckDate=true,checkTimePriod=true;
        
        
        //get data
        String itemId = txtF481.getText();
        SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
        String strDate = ft.format(jdatecho480.getDate());
        int timePeriod = (Integer) spi480.getValue();
        TechnicalServiceDbAcess obt = new TechnicalServiceDbAcess();
        textValidator obtm = new textValidator();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDate = new Date();
        
        if(obtm.isNull(txtAr482.getText())){
        lbl486.setVisible(true);
        }
        
        if(!obt.checkAvalability("machinery", "machineId", itemId) && !obt.checkAvalability("plant", "plantId", itemId) && !obt.checkAvalability("vehicle", "vehicleNo", itemId)) {
             lbl485.setVisible(true);
            check = false;
        }
        
        if(jdatecho480.getDate().before(toDate)){
        ckeckDate = false;
        lbl487.setVisible(true);
        }
        if(timePeriod < 1){
        checkTimePriod = false;
        lbl488.setVisible(true);
        }
        
        if(!obtm.isNull(txtAr482.getText()) && check  &&  ckeckDate &&  checkTimePriod){
        obt.addMaintainance(txtF482.getText(), itemId, strDate,timePeriod,txtAr482.getText());
        
            SetPanel p1 = new SetPanel();
            maintainance m= new maintainance();
            
            p1.SetPanel(m);
            
             JFrame parent = new JFrame();
             JOptionPane.showMessageDialog(parent, "Maintainance Added");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn486ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn486ActionPerformed
       String selectedId = (String) tbl480.getModel().getValueAt(tbl480.getSelectedRow(),0);
       TechnicalServiceDbAcess obtUpdateDate = new  TechnicalServiceDbAcess();
       obtUpdateDate.resetMaintainananceDate(selectedId);
       
       String selectedItemId = (String) tbl480.getModel().getValueAt(tbl480.getSelectedRow(),1);
       
       
        SetPanel p2 = new SetPanel();
        complain c= new complain();
        p2.SetPanel(c);
       c.setComplain(selectedItemId, txtAr480.getText());
       
       
    }//GEN-LAST:event_btn486ActionPerformed

    private void txtF481ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF481ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF481ActionPerformed

    private void btn487ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn487ActionPerformed
           String  selected = (String) tbl480.getModel().getValueAt(tbl480.getSelectedRow(),0);
           TechnicalServiceDbAcess dMain = new TechnicalServiceDbAcess();
          
          
           JDialog.setDefaultLookAndFeelDecorated(true);
          int response = JOptionPane.showConfirmDialog(null, "Do you want to Delete?", "Confirm",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          
          if (response == JOptionPane.YES_OPTION) {
            dMain.deleteMaintenance(selected);
            
              SetPanel p1 = new SetPanel();
             maintainance m= new maintainance();
             p1.SetPanel(m);
          }
    }//GEN-LAST:event_btn487ActionPerformed

    private void txtF480KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF480KeyReleased
         String searchId = txtF480.getText();        
        
        textValidator obtCom = new  textValidator();
        TechnicalServiceDbAcess obtSearch =new  TechnicalServiceDbAcess();
        
         if(!obtCom.isNull(searchId)){
        
        obtSearch.searchingMain(tbl480, searchId);
        
        }
        else{
            
        String sqlMain= "SELECt maintenanceId AS 'Maintenance ID',itemId AS 'Item ID',repairDate AS 'Repair Date',repairPeriod AS 'Repair Period' FROM maintenance where repairDate <= '"+dateAndTime.getDateAndTime("yyyy-MM-dd")+"'" ;
        obtSearch.fillTable(tbl480, sqlMain);
        }
    }//GEN-LAST:event_txtF480KeyReleased

    private void btn485ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn485ActionPerformed
       
       
   
        TechnicalServiceDbAcess obtSearch =new  TechnicalServiceDbAcess();
         String sqlMainAll= "SELECt maintenanceId AS 'Maintenance ID',itemId AS 'Item ID',repairDate AS 'Repair Date',repairPeriod AS 'Repair Period' FROM maintenance " ;
        if(mode == false){
         obtSearch.fillTable(tbl480, sqlMainAll);
         mode = true;
         btn485.setText("view Relevent");
        }
        else{
         obtSearch.fillTable(tbl480, sqlMaintainance);
         mode = false;
         btn485.setText("view All");
        }
    }//GEN-LAST:event_btn485ActionPerformed

    private void tbl480MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl480MouseClicked
       selected = (String) tbl480.getModel().getValueAt(tbl480.getSelectedRow(),0);
        
        TechnicalServiceDbAcess obtMain2 = new TechnicalServiceDbAcess("maintenance");
        obtMain2.getdiscription(selected, txtAr480, "maintenanceId");
        
        btn486.setEnabled(true);
        btn487.setEnabled(true);
       // jsp401.set
    }//GEN-LAST:event_tbl480MouseClicked

    private void btn496ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn496ActionPerformed
     
        txtF484.setEditable(false);
       jdatecho481.setEnabled(false);
       jsp401.setEnabled(false);
       txtAr484.setEditable(false);
       btn497.setEnabled(false);
        
        
        
        
        
        lbl495.setVisible(false);
        TechnicalServiceDbAcess obtUpdate = new TechnicalServiceDbAcess();
      
      if(!obtUpdate.checkAvalability("maintenance","maintenanceId",txtF483.getText()) ){
      lbl495.setVisible(true);
      }
      else{
      obtUpdate.setUpdateMainDetails(txtF483.getText(), txtF484, jdatecho481, jsp401, txtAr484);
       
       txtF484.setEditable(true);
       jdatecho481.setEnabled(true);
       jsp401.setEnabled(true);
       txtAr484.setEditable(true);
        btn497.setEnabled(true);
      }
    }//GEN-LAST:event_btn496ActionPerformed

    private void btn497ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn497ActionPerformed
      textValidator obtUpdate = new textValidator();
      TechnicalServiceDbAcess obtDb = new TechnicalServiceDbAcess();
      boolean checktime=true,item=true,checkDate = true;
      
      lbl416.setVisible(false);
      lbl414.setVisible(false);
      lbl413.setVisible(false);
      
      
      SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
      
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date toDate = new Date();

        
      //validate
      if(obtUpdate.isNull(txtAr484.getText()))
          lbl415.setVisible(true);
      
      if((Integer)jsp401.getValue() < 1){
           lbl414.setVisible(true);
           checktime=false;
      }
       if(!obtDb.checkAvalability("machinery", "machineId", txtF484.getText()) && 
               !obtDb.checkAvalability("plant", "plantId", txtF484.getText()) && 
               !obtDb.checkAvalability("vehicle", "vehicleNo", txtF484.getText())){
          lbl413.setVisible(true);
          item = false;
       }
       
      if(jdatecho481.getDate().before(toDate)){
        checkDate = false;
        lbl416.setVisible(true);
        }
       
       //adding data
       
       if(item && 
               checktime && !obtUpdate.isNull(txtAr484.getText()) &&  checkDate) {
          
           obtDb.updateMaintainanceDetails(txtF483.getText(), txtF484.getText(), ft.format(jdatecho480.getDate()),(Integer) jsp401.getValue() , txtAr484.getText());
           
            JFrame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Updated");
           
           SetPanel obtP = new SetPanel();
           maintainance obtC= new maintainance();
           obtP.SetPanel(obtC);
       }
        
          
    }//GEN-LAST:event_btn497ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtF481.setText("MAC05");
        spi480.setValue(5);
        txtAr482.setText("change the oil");
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn485;
    private javax.swing.JButton btn486;
    private javax.swing.JButton btn487;
    private javax.swing.JButton btn496;
    private javax.swing.JButton btn497;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private com.toedter.calendar.JDateChooser jdatecho480;
    private com.toedter.calendar.JDateChooser jdatecho481;
    private javax.swing.JSpinner jsp401;
    private javax.swing.JLabel lbl413;
    private javax.swing.JLabel lbl414;
    private javax.swing.JLabel lbl415;
    private javax.swing.JLabel lbl416;
    private javax.swing.JLabel lbl481;
    private javax.swing.JLabel lbl484;
    private javax.swing.JLabel lbl485;
    private javax.swing.JLabel lbl486;
    private javax.swing.JLabel lbl487;
    private javax.swing.JLabel lbl488;
    private javax.swing.JLabel lbl495;
    private javax.swing.JPanel pnl4;
    private javax.swing.JSpinner spi480;
    private javax.swing.JTable tbl480;
    private javax.swing.JTextArea txtAr480;
    private javax.swing.JTextArea txtAr482;
    private javax.swing.JTextArea txtAr484;
    private javax.swing.JTextField txtF480;
    private javax.swing.JTextField txtF481;
    private javax.swing.JTextField txtF482;
    private javax.swing.JTextField txtF483;
    private javax.swing.JTextField txtF484;
    // End of variables declaration//GEN-END:variables

  

  

}


