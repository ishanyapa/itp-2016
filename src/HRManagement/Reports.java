/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManagement;

import RootElement.DbConnect;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author ashanginige
 */


public class Reports extends JFrame{
    
    
  
    public Reports(String filename,Map parameter)
   // public ReportwithData(String filename,HashMap)
         
    {
            
         
          super("Reports");
          
          DbConnect c1 = new DbConnect(); 
          c1.setConnection();
               
                 try 
       {
            Connection con = c1.con;
        
          
          
           
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
    