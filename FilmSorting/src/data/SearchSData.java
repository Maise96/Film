package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClassSeries;

public class SearchSData {

	public List<DomainClassSeries> sogSeriesListe(String soog) {
		List<DomainClassSeries> list = new ArrayList<>();
		try (DataAccess access = new DataAccess()) {
			try {
				sogSeriesListe(access, list, soog);
				access.commit();
			} catch (Exception e) {
				access.rollback();
				throw e;
			}
		}
		return list;
	}

	public List<DomainClassSeries> sogSeriesListe(DataAccess dataAccess, List<DomainClassSeries> list, String soog) {
		try (PreparedStatement statement = dataAccess.getConnection()
				.prepareStatement("SELECT * FROM serie WHERE upper(navn) LIKE ? OR upper(name) LIKE ?");) {

			statement.setString(1, "%" + soog.toUpperCase() + "%");
			statement.setString(2, "%" + soog.toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClassSeries sog = new DomainClassSeries();
					sog.setRefs(resultset.getInt("refs"));
					sog.setNavn(resultset.getString("navn"));
					sog.setName(resultset.getString("name"));
					sog.setSeason(resultset.getString("season"));
					sog.setAarstal(resultset.getString("aarstal"));
					list.add(sog);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}