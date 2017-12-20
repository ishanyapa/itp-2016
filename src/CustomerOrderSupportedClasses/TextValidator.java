package CustomerOrderSupportedClasses;


import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TextValidator
{
	private String text;

        public TextValidator(){
        }
        
	public TextValidator(String t)
	{
		this.text = t;
	}

        
   
		
	private boolean isCharacter(String n)
	{
		for(int i=0; i<n.length(); i++)
		{
			if(Character.isDigit(n.charAt(i)))
				return true;			
		}
		
		return false;		
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

            
        public void empty(JLabel err)
        {
                if(text.isEmpty())
                    err.setText("!");
                else 
                    err.setText("");
                            
        }
    
        
       
        
	public void isName(JLabel err)
	{                     
                if(text.isEmpty())
                        err.setText("!");
                else if(isCharacter(text))
			err.setText("!");
                else
			err.setText("");
	}

    public void isTelephone(String cc,String ac,String num,JLabel err)
	{

            if(cc.isEmpty() || ac.isEmpty() || num.isEmpty())
                err.setText("!");
            else if(cc.length()!=2)
                err.setText("!");
            else if(ac.length()!=3)
                err.setText("!");
            else if(num.length()!=7)
                err.setText("!");
            else
                err.setText("");
            
	}

	
    public boolean isEmail(){
        
		StringTokenizer st1 = new StringTokenizer(text,"@");
		StringTokenizer st2 = new StringTokenizer(text,".");

		
		if(st1.countTokens() != 2)	
			return false;

		if(st2.countTokens() != 2)
			return false;

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
   

	
        
        public void radioSelected(JRadioButton jr1,JRadioButton jr2,JLabel err){
        
             if(jr1.isSelected() || jr2.isSelected())
                     err.setText("");
             else
                 err.setText("!");
        
        }
}
