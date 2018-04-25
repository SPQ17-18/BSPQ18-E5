package es.deusto.spq.window;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;

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
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuWindow extends JFrame implements Runnable {

	private JPanel contentPane,panelNorth, panelSouth, panelSCenter, panelSRight;
	private JTextField txtTit;
	private JLabel labelClock;
	String hour, minutes , seconds, ampm;
	Calendar cal;
	Thread t1;
	private JPanel panelCenter;
	private JPanel panelNorthC;
	private JLabel lblWelcome;
	private JPanel panel;
	private static String [] ar= new String[3];
	private JButton btnExamMode;
	InsertNewSoup in;
	PointsWindow pw;
	private String user=null;
	private String [] args=null;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuWindow frame = new MenuWindow(c);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	

	/**
	 * Create the frame.
	 *  
	 */
	public MenuWindow(String[] args) {
		
		System.out.println("menu window");
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
				JOptionPane.showMessageDialog(null, "Thank you for playing \nSee you soon!");
				System.exit(0);
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
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		panelNorthC = new JPanel();
		panelCenter.add(panelNorthC, BorderLayout.NORTH);
		
		lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Avenir", Font.PLAIN, 13));
		panelNorthC.add(lblWelcome);
		
		panel = new JPanel();
		panelCenter.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnPlay = new JButton("Play!");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolveSoup ss = new SolveSoup();
				ss.setVisible(true);
			}
		});
		btnPlay.setFont(new Font("Avenir", Font.PLAIN, 17));
		btnPlay.setBounds(59, 55, 131, 29);
		panel.add(btnPlay);
		
		JButton btnSeeScore = new JButton("See score");
		pw = new PointsWindow(args);
		
		btnSeeScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw.setUser(user);
				pw.getUser();
				pw.setVisible(true);
			}
		});
		btnSeeScore.setFont(new Font("Avenir", Font.PLAIN, 17));
		btnSeeScore.setBounds(59, 115, 131, 29);
		panel.add(btnSeeScore);
		in = new InsertNewSoup(args);
		
		JButton btnInsertNewSoup = new JButton("Insert new soup");
		btnInsertNewSoup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				in.setVisible(true);
				
			}
		});
		
		btnInsertNewSoup.setBounds(59, 173, 131, 29);
		panel.add(btnInsertNewSoup);
		
		JButton btnSendEmail = new JButton("Send email");
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				ar[0]= "127.0.0.1";
//				ar[1]= "1099";
//				ar[2]="LetterSoupServer";
//				
//					try {
//						controller c = new controller(ar);
//						c.sendMail("We have a 10 :D", "aitor.santa@opendeusto.es");
//					} catch (RemoteException e1) {
//						// Auto-generated catch block
//						e1.printStackTrace();
//					}
//			
//				
//				
				
			}
		});
		btnSendEmail.setBounds(59, 224, 131, 29);
		panel.add(btnSendEmail);
		
		btnExamMode = new JButton("Exam mode");
		btnExamMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Do you really want to start the exam mode?", "Selection", JOptionPane.INFORMATION_MESSAGE);
				ExamMode em = new ExamMode();
				em.setVisible(true);
				
			}
		});
		btnExamMode.setBounds(59, 275, 131, 29);
		panel.add(btnExamMode);
	
	System.out.println("menu window terminada");
		
	}	
	
	
	 
	 public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String[] getArgs() {
		return args;
	}



	public void setArgs(String[] args) {
		this.args = args;
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
