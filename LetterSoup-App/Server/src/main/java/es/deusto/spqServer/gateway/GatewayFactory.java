package es.deusto.spqServer.gateway;
public class GatewayFactory {

	GatewayFactory GatewayFactory = new GatewayFactory();
	public GatewayFactory() {
		
	}
	public static void sendMessage(String text, Destiny dest) {
			MailSender ms= new MailSender(dest.getEmail_address());
			ms.sendMessage(text);
			
			}
	
}
