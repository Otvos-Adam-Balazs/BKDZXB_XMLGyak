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

public class DomReadBKDZXB {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{
		// XML f?jl megh?v?sa
		File xmlFile = new File("XMLBKDZXB.xml");
		// Documentbuldier defini?l?sa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		// F?jl bet?lt?se a Documentbuldierbe
		Document doc = dBuilder.parse(xmlFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
		
		NodeList aList = doc.getElementsByTagName("Csapat");
		NodeList bList = doc.getElementsByTagName("Jatekosok");
		NodeList cList = doc.getElementsByTagName("Merkozes");
		NodeList dList = doc.getElementsByTagName("Vezetoseg");
		NodeList eList = doc.getElementsByTagName("Tabella");
		
		
			for(int i = 0; i<aList.getLength(); i++) {
			Node nNode = aList.item(i);
			
			System.out.println("\nCurrent Element:" + nNode.getNodeName());
			//Csapat ki?r?sa
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				Element elem = (Element) nNode;
				String uid = elem.getAttribute("Cskod");
				
				Node node1 = elem.getElementsByTagName("Csvaros").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("Cselerhetoseg").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("Csnev").item(0);
				String pname = node3.getTextContent();
				
				System.out.printf("Cskod: %s%n", uid);
				System.out.printf("Csvaros: %s%n", fname);
				System.out.printf("Cselerhetoseg: %s%n", lname);
				System.out.printf("Csnev: %s%n", pname);
				
			}
		}
			//J?t?kosok ki?r?sa
			for(int i = 0; i<bList.getLength(); i++) {
				Node nNode = bList.item(i);
				
				System.out.println("\nCurrent Element:" + nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("Jkod");
					
					Node node1 = elem.getElementsByTagName("Jnev").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("Jeletkor").item(0);
					String lname = node2.getTextContent();
					
					Node node3 = elem.getElementsByTagName("Jmezszam").item(0);
					String pname = node3.getTextContent();
					
					System.out.printf("Jkod: %s%n", uid);
					System.out.printf("Jnev: %s%n", fname);
					System.out.printf("Jeletkor: %s%n", lname);
					System.out.printf("Jemszam: %s%n", pname);
					
				}
			}
			//M?rk?z?sek ki?r?sa
			for(int i = 0; i<cList.getLength(); i++) {
				Node nNode = cList.item(i);
				
				System.out.println("\nCurrent Element:" + nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("Mkod");
					
					Node node1 = elem.getElementsByTagName("MIdo").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("Mhelyszin").item(0);
					String lname = node2.getTextContent();
					
					System.out.printf("Mkod: %s%n", uid);
					System.out.printf("MIdo: %s%n", fname);
					System.out.printf("Mhelyszin: %s%n", lname);
					
				}
			}
			// Vezet?s?gi tagok ki?r?sa
			for(int i = 0; i<dList.getLength(); i++) {
				Node nNode = dList.item(i);
				
				System.out.println("\nCurrent Element:" + nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("Vkod");
					
					Node node1 = elem.getElementsByTagName("Vtagok").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("Vbeosztas").item(0);
					String lname = node2.getTextContent();
					
					System.out.printf("Vkod: %s%n", uid);
					System.out.printf("Vtagok: %s%n", fname);
					System.out.printf("Vbeosztas: %s%n", lname);				
				}
			}
			//Tabella ki?r?sa
			for(int i = 0; i<eList.getLength(); i++) {
				Node nNode = eList.item(i);
				
				System.out.println("\nCurrent Element:" + nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element elem = (Element) nNode;
					String uid = elem.getAttribute("Tkod");
					
					Node node1 = elem.getElementsByTagName("Tmeccszam").item(0);
					String fname = node1.getTextContent();
					
					Node node2 = elem.getElementsByTagName("Thelyezes").item(0);
					String lname = node2.getTextContent();
					
					System.out.printf("Tkod: %s%n", uid);
					System.out.printf("Tmeccszam: %s%n", fname);
					System.out.printf("Thelyezes: %s%n", lname);
					
				}
				//Statisztika ki?r?sa
				NodeList fList = doc.getElementsByTagName("Tstatisztika");
				
				for(int j = 0; j<fList.getLength(); j++) {
					Node mNode = fList.item(i);
					
					if(mNode.getNodeType() == Node.ELEMENT_NODE) {
						Element elem = (Element) nNode;
						Node nodea = elem.getElementsByTagName("Gyozelem").item(0);
						String aname = nodea.getTextContent();
						
						Node nodeb = elem.getElementsByTagName("Vereseg").item(0);
						String bname = nodeb.getTextContent();
						
						Node nodec = elem.getElementsByTagName("Atlag").item(0);
						String cname = nodec.getTextContent();
						System.out.println("Tstatisztika:");
						System.out.printf("Gyozelem: %s%n", aname);
						System.out.printf("Vereseg: %s%n", bname);
						System.out.printf("Atlag: %s%n", cname);
						
						}
				}
			
			}
	}
}
