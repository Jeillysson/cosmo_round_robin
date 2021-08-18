package br.ufal.aracomp.cosmos.SERVERPcsDiferens;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import br.ufal.aracomp.cosmos.limite.spec.dataType.ClienteDT;

public class Conector extends UnicastRemoteObject implements ConectorServerInterface{

	private static final long serialVersionUID = 1L;
	
	private br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps limiteOps;
	
	public Conector() throws RemoteException{
		super();
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite;
		compLimite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();
		this.limiteOps = (br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps)compLimite.getProvidedInterface("ILimiteOps");
	}
	
	@Override
	public double liberarEmprestimoAutomatico(String rendimento) throws RemoteException{
		
		ClienteDT cliente2 = new ClienteDT();
		cliente2.salario = Double.parseDouble(rendimento);
		double limite =  this.limiteOps.calcularLimite(cliente2);
		return limite;
	}
	
	public static void main (String args[]){
		try { 
			//-Djava.security.policy=security.policy
			System.setProperty("java.rmi.server.hostname", "172.17.49.201");
			System.setSecurityManager(new SecurityManager());
            LocateRegistry.createRegistry(8080);
            
            Naming.rebind("//172.17.49.201:8080/Conector",new Conector());
            System.err.println("Conector Preparado do Cosmo");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
