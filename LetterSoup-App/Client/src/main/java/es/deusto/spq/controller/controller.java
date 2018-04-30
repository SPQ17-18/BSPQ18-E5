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

<<<<<<< HEAD
	public List<String> soupList() {
		List<String> listSoup=null;
=======
	
  	public String[] soupList() {
		String [] listSoup=null;
>>>>>>> branch 'HEAD' of https://github.com/SPQ17-18/BSPQ18-E5.git
		try {
			
			listSoup = new String[sl.getService().soupList().size()];
			for(int i = 0; i < sl.getService().soupList().size(); i++) { 
				listSoup[i] = sl.getService().soupList().get(i);
		//	listSoup=sl.getService().soupList(); //error on converting from array to list
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listSoup.size());
		return listSoup;//Takes from the DB all soup names
		
	}
  	
	public SoupDTO getSoup(String name) {
		SoupDTO sDTO=null;
		try {
			sDTO=sl.getService().getSoup(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Takes from the DB the soup with that name
		return sDTO;
	}
	public void sendMail(String message,String email) {//send a message to an email
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
//	public void setScore(User u, int score) throws RemoteException {
//		try {
//		sl.getService().setScore(u,score);
//		}catch(RemoteException e) {
//			e.printStackTrace();
//		}
//	}

		public void exit() {
    	System.exit(0);
    }




		public int getScoreGame(SoupDTO s, String user) {
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
