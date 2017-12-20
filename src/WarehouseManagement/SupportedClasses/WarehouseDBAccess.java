/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement.SupportedClasses;


import RootElement.DbConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ishan
 */
public class WarehouseDBAccess {
    
    public void AddRawMaterial(JTextField id,JTextField name,JTextField weight,JSpinner qty, JSpinner reorder){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("INSERT INTO rawMaterial VALUES (?,?,?,?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(id.getText()));
            pstmt.setString(2,String.valueOf(name.getText()));
            pstmt.setInt(3,Integer.parseInt(String.valueOf(qty.getValue())));
            pstmt.setDouble(4, Double.parseDouble(weight.getText()));
            pstmt.setInt(5,Integer.parseInt(String.valueOf(reorder.getValue())));
            
            pstmt.executeUpdate();
            
            id.setText(GetIncrementedId("rawMaterialId"," rawMaterial", 2));
            
            
            dbcon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            
        }

    }
    
    public void RetrieveRawMaterial(JComboBox name,String selectedItem ,JTextField id, JTextField weight, JSpinner quantity, JSpinner reorder){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        try{
            Statement stmt; 
            ResultSet rslt;
            
            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT rawMaterialId, quantity, unitWeight, reorderPoint FROM rawMaterial WHERE itemName = '"+selectedItem+"'");
            
            while(rslt.next()){
                String rid = rslt.getString("rawMaterialId");
                id.setText(rid);
                
                String qty = rslt.getString("quantity");
                quantity.setValue(Integer.parseInt(qty));
                String uwei = rslt.getString("unitWeight");
                weight.setText(uwei);
                String rorder = rslt.getString("reorderPoint");
                reorder.setValue(Integer.parseInt(rorder));
                                        
            }
            
            dbcon.con.close();
            stmt.close();
        }
        catch(Exception e){
            
        }
    }
    
    public void UpdateRawMaterial(JTextField id,String name,JTextField weight,JSpinner qty, JSpinner reorder){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("UPDATE rawMaterial SET itemName = ?,quantity = ?,unitWeight = ?,reorderPoint = ? WHERE rawMaterialId = ?");
            pstmt=dbcon.con.prepareStatement(query);
            
            System.out.println(name);
            
            pstmt.setString(1,name);
            pstmt.setInt(2,Integer.parseInt(String.valueOf(qty.getValue())));
            pstmt.setDouble(3, Double.parseDouble(weight.getText()));
            pstmt.setInt(4,Integer.parseInt(String.valueOf(reorder.getValue())));
            pstmt.setString(5,String.valueOf(id.getText()));
            
            pstmt.executeUpdate();
            

            
            
            dbcon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            
        }
        
    }
    
    
    public void AddFinishedProduct(JTextField id, JTextField name, String category, JTextField std, JTextField ins, JTextField cond, JSpinner len, JTextField weight, JTextField ncsa, JTextField nod, JSpinner qty){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String query;
        PreparedStatement pstmt;
       
        try {
            query = ("INSERT INTO finishedProducts VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1,String.valueOf(id.getText()));
            pstmt.setString(2,String.valueOf(name.getText()));
            pstmt.setString(3,category);
            pstmt.setString(4,String.valueOf(std.getText()));
            pstmt.setString(5,String.valueOf(ins.getText()));
            pstmt.setString(6,String.valueOf(cond.getText()));
            pstmt.setInt(7,Integer.parseInt(String.valueOf(len.getValue())));
            pstmt.setDouble(9,Double.parseDouble(String.valueOf(weight.getText())));
            pstmt.setDouble(10,Double.parseDouble(String.valueOf(nod.getText())));
            pstmt.setDouble(11,Double.parseDouble(String.valueOf(ncsa.getText())));
            pstmt.setInt(8,Integer.parseInt(String.valueOf(qty.getValue())));
            pstmt.setDouble(12, 0);
            pstmt.setDouble(13, 0);
            
            pstmt.executeUpdate();
            id.setText(GetIncrementedId("productId","finishedProducts", 3));
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void RetrieveFinishedProduct(JTextField id, String name,JComboBox category, JTextField std, JTextField ins, JTextField cond, JSpinner len, JTextField weight, JTextField ncsa, JTextField nod, JSpinner qty){

        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        try{
            Statement stmt;
            ResultSet rslt;

            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT productId,category,standard,insulation,conductor,unitLength,quantity,weight,nominalOD,nominalCSA FROM finishedProducts WHERE name= '"+name+"'");

            while(rslt.next()){
                id.setText(String.valueOf(rslt.getString("productId")));
                category.setSelectedItem(rslt.getString("category"));
                std.setText(rslt.getString("standard"));
                ins.setText(rslt.getString("insulation"));
                cond.setText(rslt.getString("conductor"));
                len.setValue(Integer.parseInt(rslt.getString("unitLength")));
                qty.setValue(Integer.parseInt(rslt.getString("quantity")));
                weight.setText(String.valueOf(rslt.getDouble("weight")));
                nod.setText(String.valueOf(rslt.getDouble("nominalOD")));
                ncsa.setText(String.valueOf(rslt.getDouble("nominalCSA")));
            }
            
            dbcon.con.close();
            stmt.close();
        }
        catch(Exception e){
            

        }


    }
    
    public void UpdateFinishedProducts(String id, String name,String category, JTextField std, JTextField ins, JTextField cond, JSpinner len, JTextField weight, JTextField ncsa, JTextField nod, JSpinner qty){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String query;
        PreparedStatement pstmt;
        try {
            
            query = ("UPDATE finishedProducts SET category=?,standard=?,insulation=?,conductor=?,unitLength=?,quantity=?,weight=?,nominalOD=?,nominalCSA=? WHERE productId = '"+id+"'");
            pstmt=dbcon.con.prepareStatement(query);
            

            pstmt.setString(1,category);
            pstmt.setString(2,String.valueOf(std.getText()));
            pstmt.setString(3,String.valueOf(ins.getText()));
            pstmt.setString(4,String.valueOf(cond.getText()));
            pstmt.setInt(5,Integer.parseInt(String.valueOf(len.getValue())));
            pstmt.setDouble(7,Double.parseDouble(String.valueOf(weight.getText())));
            pstmt.setDouble(8,Double.parseDouble(String.valueOf(nod.getText())));
            pstmt.setDouble(9,Double.parseDouble(String.valueOf(ncsa.getText())));
            pstmt.setInt(6,Integer.parseInt(String.valueOf(qty.getValue())));

            
            pstmt.executeUpdate();
            
            dbcon.con.close();
            pstmt.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void CheckReorderLevel(JTable reorder){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        Statement stmt;
        ResultSet rslt;
        try {
            stmt=dbcon.con.createStatement();
            rslt=stmt.executeQuery("SELECT rawMaterialId as 'Raw Material ID', itemName as 'Item Name', quantity as 'Quantity', reorderPoint as 'Reorder Point' FROM rawMaterial WHERE quantity<=reorderPoint");
            reorder.setModel(DbUtils.resultSetToTableModel(rslt));
            
            dbcon.con.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void SendPurchaseRequest(JTable tbl){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt;
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        
        String query =("INSERT INTO purchaseRequest (requestId,requestDate,quantity,rawMaterialId) VALUES (?,?,?,?)");
            try {
                pstmt = dbcon.con.prepareStatement(query);
                for(int i=0;i<tbl.getRowCount();i++){
                   pstmt.setString(1, GetIncrementedId("requestId","purchaserequest",2));
                   pstmt.setString(2,dateFormat.format(date));
                   pstmt.setString(3,String.valueOf(model.getValueAt(i, 1)));
                   pstmt.setString(4,String.valueOf(model.getValueAt(i, 0)));
                   pstmt.executeUpdate();
                   
                    
                }
                for(int j=0;j<=tbl.getRowCount();j++){
                    model.removeRow(0);
                }
                dbcon.con.close();
                pstmt.close();
                
        } catch (Exception e) {
                System.out.println(e.getMessage());   
        }
        
        
    }
    
    public void IssueRawMaterials(JTable tbl){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query = ("UPDATE request SET status='Assigned' WHERE requestId=?");
        String query2 = ("SELECT quantity FROM rawMaterial WHERE rawMaterialId=?");
        String query3 = ("UPDATE rawMaterial SET quantity=? WHERE rawMaterialId=?");
        int qty=0;
        
        PreparedStatement pstmt;
        PreparedStatement pstmt2;
        PreparedStatement pstmt3;
        
        ResultSet rslt;
        
        try {
            pstmt = dbcon.con.prepareStatement(query);
            
            for(int i=0; i<tbl.getRowCount();i++){
                pstmt.setString(1,String.valueOf(tbl.getValueAt(i,0)));
                pstmt.executeUpdate();
            }
            
        } catch (Exception e) {
        }
        
        try {
            pstmt2 = dbcon.con.prepareStatement(query2);
            pstmt3 = dbcon.con.prepareStatement(query3);
            
            
            for(int j=0; j<tbl.getRowCount(); j++){
                pstmt2.setString(1,String.valueOf(tbl.getValueAt(j, 1)));
                rslt = pstmt2.executeQuery();
                
                
                while(rslt.next()){
                    qty=rslt.getInt("quantity");
                }
                
                pstmt3.setInt(1,qty-Integer.parseInt(String.valueOf(tbl.getValueAt(j, 2))));
                pstmt3.setString(2,String.valueOf(tbl.getValueAt(j, 1)));
                
                pstmt3.executeUpdate();
            }
        } catch (Exception e) {
        }
        
    }
    
    public void AssignProducts(JTable tbl,String invoiceNo){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt1;
        PreparedStatement pstmt2;
        PreparedStatement pstmt3;
        ResultSet rslt;
        int qty=0;
        
        String query1=("SELECT quantity FROM finishedProducts WHERE productId=?");
        String query2 =("UPDATE finishedProducts SET quantity=? WHERE productId=?");
        String query3 =("UPDATE invoice SET goodIssueStatus='Issued' WHERE invoiceNo='"+invoiceNo+"'");
        try {
            pstmt1 = dbcon.con.prepareStatement(query1);
            pstmt2 = dbcon.con.prepareStatement(query2);
            pstmt3 = dbcon.con.prepareStatement(query3);
            for(int i=0;i<tbl.getRowCount();i++){
                pstmt1.setString(1,String.valueOf(tbl.getValueAt(i, 0)));
                rslt = pstmt1.executeQuery();
                
                while(rslt.next()){
                    qty=rslt.getInt("quantity");
                }
                pstmt2.setInt(1,qty-Integer.parseInt(String.valueOf(tbl.getValueAt(i, 1))));
                pstmt2.setString(2, String.valueOf(tbl.getValueAt(i, 0)));
                pstmt2.executeUpdate();
            }
            pstmt3.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
    
    public void IssueGRN(JTable tbl){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        PreparedStatement pstmt1;
        PreparedStatement pstmt2;
        PreparedStatement pstmt3;
        PreparedStatement pstmt4;
        ResultSet rslt;
        int qty=0;
        String query1=("SELECT quantity from rawMaterial WHERE rawMaterialId=?");
        String query2=("UPDATE rawMaterial SET quantity=? WHERE rawMaterialId=?");
        String query3=("INSERT INTO goodRecieveNotice (receivedDate,productId,productName,quantity,requestId) VALUES(?,?,?,?,?)");
        String query4=("UPDATE purchaserequest SET status='Accepted' WHERE requestId=?");
        try {
            pstmt1 = dbcon.con.prepareStatement(query1);
            pstmt2 = dbcon.con.prepareStatement(query2);
            pstmt3 = dbcon.con.prepareStatement(query3);
            pstmt4 = dbcon.con.prepareStatement(query4);
            for(int i=0; i<tbl.getRowCount(); i++){
                pstmt1.setString(1,String.valueOf(tbl.getValueAt(i, 2)));
                rslt = pstmt1.executeQuery();
                
                while(rslt.next()){
                    qty = rslt.getInt("quantity");
                }
                
                pstmt2.setInt(1,qty+Integer.parseInt(String.valueOf(tbl.getValueAt(i, 4))));
                pstmt2.setString(2,String.valueOf(tbl.getValueAt(i, 2)));
                
                pstmt2.executeUpdate();
                
                pstmt3.setString(1,String.valueOf(tbl.getValueAt(i, 1)));
                pstmt3.setString(2,String.valueOf(tbl.getValueAt(i, 2)));
                pstmt3.setString(3,String.valueOf(tbl.getValueAt(i, 3)));
                pstmt3.setInt(4,Integer.parseInt(String.valueOf(tbl.getValueAt(i, 4))));
                pstmt3.setString(5,String.valueOf(tbl.getValueAt(i, 0)) );
                
                pstmt4.setString(1,String.valueOf(tbl.getValueAt(i, 0)));
                pstmt4.executeUpdate();
                pstmt3.executeUpdate();
            }
            dbcon.con.close();
            pstmt1.close();
            pstmt2.close();
            pstmt3.close();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void UpdateFinishedProductsQuantity(String pid, String mid, int qty ){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt;
        PreparedStatement pstmt2;
        try {
            String query=("UPDATE finishedProducts SET quantity=? WHERE productId=?");
            String query2 =("UPDATE manufacturedProducts SET status='Assigned' WHERE manufactureId=?");
            pstmt2 = dbcon.con.prepareStatement(query2);
            pstmt = dbcon.con.prepareStatement(query);
            pstmt.setInt(1, qty);
            pstmt.setString(2, pid);
            pstmt2.setString(1,mid);
            System.out.println(mid);
            pstmt2.executeUpdate();
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void ViewManufacturedProducts(JTable tbl,String pid){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt;
        ResultSet rslt;
        try {
            String query = ("SELECT manufactureId as 'Manufacture ID',manufactureDate as 'Manufacture Date', quantity as 'Quantity' FROM manufacturedproducts WHERE productId=? AND status='Unassigned'");
            pstmt = dbcon.con.prepareStatement(query);
            pstmt.setString(1, pid);
            rslt = pstmt.executeQuery();
            tbl.setModel(DbUtils.resultSetToTableModel(rslt));
        } catch (Exception e) {
        }
        
    }
    
    public String ReturnValue(String query,String retVal){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt;
        ResultSet rslt;
        String ret="";
        try {
            
            pstmt = dbcon.con.prepareStatement(query);
            rslt = pstmt.executeQuery();
            
            while(rslt.next()){
                ret=rslt.getString(retVal);
            }
        dbcon.con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return ret;
    }
    public void DeleteRow(String tableName, String primaryKey, String value){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            
            Statement stmt;

            stmt = dbcon.con.createStatement();
            stmt.executeUpdate("DELETE FROM "+tableName+" WHERE "+primaryKey+"='"+value+"'");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void ViewAll(JTable jt, String tableName){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            
            Statement stmt;
            ResultSet rslt;
            
            stmt = dbcon.con.createStatement();
            
            rslt = stmt.executeQuery("SELECT * FROM "+tableName);
            jt.setModel(DbUtils.resultSetToTableModel(rslt));
            
            dbcon.con.close();
            stmt.close();
        } catch (Exception e) {
        }
        
    }
    
    public void SearchByKeyWord(JTable jt, String tableName, String keyword, String fname1, String fname2){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            
            Statement stmt;
            ResultSet rslt;
            
            stmt = dbcon.con.createStatement();
            if("".equals(fname2))
                rslt = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE "+fname1+"= '"+keyword+"'");
            else
                rslt = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE "+fname1+"= '"+keyword+"' OR "+fname2+" LIKE '"+keyword+"%'");
            
            jt.setModel(DbUtils.resultSetToTableModel(rslt));
            dbcon.con.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void SearchByKeyWord(JTable jt, String query){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            
            Statement stmt;
            ResultSet rslt;
            
            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery(query);
            
            
            jt.setModel(DbUtils.resultSetToTableModel(rslt));
            dbcon.con.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String GetIncrementedId(String fieldName, String tableName, int prefixSize){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String id = "";
        String incrId="";
        try{
            Statement stmnt;
            ResultSet rslt;
            stmnt=dbcon.con.createStatement();
            rslt=stmnt.executeQuery("Select "+fieldName+" from "+tableName+" order by "+fieldName);
            
            while(rslt.next()){
                id = rslt.getString(fieldName);
            }
            
            IdIncrement idIncr = new IdIncrement();
            incrId = idIncr.Increment(id,prefixSize);
            stmnt.close();
            dbcon.con.close();
        }
        catch(Exception e){
            
        }
        return incrId;
        
    }
    
    
    public void FillCombo(JComboBox<String> cmb, String fieldName, String tableName){
        try{
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            Statement stmt;
            ResultSet rslt;
            
            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT "+fieldName+" FROM "+tableName+" ");
            
            while(rslt.next()){
                String fname = rslt.getString(fieldName);
                cmb.addItem(fname);
            }
            
            cmb.setSelectedIndex(-1);
            dbcon.con.close();
            stmt.close();
            
        }
        catch(Exception e){
            
        }
    }
    
}
