package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.favoriteDAO;

public class dramaFavoriteService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException {
		// TODO Auto-generated method stub
		int unum = Integer.parseInt(request.getParameter("unum"));
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		
		favoriteDAO fvdao = favoriteDAO.getInstance();
		fvdao.favoriteInsert(unum, dnum);
	}
	
}
