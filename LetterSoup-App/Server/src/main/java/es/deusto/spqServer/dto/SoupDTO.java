package es.deusto.spqServer.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class SoupDTO implements Serializable {
	/**
	 * class for creating Soup DTO with attributes, constructor, getters and setters
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> arraywords=new ArrayList<String>();
	private ArrayList<Integer> arrayposx=new ArrayList<Integer>();
	private ArrayList<Integer> arrayposy=new ArrayList<Integer>();
	private ArrayList<Character> arrayorientation=new ArrayList<Character>();
	private int size;
	private String nombre;
	private String content;
	
	
	public SoupDTO(ArrayList<String> arraywords, ArrayList<Integer> arrayposx, ArrayList<Integer> arrayposy,
			ArrayList<Character> arrayorientation, int size, String nombre) {
		this.arraywords = arraywords;
		this.arrayposx = arrayposx;
		this.arrayposy = arrayposy;
		this.arrayorientation = arrayorientation;
		this.size = size;
		this.nombre = nombre;
		this.content = null;
	}
	
	public ArrayList<Character> getArrayorientation() {
		return arrayorientation;
	}

	public void setArrayorientation(ArrayList<Character> arrayorientation) {
		this.arrayorientation = arrayorientation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getArraywords() {
		return arraywords;
	}
	public void setArraywords(ArrayList<String> arraywords) {
		this.arraywords = arraywords;
	}
	public ArrayList<Integer> getArrayposx() {
		return arrayposx;
	}
	public void setArrayposx(ArrayList<Integer> arrayposx) {
		this.arrayposx = arrayposx;
	}
	public ArrayList<Integer> getArrayposy() {
		return arrayposy;
	}
	public void setArrayposy(ArrayList<Integer> arrayposy) {
		this.arrayposy = arrayposy;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
