import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Wyszukiwarka wyszukiwarka = new Wyszukiwarka();
	Konto loggedUser = new Konto();
	Baza baza = new Baza();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Menu frame = new Menu(args[0]);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Menu(String login) {
		loggedUser = baza.daneKonta(login);
		System.out.println("zalogowano jako " + loggedUser.imie + " " + loggedUser.nazwisko);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new java.awt.Color(95, 221, 167));
		
		JButton btnNewButton = new JButton("Konto");
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wyloguj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				dispose(); 
				Frame1 menu = new Frame1();
				menu.frame.setVisible(true);	
			}
		});
		btnNewButton_1.setBounds(97, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(234, 199, 403, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Wyszukaj kasetę");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(335, 141, 203, 47);
		contentPane.add(lblNewLabel);
		
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		btnWyszukaj.setBounds(398, 562, 89, 23);
		contentPane.add(btnWyszukaj);
		btnWyszukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Kaseta>results = wyszukiwarka.Wyszukaj(textField.getText(), 1);
				for (Kaseta kaseta : results) {
					System.out.println(kaseta.tytul);
				}
			}
		});

	}

}
