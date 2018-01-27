package storage;
/**
 * l' UfficioStage ha l'email e la password 
 */
public class UfficioStage {

	private String emailU;
	private String passwordU;
	/**
	 * Metodo che restituisce l'email dell'ufficio stage
	 * @return email dell'ufficio stage
	 */
	public String getEmailU() {
		return emailU;
	}
	/**
	 * Metodo che modifica l'email dell'ufficio stage
	 * @param emailU - email dell'ufficio stage
	 */
	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}
	/**
	 * Metodo che restituisce la password dell'ufficio stage
	 * @return password dell'ufficio stage
	 */
	public String getPasswordU() {
		return passwordU;
	}
	/**
	 * Metodo che modifica la password dell'ufficio stage
	 * @param passwordU - password dell'ufficio stage
	 */
	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}
}
