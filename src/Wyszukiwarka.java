import java.util.ArrayList;
import java.util.List;
public class Wyszukiwarka {

	/**
	 * Zwraca list? znalezionych w systemie elementów na podstawie danych wyszukiwania.
	 * @param tekst
	 * @param parametrWyszukiwania Okre?la typ listy poszukiwanych elementów
	 */
	public boolean Wyszukaj(String login,String haslo, List<Klient> lista)
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
	
	public <T> List<T> Wyszukaj(String tekst, int parametrWyszukiwania, List<T> list) {
	//	Konto konto = new Konto();
		//List<T> list = new ArrayList<>();
		switch (parametrWyszukiwania)
		{
			case 0:
			{
				//for(Konto konto : list){
					//if(konto==tekst)
					//{
						//return list;
					//}
				//}
			}
			
		}
		return list;
	}

}