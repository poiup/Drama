package kr.co.drama.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.servlet.service.ComtDeleteService;
import kr.co.drama.servlet.service.ComtInsertService;
import kr.co.drama.servlet.service.ComtListService;
import kr.co.drama.servlet.service.ComtUpdatService;
import kr.co.drama.servlet.service.ComtUpdateFormService;
import kr.co.drama.servlet.service.IDramaComtService;

/**
 * Servlet implementation class FrontComtController
 */
@WebServlet("*.do")
public class FrontComtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontComtController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}
	
	private void doRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String ui = null;
		IDramaComtService sv = null;
		
		if(uri.equals("/dramaPrj/commentList.do")) {
			sv = new ComtListService();
			sv.execute(request, response);
			ui = "/comment/comment_list.jsp";
		} else if(uri.equals("/dramaPrj/InsertComt.do")) {
			sv = new ComtInsertService();
			sv.execute(request, response);
			ui = "/commentList.do";
		} else if(uri.equals("/dramaPrj/DeleteComt.do")) {
			sv = new ComtDeleteService();
			sv.execute(request, response);
			ui = "/commentList.do";
		} else if(uri.equals("/dramaPrj/UpdateComtForm.do")) {
			sv = new ComtUpdateFormService();
			sv.execute(request, response);
			ui = "/comment/comment_updateForm.jsp";
		} else if(uri.equals("/dramaPrj/UpdateComt")) {
			sv = new ComtUpdatService();
			sv.execute(request, response);
			ui = "/commentList.do";
		}
		else {
			ui = "/";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}
}
