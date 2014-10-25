import com.thoughtworks.selenium.DefaultSelenium
import com.thoughtworks.selenium.Selenium
import com.thoughtworks.selenium.Selenium.*
import org.jboss.netty.channel.socket.SocketChannel
import org.junit.Before
import org.junit.Test

/**
 * Created by yusoof on 23/10/14.
 */
class SeleniumRCExample {

    @Before
    void setUp(){
       // new ServerStart().start()
//        new Thread().run()
//        ProcessBuilder builder = new ProcessBuilder("java", "-jar","/home/yusoof/projects/o2/Gebhish-Yusoof/SeleniumExploration/src/main/resources/seleniumrc.jar")

    }

    @Test
    void testSeleniumRC(){
/*        Socket socket = new Socket("localhost", 4444)
        while(!socket.isConnected()){
            Thread.sleep(1000)
        }*/

        Thread.sleep(5000)
        Selenium selenium = new DefaultSelenium("localhost", 4444 , "*firefox", "http://the-internet.herokuapp.com");
        selenium.start();
        selenium.open("/")
//        selenium.type("","test")
        selenium.close()

    }

}


