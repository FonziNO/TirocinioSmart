package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.AccettazioneDao;
import storage.AccettazioneTutorDao;
import storage.Azienda;
import storage.AziendaTutor;
import storage.Richiesta;
import storage.Tutor;

public class AccettazioneTutor extends HttpServlet{
AccettazioneTutorDao ricTDao = new AccettazioneTutorDao();
	
	int res = 0;
	String emailAzienda;
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		session.getId();
		System.out.println("il tutor sta per accettare");
		try {
			ArrayList<Tutor> lista= new ArrayList<Tutor>();
			lista=ricTDao.doListaTutor();
			for(int i=0; i<lista.size(); i++){
				System.out.println("email associate al tutor"+lista.get(i).getEmailA());
				if(lista.get(i).getEmailT().equals(session.getAttribute("email"))){
					emailAzienda=lista.get(i).getEmailA();
				}
			}
			Richiesta r = new Richiesta();
			res = ricTDao.accettaTutor(r.getCounter(), false, false, false, request.getParameter("emailSt"), emailAzienda);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaStudentiTutor.jsp");
		dashboardUfficioStage.forward(request, response);
	}

}
