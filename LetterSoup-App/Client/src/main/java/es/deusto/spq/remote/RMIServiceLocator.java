package es.deusto.spq.remote;


//This class is for locating the service that controller provides for getting or setting it then
public class RMIServiceLocator {
	private IFacade facade;

	public RMIServiceLocator() {

	}

	public void setServices(String args0, String args1, String args2) {
		try {

			String service = "//" + args0 + ":" + args1 + "/" + args2;

			facade = (IFacade) java.rmi.Naming.lookup(service);
			
			System.out.println("Identification Service OK.");

		} catch (Exception e) {
			System.out.println("Error trying to set Identification Service.");
		}
	}

	public IFacade getService() {
		return facade;
	}

}
