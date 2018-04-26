package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.deusto.spq.controller.controller;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamMode extends JFrame implements Runnable{

	private JPanel contentPane, panelWest;
	private JTextField txtLetsPlay;
	private JButton [][] casillas;
	private ArrayList<String> words=new ArrayList<String>();
	private ArrayList<Integer> posx=new ArrayList<Integer>();
	private ArrayList<Integer> posy=new ArrayList<Integer>();
	private ArrayList<Character> posicion=new ArrayList<Character>();
	Thread t1;
	JLabel lblNewLabel;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SolveSoup frame = new SolveSoup();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ExamMode() {
		
		final ExamMode ss = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.CYAN);
		contentPane.add(panelN, BorderLayout.NORTH);
		
		txtLetsPlay = new JTextField();
		txtLetsPlay.setBackground(Color.CYAN);
		txtLetsPlay.setHorizontalAlignment(SwingConstants.CENTER);
		txtLetsPlay.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		txtLetsPlay.setEditable(false);
		txtLetsPlay.setText("LETS PLAY");
		panelN.add(txtLetsPlay);
		txtLetsPlay.setColumns(10);
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ss.dispose();
			}
		});
		panelS.add(btnReturn);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//We stop the clock
				t1.stop();
				
				//We display a message window with the final information
				String time = lblNewLabel.getText();
				
				//TODO We need to add the real values
				int totWords = 0;
				int totPoints = 0;
				
				JOptionPane.showMessageDialog(null, "This is the overview of the game:\n- Time played: "+time+" \n- Total correct words: "+totWords+" \n- Total points: "+totPoints, "Information summary", JOptionPane.INFORMATION_MESSAGE);
				ss.dispose();
			}
		});
		panelS.add(btnFinish);
		
		panelWest = new JPanel();
		panelWest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(5, 5, 0, 0));
		

		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		
		JLabel lblExamMode = new JLabel("EXAM MODE");
		lblExamMode.setFont(new Font("Consolas", Font.PLAIN, 25));
		panelEast.add(lblExamMode);
		
		JPanel panelE1 = new JPanel();
		panelE1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelEast.add(panelE1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelE1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		

		insertCasillas(5);
		Clock();
		
	}
	
	

	public void insertCasillas(int size) {
		casillas=new JButton[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				casillas[i][j]=new JButton();
				casillas[i][j].setText(" ");
				panelWest.add(casillas[i][j]);
	
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
				
			}else {
				casillas[y][x+i].setText(""+word.charAt(i));				
			
			}
		}


		
//github.com/SPQ17-18/BSPQ18-E5.git
	}
	
	public void actionPerformed() {
		setVisible(false);
	}
	
	
	 public void Clock() {
	        t1 = new Thread(this);
	        t1.start();
	        
	    }
	
	 public void run() {
			//  Auto-generated method stub
			int sec=0;
			int min=0;
			 Thread ct = Thread.currentThread();
		        while (ct == t1) {
		            try {
		            	for(min=0;min<60;min++) {
							for(sec=0;sec<60;sec++) {
								lblNewLabel.setText(min+":"+sec);
				                Thread.sleep(1000);
								}
		            	}

		            } catch (InterruptedException e) {
		            }
		        }
	}
	 
	 
	 
}