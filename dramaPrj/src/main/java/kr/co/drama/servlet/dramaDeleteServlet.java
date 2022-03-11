package kr.co.drama.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.dramainfoDAO;

/**
 * Servlet implementation class dramaDeleteServlet
 */
@WebServlet("/dramaDelete")
public class dramaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dramaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		try {
			dInfoDAO.dramaDelete(dnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
