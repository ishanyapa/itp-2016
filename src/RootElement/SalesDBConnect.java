/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootElement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class SalesDBConnect {
        public static String username="";
	public static String password="";
	public static String url = "";
    public static Connection connect(){
        
    
        Connection conn = null;
         
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);
            
            if(conn!=null)
            {
                System.out.println("Successful");
            }
        }
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    
        return conn;
    }

    Connection getConnection()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
