package br.ufal.aracomp.cosmos.emprestimo.spec.req;

import br.ufal.aracomp.cosmos.emprestimo.spec.dataType.ClientDT;

public interface ILimiteOps {
	public double liberarEmprestimoAutomatico(ClientDT client);
}
