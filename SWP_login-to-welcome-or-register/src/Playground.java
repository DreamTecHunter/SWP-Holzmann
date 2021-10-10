import java.sql.Connection;

import models.DBManager;

/**
 * 
 * @author Tobias
 * Containing a Main, used for debugging.
 */
public class Playground {
	public static void main(String[]args) throws Exception{
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConnection();
		
		System.out.println(dbm.canLogin(con, "DreamTecHunter", "admin"));
	}
}
