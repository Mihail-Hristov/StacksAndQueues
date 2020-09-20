import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperation = Integer.parseInt(scanner.nextLine());

        StringBuilder textForEditing = new StringBuilder();

        ArrayDeque<String> textHistory = new ArrayDeque<>();

        boolean lastCommandIs1or2 = false;

        for (int i = 0; i < numberOfOperation; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            int command = Integer.parseInt(token[0]);

            switch (command){
                case 1:
                    textHistory.push(String.valueOf(textForEditing));
                    String newText = token[1];
                    textForEditing.append(newText);

                    break;
                case 2:
                    textHistory.push(String.valueOf(textForEditing));
                    int countElementsForErases = Integer.parseInt(token[1]);
                    if (countElementsForErases <= textForEditing.length()) {
                        int stopAtIndex = textForEditing.length() - countElementsForErases;
                        for (int j = textForEditing.length() - 1; j >= stopAtIndex; j--) {
                            textForEditing.deleteCharAt(j);
                        }
                    }else {
                        System.out.println("Error");
                    }

                    break;
                case 3:
                    int indexForPrinting = Integer.parseInt(token[1]) - 1;
                    if (indexForPrinting >= 0 && indexForPrinting < textForEditing.length()) {
                        char charForPrint = textForEditing.charAt(indexForPrinting);
                        System.out.println(charForPrint);
                    }else {
                        System.out.println("Error");
                    }

                    break;
                case 4:
                    textForEditing = new StringBuilder();

                    textForEditing.append(textHistory.pop());

                    break;


            }

        }

    }
}
