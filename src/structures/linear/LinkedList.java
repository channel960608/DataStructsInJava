package structures.linear;

import structures.node.*;

import java.util.NoSuchElementException;

/**
 * Created by channel on 2017/4/16.
 * 插入 add,insert
 * 删除 remove，removeAt，removeAll，clear
 * 更新 setAt
 * 访问 getAt，indexOf，size，isEmpty
 *
 *
 */
public class LinkedList<T> {
    public Node<T> tail;
    public int count;

    public LinkedList(){
        tail=null;
        count=0;
    }
    public boolean contains(T item){return indexOf(item)>=0;}
    public int size(){return count;}
    public boolean isEmpty(){return count==0;}
    public void add(T item){
        Node<T> itemnode=new Node<T>(item);
        if(count==0)
            itemnode.next=itemnode;
        else {
            itemnode.next = tail.next;
            tail.next=itemnode;
        }
        tail=itemnode;
        count++;
    }
    public void insertAt(T item,int index){
        //书上没有检查添加的元素在链表最后的情况，此时需要将tail设置为新添加的元素
//        if(index<0||index>count)
//            throw new IndexOutOfBoundsException(index+" <0 or > "+ count);
        //modify
        if(index<0||index>count-1)
            throw new IndexOutOfBoundsException(index+" <0 or > "+ count);
        if(index==count)
            add(item);
        else{
            Node<T> pred=tail;
            for(int i=0;i<index;i++)
                pred=pred.next;
            Node<T> itemnode=new Node<T>(item);
            itemnode.next=pred.next;
            pred.next=itemnode;
            count++;
            }
    }
    public void remove(T item){
        int i=indexOf(item);
        if(i==-1)
            throw new NoSuchElementException();
        removeAt(i);
    }
    public T removeAt(int index){
        if(index<0||index>=count)
            throw new IndexOutOfBoundsException(index+" <0 or >="+count);
        T ret=null;
        if(index==0){
            ret=tail.next.data;
            if(count==1)
                tail=null;
            else
                tail.next=tail.next.next;
            count--;
        } else{
            Node<T> prev=tail.next;
            for(int i=0;i<index;i++)
                prev=prev.next;
            Node<T> curr=prev.next;
            ret=curr.data;
            prev.next=curr.next;
            curr.next=null;
            count--;
            if(curr==tail)
                tail=prev;
        }
        return ret;
    }
    public void removeAll(T item){
        if(count==0)
            throw new NoSuchElementException();
        Node<T> prev=tail;
        Node<T> curr=prev.next;
        int oldcount=count;
        for(int i=0;i<oldcount;i++){
            if(item.equals(curr.data)){
                prev.next=curr.next;
                curr.data=null;
                curr.next=null;
                count--;
            }else{
                prev=curr;
            }
            curr=prev.next;

        }
        if(count==oldcount){
            throw new NoSuchElementException();
        }
        if(count==0)
            tail=null;
        else
            tail=prev;
    }
    public void clear(){tail=null;count=0;}
    public void setAt(T item,int index){
        if(index<0||index>=count)
            throw new IndexOutOfBoundsException(index+" <0 or >="+count);

        Node<T> curr=tail.next;
        for(int i=0;i<index;i++)
            curr=curr.next;
        curr.data=item;
    }
    public T getAt(int index){
        if(index<0||index>=count)
            throw new IndexOutOfBoundsException(index+" <0 or >="+count);
        Node<T> curr=tail.next;
        for(int i=0;i<index;i++)
            curr=curr.next;
        return  curr.data;
        }

    public int indexOf(T item){
        if(count==0)
            return -1;

        Node<T> curr=tail.next;
        for(int i=0;i<count;i++){
            if(curr.data.equals(item))
                return i;
            curr=curr.next;
        }
        return -1;
    }




}
