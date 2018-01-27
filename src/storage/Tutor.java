package storage;
/**
 * il tutor ha nome, cognome, matricola, password, email e email dell'azienda a cui è associato
 */
public class Tutor {

	private String nomeT;
	private String cognomeT;
	private String matricolaT;
	private String passwordT;
	private String emailT;
	private String emailA;
	/**
	 * Metodo che restituisce l'email dell'azienda
	 * @return email dell'azienda a cui è associato
	 */
	public String getEmailA() {
		return emailA;
	}
	/**
	 * Metodo che modifica l'email dell'azienda
	 * @param emailA - email dell'azienda a cui è associato
	 */
	public void setEmailA(String emailA) {
		this.emailA = emailA;
	}
	/**
	 * Metodo che restituisce il nome del tutor
	 * @return nome del tutor
	 */
	public String getNomeT() {
		return nomeT;
	}
	/**
	 * Metodo che modifica il nome del tutor
	 * @param nomeT - nome del tutor
	 */
	public void setNomeT(String nomeT) {
		this.nomeT = nomeT;
	}
	/**
	 * Metodo che restituisce il cognome del tutor
	 * @return cognome del tutor
	 */
	public String getCognomeT() {
		return cognomeT;
	}
	/**
	 * Metodo che modifica il cognome del tutor
	 * @param cognomeT - cognome del tutor
	 */
	public void setCognomeT(String cognomeT) {
		this.cognomeT = cognomeT;
	}
	/**
	 * Metodo che restituisce l amatricola del tutor
	 * @return matricola del tutor
	 */
	public String getMatricolaT() {
		return matricolaT;
	}
	/**
	 * Metodo che modifica la matricola del tutor
	 * @param matricolaT - matricola del tutor
	 */
	public void setMatricolaT(String matricolaT) {
		this.matricolaT = matricolaT;
	}
	/**
	 * Metodo che restituisce la password del tutor
	 * @return password del tutor
	 */
	public String getPasswordT() {
		return passwordT;
	}
	/**
	 * Metodo che cambia la password del tutor
	 * @param passwordT - password del tutor
	 */
	public void setPasswordT(String passwordT) {
		this.passwordT = passwordT;
	}
	/**
	 * Metodo che restituisce l'email del tutor
	 * @return email del tutor
	 */
	public String getEmailT() {
		return emailT;
	}
	/**
	 * Metodo che modifica l'email del tutor
	 * @param emailT - email del tutor
	 */
	public void setEmailT(String emailT) {
		this.emailT = emailT;
	}
}
