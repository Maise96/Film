package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClassFilm;

public class InsertDataFilm {
	
	public DomainClassFilm opretEnFilm (DomainClassFilm domain){
		try (DataAccess access = new DataAccess()){
			try {
				opretEnFilm(access, domain);
				access.commit();
			} catch (Exception e){
				access.rollback();
				throw e;
			}
		} 
		return domain;
	}

	public DomainClassFilm opretEnFilm(DataAccess dataAccess, DomainClassFilm domainClassFilm) {
		try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
				"INSERT INTO film (navn, name, aarstal, audio, sub) VALUES (?, ?, ?, ?, ?)")){
			statement.setString(1, domainClassFilm.getNavn());
			statement.setString(2, domainClassFilm.getName());
			statement.setString(3, domainClassFilm.getAarstal());
			statement.setString(4, domainClassFilm.getAudio());
			statement.setString(5, domainClassFilm.getSub());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt: " + antal + " Film tilføjet");
			
		}catch (SQLException e){
			throw new RuntimeException("Noget gik galt RuntimeException", e);
		}
		return domainClassFilm;
	}
}
