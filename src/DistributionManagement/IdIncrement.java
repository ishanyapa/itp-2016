/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;
// Delivery ID 

public class IdIncrement{
    
    private String Id;
    private char prefix;
    
    public IdIncrement(String i, char p)
	{
		this.Id = i;
                this.prefix = p;
	}
    
    private int getIndex(String n)
	{
		int k = 0 ;
		
		for(int i=1; i<n.length(); i++)
		{
			k = Character.getNumericValue(n.charAt(i));
			if(k!=0)
                        {
                            return i;
                        }
		}

		return 4;
	}
    
    public String getIncrementedId()
	{
                if(Id=="")
                {
                    return String.valueOf(prefix)+"00001";
                }
                else
                {
                int index = getIndex(Id);
		String nId="";
		int num;
		
		num = Integer.parseInt(Id.substring(index));
		num++;

		if(num<10)
		{
			nId = nId.concat(String.valueOf(Id.charAt(0)));
			nId = nId.concat(String.valueOf(Id.charAt(1)));	 
			nId = nId.concat(String.valueOf(Id.charAt(2)));
                        nId = nId.concat(String.valueOf(Id.charAt(3)));
                        nId = nId.concat(String.valueOf(Id.charAt(4)));
                        //nId = nId.concat(String.valueOf(Id.charAt(5)));
			nId = nId.concat(String.valueOf(num)); 
		}
		else if(num<100 && num>=10)
		{
			nId = nId.concat(String.valueOf(Id.charAt(0)));
			nId = nId.concat(String.valueOf(Id.charAt(1)));	 
			nId = nId.concat(String.valueOf(Id.charAt(2)));
                        nId = nId.concat(String.valueOf(Id.charAt(3)));
                        //nId = nId.concat(String.valueOf(Id.charAt(4)));
			nId = nId.concat(String.valueOf(num)); 
		}
                else if(num<1000 && num>=100)
		{
			nId = nId.concat(String.valueOf(Id.charAt(0)));
			nId = nId.concat(String.valueOf(Id.charAt(1)));	 
			nId = nId.concat(String.valueOf(Id.charAt(2)));
                        //nId = nId.concat(String.valueOf(Id.charAt(3)));
			nId = nId.concat(String.valueOf(num)); 
		}
                else if(num<10000 && num>=1000)
		{
			nId = nId.concat(String.valueOf(Id.charAt(0)));
			nId = nId.concat(String.valueOf(Id.charAt(1)));	 
			//nId = nId.concat(String.valueOf(Id.charAt(2)));
			nId = nId.concat(String.valueOf(num)); 
		}
                else if(num>=10000)
		{
			nId = nId.concat(String.valueOf(Id.charAt(0)));
			//nId = nId.concat(String.valueOf(Id.charAt(1)));
			nId = nId.concat(String.valueOf(num)); 
		}
		/*else if(num>=10000)
		{
			nId = nId.concat(String.valueOf(Id.charAt(0)));
			nId = nId.concat(String.valueOf(num)); 	
		}*/
                

		return nId;
            }
        }
}