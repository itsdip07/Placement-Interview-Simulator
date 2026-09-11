package model;

public class InterviewResult {

    private int aptitudeScore;
    private int technicalScore;
    private int hrScore;

    private int totalScore;

    private boolean selected;

    private double packageOffered;

    public InterviewResult(
            int aptitudeScore,
            int technicalScore,
            int hrScore) {

        this.aptitudeScore = aptitudeScore;
        this.technicalScore = technicalScore;
        this.hrScore = hrScore;

        this.totalScore =
                aptitudeScore
                        + technicalScore
                        + hrScore;

        this.selected = false;
        this.packageOffered = 0;
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

    public int getTotalScore() {
        return totalScore;
    }

    public boolean isSelected() {
        return selected;
    }

    public double getPackageOffered() {
        return packageOffered;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPackageOffered(
            double packageOffered) {

        this.packageOffered = packageOffered;
    }
}