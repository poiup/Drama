package kr.co.drama.servlet.service;


import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;

public class ComtDeleteService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String comtnum = request.getParameter("comtnum");
		
		int cNum = Integer.parseInt(comtnum);
		
		drama_commentDAO dao = drama_commentDAO.getInstance();
		
		dao.deletComt(cNum);
	}

	
}
