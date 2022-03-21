package kr.co.drama.servlet.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.drama.actorDAO;
import kr.co.drama.actorVO;
import kr.co.drama.drama_commentDAO;
import kr.co.drama.drama_commentVO;
import kr.co.drama.dramainfoDAO;
import kr.co.drama.dramainfoVO;
import kr.co.drama.userinfoDAO;
import kr.co.drama.userinfoVO;

public class dramaDetailService implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		int dNum = Integer.parseInt(request.getParameter("dnum"));
		// sk
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
	
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		dramainfoVO dramaDetail = null;
		actorDAO actDAO = actorDAO.getInstance();
		drama_commentDAO dao = drama_commentDAO.getInstance();
		List<actorVO> actorList = new ArrayList<>();
		List<drama_commentVO> comtList = new ArrayList<>();
		
		// sk
		userinfoDAO uifDAO = userinfoDAO.getInstance();
		userinfoVO user = null;
		
		try {
			dramaDetail = dInfoDAO.dramaDetail(dNum);
			actorList = actDAO.actorList(dNum);
			comtList = dao.getAllcomtList(dNum);
			user = uifDAO.getUserData(sId); // sk
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("actorList", actorList);
		request.setAttribute("dramaDetail", dramaDetail);
		request.setAttribute("comtList", comtList);
		
		request.setAttribute("sId", sId); // sk
		request.setAttribute("user", user);
	}	
	
}
