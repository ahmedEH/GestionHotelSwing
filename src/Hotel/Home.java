package Hotel;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.TextField;
import java.awt.Window.Type;





public class Home extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Administration");
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.control);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Gestion des clients");
		menuBar.add(mnNewMenu);
		
		JMenu mnGestionDesChambres = new JMenu("Gestion des chambres");

		menuBar.add(mnGestionDesChambres);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ajouter");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				AddRoomFrame a = new AddRoomFrame();
				a.setVisible(true);
			}
			
		});
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionDesChambres.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Afficher");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				AffichageRooms a = new AffichageRooms();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionDesChambres.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("Modifier");
		mntmNewMenuItem_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				SupEditRoom a = new SupEditRoom();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionDesChambres.add(mntmNewMenuItem_4_1);
		
		JMenu mnGestionDesReservations = new JMenu("Gestion des reservations");
		menuBar.add(mnGestionDesReservations);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Ajouter");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				AddReservationFrame a = new AddReservationFrame();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionDesReservations.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Afficher");
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				AffichageReservation a = new AffichageReservation();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionDesReservations.add(mntmNewMenuItem_1_1_1);
		
		JMenuItem mntmNewMenuItem_4_2 = new JMenuItem("Modifier");
		mntmNewMenuItem_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				SupEditReservation a = new SupEditReservation();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestionDesReservations.add(mntmNewMenuItem_4_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administration");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 82));
		lblNewLabel.setBounds(150, 11, 749, 237);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Deconnecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Andalus", Font.BOLD, 17));
		btnNewButton.setBounds(438, 226, 149, 54);
		contentPane.add(btnNewButton);
		

		


		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajouter");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				AddClientFrame a = new AddClientFrame();
				a.setVisible(true);
				

			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		

		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Afficher");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				AffichageClients a = new AffichageClients();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Modifier");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				SupEditClient a = new SupEditClient();
				a.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Statistiques");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				Statistic s = new Statistic();
				s.setVisible(true);
				
				
				
			}
		});
		mntmNewMenuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmNewMenuItem_3);
	}
}
