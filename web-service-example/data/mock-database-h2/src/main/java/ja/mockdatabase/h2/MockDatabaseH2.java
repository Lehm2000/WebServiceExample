package ja.mockdatabase.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server;


public class MockDatabaseH2
{
	Server server;
	
    public MockDatabaseH2() throws SQLException, ClassNotFoundException
    {
    	server = Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers");
    	server.start();
    	
    	Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9123/~/test", "sa", "sa");
        
        Statement statement = conn.createStatement();
        
        String query = "CREATE USER IF NOT EXISTS test PASSWORD test1234";
        
        statement.execute(query);
        
        query = "CREATE TABLE IF NOT EXISTS PERSONS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), AGE INT)";
        
        statement.execute(query);
        	
        conn.close();
    	
    	// stop the TCP Server
    	//server.stop();
    }
}
