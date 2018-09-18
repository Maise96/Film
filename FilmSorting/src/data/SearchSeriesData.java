package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassSeries;

public class SearchSeriesData {

	public List<DomainClassSeries> sogSerieListData(String sogSerieListData) {
		List<DomainClassSeries> serieList = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogSerieListdata(access, serieList, sogSerieListData);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return serieList;
	}

	public List<DomainClassSeries> sogSerieListdata(DataAccess dataAccess, List<DomainClassSeries> serieList,
			String sogSerieListdata) {
		try (PreparedStatement statement = dataAccess.getConnection()
				.prepareStatement("SELECT * FROM serie WHERE upper(navns) LIKE ? OR upper(names) LIKE ?");) {

			statement.setString(1, "%" + sogSerieListdata.toUpperCase() + "%");
			statement.setString(2, "%" + sogSerieListdata.toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClassSeries sogSerie = new DomainClassSeries();
					sogSerie.setRefs(resultset.getInt("refs"));
					sogSerie.setNavns(resultset.getString("navns"));
					sogSerie.setNames(resultset.getString("names"));
					sogSerie.setCs(resultset.getInt("cs"));
					sogSerie.setSeason(resultset.getInt("season"));
					sogSerie.setNumber(resultset.getInt("number"));
					sogSerie.setEpisode(resultset.getInt("episode"));
					sogSerie.setVolume(resultset.getInt("volume"));
					sogSerie.setBlurays(resultset.getBoolean("blurays"));
					sogSerie.setAudios(resultset.getString("audios"));
					sogSerie.setSubs(resultset.getString("subs"));
					sogSerie.setYears(resultset.getString("years"));
					sogSerie.setNotes(resultset.getString("notes"));
					serieList.add(sogSerie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serieList;
	}
}