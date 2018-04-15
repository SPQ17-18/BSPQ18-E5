package es.deusto.spq.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.spq.remote.RMIServiceLocator;

//This class is for calling the remote service 
public class controller {
	private RMIServiceLocator sl;
	
	public controller(String[] args) throws RemoteException {
		sl = new RMIServiceLocator();
		sl.setServices(args[0], args[1], args[2]);
		
	}
	
	//This method returns the service of login user and password 
	public boolean login (String username, String password) {
		boolean login = false;
		String st=username+"#"+password;
		
		try {
			login = sl.getService().login(st);
		} catch (Exception e) {
			System.out.println("A problem occured in the log in.");
			// e.printStackTrace();
		}
		
		return login;
	}
	public boolean register(String username, String password, String userType, String email) {//Returns the service of registering a user
		
	}
	public String[] soupList() {//Takes from the DB all soup names
		
	}
	public SoupDTO getSoup(String name) {//Takes from the DB the soup with that name
		
	}
	public void sendMail(String message, email) {//send a message to an email
		
	}
	public String getScore(SoupDTO) {
		
	}
		public void exit() {
    	System.exit(0);
    }

}
