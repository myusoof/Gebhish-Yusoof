import net.masterthought.cucumber.ReportBuilder

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 11/04/14
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
    static void reportingMethod(){
        new ReportBuilder(['target/cucumber.json'], new File('target/report'), "", "1", "Foo", false, false, true, false, false, "", true).generateReports();
    }

