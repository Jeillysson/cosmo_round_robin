package br.ufal.aracomp.cosmos.SERVERDOIS;

import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import br.ufal.aracomp.cosmos.limite.spec.dataType.ClienteDT;
import br.ufal.aracomp.cosmos.limite2.spec.dataType.ClienteDT2;

public class Conector extends UnicastRemoteObject implements ConectorServerDoisInterface{

	private static final long serialVersionUID = 1L;
	
	private br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps limiteOps;
	private br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2 limiteOps2;
	
	public Conector() throws RemoteException{
		super();
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite;
		compLimite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();
		this.limiteOps = (br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps)compLimite.getProvidedInterface("ILimiteOps");
		
		br.ufal.aracomp.cosmos.limite2.spec.prov.IManager compLimite2;
		compLimite2 = br.ufal.aracomp.cosmos.limite2.impl.ComponentFactory.createInstance();
		this.limiteOps2 = (br.ufal.aracomp.cosmos.limite2.spec.prov.ILimiteOps2)compLimite2.getProvidedInterface("ILimiteOps2");
	}
	
	@Override
	public double liberarEmprestimoAutomatico(String rendimento) throws RemoteException{
		
		ClienteDT cliente2 = new ClienteDT();
		ClienteDT2 cliente3 = new ClienteDT2();
		
		cliente2.salario = Double.parseDouble(rendimento);
		cliente3.salario = Double.parseDouble(rendimento);
		
		double limite =  this.limiteOps.calcularLimite(cliente2);
		double limite2 =  this.limiteOps2.calcularLimite(cliente3);
		
		System.out.println("Limite 1 tem o valor de "+ limite);
		System.out.println("Limite 1 tem o valor de "+ limite2);
		
		double media = 0;
		double percentual = ((limite2 - limite) * 100)/limite;
		if( percentual <= 5){
			media = (limite + limite2)/2;
		}
		return media;
		
	}
	
	public static void main (String args[]){
		try { 
            LocateRegistry.createRegistry(2021);
            
            Naming.rebind("//localhost:2021/Conector",new Conector());
            System.err.println("Servidor 2 Preparado ");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
