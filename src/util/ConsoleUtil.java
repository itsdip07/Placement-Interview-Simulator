package util;

public class ConsoleUtil {

    private ConsoleUtil() {
    }

    public static void clearScreen() {

        try {

            String os =
                    System.getProperty("os.name")
                            .toLowerCase();

            if (os.contains("windows")) {

                new ProcessBuilder(
                        "cmd",
                        "/c",
                        "cls"
                )
                        .inheritIO()
                        .start()
                        .waitFor();

            } else {

                System.out.print(
                        "\033[H\033[2J"
                );

                System.out.flush();
            }

        } catch (Exception e) {

            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
        }
    }

    public static void pause(
            java.util.Scanner scanner) {

        System.out.println();
        System.out.print(
                "Press ENTER to continue..."
        );

        scanner.nextLine();
    }

    public static void line() {

        System.out.println(
                "--------------------------------------------------"
        );
    }

    public static void title(
            String title) {

        System.out.println();

        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.printf(
                "║ %-48s ║%n",
                title
        );

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }
}