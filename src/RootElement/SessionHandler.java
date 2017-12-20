package RootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishan
 */
public  class SessionHandler {
    
    private static String accessLevel;
    private static String user;
    private static String occupation;
    private static String division;
    private static ControlPanel insta;

    public static void setDivision(String division) {
        SessionHandler.division = division;
    }

    public static String getDivision() {
        return division;
    }

    public static void setOccupation(String occupation) {
        SessionHandler.occupation = occupation;
    }

    public static String getOccupation() {
        return occupation;
    }

    public static void setInsta(ControlPanel ins) {
        SessionHandler.insta = ins;
    }

    public static ControlPanel getInsta() {
        return insta;
    }
    
    public static void setAccessLevel(String a)
    {
        accessLevel = a;
    }
    
    public static String getAccessLevel()
    {
        return accessLevel;
    }
    
    public static void setUser(String u)
    {
        user = u;
    }
    
    public static String  getUser()
    {
        return user;
    }
    
    public static void Dispose(){
        
        if(insta!=null)
            SessionHandler.insta.dispose();
        SessionHandler.accessLevel=null;
        SessionHandler.division=null;
        SessionHandler.insta=null;
        SessionHandler.occupation=null;
        SessionHandler.user=null;
        Login lg = new Login();
        lg.setVisible(true);
    }
    
    
}
