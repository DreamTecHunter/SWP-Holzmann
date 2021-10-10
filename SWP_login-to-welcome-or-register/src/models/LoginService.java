package models;

import java.sql.Connection;

import javax.servlet.ServletException;

public class LoginService {
	private static LoginService instance = null;

	private LoginService() {
	}

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	public boolean canLogin(String user, String password)
			throws ServletException {
		System.out.println(user + password);
		DBManager db = DBManager.getInstance();
		Connection con = null;
		boolean success = false;
		try {
			con = db.getConnection();
			success = db.canLogin(con, user, password);
		} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
		}finally{
			try{
				if(con != null){
						db.relesaeConnection(con);
				}
			
			}catch(Exception ex){
				throw new ServletException(ex.getMessage());
			}
		}
		return success;
	}
}
