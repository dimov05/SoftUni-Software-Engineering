package ExerciseStacksandQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> robots = Arrays.stream(scanner.nextLine().split(";"))
                .collect(Collectors.toList());
        String[] names = new String[robots.size()];
        int[] processTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] current = robots.get(i).split("-");
            String name = current[0];
            names[i] = name;
            int timeToWork = Integer.parseInt(current[1]);
            processTime[i] = timeToWork;
        }

        String[] time = scanner.nextLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotWorkLeft = new int[robots.size()];
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String inputProduct;

        while (!"End".equals(inputProduct = scanner.nextLine())) {
            productsQueue.offer(inputProduct);
        }

        while (!productsQueue.isEmpty()) {
            beginSeconds++;
            String product = productsQueue.poll();
            int index = -1;

            for (int i = 0; i < robotWorkLeft.length; i++) {
                if (robotWorkLeft[i] > 0) {
                    robotWorkLeft[i]--;
                }
                if (robotWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotWorkLeft[index] = processTime[index];
                printRobotData(names[index], product, beginSeconds);
            } else {
                productsQueue.offer(product);
            }
        }
    }

    private static void printRobotData(String key, String detail, int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / (60 * 60)) % 24;
        System.out.println(key + " - " + detail +
                String.format(" [%02d:%02d:%02d]", h, m, s));
    }
}
