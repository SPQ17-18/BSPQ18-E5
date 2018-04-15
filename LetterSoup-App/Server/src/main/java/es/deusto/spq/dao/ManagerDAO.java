package es.deusto.spq.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.data.Record;
import es.deusto.spq.data.Soup;
import es.deusto.spq.data.User;
import es.deusto.spq.data.Word;


//DAO Class for transfering objects from the application to the DB
public class ManagerDAO implements IManagerDAO {

private PersistenceManagerFactory pmf;
	
	public ManagerDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	//Storing objects on DB
	private void storeObject(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    	System.out.println(ex.getStackTrace());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close();
	    }
	}
	//Storing "Soup" Objects
	public void storeSoup(Soup soup) {
		System.out.println("   * Storing an object: " + soup.getSoup_id());
		 this.storeObject(soup);
	}
	//Storing users
	public void storeUser(User user) {
		 this.storeObject(user);
	}
	//Storing words for letter soups
	public void storeWord(Word word) {
		 this.storeObject(word);
	}
	
	
	@SuppressWarnings("unchecked")
	
	//Method that returns all the scores and records of one user
	public ArrayList<Record> getRecords(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		ArrayList <Record> records = new ArrayList<Record>();
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName()+ " WHERE User=='"+user.getUser()+"'");
			List <User> result = (List<User>) q.execute();
			User us=result.get(0);
			for(int i=0;i<us.getScore().size();i++) {
				records.add(new Record(us.getScore().get(i).getRecord_id(),us.getScore().get(i).getDate(), us.getScore().get(i).getRecord(), us.getScore().get(i).getUser()));
				System.out.println(us.getScore().get(i).getRecord_id());
				System.out.println(us.getScore().get(i).getDate());
				System.out.println(us.getScore().get(i).getRecord());
				System.out.println(us.getScore().get(i).getUser().getUser());
			}
			
						
			System.out.println("All  retrieved.");
			
			
			
			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving all users: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return records;
	}
	
	

	@SuppressWarnings("unchecked")
	//Method that returns if user and password are correct or not
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
			
						
			System.out.println("All  retrieved.");
			
			
			
			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving all Users: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    
		System.out.println(us.getPassword());
		return us.getPassword().equals(data[1]);
		
	}
	//Method that retrieves all Soups 
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
	    	System.out.println("   $ Error retrieving some Soups: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return arrid;

		
	}
	//This method gets a soup from DB by its id
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
	    	System.out.println("   $ Error retrieving some soups: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return resultSouup;

		
	}
	//This method deletes a soup from DB by its id
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
			System.out.println("   $ Error cleaning the soup: " + ex.getMessage());
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


		
			
	
	
	
	public static void main(String[] args) {
		//Creating DAO
		IManagerDAO dao= new ManagerDAO();
				
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		Soup s=new Soup(1, 13);//Creating Soup
		Soup s1=new Soup(2, 13);
		Word a= new Word(1, 'V', "YES", 1, 3, s);//Creating words for soup
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
		System.out.println("The number of letter soups is:\n");
		System.out.println(dao.getNumSoup().size());
		System.out.println("The content of the letter soup s is:\n");
		System.out.println(dao.getSoup(s.getSoup_id()));
		User u=new User("a1", "abc", 'S',"a1@gmail.com");
		Date date=new Date();
		Record r1=new Record(1,date, 5,u);
		u.addRecord(r1);
		System.out.println("Store user");
		dao.storeUser(u);
		System.out.println("Get records");
		dao.getRecords(u);
		System.out.println("Is correct");
		System.out.println(dao.isCorrect("a1#abc"));
		System.out.println("Is correct");
		System.out.println(dao.isCorrect("a1#aebc"));
		
		
	}


	}
