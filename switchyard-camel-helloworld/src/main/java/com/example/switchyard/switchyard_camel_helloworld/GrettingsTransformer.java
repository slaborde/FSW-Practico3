package com.example.switchyard.switchyard_camel_helloworld;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class GrettingsTransformer {

	@Transformer(from = "{urn:com.example.switchyard:switchyard-camel-helloworld:1.0}sayHello")
	public String transformSayHelloToString(Element from) {
		return from.getTextContent();
	}

}
