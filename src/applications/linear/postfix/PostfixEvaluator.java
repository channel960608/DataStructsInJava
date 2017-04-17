package applications.linear.postfix;

import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Created by channel on 2017/4/17.
 * 后缀表达式的求值类，基于Stack实现后缀表达式的计算
 */
public class PostfixEvaluator {
    StringTokenizer exprTok;
    StatusKeeper exprStatus;
    StackKeeper postStack;

    public PostfixEvaluator(){
        postStack=new StackKeeper();
        exprStatus=new StatusKeeper();
    }

    public void printStatus(PrintWriter pw){
        pw.println();
        exprStatus.printStatus(pw);
        pw.println();
        postStack.printStack(pw);
        pw.println();
    }

    public void init(String expr){
        postStack.init();
        exprStatus.init();
        exprTok=new StringTokenizer(expr);
    }
    public float runAll(PrintWriter pw) throws IllegalExpressionException{
        runSome(exprTok.countTokens(),pw);

        if(postStack.size()>1)
            throw new IllegalExpressionException("insufficient operators");

        return postStack.getTop();
    }
    public void runSome(int howManySteps,PrintWriter pw)throws IllegalExpressionException{
        int step=0;
        while(exprTok.hasMoreTokens()) {
            if (step == howManySteps) {
                return;
            }

            String nextTok = exprTok.nextToken();
            exprStatus.update(nextTok);
            try {
                postStack.update(nextTok);
            } catch (NoSuchElementException f) {
                printStatus(pw);
                throw new IllegalExpressionException("insufficient operands");
            }
            step++;
        }
    }
}
