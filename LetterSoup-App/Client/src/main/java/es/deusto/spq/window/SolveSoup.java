package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.deusto.spq.controller.controller;
import es.deusto.spqServer.data.User;
import es.deusto.spqServer.dto.SoupDTO;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SolveSoup extends JFrame implements Runnable{

	private JPanel contentPane, panelWest;
	private JTextField txtLetsPlay;
	private JButton [][] casillas;
	private ArrayList<String> words=new ArrayList<String>();
	private ArrayList<Integer> posx=new ArrayList<Integer>();
	private ArrayList<Integer> posy=new ArrayList<Integer>();
	private ArrayList<Character> posicion=new ArrayList<Character>();

	private SoupDTO sopa;
	private JPanel panelE1=new JPanel();
	private JTextField textFieldWord;
	private JComboBox<Character> comboBoxVH;
	private JTextField textFieldPx;
	private JTextField textFieldPy;
	
	private String nombre;
	private String User;

	Thread t1;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
					SolveSoup frame = new SolveSoup(args,"s1","a1");
					frame.setVisible(true);
		}

	/**
	 * Create the frame.
	 */
	public SolveSoup(String[] args,String nameSoup,String user) {
		
		this.User=user;
		this.nombre=nameSoup;
		this.sopa=controller.getController().getSoup(nameSoup);
		System.out.println(this.sopa.getArraywords().size());
		System.out.println(this.sopa.getArrayorientation().size());
		System.out.println(this.sopa.getArrayposx().size());
		System.out.println(this.sopa.getArrayposy().size());
		System.out.println(this.sopa.getContent());
		System.out.println(this.sopa.getNombre());
		System.out.println(this.sopa.getSize());

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JLabel lblWords = new JLabel(" Introduce word:");
		panelE1.setLayout(new BoxLayout(panelE1,BoxLayout.Y_AXIS));
		panelE1.add(lblWords);
		
		textFieldWord = new JTextField();
		panelE1.add(textFieldWord);
		textFieldWord.setColumns(7);
		
		JPanel Blanck = new JPanel();
		panelE1.add(Blanck);
		
		comboBoxVH = new JComboBox<Character>();
		comboBoxVH.addItem('V');
		comboBoxVH.addItem('H');
		Blanck.add(comboBoxVH);
		
		JLabel lblPosition = new JLabel(" Position:");
		panelE1.add(lblPosition);
		
		JPanel panelPos = new JPanel();
		panelPos.setLayout(new BoxLayout(panelPos,BoxLayout.Y_AXIS));
		
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
		panelE1.add(panelPos);
		
		JPanel panelBlanck2 = new JPanel();
		panelE1.add(panelBlanck2);
		JButton badd=new JButton("Add");
		panelE1.add(badd);
		contentPane.add(panelE1,BorderLayout.EAST);
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
		
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				insertWord(textFieldWord.getText(),Integer.parseInt(textFieldPx.getText()),Integer.parseInt(textFieldPy.getText()),(Character) comboBoxVH.getSelectedItem());
			}
		});
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
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
				
			}
		});
		panelS.add(btnFinish);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoupDTO s=new SoupDTO(words,posx ,posy, posicion, sopa.getSize(), nombre);
				int score=controller.getController().getScoreGame(s,User);
				JOptionPane.showMessageDialog(null,"Your score is"+score , "Score", JOptionPane.INFORMATION_MESSAGE, null);
				dispose();
			}
		});
		
		
		panelWest = new JPanel();
		panelWest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(sopa.getSize(),sopa.getSize(), 0, 0));
		

		

		Border border = LineBorder.createGrayLineBorder();
		
		panelE1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelE1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		

		insertCasillas();
		Clock();
		

	}
	
	
	
	public void insertCasillas() {
		System.out.println("entro");
		int size=sopa.getSize();
		casillas=new JButton[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				casillas[i][j]=new JButton();
				casillas[i][j].setText(""+sopa.getContent().charAt((size*i)+j));
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
				casillas[y+i][x].setBackground(Color.blue);
				
			}else {
				casillas[y][x+i].setBackground(Color.blue);				
			
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