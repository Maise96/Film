package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassSeries;

public class SearchSeriesData {

	public List<DomainClassSeries> sogSeriesListe(String soog) {
		List<DomainClassSeries> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogSeriesListe(access, list, soog);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	public List<DomainClassSeries> sogSeriesListe(DataAccess dataAccess, List<DomainClassSeries> list, String soog) {
		try (PreparedStatement statement = dataAccess.getConnection()
				.prepareStatement("SELECT * FROM serie WHERE upper(navn) LIKE ? OR upper(name) LIKE ?");) {

			statement.setString(1, "%" + soog.toUpperCase() + "%");
			statement.setString(2, "%" + soog.toUpperCase() + "%");

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
					list.add(sogSerie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}