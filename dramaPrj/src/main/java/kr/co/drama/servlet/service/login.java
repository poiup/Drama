package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.userinfoDAO;
import kr.co.drama.userinfoVO;

public class login implements IDramaService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
	String fId = request.getParameter("fid");
	String fPw = request.getParameter("fpw");
	System.out.println("폼에서 날린 아이디 : " + fId);
	System.out.println("폼에서 날린 비밀번호 : " + fPw);
	
	userinfoDAO dao = userinfoDAO.getInstance();	
	userinfoVO user = dao.getUserData(fId);
	System.out.println("DB에서 받아온 정보 : " + user);
		
		if(user != null){
			String uId = user.getUid();
			String uPw = user.getUpw();
			String uCredit = user.getUcredit();
			String uName = user.getUname();
			String uNick = user.getUnick();
			int uNum = user.getUnum();
			System.out.println("DB내 유저 유저번호 : " + uNum);
			System.out.println("DB내 유저 아이디 : " + uId);
			System.out.println(fId.equals(user.getUid()) && fPw.equals(user.getUpw()));
			
			// 아이디 비밀번호 체크
			if(fId.equals(user.getUid()) && fPw.equals(user.getUpw())){
				request.getSession().setAttribute("session_id", uId);
				request.getSession().setAttribute("session_uNum", uNum);
				request.getSession().setAttribute("session_uCredit", uCredit);
				request.getSession().setAttribute("session_uName", uName);
				request.getSession().setAttribute("session_uNick", uNick);
				//request.getSession().setAttribute("session_pw", fPw);
			} 			
		} 
	}			
}

