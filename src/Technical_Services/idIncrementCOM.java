/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

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
       int i=Integer.valueOf(this.id.substring(3));
        System.out.println(i);
        
      return this.id.substring(0,3)+ ++i; 
       
    }



    
}
