package HWs.HW2;

public class SortedSLL<T extends Comparable<T>> extends SLL<T>{

    public void insert(T e){
        SLLNode<T> newNode = new SLLNode<>(e);

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            tail = newNode;

            return;
        }

        // If the inserted element is smaller than the head, insert it at the beginning
        if (e.compareTo(head.info) < 0) {
            newNode.next = head;
            head = newNode;

            return;
        }

        // Find the correct position to insert the new node
        SLLNode<T> current = head;
        while (current.next != null && e.compareTo(current.next.info) > 0) {
            current = current;
        }

        // Insert the new node after current
        newNode.next = current.next;
        current.next = newNode;

        // If inserted at the end, update tail reference
        if (newNode.next == null) {
            tail = newNode;
        }



    }
    public void merge(SortedSLL<T> list){
        SLLNode<T> current1 = head;
        SLLNode<T> current2 = list.head;

        // If either list is empty, return the other list
        if (current1 == null) {
            head = list.head;
            tail = list.tail;
            return;
        } else if (current2 == null) {
            return;
        }

        // Determine the new head of the merged list
        if (current1.info.compareTo(current2.info) <= 0) {
            head = current1;
            current1 = current1.next;
        } else {
            head = current2;
            current2 = current2.next;
        }

        SLLNode<T> current = head;

        // Traverse both lists and merge them
        while (current1 != null && current2 != null) {
            if (current1.info.compareTo(current2.info) <= 0) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes of list1, if any
        if (current1 != null) {
            current.next= current1;
        }

        // Append the remaining nodes of list2, if any
        if (current2 != null) {
            current.next = current2;
        }

        // Update the tail of the merged list
        tail = list.tail;

        // Clear the argument list
        list.head = null;
        list.tail = null;
    }
    public class testSS {



    }}


