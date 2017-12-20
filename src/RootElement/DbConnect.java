package RootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishan
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
        public static String username="";
	public static String password="";
	public static String url = "";
	public Connection con = null;
	public void setConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(this.url,this.username,this.password);
			
			
		}

		catch(Exception e)
		{
                        JOptionPane.showMessageDialog(null,"Cannot connect to database.\nMake sure the the server is up and running.","Warning",JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
		}
	}
}