/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement;

import WarehouseManagement.SupportedClasses.SetPanel;
import WarehouseManagement.SupportedClasses.WarehouseDBAccess;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Ishan
 */
public class IssueFinishedProducts extends javax.swing.JPanel {
    WarehouseDBAccess wdba = new WarehouseDBAccess();
    /**
     * Creates new form AssignFinishedProducts
     */
    public IssueFinishedProducts() {
        initComponents();
        btngrp270Order.add(rbtn272L);
        btngrp270Order.add(rbtn273S);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrp270Order = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl276Products = new javax.swing.JTable();
        txtF274Inv = new javax.swing.JTextField();
        btn275Get = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbtn272L = new javax.swing.JRadioButton();
        rbtn273S = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl280Products = new javax.swing.JTable();
        btn78Load = new javax.swing.JButton();
        btn279Assign = new javax.swing.JButton();
        btn281Cancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("View Invoice Details"));

        tbl276Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice No", "Order ID", "Product ID", "Product Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl276Products);

        btn275Get.setText("Get Details");
        btn275Get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn275GetActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoice Number");

        rbtn272L.setBackground(new java.awt.Color(255, 255, 255));
        rbtn272L.setText("Large Scale");

        rbtn273S.setBackground(new java.awt.Color(255, 255, 255));
        rbtn273S.setText("Small Scale");

        jLabel2.setText("Order Type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbtn272L)
                                .addGap(18, 18, 18)
                                .addComponent(rbtn273S))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtF274Inv, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn275Get)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn272L)
                    .addComponent(rbtn273S)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtF274Inv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn275Get)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl280Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl280Products);

        btn78Load.setText("Load");
        btn78Load.setEnabled(false);
        btn78Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn78LoadActionPerformed(evt);
            }
        });

        btn279Assign.setText("Assign");
        btn279Assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn279AssignActionPerformed(evt);
            }
        });

        btn281Cancel.setText("Cancel");
        btn281Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn281CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btn78Load, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btn279Assign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn281Cancel)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn78Load)
                        .addComponent(btn279Assign)
                        .addComponent(btn281Cancel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(266, 266, 266))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn275GetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn275GetActionPerformed
        if(rbtn272L.isSelected() && !txtF274Inv.getText().equals("")){
            TableColumnModel tcm = tbl276Products.getColumnModel();
            String status = "Not Issued";
            String query = "SELECT invoiceNo,orderId,productId,name,quantity FROM viewLargeOrder WHERE invoiceNo='"+txtF274Inv.getText()+"' and goodIssueStatus = '"+status+"' order by invoiceNo";
            wdba.SearchByKeyWord(tbl276Products,query);
            tcm.getColumn(0).setHeaderValue("Invoice No");
            tcm.getColumn(1).setHeaderValue("Order ID");
            tcm.getColumn(2).setHeaderValue("Product ID");
            tcm.getColumn(3).setHeaderValue("Product Name");
            tcm.getColumn(4).setHeaderValue("Quantity");
            btn78Load.setEnabled(true);
            
        }
        else if(rbtn273S.isSelected() && !txtF274Inv.getText().equals("")){
            String status = "Not Issued";
            String query = "SELECT invoiceNo,orderId,productId,name,quantity FROM viewSmallOrder WHERE invoiceNo='"+txtF274Inv.getText()+"' and goodIssueStatus = '"+status+"' order by invoiceNo";
            TableColumnModel tcm = tbl276Products.getColumnModel();
            wdba.SearchByKeyWord(tbl276Products,query);
            tcm.getColumn(0).setHeaderValue("Invoice No");
            tcm.getColumn(1).setHeaderValue("Order ID");
            tcm.getColumn(2).setHeaderValue("Product ID");
            tcm.getColumn(3).setHeaderValue("Product Name");
            tcm.getColumn(4).setHeaderValue("Quantity");
            btn78Load.setEnabled(true);
        } 
        DefaultTableModel model = (DefaultTableModel) tbl280Products.getModel();
        if(model.getRowCount()>0){
            for(int j=model.getRowCount()-1;j>=0;j--){
               model.removeRow(j);
            }
        }
    }//GEN-LAST:event_btn275GetActionPerformed

    private void btn78LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn78LoadActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbl280Products.getModel();
       
        if(model.getRowCount()>0){
            for(int j=model.getRowCount()-1;j>=0;j--){
               model.removeRow(j);
            }
        }
        
        for(int i=0;i<tbl276Products.getRowCount();i++){
            
           Object obj[] ={tbl276Products.getValueAt(i, 2),tbl276Products.getValueAt(i, 4)};
           model.addRow(obj);
        }
    }//GEN-LAST:event_btn78LoadActionPerformed

    private void btn279AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn279AssignActionPerformed
       if(tbl280Products.getRowCount()>0){
           int option=JOptionPane.showConfirmDialog(this,"Do you wish to proceed ?");
           if(option==JOptionPane.YES_OPTION){
               wdba.AssignProducts(tbl280Products,String.valueOf(tbl276Products.getValueAt(0,0)));
               IssueFinishedProducts obj = new IssueFinishedProducts();
               SetPanel sp = new SetPanel();
               sp.SetPanel(obj);
           }   
           else if(option==JOptionPane.CANCEL_OPTION){
                IssueFinishedProducts obj = new IssueFinishedProducts();
                SetPanel sp = new SetPanel();
                sp.SetPanel(obj);
           }
       }
       else
           JOptionPane.showMessageDialog(this,"Load data before assigning","Warning ",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btn279AssignActionPerformed

    private void btn281CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn281CancelActionPerformed
       IssueFinishedProducts obj = new IssueFinishedProducts();
       SetPanel sp = new SetPanel();
       sp.SetPanel(obj);
    }//GEN-LAST:event_btn281CancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn275Get;
    private javax.swing.JButton btn279Assign;
    private javax.swing.JButton btn281Cancel;
    private javax.swing.JButton btn78Load;
    private javax.swing.ButtonGroup btngrp270Order;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtn272L;
    private javax.swing.JRadioButton rbtn273S;
    private javax.swing.JTable tbl276Products;
    private javax.swing.JTable tbl280Products;
    private javax.swing.JTextField txtF274Inv;
    // End of variables declaration//GEN-END:variables
}
