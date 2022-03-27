package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.drama.buyinfoDAO;
import kr.co.drama.favoriteDAO;

public class dramaBuyListService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String strunum = String.valueOf(session.getAttribute("session_uNum"));
		int unum = Integer.parseInt(strunum);
		System.out.println("유저 넘버 : "+strunum);
		
		buyinfoDAO bdao = buyinfoDAO.getInstance();
		List<String[]> buyList = bdao.getBuyList(unum);
		request.setAttribute("buyList",buyList);
	}
	
}
