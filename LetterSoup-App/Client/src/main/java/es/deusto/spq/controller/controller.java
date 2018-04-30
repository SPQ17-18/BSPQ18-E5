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
	private static final controller cont= new controller();//singleton instance
	private static RMIServiceLocator sl;
	public controller() {}//singleton object creator
	public static controller getController() {//method for getting the instance
		return cont;
	}
	
	public static void setController(String[] args) throws RemoteException {
		sl = new RMIServiceLocator();
		sl.setServices(args[0], args[1], args[2]);
		
	}
	
	
	
	//Login
	public static boolean login (String username, String password) {
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
	public static boolean IntroduceSoup(SoupDTO dto) {
		boolean soupintroduced = false;
		try {
			System.out.println("get service");
			soupintroduced=sl.getService().IntroduceSoup(dto);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return soupintroduced;
	}
	
	

	//public boolean register(String username, String password, String userType, String email) {
		//try {
			//return sl.getService().register(username+"#"+password+"#"+userType+"#"+email);
		//} catch (RemoteException e) {
			
			//e.printStackTrace();
		//}
		//return false;
	//}
/**
 * 
 * @return list with all soup names from db
 */

	public static String[] soupList() {
		String[] listSoup=null;
		try {
				listSoup = sl.getService().soupList();
		//	listSoup=sl.getService().soupList(); //error on converting from array to list
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listSoup.length);
		return listSoup;//Takes from the DB all soup names
		
	}
  	
	public static SoupDTO getSoup(String name) {
		SoupDTO sDTO=null;
		try {
			sDTO=sl.getService().getSoup(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Takes from the DB the soup with that name
		return sDTO;
	}
	public static void sendMail(String message,String email) {//send a message to an email
		try {
			sl.getService().sendMail(message,email);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		} 

	
	}

	//public ArrayList<Record> getScore(User u) {
		//try {
			//return sl.getService().getScore(u);
		//} catch (RemoteException e) {
		
			//e.printStackTrace();
		//}
		//return null;
	//}
	/**
	 * @return the score from the users
	 */
	public static ScoreDTO getScore(String u) {
		ScoreDTO score=null;
		try {
			System.out.println("get service");
			score=sl.getService().getScore(u);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
		return score;
	}
//	public void setScore(User u, int score) throws RemoteException {
//		try {
//		sl.getService().setScore(u,score);
//		}catch(RemoteException e) {
//			e.printStackTrace();
//		}
//	}

		public static void exit() {
    	System.exit(0);
    }




		public static int getScoreGame(SoupDTO s, String user) {
			// TODO Auto-generated method stub
			int score=-1;
			try {
				score=sl.getService().getScoreGame(s, user);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return score;
			
		}
		

}
