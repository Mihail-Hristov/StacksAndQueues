import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] nameOfTheKids = input.split("\\s+");

        ArrayDeque<String> children = new ArrayDeque<>();
        
        int n = Integer.parseInt(scanner.nextLine());

        for (String child : nameOfTheKids) {
            children.offer(child);
        }

        while (children.size() > 1){
            for (int i = 1; i < n; i++) {
                children.offer(children.poll());
            }
            String removedChild = children.poll();
            System.out.println(String.format("Removed %s", removedChild));
        }

        String lastChild = children.poll();
        System.out.println(String.format("Last is %s", lastChild));
    }
}
