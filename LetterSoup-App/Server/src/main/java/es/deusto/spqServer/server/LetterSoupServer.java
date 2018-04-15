package es.deusto.spqServer.server;

import java.rmi.Naming;

import es.deusto.spqServer.remote.IFacade;
import es.deusto.spqServer.remote.LetterSoupManager;





public class LetterSoupServer {
	public static void main(String[] args) {
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
			System.out.println("* SoupLetter server '" + name + "' active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();
			System.out.println("he acabado");
						
		} catch (Exception e) {
			System.err.println("$ SoupLetter server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}


}
