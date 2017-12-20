/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

/**
 *
 * @author Ishan
 */
public class IdIncrement {
    
    public String Increment(String id, int prefixSize){
        
        String prefix = id.substring(0, prefixSize);
        int number = Integer.parseInt(id.substring(prefixSize));
        
        return prefix+(++number);
        
    }
    
}
