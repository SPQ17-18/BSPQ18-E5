//package es.deusto.spq;
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
//import es.deusto.spq.window.ExamMode;
//import es.deusto.spq.window.LoginWindow;
//import es.deusto.spq.window.MenuWindow;
//import es.deusto.spq.window.PointsWindow;
//import es.deusto.spq.window.Register;
//import es.deusto.spq.window.SelectSoup;
//import es.deusto.spqServer.dao.IManagerDAO;
//import es.deusto.spqServer.data.Record;
//import es.deusto.spqServer.data.Soup;
//import es.deusto.spqServer.data.User;
//import es.deusto.spqServer.data.Word;
//import es.deusto.spqServer.dto.Assembler;
//import es.deusto.spqServer.dto.SoupDTO;
//import es.deusto.spqServer.remote.IFacade;
//import es.deusto.spqServer.server.LetterSoupServer;
//import junit.framework.JUnit4TestAdapter;
//import junit.framework.TestCase;
//
///**
// * Unit test for simple App.
// */
//public class AppTest extends TestCase
//{
//	
//	 Record record;
//	 Soup soup;
//	 User user;
//	 Word word;
//	 Assembler assembler;
//	 SoupDTO soupDTO;
//	 String[] args= {"127.0.0.1","1099","LetterSoupServer"};
//	 String[] a ={"s12","s1","s2","s12","s12","s12","s12"};
//	 List<Word> words;
//	
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//	
//    /**
//     * @return the suite of tests being tested
//     */
//
//   // public static Test suite()
//    //{
//       // return new TestSuite( AppTest.class );
//    //}
//
//    /**
//     * Rigourous Test :-)
//     * @throws RemoteException 
//     */
//	
//
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	
//		
//		
//	
//	
//	
//	
//    
//	@Before public void setUp() {
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
//		
//	}
//	
//	@Test public void setController()throws RemoteException {
//		assertTrue(controller.getController().setController(args));
//	}
//	@Test public void login()throws RemoteException {
//		assertTrue(controller.getController().login("a1", "abc"));
//	}
//	@Test public void sendMail() throws RemoteException{
//		assertTrue(controller.getController().sendMail("miau", "aitor.santa@opendeusto.es"));
//	}
//	@Test public void soupList() throws RemoteException{
//		String[] b=controller.getController().soupList();
//		assertTrue(b[0].equals(a[0]));
//	}
//	@Test public void IntroduceSoup() throws RemoteException{
//		controller.getController().IntroduceSoup(soupDTO);
//	}
//	@Test public void getSoup()throws RemoteException {
//		SoupDTO soupDTO2=controller.getController().getSoup("s12");
//		assertEquals(soupDTO.getNombre(), "s12");
//		int a11=controller.getScore("a1").getArrayrecord().get(0);
//		assertEquals(a11,5);
//	}
//	
//	
//}

