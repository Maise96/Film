package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassFilm;

public class InsertFilmData {

	public DomainClassFilm opretEnFilm(DomainClassFilm domain) {
		try (DataAccess access = new DataAccess()) {
			try {
				opretEnFilm(access, domain);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return domain;
	}

	public DomainClassFilm opretEnFilm(DataAccess dataAccess, DomainClassFilm domainClassFilm) {
		try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
				"INSERT INTO film (navnf, namef, audiof, subf, yearf, blurayf, burned, kids, animation, danish, horror, notef) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			statement.setString(1, domainClassFilm.getNavnf());
			statement.setString(2, domainClassFilm.getNamef());
			statement.setString(3, domainClassFilm.getAudiof());
			statement.setString(4, domainClassFilm.getSubf());
			statement.setString(5, domainClassFilm.getYearf());
			statement.setBoolean(6, domainClassFilm.isBlurayf());
			statement.setBoolean(7, domainClassFilm.isBurned());
			statement.setBoolean(8, domainClassFilm.isKids());
			statement.setBoolean(9, domainClassFilm.isAnimation());
			statement.setBoolean(10, domainClassFilm.isDanish());
			statement.setBoolean(11, domainClassFilm.isHorror());
			statement.setString(12, domainClassFilm.getNotef());
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Noget gik galt ved oprettelse af filmdatalaget", e);
		}
		return domainClassFilm;
	}
}
