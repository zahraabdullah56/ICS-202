package labs.lab1;

public class test {
    public static void main(String[] args){
        Student[] students = new Student[10];
        for(int i = 0; i<10; i++){
            int flag = (int)(Math.random() * 2);
            if (flag == 0){
                students[i] = new Undergraduate((int)((Math.random() * 202100)+202300),(Math.random() * 4));}
            else{
                students[i] = new Graduate((int)((Math.random() * 202100)+202300),(Math.random() * 4));}
        }
        for (Student st: students){
            if(st instanceof Undergraduate){
                System.out.println("Undergraduate " + st.displayStudent());}
            else if (st instanceof Graduate){
                System.out.println("Graduate " + st.displayStudent());
            }
        }
    }
}
