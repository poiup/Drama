package kr.co.drama;

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
}
