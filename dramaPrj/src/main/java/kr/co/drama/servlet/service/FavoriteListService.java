package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import kr.co.drama.favoriteDAO;
import kr.co.drama.favoriteVO;

public class FavoriteListService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String strunum = String.valueOf(session.getAttribute("session_uNum"));
		int unum = Integer.parseInt(strunum);
		System.out.println("유저 넘버 : "+strunum);
		
		favoriteDAO fdao = favoriteDAO.getInstance();
		List<favoriteVO> favoriteList = fdao.getFavoriteList(unum);
		request.setAttribute("favoriteList",favoriteList);
	}
	
}
