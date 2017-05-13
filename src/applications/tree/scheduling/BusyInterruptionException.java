package applications.tree.scheduling;

/**
 * Created by channel on 2017/5/13.
 */
public class BusyInterruptionException extends Exception {
    public BusyInterruptionException(){super();}
    public  BusyInterruptionException(String s){
        super(s);
    }
}
