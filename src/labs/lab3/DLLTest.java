package labs.lab3;

public class DLLTest {
    public static void main(String[] args) {
        DLL<Integer> test = new DLL<Integer>();


        for(int i = 0; i<10;i++){
        test.addToTail((int)(Math.random() * 10 ));}
        System.out.println("List 1:");
        test.printAll();
        System.out.println("List 1 reversed:");
        test.printReverse();


            DLL<Integer> list1 = new DLL<>();
            DLL<Integer> list2 = new DLL<>();

            list1.addToTail(1);
            list1.addToTail(2);
            list1.addToTail(3);
            list1.addToTail(4);


            list2.addToTail(5);
            list2.addToTail(6);
            list2.addToTail(7);
            list2.addToTail(8);

            System.out.println("List 1 before insertion:");
            list1.printAll();

            System.out.println("List 2 before insertion:");
            list2.printAll();

            // call the method
            list1.insertAlternate(list2);

            System.out.println("Lists after insertion:");
            list1.printAll();
        }}



