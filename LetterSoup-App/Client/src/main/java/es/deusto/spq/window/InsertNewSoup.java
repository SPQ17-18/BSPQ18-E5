package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertNewSoup extends JFrame {

	private JPanel contentPane, panelN, panelS, panelE, panelW, panelC;
	private JLabel lblTittle;
	private JButton btnReturn;
	private JButton btnSave;
	private JLabel lblNewLabel;
	private JPanel panelE1;
	private JLabel lblRows;
	private JLabel lblWords;
	private JLabel lblPosition;
	private JPanel Blanck;
	private JTextField textFieldRows;
	private JTextField textFieldWord;
	private JPanel panelPos;
	private JTextField textFieldPx;
	private JTextField textFieldPy;
	private JPanel panelBlanck2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertNewSoup frame = new InsertNewSoup();
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
	public InsertNewSoup() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelN = new JPanel();
		panelN.setBackground(Color.CYAN);
		contentPane.add(panelN, BorderLayout.NORTH);
		
		lblTittle = new JLabel("LETTER SOUP GAME");
		lblTittle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		panelN.add(lblTittle);
		
		panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		btnReturn = new JButton("Return");
		panelS.add(btnReturn);
		
		btnSave = new JButton("Save");
		panelS.add(btnSave);
		
		panelW = new JPanel();
		contentPane.add(panelW, BorderLayout.WEST);
		panelW.setLayout(new GridLayout(30, 30, 0, 0));
		//Función para meter tantos botones como tamaño asignemos
		
		panelE = new JPanel();
		panelE.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelE, BorderLayout.EAST);
		panelE.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel = new JLabel("CREATE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 29));
		panelE.add(lblNewLabel);
		
		panelE1 = new JPanel();
		panelE.add(panelE1);
		panelE1.setLayout(new GridLayout(4, 2, 0, 0));
		
		lblRows = new JLabel(" Number of rows: ");
		panelE1.add(lblRows);
		
		textFieldRows = new JTextField();
		panelE1.add(textFieldRows);
		textFieldRows.setColumns(10);
		
		JPanel panelCreate = new JPanel();
		panelE1.add(panelCreate);
		panelCreate.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text =textFieldRows.getText();
				int num = 0;
					num = Integer.parseInt(text);
				createTable(num);
			}
		});
		btnCreate.setBounds(6, 14, 71, 29);
		panelCreate.add(btnCreate);
		
		lblWords = new JLabel(" Introduce word:");
		panelE1.add(lblWords);
		
		textFieldWord = new JTextField();
		panelE1.add(textFieldWord);
		textFieldWord.setColumns(10);
		
		Blanck = new JPanel();
		panelE1.add(Blanck);
		
		lblPosition = new JLabel(" Position:");
		panelE1.add(lblPosition);
		
		panelPos = new JPanel();
		panelE1.add(panelPos);
		panelPos.setLayout(null);
		
		textFieldPx = new JTextField();
		textFieldPx.setBounds(15, 17, 29, 26);
		panelPos.add(textFieldPx);
		textFieldPx.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(23, 0, 21, 16);
		panelPos.add(lblX);
		
		textFieldPy = new JTextField();
		textFieldPy.setBounds(56, 17, 29, 26);
		panelPos.add(textFieldPy);
		textFieldPy.setColumns(10);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(67, 0, 29, 16);
		panelPos.add(lblY);
		
		panelBlanck2 = new JPanel();
		panelE1.add(panelBlanck2);
		
		JButton btnConfirm = new JButton("Confirm");
		panelE1.add(btnConfirm);
		
		panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
	}
	
	/**
	 * Method for creating the table
	 */
	public void createTable(int num) {
		
		//1. Checking the correction
		if(num>10) {
			JOptionPane.showMessageDialog(null, "The size is too big");
		}else {
		System.out.println(num);
		Rectangle r = new Rectangle();
		r.x=r.y=num;
		panelW.setBounds(r);
		
		//2. Creating the table TODO
		for(int i=0; i<num;i++) {
				JButton bot = new JButton("a");
				panelW.add(bot);
		}

		}
	}
	
	
	/**
	 * Method for deleting all the table labels
	 */
	public void deleteLabels(int num) {			
				panelW.removeAll();
	}
}
