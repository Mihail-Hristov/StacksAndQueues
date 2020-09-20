import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> checkPesticide = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> plants = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            plants.add(Integer.parseInt(input[i]));
        }

        int countDays = -1;

        boolean noDies = true;

        while (plants.size() > 0) {
            countDays++;

            int startFrom = plants.size() -1;

            for (int i = startFrom; i > 0; i--) {
                if (plants.get(i) > plants.get(i - 1)){
                    plants.remove(i);
                    noDies = false;
                }
            }

            if (noDies){
                break;
            }
            noDies = true;
        }

        System.out.println(countDays);


    }
}
