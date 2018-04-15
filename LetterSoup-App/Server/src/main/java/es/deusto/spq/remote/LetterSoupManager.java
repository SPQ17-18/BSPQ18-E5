package es.deusto.spq.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.spq.dao.IManagerDAO;
import es.deusto.spq.dao.ManagerDAO;
import es.deusto.spq.gateway.MailSender;

public class LetterSoupManager extends UnicastRemoteObject implements IFacade {
private static final long serialVersionUID = 1L;
	private IManagerDAO dao;
	private MailSender mail;
	
	public LetterSoupManager(String [] args) throws RemoteException {
		dao= new ManagerDAO();
	}

	public boolean login(String userpass) throws RemoteException {
		return dao.isCorrect(userpass);
	}
	
	public boolean register(String user, String password, String rol, String email) throws RemoteException {
		User user= new User(user,password,rol,email);
		dao.storeObject(user);
		return true;
	}
	
	public String[] soupList() throws RemoteException{
		return dao.soupList();
	}
		
	
	public SoupDTO getSoup(String name) throws RemoteException{
		return dao.getSoup();
	}
		
	
	public void sendMail(String message, email) throws RemoteException{
		mail=MailSender(email);
		mail.sendMessage(message);
	}
		
	
	public void getScore(int score) throws RemoteException{
		dao.storeRecord(User user, int score);
	}
	
}
