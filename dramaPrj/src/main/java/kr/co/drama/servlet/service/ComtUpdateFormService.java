package kr.co.drama.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.drama_commentDAO;
import kr.co.drama.drama_commentVO;

public class ComtUpdateFormService implements IDramaComtService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comtnum = request.getParameter("comtnum");
		int cNum = Integer.parseInt(comtnum);
		
		drama_commentDAO dao = drama_commentDAO.getInstance();
	
		drama_commentVO comtList = dao.getComtDetail(cNum);
		
		request.setAttribute("comtList", comtList);
	}
	
}
