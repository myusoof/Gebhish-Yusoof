package ResourceBundle1

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 24/05/14
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
class MainDefaultResourceBundle {
    public static void main(String[] args) {
        Locale locale = new Locale("de", "DE")
        ResourceBundle resourceBundle_german = ResourceBundle.getBundle("ResourceBundle1.DefaultResourceBundle", locale)

        //println resourceBundle_german.getObject("price")

    }
}
