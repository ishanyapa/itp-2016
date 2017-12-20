/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootElement;

import java.io.File;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ishan
 */
public class RootDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        File dbXml = new File("src/GeneratedXML/DBXml.xml");
        
        if(!dbXml.canRead()){
            DBConfig dbconf = new DBConfig(null, true);
            dbconf.setVisible(true);
        }
        else{
            Login newLogin = new Login();
            newLogin.setVisible(true);
        }
    }
    
}
