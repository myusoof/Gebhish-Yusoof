package CarPackageFactory

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/04/14
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
class SmallCar extends Car{
    SmallCar() {
        super(CarType.SMALL)
        construct()
    }

    @Override
    protected void construct() {
        println "Constructing small car"
    }
}
