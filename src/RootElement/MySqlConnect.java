/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootElement;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MySqlConnect {
    public static String url = "";
    public static String username="";
    public static String password="";
    public static Connection ConnectDB() {
            Connection conn=null;
            
         try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();;
         
            conn=DriverManager.getConnection(url,username,password);
             if(conn!=null){
                System.out.println("successful");
             }
          
        }
         
         catch(Exception e)
       {
                          
            JOptionPane.showMessageDialog(null, e);
         
            return null;
       }
           return conn;
        
        
    }
    
    
}
