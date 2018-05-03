package es.deusto.spq;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.controller.controller;
import es.deusto.spq.window.ExamMode;
import es.deusto.spq.window.LoginWindow;
import es.deusto.spq.window.MenuWindow;
import es.deusto.spq.window.PointsWindow;
import es.deusto.spq.window.Register;
import es.deusto.spq.window.SelectSoup;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	
private controller cont;
private LoginWindow lw;
private MenuWindow mw;
private Register r;
private SelectSoup sp;
private PointsWindow pw;
private ExamMode em;
private String[] args= {"127.0.0.1","1099","LetterSoupServer"};

	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
    /**
     * @return the suite of tests being tested
     */
@Before public void setup() {
	cont = new controller();
	lw = new LoginWindow(args);
	mw = new MenuWindow(args,null,"a1");
	r = new Register();
	sp = new SelectSoup(args,null,"a1");
	pw = new PointsWindow(args);
	em = new ExamMode();
	
}
   // public static Test suite()
    //{
       // return new TestSuite( AppTest.class );
    //}

    /**
     * Rigourous Test :-)
     * @throws RemoteException 
     */
	@Test public void testApp() throws RemoteException
    {
		controller.getController();
		controller.getController().setController(args);
		controller.getController().login("a1", "abc");
		controller.getController().soupList();
		controller.getController().setController(args);
        lw.main(args);
		
    }
	
}
