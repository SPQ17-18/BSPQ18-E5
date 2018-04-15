package es.deusto.spq;

import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.spq.controller.controller;
import es.deusto.spqServer.dto.SoupDTO;





/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String [] args)
    {
    	try {
			controller cont=new controller(args);
			//System.out.println(cont.login("a1","abc"));
			ArrayList<String> arrs=new ArrayList<String>();
			arrs.add("hello");
			arrs.add("good");
			ArrayList<Integer> arrx=new ArrayList<Integer>();
			arrx.add(1);
			arrx.add(5);
			ArrayList<Integer> arry=new ArrayList<Integer>();
			arry.add(0);
			arry.add(3);
			ArrayList<Character> arrayc=new ArrayList<Character>();
			arrayc.add('V');
			arrayc.add('H');
			
			SoupDTO s=new SoupDTO(arrs,arrx,arry,arrayc,14,"s12");
			System.out.println("Introduciendo sopa");
			System.out.println(cont.IntroduceSoup(s));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
