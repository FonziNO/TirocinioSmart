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

import storage.AccettazioneUfficioDao;
import storage.Azienda;
import storage.Richiesta;
import storage.Tutor;
import storage.UfficioStage;

public class AccettazioneUfficio extends HttpServlet{
	AccettazioneUfficioDao ricUDao = new AccettazioneUfficioDao();
	
	int res = 0;
	int res2=0;
	String emailAzienda;
	String emailTutor;
	boolean stato;
	private static final long serialVersionUID = 1L;
	
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		session.getId();
		System.out.println("l'ufficio sta per accettare");
		try {
			Richiesta r = new Richiesta();
			ArrayList<Richiesta> lista= new ArrayList<Richiesta>();
			lista=ricUDao.doListaAziende();
			for(int i=0; i<lista.size(); i++){
				System.out.println("email azienda"+lista.get(i).getEmailA());
				emailAzienda=lista.get(i).getEmailA();
				
			}
			res = ricUDao.accettaUfficio(r.getCounter(), false, false, false, request.getParameter("emailSt"), null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaStudentiUfficio.jsp");
		dashboardUfficioStage.forward(request, response);
	}

}
