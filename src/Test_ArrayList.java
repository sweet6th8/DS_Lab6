// package lab6_ArrayList_and_LinkedList;

import java.util.Comparator;

public class Test_ArrayList {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 2, 6 };
        MyArrayList<Integer> array = new MyArrayList<>(arr, 10);

        // array.growSize();

        // System.out.println(array.size());
        // System.out.println(array.isEmpty());
        // System.out.println(array.get(10));
        // System.out.println(array.set(3, 33));
        // System.out.println(array.add(10));
        // array.add(3, 2);
        // array.remove(1);
        // array.clear();
        // System.out.println(array.lastIndexOf(2));
        // array.toArray();
        // array.clone().print();
        // array.print();
        // System.out.println(array.contains(2));
        // System.out.println(array.indexOf(2));
        array.sort(Comparator.comparingInt(o -> o));
        array.print();

    }
}
