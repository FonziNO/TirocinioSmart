package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * la classe DriverManagerConnectionPool permette la connessione al database
 */
public class DriverManagerConnectionPool
{

	private static List<Connection> freeDbConnections; // connessioni libere

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
	/**
	 * metodo che crea la connessione al database tirociniosmart
	 * @return connessione al database
	 * @throws SQLException
	 */
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection conn = null;
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tirociniosmart", "admin", "admin");

		conn.setAutoCommit(false);
		return conn;

	}
	/**
	 * metodo che restituisce la connessione
	 * @return connessione
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}
	
	/**
	 * Metodo che rilascia la connessione
	 * @param connection - connessione
	 * @throws SQLException
	 */
	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}
}