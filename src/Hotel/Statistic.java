package Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statistic extends JFrame {

	private JPanel contentPane;
	Connection con;
	PreparedStatement st;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistic frame = new Statistic();
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
	public Statistic() {
		

		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistiques");
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 71));
		lblNewLabel.setBounds(351, 11, 352, 91);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres des client");
		lblNewLabel_1.setFont(new Font("Andalus", Font.BOLD, 44));
		lblNewLabel_1.setBounds(10, 113, 485, 98);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres des chambres");
		lblNewLabel_1_1.setFont(new Font("Andalus", Font.BOLD, 44));
		lblNewLabel_1_1.setBounds(517, 113, 515, 98);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombres des reservations");
		lblNewLabel_1_1_1.setFont(new Font("Andalus", Font.BOLD, 44));
		lblNewLabel_1_1_1.setBounds(10, 311, 515, 98);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Retourner");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("Andalus", Font.BOLD, 22));
		btnNewButton.setBounds(693, 339, 196, 56);
		contentPane.add(btnNewButton);
		
		JLabel nbr_client = new JLabel("");
		nbr_client.setForeground(new Color(34, 139, 34));
		nbr_client.setHorizontalAlignment(SwingConstants.CENTER);
		nbr_client.setFont(new Font("Bell MT", Font.BOLD, 49));
		nbr_client.setBounds(87, 206, 190, 64);
		contentPane.add(nbr_client);
		
		JLabel nbr_room = new JLabel("");
		nbr_room.setHorizontalAlignment(SwingConstants.CENTER);
		nbr_room.setForeground(new Color(34, 139, 34));
		nbr_room.setFont(new Font("Bell MT", Font.BOLD, 49));
		nbr_room.setBounds(662, 206, 190, 64);
		contentPane.add(nbr_room);
		
		JLabel nbr_reservation = new JLabel("");
		nbr_reservation.setHorizontalAlignment(SwingConstants.CENTER);
		nbr_reservation.setForeground(new Color(34, 139, 34));
		nbr_reservation.setFont(new Font("Bell MT", Font.BOLD, 49));
		nbr_reservation.setBounds(144, 420, 190, 64);
		contentPane.add(nbr_reservation);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver succes");
		} catch (ClassNotFoundException e1) {
			System.out.println("Driver Failed");
			e1.printStackTrace();
		}
		
			// Connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			System.out.println("Connection succes");
			String query;
			query = "select count(*) AS rowcount from reservation";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			rs.next();
			int count = rs.getInt("rowcount");
			nbr_reservation.setText(Integer.toString(count));
			query = "select count(*) as rowcount from client";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			rs.next();
			count = rs.getInt("rowcount");
			nbr_client.setText(Integer.toString(count));
			query = "select count(*) as rowcount from room";
			st = con.prepareStatement(query);
			rs = st.executeQuery();
			rs.next();
			count = rs.getInt("rowcount");
			nbr_room.setText(Integer.toString(count));


			
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
	}
}
