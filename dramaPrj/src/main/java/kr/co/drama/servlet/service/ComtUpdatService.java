package kr.co.drama.servlet.service;


import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;

public class ComtUpdatService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String comtcon = request.getParameter("comtcont");
		int cNum = Integer.parseInt(request.getParameter("comtnum"));
		int cRate = Integer.parseInt(request.getParameter("comtrate"));
		
		drama_commentDAO dao =  drama_commentDAO.getInstance();
		
		dao.updateComt(comtcon, cNum, cRate);
		
	}

}
