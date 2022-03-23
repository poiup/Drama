package kr.co.drama.servlet.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.drama.actorDAO;
import kr.co.drama.actorVO;
import kr.co.drama.dramainfoDAO;
import kr.co.drama.dramainfoVO;
import kr.co.drama.favoriteDAO;
import kr.co.drama.favoriteVO;

public class dramaDetailService implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		int dNum = Integer.parseInt(request.getParameter("dnum"));
		
		favoriteDAO fdao = favoriteDAO.getInstance(); // 선호작 로직
		favoriteVO favoriteDetail = null;
		
		
		try {
		
			HttpSession session = request.getSession(); // 선호작 로직
			String strunum = String.valueOf(session.getAttribute("session_uNum")); // 선호작 로직
			int uNum = Integer.parseInt(strunum);// 선호작 로직
			favoriteDetail = fdao.getFavDetail(dNum, uNum); // 선호작 로직
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		dramainfoVO dramaDetail = null;
		actorDAO actDAO = actorDAO.getInstance();
		List<actorVO> actorList = new ArrayList<>();
		
		
		try {
			dramaDetail = dInfoDAO.dramaDetail(dNum);
			actorList = actDAO.actorList(dNum);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("actorList", actorList);
		request.setAttribute("dramaDetail", dramaDetail);	
		request.setAttribute("favoriteDetail",favoriteDetail); // 선호작 로직
	}	
	
}
