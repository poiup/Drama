package kr.co.drama.servlet.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.drama.actorDAO;
import kr.co.drama.actorVO;
import kr.co.drama.dramaComtGetDataDTO;
import kr.co.drama.drama_commentDAO;
import kr.co.drama.drama_commentDTO;
import kr.co.drama.drama_commentVO;
import kr.co.drama.dramainfoDAO;
import kr.co.drama.dramainfoVO;
import kr.co.drama.userinfoDAO;
import kr.co.drama.userinfoVO;

public class dramaDetailService implements IDramaService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		
		int dNum = Integer.parseInt(request.getParameter("dnum"));
		
		int uNum = 0;
		
		
		
		String strpNum = request.getParameter("pageNum");
		int pNum = 0;
		try {
			pNum = Integer.parseInt(strpNum);
		} catch(Exception e) {
			pNum = 1;
		}
		System.out.println("DB내 유저 유저번호 : " + uNum);
		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("session_id");
	
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		drama_commentDAO dao = drama_commentDAO.getInstance();
		actorDAO actDAO = actorDAO.getInstance();

		dramainfoVO dramaDetail = null;
		List<actorVO> actorList = new ArrayList<>();
		List<drama_commentVO> comtList = new ArrayList<>();
		List<dramaComtGetDataDTO> comtDataList = new ArrayList<>();
		
		// 페이지 버튼 생성을 위한 글 개수 sk
		int comtCount = dao.getPageNum(dNum);
		drama_commentDTO dto = new drama_commentDTO(comtCount, pNum);
		
		// sk
		userinfoDAO uifDAO = userinfoDAO.getInstance();
		userinfoVO user = null;
		//userinfoVO user2 = null;//
		try {
			dramaDetail = dInfoDAO.dramaDetail(dNum);
			actorList = actDAO.actorList(dNum);
			comtList = dao.getAllcomtList(dNum,pNum);
			user = uifDAO.getUserData(sId); // sk
			//user2 = uifDAO.getUserData2(uNum);//
			
			comtDataList = dao.getAllcomtDataList(dNum,pNum);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("actorList", actorList);
		request.setAttribute("dramaDetail", dramaDetail);
		request.setAttribute("comtList", comtList);
		request.setAttribute("comtDataList", comtDataList);
		
		request.setAttribute("sId", sId); // sk
		//request.setAttribute("user", user);
		request.setAttribute("dto", dto);
		
		//request.setAttribute("user2", user2);//
	}	
	
}
