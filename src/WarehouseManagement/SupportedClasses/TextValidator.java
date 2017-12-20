/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagement.SupportedClasses;

/**
 *
 * @author Ishan
 */
public class TextValidator {
    
    private String text;
    
    public TextValidator(String ptext){
        this.text = ptext;
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

	public boolean isText()
	{
                if(text.equals(""))
                    return false;
		if(isCharacter(text))
			return true;
		else
			return false;
	}
}
