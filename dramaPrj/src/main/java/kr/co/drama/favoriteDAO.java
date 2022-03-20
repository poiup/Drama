package kr.co.drama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class favoriteDAO {
	private DataSource ds = null;;
	private static favoriteDAO dao = new favoriteDAO();
	private favoriteDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static favoriteDAO getInstance() {
		if(dao == null) {
			dao = new favoriteDAO();
		}
		return dao;
	}
	
	public void favoriteInsert(int unum,int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "insert into favorite values (?,?,null,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, unum);			
			pstmt.setInt(2, dnum);	
			//쿼리 실행
			System.out.println(pstmt);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}
}
