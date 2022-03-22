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
	
	// 선호작 등록 리스트 가져오기 - 유저넘버와 드라마 번호로 표시됨
	public List<favoriteVO> getFavoriteList(int unum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<favoriteVO> favoriteList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM favorite WHERE unum = ?";			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, unum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int uNum = rs.getInt("unum");
				int dNum = rs.getInt("dnum");
				int favNum = rs.getInt("favnum");
				Date favDate = rs.getDate("favdate");
				
				favoriteVO favoriteData = new favoriteVO(uNum,dNum,favNum,favDate);
				favoriteList.add(favoriteData);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
		return favoriteList;
	}
}
