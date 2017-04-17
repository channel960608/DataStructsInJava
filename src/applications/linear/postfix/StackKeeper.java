package applications.linear.postfix;
import structures.linear.*;

import java.io.PrintWriter;
import java.util.NoSuchElementException;

/**
 * Created by channel on 2017/4/17.
 */
public class StackKeeper {
    static final char[] operator={'+','-','*','/'};
    Stack<Float> evalStack;

    StackKeeper(){evalStack=new Stack<Float>();}
    void init(){evalStack.clear();}
    int size(){return evalStack.size();}
    void update(String token){
        if(isOperator(token))
            evaluate(token.charAt(0));
        else
            evalStack.push(Float.valueOf(token));
    }
    float getTop(){
        Float top=evalStack.first();
        if(top==null)
            throw new NoSuchElementException();
        return top;
    }

    boolean isOperator(String instr){return false;}
    void evaluate(char op){
        Float topval=evalStack.pop();
        Float nexval=evalStack.pop();
        float temval=0;
        switch (op){
            case '+':temval=nexval+topval;break;
            case '-':temval=nexval-topval;break;
            case '*':temval=nexval*topval;break;
            case '/':temval=nexval/topval;break;
        }
        evalStack.push(temval);
    }
    void printStack(PrintWriter pw){
        pw.println("                -------------->");
        pw.print("      Stack:");

        Stack<Float> tempStack=new Stack();
        Float obj=evalStack.first();
        while(obj!=null){
            tempStack.push(obj);
            obj=evalStack.next();
        }

        obj=tempStack.first();
        while(obj!=null){
            pw.print(String.format("  | %.2f",obj));
            obj=tempStack.next();
        }
        pw.println();
        pw.println("                -------------->");
    }
  }
