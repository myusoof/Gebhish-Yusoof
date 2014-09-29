package SqlConnector


import com.mysql.jdbc.Connection

import com.mysql.jdbc.Statement
import java.sql.DriverManager

import java.sql.ResultSet

/**
 * Created by yusoof on 28/09/14.
 */
class SqlUtils implements SqlInterceptor{

    static final String JDBC_DRIVER = 'com.mysql.jdbc.Driver'
    static final String DB_URL = "jdbc:mysql://localhost/yusoof";

    //  Database credentials
    static final String USER = "yusoof";
    static final String PASS = "equalexperts";

    static Connection conn = null;
    static Statement stmt = null;

    @Override
    static void connectToSqlServer() {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS)
    }

    @Override
    static void createTable(String tableName) {
        connectToSqlServer()
        stmt.executeUpdate("create table ${tableName} (id varchar(20))")
    }

    @Override
    static void dropTable(String tableName) {
        connectToSqlServer()
        stmt.executeUpdate("Drop table ${tableName}")
    }

    @Override
    static void insertContent() {
        String sql;
        sql = "SELECT id, first, last, age FROM Employees";
        ResultSet rs = stmt.executeQuery(sql);
    }

    @Override
    static void deleteContent(tablename, key, value) {
       String sql = "delete from ${tablename} where ${key} = ${value}"
       stmt.executeUpdate(sql)
    }


    @Override
    static void updateContent() {

    }

    @Override
    static void fetchContent(String sqlQuery) {
        connectToSqlServer()
        stmt = conn.createStatement();
        sqlQuery = "select * from firsttable"
        ResultSet rs = stmt.executeQuery(sqlQuery)
        while(rs.next()){
            println rs.getString("firstcolumn")
        }

    }

}