package Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import net.proteanit.sql.DbUtils;

public class AffichageRooms extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageRooms frame = new AffichageRooms();
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
	public AffichageRooms() {
		
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		Connection con;
		PreparedStatement stmt;
		ResultSet pstmt;
		table = new JTable();
		table.setEnabled(false);
		//table.setEditable(false);
		
		contentPane.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "ODI Rankings", TitledBorder.CENTER, TitledBorder.TOP));
		
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
			String query = "select * from room";
			stmt = con.prepareStatement(query);
			pstmt = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(pstmt));
			
		} catch (SQLException e1) {
			System.out.println("Connection Failed");
			e1.printStackTrace();
		}
	    
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			JScrollPane js = new JScrollPane();
			js.setBounds(479, 0, 563, 511);
			
			table.getTableHeader().setBackground(new Color(239,198,46));
			table.getTableHeader().setFont(new Font("Andulus", Font.BOLD, 12));
			contentPane.add(js);
			
			

			js.setViewportView(table);
			setContentPane(contentPane);
		    
		JLabel lblNewLabel = new JLabel("Affichage des chambres");
		lblNewLabel.setBounds(10, 66, 526, 80);
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD, 45));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 198, 221, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty() || !textField.getText().matches("^[a-zA-Z0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Error in Search key");
				}
				else {
					String v = "%"+ textField.getText()+"%";
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						System.out.println("Driver succes");
					} catch (ClassNotFoundException e1) {
						System.out.println("Driver Failed");
						e1.printStackTrace();
					}
					
						// Connection
					try {
						Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
						System.out.println("Connection succes");
						String query = "select * from room where ID like '"+v+"' OR Type like '"+v+"'  OR Surface like '"+v+"'";
						PreparedStatement stmt1 = con1.prepareStatement(query);
						ResultSet pstmt1 = stmt1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(pstmt1));
						
					} catch (SQLException e1) {
						System.out.println("Connection Failed");
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(284, 198, 111, 39);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setFont(new Font("Andalus", Font.BOLD, 18));
		btnNewButton.setBackground(SystemColor.textHighlight);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retourner");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 224));
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setFont(new Font("Andalus", Font.BOLD, 18));
		btnNewButton_1.setBounds(158, 403, 122, 39);
		contentPane.add(btnNewButton_1);
		

		//contentPane.add(table, BorderLayout.NORTH);
	
}
	}
