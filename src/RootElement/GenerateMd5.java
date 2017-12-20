package RootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishan
 */
import java.security.*;

public class GenerateMd5 {
    private String word;
	
	public GenerateMd5(String w)
	{
		this.word=w;
	}
	
	public String getMd5()
	{
		StringBuffer sb = new StringBuffer();
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(this.word.getBytes());
		
			byte byteData[] = md.digest();
 
			
			for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		
			
		}
		catch (Exception e)
		{
			
		}
		
		return sb.toString();
	}
}
