import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.io.InputStreamReader;
public class Frame1 {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	public Baza baza = new Baza();
	public Klient klient;
	public Kaseta kaseta;
	private SystemLogowania logowanie = new SystemLogowania();

	/**
	 * Launch the application.
	 */
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frame1()  {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	
	private void initialize() {
				
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new java.awt.Color(95, 221, 167));
		
		JLabel lblNewLabel = new JLabel("Wypo\u017Cyczalnia Kaset");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(144, 11, 292, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(177, 99, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("has\u0142o:");
		lblNewLabel_2.setBounds(177, 124, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(233, 96, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 121, 173, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nieprawid\u0142owe Has\u0142o lub Login");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(210, 186, 226, 23);
		lblNewLabel_3.setVisible(false);
		frame.getContentPane().add(lblNewLabel_3);
				
		JButton btnNewButton = new JButton("Zaloguj");
		btnNewButton.setBounds(243, 152, 89, 23);
		frame.getContentPane().add(btnNewButton);	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(logowanie.Logowanie(textField.getText(), textField_1.getText(), baza.listaKont))
				{
				frame.dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
				}
				lblNewLabel_3.setVisible(true);
			}
		});
	}
}