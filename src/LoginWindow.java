import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;

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
public class LoginWindow {

	public JFrame frame;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
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
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginWindow()  {
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
		
		JLabel lblBanner = new JLabel("Wypo\u017Cyczalnia Kaset");
		lblBanner.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblBanner.setBounds(144, 11, 292, 33);
		frame.getContentPane().add(lblBanner);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(177, 99, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("has\u0142o:");
		lblPassword.setBounds(177, 124, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(233, 96, 173, 20);
		frame.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(233, 121, 173, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblWrongCredentials = new JLabel("Nieprawid\u0142owe Has\u0142o lub Login");
		lblWrongCredentials.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWrongCredentials.setForeground(Color.RED);
		lblWrongCredentials.setBounds(210, 186, 226, 23);
		lblWrongCredentials.setVisible(false);
		frame.getContentPane().add(lblWrongCredentials);
				
		JButton btnNewButton = new JButton("Zaloguj");
		btnNewButton.setBounds(243, 152, 89, 23);
		frame.getContentPane().add(btnNewButton);	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(logowanie.Logowanie(textFieldLogin.getText(), textFieldPassword.getText(), baza.listaKont))
				{
				frame.dispose();
				LoggedInMenu menu = new LoggedInMenu(textFieldLogin.getText());
				menu.setVisible(true);
				}
				lblWrongCredentials.setVisible(true);
			}
		});
	}
}