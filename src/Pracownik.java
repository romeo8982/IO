public class Pracownik extends Klient {

	/**
	 * Wyszukiwarka.wyszukaj(klient, parametrWyszukiwania = klient)
	 * Wy?wietl wyniki
	 * Wybierz klienta z listy
	 * Wyszukiwarka.wyszukaj(kaseta, parametrWyszukiwania=kaseta)
	 * Wy?wietl wyniki
	 * Wybierz kaset? z listy
	 * Potwierd? wybrane dane
	 * new Wypozyczenie(id=autonumber, idKonta = Klient.id, idTytyulu=Kaseta.id, dataWypozyczenia=DateTime(), dataZwrotu=DateTime()+X dni, przedluzano=false)
	 * listaWypozyczen.add(wypozyczenie)
	 * Kaseta.liczbaDostepnych--
	 * @param klient
	 * @param kaseta
	 */
	private Wypozyczenie DodajWypozyczenie(Klient klient, Kaseta kaseta) {
		// TODO - implement Pracownik.DodajWypozyczenie
		throw new UnsupportedOperationException();
	}

	/**
	 * Wyszukiwarka.wyszukaj(klient, parametrWyszukiwania = klient)
	 * Wy?wietl wyniki
	 * Wybierz klienta z listy
	 * Wyszukiwarka.wyszukaj(wypozyczenie, parametrWyszukiwania=wypozyczenie)
	 * Wy?wietl wyniki
	 * Wybierz wypozyczenie z listy
	 * 
	 * Edytuj wybrany rekord
	 * @param wypozyczenie
	 */
	private Wypozyczenie EdytujWypozyczenie(Wypozyczenie wypozyczenie) {
		// TODO - implement Pracownik.EdytujWypozyczenie
		throw new UnsupportedOperationException();
	}

	/**
	 * Wyszukiwarka.wyszukaj(wypozyczenie, parametrWyszukiwania=wypozyczenie)
	 * Wy?wietl wyniki
	 * Wybierz wypozyczenie z listy
	 * if(dataZwrotu < DateTime()){
	 *         Konto.saldo += X;
	 *         wystawienie wezwania do zaplaty (pracownik wystawia wezwanie do zaplaty fizycznie w bibliotece)
	 * }
	 * listaWypozyczen.remove(wypozyczenie)
	 * Wyszukiwarka.wyszukaj(wypozyczenie.idTytulu, parametrWyszukiwania=kaseta);kaseta.liczbaDostepnych++
	 * @param klient
	 */
	private void RegulujSaldo(Klient klient) {
		// TODO - implement Pracownik.RegulujSaldo
		throw new UnsupportedOperationException();
	}

	private Kaseta DodajKasete() {
		// TODO - implement Pracownik.DodajKasete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kaseta
	 */
	private Kaseta EdytujKasete(Kaseta kaseta) {
		// TODO - implement Pracownik.EdytujKasete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kaseta
	 */
	private void UsunKasete(Kaseta kaseta) {
		// TODO - implement Pracownik.UsunKasete
		throw new UnsupportedOperationException();
	}

	private Klient DodajKlienta() {
		// TODO - implement Pracownik.DodajKlienta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klient
	 */
	private Klient EdytujKlienta(Klient klient) {
		// TODO - implement Pracownik.EdytujKlienta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klient
	 */
	private void UsunKlienta(Klient klient) {
		// TODO - implement Pracownik.UsunKlienta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klient
	 */
	private void SprawdzDaneKlienta(Klient klient) {
		// TODO - implement Pracownik.SprawdzDaneKlienta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klient
	 */
	private Wypozyczenie[] SprawdzWypozyczeniaKlienta(Klient klient) {
		// TODO - implement Pracownik.SprawdzWypozyczeniaKlienta
		throw new UnsupportedOperationException();
	}

}