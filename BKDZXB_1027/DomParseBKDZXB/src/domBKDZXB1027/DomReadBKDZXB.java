package domBKDZXB1027;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadBKDZXB {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{
		
		File xmlFile = new File("usersBKDZXB.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("user");
		
		
		
		for(int i = 0; i<nList.getLength(); i++) {
			Node nNode = nList.item(i);
			
			System.out.println("\nCurrent Element:" + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("id");
				
				Node node1 = elem.getElementsByTagName("firstname").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("lastname").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("profession").item(0);
				String pname = node3.getTextContent();
				
				System.out.printf("User id: %s%n", uid);
				System.out.printf("First Name: %s%n", fname);
				System.out.printf("Last Name: %s%n", lname);
				System.out.printf("Profession: %s%n", pname);
				
			}
		}

	}

}
