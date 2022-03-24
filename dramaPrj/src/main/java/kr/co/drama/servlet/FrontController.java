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

import kr.co.drama.servlet.service.ComtDeleteService;
import kr.co.drama.servlet.service.ComtInsertService;
import kr.co.drama.servlet.service.ComtUpdatService;
import kr.co.drama.servlet.service.ComtUpdateFormService;
import kr.co.drama.servlet.service.FavoriteListService;
import kr.co.drama.servlet.service.IDramaService;
import kr.co.drama.servlet.service.dramaBuyService;
import kr.co.drama.servlet.service.dramaDeleteService;
import kr.co.drama.servlet.service.dramaDetailService;
import kr.co.drama.servlet.service.dramaFavoriteService;
import kr.co.drama.servlet.service.dramaInsertService;
import kr.co.drama.servlet.service.dramaSearchDrama;
import kr.co.drama.servlet.service.dramaUpdateService;
import kr.co.drama.servlet.service.login;
import kr.co.drama.servlet.service.loginUpdate;
import kr.co.drama.servlet.service.loginUpdateForm;
import kr.co.drama.servlet.service.loginfail;
import kr.co.drama.servlet.service.logout;
import kr.co.drama.servlet.service.memberOut;
import kr.co.drama.servlet.service.signUp;

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
		} else if(uri.equals("/dramaPrj/dramaBuy.do")) {
			sv = new dramaBuyService();
			sv.execute(request, response);
			ui = "/dramaDetail.do";
		} else if(uri.equals("/dramaPrj/dramaBuyForm.do")) {
			ui = "/project/dramaBuy.jsp";
		} else if(uri.equals("/dramaPrj/dramaFavorite.do")) {
			sv = new dramaFavoriteService();
			sv.execute(request, response);
			ui = "/project/dramaFavoriteResult.jsp";
		} else if(uri.equals("/dramaPrj/FavoriteList.do")) {
			sv = new FavoriteListService();
			sv.execute(request, response);
			ui = "/project/FavoriteList.jsp";
		} 
		
		else if(uri.equals("/dramaPrj/sign.do")) {
			ui = "/project/sign.jsp";
		} else if(uri.equals("/dramaPrj/main.do")){
			ui = "/project/index.jsp";
		} else if(uri.equals("/dramaPrj/login.do")) {
			sv = new login();
			sv.execute(request, response);
			ui = "/loginfail.do";
		} else if(uri.equals("/dramaPrj/loginfail.do")) {
			sv = new loginfail();
			sv.execute(request, response);
			ui = "/main.do";
		} else if (uri.equals("/dramaPrj/signUpForm.do")) {
			ui = "/project/signup.jsp";
		} else if (uri.equals("/dramaPrj/signUp.do")) {
			sv = new signUp();
			sv.execute(request, response);
			ui = "/main.do";
		} else if(uri.equals("/dramaPrj/logout.do")) {
			sv = new logout();
			sv.execute(request, response);
			ui = "/main.do";
		}else if (uri.equals("/dramaPrj/loginUpdateForm.do")) {
			sv = new loginUpdateForm();
			sv.execute(request, response);
			ui = "/project/login_update.jsp";
		}else if (uri.equals("/dramaPrj/loginUpdate.do")) {
			sv = new loginUpdate();
			sv.execute(request, response);
			ui = "/main.do";
		}else if (uri.equals("/dramaPrj/memberOut.do")) {
			sv = new memberOut();
			sv.execute(request, response);
			ui = "/main.do";
		}
		
		
		else if (uri.equals("/dramaPrj/CommentForm.do")) {
			ui = "/project/comment_form.jsp";
		}
		else if(uri.equals("/dramaPrj/InsertComt.do")) {
			sv = new ComtInsertService();
			sv.execute(request, response);
			ui = "/dramaDetail.do";
		} else if(uri.equals("/dramaPrj/DeleteComt.do")) {
			sv = new ComtDeleteService();
			sv.execute(request, response);
			ui = "/dramaDetail.do";
		} else if(uri.equals("/dramaPrj/UpdateComtForm.do")) {
			sv = new ComtUpdateFormService();
			sv.execute(request, response);
			ui = "/project/comment_updateForm.jsp";
		} else if(uri.equals("/dramaPrj/UpdateComt.do")) {
			sv = new ComtUpdatService();
			sv.execute(request, response);
			ui = "/dramaDetail.do";			
		} 
		
		
		else if(uri.equals("/dramaPrj/dramaSearch.do")) {
			sv = new dramaSearchDrama();
			sv.execute(request, response);
			ui = "/project/dramaSearchResult.jsp";
		} else if(uri.equals("/dramaPrj/dramaSearchPage.do")) {
			ui = "/project/dramaSearch.jsp";
		} else if(uri.equals("/dramaPrj/out.do")) {
			ui = "/project/out.jsp";
		}
		
		else {
			ui = "/index.jsp";
		}
		
		
		System.out.println(request.getRequestURI());
		System.out.println(ui);
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
}
