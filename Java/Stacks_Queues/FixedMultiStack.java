package Stacks_Queues;

import java.util.NoSuchElementException;

public class FixedMultiStack {
    private int capacity;
    private int[] values;
    private int[] sizes;

    FixedMultiStack(int capacity) {
        this.capacity = capacity;
        int numOfStacks = 3;
        this.values = new int[numOfStacks * this.capacity];
        this.sizes = new int[numOfStacks];
    }

    public void push(int stackIndex, int value) {
        if (isFull(stackIndex))
            throw new StackOverflowError();
        this.sizes[stackIndex]++;
        int topIndex = getTopIndex(stackIndex);
        this.values[topIndex] = value;
    }

    public int pop(int stackIndex) {
        if (isEmpty(stackIndex))
            throw new NoSuchElementException();
        int topIndex = getTopIndex(stackIndex);
        int value = this.values[topIndex];
        this.values[topIndex] = 0;
        this.sizes[stackIndex]--;
        return value;
    }

    public int peek(int stackIndex) {
        if (isEmpty(stackIndex))
            throw new NoSuchElementException();
        return this.values[getTopIndex(stackIndex)];
    }

    public boolean isEmpty(int stackIndex) {
        return this.sizes[stackIndex] == 0;
    }

    public boolean isFull(int stackIndex) {
        return this.sizes[stackIndex] == this.capacity;
    }

    private int getTopIndex(int stackIndex) {
        int offset = stackIndex * this.capacity;
        return offset + this.sizes[stackIndex] - 1;
    }

    public static void main(String[] args) {
        FixedMultiStack fms = new FixedMultiStack(3);
        for (int i = 0; i < 3; i++) {
            System.out.println("Stack " + (i + 1) + " is " + (fms.isEmpty(i) ? "" : "not ") + "empty.");
            fms.push(i, i + 5);
            System.out.println("Stack " + (i + 1) + " is " + (fms.isEmpty(i) ? "" : "not ") + "empty.");
            fms.push(i, i + 10);
            fms.push(i, i + 15);
            System.out.println("Stack " + (i + 1) + " is " + (fms.isFull(i) ? "" : "not ") + "full.");
            System.out.println("Stack " + (i + 1) + " peek: " + fms.peek(i));
            System.out.println("Popped: " + fms.pop(i));
            System.out.println("Stack " + (i + 1) + " is " + (fms.isFull(i) ? "" : "not ") + "full.");
            System.out.println("Stack " + (i + 1) + " peek: " + fms.peek(i));
            System.out.println("Popped: " + fms.pop(i));
            System.out.println("Popped: " + fms.pop(i));
            System.out.println("Stack " + (i + 1) + " is " + (fms.isEmpty(i) ? "" : "not ") + "empty.");
        }
    }
}
