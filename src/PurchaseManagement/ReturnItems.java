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

/**
 *
 * @author Samitha Heanthenna
 */
public class ReturnItems extends javax.swing.JPanel {

    /**
     * Creates new form ReturnItems
     */
    public ReturnItems() {
        
        ComboKeyHandler cm;
        ComboKeyHandler cm1;
        
        initComponents();
        
        btn304.requestFocusInWindow();
        
        DbConnect c=new DbConnect();
        c.setConnection();
        
            try
            {                                                                             
                ResultSet qresults;
                Statement statem1=c.con.createStatement();
                qresults=statem1.executeQuery("select * from returnitem");
                               
                String ids="";
            
                while(qresults.next())
                {
                    ids=qresults.getString("returnId");
                }
                
                IdIncrementPurchase inc=new IdIncrementPurchase(ids,'r');
                String newids=inc.getIncrementedId();
                
                txtF302.setText(newids);
                

                
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
            
            DbAccessPurchase dba2 = new DbAccessPurchase("purchase");
            dba2.fillTableReturn(tbl331, lblResultCount);
            
            dba2.fillNextComboreturn(cmb397);
            cm=new ComboKeyHandler(cmb397);
            
            cmb397.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                cm.keyTyped(e);
            }
        });
            
            DbAccessPurchase dba = new DbAccessPurchase("returnitem");
            dba.viewReturns(tbl318, lblResultCount2);
            
            dba.fillNextComboreturnreport(cmb302);
            cm1=new ComboKeyHandler(cmb302);
            
            cmb302.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                cm1.keyTyped(e);
            }
        });
            
            clndr306.setMaxSelectableDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtb300 = new javax.swing.JTabbedPane();
        jpnl301 = new javax.swing.JPanel();
        lblReturnID = new javax.swing.JLabel();
        txtF302 = new javax.swing.JTextField();
        lblReturnDate = new javax.swing.JLabel();
        lblReason = new javax.swing.JLabel();
        lblDescripiton = new javax.swing.JLabel();
        jpnl303 = new javax.swing.JPanel();
        tbl307 = new javax.swing.JScrollPane();
        tbl331 = new javax.swing.JTable();
        lblResultCount = new javax.swing.JLabel();
        btn304 = new javax.swing.JButton();
        btn305 = new javax.swing.JButton();
        clndr306 = new com.toedter.calendar.JDateChooser();
        cmb307 = new javax.swing.JComboBox<>();
        jtbl308 = new javax.swing.JScrollPane();
        TxtA399 = new javax.swing.JTextArea();
        lbl309 = new javax.swing.JLabel();
        lbl310 = new javax.swing.JLabel();
        lbl311 = new javax.swing.JLabel();
        lblReturnID1 = new javax.swing.JLabel();
        cmb397 = new javax.swing.JComboBox<>();
        lbl365 = new javax.swing.JLabel();
        btn401 = new javax.swing.JButton();
        jpnl311 = new javax.swing.JPanel();
        lblSearchReturnID = new javax.swing.JLabel();
        txtF312 = new javax.swing.JTextField();
        btn314 = new javax.swing.JButton();
        jpnl315 = new javax.swing.JPanel();
        tbl316 = new javax.swing.JScrollPane();
        tbl318 = new javax.swing.JTable();
        lblResultCount2 = new javax.swing.JLabel();
        lblSearchReturnID1 = new javax.swing.JLabel();
        btn315 = new javax.swing.JButton();
        cmb302 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 590));

        jtb300.setBackground(new java.awt.Color(255, 255, 255));

        jpnl301.setBackground(new java.awt.Color(255, 255, 255));

        lblReturnID.setText("Return ID");

        txtF302.setEditable(false);

        lblReturnDate.setText("Return date");

        lblReason.setText("Reason");

        lblDescripiton.setText("Descripition");

        jpnl303.setBackground(new java.awt.Color(255, 255, 255));
        jpnl303.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Items"));

        tbl331.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Purchase ID", "Purchase Type", "Purchas Via"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl307.setViewportView(tbl331);

        lblResultCount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl303Layout = new javax.swing.GroupLayout(jpnl303);
        jpnl303.setLayout(jpnl303Layout);
        jpnl303Layout.setHorizontalGroup(
            jpnl303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl303Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl303Layout.createSequentialGroup()
                        .addComponent(lblResultCount, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addComponent(tbl307, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnl303Layout.setVerticalGroup(
            jpnl303Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl303Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl307, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultCount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn304.setText("Add return");
        btn304.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn304ActionPerformed(evt);
            }
        });

        btn305.setText("Cancel ");
        btn305.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn305ActionPerformed(evt);
            }
        });

        clndr306.setMaxSelectableDate(new java.util.Date(1790015340000L));
        clndr306.setMinSelectableDate(new java.util.Date(1451590278000L));
        clndr306.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                clndr306FocusLost(evt);
            }
        });

        cmb307.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Damaged", "Not Matching", "Seal Broken", "Expired", "Other" }));
        cmb307.setSelectedIndex(-1);
        cmb307.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb307FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb307FocusLost(evt);
            }
        });

        TxtA399.setColumns(20);
        TxtA399.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TxtA399.setLineWrap(true);
        TxtA399.setRows(5);
        TxtA399.setWrapStyleWord(true);
        TxtA399.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtA399KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtA399KeyTyped(evt);
            }
        });
        jtbl308.setViewportView(TxtA399);

        lbl309.setBackground(new java.awt.Color(255, 255, 255));
        lbl309.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl309.setForeground(new java.awt.Color(255, 0, 0));

        lbl310.setBackground(new java.awt.Color(255, 255, 255));
        lbl310.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl310.setForeground(new java.awt.Color(255, 0, 0));

        lbl311.setBackground(new java.awt.Color(255, 255, 255));
        lbl311.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl311.setForeground(new java.awt.Color(255, 0, 0));

        lblReturnID1.setText("Purchase ID");

        cmb397.setEditable(true);
        cmb397.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmb397FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmb397FocusLost(evt);
            }
        });

        lbl365.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lbl365.setForeground(new java.awt.Color(0, 102, 0));
        lbl365.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl365.setText("250 Characters Left");

        btn401.setText("Demo");
        btn401.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn401ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnl301Layout = new javax.swing.GroupLayout(jpnl301);
        jpnl301.setLayout(jpnl301Layout);
        jpnl301Layout.setHorizontalGroup(
            jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl301Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReturnID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReason, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReturnDate)
                    .addComponent(lblDescripiton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReturnID1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnl301Layout.createSequentialGroup()
                                .addComponent(txtF302, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpnl301Layout.createSequentialGroup()
                                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpnl301Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(clndr306, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                            .addComponent(cmb397, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(31, 31, 31))
                                    .addGroup(jpnl301Layout.createSequentialGroup()
                                        .addComponent(cmb307, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl309, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl311, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl310, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl365, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbl308, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addComponent(btn401, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn304, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn305, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jpnl303, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpnl301Layout.setVerticalGroup(
            jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl301Layout.createSequentialGroup()
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtF302, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReturnID))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl311, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb397)
                                .addComponent(lblReturnID1)))
                        .addGap(18, 18, 18)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clndr306, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReturnDate)
                            .addComponent(lbl309, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl310, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmb307, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblReason)))
                        .addGap(30, 30, 30)
                        .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripiton)
                            .addComponent(jtbl308, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl365, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnl301Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnl303, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jpnl301Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn304)
                    .addComponent(btn305)
                    .addComponent(btn401))
                .addGap(16, 16, 16))
        );

        jtb300.addTab("Add returns", jpnl301);

        jpnl311.setBackground(new java.awt.Color(255, 255, 255));

        lblSearchReturnID.setText("Search by return ID");

        txtF312.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtF312KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtF312KeyTyped(evt);
            }
        });

        btn314.setText("View all");
        btn314.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn314ActionPerformed(evt);
            }
        });

        jpnl315.setBackground(new java.awt.Color(255, 255, 255));
        jpnl315.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl318.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Return ID", "Purchase ID", "Return Date", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl316.setViewportView(tbl318);

        lblResultCount2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultCount2.setForeground(new java.awt.Color(0, 153, 51));
        lblResultCount2.setText("0 Maching record(s) found");

        javax.swing.GroupLayout jpnl315Layout = new javax.swing.GroupLayout(jpnl315);
        jpnl315.setLayout(jpnl315Layout);
        jpnl315Layout.setHorizontalGroup(
            jpnl315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl315Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnl315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl316, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jpnl315Layout.createSequentialGroup()
                        .addComponent(lblResultCount2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnl315Layout.setVerticalGroup(
            jpnl315Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl315Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbl316, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResultCount2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblSearchReturnID1.setText("Return ID");

        btn315.setText("Genarate report");
        btn315.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn315ActionPerformed(evt);
            }
        });

        cmb302.setEditable(true);

        javax.swing.GroupLayout jpnl311Layout = new javax.swing.GroupLayout(jpnl311);
        jpnl311.setLayout(jpnl311Layout);
        jpnl311Layout.setHorizontalGroup(
            jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnl311Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnl311Layout.createSequentialGroup()
                        .addComponent(lblSearchReturnID1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb302, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn315))
                    .addGroup(jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jpnl315, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpnl311Layout.createSequentialGroup()
                            .addComponent(lblSearchReturnID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtF312, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn314, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jpnl311Layout.setVerticalGroup(
            jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnl311Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF312, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchReturnID)
                    .addComponent(btn314))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jpnl315, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jpnl311Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchReturnID1)
                    .addComponent(btn315)
                    .addComponent(cmb302, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jtb300.addTab("View Returns", jpnl311);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtb300)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtb300)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmb397FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb397FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb397, lbl311);
    }//GEN-LAST:event_cmb397FocusLost

    private void cmb397FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb397FocusGained
        lbl311.setText("");
    }//GEN-LAST:event_cmb397FocusGained

    private void TxtA399KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtA399KeyTyped
         if(TxtA399.getText().length()>=250)
            evt.consume();
    }//GEN-LAST:event_TxtA399KeyTyped

    private void cmb307FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb307FocusLost
        TextValidatorPurchase tv = new TextValidatorPurchase();
        tv.comboSelection(cmb307, lbl310);
    }//GEN-LAST:event_cmb307FocusLost

    private void TxtA399KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtA399KeyReleased
        lbl365.setText(250-TxtA399.getText().length()+" Characters Left");
    }//GEN-LAST:event_TxtA399KeyReleased

    private void btn304ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn304ActionPerformed
        String date="";

            try{
                DateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
                date = fmt.format(this.clndr306.getDate());
            }
            catch (Exception e){

            }
        
        if(lbl310.getText().equals("!")){
        
            JOptionPane.showMessageDialog(this,"One or more fields contain invalid data", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        else if(cmb397.getSelectedIndex()==-1||cmb307.getSelectedIndex()==-1||date.isEmpty()){
            TextValidatorPurchase tv = new TextValidatorPurchase();
            
            if(cmb397.getSelectedIndex()==-1){
                tv.comboSelection(cmb397, lbl311);
            }
            if(cmb307.getSelectedIndex()==-1){
                tv.comboSelection(cmb307, lbl310);
            }
            if(date.isEmpty()){
                lbl309.setText("!");
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
            dba.addReturnItems(txtF302.getText().toString(),datex,cmb307.getSelectedItem().toString(),TxtA399.getText().toString(),"EMP1002",cmb397.getSelectedItem().toString());
            
            DbAccessPurchase dba2=new DbAccessPurchase("purchase", "status", "Returned", "purchaseid", cmb397.getSelectedItem().toString());
            dba2.updateOneFeild();
            JOptionPane.showMessageDialog(this, "Return recorded successfuly");
            //Creating a new instance of purchaseorder to refresh
            ReturnItems ri =new ReturnItems();
            SetPanel sp = new SetPanel();
            sp.SetPanel(ri);
        }
    }//GEN-LAST:event_btn304ActionPerformed

    private void btn305ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn305ActionPerformed
            ReturnItems ri =new ReturnItems();
            SetPanel sp = new SetPanel();
            sp.SetPanel(ri);
    }//GEN-LAST:event_btn305ActionPerformed

    private void btn314ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn314ActionPerformed
        DbAccessPurchase dba = new DbAccessPurchase("returnitem");
        dba.viewReturns(tbl318, lblResultCount2);
        
        txtF312.setText("");
    }//GEN-LAST:event_btn314ActionPerformed

    private void txtF312KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF312KeyTyped
        if(txtF312.getText().length()>=7)
            evt.consume();
    }//GEN-LAST:event_txtF312KeyTyped

    private void clndr306FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clndr306FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_clndr306FocusLost

    private void txtF312KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtF312KeyReleased
        DbAccessPurchase dba = new DbAccessPurchase("returnitem", "returnId", txtF312.getText().toString());
        dba.viewReturnsSearch(tbl318, lblResultCount2);
    }//GEN-LAST:event_txtF312KeyReleased

    private void btn315ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn315ActionPerformed
        if(cmb302.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null,"Select a valid return id to genarate report","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            
                 HashMap param=new HashMap();
                 param.put("returnid",String.valueOf(cmb302.getSelectedItem()));
                 PurchaseManagementMain showme=new PurchaseManagementMain("src\\PurchaseManagementReports\\ReturnNotice.jasper",param);
                 showme.setVisible(true);
        }
    }//GEN-LAST:event_btn315ActionPerformed

    private void cmb307FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmb307FocusGained
        lbl310.setText("");
    }//GEN-LAST:event_cmb307FocusGained

    private void btn401ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn401ActionPerformed
        cmb307.setSelectedIndex(0);
        cmb397.setSelectedIndex(0);
        TxtA399.setText("Damaged due to shipping or handling problems.");
        clndr306.setDate(new Date());

    }//GEN-LAST:event_btn401ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtA399;
    private javax.swing.JButton btn304;
    private javax.swing.JButton btn305;
    private javax.swing.JButton btn314;
    private javax.swing.JButton btn315;
    private javax.swing.JButton btn401;
    private com.toedter.calendar.JDateChooser clndr306;
    private javax.swing.JComboBox<String> cmb302;
    private javax.swing.JComboBox<String> cmb307;
    private javax.swing.JComboBox<String> cmb397;
    private javax.swing.JPanel jpnl301;
    private javax.swing.JPanel jpnl303;
    private javax.swing.JPanel jpnl311;
    private javax.swing.JPanel jpnl315;
    private javax.swing.JTabbedPane jtb300;
    private javax.swing.JScrollPane jtbl308;
    private javax.swing.JLabel lbl309;
    private javax.swing.JLabel lbl310;
    private javax.swing.JLabel lbl311;
    private javax.swing.JLabel lbl365;
    private javax.swing.JLabel lblDescripiton;
    private javax.swing.JLabel lblReason;
    private javax.swing.JLabel lblResultCount;
    private javax.swing.JLabel lblResultCount2;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JLabel lblReturnID;
    private javax.swing.JLabel lblReturnID1;
    private javax.swing.JLabel lblSearchReturnID;
    private javax.swing.JLabel lblSearchReturnID1;
    private javax.swing.JScrollPane tbl307;
    private javax.swing.JScrollPane tbl316;
    private javax.swing.JTable tbl318;
    private javax.swing.JTable tbl331;
    private javax.swing.JTextField txtF302;
    private javax.swing.JTextField txtF312;
    // End of variables declaration//GEN-END:variables
}
