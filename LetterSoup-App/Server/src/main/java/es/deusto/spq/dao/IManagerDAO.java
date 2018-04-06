package es.deusto.spq.dao;

import java.util.ArrayList;

import es.deusto.spq.data.Record;
import es.deusto.spq.data.Soup;
import es.deusto.spq.data.User;
import es.deusto.spq.data.Word;

public interface IManagerDAO {
	public void storeSoup(Soup soup);
	public ArrayList<Record> getRecords(User user);
	public boolean isCorrect(String UsuarioContrasena);
	public ArrayList<Integer> getNumSoup();
	public String getSoup(int Soupid);
	public void storeWord(Word word);
	public void deleteSoup(int soupid);
	public void storeUser(User user);

}
