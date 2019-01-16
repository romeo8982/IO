import java.util.ArrayList;
import java.util.List;

public class Wyszukiwarka {
	
	Baza baza = new Baza();

	/**
	 * Zwraca list? znalezionych w systemie element�w na podstawie danych wyszukiwania.
	 * @param tekst
	 * @param parametrWyszukiwania Okre?la typ listy poszukiwanych element�w
	 */
	
	public <T> List<T> Wyszukaj(String tekst, int parametrWyszukiwania) {

		List searchResults = null;
		switch (parametrWyszukiwania)
		{
			case 0:
			{
				searchResults = new ArrayList<Konto>();
				for(Konto konto : baza.listaKont){
					if(konto.nazwisko.toUpperCase().contains(tekst.toUpperCase())||konto.imie.toUpperCase().contains(tekst.toUpperCase()))
					{
						searchResults.add(konto);
					}
				}
				break;
			}
			
			case 1:
			{
				searchResults = new ArrayList<Kaseta>() {
				};
				for(Kaseta kaseta : baza.listaTytulow){
					if(kaseta.tytul.toUpperCase().contains(tekst.toUpperCase()))
					{
						searchResults.add(kaseta);
					}
				}
				break;
			}
			
		}
		return searchResults;
	}

}