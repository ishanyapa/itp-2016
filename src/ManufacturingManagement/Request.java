/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManufacturingManagement;

import RootElement.MySqlConnect;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ishan
 */
public class Request extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null, rs1 = null;
    PreparedStatement pst = null;
    Statement st = null;
    String rawid;
    String reqid;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    String sdate = dateFormat.format(date);
    ComboKeyHandler ckh;

    /**
     * Creates new form Request
     */
    public Request() {

        initComponents();

        con = MySqlConnect.ConnectDB();

        requestedDate.setText(sdate);

        tableload();
        autogenerate();
        FillCombo(rawmaterialcombo, "itemName", "rawMaterial");
        ckh = new ComboKeyHandler(rawmaterialcombo);

        rawmaterialcombo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                ckh.keyTyped(e);
            }
        });
    }

    public void tableload() {
        try {
            String q1 = "SELECT rq.requestId as RequestID,rq.requestDate as AddedDate,r.rawMaterialId as RawMaterialID,r.itemName as Name ,rr.quantity as Quantity FROM rawmaterialrequest rr,request rq,rawmaterial r WHERE rq.requestId=rr.requestId and r.rawMaterialId=rr.rawMaterialId";
            pst = con.prepareStatement(q1);
            rs = pst.executeQuery();

            rawtable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }

    }

    public void autogenerate() {
        String id = null;
        String a;
        int b;

        try {

            String q = "SELECT requestId FROM request ORDER BY requestId";
            st = con.createStatement();
            rs = st.executeQuery(q);

            while (rs.next()) {
                id = rs.getString("requestId");
            }

            a = id.substring(0, 2);
            b = Integer.parseInt(id.substring(2, 5));
            b = b + 1;
            String i = a + String.valueOf(b);
            requestId.setText(i);
            requestId.setEditable(false);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        requestId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        requestedDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn805 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        quantity = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        rawmaterialcombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        rawtable = new javax.swing.JTable();
        btn801 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Request Details"));

        jLabel1.setText("Request ID");

        jLabel3.setText("Date");

        requestedDate.setEditable(false);
        requestedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestedDateActionPerformed(evt);
            }
        });

        jButton1.setText("Add Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn805.setText("Cancel Request");
        btn805.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn805ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(requestId, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(requestedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btn805)))
                .addGap(0, 285, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(requestId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(requestedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn805)
                    .addComponent(jButton1))
                .addGap(28, 28, 28))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Raw Material Details"));

        jLabel4.setText("Quantity");

        quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel2.setText("Raw Material");

        rawmaterialcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rawmaterialcomboActionPerformed(evt);
            }
        });
        rawmaterialcombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rawmaterialcomboKeyTyped(evt);
            }
        });

        rawtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Added Date", "RawMaterialID", "Name", "Quantity"
            }
        ));
        rawtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rawtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rawtable);

        btn801.setText("Add Raw Material");
        btn801.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn801ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Raw Material");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add New Request");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Generate Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rawmaterialcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn801)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(20, 20, 20)
                        .addComponent(jButton4)))
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rawmaterialcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn801)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requestedDateActionPerformed

    private void btn801ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn801ActionPerformed
        rawmaterialcombo.requestFocus();
        String request = requestId.getText();

        String rawcombo = String.valueOf(rawmaterialcombo.getSelectedItem());
        System.out.println(rawcombo);
        String date = requestedDate.getText();
        String spinner = quantity.getValue().toString();
        System.out.println(spinner);
        try {

            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            String xz = "SELECT requestId FROM request WHERE requestId='" + request + "'";
            System.out.println(request);
            rs1 = st.executeQuery(xz);

            String sql = "SELECT rawMaterialId FROM rawmaterial WHERE itemName='" + rawcombo + "' order by rawMaterialId";

            rs = st2.executeQuery(sql);
            while (rs.next()) {
                rawid = rs.getString("rawMaterialId");
            }
            System.out.println(rawid);

            String sql2 = "INSERT INTO  rawmaterialrequest(requestId,rawMaterialId,quantity) VALUES('" + request + "','" + rawid + "','" + spinner + "')";
            pst = con.prepareStatement(sql2);
            pst.execute();
            tableload();

            MessageDisplay.display("Record succesfully added");

            rawmaterialcombo.setSelectedIndex(-1);
            quantity.setValue(0);
        } catch (Exception e) {
            System.out.println(e);
            MessageDisplay.display("Unable to add record. Try Again");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btn801ActionPerformed

    private void rawmaterialcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rawmaterialcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rawmaterialcomboActionPerformed

    private void rawtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rawtableMouseClicked
        int row = rawtable.getSelectedRow();
        String r = String.valueOf(rawtable.getValueAt(row, 0));
        String rw = String.valueOf(rawtable.getValueAt(row, 1));
        String n = String.valueOf(rawtable.getValueAt(row, 2));
        String q = String.valueOf(rawtable.getValueAt(row, 3));
        String p = String.valueOf(rawtable.getValueAt(row, 4));
        requestId.setText(r);
        rawmaterialcombo.setSelectedItem(rawtable.getValueAt(row, 3));
        quantity.setValue(rawtable.getValueAt(row, 4));

// TODO add your handling code here:
    }//GEN-LAST:event_rawtableMouseClicked

    private void btn805ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn805ActionPerformed
        try {
            String request = requestId.getText();
            String sqlx = "DELETE FROM request where requestId='" + request + "' ";
            pst = con.prepareStatement(sqlx);
            pst.execute();
            tableload();
        } catch (Exception e) {
            System.out.println(e);

        }

// TODO add your handling code here:
    }//GEN-LAST:event_btn805ActionPerformed

    private void rawmaterialcomboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rawmaterialcomboKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_rawmaterialcomboKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String request = requestId.getText();

        String date = requestedDate.getText();

        try {

            Statement st = con.createStatement();

            String xz = "SELECT requestId FROM request WHERE requestId='" + request + "'";
            rs1 = st.executeQuery(xz);

            String sql5 = "INSERT INTO request(requestId,requestDate)VALUES('" + request + "','" + date + "')";
            pst = con.prepareStatement(sql5);
            pst.execute();
            MessageDisplay.display("Record succesfully added");
        } catch (Exception e) {
            MessageDisplay.display("Unable to add record. Try Again");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String rawcombo = rawmaterialcombo.getSelectedItem().toString();

            String sql = "SELECT rawMaterialId FROM rawmaterial WHERE itemName='" + rawcombo + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                rawid = rs.getString("rawMaterialId");
            }

            String sqlx = "DELETE FROM rawmaterialrequest where rawMaterialId='" + rawid + "' ";
            pst = con.prepareStatement(sqlx);
            pst.execute();
            tableload();
            MessageDisplay.display("Record succesfully removed");
            rawmaterialcombo.setSelectedIndex(-1);
            quantity.setValue(0);

        } catch (Exception e) {
            System.out.println(e);
            MessageDisplay.display("Record couldn't be removed");
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        autogenerate();
        rawmaterialcombo.setSelectedIndex(-1);
        quantity.setValue(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Connection con = MySqlConnect.ConnectDB();
            String report = "src\\ManufactureReports\\Request.jasper";

            JasperPrint jp = JasperFillManager.fillReport(report, null, con);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn801;
    private javax.swing.JButton btn805;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner quantity;
    private javax.swing.JComboBox<String> rawmaterialcombo;
    private javax.swing.JTable rawtable;
    private javax.swing.JTextField requestId;
    private javax.swing.JTextField requestedDate;
    // End of variables declaration//GEN-END:variables
}
