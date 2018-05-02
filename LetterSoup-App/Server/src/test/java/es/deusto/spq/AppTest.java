package es.deusto.spq;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spqServer.dao.IManagerDAO;
import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.Word;
import es.deusto.spqServer.dto.Assembler;
import es.deusto.spqServer.dto.SoupDTO;
import es.deusto.spqServer.remote.IFacade;
import es.deusto.spqServer.remote.LetterSoupManager;
import es.deusto.spqServer.server.LetterSoupServer;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	private LetterSoupManager lsm;
	private Record record;
	private Soup soup;
	private User user;
	private Word word;
	private Assembler assembler;
	private SoupDTO soupDTO;
	private IManagerDAO dao;
	private IFacade letterSoupManager;
	private LetterSoupServer letterSoupServer;
	private String[] args= {"127.0.0.1","1099","LetterSoupServer"};;
	@Before public void setup() {
		
		user=new User("a1","abc", 'S', "a1@gmail.com");
		record= new Record(1, new Date(), 1, user);
		soup=new Soup(1,2,"Nya");
		word=new Word(1, 'v', "Nya", 1, 1, soup);
		dao=new ManagerDAO();
		
		 ArrayList<String> arraywords=new ArrayList<String>();
		 
		 ArrayList<Integer> arrayposx=new ArrayList<Integer>();
		 ArrayList<Integer> arrayposy=new ArrayList<Integer>();
		 ArrayList<Character> arrayorientation=new ArrayList<Character>();
		 
		 arraywords.add(soup.getWords().get(0).getWord());
		 arrayposx.add(soup.getWords().get(0).getX());
		 arrayposy.add(soup.getWords().get(0).getY());
		 arrayorientation.add(soup.getWords().get(0).getPosition());
		
		soupDTO = new SoupDTO(arraywords,arrayposx,arrayposy,arrayorientation,2,"Nya");
		
		try {
			lsm=new LetterSoupManager(args);
			letterSoupManager=new LetterSoupManager(args);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(AppTest.class);
		}
	
	
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
    /**
     * @return the suite of tests being tested
     */
	
   // public static Test suite()
    //{
       // return new TestSuite( AppTest.class );
    //}

    /**
     * Rigourous Test :-)
     * @throws RemoteException 
     */
	@Test public void testApp() throws RemoteException
    {
      
		assertEquals(assembler.assemble(soup), soupDTO);
		assertTrue(letterSoupManager.login(user.getUser()));
		assertTrue(letterSoupManager.register("a2#a2#S#a2@gmail.com"));
		
		letterSoupServer = new LetterSoupServer();
		letterSoupServer.main(args);
    }
	
}
