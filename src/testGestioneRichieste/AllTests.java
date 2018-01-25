package testGestioneRichieste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({InviaRichiestaTest.class, AccettazioneRichiestaTest.class,  AccettazioneTutorTest.class, ListaAccettatiUfficioTest.class, AccettazioneUfficioTest.class,
		 ListaRichiesteTest.class, RifiutaRichiestaTest.class })
public class AllTests {

}
