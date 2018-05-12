//package es.deusto.spq;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import es.deusto.spqServer.data.Record;
//import es.deusto.spqServer.data.Soup;
//import es.deusto.spqServer.data.User;
//import es.deusto.spqServer.data.Word;
//import es.deusto.spqServer.dto.Assembler;
//import es.deusto.spqServer.dto.SoupDTO;
//
//public class SoupTest {
//	 Record record;
//	 Soup soup;
//	 User user;
//	 Word word;
//	 Assembler assembler;
//	 SoupDTO soupDTO;
//	 String[] args= {"127.0.0.1","1099","LetterSoupServer"};
//	 List<Word> words;
//	@Before public void setUp() {
//		words=new ArrayList();
//		user=new User("a1","abc", 'S', "a1@gmail.com");
//		record= new Record(1, new Date(), 1, user);
//		soup=new Soup(1,"Ny","NYNY",2,words);
//		word=new Word(1, 'H', "Ny", 0, 0, soup);
//		words.add(word);
//		
//	}
//	
//
//	@Test public void initialize() {
//		char [][] arrayContent=new char[2][2];
//		for(int i=0;i<2;i++) {
//			for(int j=0; j<2;j++) {
//				arrayContent[i][j]='\'';
//			}
//		}
//		arrayContent[0][0]='N';arrayContent[0][1]='Y';
//		soup.initialize();
//		assertTrue(soup.getArrayContent().length==arrayContent.length);
//	}
//	@Test public void generateValue() {
//		char a=soup.generateValue();
//		assertTrue((a>='a' && a<='z')||(a>='A'&&a<='Z'));
//		
//	}
//
//	@Test public void calculateScore() {
//	assertEquals(soup.calculateScore("Ny"),5);
//	
//	}
//	@Test public void calculatePuntuation() {
//		ArrayList<String> arrWord = new ArrayList();;
//		arrWord.add("Ny");
//		assertEquals(soup.calculatePuntuation(arrWord),5);
//	}
//	@Test public void getLevel() {
//		
//		assertEquals(soup.getLevel(),"Easy");
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
