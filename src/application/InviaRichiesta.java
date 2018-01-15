package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.Richiesta;
import storage.RichiestaDao;

public class InviaRichiesta extends HttpServlet {
	RichiestaDao ricDao = new RichiestaDao();
	Richiesta r = new Richiesta();
	int res = 0;
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.getId();
		System.out.println("sto per inviare");
		String emailStudente = (String) session.getAttribute("email");

		System.out.println("Invio la richiesta");
		try {
			res = ricDao.richiedi(r.getCounter(), false, emailStudente, request.getParameter("emailAz"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
