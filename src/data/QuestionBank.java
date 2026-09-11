package data;

import model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> questions;

    public QuestionBank() {

        questions = new ArrayList<>();

        loadQuestions();
    }

    private void loadQuestions() {

        // =========================================
        // APTITUDE QUESTIONS
        // =========================================

        questions.add(new Question(
                "What is 20% of 250?",
                new String[]{
                        "A. 25",
                        "B. 40",
                        "C. 50",
                        "D. 60"
                },
                "C",
                "Easy",
                5,
                "Aptitude"
        ));

        questions.add(new Question(
                "What comes next? 2, 4, 8, 16, ?",
                new String[]{
                        "A. 20",
                        "B. 24",
                        "C. 32",
                        "D. 36"
                },
                "C",
                "Easy",
                5,
                "Aptitude"
        ));

        questions.add(new Question(
                "Which number is different?",
                new String[]{
                        "A. 2",
                        "B. 4",
                        "C. 8",
                        "D. 9"
                },
                "D",
                "Easy",
                5,
                "Aptitude"
        ));

        questions.add(new Question(
                "If 5 workers complete a job in 10 days, "
                        + "how many days will 10 workers take?",
                new String[]{
                        "A. 2",
                        "B. 5",
                        "C. 10",
                        "D. 20"
                },
                "B",
                "Easy",
                5,
                "Aptitude"
        ));

        questions.add(new Question(
                "A train travels 120 km in 2 hours. "
                        + "What is its average speed?",
                new String[]{
                        "A. 40 km/h",
                        "B. 50 km/h",
                        "C. 60 km/h",
                        "D. 80 km/h"
                },
                "C",
                "Medium",
                10,
                "Aptitude"
        ));

        questions.add(new Question(
                "If CAT is coded as DBU, how is DOG coded?",
                new String[]{
                        "A. EPH",
                        "B. EOG",
                        "C. FPH",
                        "D. DPH"
                },
                "A",
                "Medium",
                10,
                "Aptitude"
        ));

        questions.add(new Question(
                "A number is increased by 20% and then "
                        + "decreased by 20%. What is the net change?",
                new String[]{
                        "A. No change",
                        "B. 4% decrease",
                        "C. 4% increase",
                        "D. 2% decrease"
                },
                "B",
                "Hard",
                15,
                "Aptitude"
        ));

        // =========================================
        // JAVA TECHNICAL QUESTIONS
        // =========================================

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{
                        "A. implements",
                        "B. inherits",
                        "C. extends",
                        "D. super"
                },
                "C",
                "Easy",
                10,
                "Java"
        ));

        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{
                        "A. start()",
                        "B. main()",
                        "C. run()",
                        "D. execute()"
                },
                "B",
                "Easy",
                10,
                "Java"
        ));

        questions.add(new Question(
                "Which concept allows one interface to have "
                        + "multiple implementations?",
                new String[]{
                        "A. Polymorphism",
                        "B. Encapsulation",
                        "C. Compilation",
                        "D. Casting"
                },
                "A",
                "Medium",
                10,
                "Java"
        ));

        questions.add(new Question(
                "What is the difference between == and equals()?",
                new String[]{
                        "A. They are always identical",
                        "B. == generally compares references, "
                                + "equals() compares logical equality",
                        "C. equals() compares memory addresses",
                        "D. None of these"
                },
                "B",
                "Medium",
                10,
                "Java"
        ));

        questions.add(new Question(
                "Which collection does NOT allow duplicate elements?",
                new String[]{
                        "A. ArrayList",
                        "B. LinkedList",
                        "C. HashSet",
                        "D. Vector"
                },
                "C",
                "Medium",
                10,
                "Java"
        ));

        questions.add(new Question(
                "Which exception occurs when dividing an integer by zero?",
                new String[]{
                        "A. NullPointerException",
                        "B. ArithmeticException",
                        "C. IOException",
                        "D. ArrayIndexOutOfBoundsException"
                },
                "B",
                "Easy",
                10,
                "Java"
        ));

        questions.add(new Question(
                "Which keyword is used to create an object in Java?",
                new String[]{
                        "A. class",
                        "B. object",
                        "C. new",
                        "D. create"
                },
                "C",
                "Easy",
                10,
                "Java"
        ));

        questions.add(new Question(
                "Which OOP concept hides internal implementation details?",
                new String[]{
                        "A. Inheritance",
                        "B. Abstraction",
                        "C. Polymorphism",
                        "D. Compilation"
                },
                "B",
                "Medium",
                10,
                "Java"
        ));
    }

    // =========================================
    // ALL QUESTIONS
    // =========================================

    public List<Question> getAllQuestions() {

        return new ArrayList<>(questions);
    }

    // =========================================
    // RANDOM QUESTIONS
    // =========================================

    public List<Question> getRandomQuestions(
            int count) {

        List<Question> copy =
                new ArrayList<>(questions);

        Collections.shuffle(copy);

        if (count >= copy.size()) {
            return copy;
        }

        return new ArrayList<>(
                copy.subList(0, count)
        );
    }

    // =========================================
    // CATEGORY QUESTIONS
    // =========================================

    public List<Question> getQuestionsByCategory(
            String category) {

        List<Question> result =
                new ArrayList<>();

        for (Question question : questions) {

            if (question.getCategory()
                    .equalsIgnoreCase(category)) {

                result.add(question);
            }
        }

        Collections.shuffle(result);

        return result;
    }
}