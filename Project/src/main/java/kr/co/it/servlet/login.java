package kr.co.it.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		System.out.println("폼에서 날린 아이디 : " + fId);
		System.out.println("폼에서 날린 비밀번호 : " + fPw);
		
		UserDAO dao = UserDAO.getInstance();
			
			UserVO user = dao.getUserData(fId);
			System.out.println("DB에서 받아온 정보 : " + user);
			
			if(user != null){
				
				String uId = user.getuId();// hint * getter
				String uPw = user.getuPw();
				System.out.println("DB내 유저 아이디 : " + uId);
				System.out.println("DB내 유저 비밀번호 : " + uPw);
				
				if(fId.equals(uId) && fPw.equals(uPw)){
				
					request.getSession().setAttribute("session_id", fId);
					request.getSession().setAttribute("session_pw", fPw);
					
					RequestDispatcher dp = request.getRequestDispatcher("/Project/intro2.jsp");
					dp.forward(request, response);
				} else {
					
					System.out.println(uPw + "비밀번호가 틀렸습니다. 다시 확인해주세요.");
					response.sendRedirect("http://localhost:8181/Project/Project/errorPw.jsp");
					
				}
				
			} else {
				System.out.println("아이디가 없습니다.입력 아이디 또는 비밀번호를 확인해주세요.");
				response.sendRedirect("http://localhost:8181/Project/Project/errorId.jsp");
			}
	}
}
