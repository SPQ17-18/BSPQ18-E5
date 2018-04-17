package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;
import es.deusto.spqServer.dto.SoupDTO;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsertNewSoup extends JFrame {

	private JPanel contentPane, panelN, panelS, panelE;
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
	private ArrayList<String> words=new ArrayList<String>();
	private ArrayList<Integer> posx=new ArrayList<Integer>();
	private ArrayList<Integer> posy=new ArrayList<Integer>();
	private ArrayList<Character> posicion=new ArrayList<Character>();
	private JTextField[][] casillas;
	private JPanel panelC;
	private JComboBox comboBoxVH;
	controller c = null;
	

	/**
	 * Create the frame.
	 */
	public InsertNewSoup(String [] args) {
		try {
			c=new controller(args);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final InsertNewSoup ins = this;
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
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ins.setVisible(false);	
			}
		});
		panelS.add(btnReturn);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoupDTO s=new SoupDTO(words,posx,posy,posicion,Integer.parseInt(textFieldRows.getText()),"s12");
				c.IntroduceSoup(s);
				JOptionPane.showMessageDialog(null, "Your soup has been stored");
				ins.dispose();
			}
		});
		panelS.add(btnSave);
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
				int num = Integer.parseInt(text);
				if(num>20) {
					JOptionPane.showMessageDialog(null, "The number is too big");
					textFieldRows.setText("");
				}else {
				//CREATE TABLE CON NUMBERO 
				deletePanel();
				panelC.setLayout(new GridLayout(num, num, 0, 0));
				insertCasillas(num);
				
				panelC.repaint();
				panelC.revalidate();
				}
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
		
		comboBoxVH = new JComboBox();
		comboBoxVH.setModel(new DefaultComboBoxModel(new String[] {"", "Vertical", "Horizontal"}));
		Blanck.add(comboBoxVH);
		
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
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//We check if the position is okay
				String text =textFieldRows.getText();
				int num = Integer.parseInt(text);
				
				if(checkPos(num)==true) {
					//TODO WE STORE THE WORD IN THE BD
					String hv = (String) comboBoxVH.getSelectedItem();
					char selection;
					if(hv=="Vertical") {
						selection='v';
					}else {
						selection='h';
					}
					
					
					
					insertWord(textFieldWord.getText(), Integer.parseInt(textFieldPx.getText())-1,Integer.parseInt(textFieldPy.getText())-1, selection);
					panelC.repaint();
					panelC.revalidate();
					words.add(textFieldWord.getText());
					posx.add(Integer.parseInt(textFieldPx.getText())-1);
					posy.add(Integer.parseInt(textFieldPy.getText())-1);
					posicion.add(selection);
				}
			}
		});
		panelE1.add(btnConfirm);
		
		panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(new GridLayout(5, 5, 0, 0));
		

	}
	
	
	/**
	 * Method for deleting all the table labels
	 */
	public void deletePanel() {			
				panelC.removeAll();
	}
	
	/**
	 * Method for checking the correct position
	 * @param num
	 * @return
	 */
	private boolean checkPos(int num) {
		//The position cannot be less than 0
		if(Integer.parseInt(textFieldPx.getText())<0 || Integer.parseInt(textFieldPy.getText())<0 || Integer.parseInt(textFieldPx.getText())>num || Integer.parseInt(textFieldPy.getText())>num) {
			JOptionPane.showMessageDialog(null, "The position is incorrect");
			return false;
		}else {
			return true;
		}

	}
	
	public void insertCasillas(int size) {
		
		
		casillas=new JTextField[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				casillas[i][j]=new JTextField();
				casillas[i][j].setText(" ");
				panelC.add(casillas[i][j]);
				casillas[i][j].setEditable(false);
			}
			
		}
		
	}
	
	public void insertWord(String word,int positionx,int positiony,char pos) {
		words.add(word);
		posx.add(positionx);
		posy.add(positiony);
		posicion.add(pos);
		int x=positionx;
		int y=positiony;
		for(int i=0;i<word.length();i++) {
			if(pos=='v' || pos=='V') {
				casillas[y+i][x].setText(""+word.charAt(i));
//				casillas[y+i][x].setFont(new Font("Avenir", Font.PLAIN, 15));
//				casillas[y+i][x].setHorizontalAlignment(SwingConstants.CENTER);
				
			}else {
				casillas[y][x+i].setText(""+word.charAt(i));				
			
			}
		}

		
	}
}
