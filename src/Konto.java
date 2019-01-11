import java.util.concurrent.atomic.AtomicInteger;

public class Konto {

	private static final AtomicInteger count = new AtomicInteger(0); 
	public int id;
	public String imie;
	public String nazwisko;
	public String email;
	public int iloscWypozyczen;
	public int iloscZarezerwowanych;
	public String login;
	public String haslo;
	public float saldo;
	public boolean zablokowaneKonto;
	
	public Konto() {
		id = count.incrementAndGet();
	}

}