package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storage.DriverManagerConnectionPool;
import storage.Richiesta;
import storage.Studente;
import storage.StudenteTutor;
import storage.Tutor;

public class ListaStudentiTutor {
	
	public synchronized ArrayList<StudenteTutor> doListaStudenteTutor() throws SQLException {
		Connection conn = null;
		PreparedStatement s = null;
		List<StudenteTutor> lista = new ArrayList<StudenteTutor>();
		
		String query = "SELECT Studente.Email, Tutor.AziendaEmail, Richiesta.AziendaEmail FROM Richiesta, Studente, Tutor WHERE Richiesta.AziendaEmail = Tutor.AziendaEmail AND Richiesta.StudenteEmail = Studente.Email AND Richiesta.Stato = true;";
		
		conn = DriverManagerConnectionPool.getConnection();
		s = conn.prepareStatement(query);
		
		ResultSet risultato = s.executeQuery();
		conn.commit();
		
		try{
			while (risultato.next()) {
				Richiesta richiesta = new Richiesta();
				
				richiesta.setIdR(risultato.getString("ID"));
				richiesta.setStatoR(risultato.getString("Stato"));
				richiesta.setEmailS(risultato.getString("StudenteEmail"));
				richiesta.setEmailA(risultato.getString("AziendaEmail"));
				
				richiesta.setNomeS(risultato.getString("Nome"));
				richiesta.setCognomeS(risultato.getString("Cognome"));
				richiesta.setMatricolaS(risultato.getString("Matricola"));
				
				Studente studente = new Studente();
				
				studente.setEmailS(risultato.getString("Email"));
				studente.setNomeS(risultato.getString("Nome"));
				studente.setCognomeS(risultato.getString("Cognome"));
				studente.setMatricolaS(risultato.getString("Matricola"));

				Tutor tutor = new Tutor();
				
				
				lista.add(richiesta);
				
		}
	}
}
