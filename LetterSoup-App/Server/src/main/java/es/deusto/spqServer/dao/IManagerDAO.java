package es.deusto.spqServer.dao;

import java.util.ArrayList;
import java.util.List;

import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.data.Word;



public interface IManagerDAO {
	public void storeSoup(Soup soup);
	public ArrayList<Record> getRecords(User user);
	public boolean isCorrect(String UsuarioContrasena);
	public ArrayList<Integer> getNumSoup();
	public String getSoup(int Soupid);
	public Soup getSoup(String Soupid);
	public void storeWord(Word word);
	public void deleteSoup(int soupid);
	public void storeUser(User user);
	public int getLastSoupId();
	public int getLastWordId();
	public List<String> soupList();

}
