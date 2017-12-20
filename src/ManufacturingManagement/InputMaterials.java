/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManufacturingManagement;

import RootElement.MySqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ishan
 */
public class InputMaterials extends javax.swing.JPanel {

    /**
     * Creates new form InputMaterials
     *
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();

    String itemname;
    String qty;
    String status;
    String xx;
    String id;
    String x;
    String q;
    int quan;
    ComboKeyHandler ckh2;

    public InputMaterials() {
        initComponents();
        con = MySqlConnect.ConnectDB();
        tableload();
        FillCombo(rcombo, "itemName", "rawMaterial");

        ckh2 = new ComboKeyHandler(rcombo);

        rcombo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                ckh2.keyTyped(e);
            }
        });

    }

    public void tableload() {
        try {
            String q1 = "SELECT im.requestId as RequestID,r.itemName as RawMaterial,im.quantity as Quantity,im.defectiveQuantity as DefectiveQuanitiy FROM inputmaterial im,rawmaterial r WHERE im.rawMaterialId=r.rawMaterialId";
            pst = con.prepareStatement(q1);
            rs = pst.executeQuery();

            deftable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }

    }

    public void FillCombo(JComboBox cmb, String fieldName, String tableName) {
        try {
            Connection con;
            con = MySqlConnect.ConnectDB();
            Statement stmt;
            ResultSet rslt;

            stmt = con.createStatement();
            rslt = stmt.executeQuery("SELECT " + fieldName + " FROM " + tableName + " ");

            while (rslt.next()) {
                String fname = rslt.getString(fieldName);
                cmb.addItem(fname);
            }

            cmb.setSelectedIndex(-1);
            con.close();
            stmt.close();

        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        req = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rtext = new javax.swing.JTextField();
        rcombo = new javax.swing.JComboBox<>();
        count = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        deftable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Request ID");

        req.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reqKeyReleased(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request ID", "Item Name", "Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(table);

        jButton2.setText("Accept Raw Materials");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(req, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(594, 594, 594)
                .addComponent(jButton2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(req, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addComponent(jButton2))
        );

        jTabbedPane1.addTab("Accept Raw Materials", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Request ID:");

        jLabel6.setText("Raw Material:");

        jLabel7.setText("Defective Item Count:");

        rcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        deftable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request ID", "Raw Material", "Quantity", "Defective Quantity"
            }
        ));
        deftable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deftableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(deftable);

        jButton3.setText("Generate Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addComponent(jButton6))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rtext)
                                    .addComponent(rcombo, 0, 116, Short.MAX_VALUE)
                                    .addComponent(count)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))))
                .addGap(58, 58, 58)
                .addComponent(jButton3)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Update Defective Items", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String searchreq = req.getText();
        try {
            String q2 = "select rawMaterialId FROM rawmaterial WHERE itemName='" + itemname + "'";
            pst = con.prepareStatement(q2);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("rawMaterialId");

            }
        } catch (Exception e) {
        }
        try {
            String q2 = "select rq.requestId, r.itemName ,rr.quantity, rq.status FROM rawmaterialrequest rr,request rq,rawmaterial r WHERE rq.requestId=rr.requestId and r.rawMaterialId=rr.rawMaterialId and rq.requestId='" + searchreq + "';";
            pst = con.prepareStatement(q2);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {

                itemname = rs.getString(" r.itemName");
                qty = rs.getString("rr.quantity");
                status = rs.getString("rq.status");

            }

        } catch (Exception e) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            String sreq = req.getText();
            for (int r = 0; r < table.getRowCount(); r++) {
                String sdate = dateFormat.format(date);
                int quant = Integer.parseInt(String.valueOf(table.getValueAt(r, 2)));
                String rawname = String.valueOf(table.getValueAt(r, 1));
                String status = String.valueOf(table.getValueAt(r, 3));
                System.out.println(status);

                Statement st = con.createStatement();

                if (status.equalsIgnoreCase("Assigned")) {
                    String sql = "SELECT rawMaterialId FROM rawmaterial WHERE itemName='" + rawname + "'";
                    rs = st.executeQuery(sql);
                    while (rs.next()) {
                        xx = rs.getString("rawMaterialId");
                    }
                    String sql7 = "INSERT INTO inputmaterial(addedDate, quantity, rawMaterialId,requestId)VALUES('" + sdate + "','" + quant + "','" + xx + "','" + sreq + "')";
                    pst = con.prepareStatement(sql7);
                    pst.execute();
                    MessageDisplay.display("Records succesfully added");
                } else {
                    MessageDisplay.display("Cannot add Unassigned Materials");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            MessageDisplay.display("Record not added");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String rid = rtext.getText();
        String combo = rcombo.getSelectedItem().toString();
        //String cont=count.getText();
        int cont = Integer.parseInt(count.getText());
        try {
            Statement st = con.createStatement();

            String sql = "SELECT rawMaterialId FROM rawmaterial WHERE itemName='" + combo + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                x = rs.getString("rawMaterialId");

            }

            String sq = "SELECT quantity FROM inputmaterial WHERE requestId='" + rid + "' and rawMaterialId= '" + x + "'";
            rs1 = st.executeQuery(sq);
            while (rs1.next()) {
                q = rs1.getString("quantity");
                quan = Integer.parseInt(q);

            }

            if (cont <= quan) {

                String s = "UPDATE inputmaterial SET defectiveQuantity='" + count.getText() + "' WHERE requestId='" + rtext.getText() + "' and rawMaterialId='" + x + "'";
                pst = con.prepareStatement(s);
                pst.execute();
                tableload();
                MessageDisplay.display("Record succesfully added");
                rtext.setText("");
                count.setText("");
                rcombo.setSelectedIndex(0);
            } else {
                MessageDisplay.display("Record cannot be added, Defective quantity cannot exceed input quantity");
            }
        } catch (Exception e) {
            System.out.println(e);
            MessageDisplay.display("Record not added");
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        rtext.setText("");
        count.setText("");
        rcombo.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void reqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reqKeyReleased
        // TODO add your handling code here:
        String searchreq = req.getText();
        try {
            String q2 = "select rawMaterialId FROM rawmaterial WHERE itemName='" + itemname + "'";
            pst = con.prepareStatement(q2);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("rawMaterialId");

            }
        } catch (Exception e) {
        }
        try {
            String q2 = "select rq.requestId, r.itemName ,rr.quantity, rq.status FROM rawmaterialrequest rr,request rq,rawmaterial r WHERE rq.requestId=rr.requestId and r.rawMaterialId=rr.rawMaterialId and rq.requestId='" + searchreq + "';";
            pst = con.prepareStatement(q2);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {

                itemname = rs.getString(" r.itemName");
                qty = rs.getString("rr.quantity");
                status = rs.getString("rq.status");

            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_reqKeyReleased

    private void deftableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deftableMouseClicked
        int row = deftable.getSelectedRow();
        String r = String.valueOf(deftable.getValueAt(row, 0));
        rtext.setText(r);
        rcombo.setSelectedItem(deftable.getValueAt(row, 1));

    }//GEN-LAST:event_deftableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try{
         
        Connection con= MySqlConnect.ConnectDB();
        
        String report="src\\ManufactureReports\\DefectiveQuantity.jasper";

      JasperPrint jp=JasperFillManager.fillReport(report, null,con);
       JasperViewer.viewReport(jp,false);

   
       }
       catch(Exception e){
           System.out.println(e);}
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField count;
    private javax.swing.JTable deftable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> rcombo;
    private javax.swing.JTextField req;
    private javax.swing.JTextField rtext;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
