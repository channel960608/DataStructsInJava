package structures.tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by channel on 2017/5/13.
 */
public class Heap<T extends Comparable<T>> {
    ArrayList<T> items;
    int cursor;

    public Heap(int cap){
        items=new ArrayList<T>(cap);
        cursor=-1;
    }
    public  Heap(){
        items=new ArrayList<T>();
        cursor=-1;
    }

    void siftUp(int index){
        T me=items.get(index);
        while(index>0){
            int pindex=(index-1)/2;
            T myparent=items.get(pindex);
            if(me.compareTo(myparent)>0){
                items.set(index,myparent);
                index=pindex;
            }
            else break;
        }
        items.set(index,me);
    }
    void siftDown(int index){
        T me=items.get(index);
        int lindex=2*index+1;
        while(lindex<items.size()){
            T maxChild = items.get(lindex);
            int maxIndex=lindex;

            int rindex=lindex+1;
            if(rindex<items.size()){
                T rightChild=items.get(rindex);
                if(rightChild.compareTo(maxChild)>0){
                    maxChild=rightChild;
                    maxIndex=rindex;
                }
            }
            if(maxChild.compareTo(me)>0){
                items.set(index,maxChild);
                index=maxIndex;
                lindex=2*index+1;
            }
            else break;
        }
        items.set(index,me);
    }

    public void add(T item){
        items.add(item);
        siftUp(items.size()-1);
    }

    public T deleteMax(){
        if(items.isEmpty()){
            throw new NoSuchElementException();
        }
        T maxItem=items.get(0);
        T lastItem=items.remove(items.size()-1);

        if(items.isEmpty()){
            return lastItem;
        }
        items.set(0,lastItem);
        siftDown(0);
        return maxItem;
    }

    public void clear(){items.clear();}
    public int size(){return items.size();}
    public boolean isEmpty(){return items.isEmpty();}

    public T first(){
        if(items.size()==0) return null;
        cursor=0;
        return items.get(0);
        }

    public T next() {
        if (cursor < 0 || cursor == (items.size() - 1)) {
            return null;
        }
        cursor++;
        return items.get(cursor);
    }
}
