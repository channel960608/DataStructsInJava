package structures.tree;

/**
 * Created by channel on 2017/4/21.
 */
public class TreeViolationException extends RuntimeException {
    public TreeViolationException(){
        super();
    }

    public TreeViolationException(String s){
        super(s);
    }
}
