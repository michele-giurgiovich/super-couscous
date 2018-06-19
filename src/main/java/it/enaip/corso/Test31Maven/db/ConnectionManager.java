package it.enaip.corso.Test31Maven.db;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** Classe per creare connessione.
 * Viene costruita inoltrando il file con le propriet� del database.
 * Ha un solo metodo che restituisce la connessione utilizzando le propriet�. */
class ConnectionManager {
	
	private final String DB_CLASS = "db.drivername";
	private final String DB_USER = "db.username";
	private final String DB_PSW = "db.password";
	private final String DB_URL = "db.url";
	
	private Properties dbprop;
	
	/** Costruttore che richiede il nome del file con le propriet�
	 * del database con cui inizializza il suo campo
	 * @param  inputStream */
	public ConnectionManager(InputStream inputStream) {
		dbprop = new Properties();
		try {
			dbprop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*public ConnectionManager(String filePath) {
		init(filePath);
	}*/
	
	/** Metodo, richiamato dal costruttore che inizializza il campo
	 * Properties dbprop con le propriet� contenute nel file
	 * @param  file */
	/*private void init(String filePath) {
		dbprop = new Properties();
		
		try {
			FileInputStream in = new FileInputStream(filePath);
			dbprop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	/** Metodo da richiamare per creare la connessione al database.
	 * Usa le propriet� estratte memorizzate in dbprop */
	public Connection getConnection() {
		Connection conn = null;
		String className = dbprop.getProperty(DB_CLASS);
		String user = dbprop.getProperty(DB_USER);
		String psw = dbprop.getProperty(DB_PSW);
		String url = dbprop.getProperty(DB_URL);
		
	    try {
	        Class.forName(className);

	        conn = DriverManager.getConnection(url, user, psw);

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

		return conn;
	}

}
