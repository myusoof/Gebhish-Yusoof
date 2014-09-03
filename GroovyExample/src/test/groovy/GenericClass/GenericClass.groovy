package GenericClass

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 28/08/14
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
class GenericClass<T, K> {
    T t
    K k

    public GenericClass(T t, K k){
        this.t = t
    }

    public GenericClass<Integer, Integer> createGenericClass(){
        return new GenericClass<Integer, Integer>()
    }

    public void genericClassNonGenericMethod(T t, K k){
        println t.getClass().name
        println t.intValue()
        println k.getClass().name
        println t.intValue()
    }



    public static void main(String[] args) {
        GenericClass<Integer, Integer> genericClass = new GenericClass<Integer, Integer>(12, 12)
        genericClass.genericClassNonGenericMethod(new Integer(12), new Integer(12))

        GenericClass rawType = new GenericClass(12, 12)
        GenericClass<Integer,Integer> genericInstance = new GenericClass<Integer, Integer>(12, 12)


        genericInstance = rawType
        genericInstance.genericClassNonGenericMethod(12,12)


        GenericClass<Integer, Integer> create = createGenericClass()
    }
}
