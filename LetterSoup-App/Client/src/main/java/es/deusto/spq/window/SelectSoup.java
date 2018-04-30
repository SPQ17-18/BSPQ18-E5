package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;

import javax.swing.JList;

public class SelectSoup extends JFrame {
/**
 * Window that shows all soups and allow user to select one of them. 
 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList<String> list; 
	private DefaultListModel<String> modelo; 
	controller cont = null; 
	private String[] args=null;
	String[] listOfSoups;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SelectSoup frame = new SelectSoup(args);
		frame.setVisible(true);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public SelectSoup(String[] args) {
		this.args=args;
		try {
			cont=new controller(args);
		} catch (RemoteException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Select Soup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 34, 250, 227);
		contentPane.add(panel);
		
		//insert here the method that extracts all the soups name from database
		modelo = new DefaultListModel<String>();
        
        //Array for the JList
		
        listOfSoups = cont.soupList();
        ArrayList<String> soupList = new ArrayList<String>(Arrays.asList(listOfSoups));
        
        //Ciclo para agregar los elemntos del arreglo
        for(int i=0;i<soupList.size();i++) {
            modelo.addElement(soupList.get(i));
        }
  
        //Creating the JList and inserting the model on it
        list = new JList<String>(modelo);
		panel.add(list);
	}
}
