package applications.tree;

import structures.tree.Heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by channel on 2017/5/15.
 */
public class Sort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(new File("intfile"));

        int n=sc.nextInt();
        Heap<Integer> sortHeap=new Heap<Integer>(n);

        for(int i=0;i<n;i++){
            sortHeap.add(sc.nextInt());
        }

        while(!sortHeap.isEmpty()){
            System.out.print(sortHeap.deleteMax());
        }
    }
}
