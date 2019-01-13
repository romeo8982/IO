import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;
public class Kaseta {

	private static final AtomicInteger count = new AtomicInteger(0); 
	
	int id;
	String tytul;
	String opis;
	Date dataWydania;
	String rezyser;
	List<String> obsada;
	int liczbaEgzemplarzy;
	int liczbaWypozyczonych;
	int liczbaDostepnych;
	
	Kaseta(){
		id = count.incrementAndGet();
	}

}