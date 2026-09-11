package interview;

import data.QuestionBank;
import model.Candidate;
import model.Question;
import util.ConsoleUtil;
import util.InputUtil;

import java.util.List;

public class AptitudeRound
        implements InterviewRound {

    private InputUtil input;

    public AptitudeRound(
            InputUtil input) {

        this.input = input;
    }

    @Override
    public int conduct(
            Candidate candidate) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "🧠 APTITUDE ROUND"
        );

        System.out.println();

        System.out.println(
                "Candidate: "
                        + candidate.getName()
        );

        System.out.println();

        System.out.println(
                "Rules:"
        );

        System.out.println(
                "• 5 random aptitude questions"
        );

        System.out.println(
                "• Difficulty affects marks"
        );

        System.out.println(
                "• No Google. 👀"
        );

        System.out.println();

        input.waitForEnter();

        QuestionBank bank =
                new QuestionBank();

        List<Question> aptitudeQuestions =
                bank.getQuestionsByCategory(
                        "Aptitude"
                );

        int numberOfQuestions =
                Math.min(
                        5,
                        aptitudeQuestions.size()
                );

        List<Question> questions =
                aptitudeQuestions.subList(
                        0,
                        numberOfQuestions
                );

        int score = 0;

        int questionNumber = 1;

        for (Question question : questions) {

            ConsoleUtil.clearScreen();

            question.displayQuestion(
                    questionNumber
            );

            String answer =
                    input.getOption();

            if (question.isCorrect(answer)) {

                System.out.println();
                System.out.println(
                        "✅ Correct!"
                );

                System.out.println(
                        "+" + question.getMarks()
                                + " marks"
                );

                score += question.getMarks();

            } else {

                System.out.println();
                System.out.println(
                        "❌ Wrong!"
                );

                System.out.println(
                        "Correct answer: "
                                + question.getCorrectAnswer()
                );
            }

            questionNumber++;

            input.waitForEnter();
        }

        candidate.setAptitudeScore(score);

        showResult(score);

        return score;
    }

    private void showResult(
            int score) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "📊 APTITUDE RESULT"
        );

        System.out.println();

        System.out.println(
                "Score: " + score + " / 55"
        );

        System.out.println();

        if (score >= 30) {

            System.out.println(
                    "STATUS: ✅ QUALIFIED"
            );

            System.out.println();

            System.out.println(
                    "🎉 You survived aptitude!"
            );

        } else {

            System.out.println(
                    "STATUS: ❌ FAILED"
            );

            System.out.println();

            System.out.println(
                    "Maybe the calculator was nervous. 😂"
            );
        }

        input.waitForEnter();
    }
}