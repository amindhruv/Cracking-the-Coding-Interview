package Stacks_Queues;

import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> oldest, newest;

    QueueUsingStacks() {
        this.oldest = new Stack<>();
        this.newest = new Stack<>();
    }

    public void enqueue(T value) {
        this.newest.push(value);
    }

    public T dequeue() {
        shiftStacks();
        return this.oldest.pop();
    }

    public T peek() {
        shiftStacks();
        return this.oldest.peek();
    }

    private void shiftStacks() {
        if (this.oldest.isEmpty()) {
            while (!this.newest.isEmpty())
                this.oldest.push(this.newest.pop());
        }
    }

    public boolean isEmpty() {
        return oldest.isEmpty() && newest.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(2);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        queue.enqueue(9);
        queue.enqueue(0);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(8);
        while (!queue.isEmpty())
            System.out.print(queue.dequeue() + " ");
    }
}
