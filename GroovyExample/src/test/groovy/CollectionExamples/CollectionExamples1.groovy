package CollectionExamples

/**
 * Created by yusoof on 06/09/14.
 */
class CollectionExamples1 {
    public static void main(String[] args) {
        Collection collection = new ArrayList()
        collection.add(2)
        collection.add(3)
        doSomething(collection)
        Set set = new HashSet(3)
        set.add(3)

        doSomething(set)
        NavigableSet set1  = new TreeSet()
        set1.descendingSet()
    }

    public static void doSomething(Collection collection){
        Iterator iterator = collection.iterator()
         while(iterator.hasNext()){
             println iterator.next()
         }
    }
}
