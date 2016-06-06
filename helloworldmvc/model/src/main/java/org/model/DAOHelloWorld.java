package org.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOHelloWorld {
	protected static String LOGIN = "root";
	protected static String PASSWORD = "";
	protected static String URL = "jdbc:mysql://localhost/javapetri?autoReconnect=true&useSSL=false";

	public static String getLOGIN() {
		return LOGIN;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

	public static String getURL() {
		return URL;
	}

	public static void setLOGIN(final String lOGIN) {
		LOGIN = lOGIN;
	}

	public static void setPASSWORD(final String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public static void setURL(final String uRL) {
		URL = uRL;
	}

	protected Connection connection;

	protected String INSTANCE;

	protected java.sql.Statement statement;

	public DAOHelloWorld() {
		this.connection = null;
		this.statement = null;
	}

	protected void close() {

	}

	protected ResultSet executeQuery(final String query) throws SQLException {
		return this.statement.executeQuery(query);
	}

	public Connection getConnection() {
		return this.connection;
	}

	public DAOHelloWorld getInstance() {
		return null;
	}

	public String getINSTANCE() {
		return this.INSTANCE;
	}

	public String getQuerySelectFirstHelloWorld() {
		return "SELECT Nom FROM helloworld WHERE ";
	}

	public java.sql.Statement getStatement() {
		return this.statement;
	}

	protected boolean open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(DAOHelloWorld.URL, DAOHelloWorld.LOGIN,
					DAOHelloWorld.PASSWORD);
			this.statement = this.connection.createStatement();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();

			return false;

		} catch (final SQLException e) {

			e.printStackTrace();

			return false;
		}
		return true;
	}

	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	public void setINSTANCE(final String iNSTANCE) {
		this.INSTANCE = iNSTANCE;
	}

	public void setStatement(final java.sql.Statement statement) {
		this.statement = statement;
	}
}
