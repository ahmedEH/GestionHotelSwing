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


class ComboItem
{
    private String key;
    private String value;

    public ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}

public class AddClientFrame extends JFrame {

	private JPanel contentPane;

	private JLabel lblNewLabel;
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
					AddClientFrame frame = new AddClientFrame();
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
	public AddClientFrame() {
		
		
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
		
		lblNewLabel = new JLabel("Ajout d'un client");
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 38));
		lblNewLabel.setBounds(413, 0, 274, 58);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom ");
		lblNewLabel_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(114, 144, 38, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prenom ");
		lblNewLabel_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(114, 173, 58, 25);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(114, 209, 51, 25);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date de naissance");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(114, 238, 126, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JComboBox gender = new JComboBox();
		gender.setBounds(277, 213, 126, 20);
		gender.addItem(new ComboItem("Homme", "H"));
		gender.addItem(new ComboItem("Femme", "F"));
		getContentPane().add(gender);
		
		cin = new JTextField();
		cin.setBounds(277, 112, 126, 20);
		getContentPane().add(cin);
		cin.setColumns(10);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(277, 148, 126, 20);
		getContentPane().add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(277, 177, 126, 20);
		getContentPane().add(prenom);
		
		date_naissance = new JTextField();
		date_naissance.setBounds(277, 242, 126, 20);
		getContentPane().add(date_naissance);
		date_naissance.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		lblNewLabel_1.setFont(new Font("Andalus", Font.BOLD, 16));
		lblNewLabel_1.setBounds(114, 108, 28, 25);
		getContentPane().add(lblNewLabel_1);
		
		JButton effacer = new JButton("Effacer");
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cin.setText("");
				nom.setText("");
				prenom.setText("");
				date_naissance.setText("");
				gender.setSelectedItem(gender.getItemAt(0));
				
				
			}
		});
		effacer.setBounds(207, 288, 98, 23);
		getContentPane().add(effacer);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
	                        "root", "");

	                    Statement st = connection.createStatement();
	                    
	                    String query = "insert into client (cin,fName,lName,gender,birthDay) values ("+cin.getText()+",'"+nom.getText()+"','"+prenom.getText()+"','"+((ComboItem)(gender.getSelectedItem())).getValue().toString()+"','"+date_naissance.getText()+"')";


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

	                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
	        				cin.setText("");
	        				nom.setText("");
	        				prenom.setText("");
	        				date_naissance.setText("");
	        				gender.setSelectedItem(gender.getItemAt(0));
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
		ajouter.setBounds(360, 288, 98, 23);
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
		retourner.setBounds(500, 288, 98, 23);
		getContentPane().add(retourner);
		

		
	}

}
