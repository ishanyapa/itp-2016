/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Prarthana
 */
public class DateValidator {
    
    public static void Validate(String d1, String d2, JLabel l){
        String message = "";
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        
        DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        
        Date a = new Date();
        Date b = new Date();
        
        try
        {
            a = (Date)f.parse(d1);
            b = (Date)f.parse(d2);
            
        }
        catch (ParseException ex) {
            Logger.getLogger(DateValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        c1.setTime(a);
        c2.setTime(b);
        
        if(c1.after(c2))
        {    
            //DisplayMessage.display("Invalid Date");
            l.setText("!");
        }
  
    }
    
}
