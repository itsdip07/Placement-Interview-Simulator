package interview;

import model.Candidate;
import util.ConsoleUtil;
import util.InputUtil;

public class HRRound
        implements InterviewRound {

    private InputUtil input;

    public HRRound(
            InputUtil input) {

        this.input = input;
    }

    @Override
    public int conduct(
            Candidate candidate) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "🗣️ HR INTERVIEW"
        );

        Interviewer interviewer =
                new Interviewer(
                        "Ms. HR",
                        "Smiling while judging your entire life"
                );

        interviewer.introduce();

        String[] questions = {

                "Tell me about yourself.",

                "What is your biggest strength?",

                "What is your biggest weakness?",

                "Why should we hire you?",

                "Where do you see yourself in 5 years?"
        };

        int score = 0;

        for (int i = 0;
             i < questions.length;
             i++) {

            ConsoleUtil.clearScreen();

            ConsoleUtil.title(
                    "🗣️ HR INTERVIEW"
            );

            System.out.println();

            System.out.println(
                    "HR Question "
                            + (i + 1)
                            + "/"
                            + questions.length
            );

            System.out.println();

            System.out.println(
                    questions[i]
            );

            System.out.println();

            System.out.println(
                    "Choose your response:"
            );

            System.out.println();

            System.out.println(
                    "A. I am hardworking and willing to learn."
            );

            System.out.println(
                    "B. I solve problems and adapt quickly."
            );

            System.out.println(
                    "C. I mainly need the salary. 😂"
            );

            System.out.println(
                    "D. My parents told me to get a job."
            );

            String answer =
                    input.getOption();

            if (answer.equals("A")
                    || answer.equals("B")) {

                System.out.println();

                System.out.println(
                        "✅ HR liked that answer."
                );

                score += 4;

            } else if (answer.equals("C")) {

                System.out.println();

                System.out.println(
                        "😂 At least you're honest."
                );

                score += 2;

            } else {

                System.out.println();

                System.out.println(
                        "💀 HR is writing something..."
                );

                score += 1;
            }

            input.waitForEnter();
        }

        candidate.setHrScore(score);

        showResult(score);

        return score;
    }

    private void showResult(
            int score) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "🗣️ HR RESULT"
        );

        System.out.println();

        System.out.println(
                "HR Score: "
                        + score
                        + " / 20"
        );

        System.out.println();

        if (score >= 12) {

            System.out.println(
                    "STATUS: ✅ HR ROUND CLEARED"
            );

        } else {

            System.out.println(
                    "STATUS: ❌ HR ROUND FAILED"
            );

            System.out.println();

            System.out.println(
                    "Maybe don't say "
                            + "\"I just need money\" next time. 😂"
            );
        }

        input.waitForEnter();
    }
}