package testGestioneAziende;

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
import storage.AccettazioneDao;
import storage.AccettazioneTutorDao;
import storage.AccettazioneUfficioDao;
import storage.Azienda;
import storage.DriverManagerConnectionPool;
import storage.RichiestaDao;
import storage.RifiutoRichiestaDao;


public class AziendaTestErr {
	Connection conn;
	PreparedStatement prep = null; // oggetto per inviare query parametriche
	PreparedStatement prep2 = null;
	RichiestaDao richiesta;
	RifiutoRichiestaDao rifAz;
	
	ResultSet rs = null;
	
		
	@Test
		public void doListaAziendeErrore() throws SQLException{
			
			ListaAziende lista= new ListaAziende();
			List<Azienda> aziende = new ArrayList<Azienda>();
			aziende=lista.doListaAziende();
			
			for(int i=0; i<aziende.size(); i++){

				assertNotEquals("azienda1", aziende.get(i).getNomeA());
			}
			
		}
	}


