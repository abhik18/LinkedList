package com.company;

public class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
    public Node(Node a) {
        next = a;
    }

    /**
     * @return the data variable of the Node object
     */
    public int getData() {
        return data;
    }

    /**
     * @param data passed in as the new data for current Node object
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the Node object's next variable
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next to change the next Node in the linked list
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
