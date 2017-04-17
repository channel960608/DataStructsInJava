import applications.linear.*;
import applications.linear.postfix.IllegalExpressionException;
import applications.linear.postfix.PostfixEvaluator;
import structures.linear.*;
import applications.linear.*;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by channel on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        PostfixEvaluator eva=new PostfixEvaluator();
        eva.init("1+1");
        PrintWriter pw=null;
        try{eva.runAll(pw);}catch (IllegalExpressionException f){return;}

    }

}
