package labs.lab3;

//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
            return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
            head = new DLLNode<T>(el,head,null);
            head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
            tail = new DLLNode<T>(el,null,tail);
            tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }
    public void printAll() {
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
            return null;
        else return tmp.info;
    }

    public void printReverse() {
        if (tail == null) {
            System.out.println("The list is empty.");
            return;
        }

        DLLNode current = tail;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void delete7() {

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        boolean flag = false;
        DLLNode current = head;
        int count = 1;
        while (!isEmpty()){
            while (current != null) {
                if (count % 7 == 0) {
                    if (current.prev == null) {
                        head = current.next;
                        if (head != null) {
                            head.prev = null;
                        }
                    } else if (current.next == null) {
                        tail = current.prev;
                        if (tail != null) {
                            tail.next = null;
                        }
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }

                    System.out.println("Deleted element: " + current.info);
                    System.out.println("After deleting 7th element:");printAll();

                }

                if (current.next == null )
                    flag = true;
                else if (current.prev == null) { flag = false;
                }

                if ( flag ) {
                    current = current.prev;
                    count++;
                } else {
                    current = current.next;
                    count++;
                }


            }



        }}





    public void insertAlternate(DLL<T> newList) {
         // check if the lists have the same length
        if (size() != newList.size()) {
            System.out.println("The lengths of the lists are not the same.");
            return;
        }

        // iterate both lists
        DLLNode current1 = head;
        DLLNode current2 = newList.head;


        while (current1 != null && current2 != null) {
            DLLNode next1 = current1.next;
            DLLNode next2 = current2.next;

            current1.next = current2;
            current2.prev = current1;



            if (next1 != null) {
                current2.next = next1;
                next1.prev = current2;
            }

            current1 = next1;
            current2 = next2;
        }
    }



    // size method to calculate the length of the list
    public <T> int size() {

        int count = 0;
        for (DLLNode<T> current = (DLLNode<T>) head; current != null; current = current.next){
                count++;
            }
        return count;
    }








    }