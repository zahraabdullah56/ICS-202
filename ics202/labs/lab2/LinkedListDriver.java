package labs.lab2;
import java.util.LinkedList;

public class LinkedListDriver {
        public static void main(String[] args) {
            LinkedList<String> stringList = new LinkedList<>();

            stringList.add("Madinah");
            stringList.add("Dammam");
            stringList.add("Riyadh");
            stringList.add("Dhahraan");

            System.out.println("List: " + stringList);

            int index = stringList.indexOf("Riyadh");
            if(index == -1)
                System.out.println("Riyadh is not in the list");
            else{
                stringList.add(index + 1, "Jubail"); // insert Jubail after Riyadh
                stringList.addFirst("Najraan");   // insert Najraan at the beginning
            }

            System.out.println("List: " + stringList);

            index = stringList.indexOf("Dhahraan");
            if(index == -1)
                System.out.println("Dhahraan is not in the list");
            else
                stringList.set(index, "Abha");   // replace Dhahran with Abha

            String removedString = stringList. removeFirst();
            System.out.println("Removed Element: " + removedString);
            stringList.addFirst("Taif");
            System.out.println("Updated list: " + stringList);

            // Add code that will insert "Tabouk" before "Dammam", display error message if
            // "Dammam" is not in list or if the list is empty. Your code must work for any
            // two strings str1 and str2.
            String str1 = "Tabouk";
            String str2 = "Dammam";

            int indexStr2 = stringList.indexOf(str2);

            if (indexStr2 == -1 || stringList.isEmpty()) {
                System.out.println("Error: Either " + str2 + " is not in the list or the list is empty");
            } else {
                stringList.add(indexStr2, str1);
            }

            System.out.println("Updated list: " + stringList);





            // Add code that will insert "AlKhafj" before the last node, your code must work
            // for any non-empty list. Display an error message if the list is empty.
            String str3 = "AlKhafj";

            if (stringList.isEmpty()) {
                System.out.println("Error: The list is empty");
            } else {
                stringList.add(stringList.size() - 1, str3);
            }

            System.out.println("Updated list: " + stringList);




        }
    }

