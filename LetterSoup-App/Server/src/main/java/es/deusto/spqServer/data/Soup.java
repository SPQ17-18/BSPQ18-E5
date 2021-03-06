 package es.deusto.spqServer.data;
import java.util.ArrayList;

import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.dto.SoupDTO;


@PersistenceCapable(detachable = "true")
/**
 * 
 * Soup class with his attributes, constructors, getters and setters
 * @autor SPQ-E5
 */
public class Soup {
	private final static Logger logger = Logger.getLogger(Soup.class.getName());

	@PrimaryKey
	private int soup_id;
	
	private String nombre;
	
	private String content;
	
	private int size;
	
	
	@Persistent(defaultFetchGroup="true", mappedBy="soup", dependentElement = "true")
	@Join
	private List<Word> words = new ArrayList<Word>();
	

	public Soup(int soup_id, int size,String nombre) {
		this.nombre=nombre;
		this.soup_id = soup_id;
		this.size = size;
		this.words = new ArrayList<Word>();
		this.content=null;
	}
	
	
	public Soup(int soup_id, String nombre, String content, int size, List<Word> words) {
		super();
		this.soup_id = soup_id;
		this.nombre = nombre;
		this.content = content;
		this.size = size;
		this.words = words;
	}




	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public char [][] getArrayContent(){
		char [][] arraycontent=new char[size][size];
		for(int i=0;i<this.content.length();i++) {
			int x=i/this.size;
			int y=i%this.size;
			arraycontent[y][x]=this.content.charAt(i);
		}
		return arraycontent;
	}

	public String toStringArrayContent(char [][] array) {
		String s="";
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				s=s+array[i][j];
			}
			
		}
		return s;	
		
		
	}
	@Override
	public String toString() {
		String s="";
		for(int i=0;i<this.content.length();i++) {
			if(i%this.size==0) {
				s=s+'\n'+this.content.charAt(i);
			}else {
				s=s+" "+this.content.charAt(i);
			}
			
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
		logger.addAppender(new ConsoleAppender(new PatternLayout(),"Initialize"));
    	
		//Word(int word_id, char position, String word, int x, int y, Soup soup)
		char [][] arrayContent=new char[this.size][this.size];
		for(int i=0;i<size;i++) {
			for(int j=0; j<size;j++) {
				arrayContent[i][j]='\'';
			}
		}
		
		
		insertWords(arrayContent);
		fulfill(arrayContent);
		this.content=toStringArrayContent(arrayContent);

		
		
	}
	public char generateValue() {
		int num1 = 97;
		int num2 = 122;
		char letra = 0;
		int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
		letra=(char)numAleatorio;
		return letra;
				
	}
	public void insertWords(char [][] arrayContent) {
		int x=0;
		int y=0;
		for(int i=0;i<this.words.size();i++) {
			Word word=this.words.get(i);
			x=word.getX();
			y=word.getY();
			for(int j=0;j<word.getWord().length();j++) {
				if(word.getPosition()=='V' || word.getPosition()=='v') {
					
					arrayContent[y][x]=(word.getWord()).charAt(j);
					y++;
				}else {
					arrayContent[y][x]=(word.getWord()).charAt(j);
					x++;
				}
			}
			
		}
		
	}

	public void fulfill(char [][] arrayContent) {
		char a = '\'';
		for(int i=0;i<this.size;i++) {
			for(int j=0; j<this.size;j++) {
				if(arrayContent[i][j]==a) {
					arrayContent[i][j]=generateValue();		
				}
			}
		}
		
		
	}
	
	public int calculateScore(String answer) {
		int score=0;
		Word words1;
		boolean match=false;
			for(int j=0;j<this.words.size();j++) {
				words1=this.words.get(j);
			if(answer.equals(words1.getWord()) ) {//if the answer given is correct
				score+=5;
				match=true;
				}
			}
			if(match==false) {
				score-=2;//if one of the answers given does not appear in the soups real answer
			}
			match=false;
		
		return score;
	}

	
	
	public int calculatePuntuation(ArrayList<String> arrWord) {
		int score=0;
		for(int i=0;i<arrWord.size();i++) {
			score=score+calculateScore(arrWord.get(i));
			
		}
		return score;
	}
	
	public int ScoreDTO(SoupDTO dto) {
		return calculatePuntuation(dto.getArraywords());
	}
	
	public String getLevel() {
		
		if(this.size<=6)return "Easy";
		if(this.size>6 && this.size<=9 ) return "Medium";
		if(this.size>10)return "Complex";
				return null;

	}
	//public static void main(String[] args) {
		
		//Soup s = new Soup(1, 13);
		//Word a = new Word(1,'V',"ala",1,2,s);
		//Word b = new Word(1,'H',"beta",2,2,s);
		//ArrayList<Word> w = new ArrayList<>();
		//s.setAword(a);
		//s.setAword(b);

		
		//s.initialize();
		//System.out.println(s.toStringArrayContent(s.getArrayContent()));
		//System.out.println(s);
	//}
	
	
	
}

