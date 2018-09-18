package logic;

import java.util.List;

import data.SearchSeriesData;
import domain.DomainClassSeries;

public class SeriesSortImpl implements SeriesSortInterface {
	private SearchSeriesData ssd = new SearchSeriesData();
	
	@Override
	public List<DomainClassSeries> sogSerieListdata(String sogSerieListdata) {
		return ssd.sogSerieListData(sogSerieListdata);
	}
}
