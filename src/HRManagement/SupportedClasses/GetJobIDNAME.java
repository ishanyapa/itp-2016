/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManagement.SupportedClasses;

import RootElement.DbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ashanginige
 */
public class GetJobIDNAME {
    
    public String ReturnJobID(String jobNAME) throws SQLException{
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        Statement stmt;
        ResultSet rslt;
        
         //retrievedJob; 
            String retrievedJob = null;
         
            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT jobId FROM occupation where jobName = '"+jobNAME+"'");
            
            while(rslt.next()){
                retrievedJob = rslt.getString("jobId");
            }
            
            dbcon.con.close();
            stmt.close();
             
            return retrievedJob;
    }
    
    public String ReturnJobName(String jobID) throws SQLException{
        
        DbConnect dbcon = new DbConnect();
        dbcon.setConnection();
        Statement stmt;
        ResultSet rslt;
        
            String retrievedId = null;
            
            stmt = dbcon.con.createStatement();
            rslt = stmt.executeQuery("SELECT jobName FROM occupation where jobId = '"+jobID+"'");
            
            while(rslt.next()){
                retrievedId = rslt.getString("jobName");
            }
            
            dbcon.con.close();
            stmt.close();
            
            return retrievedId;
    }
}
