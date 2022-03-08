package kr.co.drama;

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
}
