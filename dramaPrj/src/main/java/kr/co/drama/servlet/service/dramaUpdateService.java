package kr.co.drama.servlet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.drama.actorDAO;
import kr.co.drama.actorVO;
import kr.co.drama.dramainfoDAO;
import kr.co.drama.dramainfoVO;

public class dramaUpdateService implements IDramaService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException{
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
	    int dnum = Integer.parseInt(request.getParameter("dnum"));
		dramainfoDAO dInfoDAO = dramainfoDAO.getInstance();
		
		try {
			dInfoDAO.dramaUpdate(dname,dpric,dgenre,ddate,dage,dthumb,dvideo,dtext,actname, dnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
