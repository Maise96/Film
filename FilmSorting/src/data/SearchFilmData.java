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

		try (PreparedStatement statement = dataAccess.getConnection()
				.prepareStatement("SELECT * FROM film WHERE upper(navn) LIKE ? OR upper(name) LIKE ?")) {

			statement.setString(1, "%" + sogeord.toUpperCase() + "%");
			statement.setString(2, "%" + sogeord.toUpperCase() + "%");

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
					list.add(sogFilm);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}