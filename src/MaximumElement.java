import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            String command = token[0];

            switch (command){
                case "1":
                    int elementToPush = Integer.parseInt(token[1]);
                    stack.push(elementToPush);

                    break;
                case "2":
                    stack.pop();

                    break;
                case "3":
                    int numberForPrint = Integer.MIN_VALUE;
                    int n = stack.size();
                    ArrayDeque<Integer> tempStack = new ArrayDeque<>();
                    for (int j = 0; j < n; j++) {
                        tempStack.addAll(stack);
                    }
                    for (int j = 0; j < n; j++) {
                        numberForPrint = Math.max(numberForPrint, tempStack.pop());
                    }
                    System.out.println(numberForPrint);

                    break;
            }

        }

    }
}
