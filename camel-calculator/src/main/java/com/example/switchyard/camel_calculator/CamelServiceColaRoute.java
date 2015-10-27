package com.example.switchyard.camel_calculator;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceColaRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://RecibirCola").log(
				"Received message for 'RecibirCola' : ${body}")
				.to("switchyard://EnviarCola");
	}

}
