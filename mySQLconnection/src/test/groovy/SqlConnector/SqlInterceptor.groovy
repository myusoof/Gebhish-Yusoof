package SqlConnector

/**
 * Created by yusoof on 28/09/14.
 */
public interface SqlInterceptor {

    void connectToSqlServer()

    void insertContent()

    void deleteContent(tablename, key, value)

    void updateContent()

    void fetchContent(String sqlQuery)

    void createTable(String tableName)

    void dropTable(String tableName)
}