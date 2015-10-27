package com.example.switchyard.camel_calculator;

import org.switchyard.component.bean.Service;

@Service(SumadorService.class)
public class SumadorServiceBean implements SumadorService {

	@Override
	public int operacion(Operando o) {
		return o.getOperador1() + o.getOperador2();
	}

}
