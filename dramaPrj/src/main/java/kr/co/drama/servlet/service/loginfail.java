package kr.co.drama.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginfail implements IDramaService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		HttpSession session = request.getSession();
		String sName = (String)session.getAttribute("session_id");
		System.out.println(sName);
		if(sName == null) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('로그인 실패!! 계정정보를 확인해주세요'); location.href='/dramaPrj/main.do';</script>");
			out.close();

		}
	}
}
