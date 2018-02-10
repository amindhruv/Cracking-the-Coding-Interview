package Stacks_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private int capacity;

    SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int value) {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack != null && lastStack.size() != this.capacity)
            lastStack.push(value);
        else {
            lastStack = new Stack<>();
            lastStack.push(value);
            this.stacks.add(lastStack);
        }
    }

    public int pop() {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null)
            throw new EmptyStackException();
        int value = lastStack.pop();
        if (lastStack.isEmpty())
            this.stacks.remove(this.stacks.size() - 1);
        return value;
    }

    private Stack<Integer> getLastStack() {
        if (this.stacks.size() == 0) return null;
        return this.stacks.get(this.stacks.size() - 1);
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(2);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(9);
        setOfStacks.push(0);
        setOfStacks.push(4);
        setOfStacks.push(8);
        while (!setOfStacks.isEmpty())
            System.out.print(setOfStacks.pop() + " ");
    }
}
