import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String currentPage = "";

        while (!"Home".equals(input)) {
            switch (input){
                case "back":

                    if (browserHistory.size() < 1) {
                        System.out.println("no previous URLs");
                        input = scanner.nextLine();
                        continue;
                    }else {
                        forwardHistory.addFirst(currentPage);
                        currentPage = browserHistory.pop();
                    }
                    break;
                case "forward":

                    if (forwardHistory.isEmpty()) {
                        System.out.println("no next URLs");
                        input = scanner.nextLine();
                        continue;
                    } else {
                        browserHistory.push(currentPage);
                        currentPage = forwardHistory.poll();
                    }
                    break;
                default:

                    if (!currentPage.isEmpty()) {
                        browserHistory.push(currentPage);
                        forwardHistory.clear();
                    }
                    currentPage = input;
            }

            System.out.println(currentPage);

            input = scanner.nextLine();
        }

    }
}
