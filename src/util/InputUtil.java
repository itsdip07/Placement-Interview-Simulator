package util;

import java.util.Scanner;

public class InputUtil {

    private Scanner scanner;

    public InputUtil(Scanner scanner) {

        this.scanner = scanner;
    }

    // =========================================
    // STRING
    // =========================================

    public String getString(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "❌ Input cannot be empty."
            );
        }
    }

    // =========================================
    // INTEGER
    // =========================================

    public int getInt(
            String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "❌ Please enter a valid number."
                );
            }
        }
    }

    // =========================================
    // INTEGER WITH RANGE
    // =========================================

    public int getInt(
            String message,
            int min,
            int max) {

        while (true) {

            int value =
                    getInt(message);

            if (value >= min
                    && value <= max) {

                return value;
            }

            System.out.println(
                    "❌ Enter a number between "
                            + min
                            + " and "
                            + max
            );
        }
    }

    // =========================================
    // DOUBLE
    // =========================================

    public double getDouble(
            String message,
            double min,
            double max) {

        while (true) {

            System.out.print(message);

            try {

                double value =
                        Double.parseDouble(
                                scanner.nextLine().trim()
                        );

                if (value >= min
                        && value <= max) {

                    return value;
                }

                System.out.println(
                        "❌ Enter a value between "
                                + min
                                + " and "
                                + max
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "❌ Please enter a valid number."
                );
            }
        }
    }

    // =========================================
    // MULTIPLE CHOICE
    // =========================================

    public String getOption() {

        while (true) {

            System.out.print(
                    "Your answer: "
            );

            String answer =
                    scanner.nextLine()
                            .trim()
                            .toUpperCase();

            if (answer.equals("A")
                    || answer.equals("B")
                    || answer.equals("C")
                    || answer.equals("D")) {

                return answer;
            }

            System.out.println(
                    "❌ Please enter A, B, C or D."
            );
        }
    }

    // =========================================
    // ENTER
    // =========================================

    public void waitForEnter() {

        System.out.println();

        System.out.print(
                "Press ENTER to continue..."
        );

        scanner.nextLine();
    }
}