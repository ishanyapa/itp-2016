/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author user
 */
public class dateAndTime {
    
   public static String getDateAndTime(String formats){
       Calendar cal = Calendar.getInstance();
       SimpleDateFormat date = new SimpleDateFormat(formats);
       return date.format(cal.getTime());
   }
    
}


 
