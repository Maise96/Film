package logic;

import java.util.List;

import data.InsertDataFilm;
import data.InsertDataSeries;
import data.SearchData;
import data.SearchSData;
import data.ShowFilmData;
import domain.DomainClassFilm;
import domain.DomainClassSeries;

public class FilmSortImpl implements FilmSortInterface {
	private SearchData sd = new SearchData();
	private InsertDataFilm tf = new InsertDataFilm();
	private SearchSData ssd = new SearchSData();
	private InsertDataSeries ts = new InsertDataSeries();
	private ShowFilmData sfd = new ShowFilmData();

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
	
	@Override
	public DomainClassSeries tilfojEnSerie(DomainClassSeries domain){
		ts.tilfojEnSerie(domain);
		return domain;
	}
	@Override
	public int visFilmAntal(){
		int antalFilm = sfd.visFilmAntal();
		return antalFilm;
	}
}
