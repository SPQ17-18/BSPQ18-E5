package es.deusto.spq.data;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class User {
	@PrimaryKey
	private String User;	
	private String Password;	
	private char rol;
	

	@Persistent(defaultFetchGroup="true", mappedBy="user", dependentElement = "true")
	@Join
	private List<Record> records = new ArrayList<Record>();
	
	
	
	public User(String user, String password, int score, char rol) {
	
		User = user;
		Password = password;
		this.rol = rol;
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

	

}
