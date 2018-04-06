package es.deusto.spq.data;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(detachable = "true")
public class Soup {
	@PrimaryKey
	private int soup_id;	
	
	private String content;
	
	private int size;
	
	@Persistent(defaultFetchGroup="true", mappedBy="soup", dependentElement = "true")
	@Join
	private List<Word> words = new ArrayList<Word>();
	

	public Soup(int soup_id, String content, int size) {
		
		this.soup_id = soup_id;
		this.content = content;
		this.size = size;
		this.words = new ArrayList<Word>();
	}

	public int getSoup_id() {
		return soup_id;
	}

	public void setSoup_id(int soup_id) {
		this.soup_id = soup_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}
	public void setAword(Word word) {
		this.words.add(word);
	}
	
}
