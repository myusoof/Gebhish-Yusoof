package EnumPackage

/**
 * Created by yusoof on 19/10/14.
 */
class TimeEnumExample {
    public static void main(String[] args) {
        println TIMEUNIT1.values()
        println TIMEUNIT1.valueOf('DAYS')
        println TIMEUNIT1.DAYS.time
        println TIMEUNIT1.DAYS.integerValue
        println TIMEUNIT1.NANOSECONDS.abstractInt()
    }
}
