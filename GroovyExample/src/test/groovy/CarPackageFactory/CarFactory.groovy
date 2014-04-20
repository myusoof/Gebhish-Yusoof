package CarPackageFactory

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/04/14
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
class CarFactory {
    public static Car buildCar(CarType type){
        switch (type){
            case CarType.LUXURY:
                return new LuxuryCar()
                break
            case CarType.SEDAN:
                return new SedanCar()
                break
            case CarType.SMALL:
                return new SmallCar()
            default:
                return null
        }
    }
}
