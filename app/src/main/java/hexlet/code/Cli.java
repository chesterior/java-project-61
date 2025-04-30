package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.ROUNDS;

public class Cli {
    public static String userName() {
        Scanner scanner = new Scanner(System.in);

        for (int attempt = 1; attempt <= ROUNDS; attempt++) {
            System.out.print("May I have your name?\n- ");
            String name = scanner.nextLine().trim();

            if (name.length() < 3) {
                System.out.println("Invalid name. Not smaller than 3 characters. Try again.");
            } else if (name.length() > 30) {
                System.out.println("Invalid name. Not more than 30 characters. Try again.");
            } else {
                System.out.printf("Hello, %s!\n", name);
                return name;
            }

            if (attempt < ROUNDS) {
                System.out.printf("Попробуйте ещё раз (%d/%d)%n", attempt + 1, ROUNDS);
            } else {
                System.out.println("Too many invalid attempts. Exiting program.");
                System.exit(1);
            }
        }
        return null;
    }
}
