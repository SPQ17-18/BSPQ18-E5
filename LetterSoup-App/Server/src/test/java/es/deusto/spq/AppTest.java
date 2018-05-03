//package es.deusto.spq;
//
//import java.net.MalformedURLException;
//import java.rmi.Naming;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import es.deusto.spqServer.dao.IManagerDAO;
//import es.deusto.spqServer.dao.ManagerDAO;
//import es.deusto.spqServer.data.Record;
//import es.deusto.spqServer.data.Soup;
//import es.deusto.spqServer.data.User;
//import es.deusto.spqServer.data.Word;
//import es.deusto.spqServer.dto.Assembler;
//import es.deusto.spqServer.dto.SoupDTO;
//import es.deusto.spqServer.remote.IFacade;
//import es.deusto.spqServer.remote.LetterSoupManager;
//import es.deusto.spqServer.server.LetterSoupServer;
//import junit.framework.JUnit4TestAdapter;
//import junit.framework.TestCase;
//
///**
// * Unit test for simple App.
// */
//public class AppTest extends TestCase
//{
//	 Record record;
//	 Soup soup;
//	 User user;
//	 Word word;
//	 Assembler assembler;
//	 SoupDTO soupDTO;
//	 IManagerDAO dao;
//	 IFacade letterSoupManager;
//	 LetterSoupServer letterSoupServer;
//	 String[] args= {"127.0.0.1","1099","LetterSoupServer"};
//	
//	 
////	@Test public void setUp() throws RemoteException {
////		System.out.println("ha entrado aqui");
////		user=new User("a1","abc", 'S', "a1@gmail.com");
////		record= new Record(1, new Date(), 1, user);
////		soup=new Soup(1,2,"Nya");
////		word=new Word(1, 'v', "Nya", 1, 1, soup);
////		dao=new ManagerDAO();
////		assembler= new Assembler();
////		 ArrayList<String> arraywords=new ArrayList<String>();
////		 
////		 ArrayList<Integer> arrayposx=new ArrayList<Integer>();
////		 ArrayList<Integer> arrayposy=new ArrayList<Integer>();
////		 ArrayList<Character> arrayorientation=new ArrayList<Character>();
////		 
////		 arraywords.add(soup.getWords().get(0).getWord());
////		 arrayposx.add(soup.getWords().get(0).getX());
////		 arrayposy.add(soup.getWords().get(0).getY());
////		 arrayorientation.add(soup.getWords().get(0).getPosition());
////		
////		soupDTO = new SoupDTO(arraywords,arrayposx,arrayposy,arrayorientation,2,"Nya");
////		
////		try {
////			letterSoupManager=new LetterSoupManager(args);
////		} catch (RemoteException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////
////		 soupDTO.toString();
////	      System.out.println("assembler");
////	      System.out.println(soup);
////			org.junit.Assert.assertEquals(assembler.assemble(soup), soupDTO);
////			org.junit.Assert.assertTrue(letterSoupManager.login(user.getUser()));
////			org.junit.Assert.assertTrue(letterSoupManager.register("a2#a2#S#a2@gmail.com"));
////			
////			letterSoupServer = new LetterSoupServer();
////			letterSoupServer.main(args);
////
////		
////	}
//	
//	
//	public static junit.framework.Test suite() {
//		return new JUnit4TestAdapter(AppTest.class);
//		}
//	
//	
//	
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
//	@Test public void testApp() throws RemoteException
//   {
//		List<Word> words=new ArrayList<>();
//		word=new Word(1, 'H', "Ny", 1, 1, soup);
//		words.add(word);
//		user=new User("a1","abc", 'S', "a1@gmail.com");
//		record= new Record(1, new Date(), 1, user);
//		soup=new Soup(1,"Ny","NYNY",2,words);
//		dao=new ManagerDAO();
//		assembler= new Assembler();
//		 ArrayList<String> arraywords=new ArrayList<String>();
//		 
//		 ArrayList<Integer> arrayposx=new ArrayList<Integer>();
//		 ArrayList<Integer> arrayposy=new ArrayList<Integer>();
//		 ArrayList<Character> arrayorientation=new ArrayList<Character>();
//		 
//		 arraywords.add(soup.getWords().get(0).getWord());
//		 arrayposx.add(soup.getWords().get(0).getX());
//		 arrayposy.add(soup.getWords().get(0).getY());
//		 arrayorientation.add(soup.getWords().get(0).getPosition());
//		
//		soupDTO = new SoupDTO(arraywords,arrayposx,arrayposy,arrayorientation,2,"Ny");
//		
//		try {
//			LetterSoupServer lss = new LetterSoupServer();
//			letterSoupManager=new LetterSoupManager(args);
//			lss.main(args);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//		
//		
//		
//		
//		System.out.println("ha entrado aqui");
//			org.junit.Assert.assertEquals(assembler.assemble(soup).getNombre(), soupDTO.getNombre());
//		System.out.println("ha entrado aqui 2");
//		System.out.println(letterSoupManager.toString());
//			org.junit.Assert.assertTrue(letterSoupManager.login(user.getUser()+"#"+user.getPassword()));
//		System.out.println("ha entrado aqui 3");
//			org.junit.Assert.assertTrue(letterSoupManager.register("a2#a2#S#a2@gmail.com"));
//			
//			letterSoupServer = new LetterSoupServer();
//			letterSoupServer.main(args);
//
//		
//	
//   }
//	
//}
