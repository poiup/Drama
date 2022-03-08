package kr.co.drama;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class actorDAO {
	private DataSource ds = null;;
	
	private static actorDAO dao = new actorDAO();
	
	private actorDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static actorDAO getInstance() {
		if(dao == null) {
			dao = new actorDAO();
		}
		return dao;
	}
}