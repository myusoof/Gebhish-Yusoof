/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 16/12/13
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;

public class CronTester {

    public static void main(String[] args) throws ParseException {
        final String expression = "0 0 0 1 OCT ?";
        final CronExpression cronExpression = new CronExpression(expression);

        final Date nextValidDate1 = cronExpression.getNextValidTimeAfter(new Date());
        final Date nextValidDate2 = cronExpression.getNextValidTimeAfter(nextValidDate1);

        System.out.println(nextValidDate1);
        System.out.println(nextValidDate2);

    }
}