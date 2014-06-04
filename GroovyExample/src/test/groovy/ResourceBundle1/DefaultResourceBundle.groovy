package ResourceBundle1

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 24/05/14
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
class DefaultResourceBundle extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[0][]  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = [["price", new Double(75.00)],["currency", "EUR"]]
}
