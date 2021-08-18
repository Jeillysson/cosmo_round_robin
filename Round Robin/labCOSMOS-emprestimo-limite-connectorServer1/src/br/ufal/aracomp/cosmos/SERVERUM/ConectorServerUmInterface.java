package br.ufal.aracomp.cosmos.SERVERUM;

import java.rmi.Remote;

import java.rmi.RemoteException;

public interface ConectorServerUmInterface extends Remote {
	
	public double liberarEmprestimoAutomatico(String rendimentos) throws RemoteException;

}
