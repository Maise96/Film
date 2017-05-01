package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClass;

public class SearchSData {
	public List<DomainClass> sogSeriesListe( DomainClass soog) {
		List<DomainClass> list = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/film", "SA", "");
				PreparedStatement statement = connection.prepareStatement(
				"SELECT * FROM serie WHERE upper(navn) LIKE ? OR upper(name) LIKE ?");) {

			statement.setString(1, "%" + soog.getNavn().toUpperCase() + "%");
			statement.setString(2, "%" + soog.getName().toUpperCase() + "%");

			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClass sog = new DomainClass();
					sog.setRefs(resultset.getInt("refs"));
					sog.setNavns(resultset.getString("navn"));
					sog.setNames(resultset.getString("name"));
					sog.setSeason(resultset.getString("season"));
					sog.setAarstals(resultset.getString("aarstal"));
					list.add(sog);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

}
