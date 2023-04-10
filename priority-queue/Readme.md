## Priority Queue (우선순위 큐)

    - 우선순위가 높은 데이터가 먼저 나옴( != FIFO )
    - 모든 데이터에 우선순위가 있음
    - Deque 시, 우선순위가 높은 순으로 나감
    - 우선 순위가 같은 경우는 FIFO
    - 최소 힙 및 최대 힙의 삽입 삭제와 같음 (우선순위큐를 힙으로 구성했을때)

### Heap

최소값 또는 최대값을 빠르게 찾아내는데 유용한 자료구조로써 완전 이진트리의 형태이며 반정렬 상태(형제 노드간에는 기준이 없으며 부모 자식사이에만 대소관계가 존재)로 구성되어 있고 중복 값을 허용한다.

**Min Heap**

- 부모 노드의 키가 자식 노드의 키보다 작거나 같은 형태
- insert
  - 트리의 가장 끝 위치에 데이터를 삽입
  - 부모 노드와 키 비교 후 작을 경우 부모 자리와 교체(반복)
- delete
  - 최상위의 노드를 반환하고 삭제한다
  - 가장 마지막에 위치한 노드를 최상위 노드로 위치시킨다
  - 자식 노드 중 더 작은 키를 가진 노드와 부모 노드를 비교 후 부모 노드가 더 크다면 교체(반복)

**Max Heap**

- 부모 노드의 키가 자식 노드의 키보다 크거나 같은 형태
- insert
  - 트리의 가장 끝 위치에 데이터를 삽입
  - 부모 노드와 키 비교 후 클 경우 부모 자리와 교체(반복)
- delete
  - 최상위의 노드를 반환하고 삭제한다
  - 가장 마지막에 위치한 노드를 최상위 노드로 위치시킨다
  - 자식 노드 중 더 큰 키를 가진 노드와 부모 노드를 비교 후 부모 노드가 더 작다면 교체(반복)

|                    |  offer  |  poll   |
| ------------------ | :-----: | :-----: |
| 정렬된 배열        |  O(N)   |  O(1)   |
| 정렬된 연결 리스트 |  O(N)   |  O(1)   |
| 힙                 | O(logN) | O(logN) |

### 사용사례

**_프로세스 스케줄링_**, **_힙 정렬_**, **_다익스트라_**

### java Priority Queue 는 힙으로 구현되어 있다.

```java
//  package java.util.PriorityQueue;

// offer
private static <T> void siftUpComparable(int k, T x, Object[] es) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = es[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            es[k] = e;
            k = parent;
        }
        es[k] = key;
    }

// poll
private static <T> void siftDownComparable(int k, T x, Object[] es, int n) {
        // assert n > 0;
        Comparable<? super T> key = (Comparable<? super T>)x;
        int half = n >>> 1;           // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = es[child];
            int right = child + 1;
            if (right < n &&
                ((Comparable<? super T>) c).compareTo((T) es[right]) > 0)
                c = es[child = right];
            if (key.compareTo((T) c) <= 0)
                break;
            es[k] = c;
            k = child;
        }
        es[k] = key;
    }
```
