package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassSeries;

public class DeleteSeriesData {

	public DomainClassSeries sletSerie(DomainClassSeries domain) {
		try (DataAccess access = new DataAccess()) {
			try {
				deleteSerie(access, domain);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return domain;
	}

	public DomainClassSeries deleteSerie(DataAccess data, DomainClassSeries domain) {
		try (PreparedStatement statement = data.getConnection().prepareStatement("DELETE FROM serie WHERE refs = ?;")) {
			statement.setInt(1, domain.getRefs());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Noget gik galt RuntimeException SQL", e);
		}
		return domain;
	}

}
