package com.example.switchyard.switchyard_camel_helloworld;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class HalloweenTransformer {

	@Transformer(to = "{urn:com.example.switchyard:switchyard-camel-helloworld:1.0}string")
	public Element transformStringToString(String from) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = builder.newDocument();
		
		Element rootElement = doc.createElement("return");
		rootElement.appendChild(doc.createTextNode( String.valueOf(from)));
		
		return rootElement;
	}

	@Transformer(from = "{urn:com.example.switchyard:switchyard-camel-helloworld:1.0}string")
	public String transformStringToString1(Element from) {
		return from.getTextContent();
	}

}
