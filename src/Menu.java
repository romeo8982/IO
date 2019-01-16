import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JList<Kaseta> list;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private static String[] resultList;
	Wyszukiwarka wyszukiwarka = new Wyszukiwarka();
	Konto loggedUser = new Konto();
	Wypozyczenie lend;
	Baza baza = new Baza();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
	Date date = new Date();

	/**
	 * Launch the application.
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
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent arg0) {
				
				List<Kaseta>results = wyszukiwarka.Wyszukaj(textField.getText(), 1);
				
				for (Kaseta kaseta : results) {
					listModel.addElement(kaseta.tytul);
					 System.out.println(kaseta.tytul);
				}
				System.out.println("-----------------");
				JList list_1 = new JList(listModel);
				list_1.setBounds(234, 246, 403, 273);
				list_1.setVisible(true);
				
				list_1.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
					if (! e.getValueIsAdjusting())
					{
					lend = new Wypozyczenie();
					lend.dataWypozyczenia=date;
					Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(Calendar.MONTH, 1);
					lend.dataZwrotu=c.getTime();
					lend.idKonta=loggedUser.id;
					
					Kaseta[] arrayResults = new Kaseta[results.size()];
					arrayResults = results.toArray(arrayResults);					
					lend.idTytulu=arrayResults[list_1.getSelectedIndex()].id;
					lend.przedluzano=false;
					loggedUser.iloscWypozyczen+=1;
					
					//baza.listaWypozyczen.add(lend);
					System.out.println(lend.id);
					System.out.println(lend.idKonta);
					System.out.println(lend.idTytulu);
					System.out.println(lend.dataWypozyczenia);
					System.out.println(lend.dataZwrotu);
					System.out.println(lend.przedluzano);
					}
					}
				});
				
				contentPane.add(list_1);					
				repaint();
			}
		});				
	}

	public static String[] getResultList() {
		return resultList;
	}

	public static void setResultList(String[] resultList) {
		Menu.resultList = resultList;
	}
}
