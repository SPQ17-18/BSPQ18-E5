package es.deusto.spqServer.dto;

import java.util.ArrayList;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

import es.deusto.spqServer.data.Record;
import es.deusto.spqServer.data.Soup;
import es.deusto.spqServer.data.Word;



public class Assembler {
	
	
	public Assembler() {
	
	
		
	}

	public SoupDTO assemble(Soup s) {
		ArrayList<String> words=new ArrayList<String>();
		ArrayList<Integer> posx=new ArrayList<Integer>();
		ArrayList<Integer> posy=new ArrayList<Integer>();
		ArrayList<Character> orientation=new ArrayList<Character>();
		for(int i=0;i<s.getWords().size();i++) {
			words.add(s.getWords().get(i).getWord());
			posx.add(s.getWords().get(i).getX());
			posy.add(s.getWords().get(i).getY());
			orientation.add(s.getWords().get(i).getPosition());
		}
		SoupDTO dto=new SoupDTO(words,posx,posy,orientation, s.getSize(),s.getNombre());
		dto.setContent(s.getContent());
		return dto;
		
	}
	
	public Soup disassemble(SoupDTO s,int lastsoupid,int lastwordid) {
		ArrayList<String> words=new ArrayList<String>();
		ArrayList<Integer> posx=new ArrayList<Integer>();
		ArrayList<Integer> posy=new ArrayList<Integer>();
		Soup soup=new Soup(lastsoupid, s.getSize(), s.getNombre());
		for(int i=0;i<s.getArraywords().size();i++) {
			Word w=new Word(lastwordid+i, s.getArrayorientation().get(i), s.getArraywords().get(i), s.getArrayposx().get(i), s.getArrayposy().get(i), soup);
			soup.setAword(w);
		}
		
		return soup;
		
	}
	
	public ScoreDTO assemble(ArrayList<Record> arrrecord) {
		ArrayList<Date> arrDate=new ArrayList<Date>();
		ArrayList<Integer> arrRecord=new ArrayList<Integer>();
		
		for(int i=0;i<arrrecord.size();i++) {
			arrDate.add(arrrecord.get(i).getDate());
			arrRecord.add(arrrecord.get(i).getRecord());
		}
		ScoreDTO score=new ScoreDTO(arrDate,arrRecord);
		return score;
		
	}
	
	

}
