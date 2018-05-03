package es.deusto.spqServer.dao;

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



/**
 * 
 * Class for managing all DAO actions
 *
 */
public class ManagerDAO implements IManagerDAO {

private PersistenceManagerFactory pmf;
private final static Logger logger = Logger.getLogger(ManagerDAO.class.getName());


	
	public ManagerDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	//Store object
	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error storing an object: " + ex.getMessage()));
	    	logger.fatal("   $ Error storing an object: ", ex);
	    	
	    	System.out.println(ex.getStackTrace());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close();
	    }
	}
//store soup
	public void storeSoup(Soup soup) {
		logger.addAppender(new ConsoleAppender(new PatternLayout(),"   * Storing an object: " + soup.getSoup_id()));
    	
		 this.storeObject(soup);
	}
//store user
	public void storeUser(User user) {
		 this.storeObject(user);
	}
//Store word for putting it into a letter soup
	public void storeWord(Word word) {
		 this.storeObject(word);
	}
	public void storeScore(Record record) {
		 this.storeObject(record);
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Record> getRecords(String user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		ArrayList <Record> records = new ArrayList<Record>();
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName()+ " WHERE User=='"+user+"'");
			List <User> result = (List<User>) q.execute();
			User us=result.get(0);
			for(int i=0;i<us.getScore().size();i++) {
				records.add(new Record(us.getScore().get(i).getRecord_id(),us.getScore().get(i).getDate(), us.getScore().get(i).getRecord(), us));
				logger.addAppender(new ConsoleAppender(new PatternLayout(),""+us.getScore().get(i).getRecord_id()));
				logger.addAppender(new ConsoleAppender(new PatternLayout(),""+us.getScore().get(i).getDate()));
				logger.addAppender(new ConsoleAppender(new PatternLayout(),""+us.getScore().get(i).getRecord()));
				logger.addAppender(new ConsoleAppender(new PatternLayout(),""+us.getScore().get(i).getUser().getUser()));
		    	
				}
			
						
			System.out.println("All  retrieved.");
			
			
			
			tx.commit();			
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving all users: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving all users: " + ex.getMessage(), ex);
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return records;
	}
	
	

	@SuppressWarnings("unchecked")
	public boolean isCorrect(String UsuarioContrasena) {
		String [] data=UsuarioContrasena.split("#");
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		ArrayList <Record> records = new ArrayList<Record>();
		User us=null;
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName()+ " WHERE User=='"+data[0]+"'");
			List <User> result = (List<User>) q.execute();
			us=new User(result.get(0).getUser(),result.get(0).getPassword(),result.get(0).getRol(),result.get(0).getEmail());
						
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"All  retrieved."));
	    	
			
			tx.commit();			
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving all Users: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving all Users: " + ex.getMessage(), ex);
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
		logger.addAppender(new ConsoleAppender(new PatternLayout(),""+us.getPassword()));
    	
		return us.getPassword().equals(data[1]);
		
	}
	
	public User getUser(String User) {
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		ArrayList <Record> records = new ArrayList<Record>();
		User us=null;
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName()+ " WHERE User=='"+User+"'");
			List <User> result = (List<User>) q.execute();
			us=new User(result.get(0).getUser(),result.get(0).getPassword(),result.get(0).getRol(),result.get(0).getEmail());
			ArrayList<Record> arr=new ArrayList<Record>();
			for(int i=0;i<result.get(0).getScore().size();i++) {
				Record r=new Record(result.get(0).getScore().get(i).getRecord_id(),result.get(0).getScore().get(i).getDate(),result.get(0).getScore().get(i).getRecord(),us);
				us.addRecord(r);
			}
						
			
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"All  retrieved."));
	    	
			
			
			tx.commit();			
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving User: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving User: ", ex);
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    
		logger.addAppender(new ConsoleAppender(new PatternLayout(),us.getPassword()));
    	
		return us;
		
	}
	
	public List <User> getAllUser() {
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		ArrayList <Record> records = new ArrayList<Record>();
		User us=null;
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		List <User> results=new ArrayList<User>();
		List <User> result=null;
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName());
			result = (List<User>) q.execute();
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"All  retrieved."));
			for(int j=0;j<result.size();j++) {
			us=new User(result.get(0).getUser(),result.get(0).getPassword(),result.get(0).getRol(),result.get(0).getEmail());
			ArrayList<Record> arr=new ArrayList<Record>();
			for(int i=0;i<result.get(0).getScore().size();i++) {
				Record r=new Record(result.get(0).getScore().get(i).getRecord_id(),result.get(0).getScore().get(i).getDate(),result.get(0).getScore().get(i).getRecord(),us);
				us.addRecord(r);
			}
			results.add(us);
			}
			
			tx.commit();			
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving User: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving User: " + ex.getMessage(), ex);
	    		    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    
		
		return results;
		
	}
	
	
	
	public ArrayList<Integer> getNumSoup() {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		ArrayList<Integer> arrid=new ArrayList<Integer>();
		pm.getFetchPlan().setMaxFetchDepth(4);

		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName());
			List <Soup> result = (List<Soup>) q.execute();
			
			
			for (int i = 0; i < result.size(); i++) {
				arrid.add(result.get(i).getSoup_id());
				
			}
			
			tx.commit();	
		} catch (Exception ex) {
	    	logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving some Soups: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving some Soups: " + ex.getMessage(), ex);
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return arrid;

		
	}
	//Database query that selects soups by their ID
	public String getSoup(int Soupid) {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		
		String resultSouup=null;

		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName()+" WHERE soup_id== "+Soupid);
			List <Soup> result = ((List<Soup>) q.execute());
			resultSouup=result.get(0).getContent();
			
			
			tx.commit();	
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving some Soups: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving some Soups: " + ex.getMessage(), ex);
	    	
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return resultSouup;

		
	}

	
	public Soup getSoup(String Soupname) {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		
		Soup resultSouup=null;

		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName()+" WHERE nombre=='"+Soupname+"'");
			List <Soup> result = ((List<Soup>) q.execute());
			resultSouup=new Soup(result.get(0).getSoup_id(), result.get(0).getSize(), result.get(0).getNombre());
			resultSouup.setContent(result.get(0).getContent());
			for(int i=0;i<result.get(0).getWords().size();i++) {
				Word w=new Word(result.get(0).getWords().get(i).getWord_id(),result.get(0).getWords().get(i).getPosition(), result.get(0).getWords().get(i).getWord(),result.get(0).getWords().get(i).getX(),result.get(0).getWords().get(i).getY(),resultSouup);
				resultSouup.setAword(w);
			}
			
			
			tx.commit();	
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving some soups: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving some soups: " + ex.getMessage(), ex);
	    	
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return resultSouup;

		
	}

	
	
	public String [] getSoups() {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		
		String [] resultSouup=null;

		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName());
			List <Soup> result = ((List<Soup>) q.execute());
			resultSouup=new String[result.size()];
			for(int i=0;i<result.size();i++) {
				resultSouup[i]=result.get(i).getNombre();
			}
			
			
			tx.commit();	
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving some soups: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving some soups: " + ex.getMessage(), ex);
	    	
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return resultSouup;

	}
	

	//Database query that deletes soup selecting it by its ID

	public void deleteSoup(int soupid) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
			
		try {		
			tx.begin();

			
			
			Query<?> query = pm.newQuery("SELECT FROM "+Soup.class.getName() + " WHERE soup_id =="+soupid);

			Collection<?> result = (Collection<?>) query.execute();

			Soup s = (Soup) result.iterator().next();

			query.close(result);

			pm.deletePersistent(s);
			   
			tx.commit();
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error cleaning the soup: " + ex.getMessage()));
	    	logger.fatal("   $ Error cleaning the soup: ", ex);
	    	
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	
	public void deleteUser(String user) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
			
		try {		
			tx.begin();

			
			
			Query<?> query = pm.newQuery("SELECT FROM "+User.class.getName() + " WHERE User =='"+user+"'");

			Collection<?> result = (Collection<?>) query.execute();

			User s = (User) result.iterator().next();

			query.close(result);

			pm.deletePersistent(s);
			tx.commit();
			
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error cleaning the user: " + ex.getMessage()));
	    	logger.fatal("   $ Error cleaning the user: ", ex);
	    	
			
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
				pm.close();
			
		}
		
	}
	

	
	//Database query that selects the last soup's ID

	public int getLastSoupId() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		int soupid = -1;
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName() + 
                    " ORDER BY soup_id");
			List <Soup> result = (List<Soup>) q.execute();
			soupid = result.get(result.size()-1).getSoup_id()+1;
			tx.commit();					
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error the last soup: " + ex.getMessage()));
	    	logger.fatal("   $ Error the last soup: ", ex);
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    return soupid;
	}
	
	public int getLastRecordId() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		int recordid = -1;
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Record.class.getName() + 
                    " ORDER BY record_id");
			List <Record> result = (List<Record>) q.execute();
			System.out.println(result.size());
			recordid = result.get(result.size()-1).getRecord_id()+1;
			tx.commit();					
		} catch (Exception ex) {
			//logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error the last record: " + ex.getMessage()));
	    	logger.fatal("   $ Error the last record: ", ex);
	    	
			
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    return recordid;
	}
	
	public int getLastWordId() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		int wordid = -1;
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Word.class.getName() + 
                    " ORDER BY word_id");
			List <Word> result = (List<Word>) q.execute();
			wordid = result.get(result.size()-1).getWord_id()+1;
			tx.commit();					
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error the last word: " + ex.getMessage()));
	    	logger.fatal("   $ Error the last word: ", ex);
	    	
			
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
		return wordid;
	}


public List<String> soupList() {
		
		List<String>soupNames = null;
		
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		
		String resultSouup=null;

		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName());
			List <Soup> result = ((List<Soup>) q.execute());
			soupNames=new ArrayList<String>();
			for(int i=0;i<result.size();i++) {
				soupNames.add(result.get(i).getNombre());
			}
			
			
			tx.commit();	
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"   $ Error retrieving some soups: " + ex.getMessage()));
	    	logger.fatal("   $ Error retrieving some soups: ", ex);
	    	
	    	
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return soupNames;

}
	


	
	
	public static void main(String[] args) {
	
		IManagerDAO dao= new ManagerDAO();
				
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		Soup s=new Soup(1, 13,"s1");
		Soup s1=new Soup(2, 13,"s2");
		Word a= new Word(1, 'V', "YES", 1, 3, s);
		Word b= new Word(2, 'H', "NO", 2, 1, s);
		s.setAword(a);
		s.setAword(b);
		s.initialize();
		dao.storeSoup(s);
		Word c= new Word(3, 'V', "PAST", 3, 5, s1);
		Word d= new Word(4, 'V', "NEW", 5,5, s1);
		Word e=new Word(5,'H',"OPEN",2,5,s1);
		s1.setAword(c);
		s1.setAword(d);
		s1.setAword(e);
		s1.initialize();
		dao.storeSoup(s1);		
		//dao.deleteSoup(s1.getSoup_id());		
		//dao.deleteSoup(s.getSoup_id());
		
		System.out.println("La cantidad de sopas de letras es:\n");
		System.out.println(dao.getNumSoup().size());
		System.out.println("El contenido de la sopa s es:\n");
		System.out.println(dao.getSoup(s.getSoup_id()));
		User u=new User("a1", "abc", 'S',"a1@gmail.com");
		User u2=new User("a2", "abc", 'S',"a2@gmail.com");
		
		Date date=new Date();
		Record r1=new Record(1,date, 5,u);
		Record r2=new Record(2,date, 5,u2);
		u2.addRecord(r2);
		u.addRecord(r1);
		System.out.println("Store user");
		dao.storeUser(u);
		dao.storeUser(u2);
		
		System.out.println("Get records");
		//dao.getRecords(u);
		System.out.println("Is correct");
		System.out.println(dao.isCorrect("a1#abc"));
		System.out.println("Is correct");
		System.out.println(dao.isCorrect("a1#aebc"));
		
		
		
	}
		
			
////public Soup getSoup(String Soupid) {
////	PersistenceManager pm = pmf.getPersistenceManager();
////
////	Transaction tx = pm.currentTransaction();
////	
////	pm.getFetchPlan().setMaxFetchDepth(4);
////	
////	Soup result=null;
////
////	try {
////		tx.begin();			
////		Query<?> q = pm.newQuery("SELECT FROM " + Soup.class+" WHERE nombre== "+Soupid);
////		 result = ((Soup) q.execute());
////		
////		
////		
////		tx.commit();	
////	} catch (Exception ex) {
////    	System.out.println("   $ Error retrieving some soups: " + ex.getMessage());
////    } finally {
////    	if (tx != null && tx.isActive()) {
////    		tx.rollback();
////    	}
////		pm.close(); 
////    }
////    				
////	return result;
////
////	
//}
//	

	
//	public static void main(String[] args) {
//	
//		IManagerDAO dao= new ManagerDAO();
//				
//		if (System.getSecurityManager() == null) {
//			System.setSecurityManager(new SecurityManager());
//		}
//		Soup s=new Soup(1, 13,"s1");
//		Soup s1=new Soup(2, 13,"s2");
//		Word a= new Word(1, 'V', "YES", 1, 3, s);
//		Word b= new Word(2, 'H', "NO", 2, 1, s);
//		s.setAword(a);
//		s.setAword(b);
//		s.initialize();
//		dao.storeSoup(s);
//		Word c= new Word(3, 'V', "PAST", 3, 5, s1);
//		Word d= new Word(4, 'V', "NEW", 5,5, s1);
//		Word e=new Word(5,'H',"OPEN",2,5,s1);
//		s1.setAword(c);
//		s1.setAword(d);
//		s1.setAword(e);
//		s1.initialize();
//		dao.storeSoup(s1);		
//		//dao.deleteSoup(s1.getSoup_id());		
//		//dao.deleteSoup(s.getSoup_id());
//		System.out.println("La cantidad de sopas de letras es:\n");
//		System.out.println(dao.getNumSoup().size());
//		System.out.println("El contenido de la sopa s es:\n");
//		System.out.println(dao.getSoup(s.getSoup_id()));
//		User u=new User("a1", "abc", 'S',"a1@gmail.com");
//		Date date=new Date();
//		Record r1=new Record(1,date, 5,u);
//		u.addRecord(r1);
//		System.out.println("Store user");
//		dao.storeUser(u);
//		System.out.println("Get records");
//		dao.getRecords(u);
//		System.out.println("Is correct");
//		System.out.println(dao.isCorrect("a1#abc"));
//		System.out.println("Is correct");
//		System.out.println(dao.isCorrect("a1#aebc"));
//		
//		
//		
//	}

	
	}
