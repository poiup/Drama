package kr.co.drama;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class dramainfoDAO {
	private DataSource ds = null;;
	private static dramainfoDAO dao = new dramainfoDAO();
	private dramainfoDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static dramainfoDAO getInstance() {
		if(dao == null) {
			dao = new dramainfoDAO();
		}
		return dao;
	}
	
	public void dramaInsert	(String dname, int dprice, String dgenre, String ddate, int dage, String dthumb, String dvideo, String dtext) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "insert into dramainfo (dname,dprice,dgenre,ddate,dage,dthumb,dvideo,dtext) value (?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setInt(2, dprice);
			pstmt.setString(3, dgenre);
			pstmt.setString(4, ddate);
			pstmt.setInt(5, dage);
			pstmt.setString(6, dthumb);
			pstmt.setString(7, dvideo);
			pstmt.setString(8, dtext);			
			//쿼리 실행
			int insert = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}
}
