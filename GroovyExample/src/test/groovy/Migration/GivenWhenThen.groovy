package Migration

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 03/02/14
 * Time: 18:45
 * To change this template use File | Settings | File Templates.
 */
class GivenWhenThen {
    void given(func, args = null) {
        callClosure(func, args)
    }


    def callClosure = { Closure func, args ->
        if (args == null) {
            func()
        } else {
            func.call(args)
        }

    }
}
