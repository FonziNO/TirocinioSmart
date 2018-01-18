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
import storage.RifiutoRichiestaDao;

public class RifiutoRichiesta extends HttpServlet {
RifiutoRichiestaDao ricDao = new RifiutoRichiestaDao();
	
	int res = 0;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		session.getId();
		System.out.println("sto per rifiutare");
		String emailAzienda = (String) session.getAttribute("email");
		try {
			Richiesta r = new Richiesta();
			res = ricDao.rifiuta(r.getCounter(), false, false, false, request.getParameter("emailStu"), emailAzienda);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaStudenti.jsp");
		dashboardUfficioStage.forward(request, response);
	}


}