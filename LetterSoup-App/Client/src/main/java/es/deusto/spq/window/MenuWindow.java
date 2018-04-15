package es.deusto.spq.window;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuWindow extends JFrame implements Runnable {

	private JPanel contentPane,panelNorth, panelSouth, panelSCenter, panelSRight;
	private JTextField txtTit;
	private JButton buttonQ;
	private JLabel labelClock;
	String hour, minutes , seconds, ampm;
	Calendar cal;
	Thread t1;
	private JPanel panelCenter;
	private JPanel panelNorthC;
	private JLabel lblWelcome;
	private JLabel labelName;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow();
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
	public MenuWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtTit = new JTextField();
		txtTit.setEditable(false);
		txtTit.setBackground(Color.CYAN);
		txtTit.setHorizontalAlignment(SwingConstants.CENTER);
		txtTit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		txtTit.setText("LETTER SOUP GAME");
		panelNorth.add(txtTit);
		txtTit.setColumns(10);
		
		panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginWindow lw = new LoginWindow(null);
				lw.setVisible(true);
				
			}
		});
		panelSouth.add(btnExit);
		
		panelSCenter = new JPanel();
		panelSouth.add(panelSCenter);
		
		labelClock = new JLabel("New label");
		labelClock.setFont(new Font("Consolas", Font.PLAIN, 20));
		panelSCenter.add(labelClock);
		//Screen clock		
		Clock();
		
		panelSRight = new JPanel();
		panelSouth.add(panelSRight);
		panelSRight.setLayout(null);
		
		buttonQ = new JButton("?");
		buttonQ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(buttonQ, "1. Select your role (Student, Teacher or Parent).\n2. Introduce your username and password.\n3. Press enter (or register, in the case your are not already registered).");
			}
		});
		buttonQ.setFont(new Font("Avenir", Font.PLAIN, 13));
		buttonQ.setBounds(200, 0, 46, 29);
		panelSRight.add(buttonQ);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		panelNorthC = new JPanel();
		panelCenter.add(panelNorthC, BorderLayout.NORTH);
		
		lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setFont(new Font("Avenir", Font.PLAIN, 13));
		panelNorthC.add(lblWelcome);
		
		labelName = new JLabel("New label");
		labelName.setFont(new Font("Avenir", Font.PLAIN, 13));
		panelNorthC.add(labelName);
		
		panel = new JPanel();
		panelCenter.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnPlay = new JButton("Play!");
		btnPlay.setFont(new Font("Avenir", Font.PLAIN, 17));
		btnPlay.setBounds(73, 55, 117, 29);
		panel.add(btnPlay);
		
		JButton btnSeeScore = new JButton("See score");
		btnSeeScore.setFont(new Font("Avenir", Font.PLAIN, 17));
		btnSeeScore.setBounds(73, 115, 117, 29);
		panel.add(btnSeeScore);
	
	
		
	}	
	
	
	 
	 /**
	  * This code has been adapted from http://monillo007.blogspot.com.es/2011/07/programar-un-reloj-en-java.html 
	  */
	 
	 public void Clock() {
	        t1 = new Thread(this);
	        t1.start();
	        
	    }
	 
	 
	 public void calcula() {
	        Calendar calendar = new GregorianCalendar();
	        Date fechaHoraActual = new Date();


	        calendar.setTime(fechaHoraActual);
	        ampm = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

	        if (ampm.equals("PM")) {
	            int h = calendar.get(Calendar.HOUR_OF_DAY) - 12;
	            hour = h > 9 ? "" + h : "0" + h;
	        } else {
	            hour = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY);
	        }
	        minutes = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE);
	        seconds = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND);
	    
	 }

	public void run() {
		//  Auto-generated method stub
		 Thread ct = Thread.currentThread();
	        while (ct == t1) {
	            calcula();
	            labelClock.setText(hour + ":" + minutes + ":" + seconds + " " + ampm);
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	            }
	        }
	}
}
