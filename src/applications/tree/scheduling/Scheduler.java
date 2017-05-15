package applications.tree.scheduling;

import structures.tree.Heap;


import java.io.PrintWriter;

/**
 * Created by channel on 2017/5/13.
 */
public class Scheduler{

    ProcessSource source;
    Processor cpu;
    Heap<Process> procHeap;
    int thruPut,intervalThruPut;
    int numProcs,intervalNumProcs;
    int clock,intervalClock;

    public Scheduler(){procHeap=new Heap<Process>();}

    public void init(float probOfArrival,int maxExecTime,int maxPriority,int timeSlice){
        source = new ProcessSource(probOfArrival,maxExecTime,maxPriority);
        cpu=new Processor(timeSlice);
        procHeap.clear();
        clock=0;
        numProcs=0;
        thruPut=0;

    }
    public void run(int howLong)throws BusyInterruptionException{
        intervalClock=0;
        intervalNumProcs=0;
        intervalThruPut=0;

        while(intervalClock < howLong){
            //处理时间
            //时间递增
            clock++;
            intervalClock++;
            cpu.stepTime();
        }

        Process process = source.getProcess();
        if(process!=null){
            process.arrivalTime=clock;
            procHeap.add(process);
            intervalNumProcs++;
            numProcs++;
        }

        if(cpu.isIdle()){
            //处理cpu空闲事件

        }

        process=cpu.getProcess();
        if(process!=null){
            process.execTime -= cpu.timeSlice;
            if(process.execTime>0){
                process.priority--;
                if(process.priority<0){
                    process.priority=0;
                }
                process.arrivalTime=clock;
                procHeap.add(process);
            }else{
                thruPut++;
                intervalThruPut++;
            }
        }

        if(!procHeap.isEmpty()){
            Process temp=procHeap.deleteMax();
            cpu.startUp(temp);
        }
    }

    public void printStatus(PrintWriter pw){
        pw.println("Interval Cumulative");
        pw.println("Processes Arrived "+intervalNumProcs+ " " + numProcs);
        pw.println("Throughput "+intervalThruPut+" "+thruPut);
        pw.flush();
    }

    public void printHeap(PrintWriter pw){
        pw.print("Heap: ");
        Process proc=procHeap.first();
        while(proc!=null){
            pw.print(proc+ " ");
            proc=procHeap.next();
        }
        pw.println();
        pw.flush();
    }


}
