package structures.linear;

import java.util.NoSuchElementException;

/**
 * Created by channel on 2017/4/17.
 * 本例中栈stack使用LinkedList作为组件储存stack中的元素
 * 由于从前端删除节点可以在O(1)时间完成，而在后端删除则需要O(n)的时间
 * 所以选择链表前端作为栈的顶部
 * 这是由于LinkedList是单向链表
 */
public class Stack<T> {
    LinkedList<T> list;
    int cursor;

    public Stack(){
        list=new LinkedList<T>();
        cursor=-1;
    }

    public void push(T item){
        if(list.isEmpty()){
            list.add(item);
        }
        else {
            list.insertAt(item, 0);
        }
    }

    public T pop(){
        if(list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.removeAt(0);
    }

    public int size(){return list.size();}
    public boolean isEmpty(){return list.isEmpty();}
    public void clear(){list.clear();}

    public T first(){
        if(list.isEmpty())
            return null;
        cursor=0;
        return list.getAt(0);
    }
    public T next(){
        if(cursor<0||cursor==list.size()-1)
            return null;
        cursor++;
        return list.getAt(cursor);
    }


}
