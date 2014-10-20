package EnumPackage

/**
 * Created by yusoof on 19/10/14.
 */
public enum TIMEUNIT1 {

    NANOSECONDS(1),
    MICROSECONDS(2),
    MILLISECONDS(3),
    SECONDS(4),
    MINUTES(5),
    HOURS(6),
    DAYS(7)

    private int time;
   // public abstract Integer abstractInt()



    private TIMEUNIT1(int time){
        this.time = time
    }

    public getTime(){
        return time
    }
    @Override
    String toString(){
        this.name().concat(" value")
    }

    String getIntegerValue(){
        switch(this){
            case NANOSECONDS:
                time + " nanoseconds"
                break
            case MICROSECONDS:
                time + " microseconds"
                break
            case MILLISECONDS:
                time + " milliseconds"
                break
            case SECONDS:
                time + " seconds"
                break
            case MINUTES:
                time + " minutes"
                break
            case HOURS:
                time + " hours"
                break
            default:
                time + " days"
        }
    }
}