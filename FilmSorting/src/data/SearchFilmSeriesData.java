package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassFilm;
import domain.DomainClassSeries;

public class SearchFilmSeriesData {

	public List<DomainClassFilm> sogFilmListe(String sogeordfilm) {
		List<DomainClassFilm> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogFilmListe(access, list, sogeordfilm);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	public List<DomainClassSeries> sogSeriesListe(String sogeordserie) {
		List<DomainClassSeries> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogSerieListe(access, list, sogeordserie);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	public List<DomainClassFilm> sogFilmListe(DataAccess dataAccessFilm, List<DomainClassFilm> listFilm,
			String sogeordFilm) {

		try (PreparedStatement statement = dataAccessFilm.getConnection()
				.prepareStatement("SELECT * FROM film WHERE upper(navnf) LIKE ? OR upper(namef) LIKE ?")) {

			statement.setString(1, "%" + sogeordFilm.toUpperCase() + "%");
			statement.setString(2, "%" + sogeordFilm.toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClassFilm sogFilm = new DomainClassFilm();
					sogFilm.setReff(resultset.getInt("reff"));
					sogFilm.setNavnf(resultset.getString("navnf"));
					sogFilm.setNamef(resultset.getString("namef"));
					sogFilm.setAudiof(resultset.getString("audiof"));
					sogFilm.setSubf(resultset.getString("subf"));
					sogFilm.setBlurayf(resultset.getBoolean("blurayf"));
					sogFilm.setYearf(resultset.getString("yearf"));
					sogFilm.setBurned(resultset.getBoolean("burned"));
					sogFilm.setKids(resultset.getBoolean("kidsf"));
					sogFilm.setAnimation(resultset.getBoolean("animation"));
					sogFilm.setDanish(resultset.getBoolean("danish"));
					sogFilm.setHorror(resultset.getBoolean("horror"));
					sogFilm.setNotef(resultset.getString("notef"));
					listFilm.add(sogFilm);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFilm;
	}

	public List<DomainClassSeries> sogSerieListe(DataAccess dataAccessSerie, List<DomainClassSeries> listSerie,
			String sogeordSerie) {

		try (PreparedStatement statement = dataAccessSerie.getConnection()
				.prepareStatement("SELECT * FROM serie WHERE upper(navns) LIKE ? OR upper(names) LIKE ?")) {

			statement.setString(1, "%" + sogeordSerie.toUpperCase() + "%");
			statement.setString(2, "%" + sogeordSerie.toUpperCase() + "%");

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
					listSerie.add(sogSerie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSerie;
	}
}
