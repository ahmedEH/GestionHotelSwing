package Hotel;

import java.awt.BorderLayout;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class AddReservationFrame extends JFrame {

	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JTextField debut;
	private JTextField fin;
	Connection con1;
	PreparedStatement stmt1;
	ResultSet pstmt1;
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReservationFrame frame = new AddReservationFrame();
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
	public AddReservationFrame() {
		
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox chambre = new JComboBox();
		chambre.setBounds(275, 156, 126, 20);

		contentPane.add(chambre);
		
		JComboBox client = new JComboBox();
		client.setBounds(275, 120, 126, 20);
		contentPane.add(client);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver succes");
		} catch (ClassNotFoundException e1) {
			System.out.println("Driver Failed");
			e1.printStackTrace();
		}
		
			// Connection
		try {
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			System.out.println("Connection succes");
			String query = "Select CIN from client;";
			stmt1 = con1.prepareStatement(query);

			pstmt1 = stmt1.executeQuery(query);

			while(pstmt1.next())
			{
			client.addItem(new ComboItem(pstmt1.getString(1),pstmt1.getString(1)));
			}
			query = "Select ID from room;";
			stmt1 = con1.prepareStatement(query);

			pstmt1 = stmt1.executeQuery(query);

			while(pstmt1.next())
			{
			chambre.addItem(new ComboItem(pstmt1.getString(1),pstmt1.getString(1)));
			}
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		

		
		
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Ajout d'un reservation");
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 38));
		lblNewLabel.setBounds(360, 0, 399, 58);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Chambre");
		lblNewLabel_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(112, 152, 72, 25);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date de debut");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(112, 181, 126, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		

		
		debut = new JTextField();
		debut.setBounds(275, 185, 126, 20);
		getContentPane().add(debut);
		debut.setColumns(10);
		
		JButton effacer = new JButton("Effacer");
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				debut.setText("");
				fin.setText("");
				chambre.setSelectedItem(chambre.getItemAt(0));
				client.setSelectedItem(client.getItemAt(0));
				
				
			}
		});
		effacer.setBounds(207, 258, 98, 23);
		getContentPane().add(effacer);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
	                        "root", "");

	                    Statement st = connection.createStatement();
	                    int cl = Integer.parseInt((((ComboItem)(client.getSelectedItem())).getValue().trim()));
	                    int ch = Integer.parseInt((((ComboItem)(chambre.getSelectedItem())).getValue().trim()));
	                    
	                    String query = "insert into reservation(Date_debut,Date_fin,Client,Chambre) values ('"+debut.getText()+"','"+fin.getText()+"','"+cl+"','"+ch+"')";


	                    if(!debut.getText().isEmpty() && debut.getText().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]") && !fin.getText().isEmpty() && fin.getText().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {

	                        String date1[] = debut.getText().toString().split("-");
	                        int day = Integer.parseInt(date1[2]);
	                        int month = Integer.parseInt(date1[1]);
	                        int year = Integer.parseInt(date1[0]);
	                        String date2[] = fin.getText().toString().split("-");
	                        int day1 = Integer.parseInt(date2[2]);
	                        int month1 = Integer.parseInt(date2[1]);
	                        int year1 = Integer.parseInt(date2[0]);
	                    if(!debut.getText().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in Date veilley respecter ce format 'yyyy-mm-dd'");
	                    }
	                    else if(!fin.getText().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in Date veilley respecter ce format 'yyyy-mm-dd'");
	                    }
	                    else if((year <1900) || (year > 2015) || (month <1) || (month > 12) || (day <1) || (day > 31)) {


	                    	JOptionPane.showMessageDialog(null, "Erreur dans la date debut");
	                    
	                    }
	                    else if((year1 <1900) || (year1 > 2015) || (month1 <1) || (month1 > 12) || (day1 <1) || (day1 > 31)) {


	                    	JOptionPane.showMessageDialog(null, "Erreur dans la date fin");
	                    
	                    }
	                    
	                    else {

	                    int rs = st.executeUpdate(query);
	                    if (rs == 1) {

	                        JOptionPane.showMessageDialog(null, "You have successfully logged in");

	        				debut.setText("");
	        				chambre.setSelectedItem(chambre.getItemAt(0));
	        				fin.setText("");
	        				client.setSelectedItem(chambre.getItemAt(0));
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error");
	                    }}}else {
	                    	JOptionPane.showMessageDialog(null, "Erreur dans les date");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		ajouter.setBounds(360, 258, 98, 23);
		getContentPane().add(ajouter);
		
		JButton retourner = new JButton("Retourner");
		retourner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
				
			}
		});
		retourner.setBounds(500, 258, 98, 23);
		getContentPane().add(retourner);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Date de fin");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(112, 213, 126, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		fin = new JTextField();
		fin.setColumns(10);
		fin.setBounds(275, 217, 126, 20);
		contentPane.add(fin);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Client");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_2.setBounds(112, 116, 51, 25);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		

		

		
	}
}
