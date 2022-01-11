package DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> vault = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }
            String output = "";

            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    vault.put(bankAccount.getId(), bankAccount);
                    output = String.format("Account ID%d created%n",
                            bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    if (vault.containsKey(id)) {
                        double amount = Double.parseDouble(tokens[2]);
                        vault.get(id).deposit(amount);
                        output = String.format("Deposited %.0f to ID%s%n",
                                amount, id);
                    } else {
                        output = String.format("Account does not exist%n");
                    }
                    break;
                case "SetInterest":
                    double interestToSet = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interestToSet);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    if (vault.containsKey(id)) {
                        int years = Integer.parseInt(tokens[2]);
                        double interest = vault.get(id).getInterest(years);
                        output = String.format("%.2f%n", interest);
                    } else {
                        output = String.format("Account does not exist%n");

                        break;
                    }
            }
            System.out.print(output);
        }
    }
}
