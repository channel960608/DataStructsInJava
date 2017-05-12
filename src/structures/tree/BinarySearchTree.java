package structures.tree;

import structures.linear.OrderViolationException;

import java.util.NoSuchElementException;

/**
 * Created by channel on 2017/5/11.
 */
public class BinarySearchTree<T extends Comparable<T>>{
    BinaryTree<T> tree;
    int size;

    public BinarySearchTree(){tree=new BinaryTree<T>();size=0;}
    public boolean isEmpty(){return tree.isEmpty();}
    public int size(){return size;}

    BinaryTree<T> recursiveSearch(BinaryTree<T> root,T key){
        if(root==null){
            return null;
        }
        int c=key.compareTo(root.data);
        if(c==0)
            return root;
        if(c<0){
            return recursiveSearch(root.left,key);
        }else{
            return recursiveSearch(root.right,key);
        }

    }

    public T search(T key){
        if(tree.isEmpty()){
            return null;
        }
        return recursiveSearch(tree,key).data;
    }

    public void insert(T item){
        if(tree.isEmpty()){
            tree.makeRoot(item);
            size++;
            return;
        }
        BinaryTree<T> root=tree;
        boolean done=false;
        BinaryTree<T> newNode=null;
        while(!done){
            int c=item.compareTo(root.data);
            if(c==0)
                throw new OrderViolationException();
            if(c<0){
                if(root.left==null) {
                    newNode = new BinaryTree<T>();
                    root.left=newNode;
                    done=true;
                }else{
                    root=root.left;
                }

            }else{
                if(root.right==null) {
                    newNode = new BinaryTree<T>();
                    root.right=newNode;
                    done=true;
                }else{
                    root=root.right;
                }
            }

            newNode.data=item;
            newNode.parent=root;
            size++;

        }

    }

    void deleteHere(BinaryTree<T> deleteNode,BinaryTree<T> attach){
        BinaryTree<T> parent=deleteNode.parent;
        deleteNode.clear();
        if(parent==null)
            return;
        if(deleteNode==parent.left){
            parent.detachLeft();
            parent.attachLeft(attach);
            return;
        }
        parent.detachRight();
        parent.attachRight(attach);

    }

    BinaryTree<T> findPredecessor(BinaryTree<T> node){
        if(node.left==null){
            return null;
        }
        BinaryTree<T> pred=node.left;
        while (pred.right!=null) {
            pred = pred.right;
        }
        return pred;
    }

    public T delete(T key){
        if(tree.isEmpty()){
            throw new NoSuchElementException();
        }
        BinaryTree<T> deleteNode=recursiveSearch(tree,key);
        if(deleteNode==null){
            throw new NoSuchElementException();
        }
        BinaryTree<T> hold;
        if(deleteNode.right!=null&&deleteNode.left!=null){
            hold=findPredecessor(deleteNode);
            deleteNode.data=hold.data;
            deleteNode=hold;
        }
        if(deleteNode.left==null&&deleteNode.right==null){
            deleteHere(deleteNode,null);
            size--;
            return deleteNode.data;
        }
        if(deleteNode.right!=null){
            hold=deleteNode.right;
            deleteNode.right=null;
        }else{
            hold=deleteNode.left;
            deleteNode.left=null;
        }
        deleteHere(deleteNode,hold);
        if(tree==deleteNode)
            tree=hold;
        size--;
        return deleteNode.data;

    }

    public T minKey(){
        if(tree.data==null){
            throw new NoSuchElementException();
        }
        BinaryTree<T> root=tree;
        T min=root.data;
        root=root.left;
        while(root!=null){
            min=root.data;
            root=root.left;
        }
        return min;
    }
    public T maxKey(){ if(tree.data==null){
        throw new NoSuchElementException();
    }
        BinaryTree<T> root=tree;
        T max=root.data;
        root=root.right;
        while(root!=null){
            max=root.data;
            root=root.right;
        }
        return max;
    }

    void recursivePreOrder(BinaryTree<T> root,Visitor<T> visitor){
        if(root!=null){
            visitor.visit(root);
            recursivePreOrder(root.left,visitor);
            recursivePreOrder(root.right,visitor);
        }

    }

    public void preOrder(Visitor<T> visitor){
        if(tree.isEmpty()){
            return;
        }
        recursivePreOrder(tree,visitor);
    }

    void recursiveInOrder(BinaryTree<T> root,Visitor<T> visitor){
        if(root!=null){
            recursivePreOrder(root.left,visitor);
            visitor.visit(root);
            recursivePreOrder(root.right,visitor);
        }
    }

    public void inOrder(Visitor<T> visitor){
        if(tree.isEmpty()){
            return;
        }
        recursiveInOrder(tree,visitor);
    }

    void recursivePostOrder(BinaryTree<T> root,Visitor<T> visitor){
        if(root!=null){
            recursivePreOrder(root.left,visitor);
            recursivePreOrder(root.right,visitor);
            visitor.visit(root);
        }
    }

    public void postOrder(Visitor<T> visitor){
        if(tree.isEmpty()){
            return;
        }
        recursivePostOrder(tree,visitor);
    }




}
