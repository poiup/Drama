package kr.co.drama.servlet.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.actorDAO;
import kr.co.drama.actorVO;
import kr.co.drama.dramainfoDAO;
import kr.co.drama.dramainfoVO;

public class dramaSearchDrama implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{

		dramainfoDAO dao = dramainfoDAO.getInstance();
		String keywords = request.getParameter("keywords");
		List<dramainfoVO> dvo = dao.SerchValuesByName(keywords);
		
		request.setAttribute("search_result", dvo);

		
	}	
	
}
