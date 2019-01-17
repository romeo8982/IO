import java.util.concurrent.atomic.AtomicInteger;

public class Rezerwacja {

	private static final AtomicInteger count = new AtomicInteger(0); 
	
	public int id;
	public int idTytulu;
	public int idKonta;

	Rezerwacja(){
		id = count.incrementAndGet();
	}
}