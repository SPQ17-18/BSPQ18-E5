package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;
import es.deusto.spqServer.dto.ScoreDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
/**
 * Shows the points scored.
 * @author SPQ-E5
 *
 */
public class PointsWindow extends JFrame {

	private JPanel contentPane, panelE, panelW, PanelN, panelS;
	private JTextField txtTit;
	private JLabel Date;
	private JLabel Points;

	private JLabel lblTime;
	private JTextPane textPaneT;

	private JList<String> textPaneD;
	private JList<String> textPaneP;
	private String [] a;
	private String [] b;
	private ScoreDTO score = null;
	private String [] args=null;
	private String user=null;
	


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PointsWindow frame = new PointsWindow();
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
	public PointsWindow(String [] args) {
		this.args=args;
			
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 750, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PanelN = new JPanel();
		PanelN.setBackground(Color.CYAN);
		contentPane.add(PanelN, BorderLayout.NORTH);
		
		txtTit = new JTextField();
		txtTit.setEditable(false);
		txtTit.setBackground(Color.CYAN);
		txtTit.setHorizontalAlignment(SwingConstants.CENTER);
		txtTit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		txtTit.setText("YOUR POINTS");
		PanelN.add(txtTit);
		txtTit.setColumns(10);
		

		
		panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		
		JButton btnReturn = new JButton("Menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelS.add(btnReturn);
		
		JButton btnNewGame = new JButton("New game");
		panelS.add(btnNewGame);
		
		panelW = new JPanel();
		contentPane.add(panelW, BorderLayout.WEST);
		
		panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.CENTER);
		panelE.setLayout(new GridLayout(2, 2, 0, 0));
		
		Date = new JLabel("Date");
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		Date.setFont(new Font("Avenir", Font.PLAIN, 18));
		panelE.add(Date);
		
		Points = new JLabel("Points");
		Points.setHorizontalAlignment(SwingConstants.CENTER);
		Points.setFont(new Font("Avenir", Font.PLAIN, 18));
		panelE.add(Points);
		System.out.println("points window");
		

		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Avenir", Font.PLAIN, 18));
		panelE.add(lblTime);
		
//		textPaneD = new JTextPane();
//		textPaneD.setEditable(false);
		//panelE.add(textPaneD);
		
//		textPaneP = new JTextPane();
//		textPaneP.setEditable(false);
		//panelE.add(textPaneP);
		
		textPaneT = new JTextPane();
		panelE.add(textPaneT);


	}
	/**
	 * Getting the user
	 */
	public void getUser() throws RemoteException {
		score=controller.getController().getScore(user);
		a=new String[score.getArrayDate().size()];
		b=new String[score.getArrayrecord().size()];
		
		
		for(int i=0;i<score.getArrayDate().size();i++) {
			System.out.println(a[i]);
			System.out.println(b[i]);
			a[i]=score.getArrayDate().get(i).toString();
			b[i]=score.getArrayrecord().get(i).toString();
			//textPaneD.add(,null);
			//textPaneP.add(score.getArrayrecord().get(i).toString(),null);
		}
		textPaneD = new JList<String>(a);
		textPaneP = new JList<String>(b);
		panelE.add(textPaneD);
		panelE.add(textPaneP);
		
		panelE.repaint();
		panelE.revalidate();
		
		
	}
	public void setUser(String user) {
		this.user = user;
	}
	

}
