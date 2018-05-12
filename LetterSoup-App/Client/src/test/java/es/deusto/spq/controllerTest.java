//package es.deusto.spq;
//
//import static org.junit.Assert.*;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import es.deusto.spq.controller.controller;
//import es.deusto.spqServer.data.Record;
//import es.deusto.spqServer.data.Soup;
//import es.deusto.spqServer.data.User;
//import es.deusto.spqServer.data.Word;
//import es.deusto.spqServer.dto.Assembler;
//import es.deusto.spqServer.dto.SoupDTO;
//
//public class controllerTest {
//
//	Record record;
//	 Soup soup;
//	 User user;
//	 Word word;
//	 Assembler assembler;
//	 SoupDTO soupDTO;
//	 String[] args= {"127.0.0.1","1099","LetterSoupServer"};
//	 String[] a ={"s12","s1","s2","s12","s12","s12","s12"};
//	 List<Word> words;
//    
//	@Before public void setUp()throws RemoteException {
//		 words=new ArrayList();
//		
//		 user=new User("a1","abc", 'S', "a1@gmail.com");
//			record= new Record(1, new Date(), 1, user);
//			soup=new Soup(1,"Ny","NYNY",2,words);
//			word=new Word(1, 'H', "Ny", 1, 1, soup);
//			words.add(word);
//			assembler= new Assembler();
//			 ArrayList<String> arraywords=new ArrayList<String>();
//			 
//			 ArrayList<Integer> arrayposx=new ArrayList<Integer>();
//			 ArrayList<Integer> arrayposy=new ArrayList<Integer>();
//			 ArrayList<Character> arrayorientation=new ArrayList<Character>();
//			 
//			 arraywords.add(soup.getWords().get(0).getWord());
//			 arrayposx.add(soup.getWords().get(0).getX());
//			 arrayposy.add(soup.getWords().get(0).getY());
//			 arrayorientation.add(soup.getWords().get(0).getPosition());
//			
//			soupDTO = new SoupDTO(arraywords,arrayposx,arrayposy,arrayorientation,2,"s12");
//			controller.getController();
//			controller.setController(args);
//	}
//	
//	@Test public void setController()throws RemoteException {
//		controller.getController();
//		assertTrue(controller.setController(args));
//	}
//	@Test public void login()throws RemoteException {
//		controller.getController();
//		assertTrue(controller.login("a1", "abc"));
//	}
//	@Test public void sendMail() throws RemoteException{
//		controller.getController();
//		assertTrue(controller.sendMail("miau", "aitor.santa@opendeusto.es"));
//	}
//	@Test public void soupList() throws RemoteException{
//		controller.getController();
//		String[] b=controller.soupList();
//		assertTrue(b[0].equals(a[0]));
//	}
//	@Test public void IntroduceSoup() throws RemoteException{
//		controller.getController();
//		controller.IntroduceSoup(soupDTO);
//	}
//	@Test public void getSoup()throws RemoteException {
//		controller.getController();
//		SoupDTO soupDTO2=controller.getSoup("s12");
//		assertEquals(soupDTO.getNombre(), "s12");
//		int a11=controller.getScore("a1").getArrayrecord().get(0);
//		assertEquals(a11,5);
//	}
//
//}
