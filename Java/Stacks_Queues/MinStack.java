package Stacks_Queues;

import java.util.Stack;

public class MinStack extends Stack<Integer> {
    private Stack<Integer> min;

    MinStack() {
        this.min = new Stack<>();
    }

    public void push(int value) {
        if (this.min.isEmpty() || this.min.peek() > value)
            this.min.push(value);
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == this.min.peek())
            this.min.pop();
        return value;
    }

    public int minValue() {
        return this.min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(6);
        minStack.push(7);
        minStack.push(9);
        minStack.push(0);
        minStack.push(4);
        minStack.push(8);
        System.out.println("Current minimum: " + minStack.minValue());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println("Current minimum: " + minStack.minValue());
    }
}
