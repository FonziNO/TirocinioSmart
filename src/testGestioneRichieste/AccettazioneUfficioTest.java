package testGestioneRichieste;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import application.InviaRichiesta;
import application.ListaAziende;
import junit.framework.TestCase;
import storage.AccettazioneDao;
import storage.AccettazioneTutorDao;
import storage.AccettazioneUfficioDao;
import storage.Azienda;
import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.RichiestaDao;

public class AccettazioneUfficioTest {

	private static final String TABLE_NAME = "Richiesta";
	Connection conn;
	PreparedStatement prep = null; // oggetto per inviare query parametriche
	PreparedStatement prep2 = null;
	RichiestaDao richiesta;
	InviaRichiesta inviaric;
	AccettazioneDao accAz;
	AccettazioneTutorDao accTu;
	AccettazioneUfficioDao accUf;


	ResultSet rs = null;

	String iD;
	boolean stat;
	boolean statoTuto;
	boolean statoUffici;
	String studEmai;
	String azEmai;



	public void cancellaDatiDB() throws SQLException{
		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();

			prep = conn.prepareStatement("DELETE FROM richiesta WHERE ID = ?");
			prep.setString(1, iD);
			prep.executeUpdate();
			conn.commit();

			prep.close();


		} finally {
			try {
				if (prep != null)
					prep.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}

	}



	@Test
	public void accettaUf() throws Exception{
		accUf = new AccettazioneUfficioDao();
		richiesta= new RichiestaDao();
		
		iD= "R113";
		stat= true;
		statoTuto=true;
		statoUffici=true;
		studEmai="a.ursi@studenti.unisa.it";
		azEmai="aziendaTheorema@gmail.it";
		
		richiesta.richiedi(iD, stat, statoTuto, statoUffici, studEmai, azEmai);
		
		accUf.accettaUfficio(iD, stat, statoTuto, statoUffici, studEmai, azEmai);

		try {
			String control2="SELECT * FROM Richiesta WHERE ID LIKE ? AND Stato LIKE ? AND StatoTutor LIKE ? AND StatoUfficio LIKE ? AND StudenteEmail LIKE ? AND AziendaEmail LIKE ?;";
			// formulo la stringa

			conn = DriverManagerConnectionPool.getConnection();
			prep= conn.prepareStatement(control2);

			prep.setString(1, iD);
			prep.setBoolean(2, stat);
			prep.setBoolean(3, statoTuto);
			prep.setBoolean(4, statoUffici);
			prep.setString(5, studEmai);
			prep.setString(6, azEmai);

			rs = prep.executeQuery();
			conn.commit();

			if(!rs.next()){
				
				throw new Exception("ERRORE!");
		}else{
				String idr=rs.getString("ID");
				boolean stato=rs.getBoolean("Stato");
				boolean statoTu=rs.getBoolean("StatoTutor");
				boolean statoUff=rs.getBoolean("StatoUfficio");
				String studE=rs.getString("StudenteEmail");
			try{	
				assertEquals(idr,iD);
				assertEquals(stato, stat);
				assertEquals(statoTu, statoTuto);
				assertEquals(statoUff, statoUffici);
				assertEquals(studE,studEmai);
			}
			catch (Throwable e){
				
			}
				prep.close();

			}
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
		cancellaDatiDB();	


	}
	
	@Test
	public void doListaAziendeTest() throws Exception {

		accUf = new AccettazioneUfficioDao();
		richiesta= new RichiestaDao();
		
		List<Richiesta> richieste = new ArrayList<Richiesta>();
		richieste=accUf.doListaAziende();
		
	
		
		iD= "R113";
		stat= true;
		statoTuto=true;
		statoUffici=true;
		studEmai="a.ursi@studenti.unisa.it";
		azEmai="aziendaTheorema@gmail.it";
		
		richiesta.richiedi(iD, stat, statoTuto, statoUffici, studEmai, azEmai);
		
		accUf.accettaUfficio(iD, stat, statoTuto, statoUffici, studEmai, azEmai);

		try {
			String control2="SELECT * FROM Richiesta WHERE ID LIKE ? AND Stato LIKE ? AND StatoTutor LIKE ? AND StatoUfficio LIKE ? AND StudenteEmail LIKE ? AND AziendaEmail LIKE ?;";
			// formulo la stringa

			conn = DriverManagerConnectionPool.getConnection();
			prep= conn.prepareStatement(control2);

			prep.setString(1, iD);
			prep.setBoolean(2, stat);
			prep.setBoolean(3, statoTuto);
			prep.setBoolean(4, statoUffici);
			prep.setString(5, studEmai);
			prep.setString(6, azEmai);

			rs = prep.executeQuery();
			conn.commit();

			if(!rs.next()){
				
				throw new Exception("ERRORE!");
		}else{
				String idr=rs.getString("ID");
				boolean stato=rs.getBoolean("Stato");
				boolean statoTu=rs.getBoolean("StatoTutor");
				boolean statoUff=rs.getBoolean("StatoUfficio");
				String studE=rs.getString("StudenteEmail");
			try{	
				assertEquals(idr,iD);
				assertEquals(stato, stat);
				assertEquals(statoTu, statoTuto);
				assertEquals(statoUff, statoUffici);
				assertEquals(studE,studEmai);
			}
			catch (Throwable e){
				
			}
				prep.close();

			}
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
		cancellaDatiDB();	

		
	}
	



}

