package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS;

public class Progression {
    private static final int PROGRESSION_LENGTH = 10;
    private static final int MAX_NUMBER_FOR_START = 11;
    private static final int MAX_NUMBER_FOR_STEP = 6;

    public static void progressionGame(String username) {
        RandomGenerator rnd = RandomGenerator.getDefault();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What number is missing in the progression?");

        for (int round = 1; round <= ROUNDS; round++) {
            int start = rnd.nextInt(1, MAX_NUMBER_FOR_START);
            int step = rnd.nextInt(2, MAX_NUMBER_FOR_STEP);
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
