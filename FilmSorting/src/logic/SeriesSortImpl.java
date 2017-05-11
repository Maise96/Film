package logic;

import java.util.List;

import data.InsertDataSeries;
import data.SearchSData;
import domain.DomainClassSeries;

public class SeriesSortImpl implements SeriesSortInterface{
	private SearchSData ssd = new SearchSData();
	private InsertDataSeries ts = new InsertDataSeries();
	
	@Override
	public List<DomainClassSeries> sogSeriesListe(String soog) {
		return ssd.sogSeriesListe(soog);
	}
	
	@Override
	public DomainClassSeries tilfojEnSerie(DomainClassSeries domain){
		ts.tilfojEnSerie(domain);
		return domain;
	}
}
