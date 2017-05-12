package logic;

import java.util.List;

import domain.DomainClassFilm;

public interface FilmSortInterface {
	public DomainClassFilm tilfojFilm(DomainClassFilm domain);
	List<DomainClassFilm> sogFilmListe(String sogeord);
	DomainClassFilm redigerFilm(DomainClassFilm domainClassFilm);
}
