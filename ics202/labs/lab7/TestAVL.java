package labs.lab7;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class TestAVL {
    public static void main(String[] args) throws FileNotFoundException {
        //Example which works with Left Rotation
        AVLTree<String> t = new AVLTree<String>();
        for(int i = 1; i <= 5; i++)
            t.insertAVL("a" + i);
        t.breadthFirst();
        System.out.println();

        System.out.println("Exercise 2");
        int[] values = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};
        AVLTree<Integer> p = new AVLTree<Integer>();
        for(int i:values){
            p.insertAVL(i);
        }
        p.breadthFirst();
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter 3 numbers to delete from the AVL Tree: ");
        p.deleteAVL(input.nextInt());
        p.deleteAVL(input.nextInt());
        p.deleteAVL(input.nextInt());

        p.breadthFirst();
        System.out.println();



        System.out.println("Exercise 3");
        //read the text file, insert unique words into the AVL tree and print its inorder traversal
        Scanner file = new Scanner(new File("/Users/zahraabdullah/IdeaProjects/ICS202/ics202/sampletextfile.txt"));
        AVLTree<String> s = new AVLTree<String>();
        while (file.hasNext()) {
            String data = file.next();
            if(!s.isInTree(data))
            s.insertAVL(data);
        }
        s.iterativeInorder();
        System.out.println();
    }
}