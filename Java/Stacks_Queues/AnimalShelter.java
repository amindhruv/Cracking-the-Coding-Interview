package Stacks_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private int order;
    private Queue<Cat> cats;
    private Queue<Dog> dogs;

    AnimalShelter() {
        this.order = 0;
        this.cats = new LinkedList<>();
        this.dogs = new LinkedList<>();
    }

    public void enqueue(Animal a) {
        a.setOrder(this.order++);
        if (a instanceof Cat)
            this.cats.offer((Cat) a);
        else if (a instanceof Dog)
            this.dogs.offer((Dog) a);
    }

    public Animal dequeueAny() {
        if (this.cats.size() == 0)
            return dequeueDog();
        if (this.dogs.size() == 0)
            return dequeueCat();
        Cat c = this.cats.peek();
        Dog d = this.dogs.peek();
        if (c.isOlderThan(d))
            return dequeueCat();
        else
            return dequeueDog();
    }

    public Cat dequeueCat() {
        return this.cats.poll();
    }

    public Dog dequeueDog() {
        return this.dogs.poll();
    }

    abstract class Animal {
        private int order;
        protected String name;

        public int getOrder() { return order; }

        public void setOrder(int order) { this.order = order; }

        public Animal(String name) { this.name = name; }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    class Cat extends Animal {
        Cat(String name) { super(name); }
    }

    class Dog extends Animal {
        Dog(String name) { super(name); }
    }
}
