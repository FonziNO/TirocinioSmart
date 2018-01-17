package application;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.AccettazioneDao;
import storage.AccettazioneTutorDao;
import storage.Richiesta;

public class AccettazioneTutor {
AccettazioneTutorDao ricTDao = new AccettazioneTutorDao();
	
	int res = 0;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		session.getId();
		System.out.println("il tutor sta per accettare");
		String emailTutor = (String) session.getAttribute("email");
		try {
			Richiesta r = new Richiesta();
			res = ricTDao.accettaTutor(r.getCounter(), false, request.getParameter("emailSt"), emailTutor);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaStudenti.jsp");
		dashboardUfficioStage.forward(request, response);
	}

}
