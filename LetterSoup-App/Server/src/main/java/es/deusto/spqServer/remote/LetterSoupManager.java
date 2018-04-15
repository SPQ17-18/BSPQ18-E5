package es.deusto.spqServer.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.spqServer.dao.IManagerDAO;
import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.dto.Assembler;
import es.deusto.spqServer.dto.SoupDTO;


public class LetterSoupManager extends UnicastRemoteObject implements IFacade {
private static final long serialVersionUID = 1L;
	private IManagerDAO dao;
	private Assembler as;
	
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
	

	
}
