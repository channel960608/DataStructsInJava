import applications.linear.*;
import applications.linear.postfix.IllegalExpressionException;
import applications.linear.postfix.PostfixEvaluator;
import structures.linear.*;
import applications.linear.*;
import structures.tree.*;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by channel on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree<String> tree=new BinaryTree<String>();
        tree.setData("root");


        BinaryTree<String> tree2=new BinaryTree<String>();
        tree2.setData("node1");

        BinaryTree<String> tree3=new BinaryTree<String>();
        tree3.setData("node2");

        BinaryTree<String> tree4=new BinaryTree<String>();
        tree4.setData("node3");

        BinaryTree<String> tree5=new BinaryTree<String>();
        tree5.setData("node4");


        tree.attachLeft(tree2);
        tree2.attachRight(tree3);
        tree2.attachLeft(tree4);
        tree.attachRight(tree5);

        Visitor<String> visit=new Visitor<String>();
        BinaryTree.inOrder(tree,visit);

    }

}
