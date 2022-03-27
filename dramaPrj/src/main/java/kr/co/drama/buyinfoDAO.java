package kr.co.drama;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
			pstmt.setInt(1, dnum);			
			pstmt.setInt(2, unum);	
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
	
	// 구매 리스트 가져오기 - 구매 번호, 드라마 제목, 등록일 표시
		public List<String[]> getBuyList(int unum){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<String[]> buyList = new ArrayList<>();
			try {
				con = ds.getConnection();
				String sql = "SELECT * FROM buyinfo WHERE unum = ?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, unum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int uNum = rs.getInt("unum");
					int dNum = rs.getInt("dnum");
					int buyNum = rs.getInt("buynum");
					Date buyDate = rs.getDate("buydate");
					
					// 드라마 제목이 들어간 리스트 하나 더 생성
					String buynum = String.valueOf(buyNum);
					String dname = getdname(dNum);
					String buydate = new SimpleDateFormat("yyyy-MM-dd").format(buyDate);
					
					String[] favarr = new String[] {buynum,dname,buydate};
					buyList.add(favarr);	
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
			return buyList;
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
	

