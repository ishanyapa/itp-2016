/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement;

import RootElement.DbConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Ishan
 */
public class UserManagementDBAccess {
    
    
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
    
    public void DeleteRow(String tableName, String primaryKey, String value){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            
            Statement stmt;

            stmt = dbcon.con.createStatement();
            stmt.executeUpdate("DELETE FROM "+tableName+" WHERE "+primaryKey+"='"+value+"'");
            dbcon.con.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean SearchByKeyWord(String tableName, String keyword, String fname1){
        try {
            DbConnect uniqueDbcon = new DbConnect();
            boolean valid=true;
            uniqueDbcon.setConnection();
            String ret="";
            Statement stmt;
            ResultSet rslt=null;
            
            stmt = uniqueDbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT * FROM "+tableName+" WHERE "+fname1+"= '"+keyword+"'");
            
            
            
            while(rslt.next()){
               valid = false;
            }
            System.out.println(ret);
            uniqueDbcon.con.close();
            stmt.close();
            
            return valid;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void AddUser(String username, String password, String accessLevel, String employeeName){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rslt;
        try {
            pstmt = dbcon.con.prepareStatement("INSERT INTO userAccount VALUES(?,?,?,?)");
            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT employeeId from employee where name='"+employeeName+"'");
            
            pstmt.setString(1,username);
            pstmt.setString(2, password);
            pstmt.setString(3, accessLevel);
            while(rslt.next()){
                pstmt.setString(4, rslt.getString("employeeId"));
            }
            
            pstmt.executeUpdate();
            dbcon.con.close();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void UpdateUser(String employeeId,String username,String password, String accessLevel){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        PreparedStatement pstmt;
        
        try {
            pstmt = dbcon.con.prepareStatement("UPDATE userAccount SET username='"+username+"', password='"+password+"', accessLevel='"+accessLevel+"' where employeeId='"+employeeId+"'");
            pstmt.executeUpdate();
            dbcon.con.close();
            pstmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
