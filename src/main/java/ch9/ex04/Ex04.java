/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2015/04/06
 */
package main.java.ch9.ex04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author budougumi0617
 * @note Refer to README.md
 */
public class Ex04 {
	public static Stream<String> parseXML(String xmlFileName) {
		List<String> elements = new ArrayList<String>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			File f = new File(xmlFileName);
			Document doc = builder.parse(f);
			Element root = doc.getDocumentElement();
			NodeList children = root.getChildNodes();

			for (int i = 0; i < children.getLength(); i++) {

				Node child = children.item(i);

				if (child instanceof Element) {
					Element childElement = (Element) child;
					elements.add(childElement.getTagName());
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return elements.stream();
	}

	public static void main(String[] args) {
		Ex04.parseXML("./src/main/resources/ch9/dummy.xml").forEach(System.out::println);
		;
	}
}
