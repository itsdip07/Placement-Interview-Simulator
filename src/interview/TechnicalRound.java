package interview;

import data.QuestionBank;
import model.Candidate;
import model.Question;
import util.ConsoleUtil;
import util.InputUtil;

import java.util.List;

public class TechnicalRound
        implements InterviewRound {

    private InputUtil input;

    public TechnicalRound(
            InputUtil input) {

        this.input = input;
    }

    @Override
    public int conduct(
            Candidate candidate) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "💻 TECHNICAL INTERVIEW"
        );

        Interviewer interviewer =
                new Interviewer(
                        "Mr. Java",
                        "Strict but slightly confused"
                );

        interviewer.introduce();

        QuestionBank bank =
                new QuestionBank();

        List<Question> questions =
                bank.getQuestionsByCategory(
                        "Java"
                );

        int numberOfQuestions =
                Math.min(
                        5,
                        questions.size()
                );

        questions =
                questions.subList(
                        0,
                        numberOfQuestions
                );

        int score = 0;

        int questionNumber = 1;

        for (Question question : questions) {

            ConsoleUtil.clearScreen();

            ConsoleUtil.title(
                    "💻 TECHNICAL INTERVIEW"
            );

            interviewer.introduce();

            question.displayQuestion(
                    questionNumber
            );

            String answer =
                    input.getOption();

            boolean correct =
                    question.isCorrect(answer);

            interviewer.react(correct);

            if (correct) {

                score += question.getMarks();
            }

            questionNumber++;

            input.waitForEnter();
        }

        candidate.setTechnicalScore(score);

        showResult(score);

        return score;
    }

    private void showResult(
            int score) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "💻 TECHNICAL RESULT"
        );

        System.out.println();

        System.out.println(
                "Technical Score: "
                        + score
                        + " / 50"
        );

        System.out.println();

        if (score >= 30) {

            System.out.println(
                    "STATUS: ✅ TECHNICAL ROUND CLEARED"
            );

        } else {

            System.out.println(
                    "STATUS: ❌ TECHNICAL ROUND FAILED"
            );

            System.out.println();

            System.out.println(
                    "The interviewer has politely "
                            + "closed your resume. 💀"
            );
        }

        input.waitForEnter();
    }
}