package labs.lab2;

public class test {
    public static void main(String[] args) throws Exception {
        SLL<Integer> myList1 = new SLL<Integer>();
        System.out.println("Original list: " + myList1);
        Integer[] numbers = {7, 5, 3, 50, 7, 9 };
        for(int i = 0; i < numbers.length; i++)
            myList1.addToTail(numbers[i]);

        System.out.println("Original list: " + myList1);
        myList1.insertBefore(4,20);
        System.out.println("After inserting 20 before index 4: " + myList1);
        System.out.println("Element deleted from index 4: " +myList1.delete(4));
        System.out.println( "After deleting element from index 4:  " +myList1);
        myList1.insertAfterSecondOccurrence(30,7);
        System.out.println("After inserting 30 after the second occurrence of 7: " +myList1 );
    }
}
