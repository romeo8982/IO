import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
public class Wypozyczenie {


	private static final AtomicInteger count = new AtomicInteger(0); 
	private int id;
	private int idKonta;
	private int idTytulu;
	private Date dataWypozyczenia;
	private Date dataZwrotu;
	private boolean przedluzano;
	
	Wypozyczenie(){
		id = count.incrementAndGet();
	}

}