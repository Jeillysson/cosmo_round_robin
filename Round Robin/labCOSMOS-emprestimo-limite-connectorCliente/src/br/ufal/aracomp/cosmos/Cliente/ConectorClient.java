package br.ufal.aracomp.cosmos.Cliente;

import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.ufal.aracomp.cosmos.SERVERTRES.ConectorServerTresInterface;
import br.ufal.aracomp.cosmos.SERVERDOIS.ConectorServerDoisInterface;
import br.ufal.aracomp.cosmos.SERVERUM.ConectorServerUmInterface;
import br.ufal.aracomp.cosmos.emprestimo.spec.dataType.ClientDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteOps;



public class ConectorClient implements ILimiteOps {
	
	private static int cont;
	
	private ConectorServerUmInterface conSerInter;
	private ConectorServerDoisInterface conSerInter2;
	private ConectorServerTresInterface conSerInter3;
	
	public ConectorClient(){
		
	}
	
	private double executarServidor(int cont, ClientDT client){
		int num = cont % 4;
		double limite = 0;
		if (num == 1){
			try{
				System.out.println("Sevidor 1");
				this.conSerInter = (ConectorServerUmInterface) Naming.lookup( "//localhost:2020/Conector");
				limite = conSerInter.liberarEmprestimoAutomatico(client.rendimentos);
				System.out.println(limite);
				
			}catch (MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("Nenhum Servidor foi Encontrado");
				e.printStackTrace();
			}
		} else if (num == 2 || num == 3){
			try{
				System.out.println("Sevidor 2");
				this.conSerInter2 = (ConectorServerDoisInterface) Naming.lookup( "//localhost:2021/Conector");
				limite = conSerInter2.liberarEmprestimoAutomatico(client.rendimentos);
				System.out.println(limite);
			}catch (MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("Nenhum Servidor foi Encontrado");
				e.printStackTrace();
				
			}
		} else if (num == 0){
			try{
				System.out.println("Sevidor 3");
				this.conSerInter3 = (ConectorServerTresInterface) Naming.lookup( "//localhost:2022/Conector");
				limite = conSerInter3.liberarEmprestimoAutomatico(client.rendimentos);
				System.out.println(limite);
				cont = 0;
			}catch (MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("Nenhum Servidor foi Encontrado");
				e.printStackTrace();
			}
		} 	
		return limite;
	}
	
	public double liberarEmprestimoAutomatico(ClientDT client){
		cont ++;
		
		return executarServidor(cont, client);

	}
}
