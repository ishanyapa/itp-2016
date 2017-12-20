/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrderSupportedClasses;


import RootElement.DbConnect;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Saajith Zain
 */

public class CustomerOrderDbAccess {
    
    
    private String tableName;
    private String columnName;
    private JComboBox comboName;
    private JTable formTable;
            
    
    public CustomerOrderDbAccess()
    {
     
    }
    
    public CustomerOrderDbAccess(String tableName)
    {
        this.tableName=tableName;
    }
    
    public CustomerOrderDbAccess(String tableName, String column)
    {
        this.tableName=tableName;
        this.columnName=column;
    }
    
    
    public void fillComboOrderItems(JComboBox JCombo)
    {
       JCombo.removeAllItems();
        this.comboName=JCombo;
        try{
                  DbConnect c=new DbConnect();
                  c.setConnection();

                  Statement stmnt=c.con.createStatement();
                  ResultSet result=stmnt.executeQuery("Select "+this.columnName+" from "+this.tableName+"");


                  while(result.next()) {

                      String iName=result.getString(this.columnName);
                      comboName.addItem(iName);                    
                  }           
                  comboName.setSelectedIndex(-1);

                  stmnt.close();
                  c.con.close();
        }
         catch(Exception e){
         }        
    }
    
    
    
    public void fillCombo(JComboBox JCombo)
    {
       JCombo.removeAllItems();
        this.comboName=JCombo;
        try{
                  DbConnect c=new DbConnect();
                  c.setConnection();

                  Statement stmnt=c.con.createStatement();
                  ResultSet result=stmnt.executeQuery("Select "+this.columnName+" from "+this.tableName+" WHERE status='Active'");


                  while(result.next()) {

                      String iName=result.getString(this.columnName);
                      comboName.addItem(iName);                    
                  }           
                  comboName.setSelectedIndex(-1);

                  stmnt.close();
                  c.con.close();
        }
         catch(Exception e){
         }        
    }
    
    public void fillComboOrderId(JComboBox JCombo)
    {
        this.comboName=JCombo;
        try{
                  DbConnect c=new DbConnect();
                  c.setConnection();

                  Statement stmnt=c.con.createStatement();
                  ResultSet result=stmnt.executeQuery("SELECT orderId from largescaleorder WHERE status='Pending Confirmation'");


                  while(result.next()) {

                      String iName=result.getString("orderId");
                      comboName.addItem(iName);                    
                  }           
                  comboName.setSelectedIndex(-1);

                  stmnt.close();
                  c.con.close();
        }
         catch(Exception e){
             System.out.println(e);
         }        
    }

    
    
    public void fillTable(JTable formTable)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select * from "+this.tableName+" ");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
        }
    }
    
    
     
    public void fillTableDeliveryDetails(JTable formTable)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select orderId as 'Order Id',invoiceNo AS 'Invoice No',companyName AS 'Company',orderDate as 'Order Date',"
                    + "deliveryId as 'Delivery Id',vehicleNo AS 'Vehicle No',deliveryDate as 'Delivery Date',routeNo AS 'Route No' from "+this.tableName+" ");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
        }
    }
    
    
    public String returnCustomerEmail(String compName)
    {
         String email=""; 
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select email from largescalecustomer WHERE companyName='"+compName+"'");
           
            while(result.next()){
                         email= result.getString("email");
                       
                    }            
            
        }
        catch(Exception e){
           
        }
        return  email;
    }
    
    
    
    public void fillTableCustomer(JTable formTable)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select companyId As 'Company ID',companyName AS 'Company Name',cutomerType AS 'Company Type',telephone AS 'Point Of Contact',email As 'Company Email',country As Country,city AS City,postalCode AS 'Postal Code',address AS 'Address',status AS 'Company Status' from "+this.tableName+" ");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
        }
    }
    
    
    
     public void fillTableLargeScaleOrder(JTable formTable)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select orderId AS 'Order Id',orderDate AS 'Order Date',companyId as 'Company Id',orderType AS 'Order Type',status AS 'Order Status',shipmentDate AS 'Shipment Date',shipmentStatus AS 'Shipment Status', deliveryEmailStatus as 'Delivery Email Status',"
                    + "invoiceEmailStatus AS 'Invoice Email Status',discountRate AS 'Discount Rate',totalOrderAmount AS 'Order Total' from "+this.tableName+" ");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void deleteRow(String value){
     
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt;
            stmnt=c.con.createStatement();
            stmnt.executeUpdate("DELETE FROM "+this.tableName+" WHERE "+this.columnName+"='"+value+"'");    
        }
        
       catch(Exception e){
        }
    }
    
   

    
    public String getLastId(){
    
        String id="";
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("SELECT "+this.columnName+" FROM "+this.tableName+" ORDER BY "+this.columnName+" " );
            
                    while(result.next())
                    {
                        id=result.getString(this.columnName);
                    }
                    
        }
        catch(Exception e){
        }   
        
        return id;
    }
    
    

    public void insertCustomer(JTextField id,JTextField name,JTextField t1,JTextField t2,
                               JTextField t3,JTextField email,String type,JTextArea address,
                               JComboBox country,JTextField city,JTextField postal){
        
        String telephone="+"+t1.getText()+"-"+t2.getText()+"-"+t3.getText();
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("INSERT INTO largescalecustomer VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(id.getText()));
            pstmt.setString(2,String.valueOf(name.getText()));
            pstmt.setString(3, type);
            pstmt.setString(4,telephone);
            pstmt.setString(5, String.valueOf(String.valueOf(email.getText())));
            pstmt.setString(6, String.valueOf(String.valueOf(country.getSelectedItem())));
            pstmt.setString(7, String.valueOf(String.valueOf(city.getText())));
            pstmt.setString(8, String.valueOf(String.valueOf(postal.getText())));
            pstmt.setString(9, String.valueOf(String.valueOf(address.getText())));
            pstmt.setString(10, "Active");
            
            pstmt.executeUpdate();
            
            
            
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    
    
    public String getUpdateCompanyId(JComboBox compName){
    
        String id="";
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
            result=stmnt.executeQuery("SELECT * FROM "+this.tableName+" WHERE companyName= '"+compName.getSelectedItem()+"' " );
            
                    while(result.next())
                    {
                        id=result.getString(this.columnName);
                       
                    }            
        }
        catch(Exception e){
           
        }   
        
        return id;
    }



public void updateCustomer(JTextField id,JTextField name,JTextField t1,JTextField t2,
                               JTextField t3,JTextField email,JTextArea address,
                               JComboBox country,JTextField city,JTextField postal,String status){
        
    
        String telephone="+"+t1.getText()+"-"+t2.getText()+"-"+t3.getText();
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        
                String type;
                if(String.valueOf(country.getSelectedItem()).equals("Sri Lanka(LK)"))
                        type="Local";
                else 
                        type="Foreign";
         
        try{
            query=("UPDATE  "+this.tableName+" SET companyName=?,cutomertype=?,telephone=?,email=?,country=?,city=?,postalCode=?,address=?,status=? WHERE companyId= '"+String.valueOf(id.getText())+"' ");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, String.valueOf(name.getText()));
            pstmt.setString(2, type);
            pstmt.setString(3,telephone);
            pstmt.setString(4, String.valueOf(String.valueOf(email.getText())));
            pstmt.setString(5, String.valueOf(String.valueOf(country.getSelectedItem())));
            pstmt.setString(6, String.valueOf(String.valueOf(city.getText())));
            pstmt.setString(7, String.valueOf(String.valueOf(postal.getText())));
            pstmt.setString(8, String.valueOf(String.valueOf(address.getText())));
            pstmt.setString(9, status);
        
            
            pstmt.executeUpdate();
 
            dbcon.con.close();
            pstmt.close();

    
        
        } 
        catch (Exception e) {
           
        }

    } 

public void UpdateCustomerLoadData(JTextField id,JTextField name,JTextField t1,JTextField t2,
                               JTextField t3,JTextField email,JTextArea address,
                               JComboBox country,JTextField city,JTextField postal,JRadioButton Ractive,JRadioButton Rinactive){
    
    try{
            DbConnect c=new DbConnect();
            c.setConnection();
            
            String tel="",type="",status="";
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
            result=stmnt.executeQuery("SELECT companyName,cutomertype,telephone,email,country,city,postalCode,address,status "
                    + "FROM "+this.tableName+" WHERE companyId= '"+String.valueOf(id.getText())+"' " );
            
                    while(result.next())
                    {
                        name.setText(result.getString("companyName"));
                        type=result.getString("cutomertype");
                        tel=result.getString("telephone");
                        email.setText(result.getString("email"));
                        city.setText(result.getString("city"));
                        postal.setText(result.getString("postalCode"));
                        address.setText(result.getString("address"));
                        country.setSelectedItem(result.getString("country"));
                        status=result.getString("status");
                    }            
            
                   
                    
                    if(status.equals("Active")){
                     Ractive.setSelected(true);
                    }
                    else if(status.equals("Inactive")){
                      Rinactive.setSelected(true);
                    }
                    t1.setText(tel.substring(1,3));
                    t2.setText(tel.substring(4,7)); 
                    t3.setText(tel.substring(8));
    }
        catch(Exception e){
        } 
    
}

 
    public void addOrderItem(JComboBox j1,JTable model,JSpinner spin,JTextField total,JLabel count,JComboBox j2,JComboBox orderComp){
    
    
        String pid="",productName="";
        double up=0;
        int l=0,w=0,q=0;
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
           
            result=stmnt.executeQuery("SELECT productId,name,unitLength,quantity,weight,unitPriceLocal from "+this.tableName+" WHERE name= '"+String.valueOf(j1.getSelectedItem())+"'");
            
            
            while(result.next())
            {
                pid=result.getString("productId");
                productName=result.getString("name");
                l=Integer.valueOf(result.getString("unitLength"));
                q=Integer.valueOf(result.getString("quantity"));
                w=Integer.valueOf(result.getInt("weight"));
                up=Double.parseDouble(result.getString("unitPriceLocal"));             
               
              
            }

        
      
         double orderTotal=0;
        
        
        double subAmount=(Integer)spin.getValue()*(((up))); 
        double discount=((Integer)spin.getValue()*(((up)))*(Double.parseDouble(String.valueOf(j2.getSelectedItem())))/100.0);
        if(Integer.valueOf(q) >= (Integer) spin.getValue()  ){
            
            Object in[]={pid,productName,up,l,w,spin.getValue(),subAmount,subAmount-discount};
            DefaultTableModel m= (DefaultTableModel) model.getModel();//fill table moodel
            m.addRow(in);
            
            
                for (int i = 0; i < model.getRowCount(); i++){//increment total order amount
                    
                    double amount = Double.parseDouble((String.valueOf(model.getValueAt(i,7))));
                    orderTotal += amount;
            }
            total.setText(String.valueOf(orderTotal));//set Total amount
            count.setText(String.valueOf(model.getRowCount())+" Item/s added");//set number of items added
        }
        
        else{
            JOptionPane.showMessageDialog(comboName, "No sufficient Stock in Warehouse", "Warning", JOptionPane.WARNING_MESSAGE);
        }
         
        
            
            
        }
        catch(SQLException e){
            System.out.println(e.getStackTrace());
        }
    }


     
public String getOrderCustomer(){
    
        String s="";
          
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            ResultSet result;
            Statement stmnt;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select companyName from "+this.tableName+" ,largescaleorder  WHERE largescaleorder.orderId='"+this.columnName+"' AND  largescaleorder.companyId=largescalecustomer.companyId ");
            
            while(result.next())
            {
                s=result.getString("companyName");
            }
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
        }
        return s;
}




    public String getCompanyType(String Id){
    
        String type="";
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
            result=stmnt.executeQuery("SELECT cutomerType from "+this.tableName+" WHERE companyId= '"+Id+"' " );
            
                    while(result.next())
                    {
                        type=result.getString("cutomerType");
                       
                    }            
        }
        catch(Exception e){
        }   
        
        return type;
    }
    
    
     public String getEmployeeId(String user){
    
        String id="";
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
            result=stmnt.executeQuery("SELECT employeeId from employee,occupation WHERE jobName= '"+user+"' AND employee.jobId=occupation.jobId ");
            
                    while(result.next())
                    {
                        id=result.getString("employeeId");
                       
                    }            
        }
        catch(Exception e){
        }   

           return id;
      }         

     
     
     
     public void insertOrder(String orderId,String orderDate,String orderType,String shipmentStatus,String employeeId,String companyId,String discount,double total){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("INSERT INTO largescaleorder (orderId,orderDate,orderType,shipmentStatus,employeeId,companyId,discountRate,totalOrderAmount) VALUES (?,?,?,?,?,?,?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, orderId);
            pstmt.setString(2,orderDate);
            pstmt.setString(3, orderType);
            pstmt.setString(4,shipmentStatus);
            pstmt.setString(5, employeeId);
            pstmt.setString(6, companyId);
            pstmt.setString(7, discount);
            pstmt.setDouble(8, total);

            
            pstmt.executeUpdate();
            
            
            
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
        }
    
    }
     
     public void insertLargeOrderGoods(String orderId,String productId,int qty){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("INSERT INTO largescaleordergood VALUES (?,?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, orderId);
            pstmt.setString(2,productId);
            pstmt.setInt(3,qty );

            pstmt.executeUpdate();
         
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
            System.out.println(e);
        }
    
   
    }
     
     
     public void updateField(String field,String value,String id){
    
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt;
            stmnt=c.con.createStatement();
            stmnt.executeUpdate("UPDATE   "+this.tableName+" set "+field+" = '"+value+"'  WHERE "+this.columnName+"='"+id+"' ");
             
            
        }
        catch(Exception e){
        }   
        
    }

     
     
     
    public void fillOrderTableOnCondition(JTable formTable,String value)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select orderId AS 'Order Id',companyId as 'Company Id',orderDate AS 'Order Date',orderType AS 'Order Type',status AS 'Order Status',shipmentDate AS 'Shipment Date',shipmentStatus AS 'Shipment Status', deliveryEmailStatus as 'Delivery Email Status',"
                    + "invoiceEmailStatus AS 'Invoice Email Status',discountRate AS 'Discount Rate',totalOrderAmount AS 'Order Total' from "+this.tableName+" WHERE "+this.columnName+"= '"+value+"' ");
                   
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
        
            System.out.println(e);
        }
    }
    
    
    public void fillCustomerTableOnCondition(JTable formTable,String value)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select companyId As 'Company ID',companyName AS 'Company Name',cutomerType AS 'Company Type',telephone AS 'Point Of Contact',email As 'Company Email',country As Country,city AS City,"
                    + "postalCode AS 'Postal Code',address AS 'Address',status AS 'Company Status' from "+this.tableName+" WHERE companyId='"+value+"'");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
    
    
    
    
    public void fillUpdateOrderItems(String value,JTable formTable)
    {
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select * from "+this.tableName+" WHERE orderId= '"+value+"'");
          
            formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public void UpdateOrderItem(JComboBox j1,JTable model,JSpinner spin,JTextField total,JLabel count,JComboBox discountRate){
    
    
        String pid="",n="";
        long subAmount;
        double up=0;
        int l=0,w=0,q=0;
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("SELECT productId,name,unitLength,quantity,weight,unitPriceLocal from "+this.tableName+" WHERE name= '"+j1.getSelectedItem()+"'");
            
            
            while(result.next())
            {
                pid=result.getString("productId");
                n=result.getString("name");
                l=Integer.valueOf(result.getInt("unitLength"));
                q=Integer.valueOf(result.getInt("quantity"));
                w=Integer.valueOf(result.getInt("weight"));
                up=Double.parseDouble(result.getString("unitPriceLocal")); 
                    
            }

        
        double orderTotal=0;
        //subAmount=(new Double((Integer)spin.getValue()*(((up)))).longValue()); 
         //double discount=((Integer)spin.getValue()*(((up)))*(Double.parseDouble(String.valueOf(discountRate.getSelectedItem())))/100.0);
            
        if(Integer.valueOf(q) >= ((Integer) spin.getValue())){
            
        Object in[]={pid,n,up,l,w,spin.getValue(),(new Double((Integer)spin.getValue()*(((up)))).longValue()),
        ((new Double((Integer)spin.getValue()*(((up)))).longValue())-((Integer)spin.getValue()*(((up)))*(Double.parseDouble(String.valueOf(discountRate.getSelectedItem())))/100.0))};
            
        DefaultTableModel m= (DefaultTableModel) model.getModel();//fill table moodel
        m.addRow(in);
            
            
            
                for (int i = 0; i < model.getRowCount(); i++){//increment total order amount
                    
                    double amount = Double.parseDouble((String.valueOf(model.getValueAt(i,7))));
                    orderTotal += (new Double(amount)).longValue();
                }
            total.setText(String.valueOf((new Double(orderTotal)).longValue()));//set Total amount
            count.setText(String.valueOf(model.getRowCount())+" Item/s added");//set number of items added
        }
        
        else
            JOptionPane.showMessageDialog(comboName, "No sufficient Stock in Warehouse", "Warning", JOptionPane.WARNING_MESSAGE);
            
         
        
            
            
        }
        catch(Exception e){
        }
    }
    
 
    
     public void UpdatetOrder(String productId,String qty){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("UPDATE  largescaleordergood  SET (productId,quantity) VALUES (?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, productId);
            pstmt.setString(2,qty);
        
            
            pstmt.executeUpdate();
            
            
            
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
        } 
    
    
}


public void deleteLargescaleOrderGood(String orderId,String productId){
        
    
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("DELETE from  largescaleordergood  WHERE orderId=? AND productId=?");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1, orderId);
            pstmt.setString(2,productId);
        
            pstmt.executeUpdate();

            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
        } 
    

     
}



    

    
    public void fillTableShipment(JTable formTable)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select orderId AS 'Order Id',orderDate As 'Order Date',orderType As 'Order Type',status AS 'Status',shipmentDate as 'Shipment Date',shipmentStatus as 'Shipment Status', "
                    + "companyId As 'Company',discountRate AS 'Discount Rate',totalOrderAmount as 'Total Amount' from "+this.tableName+" WHERE orderType='foreign' AND shipmentDate IS null AND status='confirmed' ");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
     public void insertInvoice(String invId,String invDate,double amount,String type,String orderId){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        
        String query,query1;
        PreparedStatement pstmt,pstmt1;
        
        try{
            query=("Insert Into invoice (invoiceNo,invoiceDate,amount,invoiceType) VALUES(?,?,?,?)");
            
            query1=("INSERT into largeordergoodinvoice (orderId,invoiceNo) VALUES(?,?)");
            pstmt=dbcon.con.prepareStatement(query);
            pstmt1=dbcon.con.prepareStatement(query1);
            
            pstmt.setString(1, invId);
            pstmt.setString(2,invDate);
            pstmt.setDouble(3, amount);
            pstmt.setString(4,type);
            
            
            pstmt1.setString(1,orderId);
            pstmt1.setString(2, invId);
            pstmt.executeUpdate();
            pstmt1.executeUpdate();
            
            
            
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
            System.out.println(e);
        }
     }
    
    public void fillOrderDetails(JTable formTable,String value)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select * from VW_LargeScaleOrderItems WHERE orderId='"+value+"'");                   
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
        
            System.out.println(e);
        }
    }

public String returnInvoiceNo(String orderId)
    {
         String inv=""; 
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select invoiceNo from largeordergoodinvoice WHERE orderId='"+orderId+"'");
           
            while(result.next()){
                         inv= result.getString("invoiceNo");
                       
                    }            
            
        }
        catch(Exception e){
            
        }
        return  inv;
    }
    


public void fillTableLargeScaleOrderInvoice(JTable formTable)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("Select orderId AS 'Order Id',orderDate AS 'Order Date',orderType AS 'Order Type',status AS 'Order Status',shipmentDate AS 'Shipment Date',shipmentStatus AS 'Shipment Status', deliveryEmailStatus as 'Delivery Email Status',"
                    + "invoiceEmailStatus AS 'Invoice Email Status',discountRate AS 'Discount Rate',totalOrderAmount AS 'Order Total' from "+this.tableName+" WHERE status='confirmed' ");
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    

public void UpdatetOrderDetailsLocal(String orderId,String invEmailStatus,String DeliveryEmail,String status){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        System.out.println(orderId);
        System.out.println(invEmailStatus);
        System.out.println(DeliveryEmail);
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("UPDATE  largescaleorder  SET invoiceEmailStatus=? , deliveryEmailStatus=? ,status=? WHERE orderId='"+orderId+"'");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1,invEmailStatus);
            pstmt.setString(2,DeliveryEmail);
            pstmt.setString(3,status);
            
            pstmt.executeUpdate();
            
            
            
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
            System.out.println(e);
        } 
}
        
        
        public void UpdatetOrderDetailsForeign(String orderId,String invEmailStatus,String DeliveryEmail,String Date,String SStatus,String status){
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        String query;
        PreparedStatement pstmt;
        
        try{
            query=("UPDATE  largescaleorder  SET invoiceEmailStatus=? , deliveryEmailStatus=?,shipmentDate=?,shipmentStatus=? ,status=? WHERE orderId='"+orderId+"'");
            pstmt=dbcon.con.prepareStatement(query);
            
            pstmt.setString(1,invEmailStatus);
            pstmt.setString(2,DeliveryEmail);
            pstmt.setString(3,Date);
            pstmt.setString(4,SStatus); 
            pstmt.setString(5,status); 
            pstmt.executeUpdate();
            
            
            dbcon.con.close();
            pstmt.close();

        } 
        catch (Exception e) {
            System.out.println(e);
        } 
}
    
     }
    

     


