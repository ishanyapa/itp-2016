/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class SetPanel {
    
    public void SetPanel(Object obj , JPanel panel)
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
         
         
         
        panel.add((Component) obj);
        panel.repaint();
        panel.revalidate();
    
    
    
    }
    
}
