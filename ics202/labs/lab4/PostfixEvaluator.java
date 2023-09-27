package labs.lab4;

import java.util.Scanner;

public class PostfixEvaluator {
            //// main to test
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a postfix expression: ");
            String input = scanner.nextLine();

            if (isValidPostfixExpression(input)) {
                int result = evaluatePostfixExpression(input);
                System.out.println("Final result: " + result);
            } else {
                System.out.println("Invalid postfix expression");
            }

        }

        public static boolean isValidPostfixExpression(String expression) {
            String[] op = expression.split("\\s+");
            int NumCount = 0;
            int operatorCount = 0;

            for (String token : op) {
                if (isOperand(token)) {
                    NumCount++;
                } else if (isOperator(token)) {
                    operatorCount++;
                }
            }

            return NumCount == operatorCount + 1;
        }

        public static int evaluatePostfixExpression(String expression) {
            String[] tokens = expression.split("\\s+");
            LabStack<Integer> stack = new LabStack<>();

            for (String token : tokens) {
                if (isOperand(token)) {
                    stack.push(Integer.parseInt(token));
                } else if (isOperator(token)) {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    int result = performOperation(token, operand1, operand2);
                    stack.push(result);
                }

                System.out.println("Stack: " + stack);
            }

            return stack.pop();
        }

        public static boolean isOperand(String token) {
            try {
                Integer.parseInt(token);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public static boolean isOperator(String token) {
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
        }

        public static int performOperation(String operator, int operand1, int operand2) {
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
    }


