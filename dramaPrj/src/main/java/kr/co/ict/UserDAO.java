package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DAO 클래스는 DB연동을 전담하여 처리합니다.
public class UserDAO {

	
	private DataSource ds = null;
	private static UserDAO dao = new UserDAO();
	private UserDAO() {
		try {
			Context ct = new InitialContext();
			
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	public List<UserVO> getAllUserList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> userList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM userinfo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String uId = rs.getString("uid");
				String uPw = rs.getString("upw");
				String uNick = rs.getString("unick");
				String uAge = rs.getString("uage");
				String uCredit = rs.getString("ucredit");
				String uAddress = rs.getString("uaddress");
				
				UserVO userData = new UserVO(uId, uPw, uNick, uAge, uCredit, uAddress);
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

	public UserVO getUserData(String sId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM userinfo WHERE uid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String uId = rs.getString("uid");
				String uPw = rs.getString("upw");
				String uNick = rs.getString("unick");
				String uAge = rs.getString("uage");
				String uCredit = rs.getString("ucredit");
				String uAddress = rs.getString("uaddress");
				user = new UserVO(uId, uPw, uNick, uAge, uCredit, uAddress);
			}else {
				System.out.println(sId);
				System.out.println(sql);
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
	

	public void updateCheck(String uId, String uPw, String uNick, String uAge, String uCredit , String uAddress) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql =  "UPDATE userinfo SET upw=?, unick=?, uage=?, ucredit=?, uaddress=? WHERE uid=?";
			pstmt = con.prepareStatement(sql);// 쿼리문 세팅
			pstmt.setString(1, uPw);
			pstmt.setString(2, uNick);
			pstmt.setString(3, uAge);
			pstmt.setString(4, uCredit);
			pstmt.setString(5, uAddress);
			pstmt.setString(6, uId);
			
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
	
	public void insertUser(String uId, String uPw, String uNick, String uAge,String uCredit,String uAddress) {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("2. uAddress : " + uAddress);

		
		try {
			con = ds.getConnection();
			
			String sql =  "INSERT INTO userinfo VALUES(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);// 쿼리문 세팅
			pstmt.setString(1, uId);
			pstmt.setString(2, uPw);
			pstmt.setString(3, uNick);
			pstmt.setString(4, uAge);
			pstmt.setString(5, uCredit);
			pstmt.setString(6, uAddress);
			

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
}
