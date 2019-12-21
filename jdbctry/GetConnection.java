package jdbctry;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class GetConnection {

	public Object connectionobj() {
		Connection connection;
		try {
			Class.forName("org.postgresql.Driver");
			
			Properties ps = new Properties();
			ps.load(new FileInputStream("C://Users/Mahi/workspace/PDFConveter/src/my.property"));

			String user = ps.getProperty("user");
			String pass = ps.getProperty("password");
			String dburl = ps.getProperty("dburl");

			connection = DriverManager.getConnection(dburl, user, pass);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
