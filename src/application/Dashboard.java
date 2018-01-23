package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import storage.DriverManagerConnectionPool;
import storage.LoginDao;

/**
 * Servlet implementation class Dashboard
 */

public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		PreparedStatement prep2 = null;
		PreparedStatement prep3 = null;
		Connection conn = null;
		String user = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password");
		String nomeStudente = "SELECT Nome , Cognome, notifica FROM Studente WHERE Studente.Email=?";
		String nomeAzienda = "SELECT Nome FROM Azienda WHERE Azienda.Email=?";
		String nomeTutor = "SELECT Nome, Cognome FROM Tutor WHERE Tutor.Email=?";
		String nomeUS = "SELECT Email FROM Ufficiostage WHERE Ufficiostage.Email=?";
		String n = null;
		String c = null;
		String azienda = null;
		String tutorN = null;
		String tutorC = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		try {
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(nomeStudente);
			prep.setString(1, user);

			prep1 = conn.prepareStatement(nomeAzienda);
			prep1.setString(1, user);

			prep2 = conn.prepareStatement(nomeTutor);
			prep2.setString(1, user);

			prep3 = conn.prepareStatement(nomeUS);
			prep3.setString(1, user);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			rs = prep.executeQuery();

			rs1 = prep1.executeQuery();

			rs2 = prep2.executeQuery();

			rs3 = prep3.executeQuery();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			if (rs3.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				RequestDispatcher dashboardUfficioStage = request.getRequestDispatcher("DashboardStage.jsp");
				dashboardUfficioStage.forward(request, response);

			} else if (rs2.next()) {
				tutorN = rs2.getString("Nome");
				tutorC = rs2.getString("Cognome");
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", tutorN);
				session.setAttribute("Cognome", tutorC);
				RequestDispatcher dashboardTutor = request.getRequestDispatcher("DashboardTutor.jsp");
				dashboardTutor.forward(request, response);
			} else if (rs1.next()) {
				azienda = rs1.getString("Nome");
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", azienda);
				RequestDispatcher dashboardAzienda = request.getRequestDispatcher("DashboardAzienda.jsp");
				dashboardAzienda.forward(request, response);
			} else if (rs.next()) {
				n = rs.getString("Nome");
				c = rs.getString("Cognome");
				String not = rs.getString("notifica");
				HttpSession session = request.getSession();
				session.setAttribute("email", user);
				session.setAttribute("Nome", n);
				session.setAttribute("Cognome", c);
				request.setAttribute("notifica", not);
				RequestDispatcher dashboardStudente = request.getRequestDispatcher("DashboardStudente.jsp");

				dashboardStudente.forward(request, response);
				System.out.println(n + " " + c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
