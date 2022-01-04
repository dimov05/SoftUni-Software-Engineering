package SetsAndMapsAdvanced;


import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Revision")) {
                break;
            }
            String[] input = command.split(", ");
            String shopName = input[0];
            String product = input[1];
            Double price = Double.parseDouble(input[2]);
            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(product, price);
        }
        shops.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((product, price) -> System.out.printf("Product: %s, Price: %.1f%n",
                    product, price));
        });
    }
}
