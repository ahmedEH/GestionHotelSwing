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




public class AddRoomFrame extends JFrame {

	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JTextField id;
	private JTextField surface;
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomFrame frame = new AddRoomFrame();
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
	public AddRoomFrame() {
		
		
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
		
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Ajout d'un chambre");
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 38));
		lblNewLabel.setBounds(360, 0, 327, 58);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Surface");
		lblNewLabel_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(114, 144, 58, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Type");
		lblNewLabel_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(114, 180, 51, 25);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JComboBox type = new JComboBox();
		type.setBounds(277, 184, 126, 20);
		type.addItem(new ComboItem("Individuelle", "INDIV"));
		type.addItem(new ComboItem("Double", "DOUBLE"));
		getContentPane().add(type);
		
		id = new JTextField();
		id.setBounds(277, 112, 126, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		surface = new JTextField();
		surface.setColumns(10);
		surface.setBounds(277, 148, 126, 20);
		getContentPane().add(surface);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1.setBounds(114, 108, 28, 25);
		getContentPane().add(lblNewLabel_1);
		
		JButton effacer = new JButton("Effacer");
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				surface.setText("");

				type.setSelectedItem(type.getItemAt(0));
				
				
			}
		});
		effacer.setBounds(205, 237, 98, 23);
		getContentPane().add(effacer);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
	                        "root", "");

	                    Statement st = connection.createStatement();
	                    
	                    String query = "insert into room (ID,surface,type) values ("+id.getText()+",'"+surface.getText()+"','"+((ComboItem)(type.getSelectedItem())).getValue().toString()+"')";



	                    if(!id.getText().matches("[0-9]+$")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in ID");
	                    }
	                    
	                    else if(!surface.getText().matches("^[0-9]+$")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in surface");
	                    }

	                    
	                    else {

	                    int rs = st.executeUpdate(query);
	                    if (rs == 1) {

	                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
	        				id.setText("");
	        				surface.setText("");

	        				type.setSelectedItem(type.getItemAt(0));
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error");
	                    }}
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		ajouter.setBounds(358, 237, 98, 23);
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
		retourner.setBounds(498, 237, 98, 23);
		getContentPane().add(retourner);
		

		
	}

}
