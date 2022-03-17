package kr.co.drama.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;

public class ComtInsertService implements IDramaComtService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		drama_commentDAO dao = drama_commentDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
		int unum = Integer.parseInt(request.getParameter("unum"));
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		String comtcont = request.getParameter("comtcont");
		int comtrate = Integer.parseInt(request.getParameter("comtrate"));
		
		dao.insertComt(unum, dnum, comtcont, comtrate);
		
	}

}
