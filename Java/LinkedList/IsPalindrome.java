package LinkedList;

import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1, new LinkedListNode<>(2, new LinkedListNode<>(0)));
        head.next.next.next = new LinkedListNode<>(2, new LinkedListNode<>(1));
        System.out.println("Linked list is " + (isPalindrome(head) ? "" : "not ") + "palindrome.");
        System.out.println("Linked list is " + (isPalindromeWithStack(head) ? "" : "not ") + "palindrome.");
    }

    private static boolean isPalindromeWithStack(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (!stack.pop().equals(slow.value)) return false;
            slow = slow.next;
        }
        return true;
    }

    private static boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> reversed = reverseClone(head);
        return isEqual(head, reversed);
    }

    private static boolean isEqual(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        while (first != null && second != null) {
            if (!first.value.equals(second.value)) return false;
            first = first.next;
            second = second.next;
        }
        return first == null && second == null;
    }

    private static LinkedListNode<Integer> reverseClone(LinkedListNode<Integer> node) {
        LinkedListNode<Integer> head = null;
        while (node != null) {
            LinkedListNode<Integer> n = new LinkedListNode<>(node.value);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }
}
