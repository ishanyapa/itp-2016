/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

/**
 *
 * @author user
 */
import RootElement.DbConnect;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.transform.Result;
import net.proteanit.sql.DbUtils;


public class TechnicalServiceDbAcess {
    
    private String tableName;
    private String columnName;
    private JComboBox comboName;
    private String condition;
    ResultSet result;
    private JTable formTable;
    String sql;
    
 // constructors   
public TechnicalServiceDbAcess(){}
 
public TechnicalServiceDbAcess(String tableName){
        this.tableName=tableName;
    }
    
public TechnicalServiceDbAcess(String tableName,String columnName){
      this.tableName=tableName;
      this.columnName=columnName;
    }
    

    
public void fillComboBox(JComboBox JCombo)
    {
        this.comboName=JCombo;
         
            try{
                  DbConnect c = new DbConnect();
                  c.setConnection();
                  

                  Statement stmnt=c.con.createStatement();
                  
                  ResultSet result=stmnt.executeQuery("Select "+this.columnName+" from "+this.tableName+" ");


                  while(result.next()) {

                      String lName=result.getString(this.columnName);
                      comboName.addItem(lName);                    
                      
                      
                  }
                  comboName.setSelectedIndex(-1);

                  stmnt.close();
                  c.con.close();
             }

         catch(Exception e){
         }        
    }
public void setTechnicionID(JComboBox jCombo){
          
          
        String sql = "select employeeId from employee e,occupation o where e.jobId = o.jobId AND o.jobName = 'Technical Assistant'";  
          
          try{
              DbConnect c = new DbConnect();
              c.setConnection();
                  

              Statement stmnt=c.con.createStatement();
              ResultSet result=stmnt.executeQuery(sql);
              
              while(result.next()) {

                      String id=result.getString("employeeId");
                      jCombo.addItem(id);                    
                  }
             
              
              stmnt.close();
              c.con.close();
              comboName.setSelectedIndex(-1);
          }
          catch(Exception e){
          }
      }

public void addMachine(String machineId,String location,String date,String type){
        try{
      
            DbConnect c = new DbConnect();
            c.setConnection();
            Statement stmnt=c.con.createStatement();
          
            String sql = "INSERT INTO "+this.tableName+" VALUES ('"+machineId+"','"+location+"','"+date+"','"+type+"')";
         
            stmnt.executeUpdate(sql);
            c.con.close();
          
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
public String GetIncrementedId(String tableName,String columnName){
        
      
        
        
        String id ="";
        String incrId="";
        try{
            DbConnect c = new DbConnect();
            c.setConnection();
            Statement stmnt;
            ResultSet rslt;
            stmnt=c.con.createStatement();
            rslt=stmnt.executeQuery("Select "+columnName+" from "+tableName+" order by "+columnName);
            
            while(rslt.next()){
                id = rslt.getString(columnName);
                
            }
            IdIncrement obtIdIncr = new IdIncrement();
            obtIdIncr.Increment(id, 3);
            incrId = obtIdIncr.Increment(id, 3);
            
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
            
        }
        return incrId;
        
    }
  
public void addComplain(String complainId,String itemId,String date,String status,String discription,String faultType,String employeeId,String technicion){
    
    DbConnect c = new DbConnect();
    c.setConnection();
               
    sql = "INSERT INTO " + "complain " + " VALUES ('" + complainId + "','" + itemId + "','" + date + "','" + status + "','" + discription + "','" + faultType +"','"+employeeId +"','"+technicion+"')";      
       
        try{
            Statement stmnt;
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
            System.out.println(e);
       
        }
  }
 
public void addMaintainance(String mainatainanceId,String itemId,String date,int repairPeriod,String discription){
      
       DbConnect c = new DbConnect();
       c.setConnection();
       
       String sql = "INSERT INTO maintenance VALUES ('"+ mainatainanceId +"','"+itemId.toUpperCase()+"','"+date+"',"+repairPeriod+",'"+discription+"')";
       
       try{
            Statement stmnt;
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
       
      }
      
public void addSuggestion(String suggestionId,String date,String description,String itemId,String employeeId){
      
       String sql = "INSERT INTO suggestion  VALUES ('"+suggestionId +"','"+date+"','"+description+"','"+itemId.toUpperCase()+"','"+employeeId.toUpperCase()+"')";
       
       try{
           DbConnect c = new DbConnect();
            c.setConnection();
           
            Statement stmnt;
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
        
        }
       
      }
    
 public void getdiscription(String id,JTextArea txtArName,String idName){
        
       try{
               DbConnect c=new DbConnect();
               c.setConnection();
                
            
               Statement stmnt;
               stmnt=c.con.createStatement();
                  String sql = "select description from "+ this.tableName + " where "+idName+" = '"+id +"'";
                  
               result=stmnt.executeQuery(sql);
               
               while(result.next()){
               txtArName.setText(result.getString("description"));
               }
                stmnt.close();
                c.con.close();
                
          }
          catch(Exception e){
              System.out.println(e);
          }
     
     
     
       
   }
  
public void fillTable(JTable formTable, String sql)
    {
        this.formTable=formTable;
        
        try{
            DbConnect c=new DbConnect();
            c.setConnection();
                
           
            Statement stmnt;
            ResultSet result;
            stmnt=c.con.createStatement();
               
            result=stmnt.executeQuery(sql);
            
            this.formTable.setModel(DbUtils.resultSetToTableModel(result));
          
        }
        catch(Exception e){
        }
    }     
public void loadMachineDetails(String macId,JTextField machineId,JTextField location,JTextField purchaseDate,JTextField type){
         
         String sql = "SELCT * FROM machinery where machineId ='"+macId+"'";
         try{
             
             DbConnect c = new DbConnect();
             c.setConnection();
             Statement stmnt=c.con.createStatement();
             //fill text Field
             ResultSet result=stmnt.executeQuery(sql);
             machineId.setText(result.getString("machineId"));
             location.setText(result.getString("location"));
             purchaseDate.setText(result.getString("purchaseDate"));
             type.setText(result.getString("type"));
              
             
              stmnt.close();
              c.con.close();
         }
         catch(Exception e){
         
         }
         
     }

public void updateMachineDetails(String machineId,String location,String purchaseDate,String type ){
         
         String sql = "UPDATE machinery SET location = '" +location +"',purchaseDate = '"+purchaseDate+"',type = '"+type+"' where machineId = '"+machineId+"'";
         try {
             DbConnect c = new DbConnect();
             c.setConnection();
             Statement stmnt=c.con.createStatement();
             stmnt.executeUpdate(sql);
             
             stmnt.close();
              c.con.close();
         
         }
         catch(Exception e){}
    
     }
  
public void createJob(String jobId,String date,String discription,String complainId){
    
         String sql = "INSERT INTO JOB VALUES ('"+jobId+"','"+date+"','"+discription+"','"+complainId+"')";
         
          try{
           DbConnect c = new DbConnect();
            c.setConnection();
           
            Statement stmnt;
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
     }
     
public void resetMaintainananceDate(String maintenanceId){
        
         String date="";
         String repairPeriod="";
         String sqlGetDate ="SELECT repairDate,repairPeriod from maintenance where maintenanceId='"+maintenanceId+"'";
               
         try{
              DbConnect c = new DbConnect();
              c.setConnection();
           
              Statement stmnt;
            
              stmnt=c.con.createStatement();
            
              ResultSet resultDate=stmnt.executeQuery(sqlGetDate);
          
            while(resultDate.next())
            {
                 date = resultDate.getString("repairDate");
                 repairPeriod = resultDate.getString("repairPeriod");
            
            } 
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(sdf.parse(date));
                 cal.add(Calendar.MONTH, Integer.parseInt(repairPeriod));
            
            
                 String da=(sdf.format(cal.getTime()));
            
                 Statement stmnt2;
                 stmnt2=c.con.createStatement();
                 String sqlReset = "UPDATE maintenance SET repairDate ='"+sdf.format(cal.getTime())+"' where maintenanceId ='"+maintenanceId+"'";
                 stmnt2.executeUpdate(sqlReset);
            
         }
         catch(Exception e){
             System.out.println(e);
         }
     
     }
     
public void addJob(JTextField jobId,JTextField complainId,JTextArea discription) {
         
          
             
             
         String insert=("insert into job values(?,?,?,?)");
            
         try{
              DbConnect c = new DbConnect();
              c.setConnection();
               PreparedStatement pst=c.con.prepareStatement(insert);
               
               pst.setString(1,jobId.getText());
               pst.setString(2,dateAndTime.getDateAndTime("yyyy-MM-dd"));
               pst.setString(3,discription.getText());
               pst.setString(4,complainId.getText());
               
               pst.executeUpdate();
            
         }
         catch(Exception e){
             System.out.println(e);
        
         }
         
     }

public void setStatus(String complainId,String status){
    
    String sql = "UPDATE complain SET status = '"+status+"'where complainId ='"+complainId+"'";
    try{
          DbConnect c = new DbConnect();
          c.setConnection();
           
          Statement stmnt;
            
          stmnt=c.con.createStatement();
          stmnt.executeUpdate(sql);
          
          
    }
    catch(Exception e){
        System.out.println(e);
    }
}
  
public void deleteSuggestion(String sugId){
    
        String sql="DELETE FROM suggestion WHERE suggestionId = '"+sugId+"'";
        
        try{
            DbConnect c = new DbConnect();
              c.setConnection();
           
            Statement stmnt;
            
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
   
public void deleteMachine(String machineId){
    
        String sql="DELETE FROM machinery WHERE machineId = '"+machineId+"'";
        
        try{
            DbConnect c = new DbConnect();
              c.setConnection();
           
            Statement stmnt;
            
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
         }
        
public void deleteMaintenance(String maintenanceId){
    
        String sql="DELETE FROM maintenance WHERE maintenanceId = '"+maintenanceId+"'";
        
        try{
            DbConnect c = new DbConnect();
              c.setConnection();
           
            Statement stmnt;
            
            stmnt=c.con.createStatement();
            stmnt.executeUpdate(sql);
            
            stmnt.close();
            c.con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
       
public String generateId(String type,String tableName , String columnName){
     int  id = 0;
    sql = "select "+ columnName + " from "+ tableName + " ORDER BY "+columnName+" DESC LIMIT 1";
        
    try{
        DbConnect c=new DbConnect();
        c.setConnection();
                
        Statement stmnt;
        stmnt=c.con.createStatement();
             
        result = stmnt.executeQuery(sql);
             
        while(result.next()){
        id = Integer.parseInt(result.getString("complainId"));
        }
                
        stmnt.close();
        c.con.close();
                
        }
        catch(Exception e){
            System.out.println(e);
        }
    return type + ++id;
    }

public void searchingComplain(JTable tableName,String keyWord){
    //choose field
    textValidator obtSearching = new textValidator();
    String searchField = obtSearching.searchComValidation(keyWord);
    
    
     String sqlAll= "SELECt complainId AS 'Complain ID',itemId AS 'Item ID',complainDate AS 'Complain Date',status AS 'Status',fault AS Fault,employeeId AS 'Employee ID',technician  AS Technicion FROM complain";
    String sqlComId= "SELECt complainId AS 'Complain ID',itemId AS 'Item ID',complainDate AS 'Complain Date',status AS 'Status',fault AS Fault,employeeId AS 'Employee ID',technician  AS Technicion FROM complain where complainId like '"+keyWord+ "%' OR itemId like '"+keyWord+ "%'";
    String sqlComDate= "SELECt complainId AS 'Complain ID',itemId AS 'Item ID',complainDate AS 'Complain Date',status AS 'Status',fault AS Fault,employeeId AS 'Employee ID',technician  AS Technicion FROM complain where complainDate like '"+keyWord+ "%'";
    String sqlItemId= "SELECt complainId AS 'Complain ID',itemId AS 'Item ID',complainDate AS 'Complain Date',status AS 'Status',fault AS Fault,employeeId AS 'Employee ID',technician  AS Technicion FROM complain where itemId like '"+keyWord+ "%'";
    String sqlEmpId= "SELECt complainId AS 'Complain ID',itemId AS 'Item ID',complainDate AS 'Complain Date',status AS 'Status',fault AS Fault,employeeId AS 'Employee ID',technician  AS Technicion FROM complain where employeeId like '"+keyWord+ "%' OR technician like '"+keyWord+"%'";
       
    //searching and filing the table
   
        switch(searchField){
            case "complain":
                fillTable(tableName, sqlComId);
                break; 
            case "itemId":
                fillTable(tableName, sqlItemId);
                break;
            case "date":
                fillTable(tableName, sqlComDate);
                break;
            case "employeeId":
                fillTable(tableName, sqlEmpId);
                break;
            default:
                fillTable(tableName,sqlItemId);
        }
    
    
}

public void searchingJob(JTable tableName,String keyWord){

    //choose field
    textValidator obtSearching = new textValidator();
    String searchField = obtSearching.searchJobValidation(keyWord);
   

    String sqlItemId = "select j.jobId as 'Job ID',c.itemId as 'Item ID',j.jobDate as 'Job Date',j.complainId as 'Complain ID' ,c.status as 'Status',c.technician as 'Technician Id',c.employeeId as 'Employee Id' from job j, complain c where j.complainId = c.complainId AND c.itemId like '"+keyWord+ "%'";
    String sqlJobId = "select j.jobId as 'Job ID',c.itemId as 'Item ID',j.jobDate as 'Job Date',j.complainId as 'Complain ID' ,c.status as 'Status',c.technician as 'Technician Id',c.employeeId as 'Employee Id' from job j, complain c where j.complainId = c.complainId AND J.jobId like '"+keyWord+ "%'";
    String sqlJobDate = "select j.jobId as 'Job ID',c.itemId as 'Item ID',j.jobDate as 'Job Date',j.complainId as 'Complain ID' ,c.status as 'Status',c.technician as 'Technician Id',c.employeeId as 'Employee Id' from job j, complain c where j.complainId = c.complainId AND J.jobDate like '"+keyWord+ "%'";
    String sqlcomplainId = "SELECT j.jobId AS 'Job ID',c.itemId as 'Item ID',j.jobDate AS 'Job Date',j.complainId AS 'Complain ID' ,c.status AS 'Status',c.technician as 'Technician Id',c.employeeId as 'Employee Id' from job j, complain c WHERE j.complainId = c.complainId AND J.complainId like '"+keyWord+ "%'";
    String sqlEmployee = "SELECT j.jobId AS 'Job ID',c.itemId as 'Item ID',j.jobDate AS 'Job Date',j.complainId AS 'Complain ID' ,c.status AS 'Status',c.technician as 'Technician Id',c.employeeId as 'Employee Id' from job j, complain c WHERE j.complainId = c.complainId AND c.employeeId like '"+keyWord+ "%' OR c.technician like '"+keyWord+"%'";
      //searching and filing the table
    
        switch(searchField){
            case "jobId":
                fillTable(tableName, sqlJobId);
                break;
            case "date":
                fillTable(tableName, sqlJobDate);
                break;
                case "employeeId":
                fillTable(tableName, sqlEmployee);
                break;
            case "complain":
                fillTable(tableName, sqlcomplainId);
                break;
            default:
                fillTable(tableName,sqlItemId);
           
         }
    }

public void searchingMain(JTable tableName,String keyWord){

    //choose field
    textValidator obtSearching = new textValidator();
    String searchField = obtSearching.searchMainValidation(keyWord);
    
    
    
    String sqlMainId = "SELECt maintenanceId AS 'Maintenance ID',itemId AS 'Item ID',repairDate AS 'Repair Date',repairPeriod AS 'Repair Period' FROM maintenance where maintenanceId like '"+keyWord+ "%' OR itemId like '"+keyWord+ "%'";
    String sqlRepDate = "SELECt maintenanceId AS 'Maintenance ID',itemId AS 'Item ID',repairDate AS 'Repair Date',repairPeriod AS 'Repair Period' FROM maintenance where repairDate like '"+keyWord+ "%'";
    String sqlItemId = "SELECt maintenanceId AS 'Maintenance ID',itemId AS 'Item ID',repairDate AS 'Repair Date',repairPeriod AS 'Repair Period' FROM maintenance where itemId like '"+keyWord+ "%'";
        
      //searching and filing the table
    
        switch(searchField){
            case "maintenance":
                fillTable(tableName, sqlMainId);
                break;
            case "date":
                fillTable(tableName, sqlRepDate);
                break;
            case "itemId":
                fillTable(tableName, sqlItemId);
                break;
           
         }
    }

public void searchingSugg(JTable tableName,String keyWord){

    //choose field
    textValidator obtSearching = new textValidator();
    String searchField = obtSearching.searchSuggValidation(keyWord);

    
    
    String sqlSuggId = "SELECt suggestionId AS 'Suggestion ID',suggestionDate AS 'Suggestion Date',itemId AS 'Item ID',employeeId AS 'Employee ID' FROM suggestion where suggestionId like '"+keyWord+ "%'OR itemId like '"+keyWord+ "%'";
    String sqlSuggDate = "SELECt suggestionId AS 'Suggestion ID',suggestionDate AS 'Suggestion Date',itemId AS 'Item ID',employeeId AS 'Employee ID' FROM suggestion where suggestionDate like '"+keyWord+ "%'";
    String sqlItemId = "SELECt suggestionId AS 'Suggestion ID',suggestionDate AS 'Suggestion Date',itemId AS 'Item ID',employeeId AS 'Employee ID' FROM suggestion where itemId like '"+keyWord+ "%'";
    String sqlEmpId = "SELECt suggestionId AS 'Suggestion ID',suggestionDate AS 'Suggestion Date',itemId AS 'Item ID',employeeId AS 'Employee ID' FROM suggestion where employeeId like '"+keyWord+ "%'";   
      //searching and filing the table
    
        switch(searchField){
            case "suggestion":
                fillTable(tableName, sqlSuggId);
                break;
            case "itemId":
                fillTable(tableName, sqlItemId);
                break;
            case "date":
                fillTable(tableName, sqlSuggDate);
                break;
            case "employeeId":
                fillTable(tableName, sqlEmpId);
                break;
           
         }
    }
     
 public void getMaintainanceDetails(String Id,JTextField mainId,JTextField itemId,JDateChooser date,JSpinner repairperiod,JTextArea discription) {
     
 String sqlMain  = "SELECT * FROM maintenance where maintenanceId = '"+Id+"'";

 try{
     DbConnect c = new DbConnect();
     c.setConnection();
     Statement stmnt;
     stmnt=c.con.createStatement();
     result = stmnt.executeQuery(sqlMain);
     
     while(result.next()){
     //    mainId.setText(result.getString("maintenanceId"));
     itemId.setText(result.getString("itemId"));
     date.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(result.getString("repairDate")));
     repairperiod.setValue(result.getString("repairPeriod"));
     discription.setText(result.getString("description"));
     
     }
      stmnt.close();
        c.con.close();
 }
 catch(Exception e){
     System.out.println(e);
 }
 }    
   
public void updateMaintainanceDetails (String Id,String itemId,String date,int repairperiod,String discription)
{
  
     try{
      
            DbConnect c = new DbConnect();
            c.setConnection();
            Statement stmnt=c.con.createStatement();
          
            String sql = "UPDATE maintenance set itemId = '"+itemId+"',repairDate = '"+date+"',"
                    + "repairPeriod = '"+repairperiod+"',description = '"+discription+"' where maintenanceId = '"+Id+"'";
         
        stmnt.executeUpdate(sql);
          c.con.close();
          
        }
        catch(Exception e){
            System.out.println(e);
        }
     
}

public boolean checkAvalability(String tableName,String colmunName,String data){

String sqlSelect = "SELECT count(1) FROM "+tableName+" where "+colmunName+" = '"+data+"'";
boolean available = false;
int value = 0;


 try{
     DbConnect c = new DbConnect();
     c.setConnection();
     Statement stmnt;
     stmnt=c.con.createStatement();
     result = stmnt.executeQuery(sqlSelect);
     
     while(result.next()){
         value = Integer.parseInt(result.getString("count(1)"));
     
     }
      stmnt.close();
      c.con.close();
      if(value > 0)
          available = true;
 }
 catch(Exception e){
     System.out.println(e);
 }

return available;
}

public void setUpdateMainDetails(String mainId,JTextField itemId,JDateChooser date,JSpinner period,JTextArea discription){

    String sqlGetDetails="Select * From maintenance where maintenanceId ='"+mainId+"'";
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    try{
        
     DbConnect c = new DbConnect();
     c.setConnection();
     Statement stmnt;
     stmnt=c.con.createStatement();
     result = stmnt.executeQuery(sqlGetDetails);
     
     while(result.next()){
        
     itemId.setText(result.getString("itemId"));
     date.setDate(df.parse(result.getString("repairDate")));
     period.setValue(Integer.parseInt(result.getString("repairPeriod")));
     discription.setText(result.getString("description"));
      
     }
      stmnt.close();
      c.con.close();
      
 }
 catch(Exception e){
     System.out.println(e);
 }
}

public boolean hasAJob(String sql,String checkValue){
boolean avalability = false;


String status= "";
 try{
        
     DbConnect c = new DbConnect();
     c.setConnection();
     Statement stmnt;
     stmnt=c.con.createStatement();
     result = stmnt.executeQuery(sql);
     
     while(result.next()){
        
    status = result.getString("status");
     
      
     }
      stmnt.close();
      c.con.close();
      
      if (status.equalsIgnoreCase(checkValue)){
       avalability = true;
      }
      else
          avalability = false;
 }catch(Exception e){
     System.out.println(e);
 }

return avalability;
}

}

   
      

        
    

