import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] childrenName = input.split("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : childrenName) {
            queue.offer(child);
        }

        int cycle = 1;

        while (queue.size() > 1){
            queue.offer(queue.poll());

            if (isPrime(cycle)){
                String primeChild = queue.peek();
                System.out.println(String.format("Prime %s", primeChild));
            }else {
                String removedChild = queue.poll();
                System.out.println(String.format("Removed %s", removedChild));
            }

            cycle ++;
        }

        String lastChild = queue.poll();

        System.out.println(String.format("Last is %s", lastChild));

    }

    public static boolean isPrime(int n){

        boolean primeCheck = true;

        if (n == 0 || n == 1){
            primeCheck = false;
            return primeCheck;
        }else {
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % 2 == 0){
                    primeCheck = false;
                }
            }

            return primeCheck;
        }

    }
}
