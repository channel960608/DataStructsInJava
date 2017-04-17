package applications.linear;

import structures.linear.*;

import java.util.Calendar;

/**
 * Created by channel on 2017/4/17.
 */
public class ExpenseList {
    List<Expense> expenses;

    public ExpenseList(){expenses=new List<Expense>();}
    public void add(Expense exp){expenses.add(exp);}
    public int size(){return expenses.size();}
    public boolean isEmpty(){return expenses.isEmpty();}
    public boolean contains(Expense exp){return expenses.contains(exp);}
    public void clear(){expenses.clear();}
    public void remove(Expense exp){expenses.remove(exp);}
    public Expense first(){return expenses.first();}
    public Expense next(){return expenses.next();}

    public float minExpense(){
        float min=Float.MAX_VALUE;
        Expense exp=expenses.first();
        while (exp!=null){
            float am=exp.amount;
            if(am<min)
                min=am;
            exp=expenses.next();
        }
        return min;
    }
    public float maxExpense(){
        float max=Float.MIN_VALUE;
        Expense exp=expenses.first();
        while (exp!=null){
            float am=exp.amount;
            if(am>max)
                max=am;
            exp=expenses.next();
        }
        return max;
    }

    public float avgExpense(){
        float sum=0;
        Expense exp=expenses.first();
        while (exp!=null){
            sum+=exp.amount;
            exp=expenses.next();
        }
        return sum/expenses.size();
    }

    public float amountSpentOn(String expItem){
        float sum=0;
        Expense exp=expenses.first();
        while(exp!=null){
            if(expItem.equals(exp.item))
                sum+=exp.amount;
            exp=expenses.next();
        }
        return sum;
    }

    public float amountSpentDuring(Calendar from,Calendar to){
        float sum=0;
        Expense exp=expenses.first();
        while (exp!=null){
            if(!exp.date.before(from)||exp.date.after(to)){
                sum+=exp.amount;
            }
            exp=expenses.next();
        }
        return sum;
    }

    public Expense get(Expense getExp){
        Expense exp=expenses.first();
        while(exp!=null){
            if(exp.equals(getExp))
                return exp;
            exp=expenses.next();
        }
        return null;
    }

}
