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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class LoggedInMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSearch;
	private JList<Kaseta> list;
	private DefaultListModel<String> listModel1 = new DefaultListModel<String>();
	private DefaultListModel<String> listModel2 = new DefaultListModel<String>();
	private DefaultListModel<String> listModelAccount = new DefaultListModel<String>();
	private static String[] resultList;
	Wyszukiwarka wyszukiwarka = new Wyszukiwarka();
	Konto loggedUser = new Konto();
	Wypozyczenie lend = new Wypozyczenie();
	Rezerwacja booking;
	public Baza baza = new Baza();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
	Date date = new Date();
	boolean idPicked = false;
	int idLender = 0;
	int accCounter = 0;

	/**
	 * Launch the application.
	 */
	public LoggedInMenu(String login) {
		loggedUser = baza.daneKonta(login);
		System.out.println("zalogowano jako " + loggedUser.imie + " " + loggedUser.nazwisko);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new java.awt.Color(95, 221, 167));
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList listAccount = new JList(listModelAccount);

		listModelAccount.addElement("Imie: " +loggedUser.imie);
		listModelAccount.addElement("Nazwisko: " +loggedUser.nazwisko);
		listModelAccount.addElement("Email: " +loggedUser.email);
		listModelAccount.addElement("Saldo: " + String.valueOf(loggedUser.saldo));
		
		contentPane.add(listAccount);
		listAccount.setVisible(false);
		
		listAccount.setBounds(234, 32, 403, 80);
		JButton btnAccount = new JButton("Konto");
		btnAccount.setBounds(10, 11, 89, 23);
		contentPane.add(btnAccount);
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(accCounter%2==0)
				listAccount.setVisible(true);
				else
					listAccount.setVisible(false);
				
				accCounter++;
			}
		});
		JButton btnLogout = new JButton("Wyloguj");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logOut();
			}
		});
		btnLogout.setBounds(97, 11, 89, 23);
		contentPane.add(btnLogout);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(234, 199, 403, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		
		JLabel lblSearch = new JLabel("Wyszukaj kasetÄ™");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSearch.setBounds(335, 141, 203, 47);
		contentPane.add(lblSearch);
		if(loggedUser.wlascicielKonta==1) {
			lblSearch.setText("Wyszukaj klienta");
		}
		
		
		JButton btnSearch = new JButton("Wyszukaj");
		btnSearch.setBounds(398, 562, 89, 23);
		contentPane.add(btnSearch);
		
	
		btnSearch.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent arg0) {
				if(loggedUser.wlascicielKonta==0)
				{
				List<Kaseta>results = wyszukiwarka.Wyszukaj(textFieldSearch.getText(), 1);
				
				for (Kaseta kaseta : results) {
					listModel1.addElement(kaseta.tytul);
					 System.out.println(kaseta.tytul);
				}
				System.out.println("-----------------");
				JList list_1 = new JList(listModel1);
				list_1.setBounds(234, 246, 403, 273);
				list_1.setVisible(true);
				list_1.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (! e.getValueIsAdjusting())
						{																																				
								Kaseta[] arrayResults = new Kaseta[results.size()];
								arrayResults = results.toArray(arrayResults);																								
								reservation(arrayResults[list_1.getSelectedIndex()].id);																														
								JOptionPane.showMessageDialog(null, "Pomyślnie zarezerwowano kasetę!", "", JOptionPane.INFORMATION_MESSAGE);							
						}
				}});
				contentPane.add(list_1);					
				repaint();
				}
				else if(loggedUser.wlascicielKonta==1)
				{
					if(idPicked==false)
					{
					List<Konto>results = wyszukiwarka.Wyszukaj(textFieldSearch.getText(), 0);
					
					for (Konto konto : results) {
						listModel2.addElement(konto.imie+" "+konto.nazwisko);
						 System.out.println(konto.imie+" "+konto.nazwisko);
					}
					System.out.println("-----------------");
					JList listResults = new JList(listModel2);
					listResults.setBounds(234, 246, 403, 273);
					listResults.setVisible(true);
							
					listResults.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							if (! e.getValueIsAdjusting())
							{								
								Klient[] arrayResults = new Klient[results.size()];
								arrayResults = results.toArray(arrayResults);	
								idLender = (arrayResults[listResults.getSelectedIndex()].id);
								idPicked = true;
								listResults.setVisible(false);

								lblSearch.setText("Wyszukaj kasetę");
							}
					}});					
					contentPane.add(listResults);					
					repaint();

					}
					else
					{
						List<Kaseta>results = wyszukiwarka.Wyszukaj(textFieldSearch.getText(), 1);
						
						for (Kaseta kaseta : results) {
							listModel1.addElement(kaseta.tytul);
							 System.out.println(kaseta.tytul);
						}
						JList list_1 = new JList(listModel1);
						list_1.setBounds(234, 246, 403, 273);
						list_1.setVisible(true);
								
						list_1.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								if (! e.getValueIsAdjusting())
								{																									
									Kaseta[] arrayResults = new Kaseta[results.size()];
									arrayResults = results.toArray(arrayResults);	
									lendFiller(arrayResults[list_1.getSelectedIndex()].id);
									JOptionPane.showMessageDialog(null, "Pomyślnie wypożyczono kasetę!", "", JOptionPane.INFORMATION_MESSAGE);
								}
						}});					
						contentPane.add(list_1);					
						repaint();
					}
				}
			}
		});				
	}

	
	public void reservation(int idTitle)
	{
		booking = new Rezerwacja();
		booking.idKonta=loggedUser.id;
		booking.idTytulu=idTitle;
		loggedUser.iloscZarezerwowanych+=1;
		
		baza.listaKont.set(loggedUser.id-1, (Klient) loggedUser);
		
		System.out.println("-----------------");
		System.out.println("id rezerwacji: " + booking.id);
		System.out.println("id konta: " + booking.idKonta);
		System.out.println("id tytulu: " + booking.idTytulu);
		System.out.println(baza.listaKont.get(loggedUser.id-1).iloscZarezerwowanych);
	}
	
	
	private void logOut()
	{
		contentPane.setVisible(false);
		dispose(); 
		LoginWindow menu = new LoginWindow();
		menu.frame.setVisible(true);	
	}

	private void lendFiller(int idTitle)
	{
		Wypozyczenie lend = new Wypozyczenie();
		lend.dataWypozyczenia=date;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		lend.idKonta = idLender;
		lend.dataZwrotu=c.getTime();
		lend.idTytulu=idTitle;
		lend.przedluzano=false;
		
		loggedUser.iloscWypozyczen+=1;
		System.out.println("-----------------");
		System.out.println("id Wypozyczenia: "+lend.id);
		System.out.println("id Konta: "+lend.idKonta);
		System.out.println("id tytul: "+lend.idTytulu);
		System.out.println("data wypozyczenia: "+ lend.dataWypozyczenia);
		System.out.println("data zwrotu: "+lend.dataZwrotu);
		System.out.println("czy przdluzano: "+lend.przedluzano);
	}

	public static String[] getResultList() {
		return resultList;
	}

	public static void setResultList(String[] resultList) {
		LoggedInMenu.resultList = resultList;
	}
}
