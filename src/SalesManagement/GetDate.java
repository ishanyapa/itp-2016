/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author User
 */
public class GetDate {
    public static String getDate(String formats)
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat(formats);
        return date.format(cal.getTime());
   }
    
}
