package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This window allows to register if the user is not already inside.
 * @author SPQ-E5
 *
 */
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtTit;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JTextField textFieldEmail;
	private JLabel lblName,lblSurname,lblRol,lblPassword,lblRepeatPassword,lblEmail;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		final Register r = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelN = new JPanel();
		contentPane.add(panelN, BorderLayout.NORTH);
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		/**
		 * Close the window
		 */
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.dispose();
			}
		});
		panelS.add(btnCancel);
		
		/**
		 * Erases everything
		 */
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAll();
			}
		});
		panelS.add(btnDeleteAll);
		
		/**
		 * Registers the new user
		 */
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPass();
				checkEmail();
			}
		});
		panelS.add(btnRegister);
		
		JPanel panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.EAST);
		
		JPanel panelO = new JPanel();
		contentPane.add(panelO, BorderLayout.WEST);
		
		JPanel panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Avenir", Font.PLAIN, 15));
		panelC.add(lblName);
		
		textFieldName = new JTextField();
		panelC.add(textFieldName);
		textFieldName.setColumns(10);
		
		lblSurname = new JLabel("Surname: ");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Avenir", Font.PLAIN, 15));
		panelC.add(lblSurname);
		
		textFieldSurname = new JTextField();
		panelC.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		lblRol = new JLabel("Rol: ");
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblRol.setFont(new Font("Avenir", Font.PLAIN, 15));
		panelC.add(lblRol);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Student", "Teacher", "Partent"}));
		panelC.add(comboBox);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Avenir", Font.PLAIN, 15));
		panelC.add(lblPassword);
		
		passwordField1 = new JPasswordField();
		panelC.add(passwordField1);
		
		lblRepeatPassword = new JLabel("Repeat password: ");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepeatPassword.setFont(new Font("Avenir", Font.PLAIN, 15));
		panelC.add(lblRepeatPassword);
		
		passwordField2 = new JPasswordField();
		panelC.add(passwordField2);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Avenir", Font.PLAIN, 15));
		panelC.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panelC.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		txtTit = new JTextField();
		txtTit.setEditable(false);
		txtTit.setBackground(Color.CYAN);
		txtTit.setHorizontalAlignment(SwingConstants.CENTER);
		txtTit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		txtTit.setText("REGISTER");
		panelN.add(txtTit);
		txtTit.setColumns(10);
	}

	/**
	 * Method for deleting all the fields of the registering process
	 */
	private void deleteAll() {
		textFieldName.setText("");
		textFieldSurname.setText("");
		textFieldEmail.setText("");
		passwordField1.setText("");
		passwordField2.setText("");
		comboBox.setSelectedIndex(-1);
	}
	
	/**
	 * Method for checking if the passwords are correct
	 * @return
	 */
	private void checkPass() {
		String pass1 = passwordField1.getText();
		String pass2 = passwordField2.getText();
		
		if(pass1!=pass2) {
			JOptionPane.showMessageDialog(null, "The passwords are not correct","ERROR",JOptionPane.ERROR_MESSAGE);
			passwordField1.setText("");
			passwordField2.setText("");
		
		}
	}
	/**
	 * Method for checking if the email is correct
	 * @return
	 */
	private void checkEmail() {
		String email = textFieldEmail.getText();
		
			if(email.contains("@")==false) {
				JOptionPane.showMessageDialog(null, "Bad email format","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		
		
	}
	
}
