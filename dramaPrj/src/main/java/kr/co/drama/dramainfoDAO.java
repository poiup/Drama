package kr.co.drama;

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
}
