package LinkedList;

public class Intersection {
    static class Result {
        int size;
        LinkedListNode<Integer> tail;

        Result(int size, LinkedListNode<Integer> tail) {
            this.size = size;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> headA = new LinkedListNode<>(3, new LinkedListNode<>(1, new LinkedListNode<>(5)));
        headA.next.next.next = new LinkedListNode<>(9, new LinkedListNode<>(7, new LinkedListNode<>(2, new LinkedListNode<>(1))));
        LinkedListNode<Integer> headB = new LinkedListNode<>(4, new LinkedListNode<>(6, headA.next.next.next.next));
        LinkedListNode<Integer> intersectionNode = intersection(headA, headB);
        System.out.println(intersectionNode == null ? "Can't find!" : "Intersection: " + intersectionNode.value);
    }

    private static LinkedListNode<Integer> intersection(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
        if (headA == null || headB == null) return null;
        Result firstResult = findSizeTail(headA);
        Result secondResult = findSizeTail(headB);
        if (firstResult.tail != secondResult.tail) return null;
        LinkedListNode<Integer> shorter = firstResult.size <= secondResult.size ? headA : headB;
        LinkedListNode<Integer> longer = firstResult.size > secondResult.size ? headA : headB;
        for (int i = 0; i < Math.abs(firstResult.size - secondResult.size); i++)
            longer = longer.next;
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }

    private static Result findSizeTail(LinkedListNode<Integer> head) {
        if (head == null) return null;
        int size = 1;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        return new Result(size, head);
    }
}
