package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit\
                -\s""");
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
            case 3 -> {
                welcome(choice);
                String username = Cli.userName();
                Calc.calcGame(username);
            }
            case 4 -> {
                welcome(choice);
                String username = Cli.userName();
                Gcd.gcdGame(username);
            }
            case 5 -> {
                welcome(choice);
                String username = Cli.userName();
                Progression.progressionGame(username);
            }
            case 6 -> {
                welcome(choice);
                String username = Cli.userName();
                Prime.primeGame(username);
            }
            default -> {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void welcome(int choice) {
        System.out.printf("Your choice: %s%n", choice);
        System.out.println("Welcome to the Brain Games!");
    }
}
