import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	Baza baza = new Baza();
	Klient konto = new Klient();
	Wyszukiwarka wyszukiwarka = new Wyszukiwarka();

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

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		konto.id=1;
		konto.email="kamil@gmail.com";
		konto.iloscWypozyczen=0;
		konto.iloscZarezerwowanych=0;
		konto.login="12345";
		konto.haslo="54321";
		konto.imie="Kamil";
		konto.nazwisko="Kowalski";
		konto.saldo=0;
		konto.zablokowaneKonto=false;
		
		baza.listaKont.add(konto);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new java.awt.Color(95, 221, 167));
		
		JLabel lblNewLabel = new JLabel("Wypo\u017Cyczelnia Kaset");
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
				
				if(wyszukiwarka.Wyszukaj(textField.getText(), textField_1.getText(), baza.listaKont))
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
