/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esercizioxml;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;
/**
 *
 * @author vasile
 */

public class EsercizioXml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
         File inputFile = new File("rub.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("persona");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("nome : " 
                  + eElement
                  .getElementsByTagName("nome")
                  .item(0)
                  .getTextContent());
               System.out.println("cognome : " 
                  + eElement
                  .getElementsByTagName("cognome")
                  .item(0)
                  .getTextContent());
               System.out.println("telefono casa : " 
                  + eElement
                  .getElementsByTagName("telefono_casa")
                  .item(0)
                  .getTextContent());
               System.out.println("indirizzo email : " 
                  + eElement
                  .getElementsByTagName("indirizzo_email")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
      }
   }

    }
    

