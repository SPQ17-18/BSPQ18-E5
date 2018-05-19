package es.deusto.spqServer.gateway;
/**
 * 
 * class for setting destination address with attributes, constructor, getters and setters
 * @autor SPQ-E5
 */
public class Destiny {

	private String ip;
	private int port;
	private String email_address;
	
	public Destiny(String ip, int port, String email_address) {
		super();
		this.ip = ip;
		this.port = port;
		this.email_address = email_address;
	}

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
