package sample;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnector {
    private String databaseUrl;
    private String userName;
    private String password;
    private Connection connection = null;

    public JDBCConnector(String databaseUrl, String userName, String password) {
        this.databaseUrl = databaseUrl;
        this.userName = userName;
        this.password = password;
    }

    private Connection getConnection() throws Exception {

        if(connection == null){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(databaseUrl,userName,password);
            System.out.println("Connect successfully");
            return connection;
        }else{
            return connection;
        }

    }

    public ResultSet query(String queryStatement) throws Exception {

        Connection conn = getConnection();

        var statement = conn.createStatement();
        return statement.executeQuery(queryStatement);

    }
    public void closeConnection () throws SQLException {
        if(connection!=null){
           connection.close();
        }
    }
}
