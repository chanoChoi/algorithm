import java.util.Collections;
import java.util.PriorityQueue;

// Person의 나이순으로 오름차순 정렬
// Class를 기준으로 PriorityQueue를 구현시 클래스의 어떤 값을 기준으로 정렬할 것인지 정해줘야함
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
        // 1: 변경 안함
        // -1: 변경

        // 새롭게 추가하는 데이터가 더 적을 때 변경한다. 오름차순
        // this.age == 현재 값
        // o.age == 기존에 존재하는 값
        return (this.age >= o.age) ? 1 : -1;

        // 내림차순
//        return (this.age >= o.age) ? -1 : 1;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ComparablePQ {
    public static void printPQ(PriorityQueue<Person> pq) {
        System.out.print("[");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int[] ages = {30, 20, 45, 66, 53};

        // 오름차순
        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (int i = 0; i < names.length; i++) {
            pq.offer(new Person(names[i], ages[i]));
        }

        System.out.println(pq); // [{name='B', age=20}, {name='A', age=30}, {name='C', age=45}, {name='D', age=66}, {name='E', age=53}]
        printPQ(pq); // [{name='B', age=20}, {name='A', age=30}, {name='C', age=45}, {name='E', age=53}, {name='D', age=66}]

        // 내림차순
        PriorityQueue<Person> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < names.length; i++) {
            pq2.offer(new Person(names[i], ages[i]));
        }

        System.out.println(pq2); // [{name='D', age=66}, {name='E', age=53}, {name='A', age=30}, {name='B', age=20}, {name='C', age=45}]
        printPQ(pq2); // [{name='D', age=66}, {name='E', age=53}, {name='C', age=45}, {name='A', age=30}, {name='B', age=20}]

        // 람다식으로 Comparable 구현
        PriorityQueue<Person> pq3 = new PriorityQueue<>((Person p1, Person p2) -> {
            return (p1.age >= p2.age) ? 1 : -1; // 오름차순
        });

        for (int i = 0; i < names.length; i++) {
            pq3.offer(new Person(names[i], ages[i]));
        }

        System.out.println(pq3); // [{name='B', age=20}, {name='A', age=30}, {name='C', age=45}, {name='D', age=66}, {name='E', age=53}]
        printPQ(pq3); // [{name='B', age=20}, {name='A', age=30}, {name='C', age=45}, {name='E', age=53}, {name='D', age=66}]
    }
}
