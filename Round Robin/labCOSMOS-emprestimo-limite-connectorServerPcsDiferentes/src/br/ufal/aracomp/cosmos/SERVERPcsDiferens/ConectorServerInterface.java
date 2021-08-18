package br.ufal.aracomp.cosmos.SERVERPcsDiferens;

import java.rmi.Remote;

import java.rmi.RemoteException;

public interface ConectorServerInterface extends Remote {
	
	public double liberarEmprestimoAutomatico(String rendimentos) throws RemoteException;

}
