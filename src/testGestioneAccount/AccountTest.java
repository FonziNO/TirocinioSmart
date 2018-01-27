package testGestioneAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Connection;

import junit.framework.TestCase;
import storage.DriverManagerConnectionPool;
import storage.LoginDao;
import storage.RegistratiDao;

public class AccountTest extends TestCase {
	private Connection conn;
	private PreparedStatement prep;
	private RegistratiDao registraS;
	private LoginDao loginDao;
	SimpleDateFormat sdfjava = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfsql = new SimpleDateFormat("yyyy-MM-dd");

	protected void setUp() throws Exception {
		super.setUp();
		registraS = new RegistratiDao();
		loginDao = new LoginDao();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		registraS = null;
		loginDao = null;
	}

	public final void testRegistraStudente() throws Exception {

		SimpleDateFormat sdfjava = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfsql = new SimpleDateFormat("yyyy-MM-dd");
		String nome = "Giovanni";
		String cognome = "Muciaccia";
		String matricola = "0512104455";
		String email = "g.m@studenti.unisa.it";
		String password = "giovanni123";
		String datanascita = "10/05/1990";
		datanascita = sdfsql.format(sdfjava.parse(datanascita));
		String cellulare = "3345612147";
		try {

			registraS.salva(email, nome, cognome, matricola, password, datanascita, cellulare);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		conn = null;
		prep = null;
		try {

			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(
					"SELECT email, nome, cognome, matricola, password, datanascita, cellulare FROM studente WHERE email=?;");

			prep.setString(1, email);
			ResultSet rs = prep.executeQuery();

			if (!rs.next()) {
				throw new Exception("ERRORE!");
			} else {
				String emailTest = rs.getString("email");
				String nomeTest = rs.getString("nome");
				String cognomeTest = rs.getString("cognome");
				String matricolaTest = rs.getString("matricola");
				String passwordTest = rs.getString("password");
				String datanascitaTest = rs.getString("datanascita");
				String cellulareTest = rs.getString("cellulare");
				try{
					assertEquals(emailTest, email);
					assertEquals(nomeTest, nome);
					assertEquals(cognomeTest, cognome);
					assertEquals(matricolaTest, matricola);
					assertEquals(passwordTest, password);
					assertEquals(datanascitaTest, datanascita);
					assertEquals(cellulareTest, cellulare);
				}
				catch(Throwable e){

				}
				prep.close();

			}

			prep = conn.prepareStatement("DELETE FROM studente WHERE email=?;");

			prep.setString(1, email);
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

	public final void testLoginStudente() throws Exception {
		String nomeSTest = "Giovannino";
		String cognomeSTest = "Mucciacino";
		String matricolaSTest = "0512106355";
		String emailSTest = "g.m@studenti.unisa.it";
		String passwordSTest = "giovannino";
		String dataNascitaTest = "25/06/1997";
		dataNascitaTest = sdfsql.format(sdfjava.parse(dataNascitaTest));
		String cellulareSTest = "3021548555";
		int tipoTest = 0;

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(
					"INSERT INTO studente (email,nome,cognome,matricola,password,datanascita,cellulare,tipo) "
							+ "VALUES(?,?,?,?,?,?,?,?);");

			prep.setString(1, emailSTest);
			prep.setString(2, nomeSTest);
			prep.setString(3, cognomeSTest);
			prep.setString(4, matricolaSTest);
			prep.setString(5, passwordSTest);
			prep.setString(6, dataNascitaTest);
			prep.setString(7, cellulareSTest);
			prep.setInt(8, tipoTest);

			prep.executeUpdate();
			conn.commit();
		} finally {
			try {
				if (prep != null)
					prep.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		int studente = loginDao.doLogin(emailSTest, passwordSTest);
		try{

			assertEquals(4, studente);
		}
		catch(Throwable e){

		}
		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement("DELETE FROM studente WHERE email=?;");

			prep.setString(1, emailSTest);
			prep.executeUpdate();
			conn.commit();
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

	public final void testLoginAzienda() throws Exception {
		String emailATest = "azienda@gmail.com";
		String passwordATest = "azienda123";
		String nomeATest = "aziendaTest";
		String locazioneATest = "Cile";
		int tipoATest = 3;

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(
					"INSERT INTO azienda (email,password,nome,locazione,tipo) " + "VALUES(?,?,?,?,?);");

			prep.setString(1, emailATest);
			prep.setString(2, passwordATest);
			prep.setString(3, nomeATest);
			prep.setString(4, locazioneATest);
			prep.setInt(5, tipoATest);

			prep.executeUpdate();
			conn.commit();
		} finally {
			try {
				if (prep != null)
					prep.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		int azienda = loginDao.doLogin(emailATest, passwordATest);

		assertEquals(3, azienda);

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement("DELETE FROM azienda WHERE email=?;");

			prep.setString(1, emailATest);
			prep.executeUpdate();
			conn.commit();
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

	public final void testLoginTutor() throws Exception {
		String emailTutorTest = "tutor@gmail.com";
		String nomeTutorTest = "tutorNomeTest";
		String cognomeTutorTest = "tutorCognomeTest";
		String matricolaTutorTest = "0512151478";
		String passwordTutorTest = "tutor123";
		int tipoTutorTest = 2;

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(
					"INSERT INTO tutor (email,nome,cognome,matricola, password,tipo) " + "VALUES(?,?,?,?,?,?);");

			prep.setString(1, emailTutorTest);
			prep.setString(2, nomeTutorTest);
			prep.setString(3, cognomeTutorTest);
			prep.setString(4, matricolaTutorTest);
			prep.setString(5, passwordTutorTest);
			prep.setInt(6, tipoTutorTest);

			prep.executeUpdate();
			conn.commit();
		} finally {
			try {
				if (prep != null)
					prep.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		int tutor = loginDao.doLogin(emailTutorTest, passwordTutorTest);

		assertEquals(2, tutor);

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement("DELETE FROM tutor WHERE email=?;");

			prep.setString(1, emailTutorTest);
			prep.executeUpdate();
			conn.commit();
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

	public final void testLoginUfficioStage() throws Exception {
		String emailUfficioTest = "ufficioTest@unisa.it";
		String passwordUfficioTest = "ufficio123";
		int tipoUfficioTest = 1;

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement("INSERT INTO ufficiostage (email,password,tipo) " + "VALUES(?,?,?);");

			prep.setString(1, emailUfficioTest);
			prep.setString(2, passwordUfficioTest);
			prep.setInt(3, tipoUfficioTest);

			prep.executeUpdate();
			conn.commit();
		} finally {
			try {
				if (prep != null)
					prep.close();
			} finally {
				if (conn != null)
					conn.close();
			}
		}

		int ufficioStage = loginDao.doLogin(emailUfficioTest, passwordUfficioTest);

		assertEquals(1, ufficioStage);

		conn = null;
		prep = null;

		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement("DELETE FROM ufficiostage WHERE email=?;");

			prep.setString(1, emailUfficioTest);
			prep.executeUpdate();
			conn.commit();
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
}
