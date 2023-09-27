package labs.lab4;

public class BalancedParentheses {

        public static boolean isBalanced(String expression) {
            LabStack<Character> stack = new LabStack<>();


            String parentheses = expression.replaceAll("[^\\[\\](){}]", "");

            for (char c : parentheses.toCharArray()) {
                if (c == '[' || c == '(' || c == '{') {
                    stack.push(c);
                } else if (c == ']' || c == ')' || c == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char opening = stack.pop();

                    if ((c == ']' && opening != '[') ||
                            (c == ')' && opening != '(') ||
                            (c == '}' && opening != '{')) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }

        //// main to test
        public static void main(String[] args) {
            String expression1 = "[3 + (2 - 4) + {(a - b)}]";
            String expression2 = "[3 + 2( and { 7 + [ a - b} ]";

            if (isBalanced(expression1)){
                System.out.println(expression1 + " is balanced: ");
            } else {System.out.println(expression1 + " is not balanced: ");}

            if (isBalanced(expression2)){
                System.out.println(expression2 + " is balanced: ");
            } else {System.out.println(expression2 + " is not balanced: ");}


        }
    }



