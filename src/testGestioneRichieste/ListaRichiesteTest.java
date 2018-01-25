package testGestioneRichieste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import application.ListaAziende;
import application.ListaRichieste;
import storage.Azienda;
import storage.Richiesta;

public class ListaRichiesteTest {
	
	@Test
	public void testDoListaRichieste() throws SQLException {

		ListaRichieste lista= new ListaRichieste();
		List<Richiesta> richieste = new ArrayList<Richiesta>();
		richieste=lista.doListaRichieste();

		//l'azienda azienda1 non esiste nel database
		//verifichiamo che non sia presente nella lista
		for(int i=0; i<richieste.size(); i++){

			assertNotEquals("richiesta1", richieste.get(i).getIdR());
		}
		
		//l'azienda AF Soluzioni esiste nel database
		//verifichiamo che sia presente nella lista

		assertEquals("R112", richieste.get(0).getIdR());

	}

	
}
