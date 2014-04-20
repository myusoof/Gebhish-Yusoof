package CarPackageFactory

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/04/14
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public abstract class Car {

    private CarType model = null

    public Car(CarType model){
        this.model = model
        arrangeParts()
    }

    private void arrangeParts(){
        println "following are the part of the car"
    }

    protected abstract void construct()

    CarType getModel() {
        return model
    }

    void setModel(CarType model) {
        this.model = model
    }
}
