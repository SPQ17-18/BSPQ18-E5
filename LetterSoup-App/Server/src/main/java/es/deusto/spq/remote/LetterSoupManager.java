package es.deusto.spq.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.spq.dao.IManagerDAO;
import es.deusto.spq.dao.ManagerDAO;
//Façade
public class LetterSoupManager extends UnicastRemoteObject implements IFacade {
private static final long serialVersionUID = 1L;
	private IManagerDAO dao;
	
	public LetterSoupManager(String [] args) throws RemoteException {
		dao= new ManagerDAO();
	}

	public boolean login(String userpass) throws RemoteException {
		return dao.isCorrect(userpass);
	}

	
}
