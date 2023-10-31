package labs.lab5;

//**************************  SLL.java  *********************************
//           a generic singly linked list class

public class SLL<T> {

    private class SLLNode<T> {
        private T info;
        private SLLNode<T> next;
        public SLLNode() {
            this(null,null);
        }
        public SLLNode(T el) {
            this(el,null);
        }
        public SLLNode(T el, SLLNode<T> ptr) {
            info = el; next = ptr;
        }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info;
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }


    @Override
   /* public String toString() {
        if(head == null)
            return "[ ]";
        String str = "[ ";
        SLLNode<T> tmp = head;
        while(tmp != null){
            str += tmp.info + " ";
            tmp = tmp.next;
        }
        return str+"]";
    }*/

    ///////the new
    public String toString() {
        return toStringRecursive(head);
    }

    private String toStringRecursive(SLLNode<T> node) {
        if (node == null) {
            return "[ ]";
        } else {
            return "[ " + node.info + " " + toStringRecursive(node.next) + "]";
        }
    }
    //////////////////

   /* public boolean contains(T el) {
        if(head == null)
            return false;

        SLLNode<T> tmp = head;
        while(tmp != null){
            if(tmp.info.equals(el))
                return true;
            tmp = tmp.next;
        }
        return false;
    }*/
    /////////// the new contain

    public boolean contains(T el) {
        return containsRecursive(head, el);
    }

    private boolean containsRecursive(SLLNode<T> node, T el) {
        if (node == null) {
            return false;
        } else if (node.info.equals(el)) {
            return true;
        } else {
            return containsRecursive(node.next, el);
        }
    }
    /////////////////
    public int size(){
        if(head == null)
            return 0;

        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
            count++;
            p = p.next;
        }

        return count;
    }
}