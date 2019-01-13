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
			for(int i=0;i<lista.size();i++)
			{
				if((login.equals(lista.get(i).login))&&(haslo.equals(lista.get(i).haslo)))
				{				
					udaneLogowanie=true;
				}
			}
				return udaneLogowanie;
		}
	 
}