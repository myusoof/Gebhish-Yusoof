package CollectionExamples

/**
 * Created by yusoof on 11/11/14.
 */
class StackExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack()
        println stack.isEmpty()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)
        println stack.isEmpty()
        println stack.peek()
        println stack.pop()
        println stack.peek()

        println stack.search(4)
    }
}
