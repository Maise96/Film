package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassFilm;

public class SearchFilmData {

	public List<DomainClassFilm> sogFilmListData(String sogFilmListData) {
		List<DomainClassFilm> filmList = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogFilmListdata(access, filmList, sogFilmListData);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return filmList;
	}

	public List<DomainClassFilm> sogFilmListdata(DataAccess dataAccess, List<DomainClassFilm> filmList,
			String sogFilmListdata) {

		try (PreparedStatement statement = dataAccess.getConnection()
				.prepareStatement("SELECT * FROM film WHERE upper(navnf) LIKE ? OR upper(namef) LIKE ?")) {

			statement.setString(1, "%" + sogFilmListdata.toUpperCase() + "%");
			statement.setString(2, "%" + sogFilmListdata.toUpperCase() + "%");

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
					sogFilm.setKids(resultset.getBoolean("kids"));
					sogFilm.setAnimation(resultset.getBoolean("animation"));
					sogFilm.setDanish(resultset.getBoolean("danish"));
					sogFilm.setHorror(resultset.getBoolean("horror"));
					sogFilm.setNotef(resultset.getString("notef"));
					filmList.add(sogFilm);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}
}