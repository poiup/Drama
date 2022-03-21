package kr.co.drama.servlet.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.dramainfoDAO;

public class dramaInsertService implements IDramaService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		// form으로 전송하는 데이터들
		String dname = request.getParameter("dname");
		int dpric = Integer.parseInt(request.getParameter("dprice"));
	    String dgenre = request.getParameter("dgenre");
	    String ddate = request.getParameter("ddate");
	    int dage = Integer.parseInt(request.getParameter("dage"));
	    String dthumb = request.getParameter("dthumb");
	    String dvideo = request.getParameter("dvideo");
	    String dtext = request.getParameter("dtext");
	    String actnames = request.getParameter("actname");
	    String[] actname = actnames.split(",");
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			dramainfoDAO diDAO = dramainfoDAO.getInstance();
		try {
			// 드라마 정보 저장, 배우정보 저장
			diDAO.dramaInsert(dname,dpric,dgenre,ddate,dage,dthumb,dvideo,dtext,actname);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
