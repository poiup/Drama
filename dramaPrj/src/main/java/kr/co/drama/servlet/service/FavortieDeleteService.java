package kr.co.drama.servlet.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.favoriteDAO;

public class FavortieDeleteService implements IDramaService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		int favNum = Integer.parseInt(request.getParameter("favnum"));
		
		favoriteDAO dao = favoriteDAO.getInstance();
		
		dao.deleteFavorite(favNum);
	}

}
