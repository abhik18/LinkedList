package com.company;

import java.util.Scanner;

public class Main {

    final static String MENU = "\nSelect an option\n\n1. Add Node\n2. Delete Node\n3. Delete Node by Value\n" +
            "4. Delete List\n5. Display List\n6. Exit";
    final static String ADD = "What position do you want to add a node at?";
    final static String ADDDATA = "What integer value do you want to add: ";
    final static String DELETE = "What position do you want to delete a node at?";
    final static String DELETEVALUE = "What integer value do you want to delete?";
    final static String DELETEINDEX = "At which index would you like you to delete the value: ";

    public static void main(String[] args) {
        // write your code here

        LinkedList list = new LinkedList();
        Scanner in = new Scanner(System.in);
        int data, position;
        int choice = 0;

        System.out.println("Welcome to the linked list tool!");
        while(choice != 6) {
            System.out.println(MENU);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(ADDDATA);
                    data = in.nextInt();
                    System.out.println(ADD);
                    position = in.nextInt();
                    list.addNodeAny(data, position);
                    break;
                case 2:
                    if(list.isEmpty()) {
                        System.out.println("Linked list is already empty!");
                    }
                    System.out.println(DELETE);
                    position = in.nextInt();
                    list.deleteNodeAny(position);
                    break;
                case 3:
                    if(list.isEmpty()) {
                        System.out.println("Linked list is already empty!");
                    }
                    System.out.println(DELETEVALUE);
                    data = in.nextInt();
                    list.findNodeByValue(data);
                    System.out.println(DELETEINDEX);
                    position = in.nextInt();
                    while(!LinkedList.foundIndices.contains(position)) {
                        System.out.println("The value \"" + data + "\" is not at index " + position);
                        System.out.println(DELETEINDEX);
                        position = in.nextInt();
                    }
                    list.deleteNodeAny(position);
                    break;
                case 4:
                    if(list.clearList()) {
                        System.out.println("List Cleared!");
                    }
                    break;
                case 5:
                    list.displayList();
                    break;
                case 6:
                    System.out.println("Thanks for using the linked list tool!");
                    break;
            }
        }
    }
}
