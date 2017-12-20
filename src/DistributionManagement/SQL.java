/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;

import RootElement.DbConnect;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.PopupMenu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javafx.scene.input.DataFormat;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.export.tabulator.Table;

/**
 *
 * @author Shali
 */
public class SQL {
        DbConnect connection = new DbConnect();
        String query;
        PreparedStatement pst;
       
        
        
        public void fillComboBox(JComboBox combo,String tablename, String attribute)
    {
        
        
        
                
                connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("Select Distinct "+attribute+" from "+tablename);
                
                while(rslt.next())
                {
                    String value=rslt.getString(attribute);
                    combo.addItem(value);
                    
                }
                
                combo.setSelectedIndex(-1);
               
                stmnt.close();
                connection.con.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                
                
                
           }
    
        public boolean CheckifExists(JTextField f1,String table,String attr)
        {
            try{
                
                connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("Select "+attr+" from "+table+" where "+attr+"='"+f1.getText()+ "'"); 
               // String res=rslt.toString();
                
                if(!rslt.next())
                {
                   return true; 
                }
                else 
                {
                     //JOptionPane.showMessageDialog(null,"Reg Number Already Exists. Please re-check","Warning",JOptionPane.ERROR_MESSAGE);
                   return false;
                        
                }
                 
          } 
            catch (Exception i)
            {
            
            }
      return false;
        
        }
        
        
        
    
   
    
    public void AddVehicleDetails(JTextField vehicleNo,JTextField make,JTextField model,JComboBox type,JTextField colour,JTextField weight,JLabel image_path,JTextArea description,JDateChooser purchaseDate,JComboBox status,JComboBox department,JComboBox location) throws FileNotFoundException
    {
        
        connection.setConnection();
        Statement stmt;
            try {
                
                //stmt = connection.con.createStatement();
             
    
               
               //Image file 
               int len;
               File file=new File(image_path.getText());
               FileInputStream fis=new FileInputStream(file);
               len = (int)file.length();

               
               
                query=("insert into vehicle Values(?,?,?,?,?,?,?,?,?,?,?,?)");
                pst=connection.con.prepareStatement(query);
                
                
                pst.setString(1,vehicleNo.getText());
                pst.setString(2,make.getText());
                pst.setString(3,model.getText());
                pst.setString(4,String.valueOf(type.getSelectedItem()));
                pst.setString(5,colour.getText());
                pst.setInt(6, Integer.parseInt(weight.getText()));
                pst.setBinaryStream(7,fis,len);
                pst.setString(8,description.getText());
                
                
            //----getDate(yyyy-mm-dd)------
            SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy/MM/dd");
           
            //----          -------//
            
                
               pst.setString(9,fmt1.format(purchaseDate.getDate()));
               pst.setString(10,String.valueOf(status.getSelectedItem()));
               pst.setString(11,String.valueOf(department.getSelectedItem()));
               pst.setString(12,String.valueOf(location.getSelectedItem())); 
                
               pst.executeUpdate();
               
              //clear Fields
        /*      vehicleNo.setText(null);
              make.setText(null);
              model.setText(null);
              type.setSelectedIndex(-1);
              colour.setText(null);
              weight.setText(null);
              image_path.setText(null);
              description.setText(null);
              purchaseDate.setDate(null);
              status.setSelectedIndex(-1);
              department.setSelectedIndex(-1);
              location.setSelectedIndex(-1);
              */
               
                
            } catch (SQLException ex) {
                
                System.out.println("Error! "+ex);
                
            }
        
        
    
    }
    
    
    
    public void SetVehicleDetails_UpdateTab(JComboBox Num,JComboBox loc,JComboBox dep,JComboBox stat,JTextArea ar1,JLabel img)
    {
      
        try{
               connection.setConnection();
               
                Statement stmnt;
                ResultSet rslt;
                stmnt=connection.con.createStatement();
                //rslt=stmnt.executeQuery("select description,location,department,status,image from vehicle where vehicleNo="+Num.getSelectedItem()+"'");
                rslt=stmnt.executeQuery("select description,location,department,status,image from vehicle where vehicleNo='"+Num.getSelectedItem()+"'");
                
                while(rslt.next())
                {
                    
                    ar1.setText(rslt.getString("description"));
                   
                     loc.setSelectedItem(rslt.getString("location"));
                    
                     dep.setSelectedItem(rslt.getString("department"));
                    
                     stat.setSelectedItem(rslt.getString("status"));
                    
                    //Image Retrieval
                    
                     byte[] fileBytes;
                     Blob blob = rslt.getBlob("image");
                int blobLength = (int) blob.length();

                byte[] bytes = blob.getBytes(1, blobLength);
                ImageIcon icon = new ImageIcon(bytes); // you can read straight from byte array

                img.setIcon(new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(278, 229, Image.SCALE_DEFAULT)));

                    
                           
                }
                
                
              
                stmnt.close();
                connection.con.close();
           }
        catch(Exception i)
        {
            
        }
        
      
    }
    
   
    public void UpdateVehicle(JComboBox No,JComboBox loc,JComboBox dep,JComboBox stat,JTextArea ar1,JLabel img) 
     {
            connection.setConnection();
    String query="UPDATE vehicle SET description = ?,location = ?, department = ?, status = ? WHERE vehicleNo = ?";
    try{
    pst=connection.con.prepareStatement(query);
                
    
    pst.setString(1,ar1.getText());
    pst.setString(2,String.valueOf(loc.getSelectedItem()));
    pst.setString(3,String.valueOf(dep.getSelectedItem()));
    pst.setString(4,String.valueOf(stat.getSelectedItem()));
    pst.setString(5,String.valueOf(No.getSelectedItem()));
    
    
    pst.executeUpdate();
    System.out.println("Record is updated to vahicle table!");
    }
    catch (Exception i)
    { 
        System.out.println("Er :"+i);
    }

                
            }
    
    
    
    public void SearchVehiclesAll(JTable tab, String no)
    {
     try{
           
            connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("Select vehicleNo AS Number, type as Type ,location As Location, department AS Department ,status As Status from vehicle where vehicleNo LIKE'%"+no+"%'");
                
            tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
   
   
    
    
    }
   
   public void SearchVehiclebyGo(JTable tab,JTextField txt)
   {
   
   try{
           
            connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("Select vehicleNo AS Reg_Number, type as Type ,location As Location, department AS Department ,status As Status from vehicle where vehicleNo='"+txt.getText()+"'");
                
            tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
   
   
   }
   
 public void SearchForDel(JTable t1, JTextArea tx)
 {
   
           connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            try{
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("Select vehicleNo AS Reg_Number, type as Type ,location As Location from vehicle where vehicleNo='"+tx.getText()+"'");
                
            t1.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
            }   
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
   
   
   
   }
 
 
 public void DelVehicle(String veh)
 {
     Statement stmnt;
      //String selectedObject = (String) (Object) t1.getModel().getValueAt(t1.getSelectedRow(),t1.getSelectedColumn());
     
         try {
             
             connection.setConnection();
             stmnt=connection.con.createStatement();
             
             query=("Delete from vehicle where vehicleNo=?");
             pst=connection.con.prepareStatement(query);
             pst.setString(1,veh);
              
             pst.execute();
             
             
             System.out.println("Deleted !! ");
             
             
         } catch (Exception ex) {
             System.out.println("Error sql "+ex);
         
         }
 }
 
 public void AddGatepass(JTextField pass, JComboBox driver, JTextField to, JTextField from, JDateChooser day,JComboBox vno, JComboBox deli,JComboBox type)
 {
 
 connection.setConnection();
 
 
 try{
     
                query=("insert into gatepass Values(?,?,?,?,?,?,?,?)");
                pst=connection.con.prepareStatement(query);
                
                
                pst.setString(1,pass.getText());
                pst.setString(2,String.valueOf(driver.getSelectedItem()));
                pst.setString(3,to.getText());
                pst.setString(4,from.getText());
                
                
                
            //----getDate(yyyy-mm-dd)------
            SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy/MM/dd");
           
            //----          -------//
            
                
               pst.setString(5,fmt1.format(day.getDate()));
               pst.setString(6,String.valueOf(vno.getSelectedItem())); 
               pst.setString(7,String.valueOf(deli.getSelectedItem())); 
                pst.setString(8,String.valueOf(type.getSelectedItem())); 
                
               pst.executeUpdate();
               System.out.println("Inserted");
 
 }
 catch (Exception i)
 {
     System.out.println("Failed");
 }
}
 
 
public void AddRoute(JComboBox f1, JComboBox cmb2, JTextField f3, JTextField f4) 
{
    connection.setConnection();
        
  
    
        try{
         query=("insert into schedule Values(?,?,?,?)");
                pst=connection.con.prepareStatement(query);
                
                pst.setString(1,String.valueOf(f1.getSelectedItem()));
                pst.setString(2,String.valueOf(cmb2.getSelectedItem()));
                pst.setString(3,f3.getText());
                pst.setString(4,f4.getText());
                
            pst.executeUpdate();      
                    
        }
        catch(Exception i)
        {
            System.out.println("Error : "+i);
        
        }
        
           
}
     
public void LoadRoute(String day,JTextField f1, JTextField f2,JTextField f3)
{
    //routeNo, c, deliverTo, deliverFrom

    connection.setConnection();
        try{
                Statement stmnt;
                ResultSet rslt;
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("Select routeNo,deliverTo,deliverFrom from schedule where scheduleDate='"+day+ "'");
                
                
                while(rslt.next())
                {
                   
                    f1.setText(rslt.getString("routeNo"));
                    f2.setText(rslt.getString("deliverTo"));
                    f3.setText(rslt.getString("deliverFrom"));
                    
                   
                }
                
        }
        catch (Exception i)
        {
            System.out.println("Error @ "+i);
        }


}




public void incID(JTextField f1,String table, String attr,char prefix) //Delivery ID
{


  connection.setConnection();
        
        try{
        Statement stmnt;
        ResultSet rslt;
        stmnt=connection.con.createStatement();
        rslt=stmnt.executeQuery("Select "+attr+" from "+table+" order by "+attr+"");
      
        String iId="";  
           
        while(rslt.next())
           {
                iId=rslt.getString(attr);
               
           }
            IdIncrement in=new IdIncrement(iId,prefix);
            
            System.out.println("ID "+iId);
                                              
            f1.setText(in.getIncrementedId());
            stmnt.close();
            connection.con.close();
         }
        
        catch(Exception e){
            
        }
     

}

//Increment GatePass


public void UpdateRoute(JTextField rNo,JTextField to, JTextField from)
{
    connection.setConnection();
    String query="UPDATE schedule SET deliverTo = ?,deliverFrom = ? WHERE routeNo = ?";
    try{
    pst=connection.con.prepareStatement(query);
                
    
    pst.setString(1,to.getText());
    pst.setString(2,from.getText());
    pst.setString(3,rNo.getText());
    
    pst.executeUpdate();
    System.out.println("Record is updated to Schedules table!");
    }
    catch (Exception i)
    { 
        System.out.println("Er :"+i);
    }

}


public void SearchDriverByName(String name, JTable tab)
{
try{
           
            connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("Select name AS Employee_Name, employeeId as ID from employee where jobID='JB010' and name LIKE'%"+name+"%'");
                
            tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }

}
public void getDriver(String EmpId, JLabel l1,JLabel l2,JLabel l3,JLabel l4,JLabel l5,JLabel l6,JLabel l7,JLabel l8)
{
    connection.setConnection();
      try{
                Statement stmnt;
                ResultSet rslt;
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("Select employeeId, name, dateOfBirth, nic, address1, address2,telephoneMob, image from employee where employeeId='"+EmpId+ "'");
                
                
                while(rslt.next()) 
                {
                   
                    l1.setText(rslt.getString("employeeId"));
                    l2.setText(rslt.getString("name"));
                    l3.setText(rslt.getString("dateOfBirth"));
                    l4.setText(rslt.getString("nic"));
                    l5.setText(rslt.getString("address1"));
                    l6.setText(rslt.getString("address2"));
                    l7.setText(rslt.getString("telephoneMob"));
                  
                   
                   
                   byte[] fileBytes;
                     Blob blob = rslt.getBlob("image");
                int blobLength = (int) blob.length();

                byte[] bytes = blob.getBytes(1, blobLength);
                ImageIcon icon = new ImageIcon(bytes); // you can read straight from byte array

                l8.setIcon(new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(175, 176, Image.SCALE_DEFAULT)));

                    
                              
                   
                }
                
        }
        catch (Exception i)
        {
            System.out.println("Error @ "+i);
        }

      
      




}
public void loadCust(JTable tab, String state)
      {
          
         
   try{
           
            connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("select customerId as CustomerId,name as Name,address as Address,telephone as ContactNo from smallscalecustomer where state='"+state+"' " );
            //
            tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        } 
      
      }


public void LoadDriver(JComboBox box)
{
  
   try{
           
            connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("select name from employee where jobId='JB010' ");
            while(rslt.next())
                {
                    String value=rslt.getString("name");
                    box.addItem(value);
                    
                }
                
                box.setSelectedIndex(-1);
               
                
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane,"Unexpected error occured "+e, "Error", JOptionPane.ERROR_MESSAGE);
        } 
      
      }

public void AddInvoiceDeli(String inv,JTextField del)
{               connection.setConnection();
                System.out.println(del.getText());
try
{
    query=("insert into invoicedelivery Values (?,?)");

                pst=connection.con.prepareStatement(query);
                
                
                pst.setString(2,inv);
                pst.setString(1,del.getText());
                
                pst.executeUpdate();
                
                
                System.out.println("Added to invoice deli");
                
}
catch(Exception i)
{
    System.out.println(i);
}

}
public void getLastDelId(JTextField f1,String attr,String table)
{
    System.out.println("Op");
    connection.setConnection();
        
        try{
        Statement stmnt;
        ResultSet rslt;
        stmnt=connection.con.createStatement();
        rslt=stmnt.executeQuery("Select "+attr+" from "+table+" order by "+attr+"");
      
        String iId="";  
           
        while(rslt.next())
           {
                iId=rslt.getString(attr);
                
                //System.out.println(iId);
               
           }
            f1.setText(iId);
            
            stmnt.close();
            connection.con.close();
         }
        
        catch(Exception e){
            System.out.println(e);
            
        }
     




}

public void GetEmployeeID(JTextField f1,JTextField inv)//Small Scale order
        
{
    System.out.println("Op");
    connection.setConnection();
        
        try{
        Statement stmnt;
        ResultSet rslt;
        stmnt=connection.con.createStatement();
        rslt=stmnt.executeQuery("select S.employeeId from smallscaleorder S, smallordergoodinvoice SM where S.orderId = SM.OrderId And SM.invoiceNo='"+inv.getText()+"' ");
      
        String iId="";  
           
        while(rslt.next())
           {
                iId=rslt.getString("S.employeeId");
                
                //System.out.println(iId);
               
           }
            f1.setText(iId);
            
            stmnt.close();
            connection.con.close();
         }
        
        catch(Exception e){
            System.out.println(e);
            
        }





}



//Large scal e
public void GetEmployeeIDLarge(JTextField f1,JTextField inv)//Small Scale order
        
{
   // System.out.println("Op");
    connection.setConnection();
        
        try{
        Statement stmnt;
        ResultSet rslt;
        stmnt=connection.con.createStatement();
        rslt=stmnt.executeQuery("select L.employeeID from largescaleorder L, largeordergoodinvoice LO where L.orderID=LO.orderId and LO.invoiceNo='"+inv.getText()+"' ");
      
        String iId="";  
           
        while(rslt.next())
           {
                iId=rslt.getString("L.employeeId");
                
                //System.out.println(iId);
               
           }
            f1.setText(iId);
            
            stmnt.close();
            connection.con.close();
         }
        
        catch(Exception e){
            System.out.println(e);
            
        }





}

public void AssignVeh(JTextField id, JComboBox veh,JDateChooser date,JComboBox route,JComboBox emp,JLabel weight )
{
connection.setConnection();
                
 String query=("insert into delivery values(?,?,?,?,?,?)");
 try{
 pst=connection.con.prepareStatement(query);
 
                pst.setString(1,id.getText());
                pst.setString(2,String.valueOf(veh.getSelectedItem()));
                pst.setString(3,String.valueOf(route.getSelectedItem()));
   
                SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy/MM/dd");
           
            //----          -------//
            
                
               pst.setString(4,fmt1.format(date.getDate()));
               pst.setString(5,weight.getText());
               pst.setString(6,String.valueOf(emp.getSelectedItem()));
               
                pst.executeUpdate();
                
 
 
 
 }
 catch(Exception i)
 {
     System.out.println(i);
     
 
 }

}

public void getFinalWeight(JTextField inv,JTable tab,JLabel invoiceNo,JLabel weight,String view)
{
int w=0;
String invoice=null;
connection.setConnection();
        
        try{
        Statement stmnt;
        ResultSet rslt;
        stmnt=connection.con.createStatement();
        rslt=stmnt.executeQuery("select invoiceNo, sum(quantity*weight) from "+view+" where invoiceNo='"+String.valueOf(inv.getText())+"' ");
       // tab.setModel(DbUtils.resultSetToTableModel(rslt));
            
        
       while(rslt.next())
           {
                w=rslt.getInt("sum(quantity*weight)");
                invoice=rslt.getString("invoiceNo");
                invoiceNo.setText(invoice);
                weight.setText(String.valueOf(w));
                
                
                
                //System.out.println(" w "+w);
               
           }
       
          
            stmnt.close();
            connection.con.close();
         }
        
        catch(Exception e){
            System.out.println(" Error "+e);
            
        }

 
    

}

public void DistDiv(JComboBox b)
{
       
                connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery(" select E.employeeId from employee E , occupation O where E.jobId=O.jobId and O.division='Distribution Management' ");
                
                while(rslt.next())
                {
                    String value=rslt.getString("E.employeeId");
                    b.addItem(value);
                    
                }
                
                b.setSelectedIndex(-1);
               
                stmnt.close();
                connection.con.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                



}

public void NotDelivered(JComboBox bo)
{

  connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select D.deliveryId from delivery D where D.deliveryId NOT IN (select G.deliveryId from gatepass G) group by D.deliveryId ");
                //rslt=stmnt.executeQuery("select D.deliveryId from delivery D group by D.deliveryId");
               // 
                while(rslt.next())
                {
                    String value=rslt.getString("D.deliveryId");
                    bo.addItem(value);
                    
                }
                
                bo.setSelectedIndex(-1);
               
                stmnt.close();
                connection.con.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                
                
                




}

public void availableVehi(JComboBox combo,String tablename, String attribute,double num)
    {
        
        
        
                
                connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("Select distinct "+attribute+" from "+tablename+" where status = 'Available' and weight>"+num+"  "); // where status='Available' weight>"+num+" and
                
                while(rslt.next())
                {
                    String value=rslt.getString(attribute);
                    
                     combo.addItem(value);
                }
               
                   
                combo.setSelectedIndex(-1);
               
                stmnt.close();
                connection.con.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                
                
                
           }

public void DeliveryReportNotDelivered(JTable tab)
{
    connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select D.deliveryId as ' Delivery ID' , D.vehicleNo as 'Vehicle Number', D.deliveryDate as 'Delivery Date'  from delivery D where D.deliveryId NOT IN (select G.deliveryId from gatepass G) group by D.deliveryId ");
               
                tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                
                
                



    
    
}  

public void DeliveryReportDelivered(JTable tab)
{
    connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select D.deliveryId as ' Delivery Id ' , D.vehicleNo as ' Vehicle Number', D.deliveryDate as 'Delivery Date' from delivery D , gatepass G where D.deliveryId =  G.deliveryId Group by D.deliveryId ");
               
                tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
       
    
}  
public void ViewDeliveryInvoices(JTable tab , String did)
{
    
    //int count=0;
    connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                    
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select I.invoiceNo as Invoices from delivery D , invoicedelivery I where D.deliveryId = I.deliveryId  and I.deliveryId= '"+did+"' group by I.invoiceNo");
              
                tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
                
                
                   
            stmnt.close();
            rslt.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
  
}

public void searchDelByDate(String from,String to, JTable tab)
{
 connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                    
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select deliveryId as 'Delivery ID' , vehicleNo as 'Vehicle Number' , deliveryDate as 'Delivery Date' from delivery where deliveryDate BETWEEN '"+from+"' AND '"+to+"'");
              
                tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
                
                
                   
            stmnt.close();
           // rslt.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
    

}


public void issuedGate(JTable tab, String from , String to )
{
    connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select passNo as 'Gate Pass Number ', deliverTo as 'To' , deliverFrom as 'From' , deliveryId as ' Delivery Id ' ,passDate as 'Date', driverName as ' Driver ' from gatepass where passDate BETWEEN '"+from+"' AND '"+to+"'");
               
                tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
       
    
}  

public void VehicleNotification(JLabel noti, String status)
{

     connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select COUNT(vehicleNo) from vehicle  where status ='"+status+"'" ); 
                String c = "COUNT(vehicleNo)";
                
                while(rslt.next())
                {
                    String value=rslt.getString(c);
                    
                    noti.setText("You have "+value+" "+status+" vehicle(s)");
                }
               
                   
           
               
                stmnt.close();
                connection.con.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                
                



}


public void vehicleNoty(JTable tab, String sts)
    {
     try{
           
            connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("Select vehicleNo AS 'Vehicle Number ',department As 'Division' from vehicle where status = '"+sts+"'");
                
            tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            System.out.println(e);
        }
     
        
   
   
    
    
    }

public void DeliveryNoty(JLabel noti)
{

     connection.setConnection();
                
                Statement stmnt;
                ResultSet rslt;
                try{
                stmnt=connection.con.createStatement();
                rslt=stmnt.executeQuery("select COUNT(D.deliveryId)  from delivery D where D.deliveryId NOT IN (select G.deliveryId from gatepass G) "); 
                String c = "COUNT(D.deliveryId)";
                
                while(rslt.next())
                {
                    String value=rslt.getString(c);
                    
                    noti.setText("You have "+value+" Unassigned Deliveries");
                }
               
                   
           
               
                stmnt.close();
                connection.con.close();
                
                }
                catch (Exception i)
                {
                    System.out.println("Error "+i);
                }
                
                



}

   
public void showDelNoty(JTable tab)
{
    try{
      connection.setConnection();
               
            Statement stmnt;
            ResultSet rslt;
            stmnt=connection.con.createStatement();
            rslt=stmnt.executeQuery("select D.deliveryId as 'Delivery ID', D.vehicleNo AS 'Vehicle Number', D.deliveryDate as 'Date' from delivery D where D.deliveryId NOT IN (select G.deliveryId from gatepass G) group by D.deliveryId");
                
            tab.setModel(DbUtils.resultSetToTableModel(rslt));
                      
            stmnt.close();
            rslt.close();
        }
    
        catch(Exception e){
            Component rootPane = null;
            System.out.println(e);
        }
     
        
   
   
   
    
    
}

    
    
}

   

     


                
                
    
    













 
 
   
   
   
    
    
    
    
    
    

