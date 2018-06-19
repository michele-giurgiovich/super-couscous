package it.enaip.corso.Test31Maven.db;

import java.io.InputStream;
import java.sql.Connection;

public class ConnectionFactory {
	
	private static ConnectionManager conMan;
	
	static {
		InputStream cls = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
		conMan = new ConnectionManager(cls);
	}

	public static Connection getNewConnection() {
		return conMan.getConnection();
	}

}
