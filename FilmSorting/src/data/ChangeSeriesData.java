package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassSeries;

public class ChangeSeriesData {

	public DomainClassSeries redigerSerie(DomainClassSeries domain) {
			try (DataAccess access = new DataAccess()) {
				try {
					redigerSerie(access, domain);
					access.commit();
				} catch (Exception e) {
					access.rollback();
					throw e;
				}
			}
			return domain;
		}

		public DomainClassSeries redigerSerie(DataAccess dataAccess, DomainClassSeries domain) {
			try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
					"UPDATE serie SET (navn, name, season, aarstal, audio, sub, note) = (?, ?, ?, ?, ?, ?, ?) WHERE refs = ?")) {
				statement.setString(1, domain.getNavn());
				statement.setString(2, domain.getName());
				statement.setInt(3, domain.getSeason());
				statement.setString(4, domain.getAarstal());
				statement.setString(5, domain.getAudio());
				statement.setString(6, domain.getSub());
				statement.setString(7, domain.getNote());
				statement.setInt(8, domain.getRefs());
				statement.execute();

			} catch (SQLException e) {
				throw new RuntimeException("Noget gik galt RuntimeException ChangeSerie Klassen", e);
			}
			return domain;
	}
}
