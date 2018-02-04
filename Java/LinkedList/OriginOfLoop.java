package LinkedList;

public class OriginOfLoop {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1, new LinkedListNode<>(2, new LinkedListNode<>(3)));
        head.next.next.next = new LinkedListNode<>(4, new LinkedListNode<>(5, head.next.next));
        LinkedListNode<Integer> loopStartNode = originOfLoop(head);
        System.out.println(loopStartNode == null ? "Can't find!" : "Origin of loop/cycle: " + loopStartNode.value);
    }

    private static LinkedListNode<Integer> originOfLoop(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
