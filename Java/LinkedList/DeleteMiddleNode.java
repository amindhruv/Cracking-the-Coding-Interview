package LinkedList;

import java.util.Scanner;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 linked list elements: ");
        LinkedListNode<Integer> head = new LinkedListNode<>(sc.nextInt());
        LinkedListNode<Integer> curr = head;
        for (int i = 0; i < 9; i++) {
            curr.next = new LinkedListNode<>(sc.nextInt());
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < 5; i++) {
            curr = curr.next;
        }
        deleteMiddleNode(curr);
        LinkedListNode.print(head);
        sc.close();
    }

    private static void deleteMiddleNode(LinkedListNode<Integer> node) {
        if (node == null || node.next == null) {
            System.out.println("Unable to do so!");
            return;
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
