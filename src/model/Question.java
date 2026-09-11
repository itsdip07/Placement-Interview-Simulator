package model;

public class Question {

    private String question;
    private String[] options;
    private String correctAnswer;
    private String difficulty;
    private int marks;
    private String category;

    public Question(
            String question,
            String[] options,
            String correctAnswer,
            String difficulty,
            int marks,
            String category) {

        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
        this.marks = marks;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getMarks() {
        return marks;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCorrect(String answer) {

        return answer.equalsIgnoreCase(correctAnswer);
    }

    public void displayQuestion(int number) {

        System.out.println();
        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.printf(
                "║ Question %-39d║%n",
                number
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.println(
                "║ Category   : " + category
        );

        System.out.println(
                "║ Difficulty : " + difficulty
        );

        System.out.println(
                "║ Marks      : " + marks
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.println();

        System.out.println(question);

        System.out.println();

        for (String option : options) {
            System.out.println(option);
        }
    }
}