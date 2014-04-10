import java.util.logging.LogRecord

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 05/04/14
 * Time: 00:04
 * To change this template use File | Settings | File Templates.
 */
class XmlPraserExample {

    public static void main(String[] args) {
        def xmlString = '''
        <records>
      <car name='HSV Maloo' make='Holden' year='2006'>
        <country>Australia</country>
        <record type='speed'>Production Pickup Truck with speed of 271kph</record>
      </car>
      <car name='P50' make='Peel' year='1962'>
        <country>Isle of Man</country>
        <record type='size'>Smallest Street-Legal Car at 99cm wide and 59 kg in weight</record>
      </car>
      <car name='Royale' make='Bugatti' year='1931'>
        <country>France</country>
        <record type='price'>Most Valuable Car at $15 million</record>
      </car>
    </records>
    '''

        def record12 = new XmlParser().parseText(xmlString)
        println record12.car.size()
        println record12
        def list1 = record12.car.'@make'.collect {if(it.contains("e"))
            it
        }
        println list1.removeAll {it = null}
    }

}
