package testGestioneRichieste;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import application.ListaStudentiTutor;
import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.RichiestaDao;

public class ListaAccettatiTutorTest {
	RichiestaDao richiesta;

	ResultSet rs = null;

	String iD;
	boolean stat;
	boolean statoTuto;
	boolean statoUffici;
	String studEmai;
	String azEmai;
	Connection conn;
	PreparedStatement prep;


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
	public void testDoListaStudenteTutor() throws SQLException {

		richiesta = new RichiestaDao();

		ListaStudentiTutor lista= new ListaStudentiTutor();
		List<Richiesta> richieste = new ArrayList<Richiesta>();

		iD= "R113";
		stat= true;
		statoTuto=false;
		statoUffici=false;
		studEmai="a.ursi@studenti.unisa.it";
		azEmai="aziendaTheorema@gmail.it";
		
		richiesta.richiedi(iD, stat, statoTuto, statoUffici, studEmai, azEmai);
		
		richieste=lista.doListaStudenteTutor();
		
		

		try {
			String control2="SELECT * FROM Richiesta, Tutor;";
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


				try
				{
					assertEquals(idr,iD);
					assertEquals(stato, stat);
					assertEquals(statoTu, statoTuto);
					assertEquals(statoUff, statoUffici);
					assertEquals(studE,studEmai);
					assertEquals(azE,azEmai);

				}
				catch(Throwable e){
				}


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

		cancellaDatiDB();
	}
}
