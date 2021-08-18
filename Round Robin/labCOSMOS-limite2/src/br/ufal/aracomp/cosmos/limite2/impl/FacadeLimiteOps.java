package br.ufal.aracomp.cosmos.limite2.impl;

import br.ufal.aracomp.cosmos.limite2.spec.dataType.ClienteDT2;
import br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2;

class FacadeLimiteOps implements ILimiteOps2 {

	@Override
	public double calcularLimite(ClienteDT2 client) {
		if(client.salario > 0){ 
			return (0.30*(client.salario));
		}
		return 0;
	}

}
