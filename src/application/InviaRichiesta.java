package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.Richiesta;
import storage.RichiestaDao;

/**
 * Servlet implementation class InviaRichiesta
 */
public class InviaRichiesta extends HttpServlet {
	RichiestaDao ricDao = new RichiestaDao();

	int res = 0;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.getId();
		System.out.println("sto per inviare");
		String emailStudente = (String) session.getAttribute("email");

		System.out.println("Invio la richiesta");
		try {

			Richiesta r = new Richiesta();
			res = ricDao.richiedi(r.getCounter(), false, false, false, emailStudente, request.getParameter("emailAz"));
			if (res == -1) {
				request.setAttribute("errore", "Richiesta gi� effettuata per questa Azienda");
			} else {
				request.setAttribute("inserisci", "Richiesta inviata");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaAziende.jsp");
		dashboardUfficioStage.forward(request, response);
	}
}
