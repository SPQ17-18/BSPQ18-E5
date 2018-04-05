package es.deusto.spq.dao;

import java.util.ArrayList;
import java.util.Collection;
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



public class ManagerDAO implements IManagerDAO {
private PersistenceManagerFactory pmf;
	
	public ManagerDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
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

	public void storeSoup(Soup soup) {
		System.out.println("   * Storing an object: " + soup.getSoup_id());
		 this.storeObject(soup);
	}

	public void storeUser(User user) {
		 this.storeObject(user);
	}
	public void storeWord(Word word) {
		 this.storeObject(word);
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Record> getRecords(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		ArrayList <Record> records = new ArrayList<Record>();
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName()+ "WHERE User=='"+user.getUser());
			List <User> result = (List<User>) q.execute();
			User us=result.get(0);
			
						
			System.out.println("All  retrieved.");
			
			
			
			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving all flights: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return user.getScore();
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
			Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName()+ "WHERE User=='"+data[0]);
			List <User> result = (List<User>) q.execute();
			us=result.get(0);
			
						
			System.out.println("All  retrieved.");
			
			
			
			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving all flights: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    
		
		return us.getPassword().equals(data[1]);
		
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
	    	System.out.println("   $ Error retrieving some flights: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return arrid;

		
	}
	
	public String getSoup(int Soupid) {
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		pm.getFetchPlan().setMaxFetchDepth(4);
		
		
		List <Soup> result=null;

		try {
			tx.begin();			
			Query<?> q = pm.newQuery("SELECT FROM " + Soup.class.getName()+"WHERE soup_id=='"+Soupid+"'");
			result = (List<Soup>) q.execute();
			
			
			
			tx.commit();	
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving some flights: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close(); 
	    }
	    				
		return result.get(0).getContent();

		
	}
	
	public void deleteSoup(Soup soup) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
			
		try {		
			tx.begin();

			Query<Soup> query = pm.newQuery(Soup.class, "soup_id =='"+soup.getSoup_id()+"'");

			Collection<?> result = (Collection<?>) query.execute();

			Soup s = (Soup) result.iterator().next();

			query.close(result);

			pm.deletePersistent(s);
			   
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error cleaning a flight: " + ex.getMessage());
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
	
		IManagerDAO dao= new ManagerDAO();
		System.out.println("Entro");
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		Soup s=new Soup(1,"YABECDSNO", 3);
		dao.deleteSoup(s);
		Word a= new Word(1, 'V', "YES", 1, 3, s);
		Word b= new Word(2, 'H', "NO", 2, 1, s);
		dao.storeSoup(s);
		Soup s1=new Soup(2,"ZOPENBAARESTSHWYOTVABDGCF", 5);
		Word c= new Word(1, 'V', "PAST", 3, 5, s1);
		Word d= new Word(2, 'V', "NEW", 5,5, s1);
		Word e=new Word(3,'H',"OPEN",2,5,s1);
		dao.storeSoup(s1);
				
		
		
	}


	}
