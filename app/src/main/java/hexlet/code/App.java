package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static final int GREET_OPTION = 1;
    private static final int EVEN_OPTION = 2;
    private static final int CALC_OPTION = 3;
    private static final int GCD_OPTION = 4;
    private static final int PROGRESSION_OPTION = 5;
    private static final int PRIME_OPTION = 6;

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
            case GREET_OPTION -> {
                welcome(choice);
                Cli.userName();
            }
            case EVEN_OPTION -> {
                welcome(choice);
                String username = Cli.userName();
                Even.evenGame(username);
            }
            case CALC_OPTION -> {
                welcome(choice);
                String username = Cli.userName();
                Calc.calcGame(username);
            }
            case GCD_OPTION -> {
                welcome(choice);
                String username = Cli.userName();
                Gcd.gcdGame(username);
            }
            case PROGRESSION_OPTION -> {
                welcome(choice);
                String username = Cli.userName();
                Progression.progressionGame(username);
            }
            case PRIME_OPTION -> {
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
