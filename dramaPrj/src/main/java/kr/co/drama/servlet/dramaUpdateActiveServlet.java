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
 * Servlet implementation class dramaUpdateActiveServlet
 */
@WebServlet("/dramaUpdateActive")
public class dramaUpdateActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dramaUpdateActiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dname = request.getParameter("dname");
		int dpric = Integer.parseInt(request.getParameter("dprice"));
	    String dgenre = request.getParameter("dgenre");
	    String ddate = request.getParameter("ddate");
	    int dage = Integer.parseInt(request.getParameter("dage"));
	    String dthumb = request.getParameter("dthumb");
	    String dvideo = request.getParameter("dvideo");
	    String dtext = request.getParameter("dtext");
	    String actnames = request.getParameter("actname");
	    String[] actname = actnames.split(",");
	    int dnum = Integer.parseInt(request.getParameter("dnum"));
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		
		try {
			dInfoDAO.dramaUpdate(dname,dpric,dgenre,ddate,dage,dthumb,dvideo,dtext,actname, dnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
