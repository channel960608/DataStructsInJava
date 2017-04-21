package structures.linear;


import java.util.NoSuchElementException;

/**
 * Created by channel on 2017/4/16.
 * 使用ArrayList作为队列的基础容器能够实现队列的动态增长，但是在增加或删除
 * 元素时会遇到很大的麻烦，势必会浪费很多的时间或者很多空间
 * 因此，我们选择链表作为实现队列的基础
 * 因为Java版本不同，LinkedList类的部分方法进行了改动，因此我对书上的内容作了相应的改动
 * ------------------------------------------------------------------------------------
 * 之前调用的是util.LinkedList,在重写了LinkedList类之后，还是采用原有的编码
 */
public class Queue<T> {
    LinkedList<T> list;
    int cursor;

    public Queue(){
        list=new LinkedList<T>();
        cursor=-1;
    }

    public void enqueue(T item){
        list.add(item);
    }
    public T dequeue(){
        if(list.isEmpty())
            throw new NoSuchElementException();
        return list.removeAt(0);
    }
    public int size(){return list.size();}
    public boolean isEmpty(){return list.isEmpty();}
    int positionOf(T item){return list.indexOf(item);}
    void clear(){list.clear();}
    void remove(T item){list.remove(item);}
    //删除指定项的所有出现,书上直接使用了list.removeAlll(T item)方法，但在Java 1.8中已经没有这个方法
    void removeAll(T item){
        list.removeAll(item);
    }

    public T first(){
        if(list.size()==0)
            return null;
        cursor=0;
        return list.getAt(cursor);
    }
    public T next(){
        if(cursor<0||cursor==list.size()-1)
            return null;
        cursor++;
        return list.getAt(cursor);
    }

}
