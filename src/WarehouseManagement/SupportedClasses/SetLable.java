/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement.SupportedClasses;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Ishan
 */
public class SetLable {
    
    
    
    public void CheckTextField(JTextField jtf, JLabel lbl,String type)
    {
        TextValidator tv = new TextValidator(String.valueOf(jtf.getText()));
        
        if(type.equals("text")){
           if(jtf.getText().equals(""))
            SetError(lbl);
           else if (!tv.isText())
            SetError(lbl);
           else
            SetNull(lbl); 
        }
        else if(type.equals("number"))
        {
           if(jtf.getText().equals(""))
            SetError(lbl);
           else if (tv.isText())
            SetError(lbl);
           else
            SetNull(lbl);
        }
        
    }
    
    public void CheckTextField(JTextField jtf, JLabel lbl)
    {
        
        if(jtf.getText().equals(""))
            SetError(lbl);
        else
            SetNull(lbl);
    }
    
    
    public void CheckComboBox(JComboBox cmb, JLabel lbl)
    {
        if(cmb.getSelectedIndex()==-1)
            SetError(lbl);
        else 
            SetNull(lbl);
    }
    
    public void CheckSpinner(JSpinner spnnr, JLabel lbl)
    {
        if(Integer.parseInt(String.valueOf(spnnr.getValue()))==0)
            SetError(lbl);
        else
            SetNull(lbl);
        
    }
    private void SetError(JLabel lbl){
        lbl.setText("!");
    }
    
    private void SetNull(JLabel lbl){
        lbl.setText("");
    }
}
