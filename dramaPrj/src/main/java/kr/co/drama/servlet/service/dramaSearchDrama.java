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
		String search_type = request.getParameter("search_type");
		
		List<dramainfoVO> dvo = null;

		if(search_type.equals("dname")) {
			dvo = dao.SearchValuesByName(keywords);
			
		}
		else if(search_type.equals("actor")) {
			dvo = dao.SearchValuesByGenre(keywords);
			
		}
		else if(search_type.equals("dgenre")) {
			dvo = dao.SearchValuesByactor(keywords);
		}

		
		request.setAttribute("search_result", dvo);

		
	}	
	
}
