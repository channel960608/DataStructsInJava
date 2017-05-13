package applications.tree.scheduling;

/**
 * Created by channel on 2017/5/13.
 */
public class Process implements Comparable<Process>{
    int pid;
    int execTime;
    int arrivalTime;
    int priority;

    Process(int pid,int execTime,int priority){
        this.pid=pid;
        this.execTime=execTime;
        this.priority=priority;
        arrivalTime=0;
    }

    public String toString(){
        return "("+pid+","+execTime+","+priority+","+arrivalTime+")";
    }

    @Override
    public int compareTo(Process o) {
        int c=priority-o.priority;
        if(c!=0)
            return c;
        return o.arrivalTime-arrivalTime;
    }
}
