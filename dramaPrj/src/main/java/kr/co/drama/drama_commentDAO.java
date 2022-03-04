package kr.co.drama;

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
}
