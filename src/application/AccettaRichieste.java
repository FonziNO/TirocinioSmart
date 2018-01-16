package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;


import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.Studente;

public class AccettaRichieste {
	public synchronized ArrayList<Richiesta> doListaRichieste (String sessione) throws SQLException{
		Connection conn = null;
		PreparedStatement s = null;
	
		List<Richiesta> listaR = new ArrayList<Richiesta>();
		
	}
	
	

}
