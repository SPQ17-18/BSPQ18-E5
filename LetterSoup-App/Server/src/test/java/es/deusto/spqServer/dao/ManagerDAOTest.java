package es.deusto.spqServer.dao;

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


import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.Word;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * 
 * Class for managing all DAO actions
 *
 */
public class ManagerDAOTest{

	
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
		a= new Word(6, 'V', "YES", 1, 3, s1);
		b= new Word(7, 'H', "NO", 2, 1, s1);
		Date date=new Date();
		Record r1=new Record(3,date, 5,u4);
		Record r2=new Record(4,date, 5,u3);
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
		assertTrue(dao.isCorrect("a1#abc"));
		assertFalse(dao.isCorrect("a1#ab"));
				
	}
	
	@Test public void testgetUser() {
		User u=dao.getUser("a1");
		assertEquals(u.getUser(),"a1");
		assertEquals(u.getEmail(),"a1@gmail.com");
		assertEquals(u.getRol(),'S');
		assertEquals(u.getPassword(),"abc");
		
	}
	
	@Test public void testgetAllUser() {
		assertEquals(dao.getAllUser().size(),3);
	}
	
	
	
	@Test public void getNumSoup() {
		ArrayList<Integer> ar=dao.getNumSoup();
		assertEquals(ar.size(),3);
		
				
	}
	//Database query that selects soups by their ID
	@Test public void testgetSoup() {
		
		assertEquals(dao.getSoup(22).length(),169);
			}

	
	@Test public void getSoup() {
		assertEquals(dao.getSoup("s1").getSoup_id(),1);
		assertEquals(dao.getSoup("s1").getSize(),13);
		
			}

	
	
	@Test public void getSoups() {
		assertEquals(dao.getSoups().length,3);
		
			}
	

	//Database query that deletes soup selecting it by its ID

	public void deleteSoup(int soupid) {		
			}

	
	public void deleteUser(String user) {		
				
	}
	

	
	//Database query that selects the last soup's ID

	@Test public void getLastSoupId() {
		assertEquals(dao.getLastSoupId(),23);
		}
	
	@Test public void getLastRecordId() {
		assertEquals(dao.getLastRecordId(),5);
		
		}
	
	@Test public void getLastWordId() {
		assertEquals(dao.getLastWordId(),8);
		
		}


		
	}
