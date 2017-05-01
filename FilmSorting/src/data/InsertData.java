package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.DomainClass;

public class InsertData {
	public boolean tilfojFilm(DomainClass domain){
		return false;
	}
	
	public DomainClass opretEnFilm (DomainClass domain){
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

	public DomainClass opretEnFilm(DataAccess dataAccess, DomainClass domainClass) {
		try (PreparedStatement statement = dataAccess.getConnection().prepareStatement(
				"INSERT INTO film (navn, name, aarstal, audio, sub) VALUES (?, ?, ?, ?, ?)")){
			statement.setString(1, domainClass.getNavn());
			statement.setString(2, domainClass.getName());
			statement.setString(3, domainClass.getAarstal());
			statement.setString(4, domainClass.getAudio());
			statement.setString(5, domainClass.getSub());
			int antal = statement.executeUpdate();
			System.out.println("Antal rækker berørt: " + antal + " Film tilføjet");
			
		}catch (SQLException e){
			throw new RuntimeException("Noget gik galt RuntimeException", e);
		}
		return domainClass;
	}
}
