import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 08/06/14
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
class BeanClass implements  BeanPostProcessor{

    @Override
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        println "before after initializatoin ${beanName}"
        return bean  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        println "post after initializatoin ${beanName}"
        return bean  //To change body of implemented methods use File | Settings | File Templates.
    }
}
