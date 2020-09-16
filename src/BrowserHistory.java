import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputtedCommand = scanner.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();

        String currentPage = "";

        while (!"Home".equals(inputtedCommand)){
            if ("back".equals(inputtedCommand)){
                if (history.size() <= 1) {
                    System.out.println("no previous URLs");
                    inputtedCommand = scanner.nextLine();
                    continue;
                }else {
                    currentPage = history.pop();
                }
            }else {
                history.push(currentPage);
                currentPage = inputtedCommand;
            }

            System.out.println(currentPage);

            inputtedCommand = scanner.nextLine();
        }

    }
}
