package es.deusto.spqServer.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.deusto.spqServer.dao.IManagerDAO;
import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.dto.Assembler;
import es.deusto.spqServer.dto.ScoreDTO;
import es.deusto.spqServer.dto.SoupDTO;
import es.deusto.spqServer.gateway.MailSender;
import java.util.Date;
/**Class for creating assembler, DAO manager and mail sender and manage them
 * 
 *
 */
public class LetterSoupManager extends UnicastRemoteObject implements IFacade {
private static final long serialVersionUID = 1L;
	private IManagerDAO dao;
	private Assembler as;
	private MailSender mail;

	public LetterSoupManager(String [] args) throws RemoteException {
		dao= new ManagerDAO();
		as=new Assembler();
	}

	
	public boolean login(String userpass) throws RemoteException {
		return dao.isCorrect(userpass);
	}
	
	public boolean IntroduceSoup(SoupDTO dto) throws RemoteException {
		System.out.println("Introduciendo sopa al server");
		int lastsoupid=dao.getLastSoupId();
		System.out.println(lastsoupid);
		int lastwordid=dao.getLastWordId();
		System.out.println(lastwordid);
		System.out.println("Dissasemble");
		System.out.println(dto.getArrayorientation().size());
		System.out.println(dto.getArrayposx().size());
		System.out.println(dto.getArrayposy().size());
		System.out.println(dto.getArraywords().size());
		System.out.println(dto.getNombre());
		System.out.println(dto.getSize());
		try {
			Soup s=as.disassemble(dto,lastsoupid, lastwordid);
			s.initialize();
			dao.storeSoup(s);
			
		} catch (Exception e) {
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
		System.out.println("empiezo score");
		Soup s=dao.getSoup(sdto.getNombre());
		int score=s.calculatePuntuation(sdto.getArraywords());
		User u=dao.getUser(user);
		Record record=new Record(dao.getLastRecordId(), new Date(System.currentTimeMillis()), score , u);
		u.addRecord(record);
		dao.storeScore(record);
		//dao.deleteUser(u.getUser());
		//dao.storeUser(u);
		System.out.println("acabo score");
		return score;
	}
//	public void setScore(User u, int score) throws RemoteException {
//		Random r=new Random();
//		Date d=new Date();
//		Record record =new Record(r.nextInt(100),d,score,u);
//		//FALTA EN LA DAO GUARDAR RECORD
//	}

	

	
}
