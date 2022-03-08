package kr.co.drama.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;

/**
 * Servlet implementation class InsertComtServlet
 */
@WebServlet("/InsertComt")
public class InsertComtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertComtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		drama_commentDAO dao = drama_commentDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
		int unum = Integer.parseInt(request.getParameter("unum"));
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		String comtcont = request.getParameter("comtcont");
		int comtrate = Integer.parseInt(request.getParameter("comtrate"));
		
		dao.insertComt(unum, dnum, comtcont, comtrate);
		
		response.sendRedirect("http://localhost:8181/dramaPrj/commentList");
	}

}
