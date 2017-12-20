/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerOrderSupportedClasses;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.net.InetAddress;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Saajith Zain
 */
public class EmailSender {
        String  attachmentPath;
        String attachmentName;
       
        
    public  EmailSender()
    {
        this.attachmentName=" ";
        this.attachmentPath=" ";
        
        
    }
    public void sendEmail(JTextPane subject,String Recipent,JTextPane content,JProgressBar pb,JComboBox combo,JLabel emailAd,JLabel a,String userName,String Pswd){
    


  String host="smtp.gmail.com";  
  //final String user="bitf11m036@pucit.edu.pk";//change accordingly  
  final String user =userName;
  //final String password="gazi786786";//change accordingly  
  final String password =Pswd;
  
  if(!user.equals("") && !password.equals(""))
  {
  String SMTP_PORT = "465";
  String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
  
  //String to="bitf11m036@pucit.edu.pk";//change accordingly  
  String to=Recipent;
   //Get the session object
  
   Properties props = new Properties();
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");  
   props.put("mail.debug", "true");
   props.put("mail.smtp.port", SMTP_PORT);
   props.put("mail.smtp.socketFactory.port", SMTP_PORT);
   props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
   props.put("mail.smtp.socketFactory.fallback", "false");  
  
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {
       
    protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
        pb.setValue(10);
        pb.paintImmediately(pb.getVisibleRect());
        MimeMessage message = new MimeMessage(session);  
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
        Multipart multipart = new MimeMultipart();//new additions
       
        pb.setValue(20);
        pb.paintImmediately(pb.getVisibleRect());
       
        pb.setValue(20);
        pb.paintImmediately(pb.getVisibleRect());
       
        message.setFrom(new InternetAddress(user));  
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
        message.setSubject(String.valueOf(subject.getText()));
        message.setText(String.valueOf(content.getText()));  
   
     
     if(attachmentPath.equals(" ")) 
     {
          for(int i=50;i<95;i++)
        {
            Thread.sleep(i);
            pb.setValue(i);
            pb.paintImmediately(pb.getVisibleRect()); 
        
        }
        
        
            Transport.send(message);  
            pb.setValue(100);
            pb.paintImmediately(pb.getVisibleRect());
            
            subject.setText("");
            content.setText("");
            combo.setSelectedIndex(-1);
            emailAd.setText("");
            a.setText("");
     }
     else
     {  
        
         
    
        File att = new File(new File(attachmentPath.substring(0,attachmentPath.lastIndexOf("\\")+1).replace("\\","\\\\")), attachmentName);
        
        
            messageBodyPart.attachFile(att);
            DataSource source = new FileDataSource(att);
            pb.setValue(20);
            pb.paintImmediately(pb.getVisibleRect());
       
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachmentName);
           
         
            pb.setValue(30);
            pb.paintImmediately(pb.getVisibleRect());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            pb.setValue(40);
            pb.paintImmediately(pb.getVisibleRect());    
            pb.setValue(50);
            pb.paintImmediately(pb.getVisibleRect()); 
        
        for(int i=50;i<95;i++)
        {
            Thread.sleep(100);
            pb.setValue(i);
            pb.paintImmediately(pb.getVisibleRect()); 
        
        }
        Transport.send(message);
        
        subject.setText("");
        content.setText("");
        combo.setSelectedIndex(-1);
        emailAd.setText("");
        a.setText("");
                 
        pb.setValue(100);
        pb.paintImmediately(pb.getVisibleRect());
       
        }
  
       
     JOptionPane.showMessageDialog(null,"Email sent Successfully");
            pb.setValue(0);
            pb.paintImmediately(pb.getVisibleRect());
     } catch (MessagingException e) 
   
     {e.printStackTrace();} 
       catch (IOException ex) {  
          Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Error","Error!",JOptionPane.ERROR_MESSAGE);
   
     } catch (InterruptedException ex) {  
      JOptionPane.showMessageDialog(null,"Error","Error!",JOptionPane.ERROR_MESSAGE);
    }  
  }
  else 
  {
      JOptionPane.showMessageDialog(null,"Dear User! Please Enter Email or Password");
  }
  
  


              }
          

public void addAttatchment(JLabel AttatchmentName)
{
         this.attachmentPath=" ";
         this.attachmentName=" ";
         JFileChooser fc = new JFileChooser();
         fc.showSaveDialog(null);

        try {
            File f = fc.getSelectedFile();
            this.attachmentPath= f.getAbsolutePath();
            this.attachmentName=(f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1));
            AttatchmentName.setText(this.attachmentName);
           
            
        } 
        catch(Exception e)
        {}


}
}