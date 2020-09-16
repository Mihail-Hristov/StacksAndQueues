import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] elements = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, elements);

        while (stack.size() > 1){
            int firstNumber = Integer.parseInt(stack.pop());
            String symbol = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            switch (symbol){
                case "+":
                    stack.push(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNumber - secondNumber));
                    break;
            }
        }

        System.out.println(stack.pop());

    }
}
