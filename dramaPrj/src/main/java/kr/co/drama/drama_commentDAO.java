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

public class drama_commentDAO {
	private DataSource ds = null;;
	private static drama_commentDAO dao = new drama_commentDAO();
	private drama_commentDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static drama_commentDAO getInstance() {
		if(dao == null) {
			dao = new drama_commentDAO();
		}
		return dao;
	}
	
	public List<drama_commentVO> getAllcomtList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<drama_commentVO> comtList = new ArrayList<>();
		try {
		
			con = ds.getConnection();
		
		
		 String sql = "SELECT * FROM drama_comment ORDER BY comtnum DESC";
		 pstmt = con.prepareStatement(sql);	
		
		 rs = pstmt.executeQuery();
		
	
		 while(rs.next()) {
			 
			 int unum = rs.getInt("unum");
			 int dnum = rs.getInt("dnum");
			 String comtcont = rs.getString("comtcont");
			 Date comtdate = rs.getDate("comtdate");
			 int comtrate = rs.getInt("comtrate");
			 int comtnum = rs.getInt("comtnum");
			
			 drama_commentVO comtData = new drama_commentVO(unum, dnum, comtcont, comtdate, comtrate, comtnum);
			 comtList.add(comtData);
		 }
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException es) {
				es.printStackTrace();
			}
		}
		return comtList;
	}

	
	public void insertComt(int unum, int dnum, String comtcont, int comtrate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO drama_comment(unum,dnum,comtcont,comtrate) Values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, unum);
			pstmt.setInt(2, dnum);
			pstmt.setString(3, comtcont);
			pstmt.setInt(4, comtrate);

			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletComt() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "DELECT FROM drama_comment WHERE comtnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 0);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
