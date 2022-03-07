package kr.co.drama.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.actorDAO;
import kr.co.drama.dramainfoDAO;

/**
 * Servlet implementation class dramaInsertServlet
 */
@WebServlet("/dramaInsert")
public class dramaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dramaInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname = request.getParameter("dname");
		int dpric = Integer.parseInt(request.getParameter("dprice"));
	    String dgenre = request.getParameter("dgenre");
	    String ddate = request.getParameter("ddate");
	    int dage = Integer.parseInt(request.getParameter("dage"));
	    String dthumb = request.getParameter("dthumb");
	    String dvideo = request.getParameter("dvideo");
	    String dtext = request.getParameter("dtext");
	    String actname = request.getParameter("actname");
		
		
		dramainfoDAO diDAO = dramainfoDAO.getInstance();
		actorDAO aDAO = actorDAO.getInstance();
		try {
			// 드라마 정보 저장
			diDAO.dramaInsert(dname,dpric,dgenre,ddate,dage,dthumb,dvideo,dtext);
			// 배우 정보저장
			aDAO.actorInsert(actname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
