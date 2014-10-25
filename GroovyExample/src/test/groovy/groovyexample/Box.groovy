package groovyexample
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 29/08/14
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
class Box<T> {
    T t
    public Box(){
        this.t = t
    }

    T getT() {
        return t
    }

    void setT(T t) {
        this.t = t
    }

    public <K> void genericMethod(K k){
        println k.getClass().getName()
    }

    public <K extends T> void boundedGenericMethod(K k){
        println k.getClass().name
    }
}
