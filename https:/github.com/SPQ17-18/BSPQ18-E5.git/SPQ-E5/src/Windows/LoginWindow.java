package Windows;

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
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow extends JFrame {

	private JPanel contentPane,panelNorth, panelSouth, panelEast, panelWest, panelSCenter, panelSRight, panelRoles, panelUsername, panelPassword, panelButtons;
	private JTextField txtTit;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JButton buttonQ;
	private JLabel lblImage, lblAccess, labelRoles, labelUsername, lblPassword;
	private JComboBox comboBoxRoles;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
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
				System.exit(0);
			}
		});
		panelSouth.add(btnExit);
		
		panelSCenter = new JPanel();
		panelSouth.add(panelSCenter);
		
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
		
		panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		
		lblImage = new JLabel();
		panelWest.add(lblImage);
		//lblHereGoesThe.setIcon(new ImageIcon("/Users/aitor/Desktop/GettyImages-579236076-59641e375f9b583f18138ca1.jpg"));
		
		lblImage.setIcon(ajustarImagen("/Users/aitor/Desktop/GettyImages-579236076-59641e375f9b583f18138ca1.jpg"));
		
		
		panelEast = new JPanel();
		panelEast.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelEast, BorderLayout.CENTER);
		panelEast.setLayout(new GridLayout(5, 0, 0, 0));
		
		lblAccess = new JLabel("ACCESS MENU");
		lblAccess.setFont(new Font("Avenir", Font.PLAIN, 19));
		lblAccess.setHorizontalAlignment(SwingConstants.CENTER);
		panelEast.add(lblAccess);
		
		panelRoles = new JPanel();
		panelEast.add(panelRoles);
		panelRoles.setLayout(new GridLayout(0, 2, 0, 0));
		
		labelRoles = new JLabel("Choose role: ");
		labelRoles.setFont(new Font("Avenir", Font.PLAIN, 16));
		labelRoles.setHorizontalAlignment(SwingConstants.CENTER);
		panelRoles.add(labelRoles);
		
		comboBoxRoles = new JComboBox();
		comboBoxRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableLogIn();
			}
		});
		comboBoxRoles.setModel(new DefaultComboBoxModel(new String[] {"", "Student", "Teacher", "Parent"}));
		comboBoxRoles.setFont(new Font("Avenir", Font.PLAIN, 16));
		panelRoles.add(comboBoxRoles);
		
		
		panelUsername = new JPanel();
		panelEast.add(panelUsername);
		panelUsername.setVisible(false);
		panelUsername.setLayout(new GridLayout(1, 0, 0, 0));
		
		labelUsername = new JLabel("Username: ");
		labelUsername.setVisible(true);
		labelUsername.setFont(new Font("Avenir", Font.PLAIN, 16));
		labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		panelUsername.add(labelUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setVisible(true);
		textFieldUsername.setFont(new Font("Avenir", Font.PLAIN, 16));
		textFieldUsername.setToolTipText("Introduce your username");
		textFieldUsername.setColumns(10);
		panelUsername.add(textFieldUsername);
		
		panelPassword = new JPanel();
		panelPassword.setVisible(false);
		panelEast.add(panelPassword);
		panelPassword.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setVisible(true);
		lblPassword.setFont(new Font("Avenir", Font.PLAIN, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panelPassword.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setVisible(true);
		passwordField.setFont(new Font("Avenir", Font.PLAIN, 16));
		panelPassword.add(passwordField);
		
		panelButtons = new JPanel();
		panelButtons.setVisible(false);
		panelEast.add(panelButtons);
		
		JButton button_1 = new JButton("Delete");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteAll();
			}
		});
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Avenir", Font.PLAIN, 16));
		panelButtons.add(btnRegister);
		button_1.setFont(new Font("Avenir", Font.PLAIN, 16));
		panelButtons.add(button_1);
		
		JButton button_2 = new JButton("Enter");
		button_2.setFont(new Font("Avenir", Font.PLAIN, 16));
		panelButtons.add(button_2);
	
	
		
	}	
	
	/**
	 * This code has been taken from https://www.lawebdelprogramador.com/codigo/Java/2682-Ajustar-una-imagen-en-un-contenedor.html
	 * @param url
	 * @return
	 */
	 private ImageIcon ajustarImagen(String url)
	    {
	        ImageIcon tmpIconAux = new ImageIcon(url);
	        //Scale the image
	        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(350, 400, Image.SCALE_DEFAULT));
	        return tmpIcon;
	    }
	 
	 /**
	  * Method to clean the 3 log in fields
	  */
	 private void deleteAll() {
		 comboBoxRoles.setSelectedIndex(0);
		 textFieldUsername.setText("");
		 passwordField.setText("");
		 
	 }
	 
	 /**
	  * Method to hide the fields
	  */
	 private void enableLogIn(){
		 panelUsername.setVisible(true);
		 panelPassword.setVisible(true);
		 panelButtons.setVisible(true);
	 }
}
