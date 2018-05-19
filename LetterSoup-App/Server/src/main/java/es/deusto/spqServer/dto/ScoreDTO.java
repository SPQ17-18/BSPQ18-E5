package es.deusto.spqServer.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * class for creating Score DTO, with attributes, constructor, getters and setters
 * @autor SPQ-E5
 */
public class ScoreDTO implements Serializable{
	private ArrayList<Date> arrayDate=new ArrayList<Date>();
	
	private ArrayList<Integer> arrayrecord=new ArrayList<Integer>();
	
	public ScoreDTO(ArrayList<Date> arrayDate, ArrayList<Integer> arrayrecord) {
		this.arrayDate = arrayDate;
		this.arrayrecord = arrayrecord;
	}
	
	public ArrayList<Date> getArrayDate() {
		return arrayDate;
	}
	
	public void setArrayDate(ArrayList<Date> arrayDate) {
		this.arrayDate = arrayDate;
	}
	
	public ArrayList<Integer> getArrayrecord() {
		return arrayrecord;
	}
	
	public void setArrayrecord(ArrayList<Integer> arrayrecord) {
		this.arrayrecord = arrayrecord;
	}
	
	
}
