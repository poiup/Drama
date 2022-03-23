package kr.co.drama;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	// 선호작 등록 리스트 가져오기 - 선호 번호, 드라마 제목, 등록일 표시
	public List<String[]> getFavoriteList(int unum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<favoriteVO> favoriteList = new ArrayList<>();
		List<String[]> favorite = new ArrayList<>();
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
				
				// 기존 유저번호 드라마 번호 선호작 번호 선호작 등록 일자 리스트 만든 것
				favoriteVO favoriteData = new favoriteVO(uNum,dNum,favNum,favDate);
				favoriteList.add(favoriteData);
				
				// 드라마 제목이 들어간 리스트 하나 더 생성
				String favnum = String.valueOf(favNum);
				String dname = getdname(dNum);
				String favdate = new SimpleDateFormat("yyyy-MM-dd").format(favDate);
				
				String[] favarr = new String[] {favnum,dname,favdate};
				favorite.add(favarr);	
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
		return favorite;
	}
	
	// 드라마 번호에 따른 드라마 제목 가져오는 메서드
	public String getdname(int dnum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String dname = null;
		ResultSet rs = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String select_dname_sql = "SELECT * FROM dramainfo WHERE dnum = ?";
			pstmt = con.prepareStatement(select_dname_sql);
			pstmt.setInt(1, dnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dname = rs.getString("dname");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
			rs.close();
		}
		return dname;
	}
}
