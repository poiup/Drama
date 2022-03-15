package kr.co.drama.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.servlet.service.IDramaService;
import kr.co.drama.servlet.service.dramaDeleteService;
import kr.co.drama.servlet.service.dramaDetailService;
import kr.co.drama.servlet.service.dramaInsertService;
import kr.co.drama.servlet.service.dramaUpdateService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String ui = null;
		IDramaService sv = null;
		if(uri.equals("/dramaPrj/dramatest.do")) {
			ui = "/project/dramatest.jsp";
		} else if(uri.equals("/dramaPrj/dramaDetail.do")) {
			sv = new dramaDetailService();
			sv.execute(request, response);
			ui = "/project/dramaDetail.jsp?dnum="+request.getParameter("dnum");
		} else if(uri.equals("/dramaPrj/dramaUpdate.do")) {
			sv = new dramaUpdateService();
			sv.execute(request, response);
			ui = "/dramaDetail.do";
		} else if(uri.equals("/dramaPrj/dramaUpdateForm.do")) {
			sv = new dramaDetailService();
			sv.execute(request, response);
			ui = "/project/dramaUpdate.jsp";
		} else if(uri.equals("/dramaPrj/dramaDelete.do")) {
			sv = new dramaDeleteService();
			sv.execute(request, response);
			ui = "/project/dramatest.jsp"; 
		} else if(uri.equals("/dramaPrj/dramaInsert.do")) {
			sv = new dramaInsertService();
			sv.execute(request, response);
			ui = "/project/dramatest.jsp";
		} else if(uri.equals("/dramaPrj/dramaInsertForm.do")) {
			ui = "/project/dramaInsert.jsp";
		}
		
		
		System.out.println(request.getRequestURI());
		System.out.println(ui);
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}
