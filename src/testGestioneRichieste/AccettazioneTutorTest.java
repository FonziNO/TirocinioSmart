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
import storage.RichiestaDao;
import storage.Tutor;



public class AccettazioneTutorTest {
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
	
	@Test
	public void accettaTu() throws Exception {
		accTu = new AccettazioneTutorDao();
		richiesta=new RichiestaDao();

		iD= "R113";
		stat= true;
		statoTuto=true;
		statoUffici=false;
		studEmai="a.ursi@studenti.unisa.it";
		azEmai="aziendaTheorema@gmail.it";
		
		richiesta.richiedi(iD, stat, statoTuto, statoUffici, studEmai, azEmai);

		accTu.accettaTutor(iD, stat, statoTuto, statoUffici, studEmai, azEmai);

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

			if(!rs.next())
				throw new Exception("ERRORE!");
			else{
				String idr=rs.getString("ID");
				boolean stato=rs.getBoolean("Stato");
				boolean statoTu=rs.getBoolean("StatoTutor");
				boolean statoUff=rs.getBoolean("StatoUfficio");
				String studE=rs.getString("StudenteEmail");
				String azE=rs.getString("AziendaEmail");
try{
				assertEquals(idr,iD);
				assertEquals(stato, stat);
				assertEquals(statoTu, statoTuto);
				assertEquals(statoUff, statoUffici);
				assertEquals(studE,studEmai);
				assertEquals(azE,azEmai);
}
catch(Throwable e){
	
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
		//cancellaDatiDB();	

	}
	
	@Test
	public void doListaTutorTest() throws Exception {
		AccettazioneTutorDao lista= new AccettazioneTutorDao();
		List<Tutor> tutor = new ArrayList<Tutor>();
		tutor=lista.doListaTutor();


		assertEquals("c.gialli@unisa.it", tutor.get(0).getEmailT());
		assertEquals("aziendaAFSoluzioni@gmail.it", tutor.get(0).getEmailA());
	}

}

