import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BaisStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputtedCondition = scanner.nextLine().split("\\s+");

        int[] condition = new int[inputtedCondition.length];

        for (int i = 0; i < inputtedCondition.length; i++) {
            condition[i] = Integer.parseInt(inputtedCondition[i]);
        }

        int elementsToPush = condition[0];
        int elementsToPop = condition[1];
        int checkForElement = condition[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        boolean isContain = stack.contains(checkForElement);

        if (isContain){
            System.out.println("true");
        }else {
            if (stack.isEmpty()) {
                System.out.println("0");
            } else {
                int smallNumber = Integer.MAX_VALUE;
                int n = stack.size();
                for (int i = 0; i < n; i++) {
                    smallNumber = Math.min(smallNumber, stack.pop());
                }
                System.out.println(smallNumber);
            }
        }
    }
}
