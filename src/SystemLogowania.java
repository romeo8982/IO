import java.util.List;
public class SystemLogowania {

	/**
	 * 
	 * @param listaKont
	 * @param login
	 * @param haslo
	 */	
		public boolean Logowanie(String login,String haslo, List<Klient> lista)
		{
			boolean udaneLogowanie=false;
			for(Konto konto : lista)
			{
				if((login.equals(konto.login))&&(haslo.equals(konto.haslo)))
				{				
					udaneLogowanie=true;
				}
			}
				return udaneLogowanie;
		}
	 
}