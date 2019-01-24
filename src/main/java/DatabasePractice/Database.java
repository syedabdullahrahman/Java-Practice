package DatabasePractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database {

	private static Database dbIsntance;
	private static Connection con;
	private static Logger logger = LoggerFactory.getLogger(Database.class);
	private static final String DATABASE_CONNECTION = "jdbc:h2:tcp://localhost/~/test";
	private static final String DATABASE_USER = "sa";
	private static final String DATABASE_PASSWORD = "";

	private Database() {

	}
	public static Database getInstance() {
		if (dbIsntance == null) {
			dbIsntance = new Database();
		}
		return dbIsntance;
	}
	public Connection getConnection(){
        if(con==null){
            try {
                con = DriverManager.getConnection(DATABASE_CONNECTION, DATABASE_USER, DATABASE_PASSWORD );
            } catch (SQLException ex) {
            	logger.error("Databasae Connection Exception occurs :"+ex.toString());
            }
        }
        return con;
    }
}