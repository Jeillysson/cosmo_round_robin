package br.ufal.aracomp.cosmos.main;

import javax.swing.JOptionPane;

import br.ufal.aracomp.cosmos.Cliente.ConectorClient;
import br.ufal.aracomp.cosmos.emprestimo.spec.dataType.ClientDT;


import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;



public class ArchirtecturalConfiguration {
	
	public static void main(String[] args) {
		
//		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite;
		ConectorClient empLimConn;
		br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager compEmprestimo;
		
		//instanciar componente LIMITE
		//compLimite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();
		//obter objeto da interface provida de limite
		//ILimiteOps limiteOps = (ILimiteOps)compLimite.getProvidedInterface("ILimiteOps");
		//instanciar conector
		empLimConn = new ConectorClient();
		//instanciar componente EMPRESTIMO
		compEmprestimo = br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory.createInstance();
		//ligacao da interface requerida de EMPRESTIMO
		compEmprestimo.setRequiredInterface("ILimiteOps", empLimConn);
		
		IEmprestimoOps emprestimoOps = (IEmprestimoOps) compEmprestimo.getProvidedInterface("IEmprestimoOps");
		ClientDT client = new ClientDT();
		String valor = JOptionPane.showInputDialog("Digite o valor");
		client.rendimentos = valor;
		for (int i = 0; i < 10; i ++){
			System.out.println(emprestimoOps.liberarEmprestimoAutomatico(client));
		}
		
	}
}
