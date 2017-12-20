/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RootElement;
//import org.apache.commons.codec.binary.Base64;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 *
 * @author Ishan
 */
public class GenerateBase64 {
    public String EnBase64(String password){
        byte[] encodedBytes = password.getBytes();
        String encodedPass = new String(Base64.getEncoder().encode(encodedBytes),Charset.forName("UTF-8"));
//        System.out.println(encodedPass);
        return encodedPass;

    }
    
    public byte[] DecBase64(byte[] arr){
        
        byte [] encodedBytes = Base64.getDecoder().decode(arr);
        
//        System.out.println(String.valueOf(encodedBytes));
        return encodedBytes;
    }
}
