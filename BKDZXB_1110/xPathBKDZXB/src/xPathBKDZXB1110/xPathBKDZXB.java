package xPathBKDZXB1110;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import org.xml.sax.SAXException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

public class xPathBKDZXB {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse("studentBKDZXB.xml");
			XPath xPath = XPathFactory.newInstance().newXPath();
			// String expression = "class";
			//1. String expression = "/class/student";
			//2.String expression = "/class/student";
			String expression = "/class/student";
			
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
			for(int i = 0; i < nodeList.getLength(); i++) {
				//4.if(i == 1) {
				//5.if(i == nodeList.getLength()-1) {
				//6.if(i == nodeList.getLength()-2) {
				//7.if(i < 2) {
				Node node = nodeList.item(i);
				System.out.println("\nAktuális elem: " + node.getNodeName());
			
				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
		
					//2. if(element.getAttribute("id").equals("01")) {
					System.out.println("Hallgató ID: " + element.getAttribute("id"));
					System.out.println("Vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
			}
			}
			
		} catch (ParserConfigurationException p) {
		p.printStackTrace();
		} catch (IOException i) {
		i.printStackTrace();
		} catch (SAXException s) {
		s.printStackTrace();
		} catch (XPathExpressionException x) {
		x.printStackTrace();
		}
	}
}
