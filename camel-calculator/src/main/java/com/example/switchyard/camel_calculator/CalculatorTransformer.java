package com.example.switchyard.camel_calculator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class CalculatorTransformer {

	@Transformer(to = "{urn:com.example.switchyard:camel-calculator:1.0}substractResponse")
	public Element transformIntToSubstractResponse(int from) {
		return setResponse(from);
	}

	@Transformer(to = "{urn:com.example.switchyard:camel-calculator:1.0}sumResponse")
	public Element transformIntToSumResponse(int from) {
		return setResponse(from);
	}

	@Transformer(from = "{urn:com.example.switchyard:camel-calculator:1.0}substract")
	public Operando transformSubstractToOperando(Element from) {
		return getOperando(from);
	}

	@Transformer(from = "{urn:com.example.switchyard:camel-calculator:1.0}sum")
	public Operando transformSumToOperando(Element from) {
		return getOperando(from);
	}
	
	private Element setResponse(int result){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			Element element = doc.createElement("return");
			element.appendChild(doc.createTextNode(String.valueOf(result)));
			
			return element;
		} catch (Throwable ex) {
			return null;
		}		
	}

	private Operando getOperando(Element from){
		Operando operando = new Operando();
		int x = 0;
		int y = 0;
		for (int i = 0; i < from.getChildNodes().getLength(); i++) {
			Node node = from.getChildNodes().item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				for(int j = 0; j < node.getChildNodes().getLength(); j++){
					Node subNode = node.getChildNodes().item(j);
					if (subNode.getNodeType() == Node.ELEMENT_NODE) {
						Element child = (Element)subNode;
						if (child.getNodeName() != null && child.getNodeName().equals("operador1")) {
							x = Integer.parseInt(child.getTextContent());
						}
						if (child.getNodeName() != null && child.getNodeName().equals("operador2")) {
							y = Integer.parseInt(child.getTextContent());
						}
					}
				}
			}
		}

		operando.setOperador1(x);
		operando.setOperador2(y);
		
		return operando;		
	}	

}
