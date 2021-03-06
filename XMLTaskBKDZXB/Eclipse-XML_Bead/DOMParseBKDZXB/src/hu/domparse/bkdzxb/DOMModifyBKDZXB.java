package hu.domparse.bkdzxb;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;


public class DOMModifyBKDZXB {
	 private static final String FILENAME = "XMLBKDZXB.xml";
	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException, TransformerException {
		// TODO Auto-generated method stub
		// XML f?jl megh?v?sa
				File xmlFile = new File("XMLBKDZXB.xml");
				
				// Documentbuldier defini?l?sa
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = factory.newDocumentBuilder();
				
				// F?jl bet?lt?se a Documentbuldierbe
				Document doc = dBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();
				
				// ?j veezet? hozz?ad?sa
				Element Kosarcsapat = (Element)doc.getElementsByTagName("Kosarcsapat").item(0);
				Kosarcsapat.appendChild(createKosarcsapat(doc, "k4.3","Kis ?ron", "Eg?szs?g?gyi vezet?"));
				
				//Doc ment?s
				SaveAsDoc(doc, "teszt.xml");
	
	}
	public static void SaveAsDoc(Document doc, String filename) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();
		
		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{https://xml.apache.org/.xslt}indent-amount", "2");
		
		DOMSource source = new DOMSource(doc);
		
		File myFile = new File(filename);
		
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);
		
		transf.transform(source, console);
		transf.transform(source, file);
	}
	
	private static Node createKosarcsapat(Document doc, String Vkod, String Vtagok, String Vbeosztas) {
		
		Element user = doc.createElement("Vezetoseg");
		
		user.setAttribute("Vkod", Vkod);
		user.appendChild(createElement(doc, "Vtagok", Vtagok));
		user.appendChild(createElement(doc, "Vbeosztas", Vbeosztas));
		
		return user;
	}
	
	private static Node createElement(Document doc, String name, String value) {
		
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		
		return node;
	}
}

  

