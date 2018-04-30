package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
	private JList list; 
	private DefaultListModel modelo; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectSoup frame = new SelectSoup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectSoup() {
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
		
		list = new JList();//insert here the method that extracts all the soups name from database
		modelo = new DefaultListModel();
		for(int i=0; i<=controller.soupList().size(); i++) {// searching for code that allows me to pass a list from a method of "controller" class to the model of JList
		}
		list.setModel(modelo);
		panel.add(list);
	}
}
