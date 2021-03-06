package es.deusto.spq.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Appender;
import org.apache.log4j.AsyncAppender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.lf5.viewer.LogFactor5Dialog;
import org.datanucleus.util.Log4JLogger;

import es.deusto.spq.remote.RMIServiceLocator;
import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.dto.ScoreDTO;
import es.deusto.spqServer.dto.SoupDTO;

/**
 * 
 * Class for creating RMI connection
 * @autor SPQ-E5
 */
public class controller {
	private final static Logger logger = Logger.getLogger(controller.class.getName());
	
	 
	private static final controller cont= new controller();//singleton instance
	private static RMIServiceLocator sl;
	public controller() {}//singleton object creator
	public static controller getController() {//method for getting the instance
		return cont;
	}

	
	public static boolean setController(String[] args) throws RemoteException {
		sl = new RMIServiceLocator();
		sl.setServices(args[0], args[1], args[2]);
		return true;
	}
	
	
	
	//Login
	public static boolean login (String username, String password) {
		boolean login = false;
		String st=username+"#"+password;
		
		try {
			login = sl.getService().login(st);
		} catch (Exception e) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"A problem occured in the log in."));
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
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"get service"));
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
		logger.addAppender(new ConsoleAppender(new PatternLayout(),"the lenght of the llist is"+listSoup.length));
		
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
	public static boolean sendMail(String message,String email) {//send a message to an email
		boolean sent=false;
		try {
			sl.getService().sendMail(message,email);
			sent=true;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		} 

	return sent;
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
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"Getting service"));
			
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
