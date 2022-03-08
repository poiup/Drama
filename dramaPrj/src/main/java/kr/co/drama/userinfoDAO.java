package kr.co.drama;

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
		
}
