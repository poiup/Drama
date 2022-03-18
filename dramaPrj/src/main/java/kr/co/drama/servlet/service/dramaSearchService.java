package kr.co.drama.servlet.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.dramainfoDAO;
import kr.co.drama.dramainfoVO;

/**
 * Servlet implementation class dramaSearchService
 */
@WebServlet("/dramaSearchService")
public class dramaSearchService implements IDramaService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		dramainfoDAO dao = dramainfoDAO.getInstance();
		String keywords = request.getParameter("keywords");
		List<dramainfoVO> dvo = dao.SerchValuesByName(keywords);
		
		request.setAttribute("search_result", dvo);
	
	}
}
