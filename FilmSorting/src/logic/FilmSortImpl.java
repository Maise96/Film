package logic;

import java.util.List;

import data.InsertData;
import data.SearchData;
import domain.DomainClass;

public class FilmSortImpl implements FilmSortInterface {
	private SearchData sd = new SearchData();
	private InsertData tf = new InsertData();

	@Override
	public List<DomainClass> sogFilmListe(DomainClass soeg) {
		return sd.sogFilmListe(soeg);
	}

	@Override
	public DomainClass tilfojFilm(DomainClass domain) {
		tf.opretEnFilm(domain);
			return domain;
	}
}
