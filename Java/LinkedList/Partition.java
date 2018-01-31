package LinkedList;

import java.util.Scanner;

public class Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 linked list elements: ");
        LinkedListNode<Integer> head = new LinkedListNode<>(sc.nextInt());
        LinkedListNode<Integer> curr = head;
        for (int i = 0; i < 9; i++) {
            curr.next = new LinkedListNode<>(sc.nextInt());
            curr = curr.next;
        }
        System.out.print("Enter a number on which you want to make partition: ");
        int n = sc.nextInt();
        head = partition(head, n);
        LinkedListNode.print(head);
        sc.close();
    }

    private static LinkedListNode<Integer> partition(LinkedListNode<Integer> node, int n) {
        LinkedListNode<Integer> head = node, tail = node;
        while (node != null) {
            LinkedListNode<Integer> next = node.next;
            if (node.value < n) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}
