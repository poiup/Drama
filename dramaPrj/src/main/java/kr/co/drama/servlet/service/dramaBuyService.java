package kr.co.drama.servlet.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.buyinfoDAO;

public class dramaBuyService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		// 드라마 번호, 유저 번호를 받아서 buyinfo에 저장
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		int unum = Integer.parseInt(request.getParameter("unum"));
		
		buyinfoDAO biDAO = buyinfoDAO.getInstance();
		biDAO.buyInsert(dnum, unum);
	}
	
}
