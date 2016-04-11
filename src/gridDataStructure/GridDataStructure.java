/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridDataStructure;

import java.util.Scanner;

/**
 *
 * @author keyur
 */
class Node {

    protected int value;
    protected Node next, below;

    /* Constructor */
    public Node() {
        next = null;
        below = null;
        value = 0;
    }
    /* Constructor */

    public Node(int d, Node n, Node p) {
        value = d;
        next = n;
        below = p;
    }
    /* Function to set link to next node */

    public void setLinkNext(Node n) {
        next = n;
    }
    /* Function to set link to previous node */

    public void setLinkPrev(Node p) {
        below = p;
    }
    /* Funtion to get link to next node */

    public Node getLinkNext() {
        return next;
    }
    /* Function to get link to previous node */

    public Node getLinkPrev() {
        return below;
    }
    /* Function to set value to node */

    public void setData(int d) {
        value = d;
    }
    /* Function to get value from node */

    public int getData() {
        return value;
    }
}

/* Class linkedList */
class linkedList {

    protected Node start;
    protected Node end;
    public int size;

    /* Constructor */
    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */

    public boolean isEmpty() {
        return start == null;
    }
    /* Function to get size of list */

    public int getSize() {
        return size;
    }
    /* Function to insert element at begining */

    public void insertAtStart(int val) {
        Node nptr = new Node(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }
    /* Function to insert element at end */

    public void insertAtEnd(int val) {
        Node nptr = new Node(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }
    /* Function to insert element at position */

    public void insertAtPos(int val, int pos) {
        Node nptr = new Node(val, null, null);
        if (pos == 1) {
            insertAtStart(val);
            return;
        }
        Node ptr = start;
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
//                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++;
    }
    /* Function to delete node at position */

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return;
        }
        if (pos == size) {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size--;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }
    /* Function to display status of list */

    public int searchNodes(Node root, int value) {

        Node current = root;
        int count = 0;
        if (current == null) {
            return 0;
        }
        System.out.println("current value->" + current.value);
        if (current.value == value) {
            return ++count;
        } else if (current.value < value) {
            count++;
            System.out.println("counting time::" + count + "\n");

        }
        if (current.next != null) {
            System.out.println("next value->" + current.next.value + "->");
            count = count + searchNodes(current.next, value);
            System.out.println("value::" + current.value + ",running next count::" + count + "\n");
        }
        if (current.below != null) {
            System.out.println("below value->" + current.below.value + "->");
            count = count + searchNodes(current.below, value);
            System.out.println("value::" + current.value + ",running below count::" + count + "\n");
        }
        System.out.println("value::" + current.value + ",count==" + count + "\n");

        while (current != null) {

            System.out.println("value->" + current.value + "->");

            if (current.value == value) {
                return count;
            } else {
                count++;
                if (current.next != null) {
                    System.out.println("next value->" + current.next.value + "->");
                    count = count + searchNodes(current.next, value);

////                    nextFlag = true;
                }

//        current = current.next;
//                System.out.println("current value->" + current.below + "->");
//                count = searchNodes(current.below, value);
//                current = current.next;
//            }
            }

//        return count;
//    	int index;
//        Node current = root;
//
//        int count = 0; /* index of Node we are
//         currently looking at */
//
//        boolean nextFlag = false;
//        boolean belowFlag = false;
//        System.out.println("current value->" + current.value);
//        if (current.value == value) {
//            return 1;
//        }
//        if (current.next == null && current.below == null) {
//            return 0;
//        }
//                if (current.below != null) {
//                    System.out.println("below value->" + current.below.value + "->");
//                    belowFlag = true;
//                }
//
//                if (nextFlag) {
//
//                    nextFlag = false;
//                    belowFlag = false;
//                }
//            if (count == value)
//                return current.value;
//            count++;
//        }
            
        }
        //
        return count;
    }
    public void display() {
        System.out.print("\nDoubly Linked List = ");
//        if (size == 0) {
//            System.out.print("empty\n");
//            return;
//        }
//        if (start.getLinkNext() == null) {
//            System.out.println(start.getData());
//            return;
//        }
        Node ptr = start;
        System.out.print(start.getData() + " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + "\n");
    }
}

/* Class DoublyLinkedList */
public class GridDataStructure {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        linkedList list = new linkedList();
        Node nptr = new Node(1, null, null);

        list.start = nptr;

        nptr = new Node(2, null, null);
        list.start.next = nptr;

        nptr = new Node(3, null, null);
        list.start.below = nptr;

        nptr = new Node(4, null, null);
        list.start.next.next = nptr;

        nptr = new Node(5, null, null);
        list.start.next.below = nptr;

        nptr = new Node(6, null, null);
        list.start.below.below = nptr;

        nptr = new Node(7, null, null);
        list.start.next.below.below = nptr;

        list.display();
        list.searchNodes(list.start, 6);

//        System.out.println("Doubly Linked List Test\n");
//        char ch;
//        /*  Perform list operations  */
//        do {
//            System.out.println("\nDoubly Linked List Operations\n");
//            System.out.println("1. insert at begining");
//            System.out.println("2. insert at end");
//            System.out.println("3. insert at position");
//            System.out.println("4. delete at position");
//            System.out.println("5. check empty");
//            System.out.println("6. get size");
//
//            int choice = scan.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter integer element to insert");
//                    list.insertAtStart(scan.nextInt());
//                    break;
//                case 2:
//                    System.out.println("Enter integer element to insert");
//                    list.insertAtEnd(scan.nextInt());
//                    break;
//                case 3:
//                    System.out.println("Enter integer element to insert");
//                    int num = scan.nextInt();
//                    System.out.println("Enter position");
//                    int pos = scan.nextInt();
//                    if (pos < 1 || pos > list.getSize()) {
//                        System.out.println("Invalid position\n");
//                    } else {
//                        list.insertAtPos(num, pos);
//                    }
//                    break;
//                case 4:
//                    System.out.println("Enter position");
//                    int p = scan.nextInt();
//                    if (p < 1 || p > list.getSize()) {
//                        System.out.println("Invalid position\n");
//                    } else {
//                        list.deleteAtPos(p);
//                    }
//                    break;
//                case 5:
//                    System.out.println("Empty status = " + list.isEmpty());
//                    break;
//                case 6:
//                    System.out.println("Size = " + list.getSize() + " \n");
//                    break;
//                default:
//                    System.out.println("Wrong Entry \n ");
//                    break;
//            }
//            /*  Display List  */
//            list.display();
//            System.out.println("\nDo you want to continue (Type y or n) \n");
//            ch = scan.next().charAt(0);
//
//        } while (ch == 'Y' || ch == 'y');
    }
}
