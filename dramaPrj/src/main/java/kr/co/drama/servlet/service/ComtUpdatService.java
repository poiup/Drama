package kr.co.drama.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;

public class ComtUpdatService implements IDramaComtService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String comtcon = request.getParameter("comtcont");
		int cNum = Integer.parseInt(request.getParameter("comtnum"));
		int cRate = Integer.parseInt(request.getParameter("comtrate"));
		
		drama_commentDAO dao =  drama_commentDAO.getInstance();
		
		dao.updateComt(comtcon, cNum, cRate);
		
	}

}
