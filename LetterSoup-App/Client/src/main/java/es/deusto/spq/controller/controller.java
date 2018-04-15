package es.deusto.spq.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


import es.deusto.spq.remote.RMIServiceLocator;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.dto.ScoreDTO;
import es.deusto.spqServer.dto.SoupDTO;


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

	
	public boolean IntroduceSoup(SoupDTO dto) {
		boolean soupintroduced = false;
		try {
			System.out.println("get service");
			soupintroduced=sl.getService().IntroduceSoup(dto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soupintroduced;
	}
	
	

	public boolean register(String username, String password, String userType, String email) {
		return false;
		
	}
	public String[] soupList() {
		return null;//Takes from the DB all soup names
		
	}
	public SoupDTO getSoup(String name) {
		return null;//Takes from the DB the soup with that name
		
	}
	public void sendMail(String message,String email) {//send a message to an email
		
	}
	public ScoreDTO getScore(String u) {
		ScoreDTO score=null;
		try {
			System.out.println("get service");
			score=sl.getService().getScore(u);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return score;
	}

		public void exit() {
    	System.exit(0);
    }
		

}
