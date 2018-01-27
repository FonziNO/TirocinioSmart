package storage;
/**
 * un'azienda h auna email, una password, un nome e la locazione 
 */
public class Azienda {

	private String emailA;
	private String passwordA;
	private String nomeA;
	private String locazioneA;

	/**
	 * Metodo che restituisce l'email dell'azienda
	 * @return email del'azienda
	 */
	public String getEmailA() {
		return emailA;
	}
	/**
	 * Metodo che modifica l'email dell'azienda
	 * @param emailA - email dell'azienda
	 */
	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}
	/**
	 * Metodo che restituisce la password dell'azienda
	 * @return password dell'azienda
	 */
	public String getPasswordA() {
		return passwordA;
	}
	/**
	 * Metodo che permette la modifica della password dell'azienda
	 * @param passwordA - password dell'azienda
	 */
	public void setPasswordA(String passwordA) {
		this.passwordA = passwordA;
	}
	/**
	 * Metodo che restituisce il nome dell'azienda
	 * @return il nome dell'azienda
	 */
	public String getNomeA() {
		return nomeA;
	}
	/**
	 * Metodo che permette la modiifca del nome dell'azienda
	 * @param nomeA - nome dell'azienda
	 */
	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}
	/**
	 * Metodo che restituisce la locazione dell'azienda
	 * @return locazione dell'azienda
	 */
	public String getLocazioneA() {
		return locazioneA;
	}
	/**
	 * Metodo che permette la modifica della locazione dell'azienda
	 * @param locazioneA - locazione dell'azienda
	 */
	public void setLocazioneA(String locazioneA) {
		this.locazioneA = locazioneA;
	}	
}
