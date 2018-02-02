package LinkedList;

class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next;

    LinkedListNode(T value) {
        this.value = value;
    }

    LinkedListNode(T value, LinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    static void print(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
