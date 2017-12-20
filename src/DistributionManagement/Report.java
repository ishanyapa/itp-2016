/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;

import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
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

// No Connection to the DB
class Report extends JFrame {
        public Report(String filename,Map<String, Object> parameter)
        {
          super("view report");
       try {
          // Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:7878/gym","root","shali123");
        
            JasperPrint print=JasperFillManager.fillReport(filename,parameter,new JREmptyDataSource());
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
