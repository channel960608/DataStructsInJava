import structures.linear.Queue;

/**
 * Created by channel on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> que=new Queue<>();
        for(int i=0;i<10;i++){
            que.enqueue(i);
        }

        System.out.print(que.first());

        for(int i=0;i<10;i++){
            System.out.print(que.next());
        }
    }
}
