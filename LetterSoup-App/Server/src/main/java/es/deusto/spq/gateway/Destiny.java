package es.deusto.spq.gateway;
//Destiny class for having a destination address
public class Destiny {

	private String ip;
	private int port;
	private String email_address;
	//Constructor
	public Destiny(String ip, int port, String email_address) {
		super();
		this.ip = ip;
		this.port = port;
		this.email_address = email_address;
	}
//Getters and setters
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	
}
