package kr.co.drama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class buyinfoDAO {
	private DataSource ds = null;;
	private static buyinfoDAO dao = new buyinfoDAO();
	private buyinfoDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static buyinfoDAO getInstance() {
		if(dao == null) {
			dao = new buyinfoDAO();
		}
		return dao;
	}
	
	public void buyInsert(int unum,int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "insert into buyinfo values (?,?,null,null)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, unum);			
			pstmt.setInt(2, dnum);	
			
			//쿼리 실행
			pstmt.executeUpdate();
			
			// 추후 결제 방법 상의 후 인증 후 결제 진행 코드 삽입 예정
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}
}
