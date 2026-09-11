package service;

import model.Candidate;

public class ScoreService {

    // Maximum possible scores:
    //
    // Aptitude  = 55
    // Technical = 50
    // HR        = 20
    //
    // Total = 125

    private static final int MAX_SCORE = 125;

    public double getPercentage(
            Candidate candidate) {

        return (
                candidate.getTotalScore()
                        * 100.0
                        / MAX_SCORE
        );
    }

    public boolean isSelected(
            Candidate candidate) {

        double percentage =
                getPercentage(candidate);

        return percentage >= 60
                && candidate.getAptitudeScore() >= 30
                && candidate.getTechnicalScore() >= 30
                && candidate.getHrScore() >= 10;
    }

    public void displayReport(
            Candidate candidate) {

        double percentage =
                getPercentage(candidate);

        System.out.println();

        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║                 📊 FINAL REPORT                 ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.printf(
                "║ Candidate : %-38s║%n",
                candidate.getName()
        );

        System.out.printf(
                "║ Aptitude  : %-38d║%n",
                candidate.getAptitudeScore()
        );

        System.out.printf(
                "║ Technical : %-38d║%n",
                candidate.getTechnicalScore()
        );

        System.out.printf(
                "║ HR        : %-38d║%n",
                candidate.getHrScore()
        );

        System.out.printf(
                "║ Total     : %-38d║%n",
                candidate.getTotalScore()
        );

        System.out.printf(
                "║ Percentage: %-37.2f║%n",
                percentage
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        if (isSelected(candidate)) {

            System.out.println(
                    "║              🎉 SELECTED! 🎉                    ║"
            );

        } else {

            System.out.println(
                    "║              ❌ NOT SELECTED                    ║"
            );
        }

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }
}