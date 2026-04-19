/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dessert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class manages a queue of desserts
 */
public class Dessertqueue {
    // Queue to store desserts
    private Queue<Dessert> queue;
    // Maximum number of desserts allowed
    private final int MAX_CAPACITY = 8;
    /**
     * Constructor – creates an empty queue
     */
    public Dessertqueue() {
        queue = new LinkedList<>();
    }
    // Adds a dessert to the queue
    public boolean addDessert(Dessert dessert) {
        if (isFull()) {
            return false;
        }
        queue.add(dessert);
        return true;
    }
    // Removes a dessert from the queue
    public Dessert removeDessert() {
        if (isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public Dessert peekDessert() {
        if (isEmpty()) {
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() >= MAX_CAPACITY;

    }

    public int size() {
        return queue.size();
    }
    /**
     * Displays all desserts in the queue
     */
    public String displayDessert() {
        if (isEmpty()) {
            return "No dessert in the fridge";
        }
        StringBuilder sb = new StringBuilder();
        for (Dessert dessert : queue) {
            sb.append(dessert).append("\n");
        }
        return sb.toString();
    }
}
