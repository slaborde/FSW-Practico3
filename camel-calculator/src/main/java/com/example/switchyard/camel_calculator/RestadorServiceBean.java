package com.example.switchyard.camel_calculator;

import org.switchyard.component.bean.Service;

@Service(RestadorService.class)
public class RestadorServiceBean implements RestadorService {

	@Override
	public int operacion(Operando o) {
		return o.getOperador1() - o.getOperador2();
	}

}
