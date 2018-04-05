package es.deusto.spq.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Record {
	@PrimaryKey
	private int record_id;	
	private Date date;
	private int record;
	@Persistent(defaultFetchGroup="true")
	private User user;
	
	public Record(int record_id, Date date, int record, User user) {
		
		this.record_id = record_id;
		this.date = date;
		this.record = record;
		this.user = user;
	}

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	
	

}
