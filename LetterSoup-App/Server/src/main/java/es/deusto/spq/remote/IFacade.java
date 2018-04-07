package es.deusto.spq.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacade extends Remote {
	public boolean login(String userpass) throws RemoteException;
		
	


}
