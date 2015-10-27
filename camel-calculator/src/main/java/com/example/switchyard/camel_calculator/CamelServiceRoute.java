package com.example.switchyard.camel_calculator;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRoute extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://CalcularService").log(
				"Received message for 'CalcularService' : ${body}")
				.choice()
					.when(header("org.switchyard.soap.messageName").isEqualTo("sum"))
						.to("switchyard://SumadorService")
					.when(header("org.switchyard.soap.messageName").isEqualTo("substract"))
						.to("switchyard://RestadorService");
//					.otherwise()
//						.to("switchyard://RestadorService");
	}

}
