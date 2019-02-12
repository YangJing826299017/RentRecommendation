package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	// JDBC 驱动名及数据库 URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
 
    // 数据库的用户名与密码，需要根据自己的设置
    private static final String USER = "root";
    private static final String PASS = "123456";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        // 打开链接
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
		return conn;
	}

}
