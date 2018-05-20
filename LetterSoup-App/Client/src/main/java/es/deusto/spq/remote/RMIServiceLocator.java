package es.deusto.spq.remote;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.deusto.spq.controller.controller;
import es.deusto.spqServer.remote.IFacade;
/**
 * 
 * Class for for setting the service locator
 * @autor SPQ-E5
 *
 */
public class RMIServiceLocator {
	private IFacade facade;
	
	private final static Logger logger = Logger.getLogger(controller.class.getName());
	

	public RMIServiceLocator() {

	}

	public void setServices(String args0, String args1, String args2) {
		try {

			String service = "//" + args0 + ":" + args1 + "/" + args2;

			facade = (IFacade) java.rmi.Naming.lookup(service);
			
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"Getting service..."));
			
			
			
		} catch (Exception e) {
			logger.addAppender(new ConsoleAppender(new PatternLayout(),"Error trying to set Service."));
			logger.fatal("Error trying to set Service.", e);
		}
	}

	public IFacade getService() {
		return facade;
	}

}
