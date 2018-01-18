package application;

import java.sql.SQLException;
import java.util.ArrayList;

import storage.AccettazioneTutorDao;
import storage.Tutor;

public class Prova {
	public static void main(String args[]) throws SQLException{
		
		AccettazioneTutorDao accettazione = new AccettazioneTutorDao();
		ArrayList<Tutor> lista= new ArrayList<Tutor>();
		lista=accettazione.doListaTutor();
		for(int i=0; i<lista.size(); i++){
			System.out.println(lista.get(i).getEmailT());
		}
		
	}

}
