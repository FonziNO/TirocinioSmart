package application;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.AccettazioneDao;
import storage.Richiesta;
import storage.RichiestaDao;

public class AccettazioneRichiesta extends HttpServlet {
AccettazioneDao ricDao = new AccettazioneDao();
	
	int res = 0;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		session.getId();
		System.out.println("sto per accettare");
		String emailAzienda = (String) session.getAttribute("email");
		try {
			Richiesta r = new Richiesta();
			res = ricDao.accetta(r.getCounter(), false, request.getParameter("emailS"), emailAzienda);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaStudenti.jsp");
		dashboardUfficioStage.forward(request, response);
	}

}

