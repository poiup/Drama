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
	
	// �뱶�씪留� 異붽�援щЦ
	public void dramaInsert	(String dname, int dprice, String dgenre, String ddate, int dage, String dthumb, String dvideo, String dtext, String[] actname) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db�뿰寃�
			con = ds.getConnection();
			//荑쇰━ �옉�꽦
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
			//荑쇰━ �떎�뻾
			int insert = pstmt.executeUpdate();
			// 諛곗슦 �씠由꾩씠 null�씠 �븘�땲�씪硫� �떎�뻾
			if(actname!=null) {
				// �젣�씪 �넂�� dnum( �젣�씪 理쒓렐�깮�꽦�맂 dnum)�쓣 媛��졇�샂 
				sql = "SELCET * FROM dramainfo WHERE dnum = (SELECT max(dnum) from dramainfo)";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				int dnum = rs.getInt("dnum");
				// �젣�씪 理쒓렐�깮�꽦�맂 dnum�쓣 �쇅�옒�궎濡� �꽔�뼱二쇨퀬 actname�쓣 �꽔�쓬
				// , 瑜� 湲곗��쑝濡� �옒�씪 �씠由꾩쓣 諛곗뿴濡� ���옣�빐 �뼢�긽�맂 for臾몄쓣 �룎�젮 �뿬�윭 諛곗슦瑜� �굹�닠�꽌 ���옣
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

	// �뱶�씪留� 議고쉶援щЦ
	public dramainfoVO dramaDetail(int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		dramainfoVO dramaDetail = null;
		try { 
			// db�뿰寃�
			con = ds.getConnection();
			//荑쇰━ �옉�꽦
			String sql = "SELECT * FROM dramainfo WHERE dnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dnum);
			
			//荑쇰━ �떎�뻾
			rs = pstmt.executeQuery();	
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
	
	// �뱶�씪留� �닔�젙
	public void dramaUpdate(String dname, int dprice, String dgenre, String ddate, int dage, String dthumb, String dvideo, String dtext, String[] actname, int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db�뿰寃�
			con = ds.getConnection();
			//荑쇰━ �옉�꽦
			String sql = "UPDATE dramainfo SET dname = ?, dprice = ?, dgenre = ?, ddate = ?, dage = ?, dthumb = ?, dvideo = ?, dtext = ? WHERE dnum = ?";
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
			//荑쇰━ �떎�뻾
			int insert = pstmt.executeUpdate();
			// 諛곗슦 �씠由꾩씠 null�씠 �븘�땲�씪硫� �떎�뻾
			List<actorVO> actorList = actorDAO.getInstance().actorList(dnum);
			if(actorList!=null) {
				int i =0;
				for(actorVO actor : actorList) {
					sql = "UPDATE actor SET actname=? WHERE actnum=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, actname[i]);
					pstmt.setInt(2, actor.getActnum());
					insert = pstmt.executeUpdate();
					System.out.println(pstmt);
					i++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}

	//�뱶�씪留� �궘�젣
	public void dramaDelete(int dnum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try { 
			// db�뿰寃�
			con = ds.getConnection();
			//荑쇰━ �옉�꽦
			String sql = "DELETE FROM dramainfo WHERE dnum = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dnum);
			//荑쇰━ �떎�뻾
			int insert = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			con.close();
			pstmt.close();
		}
	}

	public List<dramainfoVO> SelectAllDrama(){

		List<dramainfoVO> userList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			
			String sql = "SELECT *  FROM dramainfo";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String dname = rs.getString("dname");
				String dthumb = rs.getString("dthumb");
				String dgenre = rs.getString("dgenre");
				int dpric = rs.getInt("dprice");
				int dage = rs.getInt("dage");
				Date ddate = rs.getDate("ddate");
				int dnum = rs.getInt("dnum");
				String dvideo = rs.getString("dvideo");
				String dtext = rs.getString("dtext");

				dramainfoVO userData = new dramainfoVO(dname,dpric,dgenre,ddate,dage,dnum,dthumb,dvideo,dtext);
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


	public List<dramainfoVO> SearchValuesByName(String searching){

		List<dramainfoVO> userList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			
			String sql = "SELECT *  FROM dramainfo where dname like ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "%"+searching+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String dname = rs.getString("dname");

				String dthumb = rs.getString("dthumb");
				String dgenre = rs.getString("dgenre");
				int dpric = rs.getInt("dprice");
				int dage = rs.getInt("dage");
				Date ddate = rs.getDate("ddate");
				int dnum = rs.getInt("dnum");
				String dvideo = rs.getString("dvideo");
				String dtext = rs.getString("dtext");

				dramainfoVO userData = new dramainfoVO(dname,dpric,dgenre,ddate,dage,dnum,dthumb,dvideo,dtext);
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

	public List<dramainfoVO> SearchValuesByactor(String searching){

		List<dramainfoVO> userList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			
			String sql = "SELECT *  FROM dramainfo where dnum = (SELECT dnum  FROM actor where actname like ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "%"+searching+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String dname = rs.getString("dname");

				String dthumb = rs.getString("dthumb");
				String dgenre = rs.getString("dgenre");
				int dpric = rs.getInt("dprice");
				int dage = rs.getInt("dage");
				Date ddate = rs.getDate("ddate");
				int dnum = rs.getInt("dnum");
				String dvideo = rs.getString("dvideo");
				String dtext = rs.getString("dtext");

				dramainfoVO userData = new dramainfoVO(dname,dpric,dgenre,ddate,dage,dnum,dthumb,dvideo,dtext);
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
	
	public List<dramainfoVO> SearchValuesByGenre(String searching){

		List<dramainfoVO> userList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			
			String sql = "SELECT *  FROM dramainfo where dgenre like ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "%"+searching+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String dname = rs.getString("dname");

				String dthumb = rs.getString("dthumb");
				String dgenre = rs.getString("dgenre");
				int dpric = rs.getInt("dprice");
				int dage = rs.getInt("dage");
				Date ddate = rs.getDate("ddate");
				int dnum = rs.getInt("dnum");
				String dvideo = rs.getString("dvideo");
				String dtext = rs.getString("dtext");

				dramainfoVO userData = new dramainfoVO(dname,dpric,dgenre,ddate,dage,dnum,dthumb,dvideo,dtext);
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
}

