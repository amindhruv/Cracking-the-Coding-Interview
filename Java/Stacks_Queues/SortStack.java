package Stacks_Queues;

import java.util.Random;
import java.util.Stack;

public class SortStack {
    private static void sort(Stack<Integer> st) {
        Stack<Integer> buffer = new Stack<>();
        while (!st.isEmpty()) {
            int temp = st.pop();
            while (!buffer.isEmpty() && buffer.peek() > temp)
                st.push(buffer.pop());
            buffer.push(temp);
        }
        while (!buffer.isEmpty())
            st.push(buffer.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 10; i++) {
            st.push(new Random().nextInt(100));
            System.out.print(st.peek() + " ");
        }
        System.out.println(" <- Original");
        sort(st);
        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
        System.out.println(" <- Sorted");
    }
}
