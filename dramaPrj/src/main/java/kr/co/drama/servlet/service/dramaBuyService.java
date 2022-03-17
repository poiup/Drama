package kr.co.drama.servlet.service;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import kr.co.drama.buyinfoDAO;
import kr.co.drama.userinfoDAO;
import kr.co.drama.userinfoVO;

public class dramaBuyService implements IDramaService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		// 드라마 번호, 유저 번호를 받아서 buyinfo에 저장
		int dnum = Integer.parseInt(request.getParameter("dnum"));
		int unum = Integer.parseInt(request.getParameter("unum"));
		String ucredit = request.getParameter("ucredit");
		
		buyinfoDAO biDAO = buyinfoDAO.getInstance();
		
		try {
			if(ucredit.equals(biDAO.getucredit(unum))) {
				biDAO.buyInsert(dnum, unum);
			}else {
				System.out.println("잘못된 결제 정보 입니다.");
				RequestDispatcher dp = request.getRequestDispatcher("/project/dramaBuyFail.jsp");
				dp.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
