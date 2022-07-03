
package model;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/*
 * @author Reyna Luis, Trujillo Ronald, Guzman Sebastian, Cruz Danna, Gutierrez Ana
 */
public class ConnectionPool {
    
    private final String DB = "uzIaN7EyF9";
    private final String URL = "jdbc:mysql://remotemysql.com:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "uzIaN7EyF9";
    private final String PASS = "nldtcux9iM";
    
    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource = null;
    
    private ConnectionPool(){
        
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
    }
    
    public static ConnectionPool getInstance(){
        if (dataSource == null){
            dataSource = new ConnectionPool();
            return dataSource;
        } else {
            return dataSource;
        }
    }
    
    public Connection getConnection() throws SQLException{
        return this.basicDataSource.getConnection();
    }
    
    public void closeConnection (Connection connection) throws SQLException{
        connection.close();
    }
}
