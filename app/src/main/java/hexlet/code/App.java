package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "0 - Exit" +
                "\n- ");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch (choice) {
            case 1 -> {
                welcome(choice);
                Cli.userName();
            }
            case 2 -> {
                welcome(choice);
                String username = Cli.userName();
                Even.evenGame(username);
            }
            default -> {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void welcome(int choice) {
        System.out.println("Your choice: " + choice);
        System.out.println("Welcome to the Brain Games!");
    }
}
