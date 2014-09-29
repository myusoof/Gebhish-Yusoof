package SqlConnector

/**
 * Created by yusoof on 28/09/14.
 */
class SQLMain {
    public static void main(String[] args) {
       SqlUtils.fetchContent("select * from firsttable")
//       SqlUtils.createTable("yusoof1")
        SqlUtils.dropTable("yusoof1")
    }
}
