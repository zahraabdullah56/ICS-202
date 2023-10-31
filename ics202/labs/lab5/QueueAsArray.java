package labs.lab5;

public class QueueAsArray<T> {
    private int front, rear, capacity;
    private T[] queue;

    public QueueAsArray(int capacity) {
        front = rear = -1;
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return rear == capacity - 1;
    }

    // function to insert an element at the rear of the queue
    public void enqueue(T data)  {
        if (isFull())
            throw new UnsupportedOperationException("Queue is full!");
        if(isEmpty())
            front++;

        rear++;
        queue[rear] = data;
    }


    /*public T dequeue() {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");
        T temp = queue[front];
        if (rear == 0) {
            rear = front = -1;
        }
        else{
            for(int i = 0; i <= rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        }
        return temp;
    }*/
    /////////// the new

    public T dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty!");
        }
        T temp = queue[front];
        if (rear == 0) {
            rear = front = -1;
        } else {
            dequeueRecursive(0);
            rear--;
        }
        return temp;
    }

    private void dequeueRecursive(int index) {
        if (index == rear) {
            queue[index] = null;
        } else {
            queue[index] = queue[index + 1];
            dequeueRecursive(index + 1);
        }
    }


    public boolean search(T e){
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        for(int i = 0; i <= rear; i++)
            if(e.equals(queue[i]))
                return true;

        return false;
    }

    public String toString()  {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        String str = "";
        for (int i = 0; i <= rear; i++) {
            str = str + queue[i] + "   ";
        }

        return str;
    }

    public  T peek() {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        return queue[front];
    }

    public static void main(String[] args) {
        QueueAsArray<Integer> queue = new QueueAsArray<>(5);
        queue.enqueue(60);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("The queue is: " + queue.toString());

        System.out.println("First dequeued element is: " + queue.dequeue());
        System.out.println("Second dequeued element is: " + queue.dequeue());

        System.out.println("After two node deletion the queue is: " + queue.toString());
        System.out.println("Element at queue front is: " + queue.peek());
    }
}
