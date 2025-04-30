package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Progression {
    public static void progressionGame(String username) {
        final int ROUNDS = 3;
        final int PROGRESSION_LENGTH = 10;
        RandomGenerator rnd = RandomGenerator.getDefault();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number is missing in the progression?");

        for (int round = 1; round <= ROUNDS; round++) {
            int start = rnd.nextInt(1, 11);      // начальное число 1–10
            int step = rnd.nextInt(2, 6);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < PROGRESSION_LENGTH; i++) {
                list.add(start + i * step);
            }

            int hiddenIndex = rnd.nextInt(PROGRESSION_LENGTH);
            int correctAnswer = list.get(hiddenIndex);

            List<String> displayList = new ArrayList<>();
            for (int i = 0; i < PROGRESSION_LENGTH; i++) {
                if (i == hiddenIndex) {
                    displayList.add("..");
                } else {
                    displayList.add(String.valueOf(list.get(i)));
                }
            }

            System.out.println("Question: " + String.join(" ", displayList));
            System.out.print("Your answer: ");
            String input = scanner.nextLine().trim();

            int userAnswer;
            try {
                userAnswer = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.printf(
                        "'%s' is not a valid number.%nLet's try again, %s!%n",
                        input, username
                );
                return;
            }

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.printf(
                        "'%s' is wrong answer ;(. Correct answer was '%d'.%n" +
                                "Let's try again, %s!%n",
                        input, correctAnswer, username
                );
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", username);
    }
}
