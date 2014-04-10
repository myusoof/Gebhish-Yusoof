package SeventhApr

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 07/04/14
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */
class FruitJuice {

     enum FruitJuiceSize{

        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large")

        String juiceSize

        public FruitJuiceSize(String size){
            this.juiceSize = size
        }
    }

    FruitJuiceSize size


    public static void main(String[] args) {
        FruitJuice juice = new FruitJuice()
        println FruitJuice.FruitJuiceSize.SMALL.juiceSize
    }

}
