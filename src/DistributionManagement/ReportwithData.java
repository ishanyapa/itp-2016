/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;
import RootElement.DbConnect;

import java.awt.Container;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Shali
 */
public class ReportwithData extends JFrame{
    
    
  
    public ReportwithData(String filename,Map parameter)
   // public ReportwithData(String filename,HashMap)
         
    {
            
         
          super("Reports");
          
          DbConnect c1 = new DbConnect(); 
          c1.setConnection();
               
                 try 
       {
         //   Class.forName("com.mysql.jdbc.Driver").newInstance();
           // Connection con=DriverManager.getConnection("jdbc:mysql://localhost:7878/kelanidb","kelaniAdmin","kelani123");
          Connection con = c1.con;
        
               //con.setConnection();
          
          
           
            JasperPrint print=JasperFillManager.fillReport(filename,parameter,con);
            
            JRViewer viewer=new JRViewer(print);
            
            Container c=getContentPane();
            c.add(viewer);
            
            
           
       } catch (Exception e) {
           e.printStackTrace(); 
       }
       
       setBounds(10,10,1000,500);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        }
    
}

