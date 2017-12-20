/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;


import RootElement.SalesDBConnect;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class OrderManagement extends javax.swing.JPanel {
    
    
    

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    String order;
    String productID;
    int quantity;
    String orderNumber; //SearchToUpdateOrder
    int pq;
    ComboBoxHandler c;
    
    
    public OrderManagement() {
        initComponents();
        
        con = SalesDBConnect.connect();
        
        String id=null;
        String a;
        int b;
        String i;
        
        fillComboBox(product_name);
        fillComboBox(pName);
        fillComboBox();
        fillComboBox1();
        
        
        c = new ComboBoxHandler(cName);

        cName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                c.keyTyped(e);
            }
        });
        
       
        try
        {
            
            String q="SELECT orderId FROM smallscaleorder ORDER BY orderId";
            st = con.createStatement();
            rs = st.executeQuery(q);
            
            while(rs.next())
            {
                id=rs.getString("orderId");
            }
            
           
            a=id.substring(0, 1);
            b=Integer.parseInt(id.substring(1,4));
            b=b+1;
            i=a+String.valueOf(b);
            System.out.println(i);
            oNo.setText(i);
            order = i;
          
        }
        
        catch(Exception e)
        {
        
        }
        
        
        
  
    }
    
    
    public void fillComboBox(JComboBox combo)
    {
        try
	{
            String q = "SELECT DISTINCT name FROM finishedproducts";
            st = con.createStatement();
            rs = st.executeQuery(q);
                
            while(rs.next())
            {
                String value=rs.getString("name");
                combo.addItem(value);
            }
                
            combo.setSelectedIndex(-1);
        }
        
        catch (Exception e)
        {
            DisplayMessage.display("Error");
        }      
           
    }
    
    
    public void fillComboBox()
    {
        try
	{
            String q = "SELECT name FROM employee WHERE jobId='JB009'";
            st = con.createStatement();
            rs = st.executeQuery(q);
                
            while(rs.next())
            {
                String value=rs.getString("name");
                rep.addItem(value);
            }
                
            rep.setSelectedIndex(-1);
        }
        
        catch (Exception e)
        {
            DisplayMessage.display("Error");
        }      
           
    }
    
    
    public void fillComboBox1()
    {
        try
	{
            String q = "SELECT DISTINCT name from smallscalecustomer";
            st = con.createStatement();
            rs = st.executeQuery(q);
                
            while(rs.next())
            {
                String value=rs.getString("name");
                cName.addItem(value);
            }
                
            cName.setSelectedIndex(-1);
        }
        
        catch (Exception e)
        {
            DisplayMessage.display("Error");
        }      
           
    }
    
    
    
    
    
    public void loadTable(String id)
    {
        
        try
        {
            String q1 = "select s1.productId AS ProductID, s2.name AS Description , s1.quantity AS Quantity from finishedproducts s2, smallscalehasgood s1 where s1.productId=s2.productId and orderId='"+ id +"'";
            pst = con.prepareStatement(q1);
            rs = pst.executeQuery();
            CheckTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e)
        {
           DisplayMessage.display("Error");
        }
    }
    
    public void loadTable()
    {
        
        try
        {
            String q5 = "SELECT s1.productId AS ProductId, s2.name AS Description, s1.quantity AS Quantity FROM smallscalehasgood s1, finishedproducts s2 WHERE s1.productId=s2.productId AND s1.orderId = '"+ order +"'";
            pst = con.prepareStatement(q5);
            rs = pst.executeQuery();
            ItemsTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }
    }
    
    
    public void loadTable2(String id)
    {
        
        try
        {
            String q5 = "SELECT s1.productId AS ProductId, s2.name AS Description, s1.quantity AS Quantity FROM smallscalehasgood s1, finishedproducts s2 WHERE s1.productId=s2.productId AND s1.orderId = '"+ id +"'";
            pst = con.prepareStatement(q5);
            rs = pst.executeQuery();
            ProductUpdateTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }
    }
    
    
    public void loadTable1(String id)
    {
        
        try
        {
            String q1 = "select s1.productId AS ProductID, s2.name AS Description , s1.quantity AS Quantity, s1.availability AS AvailablilityStatus from finishedproducts s2, smallscalehasgood s1 where s1.productId=s2.productId and orderId='"+ id +"'";
            pst = con.prepareStatement(q1);
            rs = pst.executeQuery();
            CheckTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }
    }
    
  
    
   /* public void loadTable(String pName, int pQuantity)
    {
        
        try{
        String q4 = "INSERT INTO smallscalehasgood(orderId,productId,quantity) VALUES ('"+ order +"','"+ productID +"','"+ pQuantity +"')";;
        pst = con.prepareStatement(q4);
        rs = pst.executeQuery();
        ItemsTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
           DisplayMessage.display("Error");
        }
        
        loadTable();
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        ProductTable = new javax.swing.JScrollPane();
        ItemsTable = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        AddItem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pQuantity = new javax.swing.JTextField();
        p = new javax.swing.JLabel();
        q = new javax.swing.JLabel();
        pName = new javax.swing.JComboBox<>();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        oNo = new javax.swing.JTextField();
        type = new javax.swing.JComboBox<>();
        Recieved = new com.toedter.calendar.JDateChooser();
        due = new com.toedter.calendar.JDateChooser();
        AddOrder = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        status = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        t = new javax.swing.JLabel();
        rep = new javax.swing.JComboBox<>();
        r = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        jLabel28 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CustomerID = new javax.swing.JLabel();
        n = new javax.swing.JLabel();
        cName = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        oStatus = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        order__Number = new javax.swing.JTextField();
        sRep = new javax.swing.JTextField();
        dDate = new com.toedter.calendar.JDateChooser();
        Update = new javax.swing.JButton();
        ClearOrder = new javax.swing.JButton();
        oType = new javax.swing.JTextField();
        rDate = new javax.swing.JTextField();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        custID = new javax.swing.JTextField();
        custName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        orderNo = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProductUpdateTable = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        Remove = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        product_quantity = new javax.swing.JTextField();
        UpdateQuantity = new javax.swing.JButton();
        ql = new javax.swing.JLabel();
        product_name = new javax.swing.JComboBox<>();
        pn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        SearchOrder = new javax.swing.JButton();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        CheckTable = new javax.swing.JTable();
        CheckAvailability = new javax.swing.JButton();
        NotifyCustomer = new javax.swing.JButton();
        OrderNo = new javax.swing.JTextField();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLayeredPane6.setToolTipText("");

        ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product ID", "Description", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemsTableMouseClicked(evt);
            }
        });
        ProductTable.setViewportView(ItemsTable);

        jButton9.setText("RemoveItem");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        AddItem.setText("Add Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        jLabel9.setText("Product Name");

        jLabel20.setText("Quantity");

        pQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pQuantityKeyTyped(evt);
            }
        });

        p.setForeground(new java.awt.Color(255, 0, 0));

        q.setForeground(new java.awt.Color(255, 0, 0));

        pName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pNameKeyReleased(evt);
            }
        });

        jLayeredPane6.setLayer(ProductTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(AddItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(pQuantity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(p, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(q, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(pName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProductTable)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(29, 29, 29)
                                .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addGap(72, 72, 72)
                                .addComponent(pQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane6Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(q, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel20)
                        .addComponent(pQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(ProductTable, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(AddItem))
                .addContainerGap())
        );

        jLayeredPane8.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane8.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Details"));

        jLabel21.setText("Order No");

        jLabel22.setText("Type");

        jLabel23.setText("Brought by");

        jLabel24.setText("Recieved Date");

        jLabel25.setText("Due Date");

        jLabel26.setText("Status");

        oNo.setEnabled(false);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Export", "Retail" }));
        type.setSelectedIndex(-1);
        type.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                typeFocusLost(evt);
            }
        });

        AddOrder.setText("Add Order");
        AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrderActionPerformed(evt);
            }
        });

        Clear.setText("Clear Details");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        status.setEnabled(false);

        b.setForeground(new java.awt.Color(255, 0, 0));

        t.setForeground(new java.awt.Color(255, 0, 0));

        r.setForeground(new java.awt.Color(255, 0, 0));

        d.setForeground(new java.awt.Color(255, 0, 0));

        jLayeredPane8.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(oNo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(type, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(Recieved, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(due, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(AddOrder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(Clear, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(status, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(b, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(t, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(rep, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(r, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(d, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22))
                                .addGap(35, 35, 35)
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(type, 0, 201, Short.MAX_VALUE)
                                    .addComponent(oNo))
                                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel24))
                                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel26)))
                                        .addGap(55, 55, 55)
                                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(due, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                            .addComponent(status)
                                            .addComponent(Recieved, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(634, 634, 634)))
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(AddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(oNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(24, 24, 24))
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Recieved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(t, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(d, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26)
                    .addComponent(status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddOrder)
                    .addComponent(Clear))
                .addContainerGap())
        );

        jLayeredPane9.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane9.setBorder(javax.swing.BorderFactory.createTitledBorder(" Customter Details"));

        jLabel28.setText("Customer");

        jLabel1.setText("Name");

        n.setForeground(new java.awt.Color(255, 51, 51));

        cName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cNameItemStateChanged(evt);
            }
        });
        cName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cNameFocusLost(evt);
            }
        });
        cName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cNameMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cNameMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cNameMouseReleased(evt);
            }
        });
        cName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameActionPerformed(evt);
            }
        });
        cName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cNamePropertyChange(evt);
            }
        });
        cName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cNameKeyTyped(evt);
            }
        });

        jLayeredPane9.setLayer(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(CustomerID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(n, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(cName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane9Layout = new javax.swing.GroupLayout(jLayeredPane9);
        jLayeredPane9.setLayout(jLayeredPane9Layout);
        jLayeredPane9Layout.setHorizontalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(43, 43, 43)
                .addComponent(CustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(cName, 0, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jLayeredPane9Layout.setVerticalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(n, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(jLabel1)
                                .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(CustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane6)
                    .addComponent(jLayeredPane9)
                    .addComponent(jLayeredPane8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLayeredPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLayeredPane6.getAccessibleContext().setAccessibleName("Order");

        jTabbedPane1.addTab("Add Order Details", jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("Order");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane3.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Details"));

        jLabel10.setText("Order No");

        oStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", "Withdrawn" }));
        oStatus.setSelectedIndex(-1);

        jLabel11.setText("Type");

        jLabel12.setText("Brought by");

        jLabel13.setText("Recived Date");

        jLabel14.setText("Due Date");

        jLabel15.setText("Status");

        order__Number.setEnabled(false);

        sRep.setEnabled(false);

        Update.setText("Update Order");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        ClearOrder.setText("Clear Details");
        ClearOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearOrderActionPerformed(evt);
            }
        });

        oType.setEnabled(false);

        rDate.setEnabled(false);

        jLayeredPane3.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(oStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(order__Number, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(sRep, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(dDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(Update, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(ClearOrder, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(oType, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(rDate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(26, 26, 26)
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sRep, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oType, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13))
                                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dDate, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rDate, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(35, 35, 35)
                        .addComponent(order__Number, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(order__Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(rDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(oType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(dDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(sRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(oStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(ClearOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane4.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(" Customter Details"));

        jLabel16.setText("Customer ID");

        jLabel17.setText("Customer Name");

        custID.setEnabled(false);

        custName.setEnabled(false);

        jLayeredPane4.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(custID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(custName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(custID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(custID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel18.setText("Order No");

        orderNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNoActionPerformed(evt);
            }
        });
        orderNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderNoKeyReleased(evt);
            }
        });

        Search.setText("Search Order");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jLayeredPane10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLayeredPane10.setToolTipText("");

        ProductUpdateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product ID", "Description", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ProductUpdateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductUpdateTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ProductUpdateTable);

        jLabel29.setText("Product Name");

        Remove.setText("Remove Item");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        Add.setText("Add Item");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel30.setText("Quantity");

        product_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_quantityActionPerformed(evt);
            }
        });
        product_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                product_quantityKeyTyped(evt);
            }
        });

        UpdateQuantity.setText("Update Quantity");
        UpdateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateQuantityActionPerformed(evt);
            }
        });

        ql.setForeground(new java.awt.Color(255, 51, 51));

        pn.setForeground(new java.awt.Color(255, 51, 51));

        jLayeredPane10.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(Remove, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(Add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(product_quantity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(UpdateQuantity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(ql, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(product_name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane10.setLayer(pn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane10Layout = new javax.swing.GroupLayout(jLayeredPane10);
        jLayeredPane10.setLayout(jLayeredPane10Layout);
        jLayeredPane10Layout.setHorizontalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane10Layout.createSequentialGroup()
                .addGroup(jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jLayeredPane10Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel30)
                                .addGap(45, 45, 45)
                                .addComponent(product_quantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ql, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))))
                    .addGroup(jLayeredPane10Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(UpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );
        jLayeredPane10Layout.setVerticalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ql, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jLabel30)
                        .addComponent(product_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(UpdateQuantity)
                    .addComponent(Remove))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel18)
                        .addGap(46, 46, 46)
                        .addComponent(orderNo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane10)))
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(orderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update Order Details", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Order No");

        SearchOrder.setText("Search Order");
        SearchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOrderActionPerformed(evt);
            }
        });

        jLayeredPane5.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Details"));

        CheckTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product ID", "Description", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(CheckTable);

        jLayeredPane5.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        CheckAvailability.setText("Check Availability");
        CheckAvailability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckAvailabilityActionPerformed(evt);
            }
        });

        NotifyCustomer.setText("Notify Customer");
        NotifyCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotifyCustomerActionPerformed(evt);
            }
        });

        OrderNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                OrderNoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(OrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(SearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(CheckAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(NotifyCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(SearchOrder)
                    .addComponent(OrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckAvailability)
                    .addComponent(NotifyCustomer))
                .addContainerGap(290, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check Availability", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void orderNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderNoActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        orderNumber=orderNo.getText();
        
        
        try
        {
            String q7="select s1.customerId, s1.name, s2.orderId, s2.receivedDate, s2.orderType, s2.dueDate, s2.status, s2.employeeId from smallscalecustomer s1, smallscaleorder s2 where s1.customerId=s2.customerId and orderId='"+ orderNumber +"'";
            st = con.createStatement();
            rs = st.executeQuery(q7);
            
            while(rs.next())
            {
                String id = rs.getString("customerId");
                custID.setText(id);
                
                String cname = rs.getString("name");
                custName.setText(cname);
                
                String oId = rs.getString("orderId");
                order__Number.setText(oId);
                
                String oRDate = rs.getString("receivedDate"); // changed
                rDate.setText(oRDate);
                
                String orderType = rs.getString("orderType");
                oType.setText(orderType);
                
                
                Date d= new Date();
                d = rs.getDate("dueDate");
                dDate.setDate(d);
             
                
                String orderStatus = rs.getString("status");
                oStatus.setSelectedItem(orderStatus);
                
                
                String emp = rs.getString("employeeId");
                sRep.setText(emp);
                
                loadTable2(orderNumber);
           
            }//end of while
            
        }//end of try
        
        catch(Exception e)
        {
            
            DisplayMessage.display("Unable to search order");
        }
        
        
       
        
        
    }//GEN-LAST:event_SearchActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        SimpleDateFormat ft = new SimpleDateFormat("yyy/MM/dd");
        String date1 = ft.format(dDate.getDate());

        String orderStatus = oStatus.getSelectedItem().toString();

        int c = JOptionPane.showConfirmDialog(null,"Are you sure you want to update?");
       
        if(c==0)
        {    
            try
            {
                String q11 = "UPDATE smallscaleorder SET dueDate='"+ date1 +"', status='"+ orderStatus +"' where orderId='"+ orderNumber +"'";
                pst = con.prepareStatement(q11); 
                pst.execute();
                DisplayMessage.display("Order Updated Successfully");

            }
            
            catch(Exception e)
            {
                DisplayMessage.display("Unable to update order");
            }
        }
       
//        orderNo.setText("");
//        custID.setText("");
//        custName.setText("");
//        order__Number.setText("");
//        rDate.setText("");
//        oType.setText("");
//        sRep.setText("");
//        oStatus.setSelectedIndex(-1);
       
    }//GEN-LAST:event_UpdateActionPerformed

    private void SearchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchOrderActionPerformed
       
        order = OrderNo.getText();
        loadTable(order);
    }//GEN-LAST:event_SearchOrderActionPerformed

    private void NotifyCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotifyCustomerActionPerformed
         
        NotifyCustomer  n1= new NotifyCustomer();
        n1.setVisible(true);         
            
    }//GEN-LAST:event_NotifyCustomerActionPerformed

    private void AddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOrderActionPerformed

     
        
        String empID = "";
        
        status.setText("Pending");
        
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
        String date1 = "";
        String date2 = "";
        if(due.getDate()!=null && Recieved.getDate()!=null)
        {
            date1 = String.valueOf(ft.format(due.getDate()));
            date2 = String.valueOf(ft.format(Recieved.getDate()));
            
            DateValidator.Validate(date2, date1,d);
            
        }
        
        else 
        {
            r.setText("!");
            d.setText("!");
        
        }
        
        
       
        
        if(cName.getSelectedIndex()==-1)
        {
            n.setText("!");
            
        }
        
        if(type.getSelectedIndex()==-1)
        {
           t.setText("!");
        } 
        
        
        String broughtBy = String.valueOf(rep.getSelectedItem());
        if(rep.getSelectedIndex() == -1)
        {
            b.setText("!");
        }
        
        
          
        
        
         
        if("!".equals(n.getText())||"!".equals(t.getText())||"!".equals(b.getText()) ||"!".equals(d.getText())||"!".equals(r.getText()))
        {
            DisplayMessage.display("Invalid Data Entry");
            b.setText("");
            t.setText("");
            n.setText("");
            r.setText("");
            d.setText("");
        }
                
        
        
        else
        {    
        
            String orderStatus = status.getText();
      
       
            String custID = null;
        
            order = oNo.getText();
        
            String orderType = String.valueOf(type.getSelectedItem());
        
            String customer = cName.getSelectedItem().toString();
            
            try
            {


                String q2 = "SELECT customerId FROM smallScaleCustomer WHERE name='"+ customer +"'";
                st = con.createStatement();
                rs = st.executeQuery(q2);
                while(rs.next())
                {
                    custID = rs.getString("customerId");
                    //CustomerID.setText(custID);
                }
            }
           
            catch(Exception e)
            {
                DisplayMessage.display("Error");
            }

            try
            {
                String q3 = "SELECT employeeId FROM employee WHERE name='"+ broughtBy +"'";
                st = con.createStatement();
                rs = st.executeQuery(q3);
                while(rs.next())
                {
                    empID = rs.getString("employeeId");
                }
            }
           
            catch(Exception e)
            {
                DisplayMessage.display("Brought By");
            }
       
       
               
        
        
            try
            {
                String q1 = "INSERT INTO smallScaleOrder VALUES ('"+ order +"', '"+ date2 +"', '"+ orderType +"','"+ date1 +"','"+ orderStatus +"','"+ custID +"','"+ empID +"')";

                pst = con.prepareStatement(q1); 

                pst.execute();
                DisplayMessage.display("Order Successfully Added");
                
//                cName.setText("");
//                CustomerID.setText("");
//                oNo.setText("");
//                type.setSelectedIndex(-1);
//                rep.setSelectedIndex(-1);
//                status.setText("");
            }
        
            catch (Exception e)
            {
               DisplayMessage.display("Unable to add order");
            }
        
        }
        
        
        
        
        
        
        
        
        
       
        
        
    }//GEN-LAST:event_AddOrderActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        
      
        String pid="";
//        if(pName.getSelectedIndex() == -1)
//        {
//            p.setText("!");
//        }  
        
        
       
//        if(pQuantity.getText().isEmpty())
//        {
//            q.setText("!");
//        }    
       
        
        
  /*      try
        {
            String q3 = "SELECT productId FROM finishedProducts WHERE name='"+ productName +"'";
            st = con.createStatement();
            rs = st.executeQuery(q3);
            while(rs.next())
            {
             //   productID = rs.getString("productId");
               pid=rs.getString("productId");
            }
        }
           
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }
    */    
//        if("!".equals(q.getText())||"!".equals(p.getText()))
//        {
//           DisplayMessage.display("Invalid Data Entry");
//            p.setText("");
//            q.setText("");
//            
//        }        
        
        if(pName.getSelectedIndex()==-1)
        {
           p.setText("!");
        }
        
        if(pQuantity.getText().isEmpty())
        {
            q.setText("!");   
        }
        
        if("!".equals(q.getText()) || "!".equals(p.getText()))
        {
            DisplayMessage.display("Invalid Data Entry");
            q.setText("");
            p.setText("");
        }
        
        else
        {
             quantity = Integer.parseInt(pQuantity.getText());
              String productName = pName.getSelectedItem().toString();
        
              try
        {
            String q3 = "SELECT productId FROM finishedProducts WHERE name='"+ productName +"'";
            st = con.createStatement();
            rs = st.executeQuery(q3);
            while(rs.next())
            {
             //   productID = rs.getString("productId");
               pid=rs.getString("productId");
            }
        }
           
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }
            try
            {
                String q1 = "INSERT INTO smallscalehasgood(orderId,productId,quantity) VALUES ('"+ order +"','"+ pid+"','"+ quantity +"')";

                pst = con.prepareStatement(q1); 
                pst.execute();
                DisplayMessage.display("Item Successfully Added");
            }
        
            catch (Exception e)
            {
                DisplayMessage.display("Unable to add item");
            }
        }
        
        loadTable();
        
        pName.setSelectedIndex(-1);
        pQuantity.setText("");
        
        
     
        
        
    }//GEN-LAST:event_AddItemActionPerformed

    private void CheckAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckAvailabilityActionPerformed
        for(int r=0; r<=CheckTable.getRowCount()-1; r++)
        {
            int q= Integer.parseInt(String.valueOf(CheckTable.getValueAt(r,2)));
            String id =String.valueOf(CheckTable.getValueAt(r,0));
            
            try
            {
                
                String q8 = "select quantity from finishedproducts where productId='"+ id +"'";
                st = con.createStatement();
                rs = st.executeQuery(q8);
                while(rs.next())
                {
                pq = Integer.parseInt(rs.getString("quantity"));
              
                } //end of while
                
                try
                {
                    if(q<=pq)
                    {
                        String q9 = "UPDATE smallscalehasgood SET availability='Availabale' WHERE orderId='"+ order +"' AND productId='"+ id +"'";
                        pst = con.prepareStatement(q9); 
                        pst.execute();
                        //DisplayMessage.display("Successful");

                    }
                    
                    else if(q>pq)
                    {
                        String q9 = "UPDATE smallscalehasgood SET availability='Not available' WHERE orderId='"+ order +"' AND productId='"+ id +"'";
                        pst = con.prepareStatement(q9); 
                        pst.execute();
                        //DisplayMessage.display("Successful");
                    }
                }//end of try
                
                catch(Exception e)
                { DisplayMessage.display("Error");
                  //System.out.println(e);
                }
                
            } //end of try
            
            catch(Exception e)
            {
                DisplayMessage.display("Error");
            }
            
        }//end of for
            
        loadTable1(order);
            
            
    }//GEN-LAST:event_CheckAvailabilityActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int r = ItemsTable.getSelectedRow();
        
        String pId =ItemsTable.getValueAt(r,0).toString();
        
        try
        {
            String q6 = "DELETE FROM smallscalehasgood WHERE orderId = '"+ order +"' AND productId = '"+ pId +"'";

            pst = con.prepareStatement(q6); 
            pst.execute();
            DisplayMessage.display("Item Successfully Deleted");
        }
        
        catch (Exception e)
        {
            DisplayMessage.display("Unable to delete item");
        }
        
        loadTable();
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void ClearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearOrderActionPerformed
        orderNo.setText("");
        custID.setText("");
        custName.setText("");
        order__Number.setText("");
        rDate.setText("");
        oType.setText("");
        sRep.setText("");
        oStatus.setSelectedIndex(-1);
        
        //ProductUpdateTable
        DefaultTableModel t = (DefaultTableModel) ProductUpdateTable.getModel();
        t.setRowCount(0);
        
    }//GEN-LAST:event_ClearOrderActionPerformed

    private void ItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemsTableMouseClicked

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        int r = ProductUpdateTable.getSelectedRow();
        
        String pId =ProductUpdateTable.getValueAt(r,0).toString();
        
        try
        {
            String q12 = "DELETE FROM smallscalehasgood WHERE orderId = '"+ orderNumber +"' AND productId = '"+ pId +"'";

            pst = con.prepareStatement(q12); 
            pst.execute();
            DisplayMessage.display("Item Successfully Deleted");
            
            product_quantity.setText("");
            product_name.setSelectedIndex(-1);
        }
        
        catch (Exception e)
        {
            DisplayMessage.display("Unable to delete item");
        }
        
        loadTable2(orderNumber);
    }//GEN-LAST:event_RemoveActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if(product_name.getSelectedIndex()==-1)
        {
           pn.setText("!");
        }
        
        if(product_quantity.getText().isEmpty())
        {
            ql.setText("!");   
        }
        
        if("!".equals(ql.getText()) || "!".equals(pn.getText()))
        {
            DisplayMessage.display("Invalid Data Entry");
            ql.setText("");
            pn.setText("");
        }
        
        else
        {    
        
            String productName = product_name.getSelectedItem().toString();
            quantity = Integer.parseInt(product_quantity.getText());
        
            try
            {
                String q3 = "SELECT productId FROM finishedProducts WHERE name='"+ productName +"'";
                st = con.createStatement();
                rs = st.executeQuery(q3);
                while(rs.next())
                {
                    productID = rs.getString("productId");
                }
            }

            catch(Exception e)
            {
                //System.out.println(e);
                DisplayMessage.display("Error");
            }

            try
            {
                String q1 = "INSERT INTO smallscalehasgood(orderId,productId,quantity) VALUES ('"+ orderNumber +"','"+ productID +"','"+ quantity +"')";

                pst = con.prepareStatement(q1); 
                pst.execute();
                DisplayMessage.display("Item Successfully Added");
            }

            catch (Exception e)
            {
                //DisplayMessage.display("Unable to add item");
                System.out.println(e);
            }
        
            loadTable2(orderNumber);
        
            product_name.setSelectedIndex(-1);
            product_quantity.setText("");
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void product_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_quantityActionPerformed

    private void UpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateQuantityActionPerformed
        int r = ProductUpdateTable.getSelectedRow();
       
        String product_id=String.valueOf(ProductUpdateTable.getValueAt(r,0));
       
        if(product_quantity.getText().isEmpty())
        {
            ql.setText("!");   
        }
        
        if("!".equals(ql.getText()))
        {
            DisplayMessage.display("Invalid Data Entry");
            ql.setText(""); 
        }    
       
        else
        {    
            
            try
            {
            
                String q2 = "UPDATE smallscalehasgood SET quantity='"+ product_quantity.getText() +"' WHERE orderId='"+ orderNumber +"' AND productId='"+ product_id +"'";
                pst = con.prepareStatement(q2); 
                pst.execute();
                DisplayMessage.display("Quantity Updated Successfully");
            }
       
            catch (Exception e)
            {
                DisplayMessage.display("Unable to update quantity");
            }
       
            
            product_quantity.setText("");
            product_name.setSelectedIndex(-1);
       
            loadTable2(orderNumber);
            
        }    
       
       
       
    }//GEN-LAST:event_UpdateQuantityActionPerformed

    private void ProductUpdateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductUpdateTableMouseClicked
        int r = ProductUpdateTable.getSelectedRow();
        
        product_quantity.setText(String.valueOf(ProductUpdateTable.getValueAt(r,2)));
        product_name.setSelectedItem(ProductUpdateTable.getValueAt(r,1));
        
       
        
      
    }//GEN-LAST:event_ProductUpdateTableMouseClicked

    private void typeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeFocusLost
      /*  if(type.getSelectedIndex()==-1)
        {
           t.setText("!");
        }*/
    }//GEN-LAST:event_typeFocusLost

    private void orderNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderNoKeyReleased
            
        orderNumber=orderNo.getText();
        
        
        try
        {
            String q7="select s1.customerId, s1.name, s2.orderId, s2.receivedDate, s2.orderType, s2.dueDate, s2.status, s2.employeeId from smallscalecustomer s1, smallscaleorder s2 where s1.customerId=s2.customerId and orderId='"+ orderNumber +"'";
            st = con.createStatement();
            rs = st.executeQuery(q7);
            
            while(rs.next())
            {
                String id = rs.getString("customerId");
                custID.setText(id);
                
                String cname = rs.getString("name");
                custName.setText(cname);
                
                String oId = rs.getString("orderId");
                order__Number.setText(oId);
                
                String oRDate = rs.getString("receivedDate"); // changed
                rDate.setText(oRDate);
                
                String orderType = rs.getString("orderType");
                oType.setText(orderType);
                
                
                Date d= new Date();
                d = rs.getDate("dueDate");
                dDate.setDate(d);
             
                
                String orderStatus = rs.getString("status");
                oStatus.setSelectedItem(orderStatus);
                
                
                String emp = rs.getString("employeeId");
                sRep.setText(emp);
                
                loadTable2(orderNumber);
           
            }//end of while
            
        }//end of try
        
        catch(Exception e)
        {
            DisplayMessage.display("Unable to search order");
        }
        
        
    }//GEN-LAST:event_orderNoKeyReleased

    private void product_quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_product_quantityKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
        {
            evt.consume();
        }
    }//GEN-LAST:event_product_quantityKeyTyped

    private void pQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pQuantityKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
        {
            evt.consume();
        }
    }//GEN-LAST:event_pQuantityKeyTyped

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        cName.setSelectedIndex(-1);
        CustomerID.setText("");
        oNo.setText("");
        type.setSelectedIndex(-1);
        rep.setSelectedIndex(-1);
        status.setText("");
        Recieved.setDate(null);
        due.setDate(null);
    }//GEN-LAST:event_ClearActionPerformed

    private void pNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pNameKeyReleased

    private void cNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cNameKeyReleased
        String customer = cName.getSelectedItem().toString();
        String custID = "";
        try
        {
            String q2 = "SELECT customerId FROM smallScaleCustomer WHERE name='"+ customer +"'";
            st = con.createStatement();
            rs = st.executeQuery(q2);
            while(rs.next())
            {
                custID = rs.getString("customerId");
                CustomerID.setText(custID);
            }
        }
           
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }
    }//GEN-LAST:event_cNameKeyReleased

    private void cNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cNameItemStateChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_cNameItemStateChanged

    private void cNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameFocusLost

    private void cNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cNameActionPerformed

    private void cNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cNameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameMouseExited

    private void cNameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cNameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameMouseReleased

    private void cNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cNamePropertyChange

        
        String custID;
        
        try
        {
            String q2 = "SELECT customerId FROM smallScaleCustomer WHERE name='"+ cName.getSelectedItem() +"'";
            st = con.createStatement();
            rs = st.executeQuery(q2);
            while(rs.next())
            {
                custID = rs.getString("customerId");
                CustomerID.setText(custID);
            }
        }
           
        catch(Exception e)
        {
            DisplayMessage.display("Error");
        }



        
        
        //System.out.println("Changed ! ");
       
        
    }//GEN-LAST:event_cNamePropertyChange

    private void cNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameFocusGained

    private void cNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cNameMousePressed
    
    }//GEN-LAST:event_cNameMousePressed

    private void OrderNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OrderNoKeyReleased
        order = OrderNo.getText();
        loadTable(order);
    }//GEN-LAST:event_OrderNoKeyReleased

    private void cNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cNameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton AddItem;
    private javax.swing.JButton AddOrder;
    private javax.swing.JButton CheckAvailability;
    private javax.swing.JTable CheckTable;
    private javax.swing.JButton Clear;
    private javax.swing.JButton ClearOrder;
    private javax.swing.JLabel CustomerID;
    private javax.swing.JTable ItemsTable;
    private javax.swing.JButton NotifyCustomer;
    private javax.swing.JTextField OrderNo;
    private javax.swing.JScrollPane ProductTable;
    private javax.swing.JTable ProductUpdateTable;
    private com.toedter.calendar.JDateChooser Recieved;
    private javax.swing.JButton Remove;
    private javax.swing.JButton Search;
    private javax.swing.JButton SearchOrder;
    private javax.swing.JButton Update;
    private javax.swing.JButton UpdateQuantity;
    private javax.swing.JLabel b;
    private javax.swing.JComboBox<String> cName;
    private javax.swing.JTextField custID;
    private javax.swing.JTextField custName;
    private javax.swing.JLabel d;
    private com.toedter.calendar.JDateChooser dDate;
    private com.toedter.calendar.JDateChooser due;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel n;
    private javax.swing.JTextField oNo;
    private javax.swing.JComboBox<String> oStatus;
    private javax.swing.JTextField oType;
    private javax.swing.JTextField orderNo;
    private javax.swing.JTextField order__Number;
    private javax.swing.JLabel p;
    private javax.swing.JComboBox<String> pName;
    private javax.swing.JTextField pQuantity;
    private javax.swing.JLabel pn;
    private javax.swing.JComboBox<String> product_name;
    private javax.swing.JTextField product_quantity;
    private javax.swing.JLabel q;
    private javax.swing.JLabel ql;
    private javax.swing.JLabel r;
    private javax.swing.JTextField rDate;
    private javax.swing.JComboBox<String> rep;
    private javax.swing.JTextField sRep;
    private javax.swing.JTextField status;
    private javax.swing.JLabel t;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
