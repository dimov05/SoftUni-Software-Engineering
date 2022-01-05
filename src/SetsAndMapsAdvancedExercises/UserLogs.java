package SetsAndMapsAdvancedExercises;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> log = new TreeMap<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }
            String ip = command.substring(command.indexOf("=")+1, command.indexOf(" "));
            String user = command.substring(command.lastIndexOf("=") + 1);

            log.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> ipToCountInternMap = log.get(user);
            ipToCountInternMap.putIfAbsent(ip, 0);
            ipToCountInternMap.put(ip, ipToCountInternMap.get(ip) + 1);
        }

        log.forEach((key, value1) -> {
            System.out.println(key + ":");
            int count = 0;
            for (Map.Entry<String, Integer> secondMap : ((Map<String, Integer>) value1).entrySet()) {
                String format = (count++ == ((Map<String, Integer>) value1).size() - 1)
                        ? "%s => %d.%n" : "%s => %d, ";
                System.out.printf(format, secondMap.getKey(), secondMap.getValue());
            }

        });
    }
}
