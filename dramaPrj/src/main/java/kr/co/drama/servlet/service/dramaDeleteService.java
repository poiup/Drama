package kr.co.drama.servlet.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.dramainfoDAO;

public class dramaDeleteService implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		try {
			dInfoDAO.dramaDelete(dnum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
