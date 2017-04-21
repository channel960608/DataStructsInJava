package structures.tree;

/**
 * Created by channel on 2017/4/21.
 */
public class Visitor<T> {
    public void visit(BinaryTree<T> node){
        System.out.println(node.getData());
    }


}

