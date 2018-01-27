package LinkedList;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 linked list elements: ");
        LinkedListNode<Integer> head = new LinkedListNode<>(sc.nextInt());
        LinkedListNode<Integer> curr = head;
        for (int i = 2; i < 11; i++) {
            curr.next = new LinkedListNode<>(sc.nextInt());
            curr = curr.next;
        }
        removeDuplicate(head);
        //removeDupsWithoutBuffer(head);
        System.out.print("\nAfter removing duplicates: ");
        LinkedListNode.print(head);
        sc.close();
    }

    private static void removeDuplicate(LinkedListNode<Integer> node) {
        HashSet<Integer> hs = new HashSet<>();
		LinkedListNode<Integer> prev = null;
        while (node != null) {
            if (hs.contains(node.value)) {
                prev.next = node.next;
            } else {
                hs.add(node.value);
				prev = node;
            }
            node = node.next;
        }
    }

    private static void removeDupsWithoutBuffer(LinkedListNode<Integer> node) {
        while (node.next != null) {
            LinkedListNode<Integer> runner = node;
            while (runner.next != null) {
                if (node.value.equals(runner.next.value))
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            node = node.next;
        }
    }
}
