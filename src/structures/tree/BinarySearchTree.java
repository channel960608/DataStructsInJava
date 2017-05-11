package structures.tree;

/**
 * Created by channel on 2017/5/11.
 */
public class BinarySearchTree<T extends Comparable<T>>{
    BinaryTree<T> tree;
    int size;

    public BinarySearchTree(){tree=new BinaryTree<T>();size=0;}
    public boolean isEmpty(){return tree.isEmpty();}
    public int size(){return size;}
    BinaryTree<T> recursiveSearch(BinaryTree<T> root,T key){return  null;}
    public T search(T key){return null;}
    public void insert(T item){}
    void deleteHere(BinaryTree<T> deketeNode,BinaryTree<T> attach){}
    BinaryTree<T> findPredecessor(BinaryTree<T> node){return null;}
    public T delete(T key){return null;}
    public T minKey(){return null;}
    public T maxKey(){return null;}
    void recursivePreOrder(BinaryTree<T> root,Visitor<T> visitor){}
    public void preOrder(Visitor<T> visitor){}
    void recursiveInOrder(BinaryTree<T> root,Visitor<T> visitor){}
    public void inOrder(Visitor<T> visitor){}
    void recursivePostOrder(BinaryTree<T> root,Visitor<T> visitor){}
    public void postOrder(Visitor<T> visitor){}




}
