package kr.co.drama.servlet.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;
import kr.co.drama.drama_commentVO;

public class ComtListService implements IDramaService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		drama_commentDAO dao = drama_commentDAO.getInstance();
		
		List<drama_commentVO> comtList = dao.getAllcomtList();
		
		request.setAttribute("comtList", comtList);
	}

	

}
