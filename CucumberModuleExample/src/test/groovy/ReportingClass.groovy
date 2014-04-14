import net.masterthought.cucumber.ReportBuilder

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 14/04/14
 * Time: 09:19
 * To change this template use File | Settings | File Templates.
 */
class ReportingClass {

    public static void main(String[] args) {
        new ReportBuilder(['target/cucumber.json'], new File('target/report'), "", "1", "Foo", false, false, true, false, false, "", true).generateReports();
    }
}
