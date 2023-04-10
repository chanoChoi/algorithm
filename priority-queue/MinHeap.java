import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Heap {
    List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 인덱스 1번부터 사용하기 위함
    }

    public void insert(int data) {
//  1. 트리의 가장 끝 위치에 데이터 삽입
//  2. 부모 노드와 키 비교한 후 작을 경우 부모 자리와 교체(반복)
        this.heap.add(data);
        int curIdx = this.heap.size() - 1;
        while (curIdx > 1 && this.heap.get(curIdx / 2) > data) {
            int parentVal = this.heap.get(curIdx / 2);
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
//  3. 자식 노드 중 작은 값과 비교 후 부모 노드가 더 크면 자리 교체(반복)
        int res = this.heap.get(1);
        this.heap.set(1, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int curIdx = 1;
        while (true) {
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            int targetIdx = -1;

            // 자식노드의 존재 여부 확인 및 둘중 더 적은 값을 선택
            if (rightIdx < this.heap.size()) { // 완전 이진트리 오른쪽 자식노드가 존재하면 왼쪽 자식노드도 존재함
                targetIdx = (this.heap.get(leftIdx) <= this.heap.get(rightIdx)) ? leftIdx : rightIdx;
            } else if (leftIdx < this.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (this.heap.get(curIdx) < this.heap.get(targetIdx)) { // 찾은 자식노드보다 현재 노드가 더 적다면 min heap의 기준을 만족하므로 종료
                break;
            }

            int curVal = this.heap.get(curIdx);
            this.heap.set(curIdx, this.heap.get(targetIdx));
            this.heap.set(targetIdx, curVal);
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

public class MinHeap {
    public static void main(String[] args) {
        Heap minHeap = new Heap();

        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree(); // 10 40 30
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree(); // 10 40 30 50 60 70
        minHeap.insert(20);
        minHeap.printTree(); // 10 40 20 50 60 70 30
        minHeap.insert(30);
        minHeap.printTree(); // 10 30 20 40 60 70 30 50

        System.out.println("삭제: " + minHeap.delete()); // 삭제: 10
        minHeap.printTree(); // 20 30 30 40 60 70 50
        System.out.println("삭제: " + minHeap.delete()); // 삭제: 20
        minHeap.printTree(); // 30 40 30 50 60 70
        System.out.println("삭제: " + minHeap.delete()); // 삭제: 30
        minHeap.printTree(); // 30 40 70 50 60
    }
}
