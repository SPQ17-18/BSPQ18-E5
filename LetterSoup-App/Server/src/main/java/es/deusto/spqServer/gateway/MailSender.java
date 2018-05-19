package es.deusto.spqServer.gateway;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.deusto.spqServer.dao.ManagerDAO;
/**
 * Class for allowing the mail to be sended
 * @autor SPQ-E5
 *
 */
public class MailSender {
	private final String from = "deusto.sd@gmail.com";
	private final String password = "softwaredesign";
	private final String host = "smtp.gmail.com";
	private final String port = "587";
	private final String subject = "Gateway Simulation: Sending SMS to Screen ...";
	private String to;
	private final static Logger logger = Logger.getLogger(MailSender.class.getName());

	private Properties props;

	public MailSender(String destination) {
		to = destination;
		props = new Properties();
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "false");
	}

	public String sendMessage(String text) {
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(text.trim());
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"Message sent to: " + to));
			
			
		} catch (Exception ex) {
			logger.addAppender(new ConsoleAppender(new PatternLayout()," $ Error sending message: " + ex));
			logger.fatal(" $ Error sending message: ", ex);
	    	
			
		}
		return "OK";
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(from, password);
		}
	}
}