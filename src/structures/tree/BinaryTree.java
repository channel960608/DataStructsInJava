package structures.tree;

import structures.linear.Stack;


/**
 * Created by channel on 2017/4/20.
 * 添加了一个非递归的中序遍历方法 inOrder()，遍历过程如下
 * 1.遍历一个节点
 * 2.如果有左孩子，则遍历到它的左孩子节点，遍历左节点的过程即为第1步
 * 3.如果遍历的节点没有左孩子，则访问这个节点，然后返回，遍历到他的父结点
 * 4.此时是第二次遍历父结点，访问它，然后遍历它的右节点（如果有的话）
 * 5.遍历右节点即重复第1步，遍历完，回到遍历它的父结点，即第一步中的节点
 * 6.此时是第三次遍历这个节点了，即已经完成了这个节点为根的树的所有节点的访问，继续遍历它的父结点，知道没有父节点
 * 以上就是遍历的过程，没有用到递归，是因为有一个计数器，保证一个节点做多被访问3次，
 * 并用栈的结构储存了访问过程，虽然原理上和递归的操作是一样的，但是非递归会减小开销
 * 具体方法如下：
 * 使用Stack存储来实现遍历过程，存储内容为这个节点以及他的生命周期
 * 1.压入根节点，赋值生命周期为0
 * 2.从Stack中弹出栈顶元素，如果为0，则是第一次遇到，更新为1之后重新压回去，再压入他的左孩子
 * 如果是1，,则是第二次遇到，压回，再压入右孩子
 * 如果是2，则是第三次遇到，不再压入任何元素
 * 3.重复2，直到栈为空
 *
 */
public class BinaryTree<T>{
    protected T data;
    public BinaryTree<T> left;
    public BinaryTree<T> right;
    public BinaryTree<T> parent;

    public BinaryTree(){
        data=null;
        left=null;
        right=null;
        parent=null;
    }

    public void makeRoot(T data){
        if(this.data!=null)
            throw new TreeViolationException();
        this.data=data;
    }

    public void setData(T data){
        this.data=data;
    }

    public T getData(){return  data;}

    public void attachLeft(BinaryTree<T> tree){
        if(left!=null)
            throw new TreeViolationException();
        if(tree!=null){
            tree.parent=this;
            left=tree;
        }
    }

    public void attachRight(BinaryTree<T> tree){
        if(right!=null){
            throw new TreeViolationException();
        }
        if(tree!=null){
            tree.parent=this;
            right=tree;
        }
    }

    public BinaryTree<T> detachLeft(){
        BinaryTree<T> retleft=left;
        left=null;
        return retleft;
    }

    public BinaryTree<T> detachRight(){
        BinaryTree<T> retright=right;
        right=null;
        return  retright;
    }

    public boolean isEmpty(){
        return data==null;
    }

    public void clear(){
        left=null;
        right=null;
        parent=null;
        data=null;
    }

    public BinaryTree<T> root(){
        if(parent==null)
            return this;
        else{
            BinaryTree<T> nextParent=parent;
            while(nextParent.parent!=null){
                nextParent=nextParent.parent;
            }
            return nextParent;
        }


    }


    public static void inOrder(BinaryTree<String> tree,Visitor<String> visitor){
        class StackNode{
            BinaryTree<String> node;
            int milestone;
            StackNode(BinaryTree<String> node,int milestone){
                this.node=node;
                this.milestone=milestone;
            }
        }

        if(tree==null||tree.isEmpty()) return;

        Stack<StackNode> S=new Stack<StackNode>();
        S.push(new StackNode(tree,0));
        while(!S.isEmpty()){
            StackNode snode=S.pop();
            switch (snode.milestone){
                case 0://第一阶段
                    snode.milestone=1;
                    S.push(snode);
                    if(snode.node.left!=null){
                        S.push(new StackNode(snode.node.left,0));
                    }
                    break;
                case 1:
                    snode.milestone=2;
                    S.push(snode);
                    visitor.visit(snode.node);
                    if(snode.node.right!=null){
                        S.push(new StackNode(snode.node.right,0));
                    }
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }

    }
}
