package SeventhApr

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 07/04/14
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
class TestDate {
    public static void main(String[] args) {
        Date date = new Date()
        Date date2  = date.clone()
        println date2.getTime()

        GregorianCalendar calendar = new GregorianCalendar()
        println calendar.time
        println calendar
        println calendar.get(Calendar.MONTH)
    }
}
