package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailWindow frame = new EmailWindow();
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
	public EmailWindow() {
		final EmailWindow ew = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Return to the previous window
				ew.dispose();
			}
		});
		btnExit.setFont(new Font("Avenir", Font.PLAIN, 13));
		panelS.add(btnExit);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Send message and close window
				controller.sendMail(textMessage.getText(), textField_1.getText());
				ew.dispose();
				
			}
		});
		btnSend.setFont(new Font("Avenir", Font.PLAIN, 13));
		panelS.add(btnSend);
		
		JPanel panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(null);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Avenir", Font.PLAIN, 13));
		lblTo.setBounds(123, 79, 20, 16);
		panelC.add(lblTo);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Write here the email of the student. (Example lisl@opendeusto.es)");
		textField_1.setBounds(149, 73, 240, 26);
		panelC.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("Avenir", Font.PLAIN, 13));
		lblMessage.setBounds(82, 117, 61, 16);
		panelC.add(lblMessage);
		
		textMessage = new JTextField();
		textMessage.setToolTipText("Write here the message");
		textMessage.setBounds(149, 117, 240, 106);
		panelC.add(textMessage);
		textMessage.setColumns(10);
		
		JButton btnEraseMessage = new JButton("Erase message");
		btnEraseMessage.setFont(new Font("Avenir", Font.PLAIN, 13));
		btnEraseMessage.setBounds(38, 194, 115, 29);
		panelC.add(btnEraseMessage);
		
		JLabel lblNewLabel = new JLabel("EMAIL SENDING");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		lblNewLabel.setBounds(6, 6, 428, 33);
		panelC.add(lblNewLabel);
	}
}
