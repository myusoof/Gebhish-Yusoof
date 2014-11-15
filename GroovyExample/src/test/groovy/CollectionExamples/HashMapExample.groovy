package CollectionExamples

/**
 * Created by yusoof on 11/11/14.
 */
class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> hashMapEx = new HashMap<>()
        hashMapEx.put(1, "Audi")
        hashMapEx.put(2, "Audi1")
        hashMapEx.put(3, "Audi2")
        hashMapEx.put(4, "Audi3")
        hashMapEx.put(null, "Audi3")
        println hashMapEx.get(1)
        println hashMapEx.getForNullKey()
    }
}
