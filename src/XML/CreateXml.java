/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import RootElement.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
/**
 *
 * @author Ishan
 */
public class CreateXml {
    
    public void GenerateXml(String id, String dbName, String username, String password){
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("Kelani Cables", "Databases");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            GenerateBase64 newBase = new GenerateBase64();
            String newPassword = newBase.EnBase64(password);
            mainRootElement.appendChild(getDatabase(doc, id, dbName, username, newPassword));
           
 
            // output DOM XML to console 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult("src/GeneratedXml/DBXml.xml");
           
            transformer.transform(source, console);
 
            System.out.println("\nXML DOM Created Successfully..");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private static Node getDatabase(Document doc, String id, String name, String username, String password) {
        Element company = doc.createElement("Database");
        company.setAttribute("id", id);
        company.appendChild(getDbElements(doc, company, "Name", name));
        company.appendChild(getDbElements(doc, company, "Username", username));
        company.appendChild(getDbElements(doc, company, "Password", password));
        return company;
    }
 
    // utility method to create text node
    private static Node getDbElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
