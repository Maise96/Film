package logic;

import java.util.List;

import data.InsertData;
import data.SearchData;
import data.SearchSData;
import domain.DomainClass;

public class FilmSortImpl implements FilmSortInterface {
	private SearchData sd = new SearchData();
	private InsertData tf = new InsertData();
	private SearchSData ssd = new SearchSData();

	@Override
	public List<DomainClass> sogFilmListe(DomainClass soeg) {
		return sd.sogFilmListe(soeg);
	}

	@Override
	public DomainClass tilfojFilm(DomainClass domain) {
		tf.opretEnFilm(domain);
			return domain;
	}
	
	@Override
	public List<DomainClass> sogSeriesListe(DomainClass soog) {
		return ssd.sogSeriesListe(soog);
	}
}
