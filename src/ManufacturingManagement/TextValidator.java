/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManufacturingManagement;

/**
 *
 * @author User
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishan
 */
import java.util.StringTokenizer;

public class TextValidator
{
	private String text;

	public TextValidator(String t)
	{
		this.text = t;
	}
		
	private boolean isCharacter(String n)
	{
		for(int i=0; i<n.length(); i++)
		{
			if(Character.isDigit(n.charAt(i)))
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

	public boolean isName()
	{
                if(text.equals(""))
                    return false;
		if(isCharacter(text))
			return true;
		else
			return false;
	}

	public boolean isTelephone()
	{
		if(text.length()!=11)
			return false;
		
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
			
		
		if("000-0000000".equals(text))
			return false;

	
		return true;
	}

	public boolean isNic()
	{
		if(text.length()!=10)
			return false;

		if(text.charAt(9)!='V')
			return false;

		for(int i=0; i<=8; i++)
		{
			if(isCharacter(String.valueOf(text.charAt(i))))
				return false;	
		}
		return true;
	}

	public boolean isEmail()
	{
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
        
        public boolean  isAge()
        {
            if(isCharacter(text))
                return false;
            if(Integer.valueOf(text)>100 || Integer.valueOf(text)<16)
                return false;
            
            return true;
                        
        }

	
	 
}


