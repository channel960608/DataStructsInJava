package applications.tree.scheduling;

import java.util.Random;

/**
 * Created by channel on 2017/5/13.
 */
public class ProcessSource {
    float probOfArrival;
    int maxExecTime;
    int maxPriority;
    Random randomizer;
    int pid;

    ProcessSource(float arrivalProbability,int maxExecTime,int maxPriority){
        if(arrivalProbability<=0||arrivalProbability>1)
            throw new IllegalArgumentException(arrivalProbability + "<=0 or >1");
        else
            probOfArrival=arrivalProbability;

        this.maxExecTime=maxExecTime;
        this.maxPriority=maxPriority;
        randomizer=new Random();
        pid=0;
    }

    Process getProcess(){
        if(randomizer.nextFloat()>probOfArrival)
            return null;
        pid++;
        int ptime=(int)(Math.random()*maxExecTime);
        if(ptime==0)
            ptime++;
        int priority=(int)(Math.random()*maxPriority);
        return new Process(pid,ptime,priority);
    }
}
