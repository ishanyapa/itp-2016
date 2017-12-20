/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement.SupportedClasses;

/**
 *
 * @author Ishan
 */
import RootElement.DbConnect;
import java.awt.Color;
import java.awt.Paint;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class Chart
{
     DefaultPieDataset Piedataset = new DefaultPieDataset( );
     final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
     
   public void createPieDataset( String sql,String valueOfCol1,String valueOfCol2) 
   {
       
      
       
       try{
          DbConnect c = new DbConnect();
          c.setConnection();
          
          Statement stmnt=c.con.createStatement();
          ResultSet result=stmnt.executeQuery(sql);
          
           while( result.next( ) ) 
      {
         Piedataset.setValue( 
         result.getString( valueOfCol1 ) ,Double.parseDouble( result.getString( valueOfCol2)));
      }
           
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
       
       
   }
   
 
   public  JFreeChart createPieChart(String chartName)
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         chartName,  // chart title 
         Piedataset,        // data    
         true,           // include legend   
         false, 
         false);
       chart.setBackgroundPaint(Color.WHITE);
       PiePlot plot =(PiePlot) chart.getPlot();
       plot.setBackgroundPaint(Color.WHITE);
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
      return chart;
   }
   
 
   
   
   public  JPanel createPanel(JFreeChart createChart,int width,int height )
   {
      JFreeChart chart = createChart;  
      chart.setBackgroundPaint(Color.WHITE);
      ChartPanel outPanle = new ChartPanel(chart);
      outPanle.setSize(width,height);
      outPanle.setBackground(Color.WHITE);
      return outPanle; 
   }

   public void SaveChart(File f,JFreeChart chart){
       try {
           ChartUtilities.saveChartAsJPEG(f, chart,1024,720);
       } catch (Exception e) {
       }
   }
}
