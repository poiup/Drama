package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.drama.userinfoDAO;
import kr.co.drama.userinfoVO;

public class loginUpdateForm implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
		
		userinfoDAO dao = userinfoDAO.getInstance();
		userinfoVO user = null;
		user = dao.getUserData(sId);
		System.out.println("::"+user);
		
		request.setAttribute("user", user);
	}
}
