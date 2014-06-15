package session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data {

	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:sidtb";
	private String user="scott";
	private String pass="tiger";

	private Connection conn=null;

	public Connection getConn(){
		try {
			Class.forName(driver);
			this.conn=DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.conn;
	}

	public void close(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}