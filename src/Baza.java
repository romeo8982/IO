import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Baza {

	public List<Klient> listaKont = new ArrayList<Klient>();
	public List<Rezerwacja> listaRezerwacji = new ArrayList<Rezerwacja>();
	public List<Wypozyczenie> listaWypozyczen = new ArrayList<Wypozyczenie>();
	public List<Kaseta> listaTytulow = new ArrayList<Kaseta>();

	Kaseta kaseta = new Kaseta();
	Klient klient = new Klient();
	
	Konto daneKonta (String login) {
		Konto dane = new Konto();
		for(Konto konto : listaKont) {
			if(konto.login.equals(login))
				dane = konto;
		}
		return dane;
	}
	
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
			    if ((line = br.readLine()) != null) {
				       klient.wlascicielKonta=Integer.parseInt(line);
				    }
			    listaKont.add(klient);
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
			    listaTytulow.add(kaseta);
		    }
		    br.close();
		}
	}
	
	Baza(){
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
	}
}