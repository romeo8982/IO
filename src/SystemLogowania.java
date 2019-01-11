import java.util.List;
public class SystemLogowania {

	/**
	 * 
	 * @param listaKont
	 * @param login
	 * @param haslo
	 */
	public Klient Logowanie(List<Klient> listaKont, String login, String haslo) {
		Klient klient = new Klient();
		Wyszukiwarka wyszukiwarka = new Wyszukiwarka();
		
		//if(wyszukiwarka.Wyszukaj(haslo, 0).isEmpty())
		//{
			//return klient=null;
		//}
		//else
		//{
			//return wyszukiwarka.Wyszukaj(haslo, 0).get(0);
		//}
		return klient;
		
	}

}