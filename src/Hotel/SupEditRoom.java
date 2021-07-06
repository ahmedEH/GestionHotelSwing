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


public class SupEditRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextField id;
	private JTextField surface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupEditRoom frame = new SupEditRoom();
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
	public SupEditRoom() {
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
		
		JComboBox type = new JComboBox();
		type.setBounds(705, 236, 126, 20);
		contentPane.add(type);
		
		type.addItem(new ComboItem("Individuelle", "INDIV"));
		type.addItem(new ComboItem("Double", "DOUBLE"));
		
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
					
					ResultSet rs =  st.executeQuery("select * from room where ID='"+textField.getText()+"'");
					
					if (rs.next())
					{
						System.out.println("Login Succes");
			            id.setText(rs.getString("ID"));
			            surface.setText(rs.getString("Surface"));
			            String g = rs.getString("Type");
			            if(((ComboItem)(type.getItemAt(0))).getValue().toString().contentEquals(rs.getString("Type")))
			            	{type.setSelectedItem(type.getItemAt(0));}
			            else
			            {type.setSelectedItem(type.getItemAt(1));}
			            	


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
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Type");
		lblNewLabel_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(542, 232, 51, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton supprimer = new JButton("Spprumer");
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

					Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
					Statement st = cnx.createStatement();
					
					ResultSet rs =  st.executeQuery("select * from room where ID='"+textField.getText()+"'");
					
				      String query = "delete from room where ID = '"+id.getText()+"'";
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
	                    
	                    String query = "Update room set Surface = '"+surface.getText()+"', Type = '"+((ComboItem)(type.getSelectedItem())).getValue().toString()+"' Where ID = '"+id.getText()+"'";



	                    	
	                    
	                    if(!id.getText().matches("[0-9]+$")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in ID");
	                    }
	                    
	                    else if(!surface.getText().matches("^[0-9]+$")) {
	                    	
	                    	JOptionPane.showMessageDialog(null, "Error in surface");
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
	                    }}
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		ajouter.setBounds(788, 311, 98, 23);
		contentPane.add(ajouter);
		
		JLabel lblNewLabel_1_1 = new JLabel("Surface");
		lblNewLabel_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(542, 200, 58, 25);
		contentPane.add(lblNewLabel_1_1);
		

		
		id = new JTextField();
		id.setEditable(false);
		id.setEnabled(false);
		id.setColumns(10);
		id.setBounds(705, 168, 126, 20);
		contentPane.add(id);
		
		surface = new JTextField();
		surface.setColumns(10);
		surface.setBounds(705, 204, 126, 20);
		contentPane.add(surface);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1.setBounds(542, 164, 28, 25);
		contentPane.add(lblNewLabel_1);
	}
}
