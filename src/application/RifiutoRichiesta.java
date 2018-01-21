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

import storage.Richiesta;
import storage.RifiutoRichiestaDao;

public class RifiutoRichiesta extends HttpServlet {
RifiutoRichiestaDao ricDao = new RifiutoRichiestaDao();
	
	int res = 0;
	ArrayList<Richiesta> richiesteRifiutate = new ArrayList<Richiesta>();
	
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession(); 
		session.getId();
		System.out.println("sto per rifiutare");
		ListaRichieste lista= new ListaRichieste();
		String emailAzienda = (String) session.getAttribute("email");
		
		try {
			Richiesta r = new Richiesta();
			for(int i=0; i<lista.doListaRichieste().size(); i++){
				if(lista.doListaRichieste().get(i).getEmailA().equals(emailAzienda) && lista.doListaRichieste().get(i).getEmailS().equals(request.getParameter("emailStu"))){
					richiesteRifiutate.add(lista.doListaRichieste().get(i));
					
				}
			}
			res = ricDao.rifiuta(r.getCounter(), false, false, false, request.getParameter("emailStu"), emailAzienda);
			System.out.println("Sono in rifiuto richiesta "+res);
			if(res >=0 ){
				request.setAttribute("rifiuta", "Richiesta rifiutata");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("ListaStudenti.jsp");
		dashboardUfficioStage.forward(request, response);
	}

	public ArrayList<Richiesta> getRichiesteRifiutate() {
		return richiesteRifiutate;
	}

	public void setRichiesteRifiutate(ArrayList<Richiesta> richiesteRifiutate) {
		this.richiesteRifiutate = richiesteRifiutate;
	}
	
	

}
