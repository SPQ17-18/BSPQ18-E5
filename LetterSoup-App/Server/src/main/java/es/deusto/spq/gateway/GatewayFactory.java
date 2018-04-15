package es.deusto.spq.gateway;
//Factory of gateways
public class GatewayFactory implements IGateway{

	GatewayFactory GatewayFactory = new GatewayFactory();
	public GatewayFactory() {
		
	}
	//Method for sending a message introducing by paramethers the text and the destination 
	public static void sendMessage(String text, Destiny dest) {
			MailSender ms= new MailSender(dest.getEmail_address());
			ms.sendMessage(text);
			
			}
	
}
