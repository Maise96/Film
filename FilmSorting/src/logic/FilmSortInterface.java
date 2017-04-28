package logic;

import java.util.List;

import domain.DomainClass;

public interface FilmSortInterface {
	public List<DomainClass> sogFilmListe(DomainClass soeg);
	public DomainClass tilfojFilm(DomainClass domain);
}
