/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 29/08/14
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */
class GenericMethodOne<T> {
    T t

    T getT(){
      return t
    }

    void setT(T t){
        this.t = t
    }

    String NonGenericMethod(T t){
         return t.getClass().getName()
    }
    public <K extends Integer> K genericMethod(K k){
        println k.getClass().name
       return k.intValue()
    }

    public <K> K boundedGenericMethod(K k){
        return k
    }

    public static void main(String[] args) {
        GenericMethodOne<Integer>  integerGenericMethodOne = new GenericMethodOne<>()
        integerGenericMethodOne.setT(new Integer(12))
        integerGenericMethodOne.NonGenericMethod(new Integer(12))
        Integer abc1 = integerGenericMethodOne.genericMethod(12)
        String abc = integerGenericMethodOne.genericMethod(new Integer(1))
        println abc
        println abc1

        Object object1 = new Object()
        Integer integer = new Integer(10)
        object1 = integer
        println object1 instanceof Integer
    }
}

