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
		
		// select * from drama_comment where dnum = ? order by comtnum DESC;
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
	
	public void deletComt(int comtnum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "delete from drama_comment where comtnum = ?;";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, comtnum);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateComt(String comtcon, int comtnum, int comtrate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "update drama_comment set comtcont = ?, comtrate = ? where comtnum = ?;";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, comtcon);
			pstmt.setInt(2, comtrate);
			pstmt.setInt(3, comtnum);
			
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

	
	public drama_commentVO getComtDetail(int comt_num) {
		// DB연동구문을 작성해보세요.
		// try구문 초입에 ds부분까지만 하셔도 되는데 만약 다 작성 가능하다면 다 작성해보세요.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		drama_commentVO comt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "SELECT * FROM drama_comment WHERE comtnum = ?"; 
			pstmt = con.prepareStatement(sql); 
			pstmt.setInt(1, comt_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				 int unum = rs.getInt("unum");
				 int dnum = rs.getInt("dnum");
				 String comtcont = rs.getString("comtcont");
				 Date comtdate = rs.getDate("comtdate");
				 int comtrate = rs.getInt("comtrate");
				 int comtnum = rs.getInt("comtnum");
				
				comt = new drama_commentVO(unum, dnum, comtcont, comtdate, comtrate, comtnum);
			}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();	
					pstmt.close();
					rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			return comt; 
	}
	
}
