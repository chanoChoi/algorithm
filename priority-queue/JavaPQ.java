import java.util.Collections;
import java.util.PriorityQueue;

public class JavaPQ {
    public static void printPQ(PriorityQueue<Integer> pq) {
        System.out.print("[");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(3);
        pq.offer(1);
        pq.offer(9);
        pq.offer(7);
        pq.offer(5);
        System.out.println(pq); // [1, 5, 3, 9, 7, 5] 힙을 통해 구현되어 있기에 부모노드와 자식노드로 정렬되어 있다. idx * 2 + 1 && idx * 2 + 2

        printPQ(pq); // [1, 3, 5, 5, 7, 9]

        // 내림차순 정렬
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.offer(5);
        pq2.offer(3);
        pq2.offer(1);
        pq2.offer(9);
        pq2.offer(7);
        pq2.offer(5);

        System.out.println(pq2); // [9, 7, 5, 3, 5, 1]

       printPQ(pq2); // [9, 7, 5, 5, 3, 1]
    }
}
