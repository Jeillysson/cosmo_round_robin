package br.ufal.aracomp.cosmos.limite.impl;

import br.ufal.aracomp.cosmos.limite.spec.dataType.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

class FacadeLimiteOps implements ILimiteOps {

	@Override
	public double calcularLimite(ClienteDT client) {
		if(client.salario > 0){ 
			return (0.29*(client.salario));
		}
		return 0;
	}

}
