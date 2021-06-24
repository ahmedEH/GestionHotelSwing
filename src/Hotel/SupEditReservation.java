package Hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupEditReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupEditReservation frame = new SupEditReservation();
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
	public SupEditReservation() {
		setBackground(new Color(255, 175, 175));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 1058,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(22, 115, 221, 39);
		contentPane.add(textField);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Andalus", Font.BOLD, 18));
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(253, 115, 111, 39);
		contentPane.add(btnNewButton_2);
		
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
		btnNewButton_1.setFont(new Font("Andalus", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setBounds(154, 236, 122, 39);
		contentPane.add(btnNewButton_1);
	}

}
