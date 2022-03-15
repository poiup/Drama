package kr.co.drama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class actorDAO {
	private DataSource ds = null;;
	
	private static actorDAO dao = new actorDAO();
	
	private actorDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static actorDAO getInstance() {
		if(dao == null) {
			dao = new actorDAO();
		}
		return dao;
	}
	
	// 배우 리스트 받아오기
	public List<actorVO> actorList (int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<actorVO> actorList = new ArrayList<>();
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "SELECT * FROM actor WHERE dnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dnum);
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			
		
			// 정보 리스트에 저장
			while(rs.next()) {
				String actname = rs.getString("actname");
				int actnum = rs.getInt("actnum");
				int dNum = rs.getInt("dnum");
				
				actorVO actorinfo = new actorVO(actname, actnum, dNum);
				actorList.add(actorinfo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
		return actorList;
	}
}