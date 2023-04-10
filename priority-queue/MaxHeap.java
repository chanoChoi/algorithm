import java.util.ArrayList;
import java.util.List;

class Heap2 {
    List<Integer> heap;

    public Heap2() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
//  1. 트리의 가장 끝 위치에 데이터 삽입
//  2. 부모 노드와 키 비교한 후 클 경우 부모 자리와 교체(반복)
        this.heap.add(data);
        int curIdx = this.heap.size() - 1;
        while (curIdx > 1 && this.heap.get(curIdx >>> 1) < data) {
            int parentVal = this.heap.get(curIdx >>> 1);
            this.heap.set(curIdx / 2, data);
            this.heap.set(curIdx, parentVal);

            curIdx = curIdx / 2;
        }
    }

    public Integer delete() {
        if (this.heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }
//  1. 최상위 노드 반환 및 삭제
//  2. 가장 마지막 위치의 노드를 최상위 노드로 위치 시킴
//  3. 자식 노드 중 큰 값과 비교 후 부모 노드가 작으면 자리 교체(반복)
        int res = this.heap.get(1);
        this.heap.set(1, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int curIdx = 1;
        while (true) {
            int leftIdx = curIdx << 1;
            int rightIdx = (curIdx << 1) + 1;
            int targetIdx = -1;

            if (rightIdx < this.heap.size()) {
                targetIdx = (this.heap.get(leftIdx) <= this.heap.get(rightIdx)) ? rightIdx : leftIdx;
            } else if (leftIdx < this.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (this.heap.get(curIdx) >= this.heap.get(targetIdx)) { // max heap 의 조건을 만족하므로 종료
                break;
            }

            int parentVal = this.heap.get(curIdx);
            this.heap.set(curIdx, this.heap.get(targetIdx));
            this.heap.set(targetIdx, parentVal);
            curIdx = targetIdx;
        }

        return res;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class MaxHeap {
    public static void main(String[] args) {
        Heap2 maxHeap = new Heap2();

        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree(); // 40 30 10
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree(); // 70 50 60 30 40 10
        maxHeap.insert(20);
        maxHeap.printTree(); // 70 50 60 30 40 10 20
        maxHeap.insert(30);
        maxHeap.printTree(); // 70 50 60 30 40 10 20 30

        System.out.println("삭제: " + maxHeap.delete()); // 삭제: 70
        maxHeap.printTree(); // 60 50 30 30 40 10 20
        System.out.println("삭제: " + maxHeap.delete()); // 삭제: 60
        maxHeap.printTree(); // 50 40 30 30 20 10
        System.out.println("삭제: " + maxHeap.delete()); // 삭제: 50
        maxHeap.printTree(); // 40 30 30 10 20
    }
}
