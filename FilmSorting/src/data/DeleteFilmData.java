package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassFilm;

public class DeleteFilmData {

	public DomainClassFilm sletFilm(DomainClassFilm domain) {
		try (DataAccess access = new DataAccess()) {
			try {
				sletFilm(access, domain);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return domain;
	}

	public DomainClassFilm sletFilm(DataAccess data, DomainClassFilm domain) {
		try (PreparedStatement statement = data.getConnection().prepareStatement("DELETE FROM film WHERE ref = ?;")) {
			statement.setInt(1, domain.getRef());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Noget gik galt RuntimeException", e);
		}
		return domain;
	}
}