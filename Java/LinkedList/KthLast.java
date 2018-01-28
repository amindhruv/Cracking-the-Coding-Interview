package LinkedList;

import java.util.Scanner;

public class KthLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 linked list elements: ");
        LinkedListNode<Integer> head = new LinkedListNode<>(sc.nextInt());
        LinkedListNode<Integer> curr = head;
        for (int i = 2; i < 11; i++) {
            curr.next = new LinkedListNode<>(sc.nextInt());
            curr = curr.next;
        }
        System.out.print("Enter k to get kth last element: ");
        int k = sc.nextInt();
        LinkedListNode<Integer> kthLast = kthLast(head, k);
        System.out.println(kthLast == null ? "out of bound!" : k + "th last element from linkedlist: " + kthLast.value);
        sc.close();
    }

    private static LinkedListNode<Integer> kthLast(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> runner = head;
        for (int i = 0; i < k; i++) {
            if (runner == null) return null;
            runner = runner.next;
        }
        LinkedListNode<Integer> curr = head;
        while (runner != null) {
            curr = curr.next;
            runner = runner.next;
        }
        return curr;
    }
}
