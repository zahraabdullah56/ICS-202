package labs.lab4;

public class Reverse {
    public static void main(String[] args) {
        LabStack<Integer> stack = new LabStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original stack: " + stack);

        LabStack<Integer> reversedStack = reverseStack(stack);

        System.out.println("Reversed stack: " + reversedStack);
    }

    public static LabStack<Integer> reverseStack(LabStack<Integer> stack) {
        LabQueue<Integer> queue = new LabQueue<>();

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        return stack;
    }
}
