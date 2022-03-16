package kr.co.drama.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;
import kr.co.drama.drama_commentVO;

/**
 * Servlet implementation class UpdateComtFormServlet
 */
@WebServlet("/UpdateComtForm")
public class UpdateComtFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateComtFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comtnum = request.getParameter("comtnum");
		int cNum = Integer.parseInt(comtnum);
		
		drama_commentDAO dao = drama_commentDAO.getInstance();
		// 2. BoardVO가져오기
		drama_commentVO comtList = dao.getComtDetail(cNum);
		// 3. 가져온 데이터 바인딩
		request.setAttribute("comtList", comtList);
		// 4. 목적지로 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("comment/comment_updateForm.jsp");
		dp.forward(request, response);
		
		
	}

}
