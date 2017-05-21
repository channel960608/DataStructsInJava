package Test;

import java.util.ArrayList;

/**
 * Created by channel on 2017/5/20.
 */
public class TestQuickSort {
    static void quicksort(ArrayList A,int left,int right){

        int splitPoint=split(A,left,right);
        if(splitPoint==-1)
            return;
        quicksort(A,left,splitPoint-1);
        quicksort(A,splitPoint+1,right);

    }


    static int split(ArrayList<Integer> A,int lo,int hi){
        int left=lo;
        int right=hi;
        if(hi<lo){
            return  -1;
        }

        int  pivot = A.get(lo);
        left++;

        while(left<=right){
            while(left<=right && A.get(left)<pivot && left<=hi){
                left++;
            }
            while(left<=right && A.get(right)>=pivot && right>lo){
                right--;
            }

            if(right>left){
                int mid=A.get(right);
                A.set(right,A.get(left));
                A.set(left,mid);
                left++;
                right--;
            }
        }

        int mid=A.get(right);
        A.set(right,A.get(lo));
        A.set(lo,mid);
        return right;

    }

    public static void main(String[] args){
        ArrayList<Integer> test=new ArrayList<Integer>();
        test.add(1);
        test.add(3);
        test.add(5);
        test.add(2);
        test.add(4);
        quicksort(test,0,test.size()-1);
        for(int i=0;i<test.size();i++){

            System.out.println(test.get(i));
        }






    }

 }
