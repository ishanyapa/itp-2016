/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PurchaseManagement;

import RootElement.DbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Samitha Heanthenna
 */
public class DbAccessPurchase {
    
    private String tableName;
    private String columnName;
    private char prefix;
    private JComboBox comboName;
    private JTable formTable;
    private String value;
    private String value2FNC;
    private String primeName;
    private String primeVal;
    private JLabel countlb;
    private String newvalue;
    private String primeNamepar;
    private String primeValpar;
    
    public DbAccessPurchase(){
    }
    
    public DbAccessPurchase(String tableName){
        this.tableName=tableName;
    }
    
    public DbAccessPurchase(String tableName, String column){
        this.tableName=tableName;
        this.columnName=column;
    }
    
    public DbAccessPurchase(String tableName, String column, char prefixp){
        this.tableName=tableName;
        this.columnName=column;
        this.prefix=prefixp;
    }
    public DbAccessPurchase(String tableName, String column, String value2p){
        this.tableName=tableName;
        this.columnName=column;
        this.value2FNC=value2p;
    }
    public DbAccessPurchase(String tableName, String column, String newval, String primeNp,String primevalue){
        this.tableName=tableName;
        this.columnName=column;
        this.primeName=primeNp;
        this.primeVal=primevalue;
        this.newvalue=newval;
    }
    
     public DbAccessPurchase(String tableName, String column, String newval, String primeNp,String primevalue, String primeNppar,String primevaluepar){
        this.tableName=tableName;
        this.columnName=column;
        this.primeName=primeNp;
        this.primeVal=primevalue;
        this.newvalue=newval;
        this.primeNamepar=primeNppar;
        this.primeValpar=primevaluepar;
    }
   
    public void fillCombo(JComboBox JCombo){
        this.comboName=JCombo;
          try{
                DbConnect c=new DbConnect();
                c.setConnection();
                
                Statement stmnt=c.con.createStatement();
                ResultSet result=stmnt.executeQuery("select "+this.columnName+" from "+this.tableName+" ");
                
                
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

    public void fillTable(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select * from "+this.tableName+" ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTable();
        }
            catch(Exception e){
            }
    }
    public void getcountfillTable(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("Select count(*) from "+this.tableName+" ");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void itemListTable1(JTable formTable , String val ,JLabel count){
        this.formTable=formTable;
        this.value=val;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select supplierId as 'Supplier ID',itemId as 'Item ID',price as Price from "+this.tableName+" where "+this.columnName+" like '"+this.value+"'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountSelectedOnly();
            
        }
            catch(Exception e){
            }
    }
    
    
    public void getcountSelectedOnly(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(*) from "+this.tableName+" where "+this.columnName+" like '"+this.value+"'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillNextCombo(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("Select itemId from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"'");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("itemId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillNextCombo2(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("Select purchaseId from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"'");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("purchaseId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
     public void fillNextCombo3(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("select purchaseId from "+this.tableName+" where purchaseVia like 'Foreign' and "+this.columnName+" = '"+this.value2FNC+"'");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("purchaseId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
     
     public void fillNextCombo4(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("select purchaseId from "+this.tableName+" where purchaseVia like 'Local' and "+this.columnName+" = '"+this.value2FNC+"'");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("purchaseId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
      
    public void fillTableLocalPur(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select purchaseId as 'Purchase ID' ,purchaseDate as 'Date Purchased',quantity as Quentity,status as Status,paymentMethod as 'Payment Type',purchaseType as 'Purchase Type',itemId as 'Item ID' from "+this.tableName+" where purchaseVia like 'Local'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTableLocalPur();
        }
            catch(Exception e){
            }
    }
    
    public void fillTableLocalPurSearch(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select purchaseId as 'Purchase ID' ,purchaseDate as 'Date Purchased',quantity as Quentity,status as Status,paymentMethod as 'Payment Type',purchaseType as 'Purchase Type',itemId as 'Item ID' from "+this.tableName+" where purchaseVia like 'Local' and "+this.columnName+" like '"+this.value2FNC+"%'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTableLocalPurSearch();
        }
            catch(Exception e){
            }
    }
     public void fillTableForeignPurSearch(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select purchaseId as 'Purchase ID' ,purchaseDate as 'Date Purchased',quantity as Quentity,status as Status,paymentMethod as 'Payment Type',purchaseType as 'Purchase Type',itemId as 'Item ID',lcNo as 'LC No' from "+this.tableName+" where purchaseVia like 'Foreign' and "+this.columnName+" like '"+this.value2FNC+"%'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTableForeignPurSearch();
        }
            catch(Exception e){
            }
    }
    public void getcountfillTableLocalPur(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("Select count(*) from "+this.tableName+" where purchaseVia like 'Local'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    public void getcountfillTableLocalPurSearch(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("Select count(*) from "+this.tableName+" where purchaseVia like 'Local' and "+this.columnName+" like '"+this.value2FNC+"%'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void getcountfillTableForeignPurSearch(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("Select count(*) from "+this.tableName+" where purchaseVia like 'Foreign' and "+this.columnName+" like '"+this.value2FNC+"%'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void updateOneFeild(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("update "+this.tableName+" set "+this.columnName+" = '"+this.newvalue+"' where "+this.primeName+" = '"+this.primeVal+"' ");
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillTableForignPur(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select purchaseId as 'Purchase ID' ,purchaseDate as 'Date Purchased',quantity as Quentity,status as Status,paymentMethod as 'Payment Type',purchaseType as 'Purchase Type',itemId as 'Item ID',lcNo as 'LC No' from "+this.tableName+" where purchaseVia like 'Foreign'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTableForignPur();
        }
            catch(Exception e){
            }
    }
    
    public void getcountfillTableForignPur(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("Select count(*) from "+this.tableName+" where purchaseVia like 'Foreign'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    public void viewDirectSales(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select salesId as 'Sales ID',cutomerName as 'Customer Name',paymentMethod as 'Payment Method',email as Email, telephone as Telephone, salesPrice as 'Sales Price' from "+this.tableName+" ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTable();
        }
            catch(Exception e){
            }
    }
    
    public void viewDirectSalesSelected(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select salesId as 'Sales ID',cutomerName as 'Customer Name',paymentMethod as 'Payment Method',email as Email, telephone as Telephone, salesPrice as 'Sales Price' from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"%' ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountDirectSalesSelected();
        }
            catch(Exception e){
            }
    }
    
    public void getcountDirectSalesSelected(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(salesId) from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"%'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillTableReturn(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select purchaseId as 'Purchase ID',purchaseType as 'Purchase Type',purchaseVia as 'Purchase Via'  from "+this.tableName+" where status like 'Received'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTablereturn();
        }
            catch(Exception e){
            }
    }
    
    public void getcountfillTablereturn(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(purchaseId) from "+this.tableName+" where status like 'Received'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillNextComboreturn(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("Select purchaseId from "+this.tableName+" where status like 'Received'");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("purchaseId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void viewReturns(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select returnId as 'Return ID',purchaseId as 'Purchase ID',returnDate as 'Return Date',reason as Reason from "+this.tableName+" ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            viewReturnscount();
        }
            catch(Exception e){
            } 
    }
    
    public void viewReturnscount(){
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(returnId) from "+this.tableName+" ");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void viewReturnsSearch(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select returnId as 'Return ID',purchaseId as 'Purchase ID',returnDate as 'Return Date',reason as Reason from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"%'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            viewResultCountSerch();
        }
            catch(Exception e){
            }
    }
    
    public void viewResultCountSerch(){
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(returnId) from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"%'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void viewSuplierDetailsOnTBL(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select supplierId as 'Supplier ID',companyName as 'Company Name',specialization as Specialization from "+this.tableName+" ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            viewSuplierDetailsOnTBLcount();
        }
            catch(Exception e){
            }
    }
    
    public void viewSuplierDetailsOnTBLcount(){
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(*) from "+this.tableName+" ");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void viewSuplierItemsOnTBL(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select itemId as 'Item ID',itemName as 'Item Name', price as Price,supplierId as 'Supplier ID' from "+this.tableName+" ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            viewSuplierItemsOnTBLcount();
        }
            catch(Exception e){
            }
    }
    
    public void viewSuplierItemsOnTBLcount(){
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(*) from "+this.tableName+" ");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void viewSuplierItemsOnTBLserch(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select itemId as 'Item ID',itemName as 'Item Name', price as Price,supplierId as 'Supplier ID' from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"%'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            viewSuplierItemsOnTBLserchCo();
        }
            catch(Exception e){
            }
    }
    
     public void viewSuplierItemsOnTBLserchCo(){
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(itemId) from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"%'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
     
    public void updateOneFeildWithpartial(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("update "+this.tableName+" set "+this.columnName+" = '"+this.newvalue+"' where "+this.primeName+" = '"+this.primeVal+"' and "+this.primeNamepar+" = '"+this.primeValpar+" ");
            
            stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void addLocalPurchase(String par1,String par2,String par3,int par4,String par5,String par6,String par7,String par8,String par9){
            
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("insert into purchase (purchaseId, purchaseDate, purchaseVia, quantity, status, paymentMethod, purchaseType, employeeId, itemId) VALUES ('"+par1+"','"+par2+"','"+par3+"','"+par4+"','"+par5+"','"+par6+"','"+par7+"','"+par8+"','"+par9+"')");
            
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
    
    public void addForeignPurchase(String par1,String par2,String par3,int par4,String par5,String par6,String par7,String par8,String par9,String par10,String par11,String par12,String par13){
            
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("insert into purchase (purchaseId, purchaseDate, purchaseVia, quantity, status, paymentMethod, purchaseType,lcDate ,branchCode ,bank ,lcNo , employeeId, itemId) VALUES ('"+par1+"','"+par2+"','"+par3+"','"+par4+"','"+par5+"','"+par6+"','"+par7+"','"+par8+"','"+par9+"','"+par10+"','"+par11+"','"+par12+"','"+par13+"')");
            
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
    
    public void remove(){      
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("delete from "+this.tableName+" where "+this.columnName+" = '"+this.value2FNC+"' ");
            
            
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void itemListTablerequest(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select requestId as 'Request ID',requestDate as 'Request Date',quantity as Quantity,status as Status from "+this.tableName+" where status like 'Unassigned'");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            itemListTablerequestCo();
            
        }
            catch(Exception e){
            }
    }
    public void itemListTablerequestCo(){
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            ResultSet result=stmnt.executeQuery("select count(requestId) from "+this.tableName+" where status like 'Unassigned'");
                
                
                while(result.next()) 
                {
                    int val =  ((Number)result.getObject(1)).intValue();
                    this.countlb.setText(val+" Maching record(s) found");
                }      
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillComboRequest(JComboBox JCombo){
        this.comboName=JCombo;
          try{
                DbConnect c=new DbConnect();
                c.setConnection();
                
                Statement stmnt=c.con.createStatement();
                ResultSet result=stmnt.executeQuery("select requestId from purchaserequest where status like 'Unassigned' ");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("requestId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
               
                stmnt.close();
                c.con.close();
           }
    
         catch(Exception e){
         }
    }
    
    public void addDirectSales(String par1,String par2,Double par3,String par4,String par5,String par6,String par7,String par8){
            
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("insert into directsale (salesId, cutomerName, salesPrice, paymentMethod, email, telephone, purchaseId, employeeId) VALUES ('"+par1+"','"+par2+"','"+par3+"','"+par4+"','"+par5+"','"+par6+"','"+par7+"','"+par8+"')");
            
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
    
    public void addReturnItems(String par1,String par2,String par3,String par4,String par5,String par6){
            
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("insert into returnitem (returnId, returnDate, reason, description, employeeId, purchaseId) VALUES ('"+par1+"','"+par2+"','"+par3+"','"+par4+"','"+par5+"','"+par6+"')");
            
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
    
     public void addSupplierItems(String par1,String par2,String par3,String par4){
            
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("insert into itemlist (itemId, supplierId, itemName, price) VALUES ('"+par1+"','"+par2+"','"+par3+"','"+par4+"')");
            
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
     
    public void fillTableSupplierManagement(JTable formTable,JLabel count){
        this.formTable=formTable;
        this.countlb=count;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery("select supplierId as 'Supplier Id', supplierName as 'Supplier Name' from "+this.tableName+" ");
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
            
            getcountfillTable();
        }
            catch(Exception e){
            }
    }
    public void addSupplier(String par1,String par2,String par3,String par4,String par5,String par6,String par7,String par8){
            
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
            Statement stmnt=c.con.createStatement();
            stmnt.executeUpdate("insert into supplier (supplierId, supplierName, companyName, address, telephone, email,specialization,supplyType) VALUES ('"+par1+"','"+par2+"','"+par3+"','"+par4+"','"+par5+"','"+par6+"','"+par7+"','"+par8+"')");
            
                
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
    }
    
    public void fillNextComboreturnreport(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("Select returnId from "+this.tableName+" ");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("returnId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    public void fillNextCombopurreport(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("Select purchaseId from "+this.tableName+" ");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("purchaseId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
       
    }
    public void fillNextComboview(JComboBox JCombo){
        this.comboName=JCombo;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           Statement stmnt=c.con.createStatement();
           ResultSet result=stmnt.executeQuery("Select purchaseId from "+this.tableName+" where "+this.columnName+" like '"+this.value2FNC+"' and status like 'Received'");
                
                
                while(result.next()) {
                  
                    String iName=result.getString("purchaseId");
                    comboName.addItem(iName);                    
                }           
                comboName.setSelectedIndex(-1);
                stmnt.close();
                c.con.close();
        }
            catch(Exception e){
            }
    }
    
    
}


