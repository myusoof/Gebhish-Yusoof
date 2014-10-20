package EnumPackage

/**
 * Created by yusoof on 19/10/14.
 */
class CarsMap {
    public static void main(String[] args) {
        EnumMap carsMap = new EnumMap<>(Cars.class)

        Cars.values().each {
            carsMap.put(it, it.getPrice())
        }

        carsMap.each {key, value ->
            println key.toString() + " " + value
        }
    }
}
