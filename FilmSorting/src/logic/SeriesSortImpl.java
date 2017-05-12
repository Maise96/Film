package logic;

import java.util.List;

import data.ChangeSeriesData;
import data.InsertDataSeries;
import data.SearchSeriesData;
import domain.DomainClassSeries;

public class SeriesSortImpl implements SeriesSortInterface{
	private SearchSeriesData ssd = new SearchSeriesData();
	private InsertDataSeries ts = new InsertDataSeries();
	private ChangeSeriesData rs = new ChangeSeriesData();
	
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
	public DomainClassSeries redigerSerie(DomainClassSeries domain){
		rs.redigerSerie(domain);
		return domain;
	}
}
