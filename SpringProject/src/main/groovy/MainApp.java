import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 05/06/14
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        System.out.println(helloWorld.getMessage());
        System.out.println(obj.getMessage());
        ExampleBeanJava exampleBeanJava = (ExampleBeanJava)context.getBean("examplebean");
        context.registerShutdownHook();
    }
}
