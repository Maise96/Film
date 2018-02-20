package logic;

import java.util.List;

import domain.DomainClassSeries;

public interface SeriesSortInterface {
	List<DomainClassSeries> sogSeriesListe(String soog);

	DomainClassSeries tilfojEnSerie(DomainClassSeries domain);

	DomainClassSeries redigerSerie(DomainClassSeries domain);
}
