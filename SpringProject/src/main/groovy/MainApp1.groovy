import org.springframework.context.support.AbstractApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 08/06/14
 * Time: 23:24
 * To change this template use File | Settings | File Templates.
 */
class MainApp1 {
    public static void main(String[] args) {
        AbstractApplicationContext context =
            new ClassPathXmlApplicationContext("TestBean.xml")
        HelloIndia helloIndia = (HelloIndia)context.getBean("HelloIndia")
        HelloWorld1 helloWorld1 = (HelloWorld1)context.getBean("HelloWorld")
        println helloWorld1.getMessage1()
        println helloWorld1.getMessage2()
    }
}
