import java.util.LinkedList;
import java.util.List;

public class LinkedListPQ {
    public static List<Integer> list = new LinkedList<>();
    // 우선순위: 낮은 숫자 순
    public static void enqueue(int data) {
        int idx = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (data <= list.get(i)) {
                idx = i;
                break;
            }
        }

        list.add(idx, data);
    }

    public static Integer dequeue() {
        if (list.size() == 0) {
            return null;
        }

        int res = list.get(0);
        list.remove(0);
        return res;
    }

    public static void main(String[] args) {
        enqueue(5);
        enqueue(3);
        enqueue(1);
        enqueue(9);
        enqueue(7);
        enqueue(5);
        System.out.println(list); // [1, 3, 5, 5, 7, 9]

        System.out.println(dequeue()); // 1
        System.out.println(dequeue()); // 3
        System.out.println(list); // [5, 5, 7, 9]
    }
}
