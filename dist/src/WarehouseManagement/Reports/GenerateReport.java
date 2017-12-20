/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement.Reports;

import RootElement.DbConnect;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Ishan
 */
public class GenerateReport  extends JFrame{
    public GenerateReport(String filename,Map<String,Object> param)
        {
          super("view report");
       try {
           
           DbConnect dbcon = new DbConnect();
           dbcon.setConnection();
        
           JasperPrint print=JasperFillManager.fillReport(filename,param,dbcon.con);
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
