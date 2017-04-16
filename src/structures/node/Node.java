package structures.node;

/**
 * Created by channel on 2017/4/16.
 */
public class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T dat){
        data=dat;
        next=null;

    }
}
