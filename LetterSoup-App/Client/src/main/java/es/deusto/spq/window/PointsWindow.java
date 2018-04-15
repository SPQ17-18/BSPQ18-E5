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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PointsWindow extends JFrame {

	private JPanel contentPane, panelE, panelW, PanelN, panelS;
	private JTextField txtTit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointsWindow frame = new PointsWindow();
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
				MenuWindow mw = new MenuWindow();
				mw.setVisible(true);
			}
		});
		panelS.add(btnReturn);
		
		JButton btnNewGame = new JButton("New game");
		panelS.add(btnNewGame);
		
		panelW = new JPanel();
		contentPane.add(panelW, BorderLayout.WEST);
		
		panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.CENTER);
	}

}
