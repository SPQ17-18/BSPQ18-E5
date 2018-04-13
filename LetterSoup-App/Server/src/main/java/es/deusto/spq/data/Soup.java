package es.deusto.spq.data;
import java.util.ArrayList;
import java.util.Arrays;
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
	

	public Soup(int soup_id, int size) {
		
		this.soup_id = soup_id;
		this.size = size;
		this.words = new ArrayList<Word>();
		this.content=new char[this.size][this.size];
	}

	public int getSoup_id() {
		return soup_id;
	}

	public void setSoup_id(int soup_id) {
		this.soup_id = soup_id;
	}

	public char[][] getContent() {
		return content;
	}

	public void setContent(char[][] content) {
		this.content = content;
	}

	@Override
	public String toString() {
		String s="";
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				s=s+this.content[i][j]+" ";
			}
			s=s+'\n';
		}
		
		
		return s;
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

		for(int i=0;i<size;i++) {
			for(int j=0; j<size;j++) {
				this.content[i][j]='\'';
			}
		}
		
		
		insertWords();
		fulfill();

		
		
	}
	public char generateValue() {
		int num1 = 97;
		int num2 = 122;
		char letra = 0;
		int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
		letra=(char)numAleatorio;
		return letra;
				
	}
	public void insertWords() {
		int x=0;
		int y=0;
		for(int i=0;i<this.words.size();i++) {
			Word word=this.words.get(i);
			x=word.getX();
			y=word.getY();
			for(int j=0;j<word.getWord().length();j++) {
				if(word.getPosition()=='V' || word.getPosition()=='v') {
					this.content[y][x]=(word.getWord()).charAt(j);
					y++;
				}else {
					this.content[y][x]=(word.getWord()).charAt(j);
					x++;
				}
			}
			
		}
		
	}

	public void fulfill() {
		char a = '\'';
		for(int i=0;i<this.size;i++) {
			for(int j=0; j<this.size;j++) {
				if(this.content[i][j]==a) {
					this.content[i][j]=generateValue();		
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Soup s = new Soup(1, 13);
		Word a = new Word(1,'V',"ala",1,2,s);
		Word b = new Word(1,'H',"beta",2,2,s);
		ArrayList<Word> w = new ArrayList<>();
		s.setAword(a);
		s.setAword(b);

		
		s.initialize();
		System.out.println(s);
	}
	
	
}
