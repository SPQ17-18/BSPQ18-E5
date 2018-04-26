package es.deusto.spq.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import es.deusto.spq.remote.RMIServiceLocator;
import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.dto.ScoreDTO;
import es.deusto.spqServer.dto.SoupDTO;

/**
 * 
 * Class for creating RMI connection
 *
 */
public class controller {
	private RMIServiceLocator sl;
	
	public controller(String[] args) throws RemoteException {
		sl = new RMIServiceLocator();
		sl.setServices(args[0], args[1], args[2]);
		
	}
	
	
	
	//Login
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

	/**
	 * Method for introducing DTO Soups into Database
	 * @return the soup that has been introduced into DB
	 */
	public boolean IntroduceSoup(SoupDTO dto) {
		boolean soupintroduced = false;
		try {
			System.out.println("get service");
			soupintroduced=sl.getService().IntroduceSoup(dto);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return soupintroduced;
	}
	
	

	public boolean register(String username, String password, String userType, String email) {
		try {
			return sl.getService().register(username+"#"+password+"#"+userType+"#"+email);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public List<String> soupList() {
		try {
			return sl.getService().soupList();
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}//Takes from the DB all soup names
		return null;
	}
	public SoupDTO getSoup(String name) {
		try {
			return sl.getService().getSoup(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//Takes from the DB the soup with that name
		return null;
	}
	public void sendMail(String message,String email) {//send a message to an email
		try {
			sl.getService().sendMail(message,email);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		} 

	
	}

	public ArrayList<Record> getScore(User u) {
		try {
			return sl.getService().getScore(u);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @return the score from the users
	 */
	public ScoreDTO getScore(String u) {
		ScoreDTO score=null;
		try {
			System.out.println("get service");
			score=sl.getService().getScore(u);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
		return score;
	}
	public void setScore(User u, int score) throws RemoteException {
		try {
		sl.getService().setScore(u,score);
		}catch(RemoteException e) {
			e.printStackTrace();
		}
	}

		public void exit() {
    	System.exit(0);
    }
		

}
