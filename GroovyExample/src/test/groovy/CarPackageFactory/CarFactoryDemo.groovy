package CarPackageFactory

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/04/14
 * Time: 23:36
 * To change this template use File | Settings | File Templates.
 */
class CarFactoryDemo {
    public static void main(String[] args) {
        CarFactory.buildCar(CarType.SMALL)
        CarFactory.buildCar(CarType.SEDAN)
        Car luxuryCar = CarFactory.buildCar(CarType.LUXURY)
        println luxuryCar.model.values()
        println CarType.valueOf("SMALL")
    }
}
