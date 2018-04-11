package es.deusto.spq.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(detachable = "true")
public class Soup {
	@PrimaryKey
	private int soup_id;	
	
	private char[][] content;
	
	private int size;
	
	@Persistent(defaultFetchGroup="true", mappedBy="soup", dependentElement = "true")
	@Join
	private List<Word> words = new ArrayList<Word>();
	

	public Soup(int soup_id, char[][] content, int size) {
		
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
	public void initialize() {
		//Word(int word_id, char position, String word, int x, int y, Soup soup)
		this.content=new char[this.size][this.size];
		System.out.println(content[i][j]);
		
		System.out.println(word1.getWord());
		
		insertWords();
		this.content.toString();
		fulfill();
		this.content.toString();
		
		
	}
	public char generateValue() {
		int num1 = 97;
		int num2 = 122;
		char letra = 0;
		int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
		letra=(char)numAleatorio;
		System.out.println(letra);
		return letra;
				
	}
	public void insertWords() {
		String a ="hola";
		a.length();
		List<> b=new ArrayList<>();
		b.size();
		b.get(index);
		a.charAt(index);
		int x=0;
		int y=0;
		for(int i=0;i<this.words.size();i++) {
			Word word=this.words.get(i);
			x=word.getX();
			y=word.getY();
			for(int j=0;j<word.getWord().length();j++) {
				if(word.position.equals("F") || word.position.equals("f")) {
					this.content[x][y]=word.charAt(j);
					y++;
				}else {
					this.content[x][y]=word.charAt(j);
					x++;
				}
			}
			
		}
	}
	public void fulfill() {
		for(int i=0;i<this.size) {
			for(int j=0; j<this.size) {
				if(content[i][j]!=null)content[i][j]=generateValue();		
			}
		}
	}
	
	
}
