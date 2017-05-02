package logic;

import java.util.List;

import domain.DomainClassFilm;
import domain.DomainClassSeries;

public interface FilmSortInterface {
	public DomainClassFilm tilfojFilm(DomainClassFilm domain);
	List<DomainClassSeries> sogSeriesListe(String soog);
	List<DomainClassFilm> sogFilmListe(String sogeord);
	DomainClassSeries tilfojEnSerie(DomainClassSeries domain);
}
