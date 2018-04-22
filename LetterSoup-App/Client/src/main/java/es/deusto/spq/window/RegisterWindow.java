package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;
import javax.swing.JLabel;

public class RegisterWindow extends JFrame implements Runnable{

	private JPanel contentPane;
	String hour, minutes , seconds, ampm;
	Calendar cal;
	Thread t1;
	controller cont =null;
	private JLabel labelClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow frame = new RegisterWindow();
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
	public RegisterWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		labelClock.setBounds(378, 236, 46, 14);
		labelClock = new JLabel("New label");
		labelClock.setFont(new Font("Consolas", Font.PLAIN, 20));
		contentPane.add(labelClock);
		Clock();//Screen clock	
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
