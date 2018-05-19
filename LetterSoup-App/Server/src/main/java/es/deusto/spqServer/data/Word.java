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
 * Word class with his attributes, constructors, getters and setters
 * @autor SPQ-E5
 */
public class Word {
	@PrimaryKey
	private int word_id;	
	
	private char position;
	
	private String word;
	
	private int x;
	
	private int y;
	
	@Persistent(defaultFetchGroup="true")
	private Soup soup;
	
	

	public Word(int word_id, char position, String word, int x, int y, Soup soup) {
		this.word_id = word_id;
		this.position = position;
		this.word = word;
		this.x = x;
		this.y = y;
		this.soup = soup;
	}

	public int getWord_id() {
		return word_id;
	}

	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}

	public char getPosition() {
		return position;
	}

	public void setPosition(char position) {
		this.position = position;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Soup getSoup() {
		return soup;
	}

	public void setSoup(Soup soup) {
		this.soup = soup;
	}
	
	
	
	
}
