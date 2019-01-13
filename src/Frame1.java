import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
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
	private Wyszukiwarka wyszukiwarka = new Wyszukiwarka();
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
		try {
			KlientInit();
			MovieInit();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void KlientInit() throws FileNotFoundException, IOException
	{	
		try (BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("Klienci.txt"), "UTF-8"))) {
		    String line;
		    while((line = br.readLine()) != null){	  
		    	   klient = new Klient();
			       klient.id=Integer.parseInt(line);
			    if ((line = br.readLine()) != null) {
				       klient.imie=line;
				    }
			    if ((line = br.readLine()) != null) {
				       klient.nazwisko=line;
				    }
			    if ((line = br.readLine()) != null) {
				       klient.email=line;
				    }
			    if ((line = br.readLine()) != null) {
				       klient.iloscWypozyczen=Integer.parseInt(line);
				    }
			    if ((line = br.readLine()) != null) {
				       klient.iloscZarezerwowanych=Integer.parseInt(line);
				    }
			    if ((line = br.readLine()) != null) {
				       klient.login=line;
				    }
			    if ((line = br.readLine()) != null) {
				       klient.haslo=line;
				    }
			    if ((line = br.readLine()) != null) {
				       klient.saldo=Integer.parseInt(line);
				    }
			    if ((line = br.readLine()) != null) {
				       klient.zablokowaneKonto=Boolean.parseBoolean(line);
				    }
			    baza.listaKont.add(klient);
		    }
		    br.close();
		}
	}
	private void MovieInit() throws FileNotFoundException, IOException, ParseException
	{	
		try (BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("Kasety.txt"), "UTF-8"))) {
		    String line;
		    while((line = br.readLine()) != null){
		    	   kaseta = new Kaseta();
			       kaseta.id=Integer.parseInt(line);
			    if ((line = br.readLine()) != null) {
				       kaseta.tytul=line;
				    }
			    if ((line = br.readLine()) != null) {
				       kaseta.opis=line;
				    }
			    if ((line = br.readLine()) != null) {
			    	DateFormat formatter;
			    	formatter = new SimpleDateFormat("dd-MM-yy");
				       kaseta.dataWydania=formatter.parse(line);
				    }
			    if ((line = br.readLine()) != null) {
				       kaseta.rezyser=line;
				    }
			    if ((line = br.readLine()) != null) {
				       kaseta.obsada=(Arrays.asList(line.split(",")));
				    }
			    if ((line = br.readLine()) != null) {
				       kaseta.liczbaEgzemplarzy=Integer.parseInt(line);
				    }
			    if ((line = br.readLine()) != null) {
				       kaseta.liczbaWypozyczonych=Integer.parseInt(line);
				    }
			    if ((line = br.readLine()) != null) {
				       kaseta.liczbaDostepnych=Integer.parseInt(line);
				    }			   
			    baza.listaTytulow.add(kaseta);
		    }
		    br.close();
		}
	}
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
