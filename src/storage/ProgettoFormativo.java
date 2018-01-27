package storage;

/**
 * il progetto formativo ha un id
 */
public class ProgettoFormativo {

	private String IdP;

	/**
	 * metodo che restituisce l'id del progetto formativo
	 * @return id del progetto formativo
	 */
	public String getIdP() {
		return IdP;
	}
	/**
	 * Metodo che permette di modificare l'id del progetto formativo
	 * @param idP - id del progetto formativo
	 */
	public void setIdP(String idP) {
		IdP = idP;
	}
}
