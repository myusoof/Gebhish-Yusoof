package calc
/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 13/04/14
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class Calculator1 {
    List<Double> stack = new ArrayList<Double>();

    public void push(double arg) {
        stack.add(arg);
    }

    public double divide() {
        return stack.get(0) / stack.get(1);
    }
}
