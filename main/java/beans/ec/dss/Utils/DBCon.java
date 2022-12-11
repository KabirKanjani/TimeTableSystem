package beans.ec.dss.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class DBCon {
	public static Connection getJDBCConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DBConfig.DB_URL);
		Connection con=DriverManager.getConnection(DBConfig.DB_URL,DBConfig.DB_USER,DBConfig.DB_PWD);
		return con;
	}
	
	public static Connection getConnection() throws SQLException {
		//using postgre specific DataSource class
		PGSimpleDataSource source=new PGSimpleDataSource();
		source.setUrl(DBConfig.DB_URL);
		source.setUser(DBConfig.DB_USER);
		source.setPassword(DBConfig.DB_PWD);
		return source.getConnection();
	}
	
	public static Connection getPooledConnection() throws SQLException {
		PGConnectionPoolDataSource source=new PGConnectionPoolDataSource();
		source.setUrl(DBConfig.DB_URL);
		source.setUser(DBConfig.DB_USER);
		source.setPassword(DBConfig.DB_PWD);
		return source.getConnection();
	}
}