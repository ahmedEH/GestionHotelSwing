package Hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class SupEditClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextField cin;
	private JTextField nom;
	private JTextField prenom;
	private JTextField date_naissance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupEditClient frame = new SupEditClient();
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
	public SupEditClient() {
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 86, 221, 39);
		contentPane.add(textField);
		
		JComboBox gender = new JComboBox();
		gender.setBounds(705, 236, 126, 20);
		contentPane.add(gender);
		
		cin = new JTextField();
		cin.setEnabled(false);
		cin.setColumns(10);
		cin.setBounds(705, 135, 126, 20);
		contentPane.add(cin);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(705, 171, 126, 20);
		contentPane.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(705, 200, 126, 20);
		contentPane.add(prenom);
		
		date_naissance = new JTextField();
		date_naissance.setColumns(10);
		date_naissance.setBounds(705, 265, 126, 20);
		contentPane.add(date_naissance);
		
		gender.addItem(new ComboItem("Homme", "H"));
		gender.addItem(new ComboItem("Femme", "F"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver succes");
		} catch (ClassNotFoundException e1) {
			System.out.println("Driver Failed");
			e1.printStackTrace();
		}
		
			// Connection
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			System.out.println("Connection succes");
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}

		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
					Statement st = cnx.createStatement();
					
					ResultSet rs =  st.executeQuery("select * from client where CIN='"+textField.getText()+"'");
					
					if (rs.next())
					{
						System.out.println("Login Succes");
			            cin.setText(rs.getString("CIN"));
			            nom.setText(rs.getString("Nom"));
			            prenom.setText(rs.getString("Prenom"));
			            date_naissance.setText(rs.getString("Date_Naissance"));
			            String g = rs.getString("Gender");
			            if(((ComboItem)(gender.getItemAt(0))).getValue().toString().contentEquals(rs.getString("Gender")))
			            	{gender.setSelectedItem(gender.getItemAt(0));}
			            else
			            {gender.setSelectedItem(gender.getItemAt(1));}
			            	


					}
					
					else 
					{
						System.out.println("Login Failed");
		            	JOptionPane.showMessageDialog(null," Oups,fail in not found !  " );
					}
						System.out.println("Driver Succes");
					
				} catch (SQLException e1) {
					
					System.out.println("Request Failed");
					
					e1.printStackTrace();
					
				}
			
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Andalus", Font.BOLD, 18));
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(241, 86, 111, 39);
		contentPane.add(btnNewButton_2);
		
		btnNewButton = new JButton("Retourner");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Andalus", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(148, 195, 122, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom ");
		lblNewLabel_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(542, 167, 38, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prenom ");
		lblNewLabel_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(542, 196, 58, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(542, 232, 51, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date de naissance");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(542, 261, 126, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		

		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		lblNewLabel_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1.setBounds(542, 131, 28, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton supprimer = new JButton("Spprumer");
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

					Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
					Statement st = cnx.createStatement();
					
					ResultSet rs =  st.executeQuery("select * from client where CIN='"+textField.getText()+"'");
					
				      String query = "delete from client where CIN = '"+cin.getText()+"'";
				      PreparedStatement preparedStmt = cnx.prepareStatement(query);

				      // execute the preparedstatement
				      preparedStmt.executeUpdate();
				    	  JOptionPane.showMessageDialog(null," Client est supprimee  " );
				    	  setVisible(false);
				    	  dispose();
				    	  AffichageClients a = new AffichageClients();
				    	  a.setVisible(true);
				      
				      
				      cnx.close();
				    }
				    catch (Exception f)
				    {
				      System.err.println("Got an exception! ");
				      System.err.println(f.getMessage());
				    }
			}
		});
		supprimer.setBounds(635, 311, 98, 23);
		contentPane.add(supprimer);
		
		JButton ajouter = new JButton("Editer");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
	                        "root", "");

	                    Statement st = connection.createStatement();
	                    
	                    String query = "Update client set CIN = '"+cin.getText()+"',Nom = '"+nom.getText()+"',Prenom = '"+prenom.getText()+"', Gender = '"+((ComboItem)(gender.getSelectedItem())).getValue().toString()+"',Date_Naissance = '"+date_naissance.getText()+"' Where CIN = '"+cin.getText()+"'";


	                    if(!date_naissance.getText().isEmpty() && date_naissance.getText().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
	                        String date[] = date_naissance.getText().toString().split("-");
	                        int day = Integer.parseInt(date[2]);
	                        int month = Integer.parseInt(date[1]);
	                        int year = Integer.parseInt(date[0]);
	                    	
	                    
	                    if(!cin.getText().matches("[0-9]{8}")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in CIN");
	                    }
	                    
	                    else if(!nom.getText().matches("^[a-zA-Z]{3,}$") || !prenom.getText().matches("^[a-zA-Z]{3,}$")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in first and last name");
	                    }

	                    else if(!date_naissance.getText().matches("[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in Date veilley respecter ce format 'yyyy-mm-dd'");
	                    }
	                    else if((year <1900) || (year > 2015) || (month <1) || (month > 12) || (day <1) || (day > 31)) {


	                    	JOptionPane.showMessageDialog(null, "Erreur dans la date");
	                    
	                    }
	                    
	                    else {

	                    int rs = st.executeUpdate(query);
	                    if (rs == 1) {

	                        JOptionPane.showMessageDialog(null, "modified");
					    	  setVisible(false);
					    	  dispose();
					    	  AffichageClients a = new AffichageClients();
					    	  a.setVisible(true);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error");
	                    }}}else {
	                    	JOptionPane.showMessageDialog(null, "Error date");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		ajouter.setBounds(788, 311, 98, 23);
		contentPane.add(ajouter);
	}
}
