import applications.linear.Expense;
import structures.linear.*;
import applications.linear.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by channel on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        Calendar cal=Calendar.getInstance();
        Expense exp=new Expense(Expense.getCalendar("1996/6/8"),100,"赌博");
        System.out.println(exp.toString());
        System.out.print(String.format("%s",
                "1996/6/8"));

    }

}
