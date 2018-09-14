package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassFilm;
import domain.DomainClassSeries;

public class SearchFilmSeriesData {

	public List<DomainClassFilm> sogFilmListe(String sogeord) {
		List<DomainClassFilm> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogFilmListe(access, list, sogeord);
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
				.prepareStatement("SELECT * FROM film WHERE upper(navn) LIKE ? OR upper(name) LIKE ?")) {

			statement.setString(1, "%" + sogeordFilm.toUpperCase() + "%");
			statement.setString(2, "%" + sogeordFilm.toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClassFilm sogFilm = new DomainClassFilm();
					sogFilm.setRef(resultset.getInt("ref"));
					sogFilm.setNavn(resultset.getString("navn"));
					sogFilm.setName(resultset.getString("name"));
					sogFilm.setAarstal(resultset.getString("aarstal"));
					sogFilm.setAudio(resultset.getString("audio"));
					sogFilm.setSub(resultset.getString("sub"));
					sogFilm.setNote(resultset.getString("note"));
					sogFilm.setBurned(resultset.getBoolean("burned"));
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
				.prepareStatement("SELECT * FROM serie WHERE upper(navn) LIKE ? OR upper(name) LIKE ?")) {

			statement.setString(1, "%" + sogeordSerie.toUpperCase() + "%");
			statement.setString(2, "%" + sogeordSerie.toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {
				while (resultset.next()) {
					DomainClassSeries sogSerie = new DomainClassSeries();
					sogSerie.setRefs(resultset.getInt("refs"));
					sogSerie.setNavn(resultset.getString("navn"));
					sogSerie.setName(resultset.getString("name"));
					sogSerie.setSeason(resultset.getInt("season"));
					sogSerie.setAarstal(resultset.getString("aarstal"));
					sogSerie.setAudio(resultset.getString("audio"));
					sogSerie.setSub(resultset.getString("sub"));
					sogSerie.setNote(resultset.getString("note"));
					listSerie.add(sogSerie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSerie;
	}
}
