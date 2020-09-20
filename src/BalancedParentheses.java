import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));

            if (currentChar.equals("{") || currentChar.equals("[") || currentChar.equals("(")){
                stack.push(currentChar);
            }else if (currentChar.equals("}") || currentChar.equals("]") || currentChar.equals(")")) {
                if (stack.isEmpty()){
                    areBalanced = false;
                    break;
                }
                String temp = stack.peek();

                switch (currentChar) {
                    case "}":
                        if (temp.equals("{")) {
                            stack.pop();
                            areBalanced = true;
                        }

                        break;
                    case "]":
                        if (temp.equals("[")) {
                            stack.pop();
                            areBalanced = true;
                        }
                        break;
                    case ")":
                        if (temp.equals("(")) {
                            stack.pop();
                            areBalanced = true;
                        }
                        break;
                }
            }
        }

        if (areBalanced && stack.isEmpty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
