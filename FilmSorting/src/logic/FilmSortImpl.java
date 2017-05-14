package logic;

import java.util.List;

import data.ChangeFilmData;
import data.DeleteFilmData;
import data.InsertDataFilm;
import data.SearchFilmData;
import domain.DomainClassFilm;

public class FilmSortImpl implements FilmSortInterface {
	private SearchFilmData sd = new SearchFilmData();
	private InsertDataFilm tf = new InsertDataFilm();
	private ChangeFilmData rf = new ChangeFilmData();
	private DeleteFilmData df = new DeleteFilmData();

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
	@Override
	public DomainClassFilm sletFilm(DomainClassFilm domain){
		df.sletFilm(domain);
		return domain;
	}
}
