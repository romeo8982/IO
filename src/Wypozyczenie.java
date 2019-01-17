import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
public class Wypozyczenie {


	private static final AtomicInteger count = new AtomicInteger(0); 
	int id;
	int idKonta;
	int idTytulu;
	Date dataWypozyczenia;
	Date dataZwrotu;
	boolean przedluzano;
	
	Wypozyczenie(){
		id = count.incrementAndGet();
	}

}