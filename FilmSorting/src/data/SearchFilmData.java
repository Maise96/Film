package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassFilm;

public class SearchFilmData {

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

	public List<DomainClassFilm> sogFilmListe(DataAccess dataAccess, List<DomainClassFilm> list, String sogeord) {

		try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
				"SELECT * FROM film WHERE upper(navn) LIKE ? OR upper(name) LIKE ?")) {

			statement.setString(1, "%" + sogeord.toUpperCase() + "%");
			statement.setString(2, "%" + sogeord.toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClassFilm sog = new DomainClassFilm();
					sog.setRef(resultset.getInt("ref"));
					sog.setNavn(resultset.getString("navn"));
					sog.setName(resultset.getString("name"));
					sog.setAarstal(resultset.getString("aarstal"));
					sog.setAudio(resultset.getString("audio"));
					sog.setSub(resultset.getString("sub"));
					sog.setNote(resultset.getString("note"));
					list.add(sog);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}