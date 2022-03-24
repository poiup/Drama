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
			String sql = "insert into buyinfo values (?,?,null,now())";
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
	
	//유저 카드 번호 받아오는 메서드
	public String getucredit(int unum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String ucredit = null;
		ResultSet rs = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String select_ucredit_sql = "SELECT * FROM userinfo WHERE unum = ?";
			pstmt = con.prepareStatement(select_ucredit_sql);
			pstmt.setInt(1, unum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ucredit = rs.getString("ucredit");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
			rs.close();
		}
		return ucredit;
	}
}
	

