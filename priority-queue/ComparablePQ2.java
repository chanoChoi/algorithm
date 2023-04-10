// 사전식 정렬

import java.util.PriorityQueue;

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparablePQ2 {
    public static void printPQ(PriorityQueue<Person2> pq) {
        System.out.print("[");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int[] ages = {30, 20, 45, 66, 53};

        PriorityQueue<Person2> pq = new PriorityQueue<>((Person2 p1, Person2 p2) -> p1.name.compareTo(p2.name)); // 오름차순

        for (int i = 0; i < names.length; i++) {
            pq.offer(new Person2(names[i], ages[i]));
        }

        System.out.println(pq); // [{name='A', age=30}, {name='B', age=20}, {name='C', age=45}, {name='D', age=66}, {name='E', age=53}]
        printPQ(pq); // [{name='A', age=30}, {name='B', age=20}, {name='C', age=45}, {name='D', age=66}, {name='E', age=53}]

        // 내림차순
        PriorityQueue<Person2> pq2 = new PriorityQueue<>((Person2 p1, Person2 p2) -> p2.name.compareTo(p1.name)); //
        // 오름차순

        for (int i = 0; i < names.length; i++) {
            pq2.offer(new Person2(names[i], ages[i]));
        }

        System.out.println(pq2); // [{name='E', age=53}, {name='D', age=66}, {name='B', age=20}, {name='A', age=30}, {name='C', age=45}]
        printPQ(pq2); // [{name='E', age=53}, {name='D', age=66}, {name='C', age=45}, {name='B', age=20}, {name='A', age=30}]
    }
}
