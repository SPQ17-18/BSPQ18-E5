package es.deusto.spq.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacade extends Remote {
	public boolean login(String userpass) throws RemoteException;
		
public boolean register(String username, String password, String userType, String email)throws RemoteException;
		
	
	public String[] soupList() throws RemoteException;//Takes from the DB all soup names
		
	
	public SoupDTO getSoup(String name) throws RemoteException;//Takes from the DB the soup with that name
		
	
	public void sendMail(String message, email) throws RemoteException;//send a message to an email
		
	
	public String getScore(SoupDTO) throws RemoteException;


}
