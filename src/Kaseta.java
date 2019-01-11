import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.ZoneId;
public class Kaseta {

	private static final AtomicInteger count = new AtomicInteger(0); 
	private int id;
	private String tytul;
	private String opis;
	private ZoneId dataWydania;
	private String rezyser;
	private List<String> obsada;
	private int liczbaEgzemplarzy;
	private int liczbaWypozyczonych;
	private int liczbaDostepnych;
	
	Kaseta(){
		id = count.incrementAndGet();
	}

}