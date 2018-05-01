package es.deusto.spqServer.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.deusto.spqServer.dao.IManagerDAO;
import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.dto.Assembler;
import es.deusto.spqServer.dto.ScoreDTO;
import es.deusto.spqServer.dto.SoupDTO;
import es.deusto.spqServer.gateway.MailSender;

/**Class for creating assembler, DAO manager and mail sender and manage them
 * 
 *
 */
public class LetterSoupManager extends UnicastRemoteObject implements IFacade {
private static final long serialVersionUID = 1L;
	private IManagerDAO dao;
	private Assembler as;
	private MailSender mail;
	private final static Logger logger = Logger.getLogger(LetterSoupManager.class.getName());


	public LetterSoupManager(String [] args) throws RemoteException {
		dao= new ManagerDAO();
		as=new Assembler();
	}

	
	public boolean login(String userpass) throws RemoteException {
		return dao.isCorrect(userpass);
	}
	
	public boolean IntroduceSoup(SoupDTO dto) throws RemoteException {
		logger.addAppender(new ConsoleAppender(new PatternLayout(),"Introduciendo sopa al server"));
    	int lastsoupid=dao.getLastSoupId();
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+lastsoupid));
    	int lastwordid=dao.getLastWordId();
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+lastwordid));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),"Dissasemble"));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+dto.getArrayorientation().size()));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+dto.getArrayposx().size()));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+dto.getArrayposy().size()));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+dto.getArraywords().size()));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+dto.getNombre()));
    	logger.addAppender(new ConsoleAppender(new PatternLayout(),""+dto.getSize()));
    	try {
			Soup s=as.disassemble(dto,lastsoupid, lastwordid);
			s.initialize();
			dao.storeSoup(s);
			
		} catch (Exception e) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),""+e.getMessage()));
	    	
			e.printStackTrace();
			// TODO: handle exception
			return false;
		}
		
		return true;
		
	}


	@Override
	public boolean register(String user) throws RemoteException {
		String[] result = user.split("#");
		dao.storeUser(new User(result[0],result[1],result[2].charAt(0),result[3]));
		return false;
	}


	@Override
	public String [] soupList() throws RemoteException {
		// TODO Auto-generated method stub
		String [] list=dao.getSoups();
		return list;

	}


	@Override
	public SoupDTO getSoup(String name) throws RemoteException {
		// TODO Auto-generated method stub
		Soup s=dao.getSoup(name);
		return as.assemble(s);
	}


	@Override
	public void sendMail(String message, String email) throws RemoteException {
		mail=new MailSender(email);
		mail.sendMessage(message);
		
		//  Auto-generated method stub
		mail=new MailSender(email);
		mail.sendMessage(message);
	}


	@Override
	public ArrayList<Record> getScore(User u) throws RemoteException {
		return null;
	}
	public ScoreDTO getScore(String u) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Record> arrRecord=dao.getRecords(u);
		return as.assemble(arrRecord);
	}


	@Override
	public int getScoreGame(SoupDTO sdto,String user) throws RemoteException {
		// TODO Auto-generated method stub
		
		Soup s=dao.getSoup(sdto.getNombre());
		int score=s.calculatePuntuation(sdto.getArraywords());
		User u=dao.getUser(user);
		dao.deleteUser(u.getUser());
		int n=dao.getAllUser().size();
		System.out.println(n);
		//IManagerDAO dao2=new ManagerDAO();
		
		if(n==0) {
			
		Record record=new Record(dao.getLastRecordId(), new Date(System.currentTimeMillis()), score , u);
		u.addRecord(record);
		//dao.storeScore(record);
		dao.storeUser(u);
		}
		System.out.println("salgo");
		return score;
	}
//	public void setScore(User u, int score) throws RemoteException {
//		Random r=new Random();
//		Date d=new Date();
//		Record record =new Record(r.nextInt(100),d,score,u);
//		//FALTA EN LA DAO GUARDAR RECORD
//	}

	

	
}
