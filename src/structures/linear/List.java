package structures.linear;

/**
 * Created by channel on 2017/4/17.
 * 基于最底层则最抽象组件LinkedList构造的类List
 * 以后将以直接以List为基础构造其他数据结构
 */
public class List<T> {
    LinkedList<T> elements;
    int cursor;
    public List(){
        elements=new LinkedList();
        cursor=-1;
    }
    public void add(T item){elements.add(item);}
    public int size(){return elements.size();}
    public boolean isEmpty(){return  elements.isEmpty();}
    public boolean contains(T item){return elements.indexOf(item)!=-1;}
    public void remove(T item){elements.remove(item);}
    public void removeAll(T item){elements.removeAll(item);}
    public void clear(){elements.clear();}
    public T first(){
        if(elements.size()==0)
            return null;
        cursor=0;
        return elements.getAt(0);
    }
    public T next(){
        if(cursor<0||cursor==(elements.size()-1))
            return null;
        cursor++;
        return elements.getAt(cursor);
    }
}
