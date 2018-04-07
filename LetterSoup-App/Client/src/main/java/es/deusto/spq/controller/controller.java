package es.deusto.spq.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.spq.remote.RMIServiceLocator;


public class controller {
	private RMIServiceLocator sl;
	
	public controller(String[] args) throws RemoteException {
		sl = new RMIServiceLocator();
		sl.setServices(args[0], args[1], args[2]);
		
	}
	
	
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
	
		public void exit() {
    	System.exit(0);
    }

}
