package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.userinfoDAO;

public class loginUpdate implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String fId = request.getParameter("fid");
		String fpw = request.getParameter("fpw");
	    String fName = request.getParameter("fname");
	    String fnick = request.getParameter("fnick");
	    int fage = Integer.parseInt(request.getParameter("fage"));
	    String fcredit = request.getParameter("fcredit");
	    String faddress = request.getParameter("fadress");
		System.out.println(fId + fpw + fnick + fName+ fage+ fcredit+ faddress);
		userinfoDAO dao = userinfoDAO.getInstance();
		dao.userUpdateCheck(fId, fpw, fnick, fName, fage, fcredit, faddress);
	}
}
