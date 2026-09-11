package model;

public class Candidate {

    private String name;
    private String branch;
    private double cgpa;
    private String skills;

    private int aptitudeScore;
    private int technicalScore;
    private int hrScore;

    private boolean selected;

    public Candidate(
            String name,
            String branch,
            double cgpa,
            String skills) {

        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
        this.skills = skills;

        this.aptitudeScore = 0;
        this.technicalScore = 0;
        this.hrScore = 0;
        this.selected = false;
    }

    // ==============================
    // GETTERS
    // ==============================

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public int getAptitudeScore() {
        return aptitudeScore;
    }

    public int getTechnicalScore() {
        return technicalScore;
    }

    public int getHrScore() {
        return hrScore;
    }

    public boolean isSelected() {
        return selected;
    }

    // ==============================
    // SETTERS
    // ==============================

    public void setAptitudeScore(int aptitudeScore) {
        this.aptitudeScore = aptitudeScore;
    }

    public void setTechnicalScore(int technicalScore) {
        this.technicalScore = technicalScore;
    }

    public void setHrScore(int hrScore) {
        this.hrScore = hrScore;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    // ==============================
    // TOTAL SCORE
    // ==============================

    public int getTotalScore() {

        return aptitudeScore
                + technicalScore
                + hrScore;
    }

    // ==============================
    // DISPLAY PROFILE
    // ==============================

    public void displayProfile() {

        System.out.println();
        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║              👤 CANDIDATE PROFILE                ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.printf(
                "║ Name   : %-38s║%n",
                name
        );

        System.out.printf(
                "║ Branch : %-38s║%n",
                branch
        );

        System.out.printf(
                "║ CGPA   : %-38.2f║%n",
                cgpa
        );

        System.out.printf(
                "║ Skills : %-38s║%n",
                skills
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.println(
                "║                    SCORES                        ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.printf(
                "║ 🧠 Aptitude   : %-31d║%n",
                aptitudeScore
        );

        System.out.printf(
                "║ 💻 Technical  : %-31d║%n",
                technicalScore
        );

        System.out.printf(
                "║ 🗣️ HR          : %-31d║%n",
                hrScore
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.printf(
                "║ 📊 Total Score : %-30d║%n",
                getTotalScore()
        );

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }
}