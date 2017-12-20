/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PurchaseManagement;

import RootElement.DbConnect;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Samitha Heanthenna
 */
public class PurchaseOrders extends javax.swing.JPanel {

    /**
     * Creates new form PurchaseOrders
     */
    public PurchaseOrders() {
        
        ComboKeyHandler cm;
        ComboKeyHandler cm2;
        ComboKeyHandler cm3;
        ComboKeyHandler cm4;

        
        initComponents();
        
        btn313.requestFocusInWindow();
        
        DbConnect c=new DbConnect();
        c.setConnection();
        
            try
            {                                                                             
                ResultSet qresults;
                Statement statem1=c.con.createStatement();
                qresults=statem1.executeQuery("select * from purchase");
                               
                String ids="";
            
                while(qresults.next())
                {
                    ids=qresults.getString("purchaseId");
                }
                
                IdIncrementPurchase inc=new IdIncrementPurchase(ids,'p');
                String newids=inc.getIncrementedId();
                
                txtF302.setText(newids);
                txtF321.setText(newids);
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Error Connecting to Database", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try 
                {
                c.con.close();
                } 
                catch (SQLException ex) 
                {
                Logger.getLogger(PurchaseOrders.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            DbAccessPurchase dba = new DbAccessPurchase("itemlist","itemName");
            dba.fillCombo(cmb303);
            cm=new ComboKeyHandler(cmb303);
            
            cmb303.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                cm.keyTyped(e);
            }
        });
            
            dba.fillCombo(cmb325);
            cm2=new ComboKeyHandler(cmb325);
            
            cmb325.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                cm2.keyTyped(e);
            }
        });
            
            
            DbAccessPurchase dba2 = new DbAccessPurchase("purchaserequest");
            dba2.itemListTablerequest(tbl320,lblResultCount5);
            
            DbAccessPurchase dba3 =new DbAccessPurchase();
            dba3.fillComboRequest(cmb348);
            cm3=new ComboKeyHandler(cmb348);
            
            cmb348.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                cm3.keyTyped(e);
            }
        });
            
            cmb353.setSelectedIndex(0);
            lbl355.setText("");
            DbAccessPurchase dba4 = new DbAccessPurchase("purchase");
            dba4.fillTableLocalPur(tbl317, lblResultCount2);
        
            DbAccessPurchase dba5= new DbAccessPurchase("purchase", "purchaseVia","Local");
            cmb399.removeAllItems();
            dba5.fillNextCombo2(cmb399);
            
            
            lbl363.setText("");
            cmb362.setSelectedIndex(0);
            DbAccessPurchase dba6 = new DbAccessPurchase("purchase");
            dba6.fillTableForignPur(tbl318, lblResultCount3);
        
            DbAccessPurchase dba7= new DbAccessPurchase("purchase", "purchaseVia","Foreign");
            cmb398.removeAllItems();
            dba7.fillNextCombo2(cmb398);
            
            dba6.fillNextCombopurreport(cmb378);
            cm4=new ComboKeyHandler(cmb378);
            
            cmb378.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                cm4.keyTyped(e);
            }
        });
            
            clndr389.setDate(new Date());
            clndr394.setDate(new Date());
            
            clndr306.setMaxSelectableDate(new Date());
            clndr330.setMaxSelectableDate(new Date());
            clndr344.setMaxSelectableDate(new Date());
            clndr389.setMaxSelectableDate(new Date());
            clndr394.setMaxSelectableDate(new Date());
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnl394 = new javax.swing.JTabbedPane();
        jpnl301 = new javax.swing.JPanel();
        lblPurchaseID = new javax.swing.JLabel();
        txtF302 = new javax.swing.JTextField();
        lblItemName = new javax.swing.JLabel();
        cmb303 = new javax.swing.JComboBox<>();
        lblItemID = new javax.swing.JLabel();
        cmb304 = new javax.swing.JComboBox<>();
        lblQuentity = new javax.swing.JLabel();
        spnnr305 = new javax.swing.JSpinner();
        lblDatePurchased = new javax.swing.JLabel();
        clndr306 = new com.toedter.calendar.JDateChooser();
        lblPurchaseType = new javax.swing.JLabel();
        cmb307 = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        txtF309 = new javax.swing.JTextField();
        lblPaymentMethod = new javax.swing.JLabel();
        cmb310 = new javax.swing.JComboBox<>();
        jpnl311 = new javax.swing.JPanel();
        tbl312 = new javax.swing.JScrollPane();
        tbl314 = new javax.swing.JTable();
        lblResultCount = new javax.swing.JLabel();
        btn313 = new javax.swing.JButton();
        btn314 = new javax.swing.JButton();
        lbl315 = new javax.swing.JLabel();
        lbl316 = new javax.swing.JLabel();
        lbl317 = new javax.swing.JLabel();
        lbl318 = new javax.swing.JLabel();
        lbl319 = new javax.swing.JLabel();
        btn399 = new javax.swing.JButton();
        lbl320 = new javax.swing.JLabel();
        jpnl320 = new javax.swing.JPanel();
        lblPurchaseID1 = new javax.swing.JLabel();
        txtF321 = new javax.swing.JTextField();
        jpnl322 = new javax.swing.JPanel();
        tbl323 = new javax.swing.JScrollPane();
        tbl315 = new javax.swing.JTable();
        lblResultCount1 = new javax.swing.JLabel();
        btn324 = new javax.swing.JButton();
        lblItemName1 = new javax.swing.JLabel();
        lblItemID1 = new javax.swing.JLabel();
        cmb325 = new javax.swing.JComboBox<>();
        cmb326 = new javax.swing.JComboBox<>();
        lbl327 = new javax.swing.JLabel();
        lbl328 = new javax.swing.JLabel();
        spnnr329 = new javax.swing.JSpinner();
        lblQuentity1 = new javax.swing.JLabel();
        lblDatePurchased1 = new javax.swing.JLabel();
        clndr330 = new com.toedter.calendar.JDateChooser();
        lbl331 = new javax.swing.JLabel();
        lbl332 = new javax.swing.JLabel();
        cmb333 = new javax.swing.JComboBox<>();
        lblPurchaseType1 = new javax.swing.JLabel();
        txtF335 = new javax.swing.JTextField();
        lblStatus1 = new javax.swing.JLabel();
        lblPaymentMethod1 = new javax.swing.JLabel();
        cmb336 = new javax.swing.JComboBox<>();
        lblBankName = new javax.swing.JLabel();
        cmb338 = new javax.swing.JComboBox<>();
        lbl339 = new javax.swing.JLabel();
        txtF340 = new javax.swing.JTextField();
        lblBranchCode = new javax.swing.JLabel();
        lbl341 = new javax.swing.JLabel();
        lblLCNo = new javax.swing.JLabel();
        txtF342 = new javax.swing.JTextField();
        lbl343 = new javax.swing.JLabel();
        lblLCDate = new javax.swing.JLabel();
        clndr344 = new com.toedter.calendar.JDateChooser();
        lbl345 = new javax.swing.JLabel();
        btn346 = new javax.swing.JButton();
        lbl337 = new javax.swing.JLabel();
        btn400 = new javax.swing.JButton();
        jpnl347 = new javax.swing.JPanel();
        jpnl348 = new javax.swing.JPanel();
        tbl308 = new javax.swing.JScrollPane();
        tbl317 = new javax.swing.JTable();
        lblResultCount2 = new javax.swing.JLabel();
        lblSearchPurchaseID = new javax.swing.JLabel();
        txtF349 = new javax.swing.JTextField();
        btn351 = new javax.swing.JButton();
        lblPurchaseid = new javax.swing.JLabel();
        lblstatus = new javax.swing.JLabel();
        cmb353 = new javax.swing.JComboBox<>();
        btn354 = new javax.swing.JButton();
        lbl355 = new javax.swing.JLabel();
        cmb399 = new javax.swing.JComboBox<>();
        jpnl356 = new javax.swing.JPanel();
        lblSearchPurchaseID1 = new javax.swing.JLabel();
        txtF357 = new javax.swing.JTextField();
        btn359 = new javax.swing.JButton();
        jpnl360 = new javax.swing.JPanel();
        tbl357 = new javax.swing.JScrollPane();
        tbl318 = new javax.swing.JTable();
        lblResultCount3 = new javax.swing.JLabel();
        lblPurchaseid1 = new javax.swing.JLabel();
        lblstatus1 = new javax.swing.JLabel();
        cmb362 = new javax.swing.JComboBox<>();
        lbl363 = new javax.swing.JLabel();
        btn364 = new javax.swing.JButton();
        cmb398 = new javax.swing.JComboBox<>();
        jpnl398 = new javax.swing.JPanel();
        jpnl349 = new javax.swing.JPanel();
        tbl309 = new javax.swing.JScrollPane();
        tbl320 = new javax.swing.JTable();
        lblResultCount5 = new javax.swing.JLabel();
        cmb348 = new javax.swing.JComboBox<>();
        lblPurchaseid2 = new javax.swing.JLabel();
        lblstatus2 = new javax.swing.JLabel();
        cmb354 = new javax.swing.JComboBox<>();
        btn355 = new javax.swing.JButton();
        lbl321 = new javax.swing.JLabel();
        jpnl326 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cmb378 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jpnl336 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmb355 = new javax.swing.JComboBox<>();
        btn356 = new javax.swing.JButton();
        clndr389 = new com.toedter.calendar.JDateChooser();
        clndr394 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 590));

        jpnl301.setBackground(new java.awt.Color(255, 255, 255));
        jpnl301.setPreferredSize(new java.awt.Dimension(790, 590));

        lblPurchaseID.setText("Purchase ID");

        txtF302.setEditable(false);

        lblItemName.setText("Item name");

        cmb303.setBackground(new java.awt.Color(240, 240, 240));
        cmb303.setEditable(true);
        cmb303.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb303FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb303FocusLost(evt);
            }
        });
        cmb303.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb303MouseClicked(evt);
            }
        });
        cmb303.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb303ActionPerformed(evt);
            }
        });
        cmb303.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb303PropertyChange(evt);
            }
        });

        lblItemID.setText("Item ID");

        cmb304.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb304FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb304FocusLost(evt);
            }
        });
        cmb304.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb304ActionPerformed(evt);
            }
        });

        lblQuentity.setText("Quantity");

        spnnr305.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblDatePurchased.setText("Date purchased");

        clndr306.setMaxSelectableDate(new java.util.Date(1790015340000L));
        clndr306.setMinSelectableDate(new java.util.Date(1451590291000L));
        clndr306.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clndr306FocusLost(evt);
            }
        });
        clndr306.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clndr306MouseClicked(evt);
            }
        });

        lblPurchaseType.setText("Purchase type");

        cmb307.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trading", "Manufacturing" }));
        cmb307.setSelectedIndex(-1);
        cmb307.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb307FocusLost(evt);
            }
        });

        lblStatus.setText("Status");

        txtF309.setEditable(false);

        lblPaymentMethod.setText("Payment method");

        cmb310.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit" }));
        cmb310.setSelectedIndex(-1);
        cmb310.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb310FocusLost(evt);
            }
        });

        jpnl311.setBackground(new java.awt.Color(255, 255, 255));
        jpnl311.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Suppliers"));

        tbl314.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Supplier ID", "Item ID", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl312.setViewportView(tbl314);

        lblResultCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl311Layout = new javax.swing.GroupLayout(jpnl311);
        jpnl311.setLayout(jpnl311Layout);
        jpnl311Layout.setHorizontalGroup(
            jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl311Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl311Layout.createSequentialGroup()
                        .addComponent(lblResultCount, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addComponent(tbl312, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnl311Layout.setVerticalGroup(
            jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl311Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl312, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultCount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn313.setText("Order");
        btn313.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn313ActionPerformed(evt);
            }
        });

        btn314.setText("Cancel");
        btn314.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn314ActionPerformed(evt);
            }
        });

        lbl315.setBackground(new java.awt.Color(255, 255, 255));
        lbl315.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl315.setForeground(new java.awt.Color(255, 0, 0));

        lbl316.setBackground(new java.awt.Color(255, 255, 255));
        lbl316.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl316.setForeground(new java.awt.Color(255, 0, 0));

        lbl317.setBackground(new java.awt.Color(255, 255, 255));
        lbl317.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl317.setForeground(new java.awt.Color(255, 0, 0));

        lbl318.setBackground(new java.awt.Color(255, 255, 255));
        lbl318.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl318.setForeground(new java.awt.Color(255, 0, 0));

        lbl319.setBackground(new java.awt.Color(255, 255, 255));
        lbl319.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl319.setForeground(new java.awt.Color(255, 0, 0));

        btn399.setText("Demo");
        btn399.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn399ActionPerformed(evt);
            }
        });

        lbl320.setBackground(new java.awt.Color(255, 255, 255));
        lbl320.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl320.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jpnl301Layout = new javax.swing.GroupLayout(jpnl301);
        jpnl301.setLayout(jpnl301Layout);
        jpnl301Layout.setHorizontalGroup(
            jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl301Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPurchaseID)
                    .addComponent(lblItemName)
                    .addComponent(lblItemID)
                    .addComponent(lblQuentity)
                    .addComponent(lblDatePurchased)
                    .addComponent(lblPurchaseType)
                    .addComponent(lblStatus)
                    .addComponent(lblPaymentMethod))
                .addGap(29, 29, 29)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtF302, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnnr305, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(cmb310, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl319, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(cmb304, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl316, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(cmb303, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl315, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(clndr306, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl320, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl317))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(cmb307, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl318, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtF309, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(btn399, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn313, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn314, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnl311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jpnl301Layout.setVerticalGroup(
            jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl301Layout.createSequentialGroup()
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF302, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPurchaseID))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb303, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblItemName))
                            .addComponent(lbl315, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb304, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblItemID))
                            .addComponent(lbl316, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnnr305, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuentity))
                        .addGap(23, 23, 23)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl301Layout.createSequentialGroup()
                                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl317, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clndr306, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDatePurchased, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(24, 24, 24)
                                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl318, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmb307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPurchaseType))))
                            .addComponent(lbl320, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF309, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))
                        .addGap(22, 22, 22)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl319, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPaymentMethod)
                                .addComponent(cmb310, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnl311, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn314)
                    .addComponent(btn313)
                    .addComponent(btn399)))
        );

        jpnl394.addTab("Local Purchase", jpnl301);

        jpnl320.setBackground(new java.awt.Color(255, 255, 255));

        lblPurchaseID1.setText("Purchase ID");

        txtF321.setEditable(false);

        jpnl322.setBackground(new java.awt.Color(255, 255, 255));
        jpnl322.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Suppliers"));

        tbl315.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Supplier ID", "Item ID", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl323.setViewportView(tbl315);

        lblResultCount1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount1.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount1.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl322Layout = new javax.swing.GroupLayout(jpnl322);
        jpnl322.setLayout(jpnl322Layout);
        jpnl322Layout.setHorizontalGroup(
            jpnl322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl322Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl322Layout.createSequentialGroup()
                        .addComponent(lblResultCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addComponent(tbl323, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnl322Layout.setVerticalGroup(
            jpnl322Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl322Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl323, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn324.setText("Cancel");
        btn324.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn324ActionPerformed(evt);
            }
        });

        lblItemName1.setText("Item name");

        lblItemID1.setText("Item ID");

        cmb325.setBackground(new java.awt.Color(240, 240, 240));
        cmb325.setEditable(true);
        cmb325.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb325FocusLost(evt);
            }
        });
        cmb325.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb325MouseClicked(evt);
            }
        });
        cmb325.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb325ActionPerformed(evt);
            }
        });
        cmb325.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb325PropertyChange(evt);
            }
        });

        cmb326.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb326FocusLost(evt);
            }
        });
        cmb326.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb326ActionPerformed(evt);
            }
        });

        lbl327.setBackground(new java.awt.Color(255, 255, 255));
        lbl327.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl327.setForeground(new java.awt.Color(255, 0, 0));

        lbl328.setBackground(new java.awt.Color(255, 255, 255));
        lbl328.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl328.setForeground(new java.awt.Color(255, 0, 0));

        spnnr329.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblQuentity1.setText("Quantity");

        lblDatePurchased1.setText("Date purchased");

        clndr330.setMaxSelectableDate(new java.util.Date(1790015340000L));
        clndr330.setMinSelectableDate(new java.util.Date(1451590291000L));
        clndr330.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clndr330FocusLost(evt);
            }
        });

        lbl331.setBackground(new java.awt.Color(255, 255, 255));
        lbl331.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl331.setForeground(new java.awt.Color(255, 0, 0));

        lbl332.setBackground(new java.awt.Color(255, 255, 255));
        lbl332.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl332.setForeground(new java.awt.Color(255, 0, 0));

        cmb333.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trading", "Manufacturing" }));
        cmb333.setSelectedIndex(-1);
        cmb333.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb333FocusLost(evt);
            }
        });
        cmb333.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb333ActionPerformed(evt);
            }
        });

        lblPurchaseType1.setText("Purchase type");

        txtF335.setEditable(false);

        lblStatus1.setText("Status");

        lblPaymentMethod1.setText("Payment method");

        cmb336.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit", "L/C" }));
        cmb336.setSelectedIndex(-1);
        cmb336.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb336FocusLost(evt);
            }
        });
        cmb336.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb336ActionPerformed(evt);
            }
        });

        lblBankName.setText("Bank name");

        cmb338.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bank of Ceylon", "Commercial Bank", "Seylan", "HSBC", "HNB" }));
        cmb338.setSelectedIndex(-1);
        cmb338.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb338FocusLost(evt);
            }
        });
        cmb338.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb338ActionPerformed(evt);
            }
        });

        lbl339.setBackground(new java.awt.Color(255, 255, 255));
        lbl339.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl339.setForeground(new java.awt.Color(255, 0, 0));

        txtF340.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF340FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF340FocusLost(evt);
            }
        });
        txtF340.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF340KeyTyped(evt);
            }
        });

        lblBranchCode.setText("Branch code");

        lbl341.setBackground(new java.awt.Color(255, 255, 255));
        lbl341.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl341.setForeground(new java.awt.Color(255, 0, 0));

        lblLCNo.setText("L/C Date");

        txtF342.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF342FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF342FocusLost(evt);
            }
        });
        txtF342.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF342KeyTyped(evt);
            }
        });

        lbl343.setBackground(new java.awt.Color(255, 255, 255));
        lbl343.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl343.setForeground(new java.awt.Color(255, 0, 0));

        lblLCDate.setText("L/C No");

        clndr344.setMaxSelectableDate(new java.util.Date(1790015340000L));
        clndr344.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clndr344FocusLost(evt);
            }
        });

        lbl345.setBackground(new java.awt.Color(255, 255, 255));
        lbl345.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl345.setForeground(new java.awt.Color(255, 0, 0));

        btn346.setText("Order");
        btn346.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn346ActionPerformed(evt);
            }
        });

        lbl337.setBackground(new java.awt.Color(255, 255, 255));
        lbl337.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl337.setForeground(new java.awt.Color(255, 0, 0));

        btn400.setText("Demo");
        btn400.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn400ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnl320Layout = new javax.swing.GroupLayout(jpnl320);
        jpnl320.setLayout(jpnl320Layout);
        jpnl320Layout.setHorizontalGroup(
            jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl320Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnl320Layout.createSequentialGroup()
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPurchaseID1)
                            .addComponent(lblItemName1)
                            .addComponent(lblItemID1)
                            .addComponent(lblQuentity1)
                            .addComponent(lblPurchaseType1)
                            .addComponent(lblPaymentMethod1)
                            .addComponent(lblStatus1)
                            .addComponent(lblDatePurchased1))
                        .addGap(29, 29, 29)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtF321, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtF335, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addComponent(cmb336, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl337, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addComponent(cmb325, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl327, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addComponent(clndr330, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl331, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addComponent(cmb333, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl332, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnnr329, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb326, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lbl328, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnl320Layout.createSequentialGroup()
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLCNo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLCDate, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtF342)
                                    .addComponent(clndr344, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl320Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl343, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl320Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(lbl345, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl320Layout.createSequentialGroup()
                                        .addComponent(lblBranchCode, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtF340, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnl320Layout.createSequentialGroup()
                                        .addComponent(lblBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(cmb338, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl339, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl341, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE))))
                        .addGap(1, 1, 1)))
                .addGap(41, 41, 41)
                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnl320Layout.createSequentialGroup()
                        .addComponent(btn400, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn346, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn324, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnl322, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jpnl320Layout.setVerticalGroup(
            jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl320Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl320Layout.createSequentialGroup()
                        .addComponent(jpnl322, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn346)
                            .addComponent(btn400)
                            .addComponent(btn324)))
                    .addGroup(jpnl320Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF321, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPurchaseID1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbl327, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblItemName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb325))))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl320Layout.createSequentialGroup()
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(clndr330, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDatePurchased1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblPurchaseType1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl320Layout.createSequentialGroup()
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl328, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmb326, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblItemID1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnnr329, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblQuentity1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(lbl331, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lbl332, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmb333, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtF335, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb336, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPaymentMethod1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl337, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb338, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl339))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl341)
                            .addGroup(jpnl320Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtF340, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBranchCode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl343)
                            .addComponent(clndr344, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLCNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnl320Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLCDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtF342))
                            .addComponent(lbl345, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpnl394.addTab("Foreign Purchase", jpnl320);

        jpnl347.setBackground(new java.awt.Color(255, 255, 255));

        jpnl348.setBackground(new java.awt.Color(255, 255, 255));
        jpnl348.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl317.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Purchase_ID", "Date_Purchased", "Quentity", "Status", "Payment_Type", "Purchase_Type", "Item_ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl308.setViewportView(tbl317);
        if (tbl317.getColumnModel().getColumnCount() > 0) {
            tbl317.getColumnModel().getColumn(1).setHeaderValue("Date_Purchased");
            tbl317.getColumnModel().getColumn(3).setHeaderValue("Status");
            tbl317.getColumnModel().getColumn(6).setHeaderValue("Item_ID");
        }

        lblResultCount2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount2.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount2.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl348Layout = new javax.swing.GroupLayout(jpnl348);
        jpnl348.setLayout(jpnl348Layout);
        jpnl348Layout.setHorizontalGroup(
            jpnl348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl348Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl308, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jpnl348Layout.createSequentialGroup()
                        .addComponent(lblResultCount2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnl348Layout.setVerticalGroup(
            jpnl348Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl348Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl308, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblResultCount2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblSearchPurchaseID.setText("Search by purchase ID");

        txtF349.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF349KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF349KeyTyped(evt);
            }
        });

        btn351.setText("View all");
        btn351.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn351ActionPerformed(evt);
            }
        });

        lblPurchaseid.setText("PurchaseID");

        lblstatus.setText("Current Status");

        cmb353.setBackground(new java.awt.Color(240, 240, 240));
        cmb353.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Ordered", "Received" }));
        cmb353.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb353ActionPerformed(evt);
            }
        });

        btn354.setText("Update ");
        btn354.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn354ActionPerformed(evt);
            }
        });

        lbl355.setBackground(new java.awt.Color(255, 255, 255));
        lbl355.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl355.setForeground(new java.awt.Color(255, 0, 0));

        cmb399.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb399FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb399FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpnl347Layout = new javax.swing.GroupLayout(jpnl347);
        jpnl347.setLayout(jpnl347Layout);
        jpnl347Layout.setHorizontalGroup(
            jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl347Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnl348, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnl347Layout.createSequentialGroup()
                        .addComponent(lblSearchPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtF349, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn351, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl347Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblstatus)
                    .addComponent(lblPurchaseid))
                .addGap(19, 19, 19)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb353, 0, 201, Short.MAX_VALUE)
                    .addComponent(cmb399, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl347Layout.createSequentialGroup()
                        .addComponent(lbl355, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl347Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn354, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jpnl347Layout.setVerticalGroup(
            jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl347Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF349, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchPurchaseID)
                    .addComponent(btn351))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jpnl348, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPurchaseid)
                    .addComponent(lbl355, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb399, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpnl347Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstatus)
                    .addComponent(cmb353, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn354))
                .addGap(75, 75, 75))
        );

        jpnl394.addTab("View Local Purchases", jpnl347);

        jpnl356.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchPurchaseID1.setText("Search by purchase ID");

        txtF357.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF357KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF357KeyTyped(evt);
            }
        });

        btn359.setText("View all");
        btn359.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn359ActionPerformed(evt);
            }
        });

        jpnl360.setBackground(new java.awt.Color(255, 255, 255));
        jpnl360.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl318.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Purchase_ID", "Date_Purchased", "Quentity", "Status", "Payment_Type", "Purchase_Type", "Item_ID", "LC_No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl357.setViewportView(tbl318);

        lblResultCount3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount3.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount3.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl360Layout = new javax.swing.GroupLayout(jpnl360);
        jpnl360.setLayout(jpnl360Layout);
        jpnl360Layout.setHorizontalGroup(
            jpnl360Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl360Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl360Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl357, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jpnl360Layout.createSequentialGroup()
                        .addComponent(lblResultCount3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnl360Layout.setVerticalGroup(
            jpnl360Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl360Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl357, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblResultCount3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblPurchaseid1.setText("PurchaseID");

        lblstatus1.setText("Current Status");

        cmb362.setBackground(new java.awt.Color(240, 240, 240));
        cmb362.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Ordered", "Received" }));
        cmb362.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb362ActionPerformed(evt);
            }
        });

        lbl363.setBackground(new java.awt.Color(255, 255, 255));
        lbl363.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl363.setForeground(new java.awt.Color(255, 0, 0));

        btn364.setText("Update ");
        btn364.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn364ActionPerformed(evt);
            }
        });

        cmb398.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb398FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpnl356Layout = new javax.swing.GroupLayout(jpnl356);
        jpnl356.setLayout(jpnl356Layout);
        jpnl356Layout.setHorizontalGroup(
            jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl356Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblstatus1)
                    .addComponent(lblPurchaseid1))
                .addGap(19, 19, 19)
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb362, 0, 201, Short.MAX_VALUE)
                    .addComponent(cmb398, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl356Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl363, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(399, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl356Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn364, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
            .addGroup(jpnl356Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnl360, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnl356Layout.createSequentialGroup()
                        .addComponent(lblSearchPurchaseID1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtF357, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn359, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnl356Layout.setVerticalGroup(
            jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl356Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF357, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchPurchaseID1)
                    .addComponent(btn359))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jpnl360, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPurchaseid1)
                    .addComponent(lbl363, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb398, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpnl356Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstatus1)
                    .addComponent(cmb362, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn364))
                .addGap(74, 74, 74))
        );

        jpnl394.addTab("View Foreign Purchases", jpnl356);

        jpnl398.setBackground(new java.awt.Color(255, 255, 255));

        jpnl349.setBackground(new java.awt.Color(255, 255, 255));
        jpnl349.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl320.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request_ID", "Request_Date", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl309.setViewportView(tbl320);

        lblResultCount5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount5.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount5.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl349Layout = new javax.swing.GroupLayout(jpnl349);
        jpnl349.setLayout(jpnl349Layout);
        jpnl349Layout.setHorizontalGroup(
            jpnl349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl349Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl309, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jpnl349Layout.createSequentialGroup()
                        .addComponent(lblResultCount5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnl349Layout.setVerticalGroup(
            jpnl349Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl349Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl309, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblResultCount5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cmb348.setEditable(true);
        cmb348.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb348FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb348FocusLost(evt);
            }
        });

        lblPurchaseid2.setText("Request ID");

        lblstatus2.setText("Status");

        cmb354.setBackground(new java.awt.Color(240, 240, 240));
        cmb354.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assigned", "Unassigned" }));
        cmb354.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb354ActionPerformed(evt);
            }
        });

        btn355.setText("Update");
        btn355.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn355ActionPerformed(evt);
            }
        });

        lbl321.setBackground(new java.awt.Color(255, 255, 255));
        lbl321.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl321.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jpnl398Layout = new javax.swing.GroupLayout(jpnl398);
        jpnl398.setLayout(jpnl398Layout);
        jpnl398Layout.setHorizontalGroup(
            jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl398Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(lbl321, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl398Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn355, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnl398Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpnl398Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblstatus2)
                                .addComponent(lblPurchaseid2))
                            .addGap(19, 19, 19)
                            .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmb354, 0, 201, Short.MAX_VALUE)
                                .addComponent(cmb348, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jpnl349, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(25, Short.MAX_VALUE)))
        );
        jpnl398Layout.setVerticalGroup(
            jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl398Layout.createSequentialGroup()
                .addContainerGap(397, Short.MAX_VALUE)
                .addComponent(lbl321, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn355)
                .addGap(72, 72, 72))
            .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnl398Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jpnl349, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44)
                    .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPurchaseid2)
                        .addComponent(cmb348, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(jpnl398Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblstatus2)
                        .addComponent(cmb354, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        jpnl394.addTab("View Requests", jpnl398);

        jpnl326.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Genarate purchase report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmb378.setEditable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Statistical Graph"));

        jpnl336.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnl336Layout = new javax.swing.GroupLayout(jpnl336);
        jpnl336.setLayout(jpnl336Layout);
        jpnl336Layout.setHorizontalGroup(
            jpnl336Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jpnl336Layout.setVerticalGroup(
            jpnl336Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jpnl336, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnl336, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cmb355.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Purchase percentage statistics", "Purchase delivery statistics " }));

        btn356.setText("Show purchase statistics");
        btn356.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn356ActionPerformed(evt);
            }
        });

        clndr389.setMaxSelectableDate(new java.util.Date(1790015340000L));

        clndr394.setMaxSelectableDate(new java.util.Date(1790015340000L));

        jLabel1.setText("From");

        jLabel2.setText("To");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(29, 79, Short.MAX_VALUE)
                        .addComponent(btn356))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clndr394, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clndr389, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmb355, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clndr389, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(clndr394, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addComponent(cmb355, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btn356)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jpnl326Layout = new javax.swing.GroupLayout(jpnl326);
        jpnl326.setLayout(jpnl326Layout);
        jpnl326Layout.setHorizontalGroup(
            jpnl326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl326Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jpnl326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl326Layout.createSequentialGroup()
                        .addGroup(jpnl326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(cmb378, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl326Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jpnl326Layout.setVerticalGroup(
            jpnl326Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl326Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmb378, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(119, 119, 119))
            .addGroup(jpnl326Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jpnl394.addTab("Statistics and reports", jpnl326);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jpnl394, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnl394, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmb353ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb353ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb353ActionPerformed

    private void cmb362ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb362ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb362ActionPerformed

    private void btn351ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn351ActionPerformed
        cmb353.setSelectedIndex(0);
        lbl355.setText("");
        DbAccessPurchase dba = new DbAccessPurchase("purchase");
        dba.fillTableLocalPur(tbl317, lblResultCount2);
        
        DbAccessPurchase dba2= new DbAccessPurchase("purchase", "purchaseVia","Local");
        cmb399.removeAllItems();
        dba2.fillNextCombo2(cmb399);
        
        txtF349.setText("");
    }//GEN-LAST:event_btn351ActionPerformed

    private void btn354ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn354ActionPerformed
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb399, lbl355);
        
        if(lbl355.getText().equals("!")){
        
            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
        
            DbAccessPurchase dba2=new DbAccessPurchase("purchase", "status", cmb353.getSelectedItem().toString(), "purchaseid", cmb399.getSelectedItem().toString());
            dba2.updateOneFeild();
            JOptionPane.showMessageDialog(this, "Status updated successfuly");
            txtF349.setText("");
            
            DbAccessPurchase dba = new DbAccessPurchase("purchase");
            dba.fillTableLocalPur(tbl317, lblResultCount2);
            
        }
    }//GEN-LAST:event_btn354ActionPerformed

    private void cmb399FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb399FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb399, lbl355);
    }//GEN-LAST:event_cmb399FocusLost

    private void cmb399FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb399FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb399FocusGained

    private void btn359ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn359ActionPerformed
        lbl363.setText("");
        cmb362.setSelectedIndex(0);
        DbAccessPurchase dba = new DbAccessPurchase("purchase");
        dba.fillTableForignPur(tbl318, lblResultCount3);
        
        DbAccessPurchase dba2= new DbAccessPurchase("purchase", "purchaseVia","Foreign");
        cmb398.removeAllItems();
        dba2.fillNextCombo2(cmb398);
        
        txtF357.setText("");
    }//GEN-LAST:event_btn359ActionPerformed

    private void btn364ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn364ActionPerformed
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb398, lbl363);
        
        if(lbl363.getText().equals("!")){
        
            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
        
            DbAccessPurchase dba2=new DbAccessPurchase("purchase", "status", cmb362.getSelectedItem().toString(), "purchaseid", cmb398.getSelectedItem().toString());
            dba2.updateOneFeild();
            JOptionPane.showMessageDialog(this, "Status updated successfuly");
            
            DbAccessPurchase dba = new DbAccessPurchase("purchase");
            dba.fillTableForignPur(tbl318, lblResultCount3);
            txtF357.setText("");
            
        }
    }//GEN-LAST:event_btn364ActionPerformed

    private void cmb398FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb398FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb398, lbl363);
    }//GEN-LAST:event_cmb398FocusLost

    private void txtF349KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF349KeyTyped
        if(txtF349.getText().length()>=7)
            evt.consume();
    }//GEN-LAST:event_txtF349KeyTyped

    private void txtF357KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF357KeyTyped
        if(txtF357.getText().length()>=7)
            evt.consume();
    }//GEN-LAST:event_txtF357KeyTyped

    private void cmb348FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb348FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb348FocusGained

    private void cmb348FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb348FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb348, lbl321);
    }//GEN-LAST:event_cmb348FocusLost

    private void cmb354ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb354ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb354ActionPerformed

    private void btn355ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn355ActionPerformed
        if(cmb348.getSelectedIndex()==-1){
            lbl321.setText("!");
        }
        else{
            DbAccessPurchase dba = new DbAccessPurchase("purchaserequest", "status", cmb354.getSelectedItem().toString(),"requestId", cmb348.getSelectedItem().toString());
            dba.updateOneFeild();
            
            DbAccessPurchase dba2 = new DbAccessPurchase("purchaserequest");
            dba2.itemListTablerequest(tbl320,lblResultCount5);
            
            DbAccessPurchase dba3 =new DbAccessPurchase();
            dba3.fillComboRequest(cmb348);
        }
    }//GEN-LAST:event_btn355ActionPerformed

    private void txtF349KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF349KeyReleased
        DbAccessPurchase dba = new DbAccessPurchase("purchase", "purchaseId", txtF349.getText().toString());
        dba.fillTableLocalPurSearch(tbl317, lblResultCount2);
        cmb399.removeAllItems();
        dba.fillNextCombo4(cmb399);
    }//GEN-LAST:event_txtF349KeyReleased

    private void txtF357KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF357KeyReleased
        DbAccessPurchase dba = new DbAccessPurchase("purchase", "purchaseId", txtF357.getText().toString());
        dba.fillTableForeignPurSearch(tbl318, lblResultCount3);
        cmb398.removeAllItems();
        dba.fillNextCombo3(cmb398);
    }//GEN-LAST:event_txtF357KeyReleased

    private void btn356ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn356ActionPerformed
        String date="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                date = fmt.format(this.clndr389.getDate());
            }
            catch (Exception e){

            }
            
        String date1="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                date1 = fmt.format(this.clndr394.getDate());
            }
            catch (Exception e){

            }
        
            
        
        if(cmb355.getSelectedIndex()==0){
        String sql = "select purchaseVia as val1,count(purchaseId) as val2 from purchase where purchaseDate between '"+date+"' and '"+date1+"' group by purchaseVia";
        String valOfCol1 = "val1";
        String valOfCol2 = "val2";
        JPanel pnl;
        
        Chart testChart = new Chart();
        testChart.createPieDataset(sql, valOfCol1, valOfCol2);
        
        pnl = testChart.createPanel(testChart.createPieChart("Statistics of purchase type"), 430, 420);
        
        SetPanel testpnl = new SetPanel();
        testpnl.SetPanel(pnl,jpnl336);
        }
        else if(cmb355.getSelectedIndex()==1){
        String sql = "select status as val1,count(purchaseId) as val2 from purchase where purchaseDate between '"+date+"' and '"+date1+"' group by status";
        String valOfCol1 = "val1";
        String valOfCol2 = "val2";
        JPanel pnl;
        
        Chart testChart = new Chart();
        testChart.createPieDataset(sql, valOfCol1, valOfCol2);
        
        pnl = testChart.createPanel(testChart.createPieChart("Statistics of purchase item delivery"), 430, 420);
        
        SetPanel testpnl = new SetPanel();
        testpnl.SetPanel(pnl,jpnl336);
        }
        
    }//GEN-LAST:event_btn356ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cmb378.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null,"Select a valid purchase id to genarate report","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
                 HashMap param1=new HashMap();
                 param1.put("purid",String.valueOf(cmb378.getSelectedItem()));
                 System.out.println(String.valueOf(cmb378.getSelectedItem()));
                 PurchaseManagementMain showme=new PurchaseManagementMain("src\\PurchaseManagementReports\\PurchaseNotice.jasper",param1);
                 showme.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn399ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn399ActionPerformed
        cmb303.setSelectedIndex(2);
        cmb304.setSelectedItem("i000003");
        spnnr305.setValue(200);
        cmb307.setSelectedIndex(1);
        txtF309.setText("Pending");
        cmb310.setSelectedIndex(1);
        clndr306.setDate(new Date());
    }//GEN-LAST:event_btn399ActionPerformed

    private void btn314ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn314ActionPerformed
        PurchaseOrders po = new PurchaseOrders();
        SetPanel sp = new SetPanel();
        sp.SetPanel(po);
    }//GEN-LAST:event_btn314ActionPerformed

    private void btn313ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn313ActionPerformed
        String date="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                date = fmt.format(this.clndr306.getDate());
            }
            catch (Exception e){

            }
               
        if(lbl315.getText().equals("!")||lbl316.getText().equals("!")||lbl318.getText().equals("!")||lbl319.getText().equals("!")||lbl317.getText().equals("!")){

            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(cmb303.getSelectedIndex()==-1||cmb304.getSelectedIndex()==-1||cmb310.getSelectedIndex()==-1||cmb307.getSelectedIndex()==-1||date.isEmpty()){
            TextValidatorPurchase tv = new TextValidatorPurchase();
            
            if(cmb303.getSelectedIndex()==-1){
                tv.comboSelection(cmb303, lbl315);
            }
            if(cmb304.getSelectedIndex()==-1){
                tv.comboSelection(cmb304, lbl316);
            }
            if(cmb307.getSelectedIndex()==-1){
                tv.comboSelection(cmb307, lbl318);
            }
            if(cmb310.getSelectedIndex()==-1){
                tv.comboSelection(cmb310, lbl319);
            }
            
            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
        else{
            //insertion code
            String datex="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                datex = fmt.format(this.clndr306.getDate());
            }
            catch (Exception e){

            }

            DbAccessPurchase dba = new DbAccessPurchase();
            dba.addLocalPurchase(txtF302.getText().toString(),datex,"Local", (Integer)spnnr305.getValue(), txtF309.getText().toString(), cmb310.getSelectedItem().toString(), cmb307.getSelectedItem().toString(), "EMP1002", cmb304.getSelectedItem().toString());

            JOptionPane.showMessageDialog(this, "Purchase recorded successfuly");

            //Creating a new instance of purchaseorder to refresh
            PurchaseOrders po = new PurchaseOrders();
            SetPanel sp = new SetPanel();
            sp.SetPanel(po);
        }
    }//GEN-LAST:event_btn313ActionPerformed

    private void cmb310FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb310FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb310, lbl319);
    }//GEN-LAST:event_cmb310FocusLost

    private void cmb307FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb307FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb307, lbl318);

        txtF309.setText("Pending");
    }//GEN-LAST:event_cmb307FocusLost

    private void clndr306MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clndr306MouseClicked

    }//GEN-LAST:event_clndr306MouseClicked

    private void clndr306FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clndr306FocusLost

                if(clndr306.getDate()==null){
                        lbl320.setText("!");
                }
                else{
                        lbl320.setText("");
                }
        
        
    }//GEN-LAST:event_clndr306FocusLost

    private void cmb304ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb304ActionPerformed
        cmb304.getSelectedItem().toString();
    }//GEN-LAST:event_cmb304ActionPerformed

    private void cmb304FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb304FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb304, lbl316);
        
        clndr306.setDate(new Date());
    }//GEN-LAST:event_cmb304FocusLost

    private void cmb304FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb304FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb304FocusGained

    private void cmb303PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb303PropertyChange
        if(cmb303.getSelectedIndex()!=-1){
        DbAccessPurchase dba= new DbAccessPurchase("itemlist","itemName");
        dba.itemListTable1(tbl314, cmb303.getSelectedItem().toString(),lblResultCount);

        DbAccessPurchase dba2= new DbAccessPurchase("itemlist", "itemName",cmb303.getSelectedItem().toString());
        cmb304.removeAllItems();
        dba2.fillNextCombo(cmb304);
        }
    }//GEN-LAST:event_cmb303PropertyChange

    private void cmb303ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb303ActionPerformed
        lbl315.setText("");
        //       DbAccessPurchase dba= new DbAccessPurchase("itemlist","itemName");
        //       dba.itemListTable1(tbl314, cmb303.getSelectedItem().toString());
    }//GEN-LAST:event_cmb303ActionPerformed

    private void cmb303MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb303MouseClicked
//        DbAccessPurchase dba= new DbAccessPurchase("itemlist","itemName");
//        dba.itemListTable1(tbl314, cmb303.getSelectedItem().toString(),lblResultCount);
//
//        DbAccessPurchase dba2= new DbAccessPurchase("itemlist", "itemName",cmb303.getSelectedItem().toString());
//        cmb304.removeAllItems();
//        dba2.fillNextCombo(cmb304);
    }//GEN-LAST:event_cmb303MouseClicked

    private void cmb303FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb303FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb303, lbl315);
    }//GEN-LAST:event_cmb303FocusLost

    private void cmb303FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb303FocusGained
        //lbl315.setText("");
    }//GEN-LAST:event_cmb303FocusGained

    private void btn346ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn346ActionPerformed
       String date="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                date = fmt.format(this.clndr330.getDate());
            }
            catch (Exception e){

            }
            
        String date1="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                date1 = fmt.format(this.clndr344.getDate());
            }
            catch (Exception e){

            }
            
        
        
        if(lbl345.getText().equals("!")||lbl341.getText().equals("!")||lbl339.getText().equals("!")||lbl337.getText().equals("!")||lbl332.getText().equals("!")||lbl328.getText().equals("!")||lbl327.getText().equals("!")){

            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(cmb325.getSelectedIndex()==-1||cmb326.getSelectedIndex()==-1||cmb333.getSelectedIndex()==-1||cmb336.getSelectedIndex()==-1||cmb338.getSelectedIndex()==-1||date.isEmpty()||date1.isEmpty()||txtF340.getText().isEmpty()||txtF342.getText().isEmpty()){

            TextValidatorPurchase tv2 = new TextValidatorPurchase();
            TextValidatorPurchase tv = new TextValidatorPurchase(txtF340.getText().toString());
            TextValidatorPurchase tv1 = new TextValidatorPurchase(txtF342.getText().toString());
            
            
            
            
            if(cmb325.getSelectedIndex()==-1){
                tv2.comboSelection(cmb325, lbl327);
            }
            if(cmb326.getSelectedIndex()==-1){
                tv2.comboSelection(cmb326, lbl328);
            }
            if(cmb333.getSelectedIndex()==-1){
                tv2.comboSelection(cmb333, lbl332);
            }
            if(cmb336.getSelectedIndex()==-1){
                tv2.comboSelection(cmb336, lbl337);
            }
            if(cmb338.getSelectedIndex()==-1){
                tv2.comboSelection(cmb338, lbl339);
            }
            if(date.isEmpty()){
                lbl331.setText("!");
            }
            if(date1.isEmpty()){
                lbl343.setText("!");
            }
            if(txtF340.getText().isEmpty()){
                tv.empty(lbl341);
            }
            if(txtF342.getText().isEmpty()){
                tv1.empty(lbl345);
            }
            
            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //insertion code
            String datex2="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                datex2 = fmt.format(this.clndr330.getDate());
            }
            catch (Exception e){

            }

            String datex3="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                datex3 = fmt.format(this.clndr344.getDate());
            }
            catch (Exception e){

            }

            try{
                DbAccessPurchase dba = new DbAccessPurchase();
                dba.addForeignPurchase(txtF321.getText().toString(),datex2,"Foreign", (Integer)spnnr329.getValue(), txtF335.getText().toString(), cmb336.getSelectedItem().toString(), cmb333.getSelectedItem().toString(),datex3,txtF340.getText().toString(),cmb338.getSelectedItem().toString(),txtF342.getText().toString(),"EMP1002", cmb326.getSelectedItem().toString());

                JOptionPane.showMessageDialog(this, "Purchase recorded successfuly");

                //Creating a new instance of purchaseorder to refresh
                PurchaseOrders po = new PurchaseOrders();
                SetPanel sp = new SetPanel();
                sp.SetPanel(po);}

            catch (Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn346ActionPerformed

    private void txtF342KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF342KeyTyped
        if(txtF342.getText().length()<=7){
            if(!(Character.isDigit(evt.getKeyChar())))
            evt.consume();
        }
        else
        evt.consume();
    }//GEN-LAST:event_txtF342KeyTyped

    private void txtF342FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF342FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase(txtF342.getText().toString());
        tv.empty(lbl345);
    }//GEN-LAST:event_txtF342FocusLost

    private void txtF342FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF342FocusGained
        lbl345.setText("");
    }//GEN-LAST:event_txtF342FocusGained

    private void txtF340KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF340KeyTyped
        if(txtF340.getText().length()>=7)
        evt.consume();
    }//GEN-LAST:event_txtF340KeyTyped

    private void txtF340FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF340FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase(txtF340.getText().toString());
        tv.empty(lbl341);
    }//GEN-LAST:event_txtF340FocusLost

    private void txtF340FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF340FocusGained
        lbl341.setText("");
    }//GEN-LAST:event_txtF340FocusGained

    private void cmb338ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb338ActionPerformed
        lbl339.setText("");
    }//GEN-LAST:event_cmb338ActionPerformed

    private void cmb338FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb338FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb338, lbl339);
    }//GEN-LAST:event_cmb338FocusLost

    private void cmb336ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb336ActionPerformed
        lbl337.setText("");
    }//GEN-LAST:event_cmb336ActionPerformed

    private void cmb336FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb336FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb336, lbl337);
    }//GEN-LAST:event_cmb336FocusLost

    private void cmb333ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb333ActionPerformed
        lbl332.setText("");
    }//GEN-LAST:event_cmb333ActionPerformed

    private void cmb333FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb333FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb333, lbl332);

        txtF335.setText("Pending");
    }//GEN-LAST:event_cmb333FocusLost

    private void cmb326ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb326ActionPerformed
        lbl328.setText("");
    }//GEN-LAST:event_cmb326ActionPerformed

    private void cmb326FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb326FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb326, lbl328);
    }//GEN-LAST:event_cmb326FocusLost

    private void cmb325ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb325ActionPerformed
        lbl327.setText("");
    }//GEN-LAST:event_cmb325ActionPerformed

    private void cmb325MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb325MouseClicked
//        DbAccessPurchase dba= new DbAccessPurchase("itemlist","itemName");
//        dba.itemListTable1(tbl315, cmb325.getSelectedItem().toString(),lblResultCount1);
//
//        DbAccessPurchase dba2= new DbAccessPurchase("itemlist", "itemName",cmb325.getSelectedItem().toString());
//        cmb326.removeAllItems();
//        dba2.fillNextCombo(cmb326);
    }//GEN-LAST:event_cmb325MouseClicked

    private void cmb325FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb325FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb325, lbl327);
    }//GEN-LAST:event_cmb325FocusLost

    private void btn324ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn324ActionPerformed
        PurchaseOrders po = new PurchaseOrders();
        SetPanel sp = new SetPanel();
        sp.SetPanel(po);
    }//GEN-LAST:event_btn324ActionPerformed

    private void btn400ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn400ActionPerformed
        cmb325.setSelectedIndex(3);
        cmb326.setSelectedItem("i000007");
        spnnr329.setValue(870);
        clndr330.setDate(new Date());
        cmb333.setSelectedIndex(1);
        txtF335.setText("Pending");
        cmb336.setSelectedIndex(1);
        cmb338.setSelectedIndex(2);
        txtF340.setText("br1234");
        clndr344.setDate(new Date());
        txtF342.setText("562158");
    }//GEN-LAST:event_btn400ActionPerformed

    private void cmb325PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb325PropertyChange
        if(cmb325.getSelectedIndex()!=-1){
        DbAccessPurchase dba= new DbAccessPurchase("itemlist","itemName");
        dba.itemListTable1(tbl315, cmb325.getSelectedItem().toString(),lblResultCount1);

        DbAccessPurchase dba2= new DbAccessPurchase("itemlist", "itemName",cmb325.getSelectedItem().toString());
        cmb326.removeAllItems();
        dba2.fillNextCombo(cmb326);
        }
    }//GEN-LAST:event_cmb325PropertyChange

    private void clndr330FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clndr330FocusLost
                if(clndr330.getDate()==null){
                        lbl331.setText("!");
                }
                else{
                        lbl331.setText("");
                }
    }//GEN-LAST:event_clndr330FocusLost

    private void clndr344FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clndr344FocusLost
        if(clndr344.getDate()==null){
                        lbl331.setText("!");
                }
                else{
                        lbl331.setText("");
                }
    }//GEN-LAST:event_clndr344FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn313;
    private javax.swing.JButton btn314;
    private javax.swing.JButton btn324;
    private javax.swing.JButton btn346;
    private javax.swing.JButton btn351;
    private javax.swing.JButton btn354;
    private javax.swing.JButton btn355;
    private javax.swing.JButton btn356;
    private javax.swing.JButton btn359;
    private javax.swing.JButton btn364;
    private javax.swing.JButton btn399;
    private javax.swing.JButton btn400;
    private com.toedter.calendar.JDateChooser clndr306;
    private com.toedter.calendar.JDateChooser clndr330;
    private com.toedter.calendar.JDateChooser clndr344;
    private com.toedter.calendar.JDateChooser clndr389;
    private com.toedter.calendar.JDateChooser clndr394;
    private javax.swing.JComboBox<String> cmb303;
    private javax.swing.JComboBox<String> cmb304;
    private javax.swing.JComboBox<String> cmb307;
    private javax.swing.JComboBox<String> cmb310;
    private javax.swing.JComboBox<String> cmb325;
    private javax.swing.JComboBox<String> cmb326;
    private javax.swing.JComboBox<String> cmb333;
    private javax.swing.JComboBox<String> cmb336;
    private javax.swing.JComboBox<String> cmb338;
    private javax.swing.JComboBox<String> cmb348;
    private javax.swing.JComboBox<String> cmb353;
    private javax.swing.JComboBox<String> cmb354;
    private javax.swing.JComboBox<String> cmb355;
    private javax.swing.JComboBox<String> cmb362;
    private javax.swing.JComboBox<String> cmb378;
    private javax.swing.JComboBox<String> cmb398;
    private javax.swing.JComboBox<String> cmb399;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpnl301;
    private javax.swing.JPanel jpnl311;
    private javax.swing.JPanel jpnl320;
    private javax.swing.JPanel jpnl322;
    private javax.swing.JPanel jpnl326;
    private javax.swing.JPanel jpnl336;
    private javax.swing.JPanel jpnl347;
    private javax.swing.JPanel jpnl348;
    private javax.swing.JPanel jpnl349;
    private javax.swing.JPanel jpnl356;
    private javax.swing.JPanel jpnl360;
    private javax.swing.JTabbedPane jpnl394;
    private javax.swing.JPanel jpnl398;
    private javax.swing.JLabel lbl315;
    private javax.swing.JLabel lbl316;
    private javax.swing.JLabel lbl317;
    private javax.swing.JLabel lbl318;
    private javax.swing.JLabel lbl319;
    private javax.swing.JLabel lbl320;
    private javax.swing.JLabel lbl321;
    private javax.swing.JLabel lbl327;
    private javax.swing.JLabel lbl328;
    private javax.swing.JLabel lbl331;
    private javax.swing.JLabel lbl332;
    private javax.swing.JLabel lbl337;
    private javax.swing.JLabel lbl339;
    private javax.swing.JLabel lbl341;
    private javax.swing.JLabel lbl343;
    private javax.swing.JLabel lbl345;
    private javax.swing.JLabel lbl355;
    private javax.swing.JLabel lbl363;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblBranchCode;
    private javax.swing.JLabel lblDatePurchased;
    private javax.swing.JLabel lblDatePurchased1;
    private javax.swing.JLabel lblItemID;
    private javax.swing.JLabel lblItemID1;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblItemName1;
    private javax.swing.JLabel lblLCDate;
    private javax.swing.JLabel lblLCNo;
    private javax.swing.JLabel lblPaymentMethod;
    private javax.swing.JLabel lblPaymentMethod1;
    private javax.swing.JLabel lblPurchaseID;
    private javax.swing.JLabel lblPurchaseID1;
    private javax.swing.JLabel lblPurchaseType;
    private javax.swing.JLabel lblPurchaseType1;
    private javax.swing.JLabel lblPurchaseid;
    private javax.swing.JLabel lblPurchaseid1;
    private javax.swing.JLabel lblPurchaseid2;
    private javax.swing.JLabel lblQuentity;
    private javax.swing.JLabel lblQuentity1;
    private javax.swing.JLabel lblResultCount;
    private javax.swing.JLabel lblResultCount1;
    private javax.swing.JLabel lblResultCount2;
    private javax.swing.JLabel lblResultCount3;
    private javax.swing.JLabel lblResultCount5;
    private javax.swing.JLabel lblSearchPurchaseID;
    private javax.swing.JLabel lblSearchPurchaseID1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JLabel lblstatus1;
    private javax.swing.JLabel lblstatus2;
    private javax.swing.JSpinner spnnr305;
    private javax.swing.JSpinner spnnr329;
    private javax.swing.JScrollPane tbl308;
    private javax.swing.JScrollPane tbl309;
    private javax.swing.JScrollPane tbl312;
    private javax.swing.JTable tbl314;
    private javax.swing.JTable tbl315;
    private javax.swing.JTable tbl317;
    private javax.swing.JTable tbl318;
    private javax.swing.JTable tbl320;
    private javax.swing.JScrollPane tbl323;
    private javax.swing.JScrollPane tbl357;
    private javax.swing.JTextField txtF302;
    private javax.swing.JTextField txtF309;
    private javax.swing.JTextField txtF321;
    private javax.swing.JTextField txtF335;
    private javax.swing.JTextField txtF340;
    private javax.swing.JTextField txtF342;
    private javax.swing.JTextField txtF349;
    private javax.swing.JTextField txtF357;
    // End of variables declaration//GEN-END:variables
}
