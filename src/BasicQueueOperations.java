import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int numberOfElementsForAdding = Integer.parseInt(input[0]);
        int numberOfElementsForRemoving = Integer.parseInt(input[1]);
        int elementForCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < numberOfElementsForAdding; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numberOfElementsForRemoving; i++) {
            queue.poll();
        }

        boolean isContain = queue.contains(elementForCheck);

        if (isContain){
            System.out.println("true");
        }else {
            if (queue.isEmpty()){
                System.out.println(0);
            }else {
                int smallNumber = Integer.MAX_VALUE;
                while (!queue.isEmpty()) {
                    smallNumber = Math.min(smallNumber, queue.poll());
                }

                System.out.println(smallNumber);
            }
        }
    }
}
