package es.deusto.spq.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.controller.controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class PointsWindow extends JFrame {

	private JPanel contentPane, panelE, panelW, PanelN, panelS;
	private JTextField txtTit;
	private JLabel Date;
	private JLabel Points;
	private JTextPane textPaneD;
	private JTextPane textPaneP;
	private JLabel lblTime;
	private JTextPane textPaneT;

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
	public PointsWindow() {
		final PointsWindow pw = this;
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
				pw.setVisible(false);
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
		
		lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Avenir", Font.PLAIN, 18));
		panelE.add(lblTime);
		
		textPaneD = new JTextPane();
		textPaneD.setEditable(false);
		panelE.add(textPaneD);
		
		textPaneP = new JTextPane();
		textPaneP.setEditable(false);
		panelE.add(textPaneP);
		
		textPaneT = new JTextPane();
		panelE.add(textPaneT);
	}

}
