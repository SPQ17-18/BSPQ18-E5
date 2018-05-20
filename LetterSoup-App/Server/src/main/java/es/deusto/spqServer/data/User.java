package es.deusto.spqServer.data;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
/**
 * 
 * User class with his attributes, constructors, getters and setters
 * @autor SPQ-E5
 */
public class User {
	@PrimaryKey
	private String User;	
	private String Password;	
	private char rol;
	private String email;
	

	@Persistent(defaultFetchGroup="true", mappedBy="user", dependentElement = "true")
	@Join
	private List<Record> records;
	
	
	
	public User(String user, String password, char rol, String email) {
		User = user;
		Password = password;
		this.rol = rol;
		this.email = email;
		this.records = new ArrayList<Record>();
	}
	
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public ArrayList<Record> getScore() {
		return (ArrayList<Record>) records;
	}
	public char getRol() {
		return rol;
	}
	public void setRol(char rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//Method for adding a record to an specific user
	public void addRecord(Record record) {
		this.records.add(record);
	}
	
	

}
