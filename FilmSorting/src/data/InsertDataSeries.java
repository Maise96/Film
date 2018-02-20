package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassSeries;

public class InsertDataSeries {
	public DomainClassSeries tilfojEnSerie(DomainClassSeries domain) {
		try (DataAccess access = new DataAccess()) {
			try {
				tilfojEnSerie(access, domain);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return domain;
	}

	public DomainClassSeries tilfojEnSerie(DataAccess dataAccess, DomainClassSeries domainClassSerie) {
		try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
				"INSERT INTO serie (navn, name, season, aarstal, audio, sub, note) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
			statement.setString(1, domainClassSerie.getNavn());
			statement.setString(2, domainClassSerie.getName());
			statement.setInt(3, domainClassSerie.getSeason());
			statement.setString(4, domainClassSerie.getAarstal());
			statement.setString(5, domainClassSerie.getAudio());
			statement.setString(6, domainClassSerie.getSub());
			statement.setString(7, domainClassSerie.getNote());
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Noget gik galt InsertSerieData", e);
		}
		return domainClassSerie;
	}

}
