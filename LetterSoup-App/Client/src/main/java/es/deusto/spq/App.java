package es.deusto.spq;

import java.rmi.RemoteException;

import es.deusto.spq.controller.controller;

/**
 * Hello world!
 *
 */
public class App 
{
    public void a(String [] args)
    {
    	try {
			controller cont=new controller(args);
			System.out.println(cont.login("a1","abc"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
