package EnumPackage;



/**
 * Created by yusoof on 19/10/14.
 */
public enum Cars {
    AUDI{
       @Override
       public int getPrice(){
           return 1;
       };
    },
    HONDA{
        @Override
         public int getPrice() {
            return 2;
        }
    },
    BMW{
        @Override
        public int getPrice(){
            return 3;
        }
    };

    public abstract int getPrice();
}
