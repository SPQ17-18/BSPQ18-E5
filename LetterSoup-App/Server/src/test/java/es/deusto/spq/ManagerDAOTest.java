package es.deusto.spq;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spqServer.dao.IManagerDAO;
import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.Word;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;



/**
 * 
 * Class for managing all DAO actions
 *
 */
@PerfTest(invocations=5)
@Required(max=1200,average=250)

public class ManagerDAOTest{
	@Rule
	public ContiPerfRule i=new ContiPerfRule();
	
	
	private static Soup s1;
	private static User u4;
	private static User u3;
	private static Word a;
	private static Word b;
	
	private static IManagerDAO dao;		
		
		
	
	@BeforeClass public static void setUp(){
		dao= new ManagerDAO();		
		s1=new Soup(22, 13,"s21");
		s1.initialize();
		u3=new User("a11", "abc", 'S',"a1@gmail.com");
		u4=new User("a21", "abc", 'S',"a2@gmail.com");
		a= new Word(22, 'V', "YES", 1, 3, s1);
		b= new Word(32, 'H', "NO", 2, 1, s1);
		Date date=new Date();
		Record r1=new Record(23,date, 5,u4);
		Record r2=new Record(24,date, 5,u3);
		u3.addRecord(r2);
		u4.addRecord(r1);
		dao.storeUser(u3);
		s1.setAword(a);
		s1.setAword(b);		
		dao.storeSoup(s1);		
		
		
		
	
		
	}
	
	
		
	@Test public void testgetRecords() {
		ArrayList<Record> records=dao.getRecords("a11");
		assertEquals(records.size(),1);
		
		}
	
	

	@Test public void TestisCorrect() {
		assertTrue(dao.isCorrect("a11#abc"));
		assertFalse(dao.isCorrect("a11#ab"));
				
	}
	
	@Test public void testgetUser() {
		User u=dao.getUser("a11");
		assertEquals(u.getUser(),"a11");
		assertEquals(u.getEmail(),"a1@gmail.com");
		assertEquals(u.getRol(),'S');
		assertEquals(u.getPassword(),"abc");
		
	}
	
	@Test public void testgetAllUser() {
		assertTrue(dao.getAllUser().size()>1);
	}
	
	
	
	@Test public void getNumSoup() {
		ArrayList<Integer> ar=dao.getNumSoup();
		assertTrue(ar.size()>1);
		
				
	}
	//Database query that selects soups by their ID
	@Test public void testgetSoup() {
		
		assertEquals(dao.getSoup(22).length(),169);
			}

	
	@Test public void getSoup() {
		assertEquals(dao.getSoup("s21").getSoup_id(),22);
		assertEquals(dao.getSoup("s21").getSize(),13);
		
			}

	
	
	@Test public void getSoups() {
		assertTrue(dao.getSoups().length>1);
		
			}
	

	//Database query that deletes soup selecting it by its ID

		

	
	//Database query that selects the last soup's ID

	@Test public void getLastSoupId() {
		assertEquals(dao.getLastSoupId(),23);
		}
	
	@Test public void getLastRecordId() {
		assertEquals(dao.getLastRecordId(),25);
		
		}
	
	@Test public void getLastWordId() {
		assertEquals(dao.getLastWordId(),33);
		
		}
	
	@AfterClass
	 public static void tearDownClass() throws Exception {
		dao.deleteUser("a11");
		dao.deleteSoup(22);
	 }



		
	}