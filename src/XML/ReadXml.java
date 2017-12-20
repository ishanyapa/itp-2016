/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;


import RootElement.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.nio.charset.Charset;
/**
 *
 * @author Ishan
 */
public class ReadXml {
    
    public void Read(){
    try {

	File fXmlFile = new File("src/GeneratedXml/DBXml.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("Database");
			
	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                   
                    DbConnect.url = eElement.getElementsByTagName("Name").item(0).getTextContent();
                    DbConnect.username = eElement.getElementsByTagName("Username").item(0).getTextContent();
                    GenerateBase64 newBase = new GenerateBase64();
                    byte[] encodedBytes = eElement.getElementsByTagName("Password").item(0).getTextContent().getBytes();
                    String newPassword = new String(newBase.DecBase64(encodedBytes),Charset.forName("UTF-8"));
                    DbConnect.password = newPassword;
                    
                    MySqlConnect.url=eElement.getElementsByTagName("Name").item(0).getTextContent();
                    MySqlConnect.username=eElement.getElementsByTagName("Username").item(0).getTextContent();
                    MySqlConnect.password=newPassword;
                        
                    SalesDBConnect.url=eElement.getElementsByTagName("Name").item(0).getTextContent();
                    SalesDBConnect.username=eElement.getElementsByTagName("Username").item(0).getTextContent();
                    SalesDBConnect.password=newPassword;
		}
	}
    } catch (Exception e) {
	
    }
    }
}
