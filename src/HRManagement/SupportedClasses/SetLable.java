/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManagement.SupportedClasses;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

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
           else if (!tv.isName())
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
    
    public void CheckNic(JTextField jtf, JLabel lbl, String type)
    {
        TextValidator tv1 = new TextValidator(String.valueOf(jtf.getText()));
        
        if(type.equals("text")){
           if(jtf.getText().equals(""))
            SetError(lbl);
           else if (!tv1.isNic())
            SetError(lbl);
           else
            SetNull(lbl); 
        }
    }
    
    
    
    public void CheckTelephone(JTextField jtf, JLabel lbl, String type)
    {
        TextValidator tv1 = new TextValidator(String.valueOf(jtf.getText()));
        
        if(type.equals("text")){
           if(jtf.getText().equals(""))
            SetError(lbl);
           else if (!tv1.isTelephone())
            SetError(lbl);
           else
            SetNull(lbl); 
        }
    }
    
    public void CheckImage(JLabel lb, JLabel lbl)
    {
        if(lb.getIcon()==null){
            SetError(lbl);
        }
        else
            SetNull(lbl);
    }
    
    public void CheckComboBox(JComboBox cmb, JLabel lbl)
    {
        if(cmb.getSelectedItem().equals("Select"))
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
    
    public void CheckRadio(ButtonGroup btg, JLabel lbl){
        
        if(btg.getSelection()==null){
            SetError(lbl);
        }
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
