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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SelectSoup extends JFrame implements Runnable{
/**
 * Window that shows all soups and allow user to select one of them. 
 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList<String> list; 
	private DefaultListModel<String> modelo; 
	private String[] args=null;
	String[] listOfSoups;
	private String us=null;
	private String [] arg=null;
	private String nameS=null;
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		SelectSoup frame = new SelectSoup(args, nameSoup, user);
//		frame.setVisible(true);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SelectSoup(String[] args,String nameSoup, String user) {
		this.args=args;
		this.arg=args;
		this.us=user;
		this.nameS=nameSoup;
		
		setTitle("Select Soup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 26, 258, 224);
		contentPane.add(panel);
		
		//insert here the method that extracts all the soups name from database
		modelo = new DefaultListModel<String>();
        
        //Array for the JList
		
        listOfSoups = controller.getController().soupList();
        ArrayList<String> soupList = new ArrayList<String>(Arrays.asList(listOfSoups));
        
        //Ciclo para agregar los elemntos del arreglo
        for(int i=0;i<soupList.size();i++) {
            modelo.addElement(soupList.get(i));
        }
  
        //Creating the JList and inserting the model on it
        list = new JList<String>(modelo);
		panel.add(list);
		
		JLabel lblSelectTheSoup = new JLabel("Select a soup from the list: ");
		lblSelectTheSoup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectTheSoup.setBounds(10, 11, 228, 14);
		contentPane.add(lblSelectTheSoup);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolveSoup ss = new SolveSoup(arg,list.getSelectedValue(),us);
				ss.setVisible(true);
			}
		});//For the moment it can not select the soup 
		btnSelect.setBounds(278, 26, 146, 23);
		contentPane.add(btnSelect);
		
		JButton btnCancel = new JButton("Cancel");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuWindow mw = new MenuWindow(arg,nameS,us,null);
				mw.setVisible(true);
			}
		});
		btnCancel.setBounds(278, 60, 146, 23);
		contentPane.add(btnCancel);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
	

	public String[] getListOfSoups() {
		return listOfSoups;
	}

	public void setListOfSoups(String[] listOfSoups) {
		this.listOfSoups = listOfSoups;
	}
	
}
