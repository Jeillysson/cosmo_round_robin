package br.ufal.aracomp.cosmos.emprestimo.spec.prov;

import br.ufal.aracomp.cosmos.emprestimo.spec.dataType.ClientDT;

public interface IEmprestimoOps {
	public double liberarEmprestimoAutomatico(ClientDT client);
}
