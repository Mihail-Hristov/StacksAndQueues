import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsParameters = scanner.nextLine().split(";");

        String[] robots = new String[robotsParameters.length];
        int[] processTime = new int[robots.length];
        int[] workTime = new int[robots.length];
        ArrayDeque<String> products = new ArrayDeque<>();

        for (int i = 0; i < robotsParameters.length; i++) {
            String[] token = robotsParameters[i].split("-");
            String nameOfTheRobot = token[0];
            int processingTime = Integer.parseInt(token[1]);
            robots[i] = nameOfTheRobot;
            processTime[i] = processingTime;
        }

        String[] inputTime = scanner.nextLine().split(":");
        int startHour = Integer.parseInt(inputTime[0]);
        int startMinute = Integer.parseInt(inputTime[1]);
        int startSecond = Integer.parseInt(inputTime[2]);

        int startTime = (startHour * 3600) + (startMinute * 60) + startSecond;

        String product = scanner.nextLine();

        while (!"End".equals(product)) {
            products.offer(product);

            product = scanner.nextLine();
        }


        while (!products.isEmpty()) {
            startTime++;
            String currentProduct = products.poll();
            boolean isWorking = false;

            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isWorking){
                    workTime[i] = processTime[i];
                    isWorking = true;
                    int currentSecond = startTime % 60;
                    int currentMinute = (startTime / 60) % 60;
                    int currentHour = (startTime / (60 * 60)) % 24;
                    System.out.println(String.format("%s - %s [%02d:%02d:%02d]", robots[i], currentProduct, currentHour, currentMinute, currentSecond));
                }
                if (workTime[i] > 0){
                    workTime[i] --;
                }
            }

            if (!isWorking){
                products.offer(currentProduct);
            }
        }
    }
}
