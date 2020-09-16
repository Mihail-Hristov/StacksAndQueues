import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputtedNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if (inputtedNumber == 0){
            System.out.println(0);
            return;
        }

        while (inputtedNumber > 0){
            binaryNumber.push(inputtedNumber % 2);
            inputtedNumber /= 2;
        }

        while (!binaryNumber.isEmpty()) {
            System.out.print(binaryNumber.pop());
        }
    }
}
