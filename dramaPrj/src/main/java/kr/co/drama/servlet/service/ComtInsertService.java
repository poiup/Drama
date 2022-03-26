package kr.co.drama.servlet.service;


import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;

public class ComtInsertService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		drama_commentDAO dao = drama_commentDAO.getInstance();
		
		int unum = Integer.parseInt(request.getParameter("unum"));
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		String comtcont = request.getParameter("comtcont");
		int comtrate = Integer.parseInt(request.getParameter("comtrate"));
		
		dao.insertComt(unum, dnum, comtcont, comtrate);
		
	}


}
