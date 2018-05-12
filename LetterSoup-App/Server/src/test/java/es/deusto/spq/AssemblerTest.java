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
//import es.deusto.spqServer.dto.ScoreDTO;
//import es.deusto.spqServer.dto.SoupDTO;
//
//public class AssemblerTest {
//	 Record record;
//	 Soup soup;
//	 User user;
//	 Word word;
//	 Assembler assembler;
//	 SoupDTO soupDTO;
//	 String[] args= {"127.0.0.1","1099","LetterSoupServer"};
//	 List<Word> words;
//	 
//	@Before public void setUp() {
//		words=new ArrayList();
//		user=new User("a1","abc", 'S', "a1@gmail.com");
//		record= new Record(1, new Date(), 1, user);
//		soup=new Soup(1,"s12","NYNY",2,words);
//		word=new Word(1, 'H', "Ny", 0, 0, soup);
//		words.add(word);
//		assembler= new Assembler();
//		
//		
//		ArrayList<String> arraywords=new ArrayList<String>();
//		 
//		 ArrayList<Integer> arrayposx=new ArrayList<Integer>();
//		 ArrayList<Integer> arrayposy=new ArrayList<Integer>();
//		 ArrayList<Character> arrayorientation=new ArrayList<Character>();
//		 
//		 arraywords.add(soup.getWords().get(0).getWord());
//		 arrayposx.add(soup.getWords().get(0).getX());
//		 arrayposy.add(soup.getWords().get(0).getY());
//		 arrayorientation.add(soup.getWords().get(0).getPosition());
//		
//		soupDTO = new SoupDTO(arraywords,arrayposx,arrayposy,arrayorientation,2,"s12");
//	}
//
//	@Test public void assembleSoup() {
//	
//		assertEquals(assembler.assemble(soup).getArrayorientation().size(),soupDTO.getArrayorientation().size());
//		assertEquals(assembler.assemble(soup).getNombre(), soupDTO.getNombre());
//	
//	}
//
//	@Test public void disassemble() {
//	
//		assertEquals(assembler.disassemble(soupDTO, 1, 1).getNombre(), soup.getNombre());
//		assertEquals(assembler.disassemble(soupDTO, 1, 1).getWords().size(),soup.getWords().size());
//	}
//
//	@Test public void assembleScore() {
//	
//		ArrayList<Date> arrDate=new ArrayList<Date>();
//		arrDate.add(new Date());
//		ArrayList<Integer> arrRecord=new ArrayList<Integer>();
//		arrRecord.add(-2);
//		
//		Record s=new Record(0, new Date(),-2, user);
//		ArrayList<Record> arrrecord= new ArrayList(); 
//		arrrecord.add(s);
//		
//		ScoreDTO sdto= new ScoreDTO(arrDate,arrRecord);
//		
//			assertEquals(assembler.assemble(arrrecord).getArrayDate().get(0),sdto.getArrayDate().get(0));
//			assertEquals(assembler.assemble(arrrecord).getArrayrecord().get(0),sdto.getArrayrecord().get(0));
//	}
//
//}
