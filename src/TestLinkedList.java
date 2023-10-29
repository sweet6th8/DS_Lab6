
public class TestLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addFirst(1);
        linkedList.addFirst(2);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());

        System.out.println(linkedList.first());
        System.out.println(linkedList.last());

        System.out.println(linkedList.isEmpty());

        System.out.println(linkedList.size());
        linkedList.print();

    }
}
