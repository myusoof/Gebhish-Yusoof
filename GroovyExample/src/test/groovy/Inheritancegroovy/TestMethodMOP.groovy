package Inheritancegroovy

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 01/05/14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
class TestMethodMOP {

    public static void main(String[] args) {
        def subClassUsingMop1 = new SubClassUsingMOP(name:'Tom', age:20, nationality:'French', salary:1000)
        describe(subClassUsingMop1)
    }
}
