package kr.co.drama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void actorInsert	(String actname) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "insert into actor value (?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, actname);
			
			int insert = pstmt.executeUpdate();
			//쿼리 실행

		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}
}