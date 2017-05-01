package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DomainClass;

public class SearchData {
	public List<DomainClass> sogFilmListe( DomainClass soeg) {
		List<DomainClass> list = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/film", "SA", "");
				PreparedStatement statement = connection.prepareStatement(
				"SELECT * FROM film WHERE upper(navn) LIKE ? OR upper(name) LIKE ? OR aarstal LIKE ?");) {

			statement.setString(1, "%" + soeg.getNavn().toUpperCase() + "%");
			statement.setString(2, "%" + soeg.getName().toUpperCase() + "%");
			statement.setString(3, "%" + soeg.getAarstal() + "%");

			System.out.println("forbi navn string");
			try (ResultSet resultset = statement.executeQuery();) {

				while (resultset.next()) {
					DomainClass sog = new DomainClass();
					sog.setRef(resultset.getInt("ref"));
					sog.setNavn(resultset.getString("navn"));
					sog.setName(resultset.getString("name"));
					sog.setAarstal(resultset.getString("aarstal"));
					sog.setAudio(resultset.getString("audio"));
					sog.setSub(resultset.getString("sub"));
					list.add(sog);
					System.out.println("igennem while");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Catch fanget" + e);
		} 
		return list;
	}
}