package es.deusto.spqServer.server;

import java.rmi.Naming;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.deusto.spqServer.dao.ManagerDAO;
import es.deusto.spqServer.remote.IFacade;
import es.deusto.spqServer.remote.LetterSoupManager;



/**
 * 
 * Server
 *
 */

public class LetterSoupServer {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(LetterSoupServer.class.getName());
		if (args.length != 3) {
			System.exit(0);
		}

		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		
		try {
			
			IFacade soupManager = new LetterSoupManager(args);	
			Naming.rebind(name, soupManager);
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"* SoupLetter server '" + name + "' active and waiting..."));
	    	
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"I have finished"));
	    	
						
		} catch (Exception e) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"$ SoupLetter server exception: " + e.getMessage()));
	    	
			e.printStackTrace();
		}
	}


}
