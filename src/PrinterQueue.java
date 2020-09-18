import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> fileForPrinting = new ArrayDeque<>();

        while (!"print".equals(input)) {
            if ("cancel".equals(input)){
                if (fileForPrinting.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    String fileForDeleting = fileForPrinting.poll();
                    System.out.println(String.format("Canceled %s", fileForDeleting));
                }
            }else {
                fileForPrinting.offer(input);
            }

            input = scanner.nextLine();
        }

        while (!fileForPrinting.isEmpty()){
            String print = fileForPrinting.poll();
            System.out.println(print);
        }

    }
}
