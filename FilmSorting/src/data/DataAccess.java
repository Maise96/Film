package data;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess implements Closeable {

	private Connection connection;

	public DataAccess() {
		try {
			this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/film", "SA", "");
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(" Connection kunne ikke blive oprettet ", e);
		}
	}

	public void commit() {
		try {
			this.connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException(" Exception caught i commit ", e);
		}
	}

	public void rollback() {
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			throw new RuntimeException(" Exception caught ved rollback ", e);
		}
	}

	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(" Exception caught ved close ", e);
		}
	}

	public Connection getConnection() {
		return this.connection;
	}
}