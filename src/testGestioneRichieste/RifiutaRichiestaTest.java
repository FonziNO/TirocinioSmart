package testGestioneRichieste;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import application.InviaRichiesta;
import junit.framework.TestCase;
import storage.AccettazioneDao;
import storage.AccettazioneTutorDao;
import storage.AccettazioneUfficioDao;
import storage.DriverManagerConnectionPool;
import storage.RichiestaDao;
import storage.RifiutoRichiestaDao;

public class RifiutaRichiestaTest {
	private static final String TABLE_NAME = "Richiesta";
	Connection conn;
	PreparedStatement prep = null; // oggetto per inviare query parametriche
	PreparedStatement prep2 = null;
	RichiestaDao richiesta;
	RifiutoRichiestaDao rifAz;
	
	


	ResultSet rs = null;

	String iD;
	boolean stat;
	boolean statoTuto;
	boolean statoUffici;
	String studEmai;
	String azEmai;

	@Test
	public void rifiutaTest() throws Exception{
		
		rifAz = new RifiutoRichiestaDao();
		richiesta = new RichiestaDao();

		iD= "R113";
		stat= false;
		statoTuto=false;
		statoUffici=false;
		studEmai="a.ursi@studenti.unisa.it";
		azEmai="aziendaMicroambiente@gmail.it";

		rifAz.rifiuta(iD, stat, statoTuto, statoUffici, studEmai, azEmai);

		try {
			String control2="SELECT * FROM Richiesta;";
			// formulo la stringa

			conn = DriverManagerConnectionPool.getConnection();
			prep= conn.prepareStatement(control2);


			rs = prep.executeQuery();
			conn.commit();

			while(rs.next())
//				throw new Exception("ERRORE!");
//			else{
			{
				String idr=rs.getString("ID");
				boolean stato=rs.getBoolean("Stato");
				boolean statoTu=rs.getBoolean("StatoTutor");
				boolean statoUff=rs.getBoolean("StatoUfficio");
				String studE=rs.getString("StudenteEmail");
				String azE=rs.getString("AziendaEmail");
				
				assertEquals(idr, iD);


			}
			prep.close();
		}

		finally {
			try {
				if (prep != null) {
					prep.close();

				}
				//if (prep2 != null) {
				//	prep2.close();
				//}
			} 


			finally {
				if (prep != null) {
					prep.close();
				}
				//if (prep2 != null) {
				//prep2.close();
				//}

			}

		}

	}



}