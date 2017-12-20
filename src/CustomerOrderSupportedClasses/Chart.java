/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrderSupportedClasses;

/**
 *
 * @author user
 * */
import RootElement.DbConnect;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
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
       String sqlgetData = sql;
      
       
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
         true, 
         false);
     // PiePlot p= (PiePlot)new PiePlot(chart);
     Plot plot = chart.getPlot();
      plot.setBackgroundPaint(Color.WHITE);
      plot.setOutlinePaint(Color.WHITE);
      return chart;
   }
   
 
   
   
   public  JPanel createPanel(JFreeChart createChart,int width,int height )
   {
      JFreeChart chart = createChart;  
      ChartPanel outPanle = new ChartPanel(chart);
      outPanle.setSize(width,height);
      return outPanle; 
   }

}