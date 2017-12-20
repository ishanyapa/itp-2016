/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManagement.SupportedClasses;

import RootElement.DbConnect;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.StyleConstants.Size;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author ashanginige
 */
public class HRManagementDBAccess {
    
    //Add Employee Details
    public void AddEmpDetails(JTextField id, JTextField name ,String dob, String jobName, JTextField nic, JRadioButton male, JRadioButton female, JRadioButton married, JRadioButton unmarried, JTextField add1, JTextField add2, JTextField res, JTextField mob, JTextField image_path){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
         
        
        try{
            query=("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(id.getText()));
            pstmt.setString(2, String.valueOf(name.getText()));
            //dob needed 3
            
            pstmt.setString(3, dob);
            
            pstmt.setString(4, String.valueOf(nic.getText()));
            
            if(male.isSelected()){
                pstmt.setString(5, String.valueOf(male.getText()));
            }
            else if(female.isSelected()){
                pstmt.setString(5, String.valueOf(female.getText()));
            }
            
            if(married.isSelected()){
                pstmt.setString(6, String.valueOf(married.getText()));
            }
            else if(unmarried.isSelected()){
                pstmt.setString(6, String.valueOf(unmarried.getText()));
            }
     
            pstmt.setString(7, String.valueOf(add1.getText()));
            pstmt.setString(8, String.valueOf(add2.getText()));
            
            pstmt.setString(9, String.valueOf(res.getText()));
            pstmt.setString(10, String.valueOf(mob.getText()));
            
            //Image file 
               int len;
               File file=new File(image_path.getText());
               FileInputStream fis=new FileInputStream(file);
               len = (int)file.length();
               
               pstmt.setBinaryStream(11,fis,len);
               
            pstmt.setString(12, jobName);
            
            pstmt.executeUpdate();
            
            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Update Employee Details Method 1 - if there is a Image path!
    public void UpdateEmpDetailsMethod1(JTextField id, JTextField name, String dob , String jobID, JTextField nic, JRadioButton male, JRadioButton female, JRadioButton married, JRadioButton unmarried, JTextField add1, JTextField add2, JTextField res, JTextField mob, JTextField image_path, String source_id){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
  
        try{
            query=("UPDATE employee SET employeeId=?, name=?, dateOfBirth=?, nic=?, gender=? ,civilStatus=?, address1=?, address2=?, telephoneRes=?, telephoneMob=?, image=?, jobId=?  WHERE employeeId= '"+source_id+"'");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(id.getText()));
            pstmt.setString(2, String.valueOf(name.getText()));
            
            pstmt.setString(3, dob);
            
            pstmt.setString(4, String.valueOf(nic.getText()));
            
            if(male.isSelected()){
                pstmt.setString(5, String.valueOf(male.getText()));
            }
            else if(female.isSelected()){
                pstmt.setString(5, String.valueOf(female.getText()));
            }
            
            if(married.isSelected()){
                pstmt.setString(6, String.valueOf(married.getText()));
                System.out.println(married.getText());
            }
            else if(unmarried.isSelected()){
                pstmt.setString(6, String.valueOf(unmarried.getText()));
            }
     
            pstmt.setString(7, String.valueOf(add1.getText()));
            pstmt.setString(8, String.valueOf(add2.getText()));
            
            pstmt.setString(9, String.valueOf(res.getText()));
            pstmt.setString(10, String.valueOf(mob.getText()));
            
            //Image file 
               int len;
               File file=new File(image_path.getText());
               FileInputStream fis=new FileInputStream(file);
               len = (int)file.length();
               
               pstmt.setBinaryStream(11,fis,len);
            
            pstmt.setString(12, String.valueOf(jobID));

            pstmt.executeUpdate();

            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //Update Employee Details Method 2 - if there is no Image path!
    public void UpdateEmpDetailsMethod2(JTextField id, JTextField name, String dob , String jobID, JTextField nic, JRadioButton male, JRadioButton female, JRadioButton married, JRadioButton unmarried, JTextField add1, JTextField add2, JTextField res, JTextField mob, String source_id){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        
        
        try{
            query=("UPDATE employee SET employeeId=?, name=?, dateOfBirth=?, nic=?, gender=? ,civilStatus=?, address1=?, address2=?, telephoneRes=?, telephoneMob=?, jobId=?  WHERE employeeId= '"+source_id+"' ");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(id.getText()));
            pstmt.setString(2, String.valueOf(name.getText()));
            
            pstmt.setString(3, dob);
            
            pstmt.setString(4, String.valueOf(nic.getText()));
            
            if(male.isSelected()){
                pstmt.setString(5, String.valueOf(male.getText()));
            }
            else if(female.isSelected()){
                pstmt.setString(5, String.valueOf(female.getText()));
            }
            
            if(married.isSelected()){
                pstmt.setString(6, String.valueOf(married.getText()));
                System.out.println(married.getText());
            }
            else if(unmarried.isSelected()){
                pstmt.setString(6, String.valueOf(unmarried.getText()));
            }
     
            pstmt.setString(7, String.valueOf(add1.getText()));
            pstmt.setString(8, String.valueOf(add2.getText()));
            
            pstmt.setString(9, String.valueOf(res.getText()));
            pstmt.setString(10, String.valueOf(mob.getText()));
            
            pstmt.setString(11, jobID);
            
            pstmt.executeUpdate();
   
            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    // Search Employee
    public void SearchEmp(JTable table,String tableName, String keyword, String id, String name, String jobID, JLabel warning){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT employeeId, name, jobId, telephoneMob FROM "+tableName+" WHERE "+id+" = '"+keyword+"' OR "+name+" LIKE '"+keyword+"%'");
            //rslt=stmnt.executeQuery("Select job")
            if(!rslt.next()){
                warning.setText("No results found!");
            }else{ 
                table.setModel(DbUtils.resultSetToTableModel(rslt));
                System.out.println("Have");
            }    
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
   }

    public void DeleteEmployee(String empID){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try {
            query=("DELETE FROM employee WHERE employeeId = '"+empID+"'");
            pstmt=dbCon.con.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } 
        
       
    }
    
    public void LoadImage(String id, JLabel image){
        DbConnect db=new DbConnect();
        db.setConnection();
        byte[] fileBytes;
        String query;
        try{
            query = "SELECT image FROM employee WHERE employeeId='"+id+"'";

            Statement state = db.con.createStatement();
            ResultSet rs = state.executeQuery(query);
            if (rs.next())
            {
                Blob blob = rs.getBlob("image");
                int blobLength = (int) blob.length();

                byte[] bytes = blob.getBytes(1, blobLength);
                ImageIcon icon = new ImageIcon(bytes); // you can read straight from byte array

                image.setIcon(new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
                
               
                //image_path.setText(rs.getString(query));
                
            }
            else 
            {
                //no image 
            }
                

        }
        catch (Exception e)
        {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void LoadtoForm(JTable searchTable, JTextField id, JTextField name, com.toedter.calendar.JDateChooser dob, JTextField nic ,JRadioButton male, JRadioButton female, JRadioButton married, JRadioButton unmarried, JTextField add1, JTextField add2, JTextField res, JTextField mob, JLabel img_path, JComboBox jobAssigned){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String query;
        PreparedStatement pstmt;
        ResultSet rslt;
        
        GetJobIDNAME get_jo = new GetJobIDNAME();
        
        
        try {
            int row = searchTable.getSelectedRow();
            query = ("select * from employee where employeeId=?");
            pstmt=dbcon.con.prepareStatement(query);

            String table_click = (searchTable.getModel().getValueAt(row, 0).toString());
            
            pstmt.setString(1, table_click);
            rslt = pstmt.executeQuery();
            
            if(rslt.next()){
                
                id.setText(rslt.getString("employeeId"));
                name.setText(rslt.getString("name"));
                dob.setDate(rslt.getDate("dateOfBirth"));
                nic.setText(rslt.getString("nic"));
                
                String gen = rslt.getString("gender");
                if(gen.equals("Male")){
                    male.setSelected(true);
                    }
                else if(gen.equals("Female")){
                    female.setSelected(true);
                    }
                
                String civil = rslt.getString("civilStatus");
                if(civil.equals("Married")){
                    married.setSelected(true);
                    }
                else if(civil.equals("Unmarried")){
                    unmarried.setSelected(true);
                    }
                
                add1.setText(rslt.getString("address1"));
                add2.setText(rslt.getString("address2"));
                res.setText(rslt.getString("telephoneRes"));
                mob.setText(rslt.getString("telephoneMob"));
                
                HRManagementDBAccess hrdac = new HRManagementDBAccess();
                hrdac.LoadImage(rslt.getString("employeeId"), img_path ); 
                
                jobAssigned.setSelectedItem(get_jo.ReturnJobName(rslt.getString("jobId")));
               
            }
            
        } catch (Exception e) {
        }
    }
    
    //Fill Combo
    public void FillCombo(JComboBox cmb, String fieldName, String tableName){
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
    
    
    //EmployeeID auto Incremet
    public void EmpIDIncrement(JTextField emp_id){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            Statement stmt = null;
            ResultSet rslt;
            stmt = dbcon.con.createStatement();
            
            rslt = stmt.executeQuery("SELECT employeeId FROM employee ORDER BY employeeId ");
  
            String x = null;
            int y = 0;
            while (rslt.next()) {
                x = rslt.getString("employeeId");   
            }
            y = Integer.parseInt(x.substring(3,7));
            int incremented = y + 1;
            emp_id.setText("EMP"+Integer.toString(incremented));
            
            rslt.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }   
    }
    
    public void AddOccupation(JTextField jobid, JTextField title, JComboBox devision, JTextField basicSal, JTextField bonusRate, JTextField otRate){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try {
            query=("INSERT INTO occupation VALUES (?,?,?,?,?,?)");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(jobid.getText()));
            pstmt.setString(2, String.valueOf(title.getText()));
            pstmt.setString(4, devision.getSelectedItem().toString());
            pstmt.setString(3, String.valueOf(basicSal.getText()));
            pstmt.setString(5, String.valueOf(bonusRate.getText()));
            pstmt.setString(6, String.valueOf(otRate.getText()));
            
            pstmt.executeUpdate();
            dbCon.con.close();
            pstmt.close();
            
        } catch (Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LoadOccupationTable(JTable table,String tableName, String keyword, String id, String name, String jobID, JLabel warning){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT jobId, jobName, basicSalary, division, bonusRate, otRate FROM "+tableName+" WHERE '"+id+"' = '"+keyword+"' OR "+name+" LIKE '"+keyword+"%'");
            //rslt=stmnt.executeQuery("Select job")
            if(!rslt.next()){
                 warning.setText("No results found!");
            }else{    
            table.setModel(DbUtils.resultSetToTableModel(rslt));
            }
            
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LoadOccupationTable2(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT jobId AS 'Job ID', jobName AS 'Job Title', basicSalary AS 'Basic Salary', division AS 'Division', otRate AS 'OT Rate' FROM occupation ");
            //rslt=stmnt.executeQuery("Select job")
                
            table.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LoadOccupationtoForm(JTable searchTable, JTextField id, JTextField title, JComboBox devision, JTextField basicSal, JTextField bonusRate, JTextField otRate){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String query;
        PreparedStatement pstmt;
        ResultSet rslt;
        
        try {
            int row = searchTable.getSelectedRow();
            query = ("SELECT * FROM occupation WHERE jobId=?");
            pstmt = dbcon.con.prepareStatement(query);
            
            String table_click = (searchTable.getModel().getValueAt(row, 0).toString());
            
            
            pstmt.setString(1, table_click);
            rslt = pstmt.executeQuery();
            
            if(rslt.next()){
                    id.setText(rslt.getString("jobId"));
                    title.setText(rslt.getString("jobName"));
                    devision.setSelectedItem(rslt.getString("division"));
                    basicSal.setText(rslt.getString("basicSalary"));
                    bonusRate.setText(rslt.getString("bonusRate"));
                    otRate.setText(rslt.getString("otRate"));
                    
                    dbcon.con.close();
                    rslt.close();
            }
        }
        catch (Exception e) {
             Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
       }
          
    }
    
public void ViewAllEmp(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT employeeId AS 'Employee ID', name AS 'Employee Name', telephoneMob AS 'Contact No', jobId AS 'Job ID' FROM employee");
           
                table.setModel(DbUtils.resultSetToTableModel(rslt));
             
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
   }

//Update Occupation Details
    public void UpdateOccupationDetails(JTextField id, JTextField title, JComboBox devision, JTextField basicSal, JTextField bonusRate, JTextField otRate, String source_id ){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
  
        try{
            query=("UPDATE occupation SET jobId=?, jobName=?, basicSalary=?, division=?, bonusRate=? ,otRate=? WHERE jobId= '"+source_id+"'");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(id.getText()));
            pstmt.setString(2, String.valueOf(title.getText()));
            pstmt.setString(4,devision.getSelectedItem().toString());           
            pstmt.setString(3, String.valueOf(basicSal.getText()));
            pstmt.setString(5, String.valueOf(bonusRate.getText()));
            pstmt.setString(6, String.valueOf(otRate.getText()));      
      
            pstmt.executeUpdate();
            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void RemoveOccupation(String jobID){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try {
            query=("DELETE FROM occupation WHERE jobId = '"+jobID+"'");
            pstmt=dbCon.con.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public void ClearOccupation(JTextField id, JTextField title, JComboBox division, JTextField basicSal, JTextField bonusRate, JTextField otRate){
        id.setText("");
        title.setText("");
        division.setSelectedItem(null);
        basicSal.setText("");
        bonusRate.setText("");
        otRate.setText("");
    }

    public void RetrieveAtt(JTextField Empid, JLabel avgDuration, String month, JComboBox year){
        try {
            DbConnect dbCon = new DbConnect();
            dbCon.setConnection();
               
            Statement stmnt;
            ResultSet rslt;

            String a = null;
            Double b = null;
            String c = null;
            
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT SUM(duration)/COUNT(employeeId) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");   
            
            if(rslt.next()){
                a = rslt.getString(1);
                
                b = Double.parseDouble(a);
                
                DecimalFormat f = new DecimalFormat("##.00");
                c = f.format(b);
                
            }
            avgDuration.setText(c+("  Hours"));
        } catch (Exception e) {
             Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void ReturnLeaves(JTextField Empid, String month, JComboBox year, JLabel leaves, JLabel presentDays){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
        Integer a = null;
        Integer b = null; 
        
        try {
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT COUNT(employeeId) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            
            while(rslt.next()){
                a = 20 - rslt.getInt("COUNT(employeeId)");
                b = rslt.getInt("COUNT(employeeId)");
            }
            leaves.setText(String.valueOf(a)+" Days");
            presentDays.setText(String.valueOf(b)+" Days");
            
            
            
        } catch (Exception e) {
        }
    }
    
    public void ReturnEmpName(JTextField id, JLabel name){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
        String a = null;
        String b = null; 
        
        try {
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT name FROM employee WHERE employeeId = '"+id.getText()+"'");
            
            while(rslt.next()){
                a = rslt.getString("name");
               // b = rslt.getString("devision");
            }
            name.setText(a);
            //devision.setText(b);

        } catch (Exception e) {
        }
    }
    
    public String ReturnMonthNo(JComboBox month){
        String a = null;
        
        if(month.getSelectedItem().equals("August")){
            a="8";
        }else if(month.getSelectedItem().equals("January")){
            a="1";
        }else if(month.getSelectedItem().equals("February")){
            a="2";
        }else if(month.getSelectedItem().equals("March")){
            a="3";
        }else if(month.getSelectedItem().equals("April")){
            a="4";
        }else if(month.getSelectedItem().equals("May")){
            a="5";
        }else if(month.getSelectedItem().equals("June")){
            a="6";
        }else if(month.getSelectedItem().equals("July")){
            a="7";
        }else if(month.getSelectedItem().equals("September")){
            a="9";
        }else if(month.getSelectedItem().equals("October")){
            a="10";
        }else if(month.getSelectedItem().equals("November")){
            a="11";
        }else if(month.getSelectedItem().equals("December")){
            a="12";
        }
        
        return a;
    }
    
    
    public void LoadAttendance(JTable table, JTextField Empid, String month, JComboBox year){
        try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT entryId as Entry_ID, employeeId as Employee_ID, inTime as In_Time, outTime as Out_Time, duration as Duration FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            table.setModel(DbUtils.resultSetToTableModel(rslt));

            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void ReturnEmpDevision(JTextField id, JLabel division){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
        String a = null;
        //String b = null; 
        
        try {
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT O.division from occupation O, employee E WHERE E.jobId = O.jobId AND E.employeeId = '"+id.getText()+"'");
            
            while(rslt.next()){
                a = rslt.getString(1);
               // b = rslt.getString("devision");
            }
            division.setText(a);
            //devision.setText(b);

        } catch (Exception e) {
        }
    }
    
    public void Search(JTable table, String search){
         try {
            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);
            
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();       
        Statement stmnt;
        ResultSet rslt;
        
        stmnt=dbCon.con.createStatement();
            rslt = stmnt.executeQuery("SELECt employeeId AS 'Employee ID',name AS 'Name',telephoneMob AS 'Contact No:',jobId AS 'Job ID' FROM employee where employeeId like '"+search+ "%' OR name like '"+search+"%'");


            table.setModel(DbUtils.resultSetToTableModel(rslt));
            
        } catch (Exception ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            errors.toString();

            JOptionPane.showMessageDialog(null, "Exception Found. " + ex);

        }
    }
    
    //search job
    public void SearchJob(JTable table, String search){
         try {
            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);
            
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();       
        Statement stmnt;
        ResultSet rslt;
        
        stmnt=dbCon.con.createStatement();
            rslt = stmnt.executeQuery("SELECt jobId AS 'Job ID', jobName AS 'Job Title', basicSalary AS 'Basic Salary', division AS 'Division', otRate AS 'OT Rate' FROM occupation WHERE jobId like '"+search+ "%' OR jobName like '"+search+"%' OR division like '"+search+"%'");


            table.setModel(DbUtils.resultSetToTableModel(rslt));
            
        } catch (Exception ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            errors.toString();

            JOptionPane.showMessageDialog(null, "Exception Found. " + ex);

        }
    }
    
    //JFree Chart
    
    //LeaveID auto Incremet
    public void LeaveIDIncrement (JTextField leave_id){
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            Statement stmt = null;
            ResultSet rslt;
            stmt = dbcon.con.createStatement();
            
            rslt = stmt.executeQuery("SELECT leaveId FROM empleave ORDER BY leaveId ");
  
            String x = null;
            int y = 0;
            while (rslt.next()) {
                x = rslt.getString("leaveId");   
            }
            y = Integer.parseInt(x.substring(3,7));
            int incremented = y + 1;
            leave_id.setText("LVE"+Integer.toString(incremented));
            
            rslt.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }   
    }    
    
    public int RecordCheck(JTextField id){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
        int a = 0;
        //String b = null; 
        
        try {
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT name FROM employee WHERE employeeId = '"+id.getText()+"'");
            
            if((rslt.next()) == false ){
                a = 0;
            }else
                a = 1;
            
            //return a;
            
        } catch (Exception e) {
        }
        return a;
    }
    
    //Add Leave Details
    public void AddLeave(JTextField leaveId, JTextField empID ,JTextArea  reason, String fromDate, String toDate){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
         
        
        try{
            query=("INSERT INTO empleave VALUES (?,?,?,?,?,?)");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(leaveId.getText()));
            pstmt.setString(2, String.valueOf(empID.getText()));
            //dob needed 3
            
            pstmt.setString(3, String.valueOf(reason.getText()));
            
            pstmt.setString(4, fromDate);
            pstmt.setString(5, toDate);
            pstmt.setString(6, "Pending");
      
            pstmt.executeUpdate();
            
            dbCon.con.close();
            pstmt.close();      
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void LoadPendingLeave(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            String a = "Pending";
            rslt=stmnt.executeQuery("SELECT leaveId as LeaveID, employeeId as EmployeeID, status as Status FROM empleave where status = '"+a+"'");
            
            table.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    //Load Pending request to form
    public void LoadLeaveToForm(JTable table, JLabel empID, JTextArea reason, JLabel from, JLabel to, JLabel leaveID){
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String query;
        PreparedStatement pstmt;
        ResultSet rslt;
        
        try {
            int row = table.getSelectedRow();
            query = ("SELECT * FROM empleave WHERE leaveId=?");
            pstmt = dbcon.con.prepareStatement(query);
            
            String table_click = (table.getModel().getValueAt(row, 0).toString());
            
            
            pstmt.setString(1, table_click);
            rslt = pstmt.executeQuery();
            
            if(rslt.next()){
                    empID.setText(rslt.getString("employeeId"));
                    reason.setText(rslt.getString("reason"));
                    from.setText(rslt.getString("startDate"));
                    to.setText(rslt.getString("endDate"));
                    leaveID.setText(rslt.getString("leaveId"));

                    dbcon.con.close();
                    rslt.close();
            }
        }
        catch (Exception e) {
             Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    //approve the leave
    public void ApproveLeave(JLabel leaveID){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
  
        try{
            query=("UPDATE empleave SET status=? WHERE leaveId= '"+leaveID.getText()+"'");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, "Approved");
            
            pstmt.executeUpdate();

            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //reject the leave
    public void RejectLeave(JLabel leaveID){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;
  
        try{
            query=("UPDATE empleave SET status=? WHERE leaveId= '"+leaveID.getText()+"'");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, "Rejected");
            
            pstmt.executeUpdate();

            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cleanLeave(JTextField id , JLabel name, JTextArea reason, JDateChooser from, JDateChooser to){
        id.setText("");
        name.setText("");
        reason.setText("");
        from.setDate(null);
        to.setDate(null);
    }
    
    public void cleanApprvedRejectedLeave(JLabel employeeId , JLabel leaveId, JTextArea reason, JLabel from, JLabel to){
        employeeId.setText("");
        leaveId.setText("");
        reason.setText("");
        from.setText("");
        to.setText("");
    }
    
    public void LoadLeave(JTable table, JLabel warning, String id, String which){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            //String b = "Approved";
            //String c = "Rejected";
            
            
            
            rslt=stmnt.executeQuery("SELECT leaveId as LeaveID, employeeId as EmployeeID, startDate as StartDate, endDate as EndDate, status as Status FROM empleave where employeeId = '"+id+"' ");
            
            if(!rslt.next()){
                warning.setText("No Employee under this Employee ID");
            }else{
                table.setModel(DbUtils.resultSetToTableModel(rslt));
                warning.setText("");
            }
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //load All
    public void LoadLeaveAll(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            
            rslt=stmnt.executeQuery("SELECT leaveId as LeaveID, employeeId as EmployeeID, startDate as StartDate, endDate as EndDate, status as Status FROM empleave");
           
            table.setModel(DbUtils.resultSetToTableModel(rslt));
         
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //load Approved
    public void LoadLeaveApproved(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            String b = "Approved";
            
            rslt=stmnt.executeQuery("SELECT leaveId as LeaveID, employeeId as EmployeeID, startDate as StartDate, endDate as EndDate, status as Status FROM empleave where status = '"+"Approved"+"'");
            
            table.setModel(DbUtils.resultSetToTableModel(rslt));
            
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //load rejected
    public void LoadLeaveRejected(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            String b = "Rejected";
          
            rslt=stmnt.executeQuery("SELECT leaveId as LeaveID, employeeId as EmployeeID, startDate as StartDate, endDate as EndDate, status as Status FROM empleave where status = '"+b+"' ");
            
            table.setModel(DbUtils.resultSetToTableModel(rslt));
         
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //load pending 
    public void LoadLeavePending(JTable table){
   
   try{
           
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            String b = "Pending";
            
            rslt=stmnt.executeQuery("SELECT leaveId as LeaveID, employeeId as EmployeeID, startDate as StartDate, endDate as EndDate, status as Status FROM empleave where status = '"+b+"' ");
            
            table.setModel(DbUtils.resultSetToTableModel(rslt));
            
            dbCon.con.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //leave Load
    public void loadLeaveDetails(JComboBox type,JTable table){
        
        if(type.getSelectedItem().toString() == "All"){
            LoadLeaveAll(table);
        }else if(type.getSelectedItem().toString() == "Approved"){
            LoadLeaveApproved(table);
        }else if(type.getSelectedItem().toString() == "Rejected"){
            LoadLeaveRejected(table);
        }else if(type.getSelectedItem().toString().equals("Pending")){
            LoadLeavePending(table);
        }else
            System.out.println("triggerd");
    }
    
    //retrieve worked days
     public void ReturnPresentDays(JTextField Empid, String month, JComboBox year, JLabel presentDays){
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
               
        Statement stmnt;
        ResultSet rslt;
        
        Integer a = null;
        Integer b = null; 
        
        try {
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT COUNT(employeeId) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            
            while(rslt.next()){
                a = 20 - rslt.getInt("COUNT(employeeId)");
                b = rslt.getInt("COUNT(employeeId)");
            }
            //leaves.setText(String.valueOf(a)+" Days");
            presentDays.setText(String.valueOf(b)+" Days");
            
            
            
        } catch (Exception e) {
        }
    }
    
     //retrieve worked hours
    public void ReturnWorkedtHours(JTextField Empid, JLabel hours, String month, JComboBox year){
        try {
            DbConnect dbCon = new DbConnect();
            dbCon.setConnection();
               
            Statement stmnt;
            ResultSet rslt;

            String a = null;
            Double b = null;
            String c = null;
            
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT SUM(duration) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");   
            
            if(rslt.next()){
                a = rslt.getString(1);
                b = Double.parseDouble(a);
                
                DecimalFormat f = new DecimalFormat("##.00");
                c = f.format(b);
                
            }
            hours.setText(c+("  Hours"));
        } catch (Exception e) {
             Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //return OverTimed hours
    public void ReturnOTHours(JTextField Empid, String month, JComboBox year, JLabel otHours){
            try {
            DbConnect dbCon = new DbConnect();
            dbCon.setConnection();
               
            Statement stmnt1, stmnt2;
            ResultSet rslt1, rslt2;

            String a = null;
            Double b = null;
            double hours = 0;
            int days = 0;
            double othours;
            double fin;
            
            stmnt1=dbCon.con.createStatement();
            rslt1=stmnt1.executeQuery("SELECT SUM(duration) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            
            if(rslt1.next()){
                a = rslt1.getString(1);
                b = Double.parseDouble(a);
                
               // DecimalFormat f = new DecimalFormat("##.00");
                hours = b;
            }
            
            stmnt2=dbCon.con.createStatement();
            rslt2=stmnt2.executeQuery("SELECT COUNT(employeeId) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            
            while(rslt2.next()){
                days = rslt2.getInt("COUNT(employeeId)");
            }
            
            DecimalFormat m = new DecimalFormat("##.00");
            othours = hours - (days * 8 ); 
            otHours.setText(String.valueOf(m.format(othours))+" Hours");
            
        } catch (Exception e) {
                Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    
    //return Basic Sal and 
    public void ReturnBasicSalOTAllowance(JTextField Empid, JLabel BasicSal, JLabel OTAllowance, String month, JComboBox year, JLabel calculatedSal, JLabel calcculatedOTAll, JLabel netSalary){
        try {
            DbConnect dbCon = new DbConnect();
            dbCon.setConnection();
               
            Statement stmnt, stmnt2, stmnt3, stmnt4;
            ResultSet rslt, rslt2, rslt3, rslt4;
            
            double otRate = 0;
            int basicSal = 0;
            double otAll;
            double hourlyBasicSal;
            
            double calcBasicSal;
            double calcOtAll;
            double netSal;
            int days = 0;
            
            String a = null;
            Double b = null;
            double hours = 0;
            
            double othours;
            double fin;

            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT o.basicSalary, o.otRate FROM occupation o, employee e WHERE e.employeeId = '"+Empid.getText()+"' AND e.jobId = o.jobId ");

            while(rslt.next()){
               basicSal = rslt.getInt(1);
               otRate = rslt.getDouble(2);
            }
            DecimalFormat m = new DecimalFormat("##.00");
            
            BasicSal.setText(String.valueOf(m.format(basicSal))+" Rs");
            hourlyBasicSal = ((basicSal/24.00)/8.00);
            otAll = (hourlyBasicSal*(otRate/100))+hourlyBasicSal;
            OTAllowance.setText(String.valueOf(m.format(otAll))+" Rs");
            
            //--------------------------------------------
            stmnt2=dbCon.con.createStatement();
            rslt2=stmnt2.executeQuery("SELECT COUNT(employeeId) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            
            while(rslt2.next()){
                days = rslt2.getInt("COUNT(employeeId)"); //days
            }
            
            calculatedSal.setText(String.valueOf(m.format((basicSal/24)*days))+" Rs");
            //--------------------------------------------
            
            stmnt3=dbCon.con.createStatement();
            rslt3=stmnt3.executeQuery("SELECT SUM(duration) FROM attendance WHERE employeeId = '"+Empid.getText()+"' AND MONTH(inTime) = '"+month+"' AND YEAR(inTime) = '"+year.getSelectedItem()+"' ");
            
            if(rslt3.next()){
                a = rslt3.getString(1);
                b = Double.parseDouble(a);

                hours = b;
            }
            
            othours = hours - (days * 8 ); 
            
            //calc ot allowance for worked days
            calcculatedOTAll.setText(String.valueOf(m.format(othours*otAll))+" Rs");
            
            //cal netSal
            netSalary.setText(String.valueOf(m.format((othours*otAll)+((basicSal/24)*days)))+" Rs");
                
            dbCon.con.close();
            rslt.close();
            rslt2.close();
            rslt3.close();
            
        } catch (Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //return job
    public void ReturnJob(JTextField Empid, JLabel job){
        try {
            
            DbConnect dbCon = new DbConnect();
            dbCon.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
        
            stmnt=dbCon.con.createStatement();
            rslt=stmnt.executeQuery("SELECT o.jobName FROM occupation o, employee e WHERE o.jobId = e.jobId AND e.employeeId = '"+Empid.getText()+"'");
    
            while(rslt.next()){
                job.setText(rslt.getString(1));
            }
            
            dbCon.con.close();
            rslt.close();
        } catch (Exception e) {
        }
    }
   
    public String ReturnJobID(JComboBox job){
        String a = null;
        
        if(job.getSelectedItem().equals("Assistant HR Manager")){
        a = "JB001";
        }else if(job.getSelectedItem().equals("Sales Manager")){
        a = "JB002";
        }else if(job.getSelectedItem().equals("Warehouse Manager")){
        a = "JB003";
        }else if(job.getSelectedItem().equals("Data Entry Operator")){
        a = "JB004";
        }else if(job.getSelectedItem().equals("Customer Order Manager")){
        a = "JB005";
        }else if(job.getSelectedItem().equals("Data Entry Officer")){
        a = "JB006";
        }else if(job.getSelectedItem().equals("Assistant Warehouse Manager")){
        a = "JB007";
        }else if(job.getSelectedItem().equals("Distribution Manager")){
        a = "JB008";
        }else if(job.getSelectedItem().equals("Sales Rep")){
        a = "JB009";
        }else if(job.getSelectedItem().equals("Driver")){
        a = "JB010";
        }else if(job.getSelectedItem().equals("Technical Assistant")){
        a = "JB011";
        }else if(job.getSelectedItem().equals("Plant Manager")){
        a = "JB012";
        }else if(job.getSelectedItem().equals("Data Entry Operator")){
        a = "JB013";
        }else if(job.getSelectedItem().equals("Customer Order Assistant")){
        a = "JB014";
        }else if(job.getSelectedItem().equals("Purchase Manager")){
        a = "JB015";
        }
        else{
        }
        
        return a;
    }
    
    //Add Sal Payment Details
    public void AddSalPayment(JTextField id, String salId, String issueDate ,String month, JLabel ot, JLabel netSal){
        
        DbConnect dbCon = new DbConnect();
        dbCon.setConnection();
        
        String query;
        PreparedStatement pstmt;

        try{
            query=("INSERT INTO salarypayment VALUES (?,?,?,?,?,?)");
            pstmt=dbCon.con.prepareStatement(query);
            
            pstmt.setString(1, salId);
            pstmt.setString(2, String.valueOf(id.getText()));
            
            pstmt.setString(3, issueDate);
            
            pstmt.setString(4, month);
            
            pstmt.setString(5, String.valueOf(ot.getText()));
            pstmt.setString(6, String.valueOf(netSal.getText()));
         
            pstmt.executeUpdate();
            
            dbCon.con.close();
            pstmt.close();
            
        }
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     //SalID auto Incremet
    public String SalIDIncrement(){
        String salID = null;
        
        try {
            DbConnect dbcon = new DbConnect();
            dbcon.setConnection();
            Statement stmt = null;
            ResultSet rslt;
            stmt = dbcon.con.createStatement();
            
            
            
            rslt = stmt.executeQuery("SELECT salaryId FROM salarypayment ORDER BY salaryId ");
  
            String x = null;
            int y = 0;
            while (rslt.next()) {
                x = rslt.getString("salaryId");   
            }
            y = Integer.parseInt(x.substring(3,7));
            int incremented = y + 1;
            salID= String.valueOf("SAL"+Integer.toString(incremented));
            
            rslt.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }   
        return salID;
    }
    
    public void ClraeSal(JTextField one,JComboBox two, JComboBox three, JLabel four, JLabel five, JLabel six, JLabel seven, JLabel eight, JLabel nine, JLabel ten, JLabel eleven, JLabel twele, JLabel thirteen, JLabel fourteen){
        one.setText("");
        two.setSelectedItem(-1);
        three.setSelectedItem(-1);
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
        ten.setText("");
        twele.setText("");
        thirteen.setText("");
        fourteen.setText("");
        eleven.setText("");
    }
    
    public void clearEmp(JTextField one,JTextField two, JComboBox three, JTextField four, JRadioButton five, JRadioButton six, JRadioButton seven, JRadioButton eight, JDateChooser nine, JTextField ten, JTextField eleven, JTextField twele, JTextField thirteen, JLabel fourteen){
        one.setText("");
        two.setText("");
        three.setSelectedIndex(-1);
        four.setText("");
        five.setSelected(false);
        six.setSelected(false);;
        seven.setSelected(false);
        eight.setSelected(false);
        nine.setDate(null);
        ten.setText("");
        twele.setText("");
        thirteen.setText("");
        fourteen.setIcon(null);
        eleven.setText("");
    }
    
}


       
    

