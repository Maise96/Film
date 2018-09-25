package logic;

import java.util.List;

import data.InsertFilmData;
import data.SearchFilmData;
import domain.DomainClassFilm;

public class FilmSortImpl implements FilmSortInterface {
	private SearchFilmData sfd = new SearchFilmData();
	private InsertFilmData ifd = new InsertFilmData();

	@Override
	public List<DomainClassFilm> sogFilmListdata(String sogFilmListdata) {
		return sfd.sogFilmListData(sogFilmListdata);
	}

	@Override
	public DomainClassFilm opretEnFilm (DomainClassFilm domain) {
		return ifd.opretEnFilm(domain);
		
	}
}