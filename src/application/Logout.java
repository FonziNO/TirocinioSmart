package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String stato = (String) request.getSession().getAttribute("email");
		//System.out.println("Stato"+stato);

		if(stato == null || stato == "") 
		{
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
		else
		{	
			request.getSession().invalidate();
			//System.out.println("chiudo la sessione");

			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
	}


}
