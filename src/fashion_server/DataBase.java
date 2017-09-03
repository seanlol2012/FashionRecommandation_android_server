package fashion_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public Connection getConnection()
    {
    	Connection conn = null;
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/autum_fashion";
    	
    	String user = "root";
    	String password = "123456";
    	
    	try {
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url, user, password);
    		if(!conn.isClosed())
    		{
    			System.out.println("database successful connected\n");
    		}
    		else
    		{
    			System.out.println("database failed to connect\n");
    		}
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return conn;
    }
    
    public void closeConnection(Connection conn)
    {
    	try {
    		conn.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
