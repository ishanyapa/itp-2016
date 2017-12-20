/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technical_Services;

/**
 *
 * @author user
 */
public class textValidator {
    private String text;
    private String firstPart=null;
    private boolean correctId = false;
    
    public textValidator(){
    
    }
    
    public textValidator(String t){
        this.text=t;
        
        if (text.length()>3){
        firstPart = text.substring(0,3).toLowerCase();
        correctId = isCorrectId();
        }
        
             
    }
    
    private boolean isCorrectId(){
        for(int i=0;i<3;i++){
                if(!Character.isLetter((text.substring(0,3).charAt(i))))
                    return false;
            }
        
        for(int j=0;j<text.substring(3,text.length()).length();j++){
            if(!Character.isDigit((text.substring(3,text.length()).charAt(j))))
                return false;
        }
        
        return true;
    }
   
    public boolean isMachine(){
        if (correctId && firstPart.compareTo("mac") == 0 )
            return true;
        else
            return false;       
    }
    
    public boolean isEmployee(){
        if(correctId && firstPart.compareTo("emp") == 0 && (text.substring(3,text.length()).length() == 4))
            return true;
        else
            return false;
    }
    
    public boolean isPlant(){
        if(correctId && firstPart.compareTo("pla") == 0 && (text.substring(3,text.length()).compareTo("1") == 0 || text.substring(3,text.length()).compareTo("2") == 0 || text.substring(3,text.length()).compareTo("3") == 0) )
            return true;
        else
            return false;
    }
    
    public boolean isVehicle(){
        
            return true;
        
           
    }
    
    public boolean isComplain(){
        if(correctId && firstPart.compareTo("com") == 0)
            return true;
        else
            return false;
    }
     
    public boolean isJob(){
        if(correctId && firstPart.compareTo("job") == 0)
            return true;
        else
            return false;
    }
    
    public boolean isMaintenance(){
        if(correctId && firstPart.compareTo("mai") == 0)
            return true;
        else
            return false;
    }
    
    public boolean isSuggestion(){
        if(correctId && firstPart.compareTo("sug") == 0)
            return true;
        else
            return false;
    }
    
    public boolean isItem (){
        if(correctId && ( firstPart.compareTo("mac") == 0 || firstPart.compareTo("pla") == 0 || firstPart.compareTo("veh") == 0))
            return true;
        else
            return false;
    } 
    
    public boolean isNull(String text){
        if (text == null | text.length() == 0)
            return true;
        else
            return false;
    }
     
    public String searchComValidation(String keyWord){
        
        char letter = Character.toLowerCase(keyWord.charAt(0));
        
        if(letter == 'c' )
            return "complain";
        else if(letter == 'e')
            return "employeeId";
//        else if(letter == 'p' || letter == 'm')
//            return "itemId";
        else if(Character.isDigit(letter))
            return "date";
        
           
   return " ";
}
     public String searchJobValidation(String keyWord){
        
        char letter = Character.toLowerCase(keyWord.charAt(0));
        
        if(letter == 'c' )
            return "complain";
        else if(letter == 'j')
            return "jobId";
//        else if(letter == 'p' || letter == 'm')
//            return "itemId";
        else if(Character.isDigit(letter))
            return "date";
        else if(letter == 'e')
            return "employeeId";
        
           
   return "itemId";
}
     public String searchMainValidation(String keyWord){
        
        char letter = Character.toLowerCase(keyWord.charAt(0));
        
        if(letter == 'm' )
            return "maintenance";
//        else if(letter == 'p' || letter == 'm')
//            return "itemId";
        else if(Character.isDigit(letter))
            return "date";
        
           
   return "itemId";
}
     public String searchSuggValidation(String keyWord){
        
        char letter = Character.toLowerCase(keyWord.charAt(0));
        
        if(letter == 's' )
            return "suggestion";
        else if(letter == 'p' || letter == 'm')
            return "itemId";
        else if(Character.isDigit(letter))
            return "date";
        else if(letter == 'e')
            return "employeeId";
        
           
   return " ";
}
}
