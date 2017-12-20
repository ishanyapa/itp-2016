/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrderManagement;
//import CustomerOrderSupportedClasses.ComboKeyHandler;
import CustomerOrderSupportedClasses.idIncrementCOM;
import CustomerOrderSupportedClasses.SetPanel;
import CustomerOrderSupportedClasses.EmailSender;
import CustomerOrderSupportedClasses.CustomerOrderDbAccess;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saajith Zain
 */
public class OrderManagement extends javax.swing.JPanel {
  EmailSender es=new EmailSender();
  
  ComboKeyHandler ckh,ckh1,ckh2,ckh3,ckh4;
  
    /**
     * Creates new form OrderManagement
     */
    public OrderManagement() {
        initComponents();
        
        dateChooser_UpdateShipmentDate.setMinSelectableDate(new Date());
        //Customer Order Management  data Load on form 
        CustomerOrderDbAccess d1=new CustomerOrderDbAccess("largescalecustomer","companyName");
        d1.fillCombo(cmb500Add_orderCompany);
        CustomerOrderDbAccess d2=new CustomerOrderDbAccess("finishedproducts","name");
        d2.fillComboOrderItems(cmb500Add_orderItem);
        
        CustomerOrderDbAccess dbA=new CustomerOrderDbAccess("VW_OrderDeliveryDetails");
        dbA.fillTableDeliveryDetails(tbl500_DeliveryDetails);
        DeliveryCount.setText(tbl500_DeliveryDetails.getRowCount()+" Delivered order(s) found" );
        
        
        CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder","orderId");
        idIncrementCOM idi=new idIncrementCOM(dba.getLastId());//Increment CustomerID on form load
        txt500Add_orderId.setText(idi.incrementId());
        
        CustomerOrderDbAccess dba2=new CustomerOrderDbAccess("largescaleorder", "orderId");
        dba2.fillComboOrderId(cmb500Updte_orderId);//fillCombo box 
        CustomerOrderDbAccess dba3=new CustomerOrderDbAccess("finishedproducts", "name");
        dba3.fillComboOrderItems(cmb500Updt_orderItem);//fillCombo Box
        

        CustomerOrderDbAccess dba5=new CustomerOrderDbAccess("largescaleorder");
        dba5.fillTableLargeScaleOrder(tbl500View_Orders);
        
        jLabel13.setText(tbl500View_Orders.getRowCount()+ " Order/s found");
        jLabel11.setText("");

        CustomerOrderDbAccess db=new CustomerOrderDbAccess("largescaleorder", "status");
        db.fillOrderTableOnCondition(tbl500_UpdateConfirmedOrders,"Confirmed");
        
        CustomerOrderDbAccess dba4=new CustomerOrderDbAccess("largescaleorder", "status");
        dba4.fillOrderTableOnCondition(tbl500_UpdateOrderDetails,"Pending Confirmation");
        OrderUpdateCount.setText(tbl500_UpdateOrderDetails.getRowCount()+" Unconfirmed Order(s) found ");
        
        tbl500View_Orders.setComponentPopupMenu(Menu_viewOrder);
        tbl500Add_orderList.setComponentPopupMenu(Menu_AddItem);
        tbl500Update_itemList.setComponentPopupMenu(Menu_UpadteOrder);
        tbl500_UpdateOrderDetails.setComponentPopupMenu(Menu_pendingOrders);
        tbl500Update_NewitemList.setComponentPopupMenu(PopUpUpdateOrder);
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        shipmentStatus.add(rbtn_shipmentStatusNotShipped);
        shipmentStatus.add(rbtn_shipmentStatusShipped);
        invoiceEmailStatus.add(rbtn_invoiceEStatusNotSent);
        invoiceEmailStatus.add(rbtn_invoiceEStatusSent);
        deliveryEmailStatus.add(rbtn_DeliveryEStatusSent);
        deliveryEmailStatus.add(rbtn_DeliveryStatusNotSent);
        buttonGroup3.add(rbtn_Confirmed);
        buttonGroup3.add(rbtn_pending);
         //send Email
        CustomerOrderDbAccess d=new CustomerOrderDbAccess("largescalecustomer","companyName");
        d.fillCombo(cmbEmail);
        
        //cmb500Add_orderCompany
        ckh1 = new ComboKeyHandler(cmb500Add_orderCompany);
        cmb500Add_orderCompany.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                ckh1.keyTyped(e);
            }
        });
       
         ckh = new ComboKeyHandler(cmb500Add_orderItem);
        cmb500Add_orderItem.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                ckh.keyTyped(e);
            }
        });
        
        
         ckh2 = new ComboKeyHandler(cmbEmail);
        cmbEmail.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                ckh2.keyTyped(e);
            }
        });
        
        ckh3 = new ComboKeyHandler(cmb500Updte_orderId);
        cmb500Updte_orderId.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                ckh3.keyTyped(e);
            }
        });
        
        
        ckh4 = new ComboKeyHandler(cmb500Updt_orderItem);
        cmb500Updt_orderItem.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                ckh4.keyTyped(e);
            }
        });

                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_viewOrder = new javax.swing.JPopupMenu();
        Menu_OrderDetails = new javax.swing.JMenuItem();
        Menu_AddItem = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Menu_UpadteOrder = new javax.swing.JPopupMenu();
        removeItem = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Menu_pendingOrders = new javax.swing.JPopupMenu();
        RemoveOrder = new javax.swing.JMenuItem();
        buttonGroup2 = new javax.swing.ButtonGroup();
        shipmentStatus = new javax.swing.ButtonGroup();
        deliveryEmailStatus = new javax.swing.ButtonGroup();
        invoiceEmailStatus = new javax.swing.ButtonGroup();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        PopUpUpdateOrder = new javax.swing.JPopupMenu();
        updateRemoveItem = new javax.swing.JMenuItem();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt500Add_orderId = new javax.swing.JTextField();
        cmb500Add_orderCompany = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btn500Add_order = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl500Add_orderList = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmb500Add_orderItem = new javax.swing.JComboBox<>();
        spn500Add_itemQuantity = new javax.swing.JSpinner();
        btn500add_orderItem = new javax.swing.JButton();
        lbl500Add_itemCount = new javax.swing.JLabel();
        txt500Add_orderTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmb500Add_discount = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblAdd500_AddItemErr = new javax.swing.JLabel();
        btn500Add_clearOrder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl500Add_orderDateErr = new javax.swing.JLabel();
        lblAdd500_orderCompanyErr1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl500View_Orders = new javax.swing.JTable();
        txt500View_fromOrderID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmb500Updte_orderId = new javax.swing.JComboBox<>();
        cmb500updt_orderCompany = new javax.swing.JComboBox<>();
        Jpanel_addItem = new javax.swing.JPanel();
        txt500Updte_orderTotal = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl500Update_itemList = new javax.swing.JTable();
        btn500_UdateOrder = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cmb500Updt_orderItem = new javax.swing.JComboBox<>();
        btn500Updte_newItem = new javax.swing.JButton();
        spn500Updte_itemQty = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl500Update_NewitemList = new javax.swing.JTable();
        txt500Updt_NewOrderAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt500Updte_NewNetTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbl500Upte_itemCount = new javax.swing.JLabel();
        cmb500Update_discountRate = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        lbl500Updte_OrderIdErr = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        rbtn_DeliveryStatusNotSent = new javax.swing.JRadioButton();
        rbtn_invoiceEStatusNotSent = new javax.swing.JRadioButton();
        rbtn_DeliveryEStatusSent = new javax.swing.JRadioButton();
        rbtn_invoiceEStatusSent = new javax.swing.JRadioButton();
        rbtn_shipmentStatusShipped = new javax.swing.JRadioButton();
        rbtn_shipmentStatusNotShipped = new javax.swing.JRadioButton();
        txtUpdateOrderDetails = new javax.swing.JTextField();
        dateChooser_UpdateShipmentDate = new com.toedter.calendar.JDateChooser();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbl500_UpdateConfirmedOrders = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        rbtn_Confirmed = new javax.swing.JRadioButton();
        rbtn_pending = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl500_UpdateOrderDetails = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txt500_confirmOrderId = new javax.swing.JTextField();
        OrderUpdateCount = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl500_DeliveryDetails = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        DeliveryCount = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cmbEmail = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSubject = new javax.swing.JTextPane();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel23 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        Menu_OrderDetails.setText("View order Details");
        Menu_OrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_OrderDetailsActionPerformed(evt);
            }
        });
        Menu_viewOrder.add(Menu_OrderDetails);

        jMenuItem1.setText("remove Item");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Menu_AddItem.add(jMenuItem1);

        removeItem.setText("remove Item");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });
        Menu_UpadteOrder.add(removeItem);

        RemoveOrder.setText("Remove Order");
        RemoveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveOrderActionPerformed(evt);
            }
        });
        Menu_pendingOrders.add(RemoveOrder);

        updateRemoveItem.setText("Remove Item");
        updateRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRemoveItemActionPerformed(evt);
            }
        });
        PopUpUpdateOrder.add(updateRemoveItem);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 590));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(780, 570));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(780, 570));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(780, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel1FocusLost(evt);
            }
        });

        jLabel1.setText("Order Id");

        txt500Add_orderId.setEditable(false);
        txt500Add_orderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500Add_orderIdActionPerformed(evt);
            }
        });

        cmb500Add_orderCompany.setEditable(true);
        cmb500Add_orderCompany.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb500Add_orderCompanyFocusLost(evt);
            }
        });
        cmb500Add_orderCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500Add_orderCompanyActionPerformed(evt);
            }
        });
        cmb500Add_orderCompany.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb500Add_orderCompanyPropertyChange(evt);
            }
        });

        jLabel6.setText("Company ");

        btn500Add_order.setText("Add");
        btn500Add_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500Add_orderActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Item"));

        tbl500Add_orderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PoductId", "ProductName", "UnitPrice", "Length", "Weight", "Quantity", "SubTtotal", "Net Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl500Add_orderList);

        jLabel7.setText("Item");

        jLabel8.setText("Quantity");

        cmb500Add_orderItem.setEditable(true);
        cmb500Add_orderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500Add_orderItemActionPerformed(evt);
            }
        });

        spn500Add_itemQuantity.setModel(new javax.swing.SpinnerNumberModel(100, 100, null, 1));
        spn500Add_itemQuantity.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spn500Add_itemQuantityPropertyChange(evt);
            }
        });

        btn500add_orderItem.setText("Add Item");
        btn500add_orderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500add_orderItemActionPerformed(evt);
            }
        });

        lbl500Add_itemCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl500Add_itemCount.setForeground(new java.awt.Color(51, 153, 0));
        lbl500Add_itemCount.setText("0 Items Added");

        txt500Add_orderTotal.setEditable(false);
        txt500Add_orderTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt500Add_orderTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500Add_orderTotalActionPerformed(evt);
            }
        });

        jLabel3.setText("Total");

        cmb500Add_discount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "7", "10", "15", "25" }));
        cmb500Add_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500Add_discountActionPerformed(evt);
            }
        });

        jLabel4.setText("Discount Rate(%)");

        lblAdd500_AddItemErr.setBackground(new java.awt.Color(255, 255, 255));
        lblAdd500_AddItemErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAdd500_AddItemErr.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(cmb500Add_orderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn500add_orderItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdd500_AddItemErr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spn500Add_itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb500Add_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl500Add_itemCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt500Add_orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb500Add_orderItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(btn500add_orderItem))
                    .addComponent(lblAdd500_AddItemErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spn500Add_itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb500Add_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl500Add_itemCount)
                    .addComponent(jLabel3)
                    .addComponent(txt500Add_orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        btn500Add_clearOrder.setText("Cancel");
        btn500Add_clearOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500Add_clearOrderActionPerformed(evt);
            }
        });

        lbl500Add_orderDateErr.setForeground(new java.awt.Color(204, 0, 0));

        lblAdd500_orderCompanyErr1.setBackground(new java.awt.Color(255, 255, 255));
        lblAdd500_orderCompanyErr1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAdd500_orderCompanyErr1.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt500Add_orderId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb500Add_orderCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn500Add_order, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn500Add_clearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl500Add_orderDateErr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdd500_orderCompanyErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(txt500Add_orderId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAdd500_orderCompanyErr1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb500Add_orderCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lbl500Add_orderDateErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn500Add_order)
                            .addComponent(btn500Add_clearOrder))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Order", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl500View_Orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderId", "orderDate", "OrderType", "status", "shipmentDate", "shipmentStatus", "deliverEmailStatus", "invoiceEmailStatus", "employeeId", "companyId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl500View_Orders.setToolTipText("");
        jScrollPane3.setViewportView(tbl500View_Orders);

        txt500View_fromOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500View_fromOrderIDActionPerformed(evt);
            }
        });
        txt500View_fromOrderID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt500View_fromOrderIDKeyReleased(evt);
            }
        });

        jLabel12.setText("Order Id");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 0));

        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirm Pending orders");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Foreign");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Local");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("All");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));

        jButton4.setText("assign Shipment date");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("LSO");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txt500View_fromOrderID)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt500View_fromOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jButton9))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Order", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Company ");

        jLabel17.setText("Order Id");

        cmb500Updte_orderId.setEditable(true);
        cmb500Updte_orderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500Updte_orderIdActionPerformed(evt);
            }
        });
        cmb500Updte_orderId.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb500Updte_orderIdPropertyChange(evt);
            }
        });

        cmb500updt_orderCompany.setEnabled(false);
        cmb500updt_orderCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500updt_orderCompanyActionPerformed(evt);
            }
        });

        Jpanel_addItem.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel_addItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Existing Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        Jpanel_addItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt500Updte_orderTotal.setEditable(false);
        txt500Updte_orderTotal.setBackground(new java.awt.Color(255, 255, 255));
        txt500Updte_orderTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt500Updte_orderTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500Updte_orderTotalActionPerformed(evt);
            }
        });

        jLabel24.setText("Existing Total");

        tbl500Update_itemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Poduct Id", "Product Name", "Unit Price", "Length", "Weight", "Quantity", "Sub Ttotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl500Update_itemList.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane4.setViewportView(tbl500Update_itemList);

        javax.swing.GroupLayout Jpanel_addItemLayout = new javax.swing.GroupLayout(Jpanel_addItem);
        Jpanel_addItem.setLayout(Jpanel_addItemLayout);
        Jpanel_addItemLayout.setHorizontalGroup(
            Jpanel_addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_addItemLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(Jpanel_addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Jpanel_addItemLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(35, 35, 35)
                        .addComponent(txt500Updte_orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        Jpanel_addItemLayout.setVerticalGroup(
            Jpanel_addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_addItemLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Jpanel_addItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt500Updte_orderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap())
        );

        btn500_UdateOrder.setText("Update");
        btn500_UdateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500_UdateOrderActionPerformed(evt);
            }
        });

        jButton7.setText("Cancel");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel20.setText("Item");

        cmb500Updt_orderItem.setEditable(true);
        cmb500Updt_orderItem.setEnabled(false);
        cmb500Updt_orderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500Updt_orderItemActionPerformed(evt);
            }
        });

        btn500Updte_newItem.setText("Add New Item");
        btn500Updte_newItem.setEnabled(false);
        btn500Updte_newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500Updte_newItemActionPerformed(evt);
            }
        });

        spn500Updte_itemQty.setModel(new javax.swing.SpinnerNumberModel(100, 100, null, 1));
        spn500Updte_itemQty.setEnabled(false);

        jLabel21.setText("Quantity");

        tbl500Update_NewitemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Poduct Id", "Product Name", "Unit Price", "Length", "Weight", "Quantity", "Sub Ttotal", "Net Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbl500Update_NewitemList);

        txt500Updt_NewOrderAmount.setEditable(false);
        txt500Updt_NewOrderAmount.setBackground(new java.awt.Color(255, 255, 255));
        txt500Updt_NewOrderAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt500Updt_NewOrderAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500Updt_NewOrderAmountActionPerformed(evt);
            }
        });

        jLabel9.setText("New net Amount");

        txt500Updte_NewNetTotal.setEditable(false);
        txt500Updte_NewNetTotal.setBackground(new java.awt.Color(255, 255, 255));
        txt500Updte_NewNetTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt500Updte_NewNetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt500Updte_NewNetTotalActionPerformed(evt);
            }
        });

        jLabel10.setText("Updated Order Net Amount");

        lbl500Upte_itemCount.setBackground(new java.awt.Color(255, 255, 255));
        lbl500Upte_itemCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl500Upte_itemCount.setForeground(new java.awt.Color(51, 153, 0));
        lbl500Upte_itemCount.setText("0 Items Added");

        cmb500Update_discountRate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "7", "10", "15", "25" }));
        cmb500Update_discountRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb500Update_discountRateActionPerformed(evt);
            }
        });

        jLabel18.setText("Discount Rate(%)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbl500Upte_itemCount, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt500Updt_NewOrderAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(136, 136, 136))))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spn500Updte_itemQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb500Update_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(12, 12, 12)
                                .addComponent(cmb500Updt_orderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(btn500Updte_newItem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt500Updte_NewNetTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb500Updt_orderItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(btn500Updte_newItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spn500Updte_itemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb500Update_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt500Updt_NewOrderAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl500Upte_itemCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt500Updte_NewNetTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl500Updte_OrderIdErr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl500Updte_OrderIdErr.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Jpanel_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(25, 25, 25)
                        .addComponent(cmb500Updte_orderId, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lbl500Updte_OrderIdErr, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cmb500updt_orderCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btn500_UdateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb500Updte_orderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addComponent(lbl500Updte_OrderIdErr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmb500updt_orderCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(btn500_UdateOrder)
                    .addComponent(jButton7))
                .addGap(7, 7, 7)
                .addComponent(Jpanel_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Update Order Items", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Order Id");

        jLabel31.setText("Shipment Status");

        jLabel32.setText("Delivery Email Status");

        jLabel33.setText("Invoice Email Status");

        rbtn_DeliveryStatusNotSent.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_DeliveryStatusNotSent.setText("Not Sent");

        rbtn_invoiceEStatusNotSent.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_invoiceEStatusNotSent.setText("Not Sent");

        rbtn_DeliveryEStatusSent.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_DeliveryEStatusSent.setText("Sent");

        rbtn_invoiceEStatusSent.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_invoiceEStatusSent.setText("Sent");

        rbtn_shipmentStatusShipped.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_shipmentStatusShipped.setText("Shipped");
        rbtn_shipmentStatusShipped.setEnabled(false);

        rbtn_shipmentStatusNotShipped.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_shipmentStatusNotShipped.setText("Not Shipped");
        rbtn_shipmentStatusNotShipped.setEnabled(false);

        txtUpdateOrderDetails.setEditable(false);
        txtUpdateOrderDetails.setBackground(new java.awt.Color(255, 255, 255));

        tbl500_UpdateConfirmedOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "orderId", "orderDate", "orderType", "status", "shipmentDate", "shipmentStatus", "deliveryEmailStatus", "invoiceEmailStatus", "employeeId", "companyId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl500_UpdateConfirmedOrders.setToolTipText("");
        tbl500_UpdateConfirmedOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl500_UpdateConfirmedOrdersMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tbl500_UpdateConfirmedOrders);

        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel34.setText("Shipment Date");

        jLabel35.setText("Order Status");

        rbtn_Confirmed.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_Confirmed.setText("Confirmed");

        rbtn_pending.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_pending.setText("Pending Confirmation");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel34)
                        .addGap(43, 43, 43)
                        .addComponent(dateChooser_UpdateShipmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(141, 141, 141)
                        .addComponent(rbtn_pending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(rbtn_shipmentStatusNotShipped))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(14, 14, 14)
                                        .addComponent(rbtn_invoiceEStatusNotSent))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbtn_Confirmed)
                                            .addComponent(rbtn_DeliveryStatusNotSent))))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtn_DeliveryEStatusSent)
                                    .addComponent(rbtn_invoiceEStatusSent)
                                    .addComponent(rbtn_shipmentStatusShipped)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(72, 72, 72)
                                .addComponent(txtUpdateOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtUpdateOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(dateChooser_UpdateShipmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(rbtn_shipmentStatusNotShipped)
                    .addComponent(rbtn_shipmentStatusShipped))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtn_invoiceEStatusNotSent)
                        .addComponent(rbtn_invoiceEStatusSent)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(rbtn_DeliveryStatusNotSent)
                    .addComponent(rbtn_DeliveryEStatusSent))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jLabel35)
                    .addComponent(rbtn_Confirmed)
                    .addComponent(rbtn_pending))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Update Confirmed Orders", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tbl500_UpdateOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "orderId", "orderDate", "orderType", "status", "shipmentDate", "shipmentStatus", "deliveryEmailStatus", "invoiceEmailStatus", "employeeId", "companyId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl500_UpdateOrderDetails.setToolTipText("");
        tbl500_UpdateOrderDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl500_UpdateOrderDetailsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbl500_UpdateOrderDetails);

        jButton3.setText("Confirm Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt500_confirmOrderId.setEditable(false);
        txt500_confirmOrderId.setBackground(new java.awt.Color(255, 255, 255));

        OrderUpdateCount.setBackground(new java.awt.Color(255, 255, 255));
        OrderUpdateCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OrderUpdateCount.setForeground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt500_confirmOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(OrderUpdateCount, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txt500_confirmOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderUpdateCount, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pending Orders", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbl500_DeliveryDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "orderId", "orderDate", "orderType", "status", "shipmentDate", "shipmentStatus", "deliveryEmailStatus", "invoiceEmailStatus", "employeeId", "companyId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl500_DeliveryDetails.setToolTipText("");
        tbl500_DeliveryDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl500_DeliveryDetailsMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbl500_DeliveryDetails);

        jButton6.setText("Generate Delivery Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setText("Order ID :");

        DeliveryCount.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DeliveryCount.setForeground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(DeliveryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addComponent(DeliveryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delivery Details", jPanel9);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        cmbEmail.setEditable(true);
        cmbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmailActionPerformed(evt);
            }
        });
        cmbEmail.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbEmailPropertyChange(evt);
            }
        });

        jLabel25.setText("Company");

        jScrollPane1.setViewportView(txtMessage);

        jScrollPane5.setViewportView(txtSubject);

        jLabel26.setText("Subject");

        jLabel27.setText("Type Message");

        jButton8.setText("Add Attatchment");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(51, 153, 0));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(51, 153, 0));

        jLabel29.setText("User Name");

        jLabel30.setText("Password");

        jButton10.setText("Demo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cmbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 112, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jButton8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserName, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(Password))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );

        jTabbedPane1.addTab("Send Email", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
     
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DefaultTableModel m= (DefaultTableModel) tbl500Add_orderList.getModel();//fill table moodel
        m.removeRow(tbl500Add_orderList.getSelectedRow());
        lbl500Add_itemCount.setText(tbl500Add_orderList.getRowCount()+" Items Added");
        

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
    int dialogResult=JOptionPane.showConfirmDialog(this,"Do you want to Delete existing Order Item ?","Confirmation",JOptionPane.YES_NO_OPTION);
       
        long orderTotal=0;
     if(dialogResult==JOptionPane.YES_OPTION){   
        DefaultTableModel m= (DefaultTableModel) tbl500Update_itemList.getModel();//fill table moodel
        CustomerOrderDbAccess dba=new CustomerOrderDbAccess();
        dba.deleteLargescaleOrderGood(String.valueOf(cmb500Updte_orderId.getSelectedItem()), String.valueOf(tbl500Update_itemList.getValueAt(tbl500Update_itemList.getSelectedRow(),0)));
        m.removeRow(tbl500Update_itemList.getSelectedRow());
        lbl500Upte_itemCount.setText(tbl500Add_orderList.getRowCount()+" Items Added");
        
        
           for (int i = 0; i < tbl500Update_itemList.getRowCount(); i++){//increment total order amount
                    double amount = Double.parseDouble((String.valueOf(tbl500Update_itemList.getValueAt(i,6))));
                   orderTotal += (new Double(amount)).longValue();
                   
            }
            txt500Updte_orderTotal.setText(String.valueOf((new Double(orderTotal)).longValue()));
            
            txt500Updt_NewOrderAmount.setText(String.valueOf(txt500Updte_orderTotal.getText()));
     
     } 
   
    }//GEN-LAST:event_removeItemActionPerformed

    private void Menu_OrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_OrderDetailsActionPerformed
            JDialog dial = new JDialog();
            dial = new OrderDetails(new CustomerOrderManagementMain(), true,(String.valueOf( tbl500View_Orders.getValueAt(tbl500View_Orders.getSelectedRow(),0))));
//            OrderDetails s=new OrderDetails;;
            dial.setVisible(true);
            
            
            
    }//GEN-LAST:event_Menu_OrderDetailsActionPerformed

    private void updateRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRemoveItemActionPerformed
        DefaultTableModel m= (DefaultTableModel)tbl500Update_NewitemList.getModel();//fill table moodel
        m.removeRow(tbl500Update_NewitemList.getSelectedRow());
        lbl500Upte_itemCount.setText(tbl500Add_orderList.getRowCount()+" Items Added");
        
    }//GEN-LAST:event_updateRemoveItemActionPerformed

    private void RemoveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveOrderActionPerformed
  
         int dialogResult=JOptionPane.showConfirmDialog(this,"Do you want to Remove Order "+tbl500_UpdateOrderDetails.getValueAt(tbl500_UpdateOrderDetails.getSelectedRow(),0).toString()+"?","Confirmation!",JOptionPane.YES_NO_OPTION);
   
    
    if(dialogResult==JOptionPane.YES_OPTION){
  
        DefaultTableModel model = (DefaultTableModel) tbl500_UpdateOrderDetails.getModel();
        
        CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder", "orderId");
        dba.deleteRow(tbl500_UpdateOrderDetails.getValueAt(tbl500_UpdateOrderDetails.getSelectedRow(),0).toString());//remove row from database
        model.removeRow(tbl500_UpdateOrderDetails.getSelectedRow());//remove row from the model
        CustomerOrderDbAccess dba1=new CustomerOrderDbAccess("largescaleorder");
        dba1.fillTableLargeScaleOrder(tbl500View_Orders);
    
    
    }
    }//GEN-LAST:event_RemoveOrderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       if(txtSubject.getText().isEmpty()||cmbEmail.getSelectedIndex()==-1 || txtMessage.getText().isEmpty())
       {
           JOptionPane.showMessageDialog(this,"One or more fields have invalid data", "Error!",JOptionPane.ERROR_MESSAGE);
       }else{
        es.sendEmail(txtSubject,String.valueOf(jLabel23.getText()), txtMessage,jProgressBar1,cmbEmail,jLabel23,jLabel22,String.valueOf(UserName.getText()),String.valueOf(Password.getPassword()));
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        
        es.addAttatchment(jLabel22);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        es.addAttatchment(jLabel22);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cmbEmailPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbEmailPropertyChange
        if(cmbEmail.getSelectedIndex()!=-1)
        {
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess();
            jLabel23.setText(dba.returnCustomerEmail(String.valueOf(cmbEmail.getSelectedItem())));
        }
    }//GEN-LAST:event_cmbEmailPropertyChange

    private void cmbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmailActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int dialogResult = 0;

      if(txt500_confirmOrderId.getText().isEmpty())
      {
           JOptionPane.showMessageDialog(null, "Please Select an Order", "Warning!", JOptionPane.WARNING_MESSAGE);

      }else{  
        if(tbl500_UpdateOrderDetails.getValueAt(tbl500_UpdateOrderDetails.getSelectedRow(),0).toString().isEmpty()
            && tbl500_UpdateOrderDetails.getValueAt(tbl500_UpdateOrderDetails.getSelectedRow(),2).toString().equals("Foreign"))
        {
            System.out.println("I am foreign and empty");
        }

        if(tbl500_UpdateOrderDetails.getRowCount()!= 0){

            if(!String.valueOf(txt500_confirmOrderId.getText()).equals("")){
                dialogResult=JOptionPane.showConfirmDialog(this,"Do you want to Confirm Order ?","Confirmation",JOptionPane.YES_NO_OPTION);

                if(dialogResult==JOptionPane.YES_OPTION){
                    String orderId=tbl500_UpdateOrderDetails.getValueAt(tbl500_UpdateOrderDetails.getSelectedRow(),0).toString();

                    CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder","orderId");
                    dba.updateField("status","confirmed",orderId);

                    DefaultTableModel model = (DefaultTableModel) tbl500_UpdateOrderDetails.getModel();
                    model.removeRow(tbl500_UpdateOrderDetails.getSelectedRow());
                    txt500_confirmOrderId.setText("");
                    
                    CustomerOrderDbAccess dba1=new CustomerOrderDbAccess("largescaleorder");
                    dba1.fillTableLargeScaleOrder(tbl500View_Orders);
                    OrderUpdateCount.setText(tbl500_UpdateOrderDetails.getRowCount()+" Unnconfirmed Order(s) found ");
                    CustomerOrderDbAccess db=new CustomerOrderDbAccess("largescaleorder", "status");
                    db.fillOrderTableOnCondition(tbl500_UpdateConfirmedOrders,"Confirmed");
                    
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please Select an Order","Waring",JOptionPane.WARNING_MESSAGE);
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"No orders available for confirmation ", "Warning!",JOptionPane.WARNING_MESSAGE);
        }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmb500Update_discountRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500Update_discountRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb500Update_discountRateActionPerformed

    private void txt500Updte_NewNetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500Updte_NewNetTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500Updte_NewNetTotalActionPerformed

    private void txt500Updt_NewOrderAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500Updt_NewOrderAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500Updt_NewOrderAmountActionPerformed

    private void btn500Updte_newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500Updte_newItemActionPerformed
    if(cmb500Updt_orderItem.getSelectedIndex()==-1)
        {
          JOptionPane.showMessageDialog(this, "Please choose an item", "Warning", JOptionPane.WARNING_MESSAGE);
           
        }
    else{
        boolean exist=false,exist1=false;
        for (int i = 0; i < tbl500Update_NewitemList.getRowCount(); i++){

            if(String.valueOf(tbl500Update_NewitemList.getValueAt(i,1)).equals(String.valueOf(cmb500Updt_orderItem.getSelectedItem()))){
                JOptionPane.showMessageDialog(this, "This item is already added","Warning!",JOptionPane.WARNING_MESSAGE);
                exist =true;
            }

        }
        for (int i = 0; i < tbl500Update_itemList.getRowCount(); i++){

            if(String.valueOf(tbl500Update_itemList.getValueAt(i,1)).equals(String.valueOf(cmb500Updt_orderItem.getSelectedItem()))){
                JOptionPane.showMessageDialog(this, "This item is already added","Warning!",JOptionPane.WARNING_MESSAGE);
                exist =true;
            }

        }

        if(!exist){
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("finishedProducts");
            dba.UpdateOrderItem(cmb500Updt_orderItem, tbl500Update_NewitemList,spn500Updte_itemQty,txt500Updt_NewOrderAmount,lbl500Upte_itemCount,cmb500Update_discountRate);
            lblAdd500_AddItemErr.setText("");
            txt500Updte_NewNetTotal.setText(String.valueOf((Integer.valueOf(txt500Updt_NewOrderAmount.getText())+Integer.valueOf(txt500Updte_orderTotal.getText()))));
            // dba.addOrderItem(cmb500Updt_ordeItem,tbl500Update_NewitemList,spn500Updte_itemQty,txt500Updt_NewOrderAmount,lbl500Upte_itemCount,cmb500Update_discountRate,cmb500updt_orderCompany);
        }
    }
    }//GEN-LAST:event_btn500Updte_newItemActionPerformed

    private void cmb500Updt_orderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500Updt_orderItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb500Updt_orderItemActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        OrderManagement om =new OrderManagement();
        SetPanel sp = new SetPanel();
        sp.SetPanel(om);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn500_UdateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500_UdateOrderActionPerformed

        if(cmb500Updte_orderId.getSelectedIndex()!=-1 ){
            int dialogResult=JOptionPane.showConfirmDialog(this,"Do you want to Update Order ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(dialogResult==JOptionPane.YES_OPTION){
                for(int i=0;i<tbl500Update_NewitemList.getRowCount();i++)//insert order Items ointo database
                {
                    CustomerOrderDbAccess dba5=new CustomerOrderDbAccess();
                    dba5.insertLargeOrderGoods(String.valueOf(cmb500Updte_orderId.getSelectedItem()) ,
                        String.valueOf(tbl500Update_NewitemList.getValueAt(i,0)),
                        Integer.parseInt(String.valueOf(tbl500Update_NewitemList.getValueAt(i,5))));

                }
                JOptionPane.showMessageDialog(null,"Order Updated Succesfully");

                OrderManagement om =new OrderManagement();
                SetPanel sp = new SetPanel();
                sp.SetPanel(om);

            }

        }
        else{
            JOptionPane.showMessageDialog(null,"One or more fields contain invalid data","Error!", JOptionPane.ERROR_MESSAGE);
            lbl500Updte_OrderIdErr.setText("!");
        }
    }//GEN-LAST:event_btn500_UdateOrderActionPerformed

    private void txt500Updte_orderTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500Updte_orderTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500Updte_orderTotalActionPerformed

    private void cmb500updt_orderCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500updt_orderCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb500updt_orderCompanyActionPerformed

    private void cmb500Updte_orderIdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb500Updte_orderIdPropertyChange
        long orderTotal=0;

        if(cmb500Updte_orderId.getSelectedIndex()!=-1)
        {
            cmb500updt_orderCompany.setEnabled(true);
            cmb500Updt_orderItem.setEnabled(true);
            spn500Updte_itemQty.setEnabled(true);
            btn500Updte_newItem.setEnabled(true);

            CustomerOrderDbAccess dba1=new CustomerOrderDbAccess("largescalecustomer", "companyName");
            dba1.fillCombo(cmb500updt_orderCompany);
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer",String.valueOf(cmb500Updte_orderId.getSelectedItem()));
            cmb500updt_orderCompany.setSelectedItem(dba.getOrderCustomer());

            CustomerOrderDbAccess dba2=new CustomerOrderDbAccess("VW_LargeScaleOrderItems");
            dba2.fillUpdateOrderItems(String.valueOf(cmb500Updte_orderId.getSelectedItem()),tbl500Update_itemList);

            for (int i = 0; i < tbl500Update_itemList.getRowCount(); i++){//increment total order amount
                double amount = Double.parseDouble((String.valueOf(tbl500Update_itemList.getValueAt(i,8))));
                orderTotal += (new Double(amount)).longValue();

            }
            txt500Updte_orderTotal.setText(String.valueOf((new Double(orderTotal)).longValue()));
            txt500Updt_NewOrderAmount.setText(String.valueOf(txt500Updte_orderTotal.getText()));

        }
    }//GEN-LAST:event_cmb500Updte_orderIdPropertyChange

    private void cmb500Updte_orderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500Updte_orderIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb500Updte_orderIdActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JDialog dial = new JDialog();
        dial = new ShipmentInformation(new CustomerOrderManagementMain(), true);
        dial.setVisible(true);

        //  CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder","shipmentDate");
        //dba.fillTableShipment(tbl500View_Orders);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        CustomerOrderDbAccess dba4=new CustomerOrderDbAccess("largescaleorder", "status");
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if(jRadioButton3.isSelected()){
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder");
            dba.fillTableLargeScaleOrder(tbl500View_Orders);
            jLabel13.setText(tbl500View_Orders.getRowCount()+ " Order/s found");
            jLabel11.setText("");

            jButton4.setEnabled(false);
        }
        else if(jRadioButton1.isSelected()){
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder","orderType");
            dba.fillOrderTableOnCondition(tbl500View_Orders,"Foreign");
            jLabel11.setText("");
            jButton4.setEnabled(true);
        }

        else if(jRadioButton2.isSelected()){
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescaleorder","orderType");
            dba.fillOrderTableOnCondition(tbl500View_Orders,"Local");
            jLabel11.setText("");
            jButton4.setEnabled(false);
        }

        else
        jLabel11.setText("!");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txt500View_fromOrderIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt500View_fromOrderIDKeyReleased
        CustomerOrderDbAccess dba=  new CustomerOrderDbAccess("largescaleorder","orderId");
        dba.fillOrderTableOnCondition(tbl500View_Orders,String.valueOf(jTextField1.getText())+"-"+String.valueOf(txt500View_fromOrderID.getText()));
    }//GEN-LAST:event_txt500View_fromOrderIDKeyReleased

    private void txt500View_fromOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500View_fromOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500View_fromOrderIDActionPerformed

    private void jPanel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusLost

    }//GEN-LAST:event_jPanel1FocusLost

    private void btn500Add_clearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500Add_clearOrderActionPerformed
        OrderManagement om =new OrderManagement();
        SetPanel sp = new SetPanel();
        sp.SetPanel(om);
    }//GEN-LAST:event_btn500Add_clearOrderActionPerformed

    private void cmb500Add_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500Add_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb500Add_discountActionPerformed

    private void txt500Add_orderTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500Add_orderTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt500Add_orderTotalActionPerformed

    private void btn500add_orderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500add_orderItemActionPerformed
   
        boolean exist=false;
        
    if(cmb500Add_orderItem.getSelectedIndex()==-1)
        {
          JOptionPane.showMessageDialog(this, "Please choose an item", "Warning", JOptionPane.WARNING_MESSAGE);
           
        }     
    else{ 
        for (int i = 0; i < tbl500Add_orderList.getRowCount(); i++){

            if(String.valueOf(tbl500Add_orderList.getValueAt(i,1)).equals(String.valueOf(cmb500Add_orderItem.getSelectedItem()))){
                JOptionPane.showMessageDialog(this, "This item is already added","Warning!",JOptionPane.WARNING_MESSAGE);
                exist =true;
            }
        }

        if(!exist){
            if(cmb500Add_orderItem.getSelectedIndex()==-1)
            lblAdd500_AddItemErr.setText("!");
            else
            lblAdd500_AddItemErr.setText("");
            CustomerOrderDbAccess dba=new CustomerOrderDbAccess("finishedProducts");
            dba.addOrderItem(cmb500Add_orderItem, tbl500Add_orderList,spn500Add_itemQuantity,txt500Add_orderTotal,lbl500Add_itemCount,cmb500Add_discount,cmb500Add_orderCompany);
        }
    } 
    }//GEN-LAST:event_btn500add_orderItemActionPerformed

    private void spn500Add_itemQuantityPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spn500Add_itemQuantityPropertyChange

    }//GEN-LAST:event_spn500Add_itemQuantityPropertyChange

    private void cmb500Add_orderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500Add_orderItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb500Add_orderItemActionPerformed

    private void btn500Add_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500Add_orderActionPerformed

        cmb500Add_orderCompany.requestFocus(true);
        cmb500Add_orderItem.requestFocus(true);
        btn500Add_order.requestFocus(true);

        if(tbl500Add_orderList.getRowCount()==0)
        { lblAdd500_AddItemErr.setText("!");
        }
        else{lblAdd500_AddItemErr.setText("");
        }

        if(String.valueOf(lblAdd500_orderCompanyErr1.getText()).equals("!")||String.valueOf(lblAdd500_AddItemErr.getText()).equals("!")|| tbl500Update_itemList.getRowCount()==0
            || cmb500Add_orderItem.getSelectedIndex()==-1 || tbl500Add_orderList.getRowCount()==-1
        )
        {
            JOptionPane.showMessageDialog(null, "One or more fields contain Invalid data", "Error!", JOptionPane.ERROR_MESSAGE);

        }

        else if(String.valueOf(lblAdd500_orderCompanyErr1.getText()).equals("")||String.valueOf(lblAdd500_AddItemErr.getText()).equals("")||tbl500Update_itemList.getRowCount()==0) {
            {
                int dialogResult=JOptionPane.showConfirmDialog(this,"Do you want to add Order "+txt500Add_orderId.getText()+ "?","Confirmation",JOptionPane.YES_NO_OPTION);

                if(dialogResult==JOptionPane.YES_OPTION){
                    CustomerOrderDbAccess dba=new CustomerOrderDbAccess("largescalecustomer","companyId");//get companyId
                    CustomerOrderDbAccess dba1=new CustomerOrderDbAccess("largescalecustomer");//getcompNY TYPE
                    CustomerOrderDbAccess dba3=new CustomerOrderDbAccess();//get employee Id

                    Calendar cal = Calendar.getInstance();//get an instance of current date
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                    //Insert Oder into database
                    CustomerOrderDbAccess dba4=new CustomerOrderDbAccess();
                    dba4.insertOrder(String.valueOf(txt500Add_orderId.getText()),date.format(cal.getTime()),
                        dba1.getCompanyType(dba.getUpdateCompanyId(cmb500Add_orderCompany)) ,"",
                        dba3.getEmployeeId("Customer Order Manager"),dba.getUpdateCompanyId(cmb500Add_orderCompany),
                        String.valueOf(cmb500Add_discount.getSelectedItem()),Double.valueOf(txt500Add_orderTotal.getText()) );

                    for(int i=0;i<tbl500Add_orderList.getRowCount();i++)//insert order Items ointo database
                    {
                        CustomerOrderDbAccess dba5=new CustomerOrderDbAccess();
                        dba5.insertLargeOrderGoods(String.valueOf(txt500Add_orderId.getText()) ,
                            String.valueOf(tbl500Add_orderList.getValueAt(i,0)),
                            Integer.parseInt(String.valueOf(tbl500Add_orderList.getValueAt(i,5))));

                    }

                    //get incremented invoice ID
                    CustomerOrderDbAccess dba7=new CustomerOrderDbAccess("invoice", "invoiceNo");
                    idIncrementCOM inv=new idIncrementCOM(dba7.getLastId());

                    //insert into invoice and largeorderinvoice
                    CustomerOrderDbAccess dba8=new CustomerOrderDbAccess();
                    String invoiceNo=inv.incrementInvoiceId();
                    dba8.insertInvoice(invoiceNo,date.format(cal.getTime()) , Double.valueOf(txt500Add_orderTotal.getText()),"Large Scale",String.valueOf(txt500Add_orderId.getText()));

                    CustomerOrderDbAccess dba6=new CustomerOrderDbAccess("largescaleorder","orderId");
                    idIncrementCOM idi=new idIncrementCOM(dba6.getLastId());//Increment CustomerID on form load
                    txt500Add_orderId.setText(idi.incrementId());

                    JOptionPane.showMessageDialog(null, "Order added Successfully", "Successful",JOptionPane.INFORMATION_MESSAGE);

                    OrderManagement om =new OrderManagement();
                    SetPanel sp = new SetPanel();
                    sp.SetPanel(om);

                }
            }
        }
    }//GEN-LAST:event_btn500Add_orderActionPerformed

    private void cmb500Add_orderCompanyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb500Add_orderCompanyPropertyChange
        lblAdd500_orderCompanyErr1.setText("");
    }//GEN-LAST:event_cmb500Add_orderCompanyPropertyChange

    private void cmb500Add_orderCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb500Add_orderCompanyActionPerformed

    }//GEN-LAST:event_cmb500Add_orderCompanyActionPerformed

    private void cmb500Add_orderCompanyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb500Add_orderCompanyFocusLost
        // TextValidator t1=new TextValidator();
        //t1.comboSelection(cmb500Add_orderCompany, lblAdd500_AddItemErr);

        if(cmb500Add_orderCompany.getSelectedIndex()==-1){
            lblAdd500_orderCompanyErr1.setText("!");
        }else
        lblAdd500_orderCompanyErr1.setText("");
    }//GEN-LAST:event_cmb500Add_orderCompanyFocusLost

    private void txt500Add_orderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt500Add_orderIdActionPerformed

    }//GEN-LAST:event_txt500Add_orderIdActionPerformed

    private void tbl500_UpdateOrderDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl500_UpdateOrderDetailsMouseClicked
        DefaultTableModel m= (DefaultTableModel) tbl500_UpdateOrderDetails.getModel();//fill table moodel
        txt500_confirmOrderId.setText((String) m.getValueAt(tbl500_UpdateOrderDetails.getSelectedRow(),0));
        
        
      
        
        
    }//GEN-LAST:event_tbl500_UpdateOrderDetailsMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  CustomerOrderDbAccess dba4=new CustomerOrderDbAccess("largescaleorder", "status");
     
  SimpleDateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
  DefaultTableModel m= (DefaultTableModel) tbl500_UpdateConfirmedOrders.getModel();//fill table moodel
  CustomerOrderDbAccess dba=new CustomerOrderDbAccess();
  String deliveryEmail="",InvoiceEmail="",shipmentStatus="",status="";
 
     if(rbtn_DeliveryEStatusSent.isSelected())
          deliveryEmail="Sent";
     else if(rbtn_DeliveryStatusNotSent.isSelected())
          deliveryEmail="Not Sent";
    
    if(rbtn_invoiceEStatusSent.isSelected())
          InvoiceEmail="Sent";
    else if(rbtn_invoiceEStatusNotSent.isSelected())
         InvoiceEmail="Not Sent";
    
    
    if(rbtn_shipmentStatusShipped.isSelected())
          shipmentStatus="Shipped";
    else if(rbtn_shipmentStatusNotShipped.isSelected())
         shipmentStatus="Not Shipped";
    
    if(rbtn_Confirmed.isSelected())
          status="confirmed";
    else if(rbtn_pending.isSelected())
         status="Pending Confirmation";
 
      
if(String.valueOf(txtUpdateOrderDetails.getText()).equals("")){
    JOptionPane.showMessageDialog(null, "Please Select an Order", "Error!", JOptionPane.WARNING_MESSAGE);

} 
else{
int dialogResult=JOptionPane.showConfirmDialog(this,"Do you want to Update Order ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(dialogResult==JOptionPane.YES_OPTION){
              
 if( m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("Local")||
                m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("local"))
    {
        dba.UpdatetOrderDetailsLocal(String.valueOf(txtUpdateOrderDetails.getText()),InvoiceEmail, deliveryEmail,status);
        CustomerOrderDbAccess db=new CustomerOrderDbAccess("largescaleorder", "status");
        db.fillOrderTableOnCondition(tbl500_UpdateConfirmedOrders,"Confirmed");
        dba4.fillOrderTableOnCondition(tbl500_UpdateOrderDetails,"Pending Confirmation");
        OrderUpdateCount.setText(tbl500_UpdateOrderDetails.getRowCount()+" Unconfirmed Order(s) found ");
        
        rbtn_DeliveryEStatusSent.isSelected();      
        rbtn_DeliveryStatusNotSent.setSelected(false);
        rbtn_invoiceEStatusNotSent.setSelected(false);
        rbtn_invoiceEStatusSent.setSelected(false);
        rbtn_shipmentStatusNotShipped.setSelected(false);
        rbtn_shipmentStatusShipped.setSelected(false); 
        
    
    
    }
 else if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("Foreign")||
                m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("foreign"))
    {
        dba.UpdatetOrderDetailsForeign(String.valueOf(txtUpdateOrderDetails.getText()),InvoiceEmail, deliveryEmail,fmt.format(dateChooser_UpdateShipmentDate.getDate()),shipmentStatus,status);
        CustomerOrderDbAccess db=new CustomerOrderDbAccess("largescaleorder", "status");
        db.fillOrderTableOnCondition(tbl500_UpdateConfirmedOrders,"Confirmed");
        dba4.fillOrderTableOnCondition(tbl500_UpdateOrderDetails,"Pending Confirmation");
        OrderUpdateCount.setText(tbl500_UpdateOrderDetails.getRowCount()+" Unconfirmed Order(s) found ");
        
    }
         txtUpdateOrderDetails.setText("");
        JOptionPane.showMessageDialog(null,"Order Updated Succesfully");
     
                
     }
            
              
}            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl500_UpdateConfirmedOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl500_UpdateConfirmedOrdersMouseClicked
       
        DefaultTableModel m= (DefaultTableModel) tbl500_UpdateConfirmedOrders.getModel();//fill table moodel
        txtUpdateOrderDetails.setText((String) m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),0)); 
        if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("foreign")
           ||m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("Foreign")     )
        {
            rbtn_shipmentStatusNotShipped.setEnabled(true);
            rbtn_shipmentStatusShipped.setEnabled(true);
            dateChooser_UpdateShipmentDate.setEnabled(true);
            
            if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),6).toString().equals("Not Shipped")||
               m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),6).toString().equals(""))
                     rbtn_shipmentStatusNotShipped.setSelected(true);
          
            else if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),6).toString().equals("Shipped")||
                    m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),6).toString().equals("shipped"))
                rbtn_shipmentStatusShipped.setSelected(true);
            
        }
        else if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("Local")||//if local order
                m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),3).toString().equals("local"))
        {
            rbtn_shipmentStatusNotShipped.setEnabled(false);
            rbtn_shipmentStatusShipped.setEnabled(false);
            dateChooser_UpdateShipmentDate.setEnabled(false);
            
        }
        
        
        if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),7).toString().equals("Not Sent"))
            rbtn_DeliveryStatusNotSent.setSelected(true);
        
        else
            rbtn_DeliveryEStatusSent.setSelected(true);
        
        if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),8).toString().equals("Not Sent"))
            rbtn_invoiceEStatusNotSent.setSelected(true);
        else
            rbtn_invoiceEStatusSent.setSelected(true);
        
        if(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),4).toString().equals("confirmed"))
            rbtn_Confirmed.setSelected(true);
        else
            rbtn_pending.setSelected(true);
      
      java.util.Date date = null;
        try {
           date=new SimpleDateFormat("yyyy-MM-dd").parse(m.getValueAt(tbl500_UpdateConfirmedOrders.getSelectedRow(),5).toString());
            dateChooser_UpdateShipmentDate.setDate(date);
        } catch (Exception ex) {
      }
       
    }//GEN-LAST:event_tbl500_UpdateConfirmedOrdersMouseClicked

    private void tbl500_DeliveryDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl500_DeliveryDetailsMouseClicked
        DefaultTableModel m= (DefaultTableModel) tbl500_DeliveryDetails.getModel();
        jTextField2.setText(m.getValueAt(tbl500_DeliveryDetails.getSelectedRow(),0).toString());
    }//GEN-LAST:event_tbl500_DeliveryDetailsMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    DefaultTableModel m= (DefaultTableModel) tbl500_DeliveryDetails.getModel();
      
      if(jTextField2.getText().isEmpty())
      {
           JOptionPane.showMessageDialog(null, "Please Select an Order", "Warning!", JOptionPane.WARNING_MESSAGE);

      }else{
        HashMap param=new HashMap();
        param.put("orderId",m.getValueAt(tbl500_DeliveryDetails.getSelectedRow(),0).toString());
        CustomerOrderManagementMain showme=new CustomerOrderManagementMain("src\\CustomerOrderManagementReports\\CustomerDeliveryReport.jasper",param);
        showme.setVisible(true);//Invoice Generator
      }
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Password.setText("code_404");
        UserName.setText("saajith1727@gmail.com");
        txtSubject.setText("Kelani cables (PVT) LTD-Invoice");
        txtMessage.setText("Thank you for odering,The invoice for your order has been attatched below");
        
    }//GEN-LAST:event_jButton10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeliveryCount;
    private javax.swing.JPanel Jpanel_addItem;
    private javax.swing.JPopupMenu Menu_AddItem;
    private javax.swing.JMenuItem Menu_OrderDetails;
    private javax.swing.JPopupMenu Menu_UpadteOrder;
    private javax.swing.JPopupMenu Menu_pendingOrders;
    private javax.swing.JPopupMenu Menu_viewOrder;
    private javax.swing.JLabel OrderUpdateCount;
    private javax.swing.JPasswordField Password;
    private javax.swing.JPopupMenu PopUpUpdateOrder;
    private javax.swing.JMenuItem RemoveOrder;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton btn500Add_clearOrder;
    private javax.swing.JButton btn500Add_order;
    private javax.swing.JButton btn500Updte_newItem;
    private javax.swing.JButton btn500_UdateOrder;
    private javax.swing.JButton btn500add_orderItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cmb500Add_discount;
    private javax.swing.JComboBox<String> cmb500Add_orderCompany;
    private javax.swing.JComboBox<String> cmb500Add_orderItem;
    private javax.swing.JComboBox<String> cmb500Update_discountRate;
    private javax.swing.JComboBox<String> cmb500Updt_orderItem;
    private javax.swing.JComboBox<String> cmb500Updte_orderId;
    private javax.swing.JComboBox<String> cmb500updt_orderCompany;
    private javax.swing.JComboBox<String> cmbEmail;
    private com.toedter.calendar.JDateChooser dateChooser_UpdateShipmentDate;
    private javax.swing.ButtonGroup deliveryEmailStatus;
    private javax.swing.ButtonGroup invoiceEmailStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl500Add_itemCount;
    private javax.swing.JLabel lbl500Add_orderDateErr;
    private javax.swing.JLabel lbl500Updte_OrderIdErr;
    private javax.swing.JLabel lbl500Upte_itemCount;
    private javax.swing.JLabel lblAdd500_AddItemErr;
    private javax.swing.JLabel lblAdd500_orderCompanyErr1;
    private javax.swing.JRadioButton rbtn_Confirmed;
    private javax.swing.JRadioButton rbtn_DeliveryEStatusSent;
    private javax.swing.JRadioButton rbtn_DeliveryStatusNotSent;
    private javax.swing.JRadioButton rbtn_invoiceEStatusNotSent;
    private javax.swing.JRadioButton rbtn_invoiceEStatusSent;
    private javax.swing.JRadioButton rbtn_pending;
    private javax.swing.JRadioButton rbtn_shipmentStatusNotShipped;
    private javax.swing.JRadioButton rbtn_shipmentStatusShipped;
    private javax.swing.JMenuItem removeItem;
    private javax.swing.ButtonGroup shipmentStatus;
    private javax.swing.JSpinner spn500Add_itemQuantity;
    private javax.swing.JSpinner spn500Updte_itemQty;
    private javax.swing.JTable tbl500Add_orderList;
    private javax.swing.JTable tbl500Update_NewitemList;
    private javax.swing.JTable tbl500Update_itemList;
    private javax.swing.JTable tbl500View_Orders;
    private javax.swing.JTable tbl500_DeliveryDetails;
    private javax.swing.JTable tbl500_UpdateConfirmedOrders;
    private javax.swing.JTable tbl500_UpdateOrderDetails;
    private javax.swing.JTextField txt500Add_orderId;
    private javax.swing.JTextField txt500Add_orderTotal;
    private javax.swing.JTextField txt500Updt_NewOrderAmount;
    private javax.swing.JTextField txt500Updte_NewNetTotal;
    private javax.swing.JTextField txt500Updte_orderTotal;
    private javax.swing.JTextField txt500View_fromOrderID;
    private javax.swing.JTextField txt500_confirmOrderId;
    private javax.swing.JTextPane txtMessage;
    private javax.swing.JTextPane txtSubject;
    private javax.swing.JTextField txtUpdateOrderDetails;
    private javax.swing.JMenuItem updateRemoveItem;
    // End of variables declaration//GEN-END:variables
}
