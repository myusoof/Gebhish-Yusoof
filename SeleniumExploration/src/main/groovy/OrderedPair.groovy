/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 29/08/14
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
class OrderedPair<K ,V> implements Pair<K, V>{

    K k;
    V v;

    public OrderedPair(K k, V v){
        this.k = k
        this.v = v
    }

    @Override
    K getK() {
        return k
    }

    @Override
    V getV() {
        return v
    }
}
