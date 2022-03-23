package kr.co.drama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class userinfoDAO {
		
		private DataSource ds = null;;
		
		private static userinfoDAO dao = new userinfoDAO();
		
		private userinfoDAO() {
			try {
				Context ct = new InitialContext();
				ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static userinfoDAO getInstance() {
			if(dao == null) {
				dao = new userinfoDAO();
			}
			return dao;
		}
		
		public List<userinfoVO> getAllUserList(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<userinfoVO> userList = new ArrayList<>();
			try {
				con = ds.getConnection();
				String sql = "SELECT * FROM userinfo";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String uId = rs.getString("uid");
					String uPw = rs.getString("upw");
					String uName = rs.getString("uname");
					int uAge = rs.getInt("uage");
					int uNum = rs.getInt("unum");
					String uCredit = rs.getString("ucredit");
					String uAddress = rs.getString("uadress");
					String uNick = rs.getString("unick");
					int uPoint = rs.getInt("upoint");
					
					userinfoVO userData = new userinfoVO(uId, uPw, uName, uAge, uNum, uCredit, uAddress, uNick, uPoint);
					userList.add(userData);
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
			return userList;
		}

		public userinfoVO getUserData(String fId) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			userinfoVO user = null;
			try {
				con = ds.getConnection();
				String sql = "SELECT * FROM userinfo WHERE uid = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fId);
					
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String uId = rs.getString("uid");
					String uPw = rs.getString("upw");
					String uName = rs.getString("uname");
					int uAge = rs.getInt("uage");
					int uNum = rs.getInt("unum");
					String uCredit = rs.getString("ucredit");
					String uAddress = rs.getString("uadress");
					String uNick = rs.getString("unick");
					int uPoint = rs.getInt("upoint");
					user = new userinfoVO(uId, uPw, uName, uAge, uNum, uCredit, uAddress, uNick, uPoint);
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
			return user;
		}
		
		public void userUpdateCheck(String uId, String uPw, String uNick, String uName, int uAge, String uCredit , String uAddress) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				
				String sql =  "UPDATE userinfo SET upw=?, unick=?, uname=?, uage=?, ucredit=?, uadress=? WHERE uid=?";
				pstmt = con.prepareStatement(sql);// 쿼리문 세팅
				pstmt.setString(1, uPw);
				pstmt.setString(2, uNick);
				pstmt.setString(3, uName);
				pstmt.setInt(4, uAge);
				pstmt.setString(5, uCredit);
				pstmt.setString(6, uAddress);
				pstmt.setString(7, uId);
				
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
		
		public void deleteUser(String sId) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				
				String sql =  "DELETE FROM userinfo WHERE uid=?";
				pstmt = con.prepareStatement(sql);// 쿼리문 세팅
				pstmt.setString(1, sId);

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
		
		public void insertUser(String uId, String uPw,String uName, String uNick, int uAge,String uCredit,String uAdress) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				
				String sql =  "INSERT INTO userinfo (uid,upw,uname,uage,ucredit,uadress,unick) VALUE (?,?,?,?,?,?,?);";
				pstmt = con.prepareStatement(sql);// 쿼리문 세팅
				pstmt.setString(1, uId);
				pstmt.setString(2, uPw);
				pstmt.setString(3, uName);
				pstmt.setInt(4, uAge);
				pstmt.setString(5, uCredit);
				pstmt.setString(6, uAdress);
				pstmt.setString(7, uNick);
				System.out.println(pstmt);
				int insert = pstmt.executeUpdate();
				
				
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
		
		
		public userinfoVO getUserData2(int uNumber) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			userinfoVO user2 = null;
			try {
				con = ds.getConnection();
				String sql = "SELECT * FROM userinfo WHERE unum = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, uNumber);
					
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String uId = rs.getString("uid");
					String uPw = rs.getString("upw");
					String uName = rs.getString("uname");
					int uAge = rs.getInt("uage");
					int uNum = rs.getInt("unum");
					String uCredit = rs.getString("ucredit");
					String uAddress = rs.getString("uadress");
					String uNick = rs.getString("unick");
					int uPoint = rs.getInt("upoint");
					user2 = new userinfoVO(uId, uPw, uName, uAge, uNum, uCredit, uAddress, uNick, uPoint);
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
			return user2;
		}
}
