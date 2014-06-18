import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 08/06/14
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
class ExampleBeanJava implements InitializingBean, DisposableBean{

    void initMethod(){
        println "Method to be initialized"
    }

    @Override
    void afterPropertiesSet() throws Exception {

        println "This is method to be called before initialization"
    }

    @Override
    void destroy() throws Exception {
        "While destruction"
    }
}
