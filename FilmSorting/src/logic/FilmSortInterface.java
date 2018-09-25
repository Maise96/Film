package logic;

import java.util.List;
import domain.DomainClassFilm;

public interface FilmSortInterface {
	List<DomainClassFilm> sogFilmListdata(String sogFilmListdata);
	public DomainClassFilm opretEnFilm(DomainClassFilm domain);
}
