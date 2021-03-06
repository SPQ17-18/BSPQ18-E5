package es.deusto.spqServer.dao;

import java.util.ArrayList;
import java.util.List;

import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.Word;


/**
 * 
 * Data access object interface 
 * @autor SPQ-E5
 */
public interface IManagerDAO {
	public void storeSoup(Soup soup);
	public ArrayList<Record> getRecords(String user);
	public boolean isCorrect(String UsuarioContrasena);
	public ArrayList<Integer> getNumSoup();
	public String getSoup(int Soupid);
	public void storeWord(Word word);
	public void deleteSoup(int soupid);
	public void storeUser(User user);
	public int getLastSoupId();
	public int getLastWordId();
	
	public String [] getSoups();
	
	public Soup getSoup(String Soupname);
	public int getLastRecordId();
	public void storeScore(Record record);
	public User getUser(String User);
	public void deleteUser(String user);
	public List <User> getAllUser();
	

}
