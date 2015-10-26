package com.example.switchyard.switchyard_camel_helloworld;

import org.apache.camel.builder.RouteBuilder;

public class CamelServiceRouteHalloween extends RouteBuilder {

	/**
	 * The Camel route is configured via this method.  The from endpoint is required to be a SwitchYard service.
	 */
	public void configure() {
		// TODO Auto-generated method stub
		from("switchyard://GreetingsHalloween").log(
				"Happy Halloween, sweet or treat : ${body}");
	}

}
