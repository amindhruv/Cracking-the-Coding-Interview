package LinkedList;

import java.util.Scanner;

public class SumList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int num1 = sc.nextInt(), num2 = sc.nextInt(); // 617
        LinkedListNode<Integer> first = new LinkedListNode<>(num1 % 10), curr = first;
        num1 /= 10;
        while (num1 != 0) {
            curr.next = new LinkedListNode<>(num1 % 10);
            curr = curr.next;
            num1 /= 10;
        }
        LinkedListNode.print(first);
        LinkedListNode<Integer> second = new LinkedListNode<>(num2 % 10);
        curr = second;
        num2 /= 10;
        while (num2 != 0) {
            curr.next = new LinkedListNode<>(num2 % 10);
            curr = curr.next;
            num2 /= 10;
        }
        LinkedListNode.print(second);
        LinkedListNode<Integer> result = sumList(first, second);
        LinkedListNode.print(result);
        sc.close();
    }

    private static LinkedListNode<Integer> sumList(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        LinkedListNode<Integer> result = new LinkedListNode<>(0), curr = result;
        int carry = 0;
        while (first != null || second != null) {
            if (first != null) {
                carry += first.value;
                first = first.next;
            }
            if (second != null) {
                carry += second.value;
                second = second.next;
            }
            curr.next = new LinkedListNode<>(carry % 10);
            carry = carry / 10;
            curr = curr.next;
        }
        if (carry > 0)
            curr.next = new LinkedListNode<>(carry);
        return result.next;
    }
}
