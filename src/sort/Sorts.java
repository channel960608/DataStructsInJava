package sort;

import java.util.ArrayList;

/**
 * Created by channel on 2017/5/16.
 */
public class Sorts {
    /**
     * 插入排序
     * @param A 需要排序的数组
     *         最好情况 O(n)
     *         最坏情况 O(n²)
     *         平均情况 O(n²)
     */
    static void insertionSort(ArrayList<Integer> A){
        int len=A.size();

        for(int i=1;i<len;i++){
            int x=A.get(i);
            int p=i-1;
            boolean done=false;
            while(p>=0 && !done){
                if(x>=A.get(p)){
                    done=true;
                }
                else{
                    p=p-1;
                }
            }
            p++;
            for(int j=i-1;j>p-1;j--){
                A.set(j+1,A.get(j));
            }
            A.set(p,x);
        }

    }


    /**
     *  快速排序
     * @param A 需要排序的数组
     * @param left 左边开始的下标
     * @param right 右边开始的小标
     *         最好情况 O(n*㏒(n))
     *         最坏情况 O(n²)
     *         平均情况 O(n ㏒(n))
     */
    static void quicksort(ArrayList A,int left,int right){

        int splitPoint=split(A,left,right);
        if(splitPoint==-1)
            return;
        quicksort(A,left,splitPoint-1);
        quicksort(A,splitPoint+1,right);

    }


    static int split(ArrayList<Integer> A,int lo,int hi){
        if(lo>hi){
            return -1;
        }

        int pivot=A.get(lo);
        int left=lo+1;
        int right=hi;
        while(left<=right) {
            while (left <= right && left <= hi && A.get(left) < pivot) {
                left++;
            }
            while(left<=right && right>lo && A.get(right)>=pivot){
                right--;
            }
            if(left<right){
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
        int sp=right;
        return sp;
    }


    /**
     * 归并排序
     * @param A 排序的数组
     * @param left 最左的下标
     * @param right 最右下标
     *         最好情况 O(n)
     *         最坏情况 O(n ㏒(n))
     *         平均情况 O(n ㏒(n))
     *     这里使用链表作为储存数组的容器可以提升排序的效率
     */

    static void mergesort(ArrayList<Integer> A,int left,int right){
        if(left>=right)
            return;
        int splitPoint=(left+right)/2;
        mergesort(A,left,splitPoint);
        mergesort(A,splitPoint+1,right);
        merge(A,left,splitPoint,right);
    }

    static void merge(ArrayList<Integer> A,int left,int splitPoint,int right) {
        int p=left;
        int q=splitPoint+1;
        ArrayList<Integer> B=new ArrayList<Integer>();
        while(p<=splitPoint || q<=right){
            if(p>splitPoint){
                if(q<=right) {
                    B.add(A.get(q));
                    q++;
                }
            }else if(q>right){
                B.add(A.get(p));
                p++;
            }else if(A.get(p)<=A.get(q)){
                B.add(A.get(p));
                p++;
            }else {
                B.add(A.get(q));
                q++;
            }
        }

        for(int i=left;i<=right;i++){
            A.set(i,B.get(i-left));
        }
    }

    /**
     * 堆排序
     * @param A 排序的数组
     *         最坏情况 O(n ㏒(n))
     *         平均情况 O(n ㏒(n))
     */

    static void sortHeap(ArrayList<Integer> A){
        buildheap(A);
        int x=A.size()-1;
        while(x>0){
            int mid=A.get(x);
            A.set(x,A.get(0));
            A.set(0,mid);
            int v=A.get(0);
            siftDown(A,0, x);
            x--;
        }
    }

    static void buildheap(ArrayList<Integer> A){
        int len=A.size();

        int x=len/2-1;
        while(x>=0){
            int v=A.get(x);
            siftDown(A,x,A.size());
            x--;
        }
    }

    static void siftDown(ArrayList<Integer> A, int index, int max){
        int me=A.get(index);
        int lindex=2*index+1;
        while(lindex<max){
            int maxChild = A.get(lindex);
            int maxIndex=lindex;

            int rindex=lindex+1;
            if(rindex<max){
                int rightChild=A.get(rindex);
                if(rightChild>maxChild){
                    maxChild=rightChild;
                    maxIndex=rindex;
                }
            }
            if(maxChild>me){
                A.set(index,maxChild);
                index=maxIndex;
                lindex=2*index+1;
            }
            else break;
        }
        A.set(index,me);
    }




    static void print(ArrayList<Integer> A){
        for(Integer integer:A){
            System.out.print(integer+" -> ");
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> A=new ArrayList<>();
        A.add(3);
        A.add(4);
        A.add(1);
        A.add(5);
        A.add(3);
        A.add(0);
        A.add(7);
        sortHeap(A);
        print(A);
    }

}
