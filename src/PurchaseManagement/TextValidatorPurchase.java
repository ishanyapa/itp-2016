/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PurchaseManagement;

/**
 *
 * @author Samitha Heanthenna
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JLabel;


public class TextValidatorPurchase {
    
    private String text;
    
    public TextValidatorPurchase(){    
    }
    
    public TextValidatorPurchase(String t){
        this.text=t;
    }
    
    //To check Is Character [True=char / False=digit]
    private boolean isCharacter(String n)
	{
		for(int i=0; i<n.length(); i++)
		{
			if(Character.isDigit(n.charAt(i)))
				return false;			
		}
		
		return true;		
	}
    
    //To Check the Empty Feilds
    public void empty(JLabel err)
        {
                if(text.isEmpty())
                    err.setText("!");
                else 
                    err.setText("");
                            
        }
    
    //To Check the Character only Feilds
    public boolean isName()
	{               
                if(text.equals(""))
                        return false;
                if(isCharacter(text))
			return true;
                else
			return false;
	}
    
    //To Check the Telephone number Feilds
    public boolean isTelephone()
	{
		if(text.length()!=11)
			return false;
                
                if("0000000000".equals(text))
			return false;
		
		/*With -
                for(int i=0; i<=2; i++)
		{
			if(isCharacter(String.valueOf(text.charAt(i))))
				return false;
		}
			

		if(text.charAt(3)!='-')
			return false;

		
		for(int k=4; k<=10; k++)
		{
			if(isCharacter(String.valueOf(text.charAt(k))))
				return false;
		}
		*/	
		
                for(int i=0; i<=9; i++)
		{
			if(isCharacter(String.valueOf(text.charAt(i))))
				return false;
		}
   
		return true;
	}

		private int getIndex(String n, char c)
	{
		for(int i=0; i<n.length(); i++)
		{
			if(n.charAt(i)==c)
				return i;
		}
		
		return -1;
	}

	public boolean isEmail()
	{
		StringTokenizer st1 = new StringTokenizer(text,"@");
		StringTokenizer st2 = new StringTokenizer(text,".");

		
		if(st1.countTokens() != 2)	
			return false;

		/*if(st2.countTokens() != 2)
			return false;*/
		if(text.charAt(getIndex(text,'@')+1)=='.')
			return false;
		
		if(text.charAt(getIndex(text,'.')+1)=='@')
			return false;
		
		if(text.charAt(text.length()-1)=='@')
			return false;
	
		if(text.charAt(text.length()-1)=='.')
			return false;

		if(text.charAt(0)=='@')
			return false;
	
		if(text.charAt(0)=='.')
			return false;

		return true;
		
	}
        public  void comboSelection(JComboBox cmb, JLabel lbl){
            if(cmb.getSelectedIndex()==-1)
                    lbl.setText("!");
                else
                    lbl.setText("");
        }
        

}
