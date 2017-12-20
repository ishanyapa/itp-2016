/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

import RootElement.SalesDBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class IDGenerator {
    
    Connection con = null;
    
    
    public void IDGenerator()
    {
       con = SalesDBConnect.connect(); 
    }
    
    
    public String invoiceID()
    {
        Statement st = null;
        ResultSet rs = null;
        String id=null;
        String a;
        int b;
        String i=null;
        //String invoice;
        
        try
        {
            
            String q="SELECT invoiceNo FROM invoice ORDER BY invoiceNo";
            st = con.createStatement();
            rs = st.executeQuery(q);
            
            while(rs.next())
            {
                id=rs.getString("invoiceNo");
            }
            
            
                a=id.substring(0, 3);
                b=Integer.parseInt(id.substring(3,5));
                b=b+1;
                i=a+String.valueOf(b);
        }
        
        catch(Exception e)
        {
            
        }
        
        return i;
                
        
    }        
}
    
    

    

