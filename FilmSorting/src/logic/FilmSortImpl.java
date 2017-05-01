package logic;

import java.util.List;

import data.InsertDataFilm;
import data.SearchData;
import data.SearchSData;
import domain.DomainClassFilm;
import domain.DomainClassSeries;

public class FilmSortImpl implements FilmSortInterface {
	private SearchData sd = new SearchData();
	private InsertDataFilm tf = new InsertDataFilm();
	private SearchSData ssd = new SearchSData();

	@Override
	public List<DomainClassFilm> sogFilmListe(String sogeord) {
		return sd.sogFilmListe(sogeord);
	}

	@Override
	public DomainClassFilm tilfojFilm(DomainClassFilm domain) {
		tf.opretEnFilm(domain);
			return domain;
	}
	
	@Override
	public List<DomainClassSeries> sogSeriesListe(String soog) {
		return ssd.sogSeriesListe(soog);
	}
}
