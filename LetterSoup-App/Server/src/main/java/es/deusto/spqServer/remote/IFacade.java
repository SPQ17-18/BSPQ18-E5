package es.deusto.spqServer.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.deusto.spqServer.dto.SoupDTO;



public interface IFacade extends Remote {
	public boolean login(String userpass) throws RemoteException;
	public boolean IntroduceSoup(SoupDTO dto) throws RemoteException;
		
	


}
