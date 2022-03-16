package kr.co.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class join_check
 */
@WebServlet("/join_check")
public class join_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public join_check() {
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
		request.setCharacterEncoding("utf-8");
		String fId = request.getParameter("fid");
		String fPw = request.getParameter("fpw");
		String fNick = request.getParameter("fnick");
		String fAge = request.getParameter("fage");
		String fCredit = request.getParameter("fcredit");
		String fAddress = request.getParameter("faddress");
		System.out.println("1. fAddress : " + fAddress);
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(fId);
		System.out.println("DB에서 받아온 정보 : " + user);
		if(user != null){
			response.sendRedirect("http://localhost:8181/Project/Project/id_check.jsp");
		}else{
			dao.insertUser(fId, fPw, fNick, fAge, fCredit, fAddress);
		response.sendRedirect("http://localhost:8181/Project/Project/sign.jsp");
		}
	}

}
