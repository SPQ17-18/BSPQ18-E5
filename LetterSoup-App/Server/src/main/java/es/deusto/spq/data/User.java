package es.deusto.spq.data;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

//Method for creating user objects with their attributes
@PersistenceCapable(detachable = "true")
public class User {
	@PrimaryKey
	private String User;	
	private String Password;	
	private char rol;
	private String email;
	

	@Persistent(defaultFetchGroup="true", mappedBy="user", dependentElement = "true")
	@Join
	private List<Record> records;
	
	
	//Constructor
	public User(String user, String password, char rol, String email) {
		User = user;
		Password = password;
		this.rol = rol;
		this.email = email;
		this.records = new ArrayList<Record>();
	}
	//Getters and setters
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
	
	public void addRecord(Record record) {
		this.records.add(record);
	}
	
	

}
