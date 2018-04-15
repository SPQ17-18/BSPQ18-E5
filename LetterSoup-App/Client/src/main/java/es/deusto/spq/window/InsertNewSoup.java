package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InsertNewSoup extends JFrame {
	/**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	private JTextField [][] casillas;
	private ArrayList<JPanel> lines=new ArrayList<JPanel>();
	private JPanel contentPane;
	private ArrayList<String> words=new ArrayList<String>();
	private ArrayList<Integer> posx=new ArrayList<Integer>();
	private ArrayList<Integer> posy=new ArrayList<Integer>();
	private ArrayList<Character> posicion=new ArrayList<Character>();


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setContentPane(contentPane);
		insertCasillas(10);
		insertWord("hola",1,2,'V');
		
		
	}
	
	public void insertCasillas(int size) {
		casillas=new JTextField[size][size];
		for(int i=0;i<size;i++) {
			lines.add(new JPanel());
			lines.get(i).setLayout(new BoxLayout(lines.get(i), BoxLayout.X_AXIS));
			contentPane.add(lines.get(i));
			for(int j=0;j<size;j++) {
				casillas[i][j]=new JTextField();
				casillas[i][j].setText(" ");
				//casillas[i][j].setEditable(false);
				casillas[i][j].addMouseListener(new MouseListener() {

					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						setBackground(Color.BLUE);
					}

					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				lines.get(i).add(casillas[i][j]);
	
			}
		}
		contentPane.repaint();
		contentPane.revalidate();
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
				
			}else {
				casillas[y][x+i].setText(""+word.charAt(i));				
			
			}
		}
		contentPane.repaint();
		contentPane.revalidate();

		
	}

}
