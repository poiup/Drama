package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.drama.userinfoDAO;


public class signUp implements IDramaService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{	
		String fid = request.getParameter("fid");
	    String fpw = request.getParameter("fpw");
	    String fName = request.getParameter("fname");
	    String fnick = request.getParameter("fnick");
	    int fage = Integer.parseInt(request.getParameter("fage"));
	    String fcredit = request.getParameter("fcredit");
	    String faddress = request.getParameter("faddress");
	    
	    System.out.println(fName);
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		userinfoDAO dao = userinfoDAO.getInstance();
		dao.insertUser(fid, fpw, fName, fnick, fage, fcredit, faddress);
	}
}
