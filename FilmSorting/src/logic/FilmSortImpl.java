package logic;

import java.util.List;

import data.ChangeFilmData;
import data.InsertDataFilm;
import data.SearchData;
import domain.DomainClassFilm;

public class FilmSortImpl implements FilmSortInterface {
	private SearchData sd = new SearchData();
	private InsertDataFilm tf = new InsertDataFilm();
	private ChangeFilmData rf = new ChangeFilmData();

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
	public DomainClassFilm redigerFilm(DomainClassFilm domainClassFilm){
		rf.redigerEnFilm(domainClassFilm);
		return domainClassFilm;
	}
}
