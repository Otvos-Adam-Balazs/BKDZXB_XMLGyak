package hu.domparse.bkdzxb;

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

public class DomQueryBKDZXB {

		public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
			// XML f?jl megh?v?sa
			File xmlFile = new File("XMLBKDZXB.xml");
			
			// Documentbuldier defini?l?sa
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			
			// F?jl bet?lt?se a Documentbuldierbe
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			
			NodeList jatekosList = doc.getElementsByTagName("Jatekosok");
			for (int j = 0; j < jatekosList.getLength(); j++) {
				Node jNode = jatekosList.item(j);
				
				// Ki?ratjuk a 22 ?ves j?t?kosokat.
				PrintJatekos(jNode, "22");
			}
	}
		private static void PrintJatekos(Node nNode, String kor) {
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String Jkod = elem.getAttribute("Jkod");
				
				Node node1 = elem.getElementsByTagName("Jnev").item(0);
				String Jnev = node1.getTextContent();
			
				Node node2 = elem.getElementsByTagName("Jeletkor").item(0);
				String Jeletkor = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("Jmezszam").item(0);
				String Jmezszam = node3.getTextContent();
				
				// Csak akkor ?rjuk ki ha a keresett korral megegyezik
				if(kor.equals(Jeletkor)) {
					System.out.println("\n--- Jatekos ---");
					System.out.printf("Jkod: %s%n", Jkod);
					System.out.printf("Jnev: %s%n", Jnev);
					System.out.printf("Jeletkor: %s%n", Jeletkor);
					System.out.printf("Jmezszam: %s%n", Jmezszam);
				}
			}
		}
}
