/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

/**
 *
 * @author user
 * */
import RootElement.DbConnect;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import static org.jfree.chart.plot.PlotOrientation.VERTICAL;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class Chart
{
     DefaultPieDataset Piedataset = new DefaultPieDataset( );
     DefaultCategoryDataset  lineDataset = new DefaultCategoryDataset( );  
   
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
   
   
   public DefaultCategoryDataset createDataset(String sql,String nameOfY,String nameOfX,String nameOfVariable)
   {
       DefaultCategoryDataset lineDataset = new DefaultCategoryDataset( );
       try{
          DbConnect c = new DbConnect();
          c.setConnection();
          
          Statement stmnt=c.con.createStatement();
          ResultSet result=stmnt.executeQuery(sql);
          
           while( result.next( ) ) 
      {
         lineDataset.addValue( Double.parseDouble(result.getString(nameOfY)),nameOfVariable,result.getString(nameOfX));
        
      }
           
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
  
      return lineDataset;
   }
  
   public  JFreeChart createPieChart(String chartName)
   {
      JFreeChart Piechart = ChartFactory.createPieChart(      
         chartName,  // chart title 
         Piedataset,        // data    
         true,           // include legend   
         true, 
         false);
      
      Piechart.setBackgroundPaint(java.awt.Color.white);
      PiePlot plot = (PiePlot) Piechart.getPlot();
      plot.setBackgroundPaint(java.awt.Color.white);
      
      PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
              "{0} : {1} ({2})",new DecimalFormat("0"),new DecimalFormat("0%"))
      ;plot.setLabelGenerator(gen);
         

      return Piechart;
   }
   
   public JFreeChart createLineChart(String chartName,String chartNameOfX,String chartNameOfY,String sql,String nameOfY,String nameOfX,String nameOfVariable){
   
      JFreeChart LineChart = ChartFactory.createLineChart(
             chartName,
        chartNameOfX,chartNameOfY,
        createDataset(sql,nameOfY,nameOfX,nameOfVariable),
         PlotOrientation.VERTICAL,
         true,true,false);
       
       return LineChart;
   }
   
    public JFreeChart createBarChart(String chartName,String chartNameOfX,String chartNameOfY,String sql,String nameOfY,String nameOfX,String nameOfVariable){
   
      JFreeChart BarChart = ChartFactory.createBarChart(
             chartName,
        chartNameOfX,chartNameOfY,
        createDataset(sql,nameOfY,nameOfX,nameOfVariable),
         PlotOrientation.VERTICAL,
         true,true,false);
       
      
       return BarChart;
   }
   

   
   public  JPanel createPanel(JFreeChart createChart,int width,int height )
   {
      JFreeChart chart = createChart;  
      ChartPanel outPanle = new ChartPanel(chart);
      outPanle.setSize(width,height);
      return outPanle; 
   }
   

   
}