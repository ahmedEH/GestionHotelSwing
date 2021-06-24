package Hotel;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;

public class Index extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		
		//Object item = comboBox.getSelectedItem();
		//String value = ((ComboItem)item).getValue();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver succes");
		} catch (ClassNotFoundException e1) {
			System.out.println("Driver Failed");
			e1.printStackTrace();
		}
		
			// Connection
		try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			System.out.println("Connection succes");
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle("Authentification");
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion d'hotel");
		lblNewLabel.setBounds(5, 5, 654, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 46));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(62, 128, 65, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(62, 179, 91, 22);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(182, 128, 127, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 179, 127, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(324, 233, 151, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Effacer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
					Statement st = cnx.createStatement();
					
					ResultSet rs =  st.executeQuery("select * from admin where login='"+textField.getText()+"'and pwd='"+textField.getText()+"'");
					
					if (rs.next())
					{
						System.out.println("Login Succes");
			            JOptionPane.showMessageDialog(null," logined successfully !  " );
			            
			            setVisible(false);
			            dispose();
			            
			            Home home = new Home();
			            home.setVisible(true);


					}
					
					else 
					{
						System.out.println("Login Failed");
		            	JOptionPane.showMessageDialog(null," Oups,fail in login !  " );
					}
						System.out.println("Driver Succes");
					
				} catch (SQLException e1) {
					
					System.out.println("Request Failed");
					
					e1.printStackTrace();
					
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(152, 233, 134, 41);
		contentPane.add(btnNewButton_1);
		
		
	}
}
