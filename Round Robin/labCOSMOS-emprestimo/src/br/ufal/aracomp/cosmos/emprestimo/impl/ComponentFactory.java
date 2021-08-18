package br.ufal.aracomp.cosmos.emprestimo.impl;

import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;

public class ComponentFactory {
	private static IManager manager = null;
	//FACTORY METHOD & SINGLETON
	
	private ComponentFactory(){
		
	}
	
	public static IManager createInstance(){
		if(manager == null)
			manager = new Manager();
		return manager;
	}
}
