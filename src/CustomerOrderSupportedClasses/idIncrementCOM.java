/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrderSupportedClasses;

/**
 *
 * @author Saajith Zain
 */
public class idIncrementCOM {

    private String id;
    
    public idIncrementCOM(String id) {
            this.id=id;
           
    }
    
    public String incrementId()
    {
       int i=Integer.valueOf(this.id.substring(4));  
        return this.id.substring(0,4)+ ++i; 
     
    }


   public String incrementInvoiceId()
   {
       int i=Integer.valueOf(this.id.substring(3));  
        return this.id.substring(0,3)+ ++i; 
   
   }

    
}
