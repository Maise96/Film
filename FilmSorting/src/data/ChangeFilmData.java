package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassFilm;

public class ChangeFilmData {
	public DomainClassFilm redigerEnFilm(DomainClassFilm domain) {
		try (DataAccess access = new DataAccess()) {
			try {
				redigerFilm(access, domain);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return domain;
	}

	public DomainClassFilm redigerFilm(DataAccess dataAccess, DomainClassFilm domainClassFilm) {
		try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
				"UPDATE film SET (navn, name, aarstal, audio, sub, note) = (?, ?, ?, ?, ?, ?) WHERE ref = ?")) {
			statement.setString(1, domainClassFilm.getNavn());
			statement.setString(2, domainClassFilm.getName());
			statement.setString(3, domainClassFilm.getAarstal());
			statement.setString(4, domainClassFilm.getAudio());
			statement.setString(5, domainClassFilm.getSub());
			statement.setString(6, domainClassFilm.getNote());
			statement.setInt(7, domainClassFilm.getRef());
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Noget gik galt RuntimeException", e);
		}
		return domainClassFilm;
	}
}
