package br.ufal.aracomp.cosmos.emprestimo.impl;

import br.ufal.aracomp.cosmos.emprestimo.spec.dataType.ClientDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteOps;

class FacadeEmprestimoOps implements IEmprestimoOps {

	private IManager maneger;
	
	FacadeEmprestimoOps(IManager manager){
		this.maneger = manager;
	}
	
	@Override
	public double liberarEmprestimoAutomatico(ClientDT client) {
		double rendimento = 0;
		try {
			rendimento = Double.parseDouble(client.rendimentos);
		}catch (NumberFormatException e){
			client.rendimentos = client.rendimentos.replaceAll(",", ".");
			rendimento = Double.parseDouble(client.rendimentos);
		}
		
		if (rendimento > 1000){
			ILimiteOps intReq = (ILimiteOps)this.maneger.getRequiredInterface("ILimiteOps");
			double limite = intReq.liberarEmprestimoAutomatico(client);
			return limite = 0.9*limite;
		}
		return 0;
	}

}
