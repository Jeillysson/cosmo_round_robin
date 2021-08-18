package br.ufal.aracomp.cosmos.SERVERDOIS;

import java.rmi.Remote;

import java.rmi.RemoteException;

public interface ConectorServerDoisInterface extends Remote {
	
	public double liberarEmprestimoAutomatico(String rendimentos) throws RemoteException;

}
