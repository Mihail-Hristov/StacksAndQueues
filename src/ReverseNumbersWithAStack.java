import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        int n = stack.size();
        for (int i = 0; i < n; i++) {
            if (i == 0){
                System.out.print(stack.pop());
            }else {
                System.out.print(" " + stack.pop());
            }
        }
    }
}
