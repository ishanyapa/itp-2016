/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement.SupportedClasses;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Ishan
 */
public class SetPanel {
    private static JPanel jpnl = null;
    
    public void SetPanel(Object obj , JPanel panel)
    {
        jpnl = panel; 
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
         
         
         
        panel.add((Component) obj);
        panel.repaint();
        panel.revalidate();

    }
    
    public void SetPanel(Object obj){
        jpnl.removeAll();
        jpnl.repaint();
        jpnl.revalidate();
        
        jpnl.add((Component) obj);
        jpnl.repaint();
        jpnl.revalidate();
    }
    
    public void SetPanel(JPanel root, JPanel comp){
        root.removeAll();
        root.repaint();
        root.revalidate();
        
        root.add(comp);
        root.repaint();
        root.revalidate();
    }
}
