package com.company;
import java.util.ArrayList;

public class LinkedList {
    public static ArrayList<Integer> foundIndices = new ArrayList<Integer>();
    private Node head;
    private int linkedListSize;

    public LinkedList() {
        head = null;
        linkedListSize = 0;
    }

    /**
     * @param o passed in to add a node at the start of linked list
     */
    public void addNodeStart(int o) {
        if(linkedListSize == 0) {
            head = new Node(o);
            return;
        }
        Node temp = new Node(o);
        temp.setNext(head);
        head = temp;
    }

    /**
     * @param o passed in to be added into a new node
     * @param position passed in to determine where to add new node
     */
    public void addNodeAny(int o, int position) {
        if(position == 0) {
            addNodeStart(o);
            linkedListSize++;
            return;
        }
        else if(position == linkedListSize) {
            addNodeEnd(o);
            linkedListSize++;
            return;
        }
        else if(position < 0 || position > linkedListSize) {
            System.out.println("Please choose a position within the boundaries of the linked list\n" +
                    "The current size of the linked list is " + this.getSize());
            return;
        }
        Node prev = head;
        for(int tracker = 0; tracker < position - 1; tracker++) {
            prev = prev.getNext();
        }
        Node newNode = new Node(o);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        linkedListSize++;
    }

    /**
     * @param o passed in to be added to the end of the linked list
     */
    public void addNodeEnd(int o) {
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        Node temp = new Node(o);
        current.setNext(temp);
    }

    /**
     * return void and deletes first node in list
     */
    public void deleteNodeStart() {
        head = head.getNext();
    }


    /**
     * @param position passed in to determine which node to delete
     */
    public void deleteNodeAny(int position) {
        if(isEmpty()) {
            //System.out.println("Linked List is already empty!");
        }
        if(position == 0) {
            deleteNodeStart();
            linkedListSize--;
            return;
        }
        else if(position == linkedListSize - 1) {
            deleteNodeEnd();
            linkedListSize--;
            return;
        }
        else if(position < 0 || position > linkedListSize - 1) {
            System.out.println("Please choose a position within the boundaries of the linked list\n" +
                    "The current size of the linked list is " + this.getSize());
            return;
        }
        Node prev = head;
        for(int tracker = 0; tracker < position - 1; tracker++) {
            prev = prev.getNext();
        }
        prev.setNext(prev.getNext().getNext());
        linkedListSize--;
    }

    /**
     * @return void and deletes the node at end of linked list
     */
    public void deleteNodeEnd() {
        Node current = head;
        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    /**
     * @param found passed in to see at which indices that data is in the node
     */
    public void findNodeByValue(int found) {
        System.out.print("The indices at which the data \"" + found + "\" is found are: ");

        int counter = 0;
        Node temp = head;
        while(counter < linkedListSize) {
            if(temp.getData() == found) {
                foundIndices.add(counter);
                System.out.print(counter + ", ");
            }
            temp = temp.getNext();
            counter++;
        }
        if(foundIndices.size() == 0) {
            System.out.println("The integer value \"" + found + "\" is not in the linked list!");
        }
        System.out.println();
    }

    /**
     * @return the size of the linked list currently
     */
    public int getSize() {
        return linkedListSize;
    }

    /**
     * @return boolean true if linked list is empty
     */
    public boolean isEmpty() {
        return linkedListSize == 0;
    }

    /**
     * @param o passed in to see if it's in a node
     * @return boolean true if linked list contains data o
     */
    public boolean contains(int o) {
        for(Node current = head; current.getNext() != null; current = current.getNext()) {
            if(current.getData() == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return boolean true if linked list is empty
     */
    public boolean clearList() {
        head = null;
        linkedListSize = 0;
        return true;
    }

    /**
     * @return no type but prints the existing linked list
     */
    public void displayList() {
        if(isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        Node current = head;
        while(current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
    }
}
