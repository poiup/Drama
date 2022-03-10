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
	
	// 드라마 추가구문
	public void dramaInsert	(String dname, int dprice, String dgenre, String ddate, int dage, String dthumb, String dvideo, String dtext, String[] actname) throws SQLException {
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
			// 배우 이름이 null이 아니라면 실행
			if(actname!=null) {
				// 제일 높은 dnum( 제일 최근생성된 dnum)을 가져옴 
				sql = "SELECT * FROM dramainfo WHERE dnum = (SELECT max(dnum) from dramainfo)";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				int dnum = rs.getInt("dnum");
				// 제일 최근생성된 dnum을 외래키로 넣어주고 actname을 넣음
				// , 를 기준으로 잘라 이름을 배열로 저장해 향상된 for문을 돌려 여러 배우를 나눠서 저장
				for(String name : actname) {
					sql = "insert into actor (actname, dnum) value (?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setInt(2, dnum);
					insert = pstmt.executeUpdate();
				}
				rs.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}

	// 드라마 조회구문
	public dramainfoVO dramaDetail(int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		dramainfoVO dramaDetail = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "SELECET * FROM dramainfo WHERE dnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dnum);
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			// 배우 이름이 null이 아니라면 실행
			
			if(rs.next()) {
				String dname = rs.getString("dname");
				int dprice = rs.getInt("dprice"); 
			    String dgenre = rs.getString("dgenre"); 
			    Date ddate = rs.getDate("ddate");
			    int dage = rs.getInt("dage"); 
			    int dNum = rs.getInt("dNum");
			    String dthumb = rs.getString("dthumb"); 
			    String dvideo = rs.getString("dvideo");
			    String dtext = rs.getString("dtext");
			    dramaDetail = new dramainfoVO(dname,dprice,dgenre,ddate,dage,dNum,dthumb,dvideo,dtext);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
			rs.close();
		}
		return dramaDetail;
	}

	public void dramaUpdate(String dname, int dprice, String dgenre, String ddate, int dage, String dthumb, String dvideo, String dtext, String[] actname, int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db연결
			con = ds.getConnection();
			//쿼리 작성
			String sql = "UPDATE dramainfo SET dname = ?, dprice = ?, dgenre = ?, ddate = ?, dage = ?, dthumb = ?, dvideo = ?, dtext = ? WEHRE dnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setInt(2, dprice);
			pstmt.setString(3, dgenre);
			pstmt.setString(4, ddate);
			pstmt.setInt(5, dage);
			pstmt.setString(6, dthumb);
			pstmt.setString(7, dvideo);
			pstmt.setString(8, dtext);	
			pstmt.setInt(9, dnum);
			//쿼리 실행
			int insert = pstmt.executeUpdate();
			// 배우 이름이 null이 아니라면 실행
			if(actname!=null) {
				for(String name : actname) {
					sql = "insert into actor (actname, dnum) value (?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setInt(2, dnum);
					insert = pstmt.executeUpdate();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}
}
