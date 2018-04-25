package es.deusto.spq.remote;

import es.deusto.spqServer.remote.IFacade;
/**
 * 
 * Class for for setting the service locator
 *
 */
public class RMIServiceLocator {
	private IFacade facade;

	public RMIServiceLocator() {

	}

	public void setServices(String args0, String args1, String args2) {
		try {

			String service = "//" + args0 + ":" + args1 + "/" + args2;

			facade = (IFacade) java.rmi.Naming.lookup(service);
			
			System.out.println("Getting service...");

		} catch (Exception e) {
			System.out.println("Error trying to set Service.");
		}
	}

	public IFacade getService() {
		return facade;
	}

}
