import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memorizeFib;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        memorizeFib = new long[number + 1];

        System.out.println(getFibonacci(number));

    }

    public static long getFibonacci (int n){

        if (n <= 1){
            return 1;
        }
        if (memorizeFib[n] != 0){
            return memorizeFib[n];
        }else {
            memorizeFib[n] = getFibonacci(n-1) + getFibonacci(n -2);
        }


        return getFibonacci(n-1) + getFibonacci(n -2);
    }
}
